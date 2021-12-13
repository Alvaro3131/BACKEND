package com.example.sigca.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.sigca.entity.AsistenciaRecurso;
import com.example.sigca.entity.Modulo;
import com.example.sigca.serviceImpl.AsistenciaRecursoServiceImpl;

@RestController
@RequestMapping("/api/AsistenciaRecurso")
public class AsistenciaRecursoController {
	
	@Autowired
	private AsistenciaRecursoServiceImpl asistenciaRecursoImpl;
	
	//Funciona
		@GetMapping("/all")
		public ResponseEntity<List<AsistenciaRecurso>> ListarAsistenciaRecurso(){
			try {
				List<AsistenciaRecurso> list = new ArrayList<>();
				list=asistenciaRecursoImpl.ListarAsistenciaRecurso();
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
		public ResponseEntity<AsistenciaRecurso> buscarAsistenciaRecurso(@PathVariable("id") int id){
			AsistenciaRecurso asistenciaRecurso = asistenciaRecursoImpl.buscarAsistenciaRecurso(id);
			if (asistenciaRecurso.getId_asistencia_recurso()>0) {
				return new ResponseEntity<>(asistenciaRecurso,HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
		/*
		//Funciona
		@PostMapping("/new")
		public ResponseEntity<String> agregarAsistenciaRecurso(@RequestBody AsistenciaRecurso s){
			try {
				Sede sede = new Sede(s.get());
				String mensaje= sedeimpl.insertarSede(sede);
				return new ResponseEntity<>(mensaje,HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		*/
		
		//Funciona
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> eliminarAsistenciaRecurso(@PathVariable("id") int id){
		try {
			String mensaje = asistenciaRecursoImpl.eliminarAsistenciaRecurso(id);
			return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		}
		
		//Funciona
		@PutMapping("/update/{id}")
		public ResponseEntity<String> ActualizarAsistenciaRecurso(@RequestBody AsistenciaRecurso s, @PathVariable("id") int id){
		try {
			AsistenciaRecurso ul = asistenciaRecursoImpl.buscarAsistenciaRecurso(id);
			if (ul.getId_asistencia_recurso()>0) {
				ul.setEs_asistencia(s.getEs_asistencia());
				return new ResponseEntity<>(asistenciaRecursoImpl.actualizarAsistenciaRecurso(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		}
		
		
		//Funciona
		@CrossOrigin(origins = "http://localhost:4200")
		@PostMapping("/updateVal/{id}")
		public ResponseEntity<String> ActualizarValoracionRecurso(@RequestBody AsistenciaRecurso ar, @PathVariable("id") int id){
		try {
			AsistenciaRecurso ul = asistenciaRecursoImpl.buscarAsistenciaRecurso(id);
			if (ul.getId_asistencia_recurso()>0) {
				ul.setNu_valoracion(ar.getNu_valoracion());
				return new ResponseEntity<>(asistenciaRecursoImpl.actualizarValoracionRecurso(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
		
		
		
		//Funciona
				@PutMapping("/updateValoracion/{id}")
				public void ActualizarValoracion(@RequestBody AsistenciaRecurso s, @PathVariable("id") int id){
				try {
					AsistenciaRecurso ul = asistenciaRecursoImpl.buscarAsistenciaRecurso(id);
					
					if (ul.getId_asistencia_recurso()>0) {
						System.out.println(ul.getId_asistencia_recurso());
						ul.setNu_valoracion(s.getNu_valoracion());
						ul.setSocio(s.getSocio());
						ul.setRecurso(s.getRecurso());
						asistenciaRecursoImpl.actualizarValoracionAsistencia(ul.getNu_valoracion(), ul.getSocio().getId(), ul.getRecurso().getId());
						
					} 
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				}
		//Funciona
				@PostMapping("/asistencia/{id}")
				public ResponseEntity<String> actualizarAsistencia(@PathVariable("id") int id){
					try {
						System.out.println(id);
						String mensaje=asistenciaRecursoImpl.actualizarEstadoAsistencia(id);
						
						return new ResponseEntity<>(mensaje,HttpStatus.CREATED);
					} catch (Exception e) {
						return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
					}
				
				}
		}

