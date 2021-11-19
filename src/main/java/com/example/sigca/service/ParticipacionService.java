package com.example.sigca.service;

import java.util.List;
import java.util.Map;





public interface ParticipacionService {
	List<Map<String, Object>> readall(int banco, int modulo);
	String insertarMasivo(String modulo, String banco);
}
