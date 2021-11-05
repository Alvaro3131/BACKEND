package com.example.sigca.entity;

import java.io.Serializable;
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
	
	public Pregunta(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pregunta")
	private int id;
	
	@Column(name = "no_pregunta")
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "fk_recurso", referencedColumnName = "id_recurso")
	private Recurso recurso;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pregunta")
	//@JoinColumn(name = "id_alternativa")
	private List<Alternativa> alternativa;
}
