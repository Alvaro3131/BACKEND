package com.example.sigca.service;

import java.util.List;


import com.example.sigca.entity.RolUsuario;

public interface RolUsuarioService {
	String insertarRolUsuario (RolUsuario u);
	List<RolUsuario> listarRolUsuario();
	RolUsuario buscarRolUsuario(int id_rol_usuario);
	String eliminarRolUsuario(int id_rol_usuario);
	String actualizarRolUsuario(RolUsuario u);
}
