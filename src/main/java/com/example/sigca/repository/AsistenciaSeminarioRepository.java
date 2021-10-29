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
		String eliminarBanco(@Param("p_nIDASISTENCIASEMINARIO") int p_nIDASISTENCIASEMINARIO);
		
		// Insertar
		@Query(value = "{call SP_INS_ASISTENCIA_SEMINARIO(:p_nIdSeminario,:p_nIdSocio,:p_nEstado,:p_vDescripcion)}", nativeQuery = true) 
		String insertarBanco(@Param("P_NOMBRE") String P_NOMBRE,@Param("P_FKDISTRITO") int P_FKDISTRITO,@Param("P_FKASESOR") int P_FKASESOR);
		
		//Update
		@Query(value = "{call SP_UPD_ASISTENCIA_SEMINARIO(:p_nIdAsistencia,:p_nIdSeminario,:p_nIdSocio,:p_nEstado,:p_vDescripcion)}", nativeQuery = true) 
		String actualizarBanco(@Param("p_nIdAsistencia") int P_IDASISTENCIA ,@Param("p_nIdSeminario") int P_IDSEMINARIO ,@Param("p_nIdSocio") int P_IDSOCIO,@Param("p_nEstado") int P_ESTADO,@Param("p_vDescripcion") String P_DESCRIPCION);
		
}
