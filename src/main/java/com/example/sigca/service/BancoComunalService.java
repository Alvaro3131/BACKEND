package com.example.sigca.service;

import java.util.List;
import java.util.Optional;

import com.example.sigca.entity.BancoComunal;

public interface BancoComunalService {
	List<BancoComunal> listarBancoComunal();
	String insertarBanco(BancoComunal banco);
	BancoComunal buscarBanco(int id_bancocomunal);
	String eliminarBanco(int id_bancocomunal);
	String actualizarBanco(BancoComunal banco);
	List<BancoComunal> buscarDistrito(int id);
	List<BancoComunal> listarBancoComunalSede(int id);
}
