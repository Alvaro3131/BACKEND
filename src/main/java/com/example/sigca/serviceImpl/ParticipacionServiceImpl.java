package com.example.sigca.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.example.sigca.repository.DtoRepository;
import com.example.sigca.service.ParticipacionService;
@Service
public class ParticipacionServiceImpl implements ParticipacionService  {

	@Autowired
	public DtoRepository dtoRepository;
	@Override
	public List<Map<String, Object>> readall(int banco, int modulo) {
		// TODO Auto-generated method stub
		return dtoRepository.listarDto(banco, modulo);
	}
	@Override
	public String insertarMasivo(String modulo, String banco) {
		// TODO Auto-generated method stub
		return dtoRepository.insertarMasico(modulo, banco);
	}


}
