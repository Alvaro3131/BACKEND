package com.example.sigca.entity;

import java.util.List;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_distrito")
public class Distrito {
	
	//JOSUE DOMINGUEZ
	
	
	
	
	public Distrito(String no_distrito, Sede sede) {
		super();
		this.no_distrito = no_distrito;
		this.sede=sede;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_distrito")
	private int id_distrito;


	@Column(name="no_distrito")
	private String no_distrito;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_sede",referencedColumnName = "id_sede")
	private Sede sede;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY ,mappedBy ="distrito" )
	//@JoinColumn(name = "id_bancocomunal")
	private List<BancoComunal> banco;
	
	
	
	
	
}
