package com.example.sigca;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.sigca.entity.Categoria;
import com.example.sigca.entity.Distrito;
import com.example.sigca.entity.Modulo;
import com.example.sigca.entity.Persona;
import com.example.sigca.entity.Sede;
import com.example.sigca.entity.Seminario;
import com.example.sigca.repository.CategoriaRepository;
import com.example.sigca.repository.DistritoRepository;
import com.example.sigca.repository.ModuloRepository;
import com.example.sigca.repository.PersonaRepository;
import com.example.sigca.repository.SedeRepository;

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


	public static void main(String[] args) {
		SpringApplication.run(SigcaApplication.class, args);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run(String... args) throws Exception {

		/*
		List<Persona> pe= personaRepository.listarPersona();
		for(int i=0;i<pe.size(); i++) {
			System.out.println(pe.get(i).getNombre()+" "+pe.get(i).getPaterno());
		}

		
		/*List<Persona> pe= personaRepository.listarPersona();
		for(int i=0;i<pe.size(); i++) {
			System.out.println(pe.get(i).getNombre()+" "+pe.get(i).getPaterno());
		}*/
		
		
		
		/*Modulo m = modulo.buscarModulo(1);
		System.out.println(m.getId_modulo()+ " : " + m.getNo_modulo()+ "  "+ m.getCategoria().getNo_categoria());
		//cate.actualizarCategoria(4, "Deportivo");
		List<Modulo> l = modulo.listarModulo();
		for(int i=0;i<l.size(); i++) {
			System.out.println(l.get(i).getId_modulo()+" "+l.get(i).getNo_modulo()+ " " +l.get(i).getCategoria().getNo_categoria());
		}
		
		List<Categoria> c = cate.listarCategoria();
		for(int i=0;i<c.size(); i++) {
			System.out.println(c.get(i).getId_categoria()+" "+c.get(i).getNo_categoria());
		}*/
		
		
		
		/*Seminario s = seminario.buscarSeminario(1);
		System.out.println(s.getID_SEMINARIO()+" "+s.getNO_SEMINARIO()+" "+ s.getFE_INICIO()+" "+ s.getFE_FIN()+" "+ s.getURL_SEMINARIO());
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		/*List<Seminario> s = seminario.listarSeminario();
		for(int i=0;i<s.size(); i++) {
			System.out.println(s.get(i).getID_SEMINARIO()+" "+s.get(i).getNO_SEMINARIO()+" "+ s.get(i).getFE_INICIO()+" "+ s.get(i).getFE_FIN()+" "+ s.get(i).getURL_SEMINARIO());
		}*/
		
		
	String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
	System.out.println(timeStamp);
	
}
}
