package com.example.sigca.service;

import java.util.List;


import com.example.sigca.entity.RolPrivilegios;

public interface RolPrivilegiosService {
	String insertarRolPrivilegios (RolPrivilegios i);
	List<RolPrivilegios> listarRolPrivilegios();
	RolPrivilegios buscarRolPrivilegios(int id_rol_privilegios);
	String eliminarRolPrivilegios(int id_rol_privilegios);
	String actualizarRolPrivilegios(RolPrivilegios i);
}

