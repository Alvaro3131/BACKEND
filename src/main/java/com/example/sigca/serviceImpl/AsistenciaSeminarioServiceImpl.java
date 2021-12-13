package com.example.sigca.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.entity.AsistenciaSeminario;

import com.example.sigca.repository.AsistenciaSeminarioRepository;

import com.example.sigca.service.AsistenciaSeminarioService;


@Service
public class AsistenciaSeminarioServiceImpl implements AsistenciaSeminarioService {

	@Autowired
	private AsistenciaSeminarioRepository asistenciaSeminario;
	
	@Override
	public String insertarAsistenciaSeminario(AsistenciaSeminario s) {
		// TODO Auto-generated method stub
		return asistenciaSeminario.insertarAsistenciaSeminario(s.seminario.getID_SEMINARIO(),s.getSocio().getId(),s.getDE_ASISTENCIA(),s.getNU_VALORACION());
	}
	
	@Override
	public List<AsistenciaSeminario> listar() {
		// TODO Auto-generated method stub
		return asistenciaSeminario.listarAsistenciaSeminario();
	}
	
	@Override
	public AsistenciaSeminario buscarAsistenciaSeminario(int id_asistenciaSeminario) {
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
	public String actualizarAsistenciaSeminario(AsistenciaSeminario s) {
		// TODO Auto-generated method stub
		return asistenciaSeminario.actualizarAsistenciaSeminario(s.getID_ASISTENCIA_SEMINARIO(), s.getES_ASISTENCIA(), s.getDE_ASISTENCIA(), s.getFE_ASISTENCIA());
	}

	@Override
	public List<AsistenciaSeminario> listarasistencia(int seminario, int socio) {
		// TODO Auto-generated method stub
		return asistenciaSeminario.listarasistencia(seminario, socio);
	}
}
