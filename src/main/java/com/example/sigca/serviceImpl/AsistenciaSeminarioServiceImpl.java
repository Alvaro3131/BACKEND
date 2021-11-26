package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.Asistencia_Seminario;

import com.example.sigca.repository.AsistenciaSeminarioRepository;

import com.example.sigca.service.AsistenciaSeminarioService;
@Service
public class AsistenciaSeminarioServiceImpl implements AsistenciaSeminarioService {

	@Autowired
	private AsistenciaSeminarioRepository asistenciaSeminario;
	
	@Override
	public String insertarAsistenciaSeminario(Asistencia_Seminario s) {
		// TODO Auto-generated method stub
		return asistenciaSeminario.insertarAsistenciaSeminario(s.getID_ASISTENCIA_SEMINARIO(), s.getES_ASISTENCIA(), s.getDE_ASISTENCIA(), s.getFE_ASISTENCIA());
	}
	
	@Override
	public List<Asistencia_Seminario> ListarAsistenciaSeminario() {
		// TODO Auto-generated method stub
		return asistenciaSeminario.listarAsistenciaSeminario();
	}
	
	@Override
	public Asistencia_Seminario buscarAsistenciaSeminario(int id_asistenciaSeminario) {
		// TODO Auto-generated method stub
		return asistenciaSeminario.buscarAsistenciaSeminario(id_asistenciaSeminario);
	}
	
	@Override
	public String eliminarAsistenciaSeminario(int id_asistenciaSeminario) {
		// TODO Auto-generated method stub
		System.out.println(id_asistenciaSeminario);
		return asistenciaSeminario.eliminarAsistenciaSeminario(id_asistenciaSeminario);
	}
	
	@Override
	public String actualizarAsistenciaSeminario(Asistencia_Seminario s) {
		// TODO Auto-generated method stub
		return asistenciaSeminario.actualizarAsistenciaSeminario(s.getID_ASISTENCIA_SEMINARIO(), s.getES_ASISTENCIA(), s.getDE_ASISTENCIA(), s.getFE_ASISTENCIA());
	}
}
