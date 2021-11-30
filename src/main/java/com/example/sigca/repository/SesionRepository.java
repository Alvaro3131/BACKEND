package com.example.sigca.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sigca.entity.Distrito;
import com.example.sigca.entity.Sesion;

@Repository
public interface SesionRepository extends JpaRepository<Sesion, Integer>{

		// Listar	
		@Query(value = "{ CALL SP_LISTAR_SESION(0) }", nativeQuery = true)
		List<Sesion> listarSesion();
		
		
		@Query(value = "Select * from tbl_sesion where fk_modulo=?1", nativeQuery = true)
		List<Sesion> listarSesionModulo(int id);
		// Buscar
		@Query(value = "{call SP_LISTAR_SESION(:ID_SESION)}", nativeQuery = true) 
		Sesion buscarSesion(@Param("ID_SESION") int ID_SESION);
		
		//Delete
		
		@Query(value = "{ CALL SP_ELIMINAR_SESION(:ID_SESION) }", nativeQuery = true)
		String eliminarSesion(@Param("ID_SESION") int ID_SESION);
		
		// Insertar
		@Query(value = "{call SP_INS_SESION(:NO_SESION,:FK_MODULO)}", nativeQuery = true) 
		String insertarSesion(@Param("NO_SESION") String NO_SESION);
		
		//Update
		@Query(value = "{call SP_UPD_SESION(:ID_SESION,:NO_SESION,:FK_MODULO)}", nativeQuery = true) 
		String actualizarSesion(@Param("ID_SESION") int ID_SESION,@Param("NO_SESION") String NO_SESION);
		
	
}
