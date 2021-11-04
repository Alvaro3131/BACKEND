package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.Alternativa;
import com.example.sigca.repository.AlternativaRepository;
import com.example.sigca.service.AlternativaService;

@Service
public class AlternativaServiceImpl implements AlternativaService{

	@Autowired
	private AlternativaRepository alternativa;
	
	@Override
	public String insertarAlternativa(Alternativa alt) {
		// TODO Auto-generated method stub
		return alternativa.insertarAlternativa(alt.getNombre(), alt.getValor(), alt.getPregunta().getId());
	}

	@Override
	public List<Alternativa> listarAlternativa() {
		// TODO Auto-generated method stub
		return alternativa.listarAlternativa();
	}

	@Override
	public Alternativa buscarAlternativa(int id_alternativa) {
		// TODO Auto-generated method stub
		return alternativa.buscarAlternativa(id_alternativa);
	}

	@Override
	public String eliminarAlternativa(int id_alternativa) {
		// TODO Auto-generated method stub
		System.out.println(id_alternativa);
		return alternativa.eliminarAlternativa(id_alternativa);
	}

	@Override
	public String actualizarAlternativa(Alternativa alt) {
		// TODO Auto-generated method stub
		return alternativa.actualizarAlternativa(alt.getId(), alt.getNombre(), alt.getValor(), alt.getPregunta().getId());
	}

}
