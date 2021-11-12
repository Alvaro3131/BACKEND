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
import com.example.sigca.entity.ProgramaSeminario;
import com.example.sigca.serviceImpl.ProgramaSeminarioServiceImpl;


@RestController
@RequestMapping("/api/programaSeminario")
public class ProgramaSeminarioController {

	@Autowired
	private ProgramaSeminarioServiceImpl psi;
	
	//Funciona
			@GetMapping("/all")
			public ResponseEntity<List<ProgramaSeminario>> listarProgramaSeminario(){
				try {
					List<ProgramaSeminario> list = new ArrayList<>();
					list=psi.listarProgramaSeminario();
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
			public ResponseEntity<ProgramaSeminario> buscarProgramaSeminario(@PathVariable("id") int id){
				ProgramaSeminario ps = psi.buscarProgramaSeminario(id);
				if (ps.getId_programa_capacitacion()>0) {
					return new ResponseEntity<>(ps,HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
			}
			
			//Funciona
			@PostMapping("/new")
			public ResponseEntity<String> agregarProgramaSeminario(@RequestBody ProgramaSeminario ps){
				try {
						String mensaje= psi.insertarProgramaSeminario(ps);
						return new ResponseEntity<>(mensaje,HttpStatus.CREATED);					
				} catch (Exception e) {
					// TODO: handle exception
					return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			
			
			//Funciona
			@DeleteMapping("/delete/{id}")
			public ResponseEntity<String> eliminarProgramaSeminario(@PathVariable("id") int id){
			try {
				String mensaje = psi.eliminarProgramaSeminario(id);
				return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}	
			}
			
			//Funciona
			@PutMapping("/update/{id}")
			public ResponseEntity<String> ActualizarProgramaSeminario(@RequestBody ProgramaSeminario ps, @PathVariable("id") int id){
			try {
				ProgramaSeminario ul = psi.buscarProgramaSeminario(id);
				if (ul.getId_programa_capacitacion()>0) {
					ul.setSeminario(ul.getSeminario());
					ul.setBanco(ul.getBanco());
					return new ResponseEntity<>(psi.actualizarProgramaSeminario(ul),HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			}
	
}
