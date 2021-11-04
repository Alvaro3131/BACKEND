package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Tipo;

public interface TipoService {

	String insertarTipo(Tipo tip);
	List<Tipo> listarTipo();
	Tipo buscarTipo(int id_tipo);
	String eliminarTipo(int id_tipo);
	String actualizarTipo(Tipo tip);
}
