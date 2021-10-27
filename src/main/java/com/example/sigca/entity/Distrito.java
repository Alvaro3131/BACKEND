package com.example.sigca.entity;

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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_distrito")
	public int id_distrito;
	@Column(name="no_distrito")
	public String no_distrito;
	
	@ManyToOne
	@JoinColumn(name="FK_SEDE",nullable = false)
	public Sede sede;
	
	@OneToMany( cascade = CascadeType.ALL)
	@JoinColumn(name = "id_bancocomunal")
	private Set<BancoComunal> banco;
	
	
	
	
	
}
