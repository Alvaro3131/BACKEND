package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.Sede;
import com.example.sigca.repository.SedeRepository;
import com.example.sigca.service.SedeService;
@Service
public class SedeServiceImpl implements SedeService {
	
	@Autowired
	private SedeRepository sede;
	
	@Override
	public String insertarSede(Sede s) {
		// TODO Auto-generated method stub
		return sede.insertarSede(s.getNombreSede());
	}

	@Override
	public List<Sede> ListarSede() {
		// TODO Auto-generated method stub
		return sede.listarSede();
	}

	@Override
	public Sede buscarSede(int id_sede) {
		// TODO Auto-generated method stub
		return sede.buscarSede(id_sede);
	}

	@Override
	public String eliminarSede(int id_sede) {
		// TODO Auto-generated method stub
		System.out.println(id_sede);
		return sede.eliminarSede(id_sede);
	}

	@Override
	public String actualizarSede(Sede s) {
		// TODO Auto-generated method stub
		return sede.actualizarSede(s.getIdsede(), s.getNombreSede());
	}

}
