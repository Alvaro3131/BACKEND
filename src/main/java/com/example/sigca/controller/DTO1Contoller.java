package com.example.sigca.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.example.sigca.service.ParticipacionService;

@RestController
@RequestMapping("/api/reportes")
public class DTO1Contoller {
@Autowired
public ParticipacionService participacionService;
@GetMapping("/participacionrecursos/{idsesion}/{idmodulo}")
public ResponseEntity<List<Map<String, Object>>> participacionrecursosocio(@PathVariable("idsesion") int sesion, @PathVariable("idmodulo") int modulo){
	try {
		List<Map<String, Object>> list = new ArrayList<>();
		list=participacionService.ParticipacionRecursosSocio(sesion, modulo);
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


	@GetMapping("/participacion/{banco}/{modulo}")
	public ResponseEntity<List<Map<String, Object>>> listarDistrito(@PathVariable("banco") int banco, @PathVariable("modulo") int modulo){
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			list=participacionService.listarParticipacionSesion(banco, modulo);
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
	@GetMapping("/recursos/{idsocio}/{sesion}")
	public ResponseEntity<List<Map<String, Object>>> listarSocioRecursos(@PathVariable("idsocio") int idsocio, @PathVariable("sesion") int sesion){
		try {
			List<Map<String, Object>> list = new ArrayList<>();

			list=participacionService.listarSocioRecurso(idsocio, sesion);
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
	@GetMapping("/participacion/{banco}/{modulo}/{sesion}")
	public ResponseEntity<List<Map<String, Object>>> listarSocioSesiones(@PathVariable("banco") int banco, @PathVariable("modulo") int modulo, @PathVariable("sesion") int sesion){
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			list=participacionService.listarSocioSesiones(banco, modulo,sesion);
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
	@GetMapping("/programa/{id}")
	public ResponseEntity<List<Map<String, Object>>> listarProgramaAsesor(@PathVariable("id") int id){
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			list=participacionService.listaProgramaAsesor(id);
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
	@GetMapping("/socios/{id}")
	public ResponseEntity<List<Map<String, Object>>> listarSocios(@PathVariable("id") int id){
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			list=participacionService.listarSocioBanco(id);
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
	@GetMapping("/progreso/{id}")
	public ResponseEntity<List<Map<String, Object>>> progresogeneralsocio(@PathVariable("id") int id){
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			list=participacionService.progresogeeneralsocio(id);
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
	@GetMapping("/participantes/{banco}/{modulo}")
	public ResponseEntity<List<Map<String, Object>>> listarParticipantes(@PathVariable("banco") int banco, @PathVariable("modulo") int modulo){
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			list=participacionService.participantes(banco, modulo);
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
	@PostMapping("/insertar/{modulo}/{banco}")
	public  ResponseEntity<String> insertarMasivo(@PathVariable("banco") String banco, @PathVariable("modulo") String modulo){
		try {
			String mensaje=participacionService.insertarMasivo(modulo, banco);
			
			return new ResponseEntity<>(mensaje,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/desarrollodistrito/{id}")
	public ResponseEntity<List<Map<String, Object>>> desarrollodistrito(@PathVariable("id") int id){
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			list=participacionService.desarrollmoduloDistrito(id);
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
	@GetMapping("/desarrollobanco/{id}")
	public ResponseEntity<List<Map<String, Object>>> desarrolloBanco(@PathVariable("id") int id){
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			list=participacionService.desarrollmoduloBanco(id);
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
