package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Asistencia_Seminario;

public interface AsistenciaSeminarioService {

	String insertarAsistenciaSeminario (Asistencia_Seminario s);
	List<Asistencia_Seminario> ListarAsistenciaSeminario();
	Asistencia_Seminario buscarAsistenciaSeminario(int id_asistencia_seminario);
	String eliminarAsistenciaSeminario(int id_asistencia_seminario);
	String actualizarAsistenciaSeminario(Asistencia_Seminario s);
}
