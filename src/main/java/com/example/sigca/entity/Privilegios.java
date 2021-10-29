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
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_privilegios")
public class Privilegios implements Serializable{
	
	//Carlos Gutierrez Acosta
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_privilegios")
	public int idprivilegios;
	@Column(name="no_privilegios")
	public String nombreprivilegios;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_rol_privilegios")
	private Set<RolPrivilegios> rolprivilegios;
	
}
