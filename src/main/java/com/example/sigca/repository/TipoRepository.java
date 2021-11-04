package com.example.sigca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sigca.entity.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Integer> {

	// Listar	
		@Query(value = "{ CALL SP_LISTAR_TIPO(0) }", nativeQuery = true)
		List<Tipo> listarTipo();
		
		// Buscar
		
		@Query(value = "{call SP_LISTAR_TIPO(:p_nIDTIPO)}", nativeQuery = true) 
		Tipo buscarTipo(@Param("p_nIDTIPO") int p_nIDTIPO);
		
		//Delete
		
		@Query(value = "{ CALL SP_ELIMINAR_TIPO(:p_nIDTIPO) }", nativeQuery = true)
		String eliminarTipo(@Param("p_nIDTIPO") int p_nIDTIPO);
		
		// Insertar
		@Query(value = "{call SP_INS_TIPO(:p_vNombre)}", nativeQuery = true) 
		String insertarTipo(@Param("p_vNombre") String P_NOMBRE);
		
		//Update
		@Query(value = "{call SP_UPD_TIPO(:p_nIDTIPO,:p_vNombre)}", nativeQuery = true) 
		String actualizarTipo(@Param("p_nIDTIPO") int p_nIDTIPO ,@Param("p_vNombre") String p_vNombre);
}
