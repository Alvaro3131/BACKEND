package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.example.sigca.entity.RolPrivilegios;
import com.example.sigca.repository.RolPrivilegiosRepository;
import com.example.sigca.repository.RolUsuarioRepository;
import com.example.sigca.service.RolPrivilegiosService;


@Service
public class RolPrivilegiosServiceImpl implements RolPrivilegiosService {
	
	@Autowired
	private RolPrivilegiosRepository rolprivilegios;

	@Override
	public String insertarRolPrivilegios(RolPrivilegios i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RolPrivilegios> listarRolPrivilegios() {
		// TODO Auto-generated method stub
		return rolprivilegios.listarRolPrivilegios();
	}

	@Override
	public RolPrivilegios buscarRolPrivilegios(int id_rol_privilegios) {
		// TODO Auto-generated method stub
		return rolprivilegios.buscarRolPrivilegios(id_rol_privilegios);
	}

	@Override
	public String eliminarRolPrivilegios(int id_rol_privilegios) {
		// TODO Auto-generated method stub
		return rolprivilegios.eliminarRolPrivilegios(id_rol_privilegios);
	}

	@Override
	public String actualizarRolPrivilegios(RolPrivilegios i) {
		// TODO Auto-generated method stub
		return null;
	}



}