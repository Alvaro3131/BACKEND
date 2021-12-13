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

import com.example.sigca.entity.AsistenciaSeminario;
import com.example.sigca.service.AsistenciaSeminarioService;
import com.example.sigca.service.ParticipacionService;
import com.example.sigca.serviceImpl.AsistenciaSeminarioServiceImpl;

@RestController
@RequestMapping("/api/asistenciaseminario")
public class AsistenciaSeminarioController {

	@Autowired
	private AsistenciaSeminarioServiceImpl asistencia;
	@Autowired
	private AsistenciaSeminarioService asistenciaSeminarioService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<AsistenciaSeminario>> listarAsistenciaSeminario(){
		try {
			System.out.println("asasasas");
			List<AsistenciaSeminario> list = new ArrayList<>();
			
			list = asistenciaSeminarioService.listar();
			
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/validacion/{seminario}/{socio}")
	public ResponseEntity<List<AsistenciaSeminario>> listado(@PathVariable("seminario") int seminario,@PathVariable("socio") int socio){
		try {
			System.out.println("asasasas");
			List<AsistenciaSeminario> list = new ArrayList<>();
			
			list = asistenciaSeminarioService.listarasistencia(seminario, socio);
			
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/search/{id}")
	public ResponseEntity<AsistenciaSeminario> buscarAsistenciaSeminario(@PathVariable("id") int id){
		AsistenciaSeminario asistenciaSeminario= asistencia.buscarAsistenciaSeminario(id);
		if (asistenciaSeminario.getID_ASISTENCIA_SEMINARIO()>0) {
			return new ResponseEntity<>(asistenciaSeminario,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/new")
	public ResponseEntity<String> agregarAsistenciaSeminario(@RequestBody AsistenciaSeminario s){
		try {
			String mensaje= asistencia.insertarAsistenciaSeminario(s);
			return new ResponseEntity<>(mensaje,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> eliminarAsistenciaSeminario(@PathVariable("id") int id){
		try {
			String mensaje = asistencia.eliminarAsistenciaSeminario(id);
			return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> ActualizarAsistenciaSeminario(@RequestBody AsistenciaSeminario s, @PathVariable("id") int id){
		try {
			AsistenciaSeminario ul = asistencia.buscarAsistenciaSeminario(id);
			if (ul.getID_ASISTENCIA_SEMINARIO()>0) {
				ul.setES_ASISTENCIA(id);
				ul.setDE_ASISTENCIA(null);
				ul.setFE_ASISTENCIA(null);
				return new ResponseEntity<>(asistencia.actualizarAsistenciaSeminario(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
