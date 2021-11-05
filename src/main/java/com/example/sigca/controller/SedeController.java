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
import com.example.sigca.entity.Sede;
import com.example.sigca.serviceImpl.SedeServiceImpl;

@RestController
@RequestMapping("/api/sede")
public class SedeController {
	
	@Autowired
	private SedeServiceImpl sedeimpl;
	
	//Funciona
	@GetMapping("/all")
	public ResponseEntity<List<Sede>> listarSede(){
		try {
			List<Sede> list = new ArrayList<>();
			list=sedeimpl.ListarSede();
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
	public ResponseEntity<Sede> buscarSede(@PathVariable("id") int id){
		Sede sede = sedeimpl.buscarSede(id);
		if (sede.getId_sede()>0) {
			return new ResponseEntity<>(sede,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	//Funciona
	@PostMapping("/new")
	public ResponseEntity<String> agregarSede(@RequestBody Sede s){
		try {
			Sede sede = new Sede(s.getNo_sede());
			String mensaje= sedeimpl.insertarSede(sede);
			return new ResponseEntity<>(mensaje,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//Funciona
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> eliminarSede(@PathVariable("id") int id){
	try {
		String mensaje = sedeimpl.eliminarSede(id);
		return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	}
	
	//Funciona
	@PutMapping("/update/{id}")
	public ResponseEntity<String> ActualizarSede(@RequestBody Sede s, @PathVariable("id") int id){
	try {
		Sede ul = sedeimpl.buscarSede(id);
		if (ul.getId_sede()>0) {
			ul.setNo_sede(s.getNo_sede());
			return new ResponseEntity<>(sedeimpl.actualizarSede(ul),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	}
	}

