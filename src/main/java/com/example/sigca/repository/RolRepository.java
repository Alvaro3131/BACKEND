package com.example.sigca.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sigca.entity.Rol;


@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
	
	
	// Listar	
	@Query(value = "{ CALL SP_LISTAR_ROL(0) }", nativeQuery = true)
	List<Rol> listarRol();
	
	// Buscar
	
	@Query(value = "{call SP_LISTAR_ROL(:p_nID_ROL)}", nativeQuery = true) 
	Rol buscarRol(@Param("p_nID_ROL") int p_nID_ROL);
	
	//Delete
	
	@Query(value = "{ CALL SP_ELIMINAR_ROL(:p_nID_ROL) }", nativeQuery = true)
	String eliminarRol(@Param("p_nID_ROL") int p_nID_ROL);
	
	// Insertar
	@Query(value = "{call SP_INS_ROL(:p_nNO_ROL)}", nativeQuery = true) 
	String insertarRol(@Param("p_nNO_ROL") String p_nNO_ROL);
	
	//Update
	@Query(value = "{call SP_UPD_ROL(:p_nID_ROL,:p_nNO_ROL)}", nativeQuery = true) 
	String actualizarRol(@Param("p_nID_ROL") int p_nID_ROL ,@Param("p_nNO_ROL") String p_nNO_ROL);
	
	@Query(value = "select tr.ID_ROL , tr.NO_ROL from tbl_usuario tu join tbl_rol_usuario tru on tu.ID_PERSONA =tru.FK_USUARIO join tbl_rol tr  on tru.FK_ROL =tr.ID_ROL where tu.ID_PERSONA =?;", nativeQuery = true)
	List<Rol> listarRoles(int id);
	
	
}