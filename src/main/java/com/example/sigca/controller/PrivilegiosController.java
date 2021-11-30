package com.example.sigca.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.example.sigca.entity.Privilegios;
import com.example.sigca.service.PrivilegiosService;
import com.example.sigca.serviceImpl.PrivilegiosServiceImpl;


@RestController
@RequestMapping("/api/privilegios")
public class PrivilegiosController {
	
	@Autowired
	private PrivilegiosServiceImpl privilegiosimpl;
	@Autowired
	private PrivilegiosService privilegiosService;
	
	//Funciona
	@GetMapping("/all")
	public ResponseEntity<List<Privilegios>> listarPrivilegios(){
		try {
			List<Privilegios> list = new ArrayList<>();
			list=privilegiosimpl.ListarPrivilegios();
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/usuario/{id}")
	public ResponseEntity<List<Map<String, Object>>> listarPrivilegiosUsuario(@PathVariable("id") int id){
		try {
			List<Map<String,Object>> list = new ArrayList<>();
			list=privilegiosService.ListarPrivilegiosUsuario(id);
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
	public ResponseEntity<Privilegios> buscarPrivilegios(@PathVariable("id") int id){
		Privilegios privilegios = privilegiosimpl.buscarPrivilegios(id);
		if (privilegios.getIdprivilegios()>0) {
			return new ResponseEntity<>(privilegios,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	//Funciona
	@PostMapping("/new")
	public ResponseEntity<String> agregarPrivilegios(@RequestBody Privilegios p){
		try {
			Privilegios privilegios = new Privilegios(p.getNombreprivilegios());
			String mensaje= privilegiosimpl.insertarPrivilegios(privilegios);
			return new ResponseEntity<>(mensaje,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//Funciona
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> eliminarPrivilegios(@PathVariable("id") int id){
	try {
		String mensaje = privilegiosimpl.eliminarPrivilegios(id);
		return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	}
	
	//Funciona
	@PutMapping("/update/{id}")
	public ResponseEntity<String> ActualizarPrivilegios(@RequestBody Privilegios p, @PathVariable("id") int id){
	try {
		Privilegios ul = privilegiosimpl.buscarPrivilegios(id);
		if (ul.getIdprivilegios()>0) {
			ul.getNombreprivilegios();
			return new ResponseEntity<>(privilegiosimpl.actualizarPrivilegios(ul),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	}
	}

