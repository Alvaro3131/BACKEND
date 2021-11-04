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

import com.example.sigca.entity.Pregunta;
import com.example.sigca.serviceImpl.PreguntaServiceImpl;

@RestController
@RequestMapping("/api/pregunta")
public class PreguntaController {

	@Autowired
	private PreguntaServiceImpl preguntaimpl;
	
	//Funciona
			@GetMapping("/all")
			public ResponseEntity<List<Pregunta>> listarPregunta(){
				try {
					List<Pregunta> list = new ArrayList<>();
					list=preguntaimpl.listarPregunta();
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
			public ResponseEntity<Pregunta> buscarPregunta(@PathVariable("id") int id){
				Pregunta pregunta = preguntaimpl.buscarPregunta(id);
				if (pregunta.getId()>0) {
					return new ResponseEntity<>(pregunta,HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
			}
			
			//Funciona
			@PostMapping("/new")
			public ResponseEntity<String> agregarPregunta(@RequestBody Pregunta preg){
				try {
					Pregunta pregunta = new Pregunta(preg.getNombre());
					String mensaje= preguntaimpl.insertarPregunta(pregunta);
					return new ResponseEntity<>(mensaje,HttpStatus.CREATED);
				} catch (Exception e) {
					// TODO: handle exception
					return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			
			
			//Funciona
			@DeleteMapping("/delete/{id}")
			public ResponseEntity<String> eliminarPregunta(@PathVariable("id") int id){
			try {
				String mensaje = preguntaimpl.eliminarPregunta(id);
				return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}	
			}
			
			//Funciona
			@PutMapping("/update/{id}")
			public ResponseEntity<String> actualizarPregunta(@RequestBody Pregunta preg, @PathVariable("id") int id){
			try {
				Pregunta ul = preguntaimpl.buscarPregunta(id);
				if (ul.getId()>0) {
					ul.setNombre(preg.getNombre());
					ul.setRecurso(preg.getRecurso());
					return new ResponseEntity<>(preguntaimpl.actualizarPregunta(ul),HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			}
}
