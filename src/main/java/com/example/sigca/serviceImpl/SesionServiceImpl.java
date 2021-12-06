package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.Sede;
import com.example.sigca.entity.Sesion;
import com.example.sigca.repository.SesionRepository;
import com.example.sigca.service.SesionService;
@Service
public class SesionServiceImpl implements SesionService{

	@Autowired
	private SesionRepository sesion;
	
	@Override
	public String insertarSesion(Sesion s) {
		// TODO Auto-generated method stub
		return sesion.insertarSesion(s.getNO_SESION());
	}
	@Override
	public List<Sesion> ListarSesion() {
		// TODO Auto-generated method stub
		return sesion.listarSesion();
	}

	@Override
	public Sesion buscarSesion(int id_sesion) {
		// TODO Auto-generated method stub
		return sesion.buscarSesion(id_sesion);
	}

	@Override
	public String eliminarSesion(int id_sesion) {
		// TODO Auto-generated method stub
		System.out.println(id_sesion);
		return sesion.eliminarSesion(id_sesion);
	}

	@Override
	public String actualizarSesion(Sesion s) {
		// TODO Auto-generated method stub
		return sesion.actualizarSesion(s.getID_SESION(), s.getNO_SESION());
	}
	@Override
	public List<Sesion> listarSesionModulo(int id_sesion) {
		// TODO Auto-generated method stub
		return sesion.listarSesionModulo(id_sesion);
	}

	@Override
	public List<Sesion> listarSesiones(int p_nIdModulo) {
		// TODO Auto-generated method stub
		return sesion.listarSesiones(p_nIdModulo);
	}
	
	
	
}
