package com.example.sigca.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_inscripcion")
public class Inscripcion implements Serializable{

	private static final long serialVersionUID = -6706191668148771249L;
	
	public Inscripcion(int recursosvistos, int estado) {
		super();
		this.recursosvistos = recursosvistos;
		this.estado = estado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_inscripcion")
	private int id;
	
	@Column(name = "nu_recursosvistos")
	private int recursosvistos;
	
	@Column(name = "es_inscripcion")
	private int estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_socio", referencedColumnName = "id_persona")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Socio socio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_modulo", referencedColumnName = "id_modulo")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Modulo modulo;
	
	
	/*@ManyToOne
	@JoinColumn(name = "fk_socio", nullable = false)
	private Socio socio;
	
	@ManyToOne
	@JoinColumn(name = "fk_modulo", nullable = false)
	private Modulo modulo;*/
	
}
