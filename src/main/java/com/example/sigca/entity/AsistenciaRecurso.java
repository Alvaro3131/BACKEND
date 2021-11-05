package com.example.sigca.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name="tbl_asistencia_recurso")
public class AsistenciaRecurso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_asistencia_recurso")
	int id_asistencia_recurso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn( name = "fk_socio", referencedColumnName = "id_persona")
	private Socio socio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn( name = "fk_recurso", referencedColumnName = "id_recurso")
	private Recurso recurso;
	
	@Column( name = "es_asistencia")
	int es_asistencia;
	
	@Column( name = "nu_valoracion")
	int nu_valoracion;
	
	
}
