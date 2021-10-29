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
@Table(name = "tbl_pregunta")
public class Pregunta implements Serializable {
	
	private static final long serialVersionUID = 4868757099978767253L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pregunta")
	private int id;
	@Column(name = "no_pregunta")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "id_recurso", nullable = false)
	private Recurso recurso;
	
}
