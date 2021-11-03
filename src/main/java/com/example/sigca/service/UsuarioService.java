package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Persona;
import com.example.sigca.entity.Usuario;

public interface UsuarioService {
	List<Usuario> readall();
	Usuario create(Usuario al);
	Usuario read(int id);
	void delete(int id);
	Usuario update(Usuario al);
}
