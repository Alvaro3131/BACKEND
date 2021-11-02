package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.Categoria;
import com.example.sigca.repository.CategoriaRepository;
import com.example.sigca.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private CategoriaRepository categoria;
	
	@Override
	public String insertarCategoria(Categoria c) {
		// TODO Auto-generated method stub
		return categoria.insertarCategoria(c.getNo_categoria());
	}

	@Override
	public List<Categoria> listarCategoria() {
		// TODO Auto-generated method stub
		return categoria.listarCategoria();
	}

	@Override
	public Categoria buscarCategoria(int id_distrito) {
		// TODO Auto-generated method stub
		return categoria.buscarCategoria(id_distrito);
	}

	@Override
	public String eliminarCategoria(int id_distrito) {
		// TODO Auto-generated method stub
		return categoria.eliminarCategoria(id_distrito);
	}

	@Override
	public String actualizarCategoria(Categoria c) {
		// TODO Auto-generated method stub
		return categoria.actualizarCategoria(c.getId_categoria(), c.getNo_categoria());
	}

}
