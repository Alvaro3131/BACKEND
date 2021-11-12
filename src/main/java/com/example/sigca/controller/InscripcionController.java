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

import com.example.sigca.entity.Inscripcion;
import com.example.sigca.service.InscripcionService;

@RestController
@RequestMapping("/api/inscripcion")
public class InscripcionController {
	@Autowired
	private InscripcionService inscripcionService;
	@GetMapping("/all")
	public ResponseEntity<List<Inscripcion>> getPersona(){
		try {
			List<Inscripcion> list = new ArrayList<>();
			list = inscripcionService.readall();
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/read/{id}")
	public ResponseEntity<Inscripcion> getPersona(@PathVariable("id") int id){
		Inscripcion inscripcion = inscripcionService.read(id);
			if(inscripcion.getId()>0) {
				return new ResponseEntity<>(inscripcion, HttpStatus.OK);
			}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	@PostMapping("/insertar")
	public ResponseEntity<Inscripcion> save(@RequestBody Inscripcion inscripcion){
		try {
			Inscripcion a = new Inscripcion();
			
			a.setRecursosvistos(inscripcion.getRecursosvistos());
			a.setEstado(inscripcion.getEstado());
			a.setModulo(inscripcion.getModulo());
			a.setSocio(inscripcion.getSocio());
			Inscripcion al = inscripcionService.create(a);
			return new ResponseEntity<>(al, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Inscripcion> update(@RequestBody Inscripcion inscripcion, @PathVariable("id") int id){
		try {
			Inscripcion a = inscripcionService.read(id);
			if(a.getId()>0) {
				
				a.setRecursosvistos(inscripcion.getRecursosvistos());
				a.setEstado(inscripcion.getEstado());
				a.setModulo(inscripcion.getModulo());
				a.setSocio(inscripcion.getSocio());
				return new ResponseEntity<>(inscripcionService.create(a),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			inscripcionService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
