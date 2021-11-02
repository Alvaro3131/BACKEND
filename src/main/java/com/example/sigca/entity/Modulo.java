package com.example.sigca.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_modulo")
public class Modulo {
	
	//JOSUE DOMINGUEZ
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_modulo")
	int id_modulo;
	@Column(name = "no_modulo")
	String no_modulo;
	
	// Enlaze con categoria
	@ManyToOne
	@JoinColumn(name="fk_categoria", nullable = false)
	public Categoria categoria;
	
	@Column(name = "NU_SESIONES")
	String nu_sesiones;
	
	// Enlace con programacion
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_programacion")
	private Set<Programacion> programacion;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_sesion")
	private Set<Sesion> sesion;
	
	
}
