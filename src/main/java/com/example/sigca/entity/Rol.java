package com.example.sigca.entity;

import java.io.Serializable;
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_rol")
public class Rol implements Serializable{
	
	//Carlos Gutierrez Acosta
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_rol")
	public int idrol;
	public Rol(String nombrerol) {
		super();
		this.nombrerol = nombrerol;
	}
	
	
	@Column(name="no_rol")
	public String nombrerol;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY ,mappedBy ="rol")
	private Set<RolPrivilegios> rolprivilegios;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY ,mappedBy ="rol")
	private Set<RolUsuario> rolusuario;
	
}
