package com.example.sigca.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sigca.entity.Privilegios;



@Repository
public interface PrivilegiosRepository extends JpaRepository<Privilegios, Integer>{
	
	
	// Listar	
	@Query(value = "{ CALL SP_LISTAR_TBL_PRIVILEGIO(0) }", nativeQuery = true)
	List<Privilegios> listarPrivilegios();
	
	@Query(value = "{ CALL ido_bi_capa.SP_CHECK_USER(:p_nID) }", nativeQuery = true)
	List<Map<String,Object>> listarPrivilegiosUsuario(@Param("p_nID") int p_nID);
	
	// Buscar
	
	@Query(value = "{call SP_LISTAR_TBL_PRIVILEGIO(:p_nID)}", nativeQuery = true) 
	Privilegios buscarPrivilegios(@Param("p_nID") int p_nID);
	
	//Delete
	
	@Query(value = "{ CALL SP_DEL_TBL_PRIVILEGIOS(:P_nID) }", nativeQuery = true)
	String eliminarPrivilegios(@Param("P_nID") int P_nID);
	
	// Insertar
	@Query(value = "{call SP_INS_TBL_PRIVILEGIO(:p_vPRIVILEGIOS)}", nativeQuery = true) 
	String insertarPrivilegios(@Param("p_vPRIVILEGIOS") String p_vPRIVILEGIOS);
	
	//Update
	@Query(value = "{call SP_UPD_TBL_PRIVILEGIO(:p_nID,:p_vPRIVILEGIOS)}", nativeQuery = true) 
	String actualizarPrivilegios(@Param("p_nID") int p_nID ,@Param("p_vPRIVILEGIOS") String p_vPRIVILEGIOS);
	
	
	
}