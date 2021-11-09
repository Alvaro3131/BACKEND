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
@Table(name="tbl_sede")
public class Sede implements Serializable{
	
	//JOSUE DOMINGUEZ 
	
	private static final long serialVersionUID = -1942395296462336245L;
	
	
	
	public Sede(String nombreSede) {
		super();
		this.no_sede = nombreSede;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_sede")
	private int id_sede;
	
	@Column(name="no_sede")
	private String no_sede;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sede")
	//@JoinColumn(name="id_distrito")
	private List<Distrito> distrito;
	
	
}

