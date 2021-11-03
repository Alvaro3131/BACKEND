package com.example.sigca.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_socio" )

public class Socio {
		
	@Id
	@Column(name = "id_persona")
	int id;

	
	@Column(name = "es_socio")
	public int  estado;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	@JsonBackReference
	public Persona persona;
	
	@ManyToOne
	@JoinColumn(name="fk_bancocomunal", nullable = false)
	public BancoComunal banco;
	
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "socio")
	//@JoinColumn(name="id_distrito")
	private List<Asistencia_Seminario> as;
	
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "socio")
	//@JoinColumn(name="id_distrito")
	private List<PedidoOracion> pedido;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "socio")
	//@JoinColumn(name="id_distrito")
	private List<AsistenciaRecurso> asistenciarecurso;
	
    @OneToMany
	@JoinColumn(name = "id_inscripcion")
	private Set<Inscripcion> inscripciones;
}
