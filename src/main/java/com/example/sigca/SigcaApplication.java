package com.example.sigca;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.sigca.entity.Asesor;
import com.example.sigca.entity.Categoria;
import com.example.sigca.entity.Distrito;
import com.example.sigca.entity.Modulo;
import com.example.sigca.entity.Persona;
import com.example.sigca.entity.Sede;

import com.example.sigca.entity.Seminario;
import com.example.sigca.entity.Sesion;
import com.example.sigca.entity.Socio;
import com.example.sigca.entity.Usuario;
import com.example.sigca.repository.AsesorRepository;
import com.example.sigca.repository.CategoriaRepository;
import com.example.sigca.repository.DistritoRepository;
import com.example.sigca.repository.ModuloRepository;
import com.example.sigca.repository.PersonaRepository;
import com.example.sigca.repository.SedeRepository;

import com.example.sigca.repository.SeminarioRepository;
import com.example.sigca.repository.SesionRepository;
import com.example.sigca.repository.SocioRepository;
import com.example.sigca.repository.UsuarioRepository;


@SpringBootApplication
public class SigcaApplication implements CommandLineRunner{
@Autowired
private PersonaRepository personaRepository;

@Autowired 
private SedeRepository sede;

@Autowired
private DistritoRepository distrito;

@Autowired
private CategoriaRepository cate;

@Autowired 
private ModuloRepository modulo;
@Autowired
private SesionRepository sesion;

@Autowired 
private SocioRepository socio;
@Autowired 
private AsesorRepository asesor;
@Autowired 
private UsuarioRepository usuario;
@Autowired 
private SeminarioRepository seminario;


	public static void main(String[] args) {
		SpringApplication.run(SigcaApplication.class, args);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run(String... args) throws Exception {

		
		/*List<Sesion> pe= sesion.listarSesion();
		for(int i=0;i<pe.size(); i++) {
			System.out.println(pe.get(i).getIdsesion()+" "+pe.get(i).getNombreSesion()+" "+pe.get(i).getModulo().getNo_modulo());
		}

		
		List<Persona> pe= personaRepository.listarPersona();
		for(int i=0;i<pe.size(); i++) {
			System.out.println(pe.get(i).getNombre()+" "+pe.get(i).getPaterno());
		}*/
		
}
}
