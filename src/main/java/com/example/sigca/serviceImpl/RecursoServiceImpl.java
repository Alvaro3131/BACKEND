package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.Recurso;
import com.example.sigca.repository.RecursoRepository;
import com.example.sigca.service.RecursoService;
@Service
public class RecursoServiceImpl implements RecursoService{

	@Autowired
	private RecursoRepository recurso;
	
	@Override
	public String insertarRecurso(Recurso rec) {
		// TODO Auto-generated method stub
		return recurso.insertarRecurso(rec.getNombrerecurso(), rec.getOrden(), rec.getDescripcion(), rec.getTipo().getId(), rec.getSesion().getID_SESION());
	}

	@Override
	public List<Recurso> listarRecurso() {
		// TODO Auto-generated method stub
		return  recurso.listarRecurso();
	}

	@Override
	public Recurso buscarRecurso(int id_recurso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarRecurso(int id_recurso) {
		// TODO Auto-generated method stub
		System.out.println(id_recurso);
		return recurso.eliminarRecurso(id_recurso);
	}

	@Override
	public String actualizarRecurso(Recurso rec) {
		// TODO Auto-generated method stub
		return recurso.actualizarRecurso(rec.getId(), rec.getNombrerecurso(), rec.getOrden(), rec.getDescripcion(), rec.getTipo().getId(), rec.getSesion().getID_SESION());
	}

}
