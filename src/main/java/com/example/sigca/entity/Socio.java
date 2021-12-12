package com.example.sigca.entity;


import java.util.List;

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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private int id;

	
	@Column(name = "es_socio")
	private int  estado;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Persona persona;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_BANCOCOMUNAL",referencedColumnName = "id_bancocomunal")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private BancoComunal banco;
	
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "socio")
	private List<PedidoOracion> pedido;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "socio")
	private List<Inscripcion> inscripcion;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "socio")
	private List<AsistenciaSeminario> as;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "socio")
	private List<AsistenciaRecurso> ar;
	
	/*
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "socio")
	private List<PedidoOracion> pedido;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "socio")
	private List<Inscripcion> inscripcion;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "socio")
	private List<Asistencia_Seminario> as;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "socio")
	private List<AsistenciaRecurso> ar;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="FK_BANCOCOMUNAL",referencedColumnName = "id_bancocomunal")
	private BancoComunal banco;

    */
}
