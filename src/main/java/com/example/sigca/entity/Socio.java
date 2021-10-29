package com.example.sigca.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	public Persona persona;
	
	@Column(name = "es_socio")
	public int  estado;
	
	@ManyToOne
	@JoinColumn(name="fk_bancocomunal", nullable = false)
	public BancoComunal banco;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_ASISTENCIA_SEMINARIO")
	public Set<Asistencia_Seminario> as;
}
