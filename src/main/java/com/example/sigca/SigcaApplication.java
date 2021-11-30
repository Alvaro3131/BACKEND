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
import com.example.sigca.entity.Privilegios;
import com.example.sigca.entity.ProgramaSeminario;

import com.example.sigca.entity.Rol;
import com.example.sigca.entity.RolPrivilegios;

import com.example.sigca.entity.Programacion;

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
import com.example.sigca.repository.ProgramacionRepository;
import com.example.sigca.repository.RolPrivilegiosRepository;
import com.example.sigca.repository.RolRepository;
import com.example.sigca.repository.RolUsuarioRepository;
import com.example.sigca.repository.SedeRepository;

import com.example.sigca.repository.SeminarioRepository;
import com.example.sigca.repository.SesionRepository;
import com.example.sigca.repository.SocioRepository;
import com.example.sigca.repository.UsuarioRepository;
import com.example.sigca.service.PersonaService;


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
private SesionRepository sesionRepository;
@Autowired
private AsistenciaSeminarioRepository asistenciaSeminarioRepository;


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
@Autowired 
private BancoComunalRepositoy banco;

@Autowired
private ProgramacionRepository p;
@Autowired
private PersonaService personaService;

	public static void main(String[] args) {
		SpringApplication.run(SigcaApplication.class, args);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run(String... args) throws Exception {


}
}

