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


import com.example.sigca.entity.Persona;
import com.example.sigca.service.PersonaService;
import com.example.sigca.serviceImpl.PersonaServiceImpl;


@RestController
@RequestMapping("/api/persona")
public class PersonaController {
	@Autowired
	private PersonaService personaService;
	@GetMapping("/all")
	public ResponseEntity<List<Persona>> getAlumnos(){
		try {
			List<Persona> list = new ArrayList<>();
			list = personaService.readall();
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
	public ResponseEntity<Persona> getUser(@PathVariable("id") int id){
		Persona persona = personaService.read(id);
			if(persona.getId()>0) {
				return new ResponseEntity<>(persona, HttpStatus.OK);
			}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	@PostMapping("/insertar")
	public ResponseEntity<Persona> save(@RequestBody Persona persona){
		try {
			Persona a = new Persona();
			
			a.setNombre(persona.getNombre());
			a.setPaterno(persona.getPaterno());
			a.setMaterno(persona.getMaterno());
			a.setDni(persona.getDni());
			a.setCorreo(persona.getCorreo());
			a.setTelefono(persona.getTelefono());
			Persona al = personaService.create(a);
			return new ResponseEntity<>(al, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Persona> update(@RequestBody Persona persona, @PathVariable("id") int id){
		try {
			Persona a = personaService.read(id);
			if(a.getId()>0) {
				
				
				a.setNombre(persona.getNombre());
				a.setPaterno(persona.getPaterno());
				a.setMaterno(persona.getMaterno());
				a.setDni(persona.getDni());
				a.setCorreo(persona.getCorreo());
				a.setTelefono(persona.getTelefono());
				return new ResponseEntity<>(personaService.create(a),HttpStatus.OK);
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
			personaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
