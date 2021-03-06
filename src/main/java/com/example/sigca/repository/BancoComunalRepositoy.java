package com.example.sigca.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.sigca.entity.BancoComunal;
@Repository
public interface BancoComunalRepositoy extends JpaRepository<BancoComunal, Integer>{
	
	//List
	@Query(value = "{ CALL SP_LISTAR_BANCOCOMUNAL(0) }", nativeQuery = true)
	List<BancoComunal> listarBancoComunal();
	
	
	@Query(value = "Select * from tbl_bancocomunal where fk_distrito=?1", nativeQuery = true)
	List<BancoComunal> listarBancoComunalDistrito(int id);

	@Query(value = "select bc.ID_BANCOCOMUNAL, bc.NO_BANCOCOMUNAL, bc.FK_DISTRITO, bc.FK_ASESOR from tbl_bancocomunal bc join tbl_distrito tb on tb.ID_DISTRITO = bc.FK_DISTRITO join tbl_sede sd on tb.FK_SEDE = sd.ID_SEDE where sd.ID_SEDE = ?;", nativeQuery = true)
	List<BancoComunal> listarBancoComunalSede(int id);
	
	//Buscar
	@Query(value = "{call SP_LISTAR_BANCOCOMUNAL(:p_nIDBANCOCOMUNAL)}", nativeQuery = true) 
	BancoComunal buscarBanco(@Param("p_nIDBANCOCOMUNAL") int p_nIDBANCOCOMUNAL);
	
	//Delete
	@Query(value = "{ CALL SP_ELIMINAR_BANCOCOMUNAL(:p_nIDBANCOCOMUNAL) }", nativeQuery = true)
	String eliminarBanco(@Param("p_nIDBANCOCOMUNAL") int p_nIDBANCOCOMUNAL);
	
	//Insert
	@Query(value = "{call SP_INS_BANCOCOMUNAL(:P_NOMBRE,:P_FKDISTRITO,:P_FKASESOR)}", nativeQuery = true) 
	String insertarBanco(@Param("P_NOMBRE") String P_NOMBRE,@Param("P_FKDISTRITO") int P_FKDISTRITO,@Param("P_FKASESOR") int P_FKASESOR);
	
	//Update
	@Query(value = "{call SP_UPD_BANCOCOMUNAL(:P_nIDBANCOCOMUNAL,:P_NOMBRE,:P_FKDISTRITO,:P_FKASESOR)}", nativeQuery = true) 
	String actualizarBanco(@Param("P_nIDBANCOCOMUNAL") int P_nIDBANCOCOMUNAL ,@Param("P_NOMBRE") String P_NOMBRE,@Param("P_FKDISTRITO") int P_FKDISTRITO,@Param("P_FKASESOR") int P_FKASESOR);

}
