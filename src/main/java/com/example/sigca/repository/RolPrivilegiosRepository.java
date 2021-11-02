package com.example.sigca.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.sigca.entity.RolPrivilegios;



@Repository
public interface RolPrivilegiosRepository extends JpaRepository<RolPrivilegios, Integer>{
	
	
	// Listar	
	@Query(value = "{ CALL SP_LISTAR_ROL_PRIVILEGIOS(0) }", nativeQuery = true)
	List<RolPrivilegios> listarRolPrivilegios();
	
	// Buscar
	
	@Query(value = "{call SP_LISTAR_ROL_PRIVILEGIOS(:p_nIDROLPRIVILEGIOS)}", nativeQuery = true) 
	RolPrivilegios ListarRolPrivilegios(@Param("p_nIDROLPRIVILEGIOS") int p_nIDROLPRIVILEGIOS);
	
	//Delete
	
	@Query(value = "{ CALL SP_ELIMINAR_ROL_PRIVILEGIOS(:p_nIDROLPRIVILEGIOS) }", nativeQuery = true)
	String eliminarRolPrivilegios(@Param("p_nIDROLPRIVILEGIOS") int p_nIDROLPRIVILEGIOS);
	
	// Insertar
	@Query(value = "{call SP_INS_ROL_PRIVILEGIOS(:p_nIDPRIVILEGIOS,:p_nIDROL)}", nativeQuery = true) 
	String insertarRolPrivilegios(@Param("p_nIDPRIVILEGIOS") int p_nIDPRIVILEGIOS,@Param("p_nIDROL") int p_nIDROL);
	
	//Update
	@Query(value = "{call SP_UPD_ROL_PRIVILEGIOS(:p_nIDROLPRIVILEGIOS,:p_nIDPRIVILEGIOS,:p_nIDROL)}", nativeQuery = true) 
	String actualizarRolPrivilegios(@Param("p_nIDROLPRIVILEGIOS") int p_nIDROLPRIVILEGIOS ,@Param("p_nIDPRIVILEGIOS") int p_nIDPRIVILEGIOS,@Param("p_nIDROL") int p_nIDROL);
	
	
	
}