package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.Modulo;
import com.example.sigca.repository.ModuloRepository;
import com.example.sigca.service.ModuloService;

@Service
public class ModuloServiceImpl implements ModuloService{
	
	@Autowired
	private ModuloRepository modulo;
	
	@Override
	public String insertarModulo(Modulo m) {
		// TODO Auto-generated method stub
		return modulo.insertarModulo(m.getNo_modulo(),m.getCategoria().getId_categoria());
	}

	@Override
	public List<Modulo> listarModulo() {
		// TODO Auto-generated method stub
		return modulo.listarModulo();
	}

	@Override
	public Modulo buscarModulo(int id_modulo) {
		// TODO Auto-generated method stub
		return modulo.buscarModulo(id_modulo);
	}

	@Override
	public String eliminarModulo(int id_modulo) {
		// TODO Auto-generated method stub
		return modulo.eliminarModulo(id_modulo);
	}

	@Override
	public String actualizarModulo(Modulo m) {
		// TODO Auto-generated method stub
		return modulo.actualizarModulo(m.getId_modulo(),m.getNo_modulo() , m.getCategoria().getId_categoria());
	}

}
