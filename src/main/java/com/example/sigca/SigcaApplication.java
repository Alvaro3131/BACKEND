package com.example.sigca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.sigca.entity.Persona;
import com.example.sigca.repository.PersonaRepository;

@SpringBootApplication
public class SigcaApplication implements CommandLineRunner{
@Autowired
private PersonaRepository personaRepository;
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
		Persona pe=personaRepository.readId(1).get();
		System.out.println(pe.getNombre()+" "+pe.getCorreo());
		
		personaRepository.savePersona("Pablo", "Alva", "Chipana", "40875108", "pabloalva2017@hotmail.com", "933771205");
	*/
		
	
	}

}
