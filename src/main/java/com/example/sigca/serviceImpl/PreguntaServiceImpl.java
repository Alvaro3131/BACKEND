package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.Pregunta;
import com.example.sigca.repository.PreguntaRepository;
import com.example.sigca.service.PreguntaService;

@Service
public class PreguntaServiceImpl implements PreguntaService{

	@Autowired
	private PreguntaRepository pregunta;
	
	@Override
	public String insertarPregunta(Pregunta preg) {
		// TODO Auto-generated method stub
		return pregunta.insertarPregunta(preg.getNombre(), preg.getRecurso().getId());
	}

	@Override
	public List<Pregunta> listarPregunta() {
		// TODO Auto-generated method stub
		return pregunta.listarPregunta();
	}

	@Override
	public Pregunta buscarPregunta(int id_pregunta) {
		// TODO Auto-generated method stub
		return pregunta.buscarPregunta(id_pregunta);
	}

	@Override
	public String eliminarPregunta(int id_pregunta) {
		// TODO Auto-generated method stub
		System.out.println(id_pregunta);
		return pregunta.eliminarPregunta(id_pregunta);
	}

	@Override
	public String actualizarPregunta(Pregunta preg) {
		// TODO Auto-generated method stub
		return pregunta.actualizarPregunta(preg.getId(), preg.getNombre(), preg.getRecurso().getId());
	}

}
