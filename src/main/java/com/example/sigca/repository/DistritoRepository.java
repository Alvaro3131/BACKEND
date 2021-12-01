package com.example.sigca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sigca.entity.BancoComunal;
import com.example.sigca.entity.Distrito;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Integer>{
	
	//Listar	
	@Query(value = "{ CALL SP_LISTAR_DISTRITO(0) }", nativeQuery = true)
	List<Distrito> listarDistrito();
	
	@Query(value = "Select * from tbl_distrito where fk_sede=?1", nativeQuery = true)
	List<Distrito> listarDistritoSede(int id);
	//buscar
	@Query(value = "{call SP_LISTAR_DISTRITO(:p_nIDDISTRITO)}", nativeQuery = true) 
	Distrito buscarDistrito(@Param("p_nIDDISTRITO") int p_nIDDISTRITO);
	
	//Delete
	@Query(value = "{ CALL SP_ELIMINAR_DISTRITO(:p_nIDDISTRITO) }", nativeQuery = true)
	String eliminarDistrito(@Param("p_nIDDISTRITO") int p_nIDDISTRITO);
		
	//Insertar
	@Query(value = "{call SP_INS_DISTRITO(:p_vNombre,:p_nIdSede)}", nativeQuery = true) 
	String insertarDistrito(@Param("p_vNombre") String p_vNombre ,@Param("p_nIdSede") int p_nIdSede );
		
	//Update
	@Query(value = "{call SP_UPD_DISTRITO(:p_nID,:p_vNombre,:p_nIdSede)}", nativeQuery = true) 
	String actualizarDistrito(@Param("p_nID") int p_nID ,@Param("p_vNombre") String p_vNombre,@Param("p_nIdSede") int p_nIdSede );
	
}
