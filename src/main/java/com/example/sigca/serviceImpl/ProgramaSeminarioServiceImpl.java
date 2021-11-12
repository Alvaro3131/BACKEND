package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sigca.entity.ProgramaSeminario;
import com.example.sigca.repository.ProgramaSeminarioRepository;
import com.example.sigca.service.ProgramaSeminarioService;

@Service
public class ProgramaSeminarioServiceImpl implements ProgramaSeminarioService {

	@Autowired
	private ProgramaSeminarioRepository psr;

	
	@Override
	public List<ProgramaSeminario> listarProgramaSeminario() {
		// TODO Auto-generated method stub
		return psr.listarProgramaSeminario();
	}

	@Override
	public String insertarProgramaSeminario(ProgramaSeminario ps) {
		// TODO Auto-generated method stub
		return psr.insertarProgramaSeminario(ps.getSeminario().getID_SEMINARIO(), ps.getBanco().getId_bancocomunal());
	}

	@Override
	public ProgramaSeminario buscarProgramaSeminario(int id_programa_capacitacion) {
		// TODO Auto-generated method stub
		return psr.buscarProgramaSeminario(id_programa_capacitacion);
	}

	@Override
	public String eliminarProgramaSeminario(int id_programa_capacitacion) {
		// TODO Auto-generated method stub
		return psr.eliminarProgramaSeminario(id_programa_capacitacion);
	}

	@Override
	public String actualizarProgramaSeminario(ProgramaSeminario ps) {
		// TODO Auto-generated method stub
		return psr.actualizarProgramaSeminario(ps.getId_programa_capacitacion(), ps.getSeminario().getID_SEMINARIO(), ps.getBanco().getId_bancocomunal());
	}

}
