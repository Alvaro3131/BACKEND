package com.example.sigca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.sigca.entity.Socio;
import com.example.sigca.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	// Listar	
	public Usuario findByUsername(String username);
	
	@Query(value = "{ CALL SP_LISTAR_USUARIO(0) }", nativeQuery = true)
	List<Usuario> listarUsuario();
	
	// Buscar
	
	@Query(value = "{ CALL SP_LISTAR_USUARIO(:p_nIDUsuario) }", nativeQuery = true) 
	Optional<Usuario> buscarUsuario(@Param("p_nIDUsuario") int p_nIDUsuario);
	
	//Delete
	
	@Query(value = "{ CALL SP_ELIMINAR_USUARIO(:p_nID) }", nativeQuery = true)
	String eliminarsocio(@Param("p_nID") int p_nID);
	
	// Insertar
	@Query(value = "{ CALL SP_INS_USUARIO(:p_nIdUsuario,:p_vNombre,:p_vContraseña) }", nativeQuery = true) 
	String insertarUsuario(@Param("p_nIdUsuario") int p_nIdUsuario, @Param("p_vNombre") String p_vNombre, @Param("p_vContraseña") String p_vContraseña );
	
	//Update
	@Query(value = "{ CALL SP_UPD_USUARIO(:p_nID,:p_vNombre,:p_vContraseña) }", nativeQuery = true) 
	String actualizarsocio( @Param("p_nID") int p_nID, @Param("p_vNombre") String p_vNombre, @Param("p_vContraseña") String p_vContraseña );
	
}
