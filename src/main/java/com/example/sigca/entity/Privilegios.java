package com.example.sigca.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	public Privilegios(String nombreprivilegios) {
		super();
		this.nombreprivilegios = nombreprivilegios;
	}

	@Column(name="no_privilegios")
	public String nombreprivilegios;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<RolPrivilegios> rolprivilegios;
	
	
	
}
