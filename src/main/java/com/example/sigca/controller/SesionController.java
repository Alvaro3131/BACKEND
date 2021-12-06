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
import com.example.sigca.entity.Sesion;
import com.example.sigca.service.SesionService;

@RestController
@RequestMapping("/api/sesion")
public class SesionController {
	
	@Autowired
	private SesionService sesionImpl;
	
	//Funciona
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/modulo/{id}")
	public ResponseEntity<List<Sesion>> listarSesionModulo(@PathVariable("id") int id){
		try {
			List<Sesion> list = new ArrayList<>();
			list=sesionImpl.listarSesionModulo(id);
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//listarSesiones
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/modulo2/{id}")
	public ResponseEntity<List<Sesion>> listarSesiones(@PathVariable("id") int id){
		try {
			List<Sesion> list = new ArrayList<>();
			list=sesionImpl.listarSesiones(id);
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/all")
	public ResponseEntity<List<Sesion>> listarSesion(){
		try {
			List<Sesion> list = new ArrayList<>();
			list = sesionImpl.ListarSesion();
			System.out.println(list.get(1).getNO_SESION());
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Funciona 
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/search/{id}")
	public ResponseEntity<Sesion> buscarSesion(@PathVariable("id") int id){
		Sesion sesion = sesionImpl.buscarSesion(id);
		if (sesion.getID_SESION()>0) {
			return new ResponseEntity<>(sesion,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	//Funciona
	@CrossOrigin(origins = "http://localhost:4200")
		@PostMapping("/new")
		public ResponseEntity<String> agregarSesion(@RequestBody Sesion s){
			try {
				String mensaje= sesionImpl.insertarSesion(s);
				return new ResponseEntity<>(mensaje,HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> eliminarSesion(@PathVariable("id") int id){
	try {
		String mensaje = sesionImpl.eliminarSesion(id);
		return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update/{id}")
	public ResponseEntity<String> ActualizarSesion(@RequestBody Sesion s, @PathVariable("id") int id){
	try {
		Sesion ul = sesionImpl.buscarSesion(id);
		if (ul.getID_SESION()>0) {
			ul.setNO_SESION(s.getNO_SESION());
			return new ResponseEntity<>(sesionImpl.actualizarSesion(ul),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
}
