package com.example.sigca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.sigca.repository.TipoRepository;

@SpringBootApplication
public class SigcaLuis implements CommandLineRunner {

		@Autowired
		private TipoRepository tipoRepository;
		
		public static void main(String[] args) {
			SpringApplication.run(SigcaLuis.class, args);
		}
		
		@SuppressWarnings("deprecation")
		@Override
		
		public void run(String... args) throws Exception {
			
			
			/*System.out.println("Hola............");
			List<Tipo> l = tipo.listarTipo();
			for (int i = 0; i < l.size(); i++) {
				System.out.println(l.get(i).getId_tipo() + " " +l.get(i).no_tipo);
				
			}*/
			
		}
}
