package com.example.sigca.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "tbl_usuario" )
public class Usuario {
	@Id
	@Column(name = "id_persona")
	int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	public Persona persona;
	
	@Column(name = "US_NOMBRE")
	public String  user;
	
	@Column(name = "PW_USUARIO")
	public String  pass;
	
	@OneToMany( cascade = CascadeType.ALL)
	@JoinColumn(name = "id_rol_usuario")
	private Set<RolUsuario> rolusuario;
	/*
	@OneToMany( cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pedidooracion")
	private Set<Pedido> pedido;
	
    @OneToMany( cascade = CascadeType.ALL)
	@JoinColumn(name = "id_asistencia_recurso")
	private Set<asistenciaRecurso> asistenciarecurso;
	
    @OneToMany( cascade = CascadeType.ALL)
	@JoinColumn(name = "id_asistencia_seminario")
	private Set<AsistenciaSeminario> asistenciaseminario;
	
	
	*/
	
}
