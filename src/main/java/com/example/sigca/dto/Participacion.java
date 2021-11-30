package com.example.sigca.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Participacion {
	
	private String nombre;
	private String correo;
	private String participacion;
	private String Sesion;
}
