package com.example.sigca.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.sigca.entity.AsistenciaSeminario;

public interface DTO2Repository extends JpaRepository<AsistenciaSeminario, Integer> {
	@Query(value = "Select tr.NO_RECURSO RECURSO , ASISTENCIA(rs.ES_ASISTENCIA) Asistencia, VALORACION(rs.NU_VALORACION) Valoracion from tbl_asistencia_recurso rs join tbl_recurso tr on rs.FK_RECURSO =tr.ID_RECURSO join tbl_sesion s on tr.FK_SESION=s.ID_SESION join tbl_socio ts ON ts.ID_PERSONA =rs.FK_SOCIO where ts.ID_PERSONA=? and s.ID_SESION=?;", nativeQuery = true)
	List<Map<String,Object>> listarSocioRecursos(int idsocio,int idsesion);
	

	@Query(value = "select concat(tp.NO_PERSONA,' ', tp.AP_PATERNO, ' ', tp.AP_MATERNO) Persona, ts.ID_PERSONA from tbl_socio ts join tbl_persona tp on ts.ID_PERSONA=tp.ID_PERSONA where FK_BANCOCOMUNAL=?;", nativeQuery = true)
	List<Map<String,Object>> listarSocioBanco(int idbanco);
	
	@Query(value = "select round((RECURSOS_VISTOS(m.id_modulo,bc.id_bancocomunal)*100)/(TOTAL_RECURSO(m.id_modulo)*PERSONAS_BANCO(bc.id_bancocomunal))) AS 'PROGRESO',TOTAL_RECURSO(m.id_modulo) as 'RECURSOS',RECURSOS_VISTOS(m.id_modulo,bc.id_bancocomunal)  as 'VISTOS', TOTAL_RECURSO(m.id_modulo)*PERSONAS_BANCO(bc.id_bancocomunal)as 'TOTALRECURSOS' , PERSONAS_BANCO(bc.id_bancocomunal) AS 'PERSONA',bc.ID_BANCOCOMUNAL as  'IDBANCO' , bc.no_bancocomunal AS 'BANCO',m.ID_MODULO as 'IDMODULO',m.no_modulo as 'MODULO' from tbl_asistencia_recurso  ar  join tbl_socio s on ar.fk_socio=s.id_persona join tbl_bancocomunal bc on s.fk_bancocomunal =bc.id_bancocomunal join tbl_programacion p on bc.id_bancocomunal=p.fk_bancocomunal join tbl_modulo m on p.fk_modulo = m.id_modulo join tbl_distrito tbd on bc.FK_DISTRITO=tbd.ID_DISTRITO where ar.es_asistencia = 1 and tbd.ID_DISTRITO=? group by BANCO, MODULO;", nativeQuery = true)
	List<Map<String,Object>> desarrollomoduloDistrito(int iddistrito);
	
	@Query(value = "select round((RECURSOS_VISTOS(m.id_modulo,bc.id_bancocomunal)*100)/(TOTAL_RECURSO(m.id_modulo)*PERSONAS_BANCO(bc.id_bancocomunal))) AS 'PROGRESO',TOTAL_RECURSO(m.id_modulo) as 'RECURSOS',RECURSOS_VISTOS(m.id_modulo,bc.id_bancocomunal)  as 'VISTOS', TOTAL_RECURSO(m.id_modulo)*PERSONAS_BANCO(bc.id_bancocomunal)as 'TOTALRECURSOS' , PERSONAS_BANCO(bc.id_bancocomunal) AS 'PERSONA',bc.ID_BANCOCOMUNAL as  'IDBANCO' , bc.no_bancocomunal AS 'BANCO',m.ID_MODULO as 'IDMODULO',m.no_modulo as 'MODULO' from tbl_asistencia_recurso  ar  join tbl_socio s on ar.fk_socio=s.id_persona join tbl_bancocomunal bc on s.fk_bancocomunal =bc.id_bancocomunal join tbl_programacion p on bc.id_bancocomunal=p.fk_bancocomunal join tbl_modulo m on p.fk_modulo = m.id_modulo  where ar.es_asistencia = 1 and bc.ID_BANCOCOMUNAL=? group by BANCO, MODULO;", nativeQuery = true)
	List<Map<String,Object>> desarrollomoduloBanco(int idbanco);
	
	
	

	@Query(value= "select tar.ID_ASISTENCIA_RECURSO, tr.NO_RECURSO, tr.DESC_RECURSO  from tbl_asistencia_recurso tar join tbl_recurso tr on tr.ID_RECURSO =tar.FK_RECURSO  where tr.FK_SESION=? and tar.FK_SOCIO=?;", nativeQuery = true)
	List<Map<String,Object>> listarRecursoSesion(int idsesion, int idsocio);
	
	
	@Query(value= "select Sum(A.ES_ASISTENCIA)/PERSONAS_BANCO(tb.id_bancocomunal)*100 as Progreso ,Sum(A.ES_ASISTENCIA) Vistos,PERSONAS_BANCO(tb.id_bancocomunal) as Personas,tb.NO_BANCOCOMUNAL BANCO,td.NO_DISTRITO   from TBL_ASISTENCIA_SEMINARIO A join TBL_SEMINARIO S on A.FK_SEMINARIO=S.ID_SEMINARIO join  tbl_socio ts on ts.id_persona=A.fk_socio join  tbl_BANCOCOMUNAL tb on  tb.id_bancocomunal=ts.fk_bancocomunal join tbl_distrito td on tb.FK_DISTRITO=td.ID_DISTRITO where td.ID_DISTRITO =? and S.ID_SEMINARIO=? group by BANCO;", nativeQuery = true)
	List<Map<String,Object>> listarseminario(int iddistrito, int idseminario);
	
	
	@Query(value= "SELECT CONCAT(P.NO_PERSONA,' ', P.AP_PATERNO,' ', P.AP_MATERNO)SOCIO, ts.NO_SEMINARIO, A.DE_ASISTENCIA, A.FE_ASISTENCIA, A.ES_ASISTENCIA , A.NU_VALORACION FROM TBL_ASISTENCIA_SEMINARIO A JOIN TBL_SOCIO B ON A.FK_SOCIO=B.ID_PERSONA JOIN TBL_PERSONA P ON P.ID_PERSONA=B.ID_PERSONA JOIN TBL_BANCOCOMUNAL BC ON BC.ID_BANCOCOMUNAL= B.FK_BANCOCOMUNAL join tbl_seminario ts on A.FK_SEMINARIO=ts.ID_SEMINARIO WHERE ID_BANCOCOMUNAL= ? AND ts.ID_SEMINARIO=?;", nativeQuery = true)
	List<Map<String,Object>> listarseminariobanco(int idbanco, int idseminario);

}
