package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.Distrito;
import com.example.sigca.repository.DistritoRepository;
import com.example.sigca.service.DistritoService;

@Service
public class DistritoServiceImpl implements DistritoService{
	
	@Autowired
	DistritoRepository distrito;
	
	@Override
	public String insertarDistrito(Distrito d) {
		// TODO Auto-generated method stub
		return distrito.insertarDistrito(d.getNo_distrito(),d.getSede().getId_sede());
	}

	@Override
	public List<Distrito> listarDistrito() {
		// TODO Auto-generated method stub
		return distrito.listarDistrito();
	}

	@Override
	public Distrito buscarDistrito(int id_distrito) {
		// TODO Auto-generated method stub
		return distrito.buscarDistrito(id_distrito);
	}

	@Override
	public String eliminarDistrito(int id_distrito) {
		// TODO Auto-generated method stub
		return distrito.eliminarDistrito(id_distrito);
	}

	@Override
	public String ActualizarDistrito(Distrito d) {
		// TODO Auto-generated method stub
		return distrito.actualizarDistrito(d.getId_distrito(), d.getNo_distrito(), d.getSede().getId_sede());
	}

	

}
