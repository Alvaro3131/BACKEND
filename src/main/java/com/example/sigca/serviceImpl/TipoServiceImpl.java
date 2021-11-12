package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.Tipo;
import com.example.sigca.repository.TipoRepository;
import com.example.sigca.service.TipoService;

@Service
public class TipoServiceImpl implements TipoService{

	@Autowired
	private TipoRepository tipo;
	
	@Override
	public String insertarTipo(Tipo tip) {
		// TODO Auto-generated method stub
		return tipo.insertarTipo(tip.getNombre());
	}

	@Override
	public List<Tipo> listarTipo() {
		// TODO Auto-generated method stub
		return tipo.listarTipo();
	}

	@Override
	public Tipo buscarTipo(int id_tipo) {
		// TODO Auto-generated method stub
		return tipo.buscarTipo(id_tipo);
	}

	@Override
	public String eliminarTipo(int id_tipo) {
		// TODO Auto-generated method stub
		System.out.println(id_tipo);
		return tipo.eliminarTipo(id_tipo);
	}

	@Override
	public String actualizarTipo(Tipo tip) {
		// TODO Auto-generated method stub
		return tipo.actualizarTipo(tip.getId_tipo(), tip.getNombre());
	}

	
}
