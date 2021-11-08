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
import com.example.sigca.entity.BancoComunal;
import com.example.sigca.serviceImpl.BancoComunalServiceImpl;

@RestController
@RequestMapping("/api/bancoComunal")
public class BancoComunalController {
	
	@Autowired
	private BancoComunalServiceImpl bsi;
	
	//Funciona
			@GetMapping("/all")
			public ResponseEntity<List<BancoComunal>> listarBancoComunal(){
				try {
					List<BancoComunal> list = new ArrayList<>();
					list=bsi.listarBancoComunal();
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
			public ResponseEntity<BancoComunal> buscarBancoComunal(@PathVariable("id") int id){
				BancoComunal bc = bsi.buscarBanco(id);
				if (bc.getId_bancocomunal()>0) {
					return new ResponseEntity<>(bc,HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
			}
			
			//Funciona
			@PostMapping("/new")
			public ResponseEntity<String> agregarBancoComunal(@RequestBody BancoComunal bc){
				try {
					if (bc.getNo_bancocomunal() !=null) {
						String mensaje= bsi.insertarBanco(bc);
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
			public ResponseEntity<String> eliminarBancoComunal(@PathVariable("id") int id){
			try {
				String mensaje = bsi.eliminarBanco(id);
				return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}	
			}
			
			//Funciona
			@PutMapping("/update/{id}")
			public ResponseEntity<String> ActualizarBancoComunal(@RequestBody BancoComunal bc, @PathVariable("id") int id){
			try {
				BancoComunal ul = bsi.buscarBanco(id);
				if (ul.getId_bancocomunal()>0) {
					ul.setNo_bancocomunal(bc.getNo_bancocomunal());
					ul.setDistrito(bc.getDistrito());
					ul.setAsesor(bc.getAsesor());
					return new ResponseEntity<>(bsi.actualizarBanco(ul),HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			}
	
}
