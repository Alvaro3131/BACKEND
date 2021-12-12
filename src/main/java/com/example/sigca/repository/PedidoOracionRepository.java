package com.example.sigca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.sigca.entity.PedidoOracion;
import com.example.sigca.entity.Sesion;

public interface PedidoOracionRepository extends JpaRepository<PedidoOracion, Integer>{
	
	
	@Query(value = "select * from tbl_pedidooracion where FE_PEDIDOORACION=? and FK_PERSONA=?;", nativeQuery = true)
	List<PedidoOracion> listarpedido(String fecha, int idsocio);
		// Listar	
		@Query(value = "{  call SP_LISTAR_TBL_PEDIDOORACION(0) }", nativeQuery = true)
		List<PedidoOracion> listarPedidoOracion();
			
		// Buscar
		@Query(value = "{call SP_LISTAR_PEDIDOORACION(:p_nID)}", nativeQuery = true) 
		PedidoOracion buscarPedidoOracion(@Param("p_nID") int p_nID);
			
		//Delete
		@Query(value = "{ CALL SP_DEL_TBL_PEDIDOORACION(:p_nID) }", nativeQuery = true)
		String eliminarPedidoOracion(@Param("p_nID") int p_nID);
			
		// Insertar
		@Query(value = "{ CALL SP_INS_TBL_PEDIDOORACION(:p_vPEDIDOORACION,:p_nPERSONA) }", nativeQuery = true) 
		String insertarPedidoOracion(@Param("p_vPEDIDOORACION") String p_vDE_PEDIDOORACION, @Param("p_nPERSONA") int id);
			
		//Update
		@Query(value = "{call SP_UPD_MODULO(:p_iIDPEDIDOORACION,:p_vDE_PEDIDOORACION,:p_tPEDIDOORACION)}", nativeQuery = true) 
		String actualizarPedidoOracion(@Param("p_iIDPEDIDOORACION") int p_iIDPEDIDOORACION, @Param("p_vDE_PEDIDOORACION") String p_vDE_PEDIDOORACION, @Param("p_tPEDIDOORACION") String string);
}
