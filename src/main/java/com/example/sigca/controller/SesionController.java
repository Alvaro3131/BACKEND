package com.example.sigca.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sigca.entity.Sesion;
import com.example.sigca.service.SesionService;

@RestController
@RequestMapping("/api/sesion")
public class SesionController {
	
	@Autowired
	private SesionService sesionService;
	@GetMapping("/all")
	public ResponseEntity<List<Sesion>> getSesion(){
		try {
			List<Sesion> list = new ArrayList<>();
			list = sesionService.readAll();
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
