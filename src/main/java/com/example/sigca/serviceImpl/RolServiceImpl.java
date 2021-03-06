package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.sigca.entity.Rol;
import com.example.sigca.repository.RolRepository;
import com.example.sigca.service.RolService;

@Service
public class RolServiceImpl implements RolService {
	
	@Autowired
	private RolRepository rol;

	
	@Override
	public String insertarRol(Rol r) {
		// TODO Auto-generated method stub
		return rol.insertarRol(r.getNombrerol());
	}

	@Override
	public List<Rol> listarRol() {
		// TODO Auto-generated method stub
		return rol.listarRol();
	}

	@Override
	public Rol buscarRol(int id_rol) {
		// TODO Auto-generated method stub
		return rol.buscarRol(id_rol);
	}

	@Override
	public String eliminarRol(int id_rol) {
		// TODO Auto-generated method stub
		return rol.eliminarRol(id_rol);
	}

	@Override
	public String actualizarRol(Rol r) {
		// TODO Auto-generated method stub
		return rol.actualizarRol(r.getIdrol(), r.getNombrerol());
	}

	@Override
	public List<Rol> listarRoles(int id_rol) {
		// TODO Auto-generated method stub
		return rol.listarRoles(id_rol);
	}

	


}