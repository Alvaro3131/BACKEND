package com.example.sigca.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sigca.entity.RolUsuario;



@Repository
public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Integer>{
	
	
	// Listar	
	@Query(value = "{ CALL SP_LISTAR_ROL_USUARIO(0) }", nativeQuery = true)
	List<RolUsuario> listarRolUsuario();
	
	// Buscar
	
	@Query(value = "{call SP_LISTAR_ROL_USUARIO(:p_nIDROLUSUARIO)}", nativeQuery = true) 
	RolUsuario ListarRolUsuario(@Param("p_nIDROLUSUARIO") int p_nIDROLUSUARIO);
	
	//Delete
	
	@Query(value = "{ CALL SP_ELIMINAR_ROL_USUARIO(:p_nIDROLUSUARIO) }", nativeQuery = true)
	String eliminarRolUsuario(@Param("p_nIDROLUSUARIO") int p_nIDROLUSUARIO);
	
	// Insertar
	@Query(value = "{call SP_INS_ROL_USUARIO(:p_nIDROLUSUARIO,:p_nIDROL,:p_nIDPERSONA)}", nativeQuery = true) 
	String insertarRolUsuario(@Param("p_nIDROLUSUARIO") int p_nIDROLUSUARIO,@Param("p_nIDROL") int p_nIDROL,@Param("p_nIDPERSONA") int p_nIDPERSONA);
	
	//Update
	@Query(value = "{call SP_UPD_ROL_USUARIO(:p_nIDROLUSUARIO,:p_nIDROL,:p_nIDPERSONA)}", nativeQuery = true) 
	String actualizarRolUsuario(@Param("p_nIDROLUSUARIO") int p_nIDROLUSUARIO ,@Param("p_nIDROL") int p_nIDROL,@Param("p_nIDPERSONA") int p_nIDPERSONA);
	
	
	
}