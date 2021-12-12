package com.example.sigca.repository;

import java.sql.Time;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.sigca.entity.AsistenciaSeminario;
import com.example.sigca.entity.BancoComunal;

@Repository
public interface AsistenciaSeminarioRepository extends JpaRepository<AsistenciaSeminario, Integer>{
	@Query(value = "select * from tbl_asistencia_seminario where FK_SEMINARIO=? and FK_SOCIO=?;", nativeQuery = true)
	List<AsistenciaSeminario> listarasistencia(int seminario, int socio);
	
	
	
	
		//Listar
		@Query(value = "{ CALL SP_LISTAR_ASISTENCIA_SEMINARIO(0) }", nativeQuery = true)
		List<AsistenciaSeminario> listarAsistenciaSeminario();
		
		//Buscar
		@Query(value = "{call SP_LISTAR_ASISTENCIA_SEMINARIO(:p_nIDASISTENCIASEMINARIO)}", nativeQuery = true) 
		AsistenciaSeminario buscarAsistenciaSeminario(@Param("p_nIDASISTENCIASEMINARIO") int p_nIDASISTENCIASEMINARIO);
		
		//Delete
		@Query(value = "{ CALL SP_ELIMINAR_ASISTENCIA_SEMINARIO(:p_nIDASISTENCIASEMINARIO) }", nativeQuery = true)
		String eliminarAsistenciaSeminario(@Param("p_nIDASISTENCIASEMINARIO") int p_nIDASISTENCIASEMINARIO);
		
		//Insertar
		@Query(value = "{CALL SP_INS_ASISTENCIA_SEMINARIO(:p_nIdSeminario,:p_nIdSocio,:p_vDescripcion,:P_nValoracion)}", nativeQuery = true) 
		String insertarAsistenciaSeminario(@Param("p_nIdSeminario") int p_nIdSeminario,
				@Param("p_nIdSocio") int p_nIdSocio,@Param("p_vDescripcion") String p_vDescripcion, 
				@Param("P_nValoracion") int P_nValoracion);
		
	
		@Query(value = "{ CALL SP_REGISTRAR_ASISTENCIA_SEMINARIO(:p_nIDSOCIO,:p_nIDSEMINARIO,:p_nVALORACION,:p_nDESCRIPCION) }", nativeQuery = true) 
		String actualizar(@Param("p_nIDSOCIO") int p_nIDSOCIO,@Param("p_nIDSEMINARIO") int p_nIDSEMINARIO,@Param("p_nVALORACION") int p_nVALORACION, 
				@Param("p_nDESCRIPCION") String p_nDESCRIPCION);
		
		//Update
		@Query(value = "{call SP_UPD_ASISTENCIA_SEMINARIO(:p_nIdAsistencia_Seminario,:p_Es_Asistencia:p_De_Asistencia,:p_Fe_Asistencia)}", nativeQuery = true) 
		String actualizarAsistenciaSeminario(@Param("p_nIdAsistencia_Seminario") int p_nIdAsistencia_Seminario,
				@Param("p_Es_Asistencia") int p_Es_Asistencia,@Param("p_De_Asistencia") String p_De_Asistencia,
				@Param("p_Fe_Asistencia") Time p_Fe_Asistencia);
		
}
