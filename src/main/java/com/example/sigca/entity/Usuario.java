package com.example.sigca.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "tbl_usuario" )
public class Usuario {
	@Id
	@Column(name = "id_persona")
	int id;
	
	@Column(name = "US_NOMBRE")
	public String  user;
	
	@Column(name = "PW_USUARIO")
	public String  pass;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	@JsonBackReference
	public Persona persona;
	

	/*
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<RolUsuario> rolusuario;
	*/
	
	
	
	
	
	
}
