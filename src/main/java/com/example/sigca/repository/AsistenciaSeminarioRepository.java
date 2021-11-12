package com.example.sigca.repository;

import java.sql.Time;
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
		@Query(value = "{call SP_INS_ASISTENCIA_SEMINARIO(:p_nIdAsistencia_Seminario,:p_Es_Asistencia:p_De_Asistencia,:p_Fe_Asistencia)}", nativeQuery = true) 
		String insertarAsistenciaSeminario(@Param("p_nIdAsistencia_Seminario") int p_nIdAsistencia_Seminario,@Param("p_Es_Asistencia") int p_Es_Asistencia,@Param("p_De_Asistencia") String p_De_Asistencia, @Param("p_Fe_Asistencia") Time p_Fe_Asistencia);
		
		//Update
		@Query(value = "{call SP_UPD_ASISTENCIA_SEMINARIO(:p_nIdAsistencia,:p_nIdSeminario,:p_nIdSocio,:p_nEstado,:p_vDescripcion)}", nativeQuery = true) 
		String actualizarAsistenciaSeminario(@Param("p_nIdAsistencia_Seminario") int p_nIdAsistencia_Seminario,@Param("p_Es_Asistencia") int p_Es_Asistencia,@Param("p_De_Asistencia") String p_De_Asistencia, @Param("p_Fe_Asistencia") Time p_Fe_Asistencia);
		
}
