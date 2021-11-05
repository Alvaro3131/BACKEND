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
import com.example.sigca.entity.Categoria;
import com.example.sigca.serviceImpl.CategoriaServiceImpl;


@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	@Autowired
	private CategoriaServiceImpl categoria;
	
	//Funciona
	@GetMapping("/all")
	public ResponseEntity<List<Categoria>> listarCategoria(){
		try {
			List<Categoria> list = new ArrayList<>();
			list=categoria.listarCategoria();
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
	public ResponseEntity<Categoria> buscarCategoria(@PathVariable("id") int id){
		Categoria ca = categoria.buscarCategoria(id);
		if (ca.getId_categoria()>0) {
			return new ResponseEntity<>(ca,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	//Funciona
	@PostMapping("/new")
	public ResponseEntity<String> agregarCategoria(@RequestBody Categoria c){
		try {
			String mensaje= categoria.insertarCategoria(c);
			return new ResponseEntity<>(mensaje,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//Funciona
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> eliminarCategoria(@PathVariable("id") int id){
	try {
		String mensaje = categoria.eliminarCategoria(id);
		return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	}
	
	//Funciona
	@PutMapping("/update/{id}")
	public ResponseEntity<String> ActualizarCategoria(@RequestBody Categoria c, @PathVariable("id") int id){
	try {
		Categoria ul = categoria.buscarCategoria(id);
		if (ul.getId_categoria()>0) {
			ul.setNo_categoria(c.getNo_categoria());
			return new ResponseEntity<>(categoria.actualizarCategoria(ul),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	}
}
