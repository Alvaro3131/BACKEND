package com.example.sigca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.sigca.entity.Distrito;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Integer>{
	
	// Listar	
	@Query(value = "{ CALL SP_LISTAR_DISTRITO(0) }", nativeQuery = true)
	List<Distrito> listarDistrito();
	
	
	//buscar
	@Query(value = "{call SP_LISTAR_DISTRITO(:p_nIDDISTRITO)}", nativeQuery = true) 
	Optional<Distrito> buscarDistrito(@Param("p_nIDDISTRITO") int p_nIDDISTRITO);
	
}
