package com.example.sigca.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.sigca.entity.Asistencia_Seminario;

public interface DTO2Repository extends JpaRepository<Asistencia_Seminario, Integer> {
	@Query(value = "Select tr.NO_RECURSO RECURSO , ASISTENCIA(rs.ES_ASISTENCIA) Asistencia, VALORACION(rs.NU_VALORACION) Valoracion from tbl_asistencia_recurso rs join tbl_recurso tr on rs.FK_RECURSO =tr.ID_RECURSO join tbl_sesion s on tr.FK_SESION=s.ID_SESION join tbl_socio ts ON ts.ID_PERSONA =rs.FK_SOCIO where ts.ID_PERSONA=? and s.ID_SESION=?;", nativeQuery = true)
	List<Map<String,Object>> listarSocioRecursos(int idsocio,int idsesion);
}