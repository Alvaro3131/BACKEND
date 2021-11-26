package com.example.sigca.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.sigca.entity.AsistenciaRecurso;
import com.example.sigca.entity.Persona;


@Repository
public interface DtoRepository extends JpaRepository<AsistenciaRecurso, String> {
	
	@Query(value = "Select concat(tp.NO_PERSONA,' ',tp.AP_PATERNO ) PERSONA,tp.NO_CORREO CORREO,s.NO_SESION SESION, concat(SUM(rs.ES_ASISTENCIA),'/' ,s.NU_Recursos  ) Asistencia from tbl_asistencia_recurso rs join tbl_recurso r on rs.fk_recurso=r.id_recurso join tbl_sesion s  on r.FK_SESION=s.ID_SESION join tbl_socio ts on rs.FK_SOCIO=ts.ID_PERSONA join tbl_persona tp on ts.ID_PERSONA=tp.ID_PERSONA  join tbl_modulo tbm on s.FK_MODULO=tbm.ID_MODULO join tbl_bancocomunal tba on ts.FK_BANCOCOMUNAL=tba.ID_BANCOCOMUNAL  WHERE  tba.ID_BANCOCOMUNAL=?1 and tbm.ID_MODULO=?2  GROUP BY PERSONA, SESION ORDER BY SESION;", nativeQuery = true)
	List<Map<String,Object>> listarParticipacionSesiones(int bancocomunal,int modulo);
	
	@Query(value = "select concat(tp.NO_PERSONA,' ',tp.AP_PATERNO) SOCIO , tp.NO_CORREO CORREO,tr.NO_RECURSO RECURSO, concat(ASISTENCIA(tar.ES_ASISTENCIA),' - ',VALORACION(tar.NU_VALORACION)) ASISTENCIA from tbl_asistencia_recurso tar join tbl_socio ts on tar.FK_SOCIO =ts.ID_PERSONA join tbl_persona tp on ts.ID_PERSONA=tp.ID_PERSONA join tbl_recurso tr on tr.ID_RECURSO =tar.FK_RECURSO join tbl_sesion tse on tse.ID_SESION =tr.FK_SESION join tbl_bancocomunal tb on ts.FK_BANCOCOMUNAL=tb.ID_BANCOCOMUNAL where tse.ID_SESION=? and tb.ID_BANCOCOMUNAL=? ;", nativeQuery = true)
	List<Map<String,Object>> participacionRecursoSocio(int idsesion,int idmodulo);
	
	@Query(value = "Select tp.ID_PERSONA ID,concat(tp.NO_PERSONA,' ',tp.AP_PATERNO ) PERSONA,tp.NO_CORREO CORREO,s.NO_SESION SESION, concat(SUM(rs.ES_ASISTENCIA),'/' ,s.NU_Recursos  ) Asistencia from tbl_asistencia_recurso rs join tbl_recurso r on rs.fk_recurso=r.id_recurso join tbl_sesion s  on r.FK_SESION=s.ID_SESION join tbl_socio ts on rs.FK_SOCIO=ts.ID_PERSONA join tbl_persona tp on ts.ID_PERSONA=tp.ID_PERSONA  join tbl_modulo tbm on s.FK_MODULO=tbm.ID_MODULO join tbl_bancocomunal tba on ts.FK_BANCOCOMUNAL=tba.ID_BANCOCOMUNAL  WHERE  tba.ID_BANCOCOMUNAL=?1 and tbm.ID_MODULO=?2 and s.ID_SESION =?3 GROUP BY PERSONA, SESION;", nativeQuery = true)
	List<Map<String,Object>> listarSocioSesiones(int bancocomunal,int modulo, int sesion);
	
	@Query(value = "{ CALL ido_bi_capa.SP_MASIVO(:p_modulo,:p_bancos) }", nativeQuery = true) 
	String insertarMasico(@Param("p_modulo") String p_modulo, @Param("p_bancos") String p_bancos);
	
	@Query(value = "select tpe.NO_PERSONA NOMBRE , tpe.AP_PATERNO  PATERNO, tpe.AP_MATERNO MATERNO,tpe.NU_TELEFONO TELEFONO, tpe.CO_DNI DNI,tpe.NO_CORREO CORREO from tbl_programacion tp join tbl_bancocomunal tb on tp.FK_BANCOCOMUNAL=tb.ID_BANCOCOMUNAL join tbl_socio ts  on ts.FK_BANCOCOMUNAL=tb.ID_BANCOCOMUNAL join tbl_persona tpe on ts.ID_PERSONA =tpe.ID_PERSONA join tbl_modulo tm on tp.FK_MODULO =tm.ID_MODULO where tb.ID_BANCOCOMUNAL =?1 and tm.ID_MODULO=?2 ;", nativeQuery = true)
	List<Map<String,Object>> listarParticipantes(int bancocomunal,int modulo);
	
	@Query(value = "select round((count(*)*100)/(TOTAL_RECURSO(m.id_modulo)*PERSONAS_BANCO(bc.id_bancocomunal))) AS 'PROGRESO',TOTAL_RECURSO(m.id_modulo) as 'RECURSOS',count(*)  as 'VISTOS',TOTAL_RECURSO(m.id_modulo)*PERSONAS_BANCO(bc.id_bancocomunal)as 'TOTALRECURSOS' ,PERSONAS_BANCO(bc.id_bancocomunal) AS 'PERSONA',bc.ID_BANCOCOMUNAL as  'IDBANCO' ,bc.no_bancocomunal AS 'BANCO',m.ID_MODULO as 'IDMODULO',m.no_modulo as 'MODULO' from tbl_asistencia_recurso ar  join tbl_socio s on ar.fk_socio=s.id_persona join tbl_bancocomunal bc on s.fk_bancocomunal =bc.id_bancocomunal join tbl_programacion p on bc.id_bancocomunal=p.fk_bancocomunal join tbl_modulo m on p.fk_modulo = m.id_modulo join tbl_asesor ta on bc.FK_ASESOR=ta.ID_PERSONA where ar.es_asistencia = 1 and ta.ID_PERSONA=?1 group by BANCO, MODULO;", nativeQuery = true)
	List<Map<String,Object>> listarProgramasAsesor(int id);
	
}
