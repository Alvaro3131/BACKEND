package com.example.sigca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.sigca.entity.Distrito;
import com.example.sigca.entity.Persona;
import com.example.sigca.entity.Sede;

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

	}
}
