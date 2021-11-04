package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.ProgramaSeminario;

public interface ProgramaSeminarioService {

	List<ProgramaSeminario> listarProgramaSeminario();
	String insertarProgramaSeminario(ProgramaSeminario ps);
	ProgramaSeminario buscarProgramaSeminario(int id_programa_capacitacion);
	String eliminarProgramaSeminario(int id_programa_capacitacion);
	String actualizarProgramaSeminario(ProgramaSeminario ps);
}
