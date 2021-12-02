package com.example.sigca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.sigca.entity.Recurso;
import com.example.sigca.entity.Seminario;

public interface SeminarioRepository extends JpaRepository<Seminario, Integer>{
       
	@Query(value = "select tse.ID_SEMINARIO , tse.NO_SEMINARIO, tse.FE_INICIO , tse.FE_FIN , tse.URL_SEMINARIO  from tbl_asistencia_seminario tas  join tbl_socio ts on ts.ID_PERSONA =tas.FK_SOCIO join tbl_seminario tse on tse.ID_SEMINARIO =tas.FK_SEMINARIO where ts.ID_PERSONA =? and tas.ES_ASISTENCIA=0;", nativeQuery = true)
	List<Seminario> listarSeminarioSocio(int id);
		//Listar	
		@Query(value = "{ CALL SP_LISTAR_SEMINARIO(0) }", nativeQuery = true)
		List<Seminario> listarSeminario();
		
		//Buscar
		@Query(value = "{call SP_LISTAR_SEMINARIO(:p_nID)}", nativeQuery = true) 
		Seminario buscarSeminario(@Param("p_nID") int p_nID);
		
		//Delete
		@Query(value = "{ CALL SP_ELIMINAR_SEMINARIO(:p_nID) }", nativeQuery = true)
		String eliminarSeminario(@Param("p_nID") int p_nID);
		
		//Insertar
		@Query(value = "{call SP_INS_SEMINARIO(:P_NOMBRE, :P_FEINICIO, :P_FEFIN, :P_URL)}", nativeQuery = true) 
		String insertarSeminario(@Param("P_NOMBRE") String P_NOMBRE,@Param("P_FEINICIO") String P_FEINICIO,@Param("P_FEFIN") String P_FEFIN,
			 @Param("P_URL") String P_URL);
		
		//Update
		@Query(value = "{call SP_UPD_SEMINARIO(:P_IDSEMINARIO,:P_NOMBRE, :P_FEINICIO, :P_FEFIN, :P_URL)}", nativeQuery = true) 
		String actualizarSeminario(@Param("P_IDSEMINARIO") int P_IDSEMINARIO ,@Param("P_NOMBRE") String P_NOMBRE,@Param("P_FEINICIO") String P_FEINICIO,@Param("P_FEFIN") String P_FEFIN,
				 @Param("P_URL") String P_URL); 
}
