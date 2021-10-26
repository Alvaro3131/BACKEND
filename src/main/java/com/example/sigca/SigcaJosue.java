package com.example.sigca;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import com.example.sigca.entity.Distrito;
import com.example.sigca.repository.DistritoRepository;

public class SigcaJosue implements CommandLineRunner{
	
	@Autowired
	private DistritoRepository distrito;
	
	public static void main(String[] args) {
		SpringApplication.run(SigcaJosue.class, args);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run(String... args) throws Exception {
		
		
		/*System.out.println("Hola............");
		List<Distrito> l = distrito.listarDistrito();
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i).getId_distrito() + " " +l.get(i).no_distrito +"  "+l.get(i).getSede().getNombreSede());
			
		}*/
		
	}
}
