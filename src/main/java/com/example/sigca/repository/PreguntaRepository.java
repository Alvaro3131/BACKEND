package com.example.sigca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sigca.entity.Pregunta;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {

	// Listar
		@Query(value = "{ CALL SP_LISTAR_TBL_PREGUNTA }", nativeQuery = true)
		List<Pregunta> listarPregunta();
		
		// Buscar
		@Query(value = "{ CALL SP_LISTAR_TBL_PREGUNTA(:p_nID) }", nativeQuery = true)
		Optional<Pregunta> buscarPregunta(@Param("p_nID") int p_nID);
		
		// Delete
		@Query(value = "{ CALL SP_ELIMINAR_TBL_PREGUNTA(:p_nID) }", nativeQuery = true)
		String eliminarPregunta(@Param("p_nID") int p_nID);
		
		// Insertar
		@Query(value = "{call SP_INS_TBL_PREGUNTA(:p_vPREGUNTA, :p_nRECURSO)}", nativeQuery = true) 
		String insertarPregunta(@Param("p_vPREGUNTA") String p_vPREGUNTA, @Param("p_nRECURSO") int p_nRECURSO);
		
		//Actualizar
		@Query(value = "{call SP_UPD_TBL_PREGUNTA(:p_nID,:p_vPREGUNTA, :p_nRECURSO)}", nativeQuery = true) 
		String actualizarPregunta(@Param("p_nID") int p_nID ,@Param("p_vPREGUNTA") String p_vPREGUNTA, @Param("p_nRECURSO") int p_nRECURSO);
		
}
