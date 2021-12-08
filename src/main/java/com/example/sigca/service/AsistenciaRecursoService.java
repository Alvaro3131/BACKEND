package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.AsistenciaRecurso;
import com.example.sigca.entity.Sede;

public interface AsistenciaRecursoService {
	
	String insertarAsistenciaRecurso(AsistenciaRecurso s);
	List<AsistenciaRecurso> ListarAsistenciaRecurso();
	AsistenciaRecurso buscarAsistenciaRecurso(int id_AsistenciaRecurso);
	String eliminarAsistenciaRecurso(int id_AsistenciaRecurso);
	String actualizarAsistenciaRecurso(AsistenciaRecurso s);
	String actualizarEstadoAsistencia(int id);
}
