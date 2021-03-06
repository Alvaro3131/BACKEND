package com.example.sigca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.sigca.entity.AsistenciaRecurso;
import com.example.sigca.entity.Modulo;

public interface AsistenciaRecursoRepository extends JpaRepository<AsistenciaRecurso, Integer>{
	
	// Listar	
	@Query(value = "{ CALL SP_LISTAR_ASISTENCIA_RECURSO(0) }", nativeQuery = true)
	List<AsistenciaRecurso> listarAsistenciaRecurso();
			
	// Buscar
	@Query(value = "{call SP_LISTAR_ASISTENCIA_RECURSO(:p_nIDASISTENCIARECURSO)}", nativeQuery = true) 
	AsistenciaRecurso buscarAsistenciaRecurso(@Param("p_nIDASISTENCIARECURSO") int p_nIDASISTENCIARECURSO);
			
	//Delete
	@Query(value = "{ CALL SP_ELIMINAR_ASISTENCIA_RECURSO(:P_nIDRec) }", nativeQuery = true)
	String eliminarAsistenciaRecurso(@Param("P_nIDRec") int P_nIDRec);
			
	// Insertar
	@Query(value = "{call SP_INS_ASISTENCIA_RECURSO(:p_nEstado,:p_nValoracion,:p_nIdSocio,:p_nIdRecurso)}", nativeQuery = true) 
	String insertarAsistenciaRecurso(@Param("p_nEstado") int p_nEstado, @Param("p_nValoracion") int p_nValoracion,@Param("p_nIdSocio") int p_nIdSocio,@Param("p_nIdRecurso") int p_nIdRecurso );
			
	//Update
	@Query(value = "{call SP_UPD_ASISTENCIA_RECURSO(:p_nId,:p_nEstado,:p_nValoracion,:p_nIdSocio,:p_nIdRecurso)}", nativeQuery = true) 
	String actualizarAsistenciaRecurso(@Param("p_nId") int p_nId ,@Param("p_nEstado") int p_nEstado,@Param("p_nValoracion") int p_nValoracion, @Param("p_nIdSocio") int p_nIdSocio, @Param("p_nIdRecurso") int p_nIdRecurso);
	
	//Update
	@Query(value = "{call SP_UDP_ES_ASISTENCIA(:p_nID)}", nativeQuery = true) 
	String actualizarEstadoAsistencia(@Param("p_nID") int p_nID);
	
	
	//UpdateValoracion
	@Query(value = "{call SP_UPD_VAL_RECURSO(:p_nId,:p_nValoracion)}", nativeQuery = true) 
	String actualizarValoracionRecurso(@Param("p_nId") int p_nId, @Param("p_nValoracion") int p_nValoracion);
	
	@Query(value = "update tbl_asistencia_recurso set nu_valoracion=valoracion where fk_socio=p_nFK_SOCIO and FK_RECURSO =p_nFK_RECURSO;", nativeQuery = true)
	List<AsistenciaRecurso> valorarRecurso(@Param("valoracion") int p_nValoracion ,@Param("p_nFK_SOCIO") int p_nFK_SOCIO
			,	@Param("p_nFK_RECURSO") int p_nFK_RECURSO);
}
