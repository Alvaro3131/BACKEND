package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.Programacion;
import com.example.sigca.repository.ProgramacionRepository;
import com.example.sigca.service.ProgramacionService;

@Service
public class ProgramacionServiceImpl implements ProgramacionService {

	@Autowired
	private ProgramacionRepository p;
	
	@Override
	public List<Programacion> listarProgramacion() {
		// TODO Auto-generated method stub
		return p.listarProgramacion();
	}

	@Override
	public String insertarProgramacion(Programacion p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Programacion BuscarProgramacion(int id_programacion) {
		// TODO Auto-generated method stub
		return p.BuscarProgramacion(id_programacion);
		}

	@Override
	public String eliminarProgramacion(int id_programacion) {
		// TODO Auto-generated method stub
		return p.eliminarProgramacion(id_programacion);
		}

	@Override
	public String actualizarProgramacion(Programacion p) {
		// TODO Auto-generated method stub
		return null;
	}

}
