package com.example.sigca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sigca.entity.BancoComunal;
import com.example.sigca.entity.Programacion;

@Repository
public interface ProgramacionRepository extends JpaRepository<Programacion, Integer>{

	@Query(value = "select * from tbl_programacion where ES_PROGRAMACION =1;", nativeQuery = true)
	List<Programacion> programacionEstadoTrue();
	
	@Query(value = "select * from tbl_programacion where ES_PROGRAMACION =0;", nativeQuery = true)
	List<Programacion> programacionEstadoFalse();
	
	@Query(value = "update tbl_programacion set ES_PROGRAMACION=p_nEstado where fk_modulo=p_nFK_MODULO and fk_bancocomunal=p_nFK_BANCOCOMUNAL;", nativeQuery = true)
	List<Programacion> programacionUpdate(@Param("estado") int p_nEstado ,@Param("p_nFK_BANCOCOMUNAL") int p_nFK_BANCOCOMUNAL
			,	@Param("p_nFK_MODULO") int p_nFK_MODULO);
	
	// Listar	
	@Query(value = "{ CALL SP_LISTAR_PROGRAMACION(0) }", nativeQuery = true)
	List<Programacion> listarProgramacion();
	
	// Buscar
	
	@Query(value = "{call SP_LISTAR_PROGRAMACION(:p_nIDPROGRAMACION)}", nativeQuery = true) 
	Programacion BuscarProgramacion(@Param("p_nIDPROGRAMACION") int p_nIDPROGRAMACION);
	
	@Query(value = "Select * from tbl_programacion where fk_bancocomunal=?1", nativeQuery = true)
	List<Programacion> listarProgramacionBanco(int id);
	//Delete
	
	@Query(value = "{ CALL SP_DEL_PROGRAMACION(:p_nIDPROGRAMACION) }", nativeQuery = true)
	String eliminarProgramacion(@Param("p_nIDPROGRAMACION") int p_nIDPROGRAMACION);
	
	// Insertar
	@Query(value = "{call SP_INS_PROGRAMACION(:p_nFK_BANCOCOMUNAL,:p_nFK_MODULO)}", nativeQuery = true) 
	String insertarProgramacion(@Param("p_nFK_BANCOCOMUNAL") int p_nFK_BANCOCOMUNAL,@Param("p_nFK_MODULO") int p_nFK_MODULO);
	
	//Update
	@Query(value = "{call SP_UPD_PROGRAMACION(:p_nIDPROGRAMACION,:p_nFK_BANCOCOMUNAL,:p_nFK_MODULO,:p_nES_PROGRAMACION)}", nativeQuery = true) 
	String actualizarProgramacion(@Param("p_nIDPROGRAMACION") int p_nIDPROGRAMACION ,@Param("p_nFK_BANCOCOMUNAL") int p_nFK_BANCOCOMUNAL
		,	@Param("p_nFK_MODULO") int p_nFK_MODULO, @Param("p_nES_PROGRAMACION") int p_nES_PROGRAMACION);
}
