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

import com.example.sigca.entity.RolPrivilegios;
import com.example.sigca.entity.RolUsuario;
import com.example.sigca.serviceImpl.RolUsuarioServiceImpl;



@RestController
@RequestMapping("/api/rolusuario")
public class RolUsuarioController {
	
	@Autowired
	private RolUsuarioServiceImpl rolusuarioimpl;
	
	//Funciona
	@GetMapping("/all")
	public ResponseEntity<List<RolUsuario>> listarRolUsuario(){
		try {
			List<RolUsuario> list = new ArrayList<>();
			list=rolusuarioimpl.listarRolUsuario();
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
	public ResponseEntity<RolUsuario> buscarRolUsuario(@PathVariable("id") int id){
		RolUsuario rolusuario = rolusuarioimpl.buscarRolUsuario(id);
		if (rolusuario.getIdrolusuario()>0) {
			return new ResponseEntity<>(rolusuario,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	//Funciona	
	@PostMapping("/new")
	public ResponseEntity<String> agregarRolUsuario(@RequestBody RolUsuario u){
		try {			
			String mensaje= rolusuarioimpl.insertarRolUsuario(u);
			return new ResponseEntity<>(mensaje,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Funciona
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> eliminarRolUsuario(@PathVariable("id") int id){
	try {
		String mensaje = rolusuarioimpl.eliminarRolUsuario(id);
		return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	}
	
	//Funciona
	@PutMapping("/update/{id}")
	public ResponseEntity<String> ActualizarRolUsuario(@RequestBody RolUsuario u, @PathVariable("id") int id){
	try {
		RolUsuario ul = rolusuarioimpl.buscarRolUsuario(id);
		if (ul.getIdrolusuario()>0) {
			;
			return new ResponseEntity<>(rolusuarioimpl.actualizarRolUsuario(ul),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	}
	}

