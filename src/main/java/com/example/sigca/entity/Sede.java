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
@Table(name="tbl_sede")
public class Sede implements Serializable{
	
	//JOSUE DOMINGUEZ 
	
	private static final long serialVersionUID = -1942395296462336245L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_sede")
	public int idsede;
	
	@Column(name="no_sede")
	public String nombreSede;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_distrito")
	public Set<Distrito> distrito;
	
	
}

