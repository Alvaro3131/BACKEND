package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.Socio;
import com.example.sigca.repository.SocioRepository;
import com.example.sigca.service.SocioService;
@Service
public class SocioServiceImpl implements SocioService {
@Autowired
private SocioRepository socioRepository;
	@Override 
	public List<Socio> readall() {
		// TODO Auto-generated method stub
		return socioRepository.findAll();
	}

	@Override
	public Socio create(Socio al) {
		// TODO Auto-generated method stub
		return socioRepository.save(al);
	}

	@Override
	public Socio read(int id) {
		// TODO Auto-generated method stub
		return socioRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		socioRepository.deleteById(id);
		
	}

	@Override
	public Socio update(Socio al) {
		// TODO Auto-generated method stub
		return socioRepository.save(al);
	}

}
