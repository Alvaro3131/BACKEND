package com.example.sigca.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private int id_modulo;
	@Column(name = "no_modulo")
	private String no_modulo;
	
	// Enlaze con categoria
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_categoria", referencedColumnName = "id_categoria")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Categoria categoria;
	
	@Column(name = "NU_SESIONES")
	private String nu_sesiones;
	
	// Enlace con programacion
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY ,mappedBy ="modulo")
	private List<Programacion> programacion;
	
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY ,mappedBy ="modulo")
	private List<Sesion> sesion;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY ,mappedBy ="modulo")
	private List<Inscripcion> inscripcion;
}
