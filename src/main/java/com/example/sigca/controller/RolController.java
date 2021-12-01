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


import com.example.sigca.entity.Rol;

import com.example.sigca.serviceImpl.RolServiceImpl;


@RestController
@RequestMapping("/api/rol")
public class RolController {
	
	@Autowired
	private RolServiceImpl rolimpl;
	
	//Funciona
	@GetMapping("/all")
	public ResponseEntity<List<Rol>> listarRol(){
		try {
			List<Rol> list = new ArrayList<>();
			list=rolimpl.listarRol();
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
	@GetMapping("/roles/{id}")
	public ResponseEntity<List<Rol>> listarRoles(@PathVariable("id") int id){
		try {
			List<Rol> list = new ArrayList<>();
			list=rolimpl.listarRoles(id);
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
	public ResponseEntity<Rol> buscarRol(@PathVariable("id") int id){
		Rol rol = rolimpl.buscarRol(id);
		if (rol.getIdrol()>0) {
			return new ResponseEntity<>(rol,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	//Funciona
	@PostMapping("/new")
	public ResponseEntity<String> agregarRol(@RequestBody Rol r){
		try {
			Rol rol = new Rol(r.getNombrerol());
			String mensaje= rolimpl.insertarRol(rol);
			return new ResponseEntity<>(mensaje,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//Funciona
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> eliminarRol(@PathVariable("id") int id){
	try {
		String mensaje = rolimpl.eliminarRol(id);
		return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	}
	
	//Funciona
	@PutMapping("/update/{id}")
	public ResponseEntity<String> actualizarRol(@RequestBody Rol r, @PathVariable("id") int id){
	try {
		Rol ul = rolimpl.buscarRol(id);
		if (ul.getIdrol()>0) {
			ul.getNombrerol();
			return new ResponseEntity<>(rolimpl.actualizarRol(ul),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	}
	}

