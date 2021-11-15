package com.example.sigca.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.sigca.entity.Distrito;
import com.example.sigca.entity.Persona;
import com.example.sigca.service.ParticipacionService;

@RestController
@RequestMapping("/api/reportes")
public class DTO1Contoller {
@Autowired
public ParticipacionService participacionService;
	@GetMapping("/participacion/{banco}/{modulo}")
	public ResponseEntity<List<Map<String, Object>>> listarDistrito(@PathVariable("banco") int banco, @PathVariable("modulo") int modulo){
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			list=participacionService.readall(banco, modulo);
			System.out.println(list);
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
