package com.example.sigca.servicelmpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.Sesion;
import com.example.sigca.repository.SesionRepository;
import com.example.sigca.service.SesionService;
@Service
public class SesionServiceImpl implements SesionService{

	@Autowired
	private SesionRepository sesionRepository;
	
	@Override
	public List<Sesion> readAll() {
		// TODO Auto-generated method stub
		return sesionRepository.findAll();
	}

	@Override
	public Sesion create(Sesion al) {
		// TODO Auto-generated method stub
		return sesionRepository.save(al);
	}

	@Override
	public Sesion read(int id) {
		// TODO Auto-generated method stub
		return sesionRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sesionRepository.deleteById(id);
	}

	@Override
	public Sesion update(Sesion al) {
		// TODO Auto-generated method stub
		return sesionRepository.save(al);
	}
	
	
}
