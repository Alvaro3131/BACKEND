package com.example.sigca.entity;

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
@Table(name = "tbl_bancocomunal" )
public class BancoComunal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bancocomunal")
	private int id_bancocomunal;
	
	@Column(name = "no_bancocomunal")
	private String no_bancocomunal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_asesor", referencedColumnName = "id_persona")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Asesor asesor;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "banco")
	private List<Socio> socio;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_distrito", referencedColumnName = "id_distrito")
	private Distrito distrito;
	
	
	/*
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "banco")
	//@JoinColumn(name = "id_programa_capacitacion")
	private List<ProgramaSeminario> ps;
	
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "banco")
	//@JoinColumn(name = "id_programacion")
	private List<Programacion> programacion;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "banco")
	//@JoinColumn(name = "id_persona")
	private List<Socio> socio;
	*/
}
