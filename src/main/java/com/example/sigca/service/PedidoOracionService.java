package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.PedidoOracion;

public interface PedidoOracionService {
	
	String insertarPedidoOracion (PedidoOracion po);
	List<PedidoOracion> listarPedidoOracion();
	PedidoOracion buscarPedidoOracion(int id_pedidooracion);
	String eliminarPedidoOracion(int id_pedidooracion);
	String actualizarPedidoOracion(PedidoOracion po);
}
