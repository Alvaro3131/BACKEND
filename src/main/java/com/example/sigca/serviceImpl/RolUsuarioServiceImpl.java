package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.RolUsuario;
import com.example.sigca.repository.RolUsuarioRepository;
import com.example.sigca.service.RolUsuarioService;

@Service
public class RolUsuarioServiceImpl implements RolUsuarioService {
	
	@Autowired
	private RolUsuarioRepository rolusuario;

	@Override
	public String insertarRolUsuario(RolUsuario u) {
		// TODO Auto-generated method stub
		return rolusuario.insertarRolUsuario(u.getRol().idrol, u.getUsuario().getId());
	}

	@Override
	public List<RolUsuario> listarRolUsuario() {
		// TODO Auto-generated method stub
		return rolusuario.listarRolUsuario();
	}

	@Override
	public RolUsuario buscarRolUsuario(int id_rol_usuario) {
		// TODO Auto-generated method stub
		return rolusuario.buscarRolUsuario(id_rol_usuario);
	}

	@Override
	public String eliminarRolUsuario(int id_rol_usuario) {
		// TODO Auto-generated method stub
		return rolusuario.eliminarRolUsuario(id_rol_usuario);
	}
	
	@Override
	public String actualizarRolUsuario(RolUsuario u) {
		// TODO Auto-generated method stub
		return rolusuario.actualizarRolUsuario(u.idrolusuario, u.getRol().idrol, u.getUsuario().getId());
	}
	


}

