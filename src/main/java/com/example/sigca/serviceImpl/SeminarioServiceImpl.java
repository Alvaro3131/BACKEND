

package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.Seminario;
import com.example.sigca.repository.SeminarioRepository;
import com.example.sigca.service.SeminarioService;
@Service
public class SeminarioServiceImpl implements SeminarioService {
	
	@Autowired
	private SeminarioRepository seminario;

	@Override
	public List<Seminario> listarSeminario() {
		// TODO Auto-generated method stub
		return seminario.listarSeminario();
	}

	@Override
	public String insertarSeminario(Seminario se) {
		// TODO Auto-generated method stub
		return seminario.insertarSeminario(se.getNO_SEMINARIO(),se.getFE_INICIO(),se.getFE_FIN(),se.getURL_SEMINARIO());
	}

	@Override
	public Seminario buscarSeminario(int id_seminario) {
		// TODO Auto-generated method stub
		return seminario.buscarSeminario(id_seminario);
	}

	@Override
	public String eliminarSeminario(int id_seminario) {
		// TODO Auto-generated method stub
		System.out.println(id_seminario);
		return seminario.eliminarSeminario(id_seminario);
	}

	@Override
	public String actualizarSeminario(Seminario se) {
		// TODO Auto-generated method stub
		return seminario.actualizarSeminario(se.getID_SEMINARIO(),se.getNO_SEMINARIO(),se.getFE_INICIO(),se.getFE_FIN(),se.getURL_SEMINARIO());
	}

}
