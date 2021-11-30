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

import com.example.sigca.entity.Asesor;
import com.example.sigca.entity.Usuario;
import com.example.sigca.service.UsuarioService;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> getPersonas(){
		try {
			List<Usuario> list = new ArrayList<>();
			list = usuarioService.readall();
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/read/{id}")
	public ResponseEntity<Usuario> getUser(@PathVariable("id") int id){
		Usuario usuario = usuarioService.read(id);
			if(usuario.getId()>0) {
				return new ResponseEntity<>(usuario, HttpStatus.OK);
			}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	@PostMapping("/insertar")
	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
		try {
			Usuario a = new Usuario();
			
			a.setId(usuario.getId());
			a.setPassword(usuario.getPassword());
			a.setUsername(usuario.getUsername());
			Usuario al = usuarioService.create(a);
			return new ResponseEntity<>(al, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario, @PathVariable("id") int id){
		try {
			Usuario a = usuarioService.read(id);
			if(a.getId()>0) {
				
				a.setPassword(usuario.getPassword());
				a.setUsername(usuario.getUsername());
				return new ResponseEntity<>(usuarioService.create(a),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			usuarioService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
