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

import com.example.sigca.entity.Asistencia_Seminario;

import com.example.sigca.entity.BancoComunal;

import com.example.sigca.entity.Categoria;
import com.example.sigca.entity.Distrito;
import com.example.sigca.entity.Modulo;
import com.example.sigca.entity.Persona;
import com.example.sigca.entity.ProgramaSeminario;
import com.example.sigca.entity.Sede;

import com.example.sigca.entity.Seminario;
import com.example.sigca.entity.Sesion;
import com.example.sigca.entity.Socio;
import com.example.sigca.entity.Usuario;
import com.example.sigca.repository.AsesorRepository;

import com.example.sigca.repository.AsistenciaSeminarioRepository;

import com.example.sigca.repository.BancoComunalRepositoy;

import com.example.sigca.repository.CategoriaRepository;
import com.example.sigca.repository.DistritoRepository;
import com.example.sigca.repository.ModuloRepository;
import com.example.sigca.repository.PersonaRepository;
import com.example.sigca.repository.PrivilegiosRepository;
import com.example.sigca.repository.ProgramaSeminarioRepository;
import com.example.sigca.repository.RolPrivilegiosRepository;
import com.example.sigca.repository.RolRepository;
import com.example.sigca.repository.RolUsuarioRepository;
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
private AsistenciaSeminarioRepository asistenciaSeminarioRepository;
@Autowired 
private SocioRepository socio;
@Autowired 
private AsesorRepository asesor;
@Autowired 
private UsuarioRepository usuario;
@Autowired 
private SeminarioRepository seminario;

@Autowired 
private ProgramaSeminarioRepository programaseminario;
@Autowired 
private RolRepository rol;
@Autowired 
private RolPrivilegiosRepository rolprivilegios;
@Autowired 
private RolUsuarioRepository rolusuario;
@Autowired 
private PrivilegiosRepository privilegios;




	public static void main(String[] args) {
		SpringApplication.run(SigcaApplication.class, args);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run(String... args) throws Exception {
		/*
	Asistencia_Seminario a = asistenciaSeminarioRepository.buscarAsistenciaSeminario(4);
	System.out.println(a.getID_ASISTENCIA_SEMINARIO()+" "+
			   		   a.getSeminario().getNO_SEMINARIO()+" "+
			   		   a.getSocio().getPersona().getNombre()+" "+
			   		   a.getES_ASISTENCIA()+" "+
			   		   a.getDE_ASISTENCIA()+" "+
			   		   a.getFE_ASISTENCIA());
		

		List<Asistencia_Seminario> pe = asistenciaSeminarioRepository.listarAsistencia_Seminario();

		List<Sesion> pe= sesion.listarSesion();

		for(int i=0;i<pe.size(); i++) {
			System.out.println(pe.get(i).getID_ASISTENCIA_SEMINARIO()+" "+
							   pe.get(i).getSeminario().getNO_SEMINARIO()+" "+
							   pe.get(i).getSocio().getPersona().getNombre()+" "+
							   pe.get(i).getES_ASISTENCIA()+" "+
							   pe.get(i).getDE_ASISTENCIA()+" "+
							   pe.get(i).getFE_ASISTENCIA());
		}
		

		/*


		List<Persona> pe= personaRepository.listarPersona();
		for(int i=0;i<pe.size(); i++) {
			System.out.println(pe.get(i).getNombre()+" "+pe.get(i).getPaterno());
		}
		*/
	
	}

}

