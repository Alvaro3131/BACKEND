package com.example.sigca.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_persona")
public class Persona  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_PERSONA")
	private int id;
	@Column(name="NO_PERSONA")
	private String nombre;
	@Column(name="AP_PATERNO")
	private String paterno;
	@Column(name="AP_MATERNO")
	private String materno;
	@Column(name="CO_DNI")
	private String dni;
	@Column(name="NO_CORREO")
	private String correo;
	@Column(name="NU_TELEFONO")
	private String telefono;
	
	@OneToOne(mappedBy = "persona")
	private Asesor asesor;
	@OneToOne(mappedBy = "persona")
	private Socio socio;
	@OneToOne(mappedBy = "persona")
	private Usuario usuario;
	private static final long serialVersionUID = 1L;
	
	
	
}
