package com.example.sigca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sigca.entity.Recurso;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Integer> {

			// Listar
			@Query(value = "{ CALL SP_LISTAR_RECURSO}", nativeQuery = true)
			List<Recurso> listarRecurso();
			
			// Buscar
			@Query(value = "{ CALL SP_LISTAR_RECURSO(:p_nID_RECURSO) }", nativeQuery = true)
			Optional<Recurso> buscarRecurso(@Param("p_nID_RECURSO") int p_nID_RECURSO);
			
			// Delete
			@Query(value = "{ CALL SP_ELIMINAR_RECURSO(:p_nID_RECURSO) }", nativeQuery = true)
			String eliminarRecurso(@Param("p_nID_RECURSO") int p_nID_RECURSO);
			
			// Insertar
			@Query(value = "{call SP_INS_RECURSO(:p_vNO_RECURSO, :p_nSE_ORDEN, :p_vDESC_RECURSO, :p_nFK_SESION, :p_nFK_TIPO)}", nativeQuery = true) 
			String insertarRecurso(@Param("p_vNO_RECURSO") String p_vNO_RECURSO, @Param("p_nSE_ORDEN") int p_nSE_ORDEN, @Param("p_vDESC_RECURSO") String p_vDESC_RECURSO, @Param("p_nFK_SESION") int p_nFK_SESION, @Param("p_nFK_TIPO") int p_nFK_TIPO);
			
			//Actualizar
			@Query(value = "{call SP_UPD_RECURSO(:p_nID_RECURSO, :p_vNO_RECURSO, :p_nSE_ORDEN, :p_vDESC_RECURSO, :p_nFK_SESION, :p_nFK_TIPO)}", nativeQuery = true) 
			String actualizarRecurso(@Param("p_nID_RECURSO") int p_nID_RECURSO ,@Param("p_vNO_RECURSO") String p_vNO_RECURSO, @Param("p_nSE_ORDEN") int p_nSE_ORDEN, @Param("p_vDESC_RECURSO") String p_vDESC_RECURSO, @Param("p_nFK_SESION") int p_nFK_SESION, @Param("p_nFK_TIPO") int p_nFK_TIPO);
			
}
