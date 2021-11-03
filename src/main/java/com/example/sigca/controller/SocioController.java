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

import com.example.sigca.entity.Asesor;
import com.example.sigca.entity.Socio;
import com.example.sigca.service.SocioService;

@RestController
@RequestMapping("/api/socio")
public class SocioController {
@Autowired
private SocioService socioService;
@GetMapping("/all")
public ResponseEntity<List<Socio>> getPersonas(){
	try {
		List<Socio> list = new ArrayList<>();
		list = socioService.readall();
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
public ResponseEntity<Socio> getUser(@PathVariable("id") int id){
	Socio socio = socioService.read(id);
		if(socio.getId()>0) {
			return new ResponseEntity<>(socio, HttpStatus.OK);
		}else {
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
}
@PostMapping("/insertar")
public ResponseEntity<Socio> save(@RequestBody Socio socio){
	try {
		Socio a = new Socio();
		
		a.setId(socio.getId());
		a.setEstado(socio.getEstado());
		Socio al = socioService.create(a);
		return new ResponseEntity<>(al, HttpStatus.CREATED);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@PutMapping("/update/{id}")
public ResponseEntity<Socio> update(@RequestBody Socio socio, @PathVariable("id") int id){
	try {
		Socio a = socioService.read(id);
		if(a.getId()>0) {
			
			a.setEstado(socio.getEstado());
			return new ResponseEntity<>(socioService.create(a),HttpStatus.OK);
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
		socioService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
}
