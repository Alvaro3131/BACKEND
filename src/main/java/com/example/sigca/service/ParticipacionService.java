package com.example.sigca.service;

import java.util.List;
import java.util.Map;

import com.example.sigca.dto.ParticipacionDto;



public interface ParticipacionService {
	List<Map<String, Object>> readall(int banco, int modulo);
}
