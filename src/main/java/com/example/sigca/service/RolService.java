package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Rol;


public interface RolService {
	String insertarRol (Rol r);
	List<Rol> listarRol();
	Rol buscarRol(int id_rol);
	String eliminarRol(int id_rol);
	String actualizarRol(Rol r);
	List<Rol> listarRoles(int id_rol);
}
