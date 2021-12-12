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
import com.example.sigca.entity.Seminario;
import com.example.sigca.service.SeminarioService;
import com.example.sigca.serviceImpl.SeminarioServiceImpl;

@RestController
@RequestMapping("/api/seminario")
public class SeminarioController {
	
	@Autowired
	private SeminarioServiceImpl seminario;
	
	@Autowired
	private SeminarioService seminarioService;
	
	
	//Funciona
			@GetMapping("/all")
			public ResponseEntity<List<Seminario>> listarSeminario(){
				try {
					List<Seminario> list = new ArrayList<>();
					list=seminarioService.listarSeminario();
					if (list.isEmpty()) {
						return new ResponseEntity<>(HttpStatus.NO_CONTENT);
					}
					return new ResponseEntity<>(list,HttpStatus.OK);
				} catch (Exception e) {
					// TODO: handle exception
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			@GetMapping("/fecha/{fecha}")
			public ResponseEntity<List<Seminario>> listarSeminarioFecha(@PathVariable("fecha") String fecha){
				try {
					String fecha1=fecha+'%';
					System.out.println(fecha1);
					List<Seminario> list = new ArrayList<>();
					list=seminarioService.listarSeminarioFecha(fecha1);
					if (list.isEmpty()) {
						return new ResponseEntity<>(HttpStatus.NO_CONTENT);
					}
					return new ResponseEntity<>(list,HttpStatus.OK);
				} catch (Exception e) {
					// TODO: handle exception
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			@GetMapping("/socio/{id}")
			public ResponseEntity<List<Seminario>> listarSeminarioSocio(@PathVariable("id") int id){
				try {
					List<Seminario> list = new ArrayList<>();
					list=seminarioService.listarSeminarioSocio(id);
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
			public ResponseEntity<Seminario> buscarSeminario(@PathVariable("id") int id){
				Seminario s = seminario.buscarSeminario(id);
				if (s.getID_SEMINARIO()>0) {
					return new ResponseEntity<>(s,HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
			}
			
			//Funciona
			@PostMapping("/new")
			public ResponseEntity<String> agregarSeminario(@RequestBody Seminario s){
				try {
					if (s.getNO_SEMINARIO() !=null) {
						String mensaje= seminario.insertarSeminario(s);
						return new ResponseEntity<>(mensaje,HttpStatus.CREATED);					
					}
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				} catch (Exception e) {
					// TODO: handle exception
					return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			
			
			//Funciona
			@DeleteMapping("/delete/{id}")
			public ResponseEntity<String> eliminarSeminario(@PathVariable("id") int id){
			try {
				String mensaje = seminario.eliminarSeminario(id);
				return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}	
			}
			
			//Funciona
			@PutMapping("/update/{id}")
			public ResponseEntity<String> ActualizarSeminario(@RequestBody Seminario s, @PathVariable("id") int id){
			try {
				Seminario ul = seminario.buscarSeminario(id);
				if (ul.getID_SEMINARIO()>0) {
					ul.setNO_SEMINARIO(s.getNO_SEMINARIO());
					ul.setFE_INICIO(s.getFE_INICIO());
					ul.setFE_FIN(s.getFE_FIN());
					ul.setURL_SEMINARIO(s.getURL_SEMINARIO());
					return new ResponseEntity<>(seminario.actualizarSeminario(ul),HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			}

}
