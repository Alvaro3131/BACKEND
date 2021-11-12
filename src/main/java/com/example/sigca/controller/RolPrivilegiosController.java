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
import com.example.sigca.serviceImpl.RolPrivilegiosServiceImpl;



@RestController
@RequestMapping("/api/rolprivilegios")
public class RolPrivilegiosController {
	
	@Autowired
	private RolPrivilegiosServiceImpl rolprivilegiosimpl;
	
	//Funciona
	@GetMapping("/all")
	public ResponseEntity<List<RolPrivilegios>> listarRolPrivilegios(){
		try {
			List<RolPrivilegios> list = new ArrayList<>();
			list=rolprivilegiosimpl.listarRolPrivilegios();
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
	public ResponseEntity<RolPrivilegios> buscarRolPrivilegios(@PathVariable("id") int id){
		RolPrivilegios rolprivilegios = rolprivilegiosimpl.buscarRolPrivilegios(id);
		if (rolprivilegios.getIdrolprivilegios()>0) {
			return new ResponseEntity<>(rolprivilegios,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	/*
	//Funciona
	@PostMapping("/new")
	public ResponseEntity<String> agregarRolPrivilegios(@RequestBody RolPrivilegios i){
		try {
			RolPrivilegios rolprivilegios = new RolPrivilegios(i.);
			String mensaje= rolprivilegiosimpl.insertarRolPrivilegios(rolprivilegios);
			return new ResponseEntity<>(mensaje,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/
	
	//Funciona
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> eliminarRolPrivilegios(@PathVariable("id") int id){
	try {
		String mensaje = rolprivilegiosimpl.eliminarRolPrivilegios(id);
		return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	}
	
	//Funciona
	@PutMapping("/update/{id}")
	public ResponseEntity<String> actualizarRolPrivilegios(@RequestBody RolPrivilegios i, @PathVariable("id") int id){
	try {
		RolPrivilegios ul = rolprivilegiosimpl.buscarRolPrivilegios(id);
		if (ul.getIdrolprivilegios()>0) {
			;
			return new ResponseEntity<>(rolprivilegiosimpl.actualizarRolPrivilegios(ul),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	}
	}

