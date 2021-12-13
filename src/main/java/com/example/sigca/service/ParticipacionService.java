package com.example.sigca.service;

import java.util.List;
import java.util.Map;





public interface ParticipacionService {
	List<Map<String, Object>> ParticipacionRecursosSocio(int idsesion, int idmodulo);
	List<Map<String, Object>> listarSocioSesiones(int banco, int modulo,int sesion);
	List<Map<String, Object>> listarParticipacionSesion(int banco, int modulo);
	List<Map<String, Object>> listaProgramaAsesor(int id);
	List<Map<String, Object>> listarSocioRecurso(int idsocio, int sesion);
	List<Map<String, Object>> participantes(int banco, int modulo);
	String insertarMasivo(String modulo, String banco);
	String actualizarasistenciaSeminario(int socio, int seminario, int valoracion, String descripcion );
	List<Map<String, Object>> progresogeeneralsocio(int id);

	List<Map<String, Object>> desarrollmoduloDistrito(int id);
	List<Map<String, Object>> desarrollmoduloBanco(int id);
	List<Map<String, Object>> listarSocioBanco(int id);

	List<Map<String,Object>> listarRecursosSesion(int idsesion, int idsocio);
	List<Map<String,Object>> listarseminario(int iddistrito, int idseminario);
	List<Map<String,Object>> listarseminariobanco(int idbanco, int idseminario);

}
