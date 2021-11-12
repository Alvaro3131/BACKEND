package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.Inscripcion;
import com.example.sigca.repository.InscripcionRepository;
import com.example.sigca.service.InscripcionService;

@Service
public class InscripcionServiceImpl implements InscripcionService{
@Autowired
private InscripcionRepository inscripcionRepository;
	@Override
	public List<Inscripcion> readall() {
		// TODO Auto-generated method stub
		return inscripcionRepository.findAll();
	}

	@Override
	public Inscripcion create(Inscripcion al) {
		// TODO Auto-generated method stub
		return inscripcionRepository.save(al);
	}

	@Override
	public Inscripcion read(int id) {
		// TODO Auto-generated method stub
		return inscripcionRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		inscripcionRepository.deleteById(id);
		
		
	}

	@Override
	public Inscripcion update(Inscripcion al) {
		// TODO Auto-generated method stub
		return inscripcionRepository.save(al);
	}

	

}
