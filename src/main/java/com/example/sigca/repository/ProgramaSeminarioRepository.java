package com.example.sigca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sigca.entity.ProgramaSeminario;
@Repository
public interface ProgramaSeminarioRepository extends JpaRepository<ProgramaSeminario, Integer> {

			//Listar	
			@Query(value = "{ CALL SP_LISTAR_PROGRAMA_SEMINARIO(0) }", nativeQuery = true)
			List<ProgramaSeminario> listarProgramaSeminario();
			
			//Buscar
			@Query(value = "{call SP_LISTAR_PROGRAMA_SEMINARIO(:p_nIDPROGRAMASEMINARIO)}", nativeQuery = true) 
			ProgramaSeminario buscarProgramaSeminario(@Param("p_nIDPROGRAMASEMINARIO") int p_nIDPROGRAMASEMINARIO);
			
			//Delete
			@Query(value = "{ CALL SP_ELIMINAR_PROGRAMA_SEMINARIO(:p_nIDPROGRAMASEMINARIO) }", nativeQuery = true)
			String eliminarProgramaSeminario(@Param("p_nIDPROGRAMASEMINARIO") int p_nIDPROGRAMASEMINARIO);
			
			//Insertar
			@Query(value = "{call SP_INS_PROGRAMA_SEMINARIO(:P_FK_SEMINARIO, :P_FK_BANCOCOMUNAL)}", nativeQuery = true) 
			String insertarProgramaSeminario(@Param("P_FK_SEMINARIO") int P_FK_SEMINARIO,@Param("P_FK_BANCOCOMUNAL") int P_FK_BANCOCOMUNAL);
			
			//Update
			@Query(value = "{call SP_UPD_PROGRAMA_SEMINARIO(:p_nID_PROGRAMA_CAPACITACION,:p_nFK_SEMINARIO ,:p_nFK_BANCOCOMUNAL)}", nativeQuery = true) 
			String actualizarProgramaSeminario(@Param("p_nID_PROGRAMA_CAPACITACION") int p_nID_PROGRAMA_CAPACITACION,@Param("p_nFK_SEMINARIO") int p_nFK_SEMINARIO,@Param("p_nFK_BANCOCOMUNAL") int p_nFK_BANCOCOMUNAL); 
}
