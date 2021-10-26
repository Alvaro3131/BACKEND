package com.example.sigca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.sigca.entity.Distrito;
import com.example.sigca.entity.Persona;
import com.example.sigca.entity.Sede;
import com.example.sigca.repository.DistritoRepository;
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

	public static void main(String[] args) {
		SpringApplication.run(SigcaApplication.class, args);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run(String... args) throws Exception {
		
		/*List<Persona> pe= personaRepository.listarPersona();
		for(int i=0;i<pe.size(); i++) {
			System.out.println(pe.get(i).getNombre()+" "+pe.get(i).getPaterno());
		}*/
		/*
		Persona pe=personaRepository.readId(1).get();
		System.out.println(pe.getNombre()+" "+pe.getCorreo());
		
		personaRepository.savePersona("Pablo", "Alva", "Chipana", "40875108", "pabloalva2017@hotmail.com", "933771205");
	*/
		//sede.deleteSede(12);
		/*Sede s= sede.buscarSede(1).get();
		
		System.out.println(s.getIdsede()+" : "+s.getNombreSede());
		
		sede.saveSede("Apc Norte");
		List<Sede> se= sede.listarSede();
		for(int i=0;i<se.size(); i++) {
			System.out.println(se.get(i).getIdsede()+" : "+se.get(i).getNombreSede());
	}*/
		
		
		//sede.actualizarSede(14, "APC NORTE");
		
		Distrito dis= distrito.buscarDistrito(1).get();
		
		System.out.println(dis.getId_distrito()+" : "+dis.getNo_distrito()+" , "+ dis.getSede().nombreSede);
		
		
		List<Distrito> d= distrito.listarDistrito();
		for(int i=0;i<d.size(); i++) {
			System.out.println(d.get(i).getId_distrito()+" : "+d.get(i).getNo_distrito()+" " + d.get(i).getSede().getNombreSede());
	}
		
	}
}
