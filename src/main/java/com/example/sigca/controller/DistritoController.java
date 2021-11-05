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
import com.example.sigca.entity.Distrito;
import com.example.sigca.entity.Sede;
import com.example.sigca.serviceImpl.DistritoServiceImpl;

@RestController
@RequestMapping("/api/distrito")
public class DistritoController {
	
	@Autowired
	private DistritoServiceImpl distrito;
	
	//Funciona
		@GetMapping("/all")
		public ResponseEntity<List<Distrito>> listarDistrito(){
			try {
				List<Distrito> list = new ArrayList<>();
				list=distrito.listarDistrito();
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
		public ResponseEntity<Distrito> buscarDistrito(@PathVariable("id") int id){
			Distrito d = distrito.buscarDistrito(id);
			if (d.getId_distrito()>0) {
				return new ResponseEntity<>(d,HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
		
		//Funciona
		@PostMapping("/new")
		public ResponseEntity<String> agregarDistrito(@RequestBody Distrito d){
			try {
				if (d.getNo_distrito() !=null) {
					System.out.println(d.getSede().getId_sede());
					String mensaje= distrito.insertarDistrito(d);
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
		public ResponseEntity<String> eliminarDistrito(@PathVariable("id") int id){
		try {
			String mensaje = distrito.eliminarDistrito(id);
			return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		}
		
		//Funciona
		@PutMapping("/update/{id}")
		public ResponseEntity<String> ActualizarDistrito(@RequestBody Distrito d, @PathVariable("id") int id){
		try {
			System.out.println(id +" "+d.getNo_distrito());
			Distrito ul = distrito.buscarDistrito(id);
			if (ul.getId_distrito()>0) {
				ul.setNo_distrito(d.getNo_distrito());
				ul.setSede(d.getSede());
				return new ResponseEntity<>(distrito.ActualizarDistrito(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		}
	
}
