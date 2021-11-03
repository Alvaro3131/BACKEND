package com.example.sigca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sigca.entity.Persona;


@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer>{
	@Query(value = "{ CALL SP_LISTAR_TBL_PERSONA(0) }", nativeQuery = true) 
	List<Persona> listarPersona();
	
	@Query(value = "{CALL SP_LISTAR_TBL_PERSONA(:V_ID)}", nativeQuery = true) 
	Optional<Persona> readId(@Param("V_ID") int V_ID);
	
	@Query(value = "{ CALL SP_DEL_TBL_PERSONA(:P_nID) }", nativeQuery = true) 
	String deleteId(@Param("P_nID") int P_nID);
	
	@Query(value = "{ CALL ido_bi_capa.SP_INS_TBL_PERSONA(:p_vNOMBRE,:p_vAPELLIDO_P,:p_vAPELLIDO_M,"
			+ ":p_vDNI,:p_vCORREO,:p_vTELEFONO) }", nativeQuery = true) 
	String savePersona(@Param("p_vNOMBRE") String p_vNOMBRE,
			@Param("p_vAPELLIDO_P") String p_vAPELLIDO_P, @Param("p_vAPELLIDO_M") String p_vAPELLIDO_M,
			@Param("p_vDNI") String p_vDNI, @Param("p_vCORREO") String p_vCORREO,@Param("p_vTELEFONO") String p_vTELEFONO  );
  
}
