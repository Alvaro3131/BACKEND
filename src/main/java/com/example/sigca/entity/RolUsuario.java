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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_rol_usuario")
public class RolUsuario implements Serializable{
	
	//Carlos Gutierrez Acosta
	
	private static final long serialVersionUID = -1942395296462336245L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_rol_usuario")
	public int idrolusuario;
	
	
	
	@ManyToOne
	@JoinColumn(name="fk_usuario", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="fk_rol", nullable = false)
	private Rol rol;
	
}