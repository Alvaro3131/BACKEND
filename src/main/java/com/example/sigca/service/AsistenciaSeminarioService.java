package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.AsistenciaSeminario;

public interface AsistenciaSeminarioService {

	String insertarAsistenciaSeminario (AsistenciaSeminario s);
	List<AsistenciaSeminario> listar();
	List<AsistenciaSeminario> listarasistencia(int seminario, int socio);
	AsistenciaSeminario buscarAsistenciaSeminario(int id_asistencia_seminario);
	String eliminarAsistenciaSeminario(int id_asistencia_seminario);
	String actualizarAsistenciaSeminario(AsistenciaSeminario s);
}
