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

import com.example.sigca.entity.Alternativa;
import com.example.sigca.serviceImpl.AlternativaServiceImpl;

@RestController
@RequestMapping
public class AlternativaController {

	@Autowired
	private AlternativaServiceImpl alternativaimpl;
	
	//Funciona
			@GetMapping("/all")
			public ResponseEntity<List<Alternativa>> listarAlternativa(){
				try {
					List<Alternativa> list = new ArrayList<>();
					list=alternativaimpl.listarAlternativa();
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
			public ResponseEntity<Alternativa> buscarAlternativa(@PathVariable("id") int id){
				Alternativa alternativa = alternativaimpl.buscarAlternativa(id);
				if (alternativa.getId()>0) {
					return new ResponseEntity<>(alternativa,HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
			}
			
			//Funciona
			@PostMapping("/new")
			public ResponseEntity<String> agregarAlternativa(@RequestBody Alternativa alt){
				try {
					Alternativa alternativa = new Alternativa(alt.getNombre(), alt.getValor(), alt.getPregunta());
					String mensaje= alternativaimpl.insertarAlternativa(alternativa);
					return new ResponseEntity<>(mensaje,HttpStatus.CREATED);
				} catch (Exception e) {
					// TODO: handle exception
					return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			
			
			//Funciona
			@DeleteMapping("/delete/{id}")
			public ResponseEntity<String> eliminarAlternativa(@PathVariable("id") int id){
			try {
				String mensaje = alternativaimpl.eliminarAlternativa(id);
				return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}	
			}
			
			//Funciona
			@PutMapping("/update/{id}")
			public ResponseEntity<String> ActualizarAlternativa(@RequestBody Alternativa alt, @PathVariable("id") int id){
			try {
				Alternativa ul = alternativaimpl.buscarAlternativa(id);
				if (ul.getId()>0) {
					ul.setNombre(alt.getNombre());
					ul.setValor(alt.getValor());
					ul.setPregunta(alt.getPregunta());
					return new ResponseEntity<>(alternativaimpl.actualizarAlternativa(ul),HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			}
}
