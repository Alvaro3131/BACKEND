package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.Privilegios;

import com.example.sigca.repository.PrivilegiosRepository;

import com.example.sigca.service.PrivilegiosService;

@Service
public class PrivilegiosServiceImpl implements PrivilegiosService {
	
	@Autowired
	private PrivilegiosRepository privilegios;

	@Override
	public String insertarPrivilegios(Privilegios p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Privilegios> ListarPrivilegios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Privilegios buscarPrivilegios(int id_privilegios) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarPrivilegios(int id_privilegios) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizarPrivilegios(Privilegios p) {
		// TODO Auto-generated method stub
		return null;
	}
	
 

}