package com.example.sigca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sigca.entity.Asistencia_Seminario;
@Repository
public interface AsistenciaSeminarioRepository extends JpaRepository<Asistencia_Seminario, Integer>{
	
		//Listar
		@Query(value = "{ CALL SP_LISTAR_ASISTENCIA_SEMINARIO(0) }", nativeQuery = true)
		List<Asistencia_Seminario> listarAsistencia_Seminario();
		
		//Buscar
		@Query(value = "{call SP_LISTAR_ASISTENCIA_SEMINARIO(:p_nIDASISTENCIASEMINARIO)}", nativeQuery = true) 
		Asistencia_Seminario buscarAsistenciaSeminario(@Param("p_nIDASISTENCIASEMINARIO") int p_nIDASISTENCIASEMINARIO);
		
		//Delete
		@Query(value = "{ CALL SP_ELIMINAR_ASISTENCIA_SEMINARIO(:p_nIDASISTENCIASEMINARIO) }", nativeQuery = true)
		String eliminarAsistenciaSeminario(@Param("p_nIDASISTENCIASEMINARIO") int p_nIDASISTENCIASEMINARIO);
		
		//Insertar
		@Query(value = "{call SP_INS_ASISTENCIA_SEMINARIO(:p_nIdSeminario,:p_nIdSocio,:p_nEstado,:p_vDescripcion)}", nativeQuery = true) 
		String insertarAsistenciaSeminario(@Param("p_nIdSeminario") int p_nIdSeminario,@Param("p_nIdSocio") int p_nIdSocio,@Param("p_nEstado") int p_nEstado,@Param("p_vDescripcion") String p_vDescripcion);
		
		//Update
		@Query(value = "{call SP_UPD_ASISTENCIA_SEMINARIO(:p_nIdAsistencia,:p_nIdSeminario,:p_nIdSocio,:p_nEstado,:p_vDescripcion)}", nativeQuery = true) 
		String actualizarAsistenciaSeminario(@Param("p_nIdAsistencia") int p_nIdAsistencia ,@Param("p_nIdSeminario") int p_nIdSeminario,@Param("p_nIdSocio") int p_nIdSocio,@Param("p_nEstado") int p_nEstado,@Param("p_vDescripcion") int p_vDescripcion);
		
}
