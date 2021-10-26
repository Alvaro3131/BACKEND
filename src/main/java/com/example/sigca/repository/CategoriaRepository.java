package com.example.sigca.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.sigca.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
		// Listar	
		@Query(value = "{ CALL SP_LISTAR_CATEGORIA(0) }", nativeQuery = true)
		List<Categoria> listarCategoria();
		
		// Buscar
		
		@Query(value = "{call SP_LISTAR_CATEGORIA(:p_nIDCATEGORIA)}", nativeQuery = true) 
		Categoria buscarCategoria(@Param("p_nIDCATEGORIA") int p_nIDCATEGORIA);
		
		//Delete
		
		@Query(value = "{ CALL SP_ELIMINAR_CATEGORIA(:p_nIDCATEGORIA) }", nativeQuery = true)
		String eliminarCategoria(@Param("p_nIDCATEGORIA") int p_nIDCATEGORIA);
		
		// Insertar
		@Query(value = "{call SP_INS_CATEGORIA(:P_NOMBRE)}", nativeQuery = true) 
		String insertarCategoria(@Param("P_NOMBRE") String P_NOMBRE);
		
		//Update
		@Query(value = "{call SP_UPD_CATEGORIA(:p_nID,:P_NOMBRE)}", nativeQuery = true) 
		String actualizarCategoria(@Param("p_nID") int p_nID ,@Param("P_NOMBRE") String P_NOMBRE);
		
}
