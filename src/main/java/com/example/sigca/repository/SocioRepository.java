package com.example.sigca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.sigca.entity.Sede;
import com.example.sigca.entity.Socio;

public interface SocioRepository extends JpaRepository<Socio, Integer> {
	// Listar	
		@Query(value = "{ CALL SP_LISTAR_SOCIO(0) }", nativeQuery = true)
		List<Socio> listarSocio();
		
		// Buscar
		
		@Query(value = "{ CALL SP_LISTAR_SOCIO(:p_nIDSocio) }", nativeQuery = true) 
		Optional<Socio> buscarSocio(@Param("p_nIDSocio") int p_nIDSocio);
		
		//Delete
		
		@Query(value = "{ CALL SP_DEL_SOCIO(:p_nID) }", nativeQuery = true)
		String eliminarsocio(@Param("p_nID") int p_nID);
		
		// Insertar
		@Query(value = "{ CALL SP_INS_SOCIO(:p_nIdSocio,:p_nEstado,:p_nBancoComunal) }", nativeQuery = true) 
		String insertarsocio(@Param("p_nIdSocio") int p_nIdSocio, @Param("p_nEstado") int p_nEstado, @Param("p_nBancoComunal") int p_nBancoComunal );
		
		//Update
		@Query(value = "{ CALL SP_UPD_SOCIO(:p_nID,:p_nEstado,:p_nBancoComunal) }", nativeQuery = true) 
		String actualizarsocio( @Param("p_nID") int p_nID, @Param("p_nEstado") int p_nEstado, @Param("p_nBancoComunal") int p_nBancoComunal );
		
}
