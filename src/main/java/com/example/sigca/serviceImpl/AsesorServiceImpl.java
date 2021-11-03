package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.Asesor;
import com.example.sigca.repository.AsesorRepository;
import com.example.sigca.service.AsesorService;
@Service
public class AsesorServiceImpl implements AsesorService {
@Autowired
private AsesorRepository asesorRepository;
	@Override
	public List<Asesor> readall() {
		// TODO Auto-generated method stub
		return asesorRepository.findAll();
	}

	@Override
	public Asesor create(Asesor al) {
		// TODO Auto-generated method stub
		return asesorRepository.save(al);
	}

	@Override
	public Asesor read(int id) {
		// TODO Auto-generated method stub
		return asesorRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		asesorRepository.deleteById(id);
	}

	@Override
	public Asesor update(Asesor al) {
		// TODO Auto-generated method stub
		return asesorRepository.save(al);
	}

}
