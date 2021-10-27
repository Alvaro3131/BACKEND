package com.example.sigca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.sigca.entity.Asesor;
import com.example.sigca.entity.Usuario;

public interface AsesorRepository extends JpaRepository<Asesor, Integer> {
	// Listar	
	@Query(value = "{ CALL SP_LISTAR_ASESOR(0) }", nativeQuery = true)
	List<Asesor> listarAsesor();
	
	// Buscar
	
	@Query(value = "{ CALL SP_LISTAR_ASESOR(:p_nIDASESOR) }", nativeQuery = true) 
	Optional<Asesor> buscarAsesor(@Param("p_nIDASESOR") int p_nIDASESOR);
	
	//Delete
	
	@Query(value = "{ CALL SP_ELIMINAR_ASESOR(:P_IDASESOR) }", nativeQuery = true)
	String eliminarAsesor(@Param("P_IDASESOR") int P_IDASESOR);
	
	// Insertar
	@Query(value = "{ CALL ido_bi_capa.SP_INS_ASESOR(:p_nIdAsesor) }", nativeQuery = true) 
	String insertarAsesor(@Param("p_nIdAsesor") int p_nIdAsesor);
	
	//Update
	@Query(value = "{ CALL SP_UPD_ASESOR(:p_nIdAsesor,:p_nEstado) }", nativeQuery = true) 
	String actualizarAsesor( @Param("p_nIdAsesor") int p_nIdAsesor, @Param("p_nEstado") String p_nEstado );
	

}
