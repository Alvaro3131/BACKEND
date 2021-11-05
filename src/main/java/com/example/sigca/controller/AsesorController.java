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

import com.example.sigca.service.AsesorService;



@RestController
@RequestMapping("/api/asesor")
public class AsesorController {
	@Autowired
	private AsesorService asesorService;
	@GetMapping("/all")
	public ResponseEntity<List<Asesor>> getPersonas(){
		try {
			List<Asesor> list = new ArrayList<>();
			list = asesorService.readall();
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
	public ResponseEntity<Asesor> getUser(@PathVariable("id") int id){
		Asesor asesor = asesorService.read(id);
			if(asesor.getId_persona()>0) {
				return new ResponseEntity<>(asesor, HttpStatus.OK);
			}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	@PostMapping("/insertar")
	public ResponseEntity<Asesor> save(@RequestBody Asesor asesor){
		try {
			Asesor a = new Asesor();
		
			a.setId_persona(asesor.getId_persona());
			a.setEs_asesor(asesor.getEs_asesor());
			Asesor al = asesorService.create(a);
			return new ResponseEntity<>(al, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Asesor> update(@RequestBody Asesor asesor, @PathVariable("id") int id){
		try {
			Asesor a = asesorService.read(id);
			if(a.getId_persona()>0) {
				
				a.setEs_asesor(asesor.getEs_asesor());
				return new ResponseEntity<>(asesorService.create(a),HttpStatus.OK);
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
			asesorService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
