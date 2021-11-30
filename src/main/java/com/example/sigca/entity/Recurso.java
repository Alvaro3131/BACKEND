package com.example.sigca.entity;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "tbl_recurso")
public class Recurso implements Serializable {
	private static final long serialVersionUID = -1016636679259223396L;
	
	

	public Recurso(String nombrerecurso, int orden, String descripcion, Sesion sesion, Tipo tipo) {
		super();
		this.nombrerecurso = nombrerecurso;
		this.orden = orden;
		this.descripcion = descripcion;
		this.sesion = sesion;
		this.tipo = tipo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_recurso")
	private int id;
	
	@Column(name = "no_recurso")
	private String nombrerecurso;
	
	@Column(name = "se_orden")
	private int orden;
	
	@Column(name = "desc_recurso")
	private String descripcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_sesion", referencedColumnName = "id_sesion")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Sesion sesion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_tipo", referencedColumnName = "id_tipo")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Tipo tipo;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "recurso")
	private List<Pregunta> pregunta;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "")
	private List<AsistenciaRecurso> asistenciaRecurso;
	
}
