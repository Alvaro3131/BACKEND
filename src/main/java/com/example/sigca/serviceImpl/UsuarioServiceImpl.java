package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.Usuario;
import com.example.sigca.repository.UsuarioRepository;
import com.example.sigca.service.UsuarioService;
@Service
public class UsuarioServiceImpl implements UsuarioService {
@Autowired
private UsuarioRepository usuarioRepository;
	@Override
	public List<Usuario> readall() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario create(Usuario al) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(al);
	}

	@Override
	public Usuario read(int id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}

	@Override
	public Usuario update(Usuario al) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(al);
	}

}
