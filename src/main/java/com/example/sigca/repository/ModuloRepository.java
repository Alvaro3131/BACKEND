package com.example.sigca.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.sigca.entity.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Integer> {
	
	
		// Listar	
		@Query(value = "{ CALL SP_LISTAR_MODULO(0) }", nativeQuery = true)
		List<Modulo> listarModulo();
		
		// Buscar
		
		@Query(value = "{call SP_LISTAR_MODULO(:p_nIDMODULO)}", nativeQuery = true) 
		Modulo buscarModulo(@Param("p_nIDMODULO") int p_nIDMODULO);
		
		//Delete
		
		@Query(value = "{ CALL SP_ELIMINAR_MODULO(:p_IDSEDE) }", nativeQuery = true)
		String eliminarModulo(@Param("p_IDSEDE") int P_IDSEDE);
		
		// Insertar
		@Query(value = "{call SP_INS_MODULO(:p_vNombre,:p_nIdCategoria)}", nativeQuery = true) 
		String insertarModulo(@Param("p_vNombre") String P_NOMBRE, @Param("p_nIdCategoria") int p_nIdCategoria);
		
		//Update
		@Query(value = "{call SP_UPD_MODULO(:P_IDSEDE,:P_NOMBRE)}", nativeQuery = true) 
		String actualizarModulo(@Param("P_IDSEDE") int P_IDSEDE ,@Param("P_NOMBRE") String P_NOMBRE);
	
}
