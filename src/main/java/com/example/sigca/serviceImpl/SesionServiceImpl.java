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
		System.out.println(s.getNo_sesion()+ " "+ s.getModulo().getId_modulo());
		return sesion.insertarSesion(s.getNo_sesion(),s.getModulo().getId_modulo());
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
		return sesion.actualizarSesion(s.getId_sesion(), s.getNo_sesion(),s.getModulo().getId_modulo());
	}
	@Override
	public List<Sesion> listarSesionModulo(int id_sesion) {
		// TODO Auto-generated method stub
		return sesion.listarSesionModulo(id_sesion);
	}


	
	
	
}
