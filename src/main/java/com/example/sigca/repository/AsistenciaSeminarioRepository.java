package com.example.sigca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sigca.entity.Asistencia_Seminario;
import com.example.sigca.entity.BancoComunal;
@Repository
public interface AsistenciaSeminarioRepository extends JpaRepository<Asistencia_Seminario, Integer>{
	
		//Listar
		@Query(value = "{ CALL SP_LISTAR_ASISTENCIA_SEMINARIO(0) }", nativeQuery = true)
		List<Asistencia_Seminario> listarAsistencia_Seminario();
		
		//Buscar
		
		@Query(value = "{call SP_LISTAR_ASISTENCIA_SEMINARIO(:p_nIDASISTENCIASEMINARIO)}", nativeQuery = true) 
		Asistencia_Seminario buscarAsistenciaSeminario(@Param("p_nIDASISTENCIASEMINARIO") int p_nIDASISTENCIASEMINARIO);
		
		//Delete
		/*
		@Query(value = "{ CALL SP_ELIMINAR_ASISTENCIA_SEMINARIO(:p_nIDASISTENCIASEMINARIO) }", nativeQuery = true)
		String eliminarBanco(@Param("p_nIDASISTENCIASEMINARIO") int p_nIDASISTENCIASEMINARIO);
		/*
		// Insertar
		@Query(value = "{call SP_INS_BANCOCOMUNAL(:P_NOMBRE,:P_FKDISTRITO,:P_FKASESOR)}", nativeQuery = true) 
		String insertarBanco(@Param("P_NOMBRE") String P_NOMBRE,@Param("P_FKDISTRITO") int P_FKDISTRITO,@Param("P_FKASESOR") int P_FKASESOR);
		
		//Update
		@Query(value = "{call SP_UPD_BANCOCOMUNAL(:P_nIDBANCOCOMUNAL,:P_NOMBRE,:P_FKDISTRITO,:P_FKASESOR)}", nativeQuery = true) 
		String actualizarBanco(@Param("P_nIDBANCOCOMUNAL") int P_nIDBANCOCOMUNAL ,@Param("P_NOMBRE") String P_NOMBRE,@Param("P_FKDISTRITO") int P_FKDISTRITO,@Param("P_FKASESOR") int P_FKASESOR);
		*/
}