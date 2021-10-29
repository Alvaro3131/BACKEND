package com.example.sigca.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alternativa")
	private int id;
	@Column(name = "no_alternativa")
	private String nombre;
	@Column(name = "nu_valor")
	private int valor;
	
	@ManyToOne
	@JoinColumn(name = "id_pregunta", nullable = false)
	private Pregunta pregunta;
}
