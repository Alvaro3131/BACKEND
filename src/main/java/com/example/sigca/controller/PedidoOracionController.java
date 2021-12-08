package com.example.sigca.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.sigca.entity.PedidoOracion;
import com.example.sigca.serviceImpl.PedidoOracionServiceImpl;

@RestController
@RequestMapping("/api/pedidooracion")
public class PedidoOracionController {

	@Autowired
	private PedidoOracionServiceImpl pedidoOracionimpl;
	
	@GetMapping("/all")
	public ResponseEntity<List<PedidoOracion>> listarPedidoOracion(){
		try {
			List<PedidoOracion> list = new ArrayList<>();
			list=pedidoOracionimpl.listarPedidoOracion();
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/buscar/{fecha}/{id}")
	public ResponseEntity<List<PedidoOracion>> listarPedidoOracion(@PathVariable("fecha") String fecha,@PathVariable("id") int id){
		try {
			List<PedidoOracion> list = new ArrayList<>();
			list=pedidoOracionimpl.listaPedido(fecha,id);
			System.out.println(fecha);
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<PedidoOracion> buscarPedidoOracion(@PathVariable("id") int id){
		PedidoOracion pedidoOracion = pedidoOracionimpl.buscarPedidoOracion(id);
		if (pedidoOracion.getId_pedidooracion()>0) {
			return new ResponseEntity<>(pedidoOracion,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/new")
	public ResponseEntity<String> agregarPedidoOracion(@RequestBody PedidoOracion po){
		try {
			if (po.getDe_pedidooracion() !=null) {
				
				String pe= pedidoOracionimpl.insertarPedidoOracion(po);
				return new ResponseEntity<String>(pe,HttpStatus.CREATED);					
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> eliminarPedidoOracion(@PathVariable("id") int id){
	try {
		String mensaje = pedidoOracionimpl.eliminarPedidoOracion(id);
		return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	public ResponseEntity<String> ActualizarPedidoOracion(@RequestBody PedidoOracion po, @PathVariable("id") int id){
		try {
			PedidoOracion ul = pedidoOracionimpl.buscarPedidoOracion(id);
			if (ul.getId_pedidooracion()>0) {
				ul.setDe_pedidooracion(null);
				ul.setFe_pedidooracion(null);
				return new ResponseEntity<>(pedidoOracionimpl.actualizarPedidoOracion(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		}	
}
