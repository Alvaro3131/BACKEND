package com.example.sigca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.sigca.entity.Modulo;
import com.example.sigca.entity.PedidoOracion;

public interface PedidoOracionRepository extends JpaRepository<PedidoOracion, Integer>{

		// Listar	
		@Query(value = "{ CALL SP_LISTAR_PEDIDOORACION(0) }", nativeQuery = true)
		List<PedidoOracion> listarPedidoOracion();
			
		// Buscar
		@Query(value = "{call SP_LISTAR_PEDIDOORACION(:p_nID)}", nativeQuery = true) 
		Modulo buscarPedidoOracion(@Param("p_nID") int p_nID);
			
		//Delete
		@Query(value = "{ CALL SP_DEL_TBL_PEDIDOORACION(:p_nID) }", nativeQuery = true)
		String eliminarPedidoOracion(@Param("p_nID") int p_nID);
			
		// Insertar
		@Query(value = "{call SP_INS_TBL_PEDIDOORACION(:p_vPEDIDOORACION,:p_nPERSONA)}", nativeQuery = true) 
		String insertarPedidoOracion(@Param("p_vPEDIDOORACION") String P_PEDIDOORAION, @Param("p_nPERSONA") int P_PERSONA);
			
		//Update
		@Query(value = "{call SP_UPD_MODULO(:p_vID,:p_vPEDIDOORACION,:p_nPERSONA)}", nativeQuery = true) 
		String actualizarPedidoOracion(@Param("p_vID") int P_ID ,@Param("p_vPEDIDOORACION") String P_PEDIDOORACION,@Param("p_nPERSONA") int P_PERSONA);
}
