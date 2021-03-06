package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.AsistenciaRecurso;
import com.example.sigca.entity.Sede;
import com.example.sigca.repository.AsistenciaRecursoRepository;
import com.example.sigca.service.AsistenciaRecursoService;

@Service
public class AsistenciaRecursoServiceImpl implements AsistenciaRecursoService{

	@Autowired
	private AsistenciaRecursoRepository asistenciaRecurso;
	
	@Override
	public String insertarAsistenciaRecurso(AsistenciaRecurso s) {
		// TODO Auto-generated method stub
		return asistenciaRecurso.insertarAsistenciaRecurso(1, s.getNu_valoracion(), s.getSocio().getId(), s.getRecurso().getId());
	}

	@Override
	public List<AsistenciaRecurso> ListarAsistenciaRecurso() {
		// TODO Auto-generated method stub
		return asistenciaRecurso.listarAsistenciaRecurso();
	}

	@Override
	public AsistenciaRecurso buscarAsistenciaRecurso(int id_AsistenciaRecurso) {
		// TODO Auto-generated method stub
		return asistenciaRecurso.buscarAsistenciaRecurso(id_AsistenciaRecurso);
	}

	@Override
	public String eliminarAsistenciaRecurso(int id_AsistenciaRecurso) {
		// TODO Auto-generated method stub
		return asistenciaRecurso.eliminarAsistenciaRecurso(id_AsistenciaRecurso);
	}

	@Override
	public String actualizarAsistenciaRecurso(AsistenciaRecurso s) {
		// TODO Auto-generated method stub
		return asistenciaRecurso.actualizarAsistenciaRecurso(s.getId_asistencia_recurso(), s.getEs_asistencia(), s.getNu_valoracion(),s.getSocio().getId(),s.getRecurso().getId());
	}

	@Override
	public String actualizarEstadoAsistencia(int id) {
		// TODO Auto-generated method stub
		return asistenciaRecurso.actualizarEstadoAsistencia(id);
	}

	@Override
	public void actualizarValoracionAsistencia(int valoracion, int id_socio, int id_recurso) {
		// TODO Auto-generated method stub
		asistenciaRecurso.valorarRecurso(valoracion, id_socio, id_recurso);
	}

	@Override
	public String actualizarValoracionRecurso(AsistenciaRecurso s) {
		// TODO Auto-generated method stub
		return asistenciaRecurso.actualizarValoracionRecurso(s.getId_asistencia_recurso(), s.getNu_valoracion());
	}




}
