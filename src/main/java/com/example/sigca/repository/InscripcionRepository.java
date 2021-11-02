package com.example.sigca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sigca.entity.Inscripcion;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Integer> {

	// Listar
	@Query(value = "{ CALL SP_LISTAR_INSCRIPCION}", nativeQuery = true)
	List<Inscripcion> listarInscripcion();
	
	// Buscar
	@Query(value = "{ CALL SP_LISTAR_INSCRIPCION(:p_nIdInscripcion) }", nativeQuery = true)
	Optional<Inscripcion> buscarInscripcion(@Param("p_nIdInscripcion") int p_nIdInscripcion);
	
	// Delete
	@Query(value = "{ CALL SP_ELIMINAR_INSCRIPCION(:p_nIdInscripcion) }", nativeQuery = true)
	String eliminarInscripcion(@Param("p_nIdInscripcion") int p_nIdInscripcion);
	
	// Insertar
	@Query(value = "{call SP_INS_INSCRIPCION(:p_nRecursosVistos, :p_nIdSocio, :p_nIdModulo)}", nativeQuery = true) 
	String insertarInscripcion(@Param("p_nRecursosVistos") int p_nRecursosVistos, @Param("p_nIdSocio") int p_nIdSocio, @Param("p_nIdModulo") int p_nIdModulo);
	
	//Actualizar
	@Query(value = "{call SP_UPD_INSCRIPCION(:p_nIdInscripcion, :p_nRecursosVistos, :p_nIdSocio, :p_nIdModulo)}", nativeQuery = true) 
	String actualizarInscripcion(@Param("p_nIdInscripcion") int p_nIdInscripcion , @Param("p_nRecursosVistos") int p_nRecursosVistos, @Param("p_nIdSocio") int p_nIdSocio, @Param("p_nIdModulo") int p_nIdModulo);
}
