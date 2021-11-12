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

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_rol_privilegios")
public class RolPrivilegios implements Serializable{
	
	//Carlos Gutierrez Acosta
	
	private static final long serialVersionUID = -1942395296462336245L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_rol_privilegios")
	public int idrolprivilegios;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_rol",referencedColumnName = "id_rol")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Rol rol;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_privilegio",referencedColumnName = "id_privilegios")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Privilegios privilegios;
	
}



/*
@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
@JoinColumn(name="fk_rol", nullable = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
private Rol rol;*/

/*
@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
@JoinColumn(name="fk_privilegio", nullable = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
private Privilegios privilegios;
*/