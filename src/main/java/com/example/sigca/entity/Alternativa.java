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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_alternativa")
public class Alternativa implements Serializable {
	
	private static final long serialVersionUID = 8179352236021303563L;
	
	

	public Alternativa(String nombre, int valor, Pregunta pregunta) {
		super();
		this.nombre = nombre;
		this.valor = valor;
		this.pregunta = pregunta;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alternativa")
	private int id;
	
	@Column(name = "no_alternativa")
	private String nombre;
	
	@Column(name = "nu_valor")
	private int valor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "fk_pregunta", referencedColumnName = "id_pregunta")
	private Pregunta pregunta;
}
