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
import com.example.sigca.entity.Recurso;
import com.example.sigca.serviceImpl.RecursoServiceImpl;

@RestController
@RequestMapping("/api/recursos")
public class RecursoController {

	@Autowired
	private RecursoServiceImpl recursoimpl;
	
	//Funciona
		@GetMapping("/all")
		public ResponseEntity<List<Recurso>> listarRecurso(){
			try {
				List<Recurso> list = new ArrayList<>();
				list=recursoimpl.listarRecurso();
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
		public ResponseEntity<Recurso> buscarRecurso(@PathVariable("id") int id){
			Recurso recurso = recursoimpl.buscarRecurso(id);
			if (recurso.getId()>0) {
				return new ResponseEntity<>(recurso,HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
		
		//Funciona
		@PostMapping("/new")
		public ResponseEntity<String> agregarRecurso(@RequestBody Recurso rec){
			try {
				Recurso r = new Recurso(rec.getNombrerecurso(), rec.getOrden(), rec.getDescripcion(), rec.getSesion(), rec.getTipo());
				String mensaje= recursoimpl.insertarRecurso(r);
				return new ResponseEntity<>(mensaje,HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
		//Funciona
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> eliminarRecurso(@PathVariable("id") int id){
		try {
			String mensaje = recursoimpl.eliminarRecurso(id);
			return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		}
		
		//Funciona
		@PutMapping("/update/{id}")
		public ResponseEntity<String> ActualizarRecurso(@RequestBody Recurso rec, @PathVariable("id") int id){
		try {
			Recurso ul = recursoimpl.buscarRecurso(id);
			if (ul.getId()>0) {
				ul.setNombrerecurso(rec.getNombrerecurso());
				ul.setOrden(rec.getOrden());
				ul.setDescripcion(rec.getDescripcion());
				ul.setTipo(rec.getTipo());
				ul.setSesion(rec.getSesion());
				return new ResponseEntity<>(recursoimpl.actualizarRecurso(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		}
	
}
