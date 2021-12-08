package com.example.sigca.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.sigca.entity.Asistencia_Seminario;

public interface DTO2Repository extends JpaRepository<Asistencia_Seminario, Integer> {
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

}
