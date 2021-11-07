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
import com.example.sigca.entity.Seminario;
import com.example.sigca.serviceImpl.SeminarioServiceImpl;

@RestController
@RequestMapping("/api/seminario")
public class SeminarioController {
	@Autowired
	private SeminarioServiceImpl seminarioimpl;
	
	@GetMapping("/all")
	public ResponseEntity<List<Seminario>> listarSeminario(){
		try {
			List<Seminario> list = new ArrayList<>();
			list=seminarioimpl.listarSeminario();
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<Seminario> buscarSeminario(@PathVariable("id") int id){
		Seminario seminario = seminarioimpl.buscarSeminario(id);
		if (seminario.getID_SEMINARIO()>0) {
			return new ResponseEntity<>(seminario,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	@PostMapping("/new")
	public ResponseEntity<String> agregarSeminario(@RequestBody Seminario se){
		try {
			Seminario seminario = new Seminario(se.getNO_SEMINARIO(),se.getFE_INICIO(),se.getFE_FIN(),se.getURL_SEMINARIO());
			String mensaje= seminarioimpl.insertarSeminario(seminario);
			return new ResponseEntity<>(mensaje,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> eliminarSeminario(@PathVariable("id") int id){
	try {
		String mensaje = seminarioimpl.eliminarSeminario(id);
		return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> ActualizarSede(@RequestBody Seminario se, @PathVariable("id") int id){
	try {
		Seminario ul = seminarioimpl.buscarSeminario(id);
		if (ul.getID_SEMINARIO()>0) {
			ul.setNO_SEMINARIO(se.getNO_SEMINARIO());
			ul.setFE_INICIO(se.getFE_INICIO());
			ul.setFE_FIN(se.getFE_FIN());
			ul.setURL_SEMINARIO(se.getURL_SEMINARIO());
			return new ResponseEntity<>(seminarioimpl.actualizarSeminario(ul),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	}
}
