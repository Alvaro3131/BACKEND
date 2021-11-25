package com.example.sigca.service;

import java.util.List;
import java.util.Map;





public interface ParticipacionService {
	List<Map<String, Object>> listarParticipacionSesion(int banco, int modulo);
	List<Map<String, Object>> listaProgramaAsesor(int id);
	List<Map<String, Object>> participantes(int banco, int modulo);
	String insertarMasivo(String modulo, String banco);
}
