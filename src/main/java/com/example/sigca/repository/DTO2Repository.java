package com.example.sigca.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.sigca.entity.AsistenciaRecurso;
import com.example.sigca.entity.Asistencia_Seminario;
import com.example.sigca.entity.Programacion;

public interface DTO2Repository extends JpaRepository<Asistencia_Seminario, Integer> {
	@Query(value = "Select tr.NO_RECURSO RECURSO , ASISTENCIA(rs.ES_ASISTENCIA) Asistencia, VALORACION(rs.NU_VALORACION) Valoracion from tbl_asistencia_recurso rs join tbl_recurso tr on rs.FK_RECURSO =tr.ID_RECURSO join tbl_sesion s on tr.FK_SESION=s.ID_SESION join tbl_socio ts ON ts.ID_PERSONA =rs.FK_SOCIO where ts.ID_PERSONA=? and s.ID_SESION=?;", nativeQuery = true)
	List<Map<String,Object>> listarSocioRecursos(int idsocio,int idsesion);
	
	@Query(value= "select tar.ID_ASISTENCIA_RECURSO, tr.NO_RECURSO, tr.DESC_RECURSO, tar.ES_ASISTENCIA  from tbl_asistencia_recurso tar join tbl_recurso tr on tr.ID_RECURSO =tar.FK_RECURSO  where tr.FK_SESION=? and tar.FK_SOCIO=?;", nativeQuery = true)
	List<Map<String,Object>> listarRecursoSesion(int idsesion, int idsocio);

	
}
