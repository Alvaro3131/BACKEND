package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Asistencia_Seminario;

public interface AsistenciaSeminarioService {

	String insertarAsistenciaSeminario (Asistencia_Seminario s);
	List<Asistencia_Seminario> ListarAsistenciaSeminario();
	Asistencia_Seminario buscarAsistenciaSeminario(int id_asistenciaSeminario);
	String eliminarAsistenciaSeminario(int id_asistenciaSeminario);
	String actualizarAsistenciaSeminario(Asistencia_Seminario s);
}
