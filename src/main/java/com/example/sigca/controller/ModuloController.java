package com.example.sigca.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sigca.entity.BancoComunal;
import com.example.sigca.entity.Modulo;
import com.example.sigca.serviceImpl.ModuloServiceImpl;

@RestController
@RequestMapping("/api/modulo")
public class ModuloController {
	
	@Autowired
	private ModuloServiceImpl modulo;
	
	//Funciona
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/all")
	public ResponseEntity<List<Modulo>> listarModulo(){
		try {
			List<Modulo> list = new ArrayList<>();
			list=modulo.listarModulo();
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
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/search/{id}")
	public ResponseEntity<Modulo> buscarModulo(@PathVariable("id") int id){
		Modulo m = modulo.buscarModulo(id);
		if (m.getId_modulo()>0) {
			return new ResponseEntity<>(m,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	//Funciona
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/new")
	public ResponseEntity<String> agregarModulo(@RequestBody Modulo m){
		try {
			System.out.println("Pase");
			String mensaje= modulo.insertarModulo(m);
			return new ResponseEntity<>(mensaje,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//Funciona
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> eliminarModulo(@PathVariable("id") int id){
	try {
		String mensaje = modulo.eliminarModulo(id);
		return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	}
	
	//Funciona
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update/{id}")
	public ResponseEntity<String> ActualizarModulo(@RequestBody Modulo m, @PathVariable("id") int id){
	try {
		Modulo ul = modulo.buscarModulo(id);
		if (ul.getId_modulo()>0) {
			ul.setNo_modulo(m.getNo_modulo());
			ul.setCategoria(m.getCategoria());
			return new ResponseEntity<>(modulo.actualizarModulo(ul),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	@GetMapping("/categoria/{id}")
	public ResponseEntity<List<Modulo>> listarModuloCategoria(@PathVariable("id") int id){
		try {
			List<Modulo> list = new ArrayList<>();
			list=modulo.listarModuloCategoria(id);
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
