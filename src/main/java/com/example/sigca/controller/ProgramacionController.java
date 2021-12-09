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
import com.example.sigca.entity.Programacion;
import com.example.sigca.serviceImpl.ProgramacionServiceImpl;

@RestController
@RequestMapping("/api/programacion")
public class ProgramacionController {
	
	@Autowired
	private ProgramacionServiceImpl psi;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/allTrue")
	public ResponseEntity<List<Programacion>> listarProgramacionTrue(){
		try {
			List<Programacion> list = new ArrayList<>();
			list=psi.listarProgramacionTrue();
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/allFalse")
	public ResponseEntity<List<Programacion>> listarProgramacionFalse(){
		try {
			List<Programacion> list = new ArrayList<>();
			list=psi.listarProgramacionFalse();
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
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/banco/{id}")
	public ResponseEntity<List<Programacion>> listarBancoDistrito(@PathVariable("id") int id){
		try {
			List<Programacion> list = new ArrayList<>();
			list=psi.buscarProgramacionBanco(id);
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
			@CrossOrigin(origins = "http://localhost:4200")
			@GetMapping("/all")
			public ResponseEntity<List<Programacion>> listarProgramacion(){
				try {
					List<Programacion> list = new ArrayList<>();
					list=psi.listarProgramacion();
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
			@CrossOrigin(origins = "http://localhost:4200")
			@GetMapping("/search/{id}")
			public ResponseEntity<Programacion> buscarProgramacion(@PathVariable("id") int id){
				Programacion p = psi.BuscarProgramacion(id);
				if (p.getId_programacion()>0) {
					return new ResponseEntity<>(p,HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
			}
			
			//Funciona
			@CrossOrigin(origins = "http://localhost:4200")
			@PostMapping("/new")
			public ResponseEntity<String> agregarProgramacion(@RequestBody Programacion p){
				try {
						String mensaje= psi.insertarProgramacion(p);
						return new ResponseEntity<>(mensaje,HttpStatus.CREATED);					
				} catch (Exception e) {
					// TODO: handle exception
					return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			
			
			//Funciona
			@DeleteMapping("/delete/{id}")
			public ResponseEntity<String> eliminarProgramacion(@PathVariable("id") int id){
			try {
				String mensaje = psi.eliminarProgramacion(id);
				return new ResponseEntity<>(mensaje,HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}	
			}
			
			//Funciona
			@CrossOrigin(origins = "http://localhost:4200")
			@PutMapping("/update/{id}")
			public ResponseEntity<String> ActualizarProgramacion(@RequestBody Programacion p, @PathVariable("id") int id){
			try {
				Programacion ul = psi.BuscarProgramacion(id);
				if (ul.getId_programacion()>0) {
					ul.setBanco(p.getBanco());
					ul.setModulo(p.getModulo());
					ul.setEs_pogramacion(p.getEs_pogramacion());
					return new ResponseEntity<>(psi.actualizarProgramacion(ul),HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			}
		
	
}
