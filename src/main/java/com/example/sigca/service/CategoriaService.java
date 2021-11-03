package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Categoria;


public interface CategoriaService {
	String insertarCategoria(Categoria c);
	List<Categoria> listarCategoria();
	Categoria buscarCategoria(int id_distrito);
	String eliminarCategoria(int id_distrito);
	String actualizarCategoria(Categoria c);
}
