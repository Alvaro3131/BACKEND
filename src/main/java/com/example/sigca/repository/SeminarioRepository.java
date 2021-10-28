package com.example.sigca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.sigca.entity.Seminario;

public interface SeminarioRepository extends JpaRepository<Seminario, Integer>{

		//Listar	
		@Query(value = "{ CALL SP_LISTAR_SEMINARIO(0) }", nativeQuery = true)
		List<Seminario> listarSeminario();
		
		//Buscar
		@Query(value = "{call SP_LISTAR_SEMINARIO(:p_nID)}", nativeQuery = true) 
		Seminario buscarSeminario(@Param("p_nID") int p_nID);
		
		/*//Delete
		@Query(value = "{ CALL SP_ELIMINAR_SEMINARIO(:p_nID) }", nativeQuery = true)
		String eliminarSeminario(@Param("p_nID") int p_nID);*/
		
		/*//Insertar
		@Query(value = "{call SP_INS_SEMINARIO(:P_NOMBRE, :P_FEINICIO, :P_FEFIN, :P_URL)}", nativeQuery = true) 
		String insertarSede(@Param("P_NOMBRE") String P_NOMBRE,@Param("P_FEINICIO") LocalDateTime P_FEINICIO,@Param("P_FEFIN") LocalDateTime P_FEFIN,
			 @Param("P_URL") String P_URL);
		
		//Update
		@Query(value = "{call SP_UPD_SEDE(:P_IDSEMINARIO,:P_NOMBRE, :P_FEINICIO, :P_FEFIN, :P_URL)}", nativeQuery = true) 
		String actualizarSede(@Param("P_IDSEMINARIO") int P_IDSEMINARIO ,@Param("P_NOMBRE") String P_NOMBRE,@Param("P_FEINICIO") LocalDateTime P_FEINICIO,@Param("P_FEFIN") LocalDateTime P_FEFIN,
				 @Param("P_URL") String P_URL); */
}
