package com.example.sigca.service;

import java.util.List;


import com.example.sigca.entity.Programacion;

public interface ProgramacionService {
	List<Programacion> listarProgramacionTrue();
	List<Programacion> listarProgramacionFalse();
	List<Programacion> listarProgramacion();
	String insertarProgramacion(Programacion p);
	Programacion BuscarProgramacion(int id_programacion);
	String eliminarProgramacion(int id_programacion);
	String actualizarProgramacion(Programacion p);
	List<Programacion> buscarProgramacionBanco(int id);
}
