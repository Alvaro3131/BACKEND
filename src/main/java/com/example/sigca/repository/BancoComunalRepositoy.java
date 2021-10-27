package com.example.sigca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.sigca.entity.BancoComunal;
@Repository
public interface BancoComunalRepositoy extends JpaRepository<BancoComunal, Integer>{
	
	//Listar
	@Query(value = "{ CALL SP_LISTAR_BANCOCOMUNAL(0) }", nativeQuery = true)
	List<BancoComunal> listarBancoComunal();
	
	//Buscar
	
	@Query(value = "{call SP_LISTAR_BANCOCOMUNAL(:p_nIDBANCOCOMUNAL)}", nativeQuery = true) 
	Optional<BancoComunal> buscarBanco(@Param("p_nIDBANCOCOMUNAL") int p_nIDBANCOCOMUNAL);
	
	//Delete
	
	@Query(value = "{ CALL SP_ELIMINAR_BANCOCOMUNAL(:p_nIDBANCOCOMUNAL) }", nativeQuery = true)
	String eliminarBanco(@Param("p_nIDBANCOCOMUNAL") int p_nIDBANCOCOMUNAL);
	
	// Insertar
	@Query(value = "{call SP_INS_BANCOCOMUNAL(:P_NOMBRE,:P_FKDISTRITO,:P_FKASESOR)}", nativeQuery = true) 
	String insertarBanco(@Param("P_NOMBRE") String P_NOMBRE,@Param("P_FKDISTRITO") int P_FKDISTRITO,@Param("P_FKASESOR") int P_FKASESOR);
	
	//Update
	@Query(value = "{call SP_UPD_BANCOCOMUNAL(:P_nIDBANCOCOMUNAL,:P_NOMBRE,:P_FKDISTRITO,:P_FKASESOR)}", nativeQuery = true) 
	String actualizarBanco(@Param("P_nIDBANCOCOMUNAL") int P_nIDBANCOCOMUNAL ,@Param("P_NOMBRE") String P_NOMBRE,@Param("P_FKDISTRITO") int P_FKDISTRITO,@Param("P_FKASESOR") int P_FKASESOR);

}
