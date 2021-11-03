package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.Persona;
import com.example.sigca.repository.PersonaRepository;
import com.example.sigca.service.PersonaService;
@Service
public class PersonaServiceImpl implements PersonaService {
@Autowired
private PersonaRepository persona;
	@Override
	public List<Persona> readall() {
		// TODO Auto-generated method stub
		return persona.findAll();
	}

	@Override
	public Persona create(Persona al) {
		// TODO Auto-generated method stub
		return persona.save(al);
	}

	@Override
	public Persona read(int id) {
		// TODO Auto-generated method stub
		return persona.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		persona.deleteById(id);
		
	}

	@Override
	public Persona update(Persona al) {
		// TODO Auto-generated method stub
		return persona.save(al);
	}

}
