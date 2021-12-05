package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.PedidoOracion;
import com.example.sigca.repository.PedidoOracionRepository;
import com.example.sigca.service.PedidoOracionService;

@Service
public class PedidoOracionServiceImpl implements PedidoOracionService{

	@Autowired
	private PedidoOracionRepository pedidoOracion;
	
	@Override
	public String insertarPedidoOracion(PedidoOracion po) {
		return pedidoOracion.insertarPedidoOracion(po.getDe_pedidooracion(), po.getSocio().getId());
	}
	
	@Override
	public List<PedidoOracion> listarPedidoOracion(){
		return pedidoOracion.listarPedidoOracion();
	}
	
	@Override
	public PedidoOracion buscarPedidoOracion(int id_pedidooracion) {
		return pedidoOracion.buscarPedidoOracion(id_pedidooracion);
	}
	
	@Override
	public String eliminarPedidoOracion(int id_pedidooracion) {
		System.out.println(id_pedidooracion);
		return pedidoOracion.eliminarPedidoOracion(id_pedidooracion);
	}
	
	@Override
	public String actualizarPedidoOracion(PedidoOracion po) {
		return pedidoOracion.actualizarPedidoOracion(po.getId_pedidooracion(), po.getDe_pedidooracion(), po.getFe_pedidooracion());
	}
}
