package com.example.sigca.serviceImpl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sigca.repository.AsistenciaSeminarioRepository;
import com.example.sigca.repository.DTO2Repository;
import com.example.sigca.repository.DtoRepository;
import com.example.sigca.service.ParticipacionService;
@Service
public class ParticipacionServiceImpl implements ParticipacionService  {

	@Autowired
	public DtoRepository dtoRepository;
	@Autowired
	public DTO2Repository dto2Repository;
	@Autowired
	public AsistenciaSeminarioRepository asistenciaSeminarioRepository;
	@Override
	public List<Map<String, Object>> listarParticipacionSesion(int banco, int modulo) {
		// TODO Auto-generated method stub
		return dtoRepository.listarParticipacionSesiones(banco, modulo);
	}
	@Override
	public String insertarMasivo(String modulo, String banco) {
		// TODO Auto-generated method stub
		return dtoRepository.insertarMasico(modulo, banco);
	}
	@Override
	public List<Map<String, Object>> participantes(int banco, int modulo) {
		// TODO Auto-generated method stub
		return dtoRepository.listarParticipantes(banco, modulo);
	}
	@Override
	public List<Map<String, Object>> listaProgramaAsesor(int id) {
		// TODO Auto-generated method stub
		return dtoRepository.listarProgramasAsesor(id);
	}
	@Override
	public List<Map<String, Object>> listarSocioSesiones(int banco, int modulo, int sesion) {
		// TODO Auto-generated method stub
		return dtoRepository.listarSocioSesiones(banco, modulo, sesion);
	}
	@Override
	public List<Map<String, Object>> listarSocioRecurso(int idsocio, int sesion) {
		// TODO Auto-generated method stub
		return 	dto2Repository.listarSocioRecursos(idsocio, sesion);

	}
	@Override
	public List<Map<String, Object>> ParticipacionRecursosSocio(int idsesion, int idmodulo) {
		// TODO Auto-generated method stub
		return dtoRepository.participacionRecursoSocio(idsesion, idmodulo);
	}
	@Override
	public List<Map<String, Object>> progresogeeneralsocio(int id) {
		// TODO Auto-generated method stub
		return dtoRepository.progresogeneralsocio(id);
	}
	@Override
	public String actualizarasistenciaSeminario(int socio, int seminario, int valoracion, String descripcion) {
		// TODO Auto-generated method stub
		return asistenciaSeminarioRepository.actualizar(socio, seminario, valoracion, descripcion);
	}
}
