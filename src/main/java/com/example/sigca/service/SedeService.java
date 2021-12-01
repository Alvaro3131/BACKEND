package com.example.sigca.service;

import java.util.List;
import com.example.sigca.entity.Sede;


public interface SedeService{
	String insertarSede (Sede s);
	List<Sede> ListarSede();
	Sede buscarSede(int id_sede);
	String eliminarSede(int id_sede);
	String actualizarSede(Sede s);
}
