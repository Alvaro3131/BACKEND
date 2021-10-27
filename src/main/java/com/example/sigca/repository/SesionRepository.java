package com.example.sigca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sigca.entity.Sede;
import com.example.sigca.entity.Sesion;

@Repository
public interface SesionRepository extends JpaRepository<Sesion, Integer>{

		// Listar	
		@Query(value = "{ CALL SP_LISTAR_SESION(0) }", nativeQuery = true)
		List<Sesion> listarSesion();
		
		// Buscar
		
		@Query(value = "{call SP_LISTAR_SESION(:p_nIDSESION)}", nativeQuery = true) 
		Optional<Sesion> buscarSesion(@Param("p_nIDSESION") int p_nIDSESION);
		
		//Delete
		
		@Query(value = "{ CALL SP_ELIMINAR_SESION(:p_nIDSESION) }", nativeQuery = true)
		String eliminarSesion(@Param("p_nIDSESION") int p_nIDSESION);
		
		// Insertar
		@Query(value = "{call SP_INS_SEDE(:P_NOMBRE)}", nativeQuery = true) 
		String insertarSede(@Param("P_NOMBRE") String P_NOMBRE);
		
		//Update
		@Query(value = "{call SP_UPD_SEDE(:P_IDSEDE,:P_NOMBRE)}", nativeQuery = true) 
		String actualizarSede(@Param("P_IDSEDE") int P_IDSEDE ,@Param("P_NOMBRE") String P_NOMBRE);
			
	
}
