package com.example.sigca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sigca.entity.Alternativa;

@Repository
public interface AlternativaRepository extends JpaRepository<Alternativa, Integer> {
	
	// Listar
	@Query(value = "{ CALL SP_LISTAR_ALTERNATIVA }", nativeQuery = true)
	List<Alternativa> listarAlternativa();
	
	// Buscar
	@Query(value = "{ CALL SP_LISTAR_ALTERNATIVA(:p_nIDALTERNATIVA) }", nativeQuery = true)
	Optional<Alternativa> buscarAlternativa(@Param("p_nIDALTERNATIVA") int p_nIDALTERNATIVA);
	
	// Delete
	@Query(value = "{ CALL SP_ELIMINAR_ALTERNATIVA(:p_nIDALTERNATIVA) }", nativeQuery = true)
	String eliminarTipo(@Param("p_nIDALTERNATIVA") int p_nIDALTERNATIVA);
	
	// Insertar
	@Query(value = "{call SP_INS_ALTERNATIVA(:p_vNombre, :p_nValor, :p_nIdPregunta)}", nativeQuery = true) 
	String insertarAlternativa(@Param("p_vNombre") String p_vNombre, @Param("p_nValor") int p_nValor, @Param("p_nIdPregunta") int p_nIdPregunta);
	
	//Actualizar
	@Query(value = "{call SP_UPD_ALTERNATIVA(:p_nID,:p_vNombre, :p_nAlternativa, :p_nIdPregunta )}", nativeQuery = true) 
	String actualizarAlternativa(@Param("p_nID") int p_nID ,@Param("p_vNombre") String p_vNombre, @Param("p_nValor") int p_nValor, @Param("p_nIdPregunta") int p_nIdPregunta);
	
}
