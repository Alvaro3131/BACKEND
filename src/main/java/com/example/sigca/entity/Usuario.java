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
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	public String  username;
	
	@Column(name = "PW_USUARIO")
	public String  password;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Persona persona;
	
	@Column(name="ESTADO")
	private boolean estado;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<RolUsuario> rolusuario;
	
	public boolean getEstado() {
		return this.estado;
	}
	
	
	
	
	
}
