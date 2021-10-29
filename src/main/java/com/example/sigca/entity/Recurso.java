package com.example.sigca.entity;

import java.io.Serializable;
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
@Table(name = "tbl_recurso")
public class Recurso implements Serializable {
	private static final long serialVersionUID = -1016636679259223396L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_recurso")
	private int id;
	@Column(name = "no_recurso")
	private String nombre;
	@Column(name = "se_orden")
	private int orden;
	@Column(name = "desc_recurso")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "fk_tipo", nullable = false)
	private Tipo tipo;
	
	@ManyToOne
	@JoinColumn(name = "fk_sesion", nullable = false)
	private Sesion sesion;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pregunta")
	private Set<Pregunta> preguntas;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_asistencia_recurso")
	private Set<Asistencia_Seminario> asistencia_Seminarios;
	
}
