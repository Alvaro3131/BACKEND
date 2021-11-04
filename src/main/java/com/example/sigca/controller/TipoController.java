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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sigca.entity.Tipo;
import com.example.sigca.serviceImpl.TipoServiceImpl;

@RestController
@RequestMapping("/api/tipo")
public class TipoController {

	@Autowired
	private TipoServiceImpl tipoimpl;
	
	//Funciona
		@GetMapping("/all")
		public ResponseEntity<List<Tipo>> listarTipo(){
			try {
				List<Tipo> list = new ArrayList<>();
				list=tipoimpl.listarTipo();
				if (list.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(list,HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		//Funciona
		@GetMapping("/search/{id}")
		public ResponseEntity<Tipo> buscarTipo(@PathVariable("id") int id){
			Tipo tipo = tipoimpl.buscarTipo(id);
			if (tipo.getId_tipo()>0) {
				return new ResponseEntity<>(tipo,HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
		
		//Funciona
		@PostMapping("/new")
		public ResponseEntity<String> agregarTipo(@RequestBody Tipo tip){
			try {
				Tipo tipo = new Tipo(tip.getNombre());
				String mensaje= tipoimpl.insertarTipo(tipo);
				return new ResponseEntity<>(mensaje,HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
		//Funciona
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> eliminarTipo(@PathVariable("id") int id){
		try {
			String mensaje = tipoimpl.eliminarTipo(id);
			return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		}
		
		//Funciona
		@PutMapping("/update/{id}")
		public ResponseEntity<String> actualizarTipo(@RequestBody Tipo tip, @PathVariable("id") int id){
		try {
			Tipo ul = tipoimpl.buscarTipo(id);
			if (ul.getId_tipo()>0) {
				ul.setNombre(tip.getNombre());
				return new ResponseEntity<>(tipoimpl.actualizarTipo(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		}
}
