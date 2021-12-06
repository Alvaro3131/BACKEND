package com.example.sigca.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.sigca.entity.Sede;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Integer>{
	
	
	// Listar	
	@Query(value = "{ CALL SP_LISTAR_SEDE(0) }", nativeQuery = true)
	List<Sede> listarSede();
	
	// Buscar
	
	@Query(value = "{call SP_LISTAR_SEDE(:p_IDSEDE)}", nativeQuery = true) 
	Sede buscarSede(@Param("p_IDSEDE") int p_IDSEDE);
	
	//Delete
	
	@Query(value = "{ CALL SP_ELIMINAR_SEDE(:p_IDSEDE) }", nativeQuery = true)
	String eliminarSede(@Param("p_IDSEDE") int P_IDSEDE);
	
	// Insertar
	@Query(value = "{call SP_INS_SEDE(:P_NOMBRE)}", nativeQuery = true) 
	String insertarSede(@Param("P_NOMBRE") String P_NOMBRE);
	
	//Update
	@Query(value = "{call SP_UPD_SEDE(:P_IDSEDE,:P_NOMBRE)}", nativeQuery = true) 
	String actualizarSede(@Param("P_IDSEDE") int P_IDSEDE ,@Param("P_NOMBRE") String P_NOMBRE);
	
	
	
}
