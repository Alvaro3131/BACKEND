package com.example.sigca.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_programacion" )
public class Programacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_programacion")
	int id_programacion;
	
	@Column(name="es_programacion")
	int es_pogramacion;

	//Relacion con modulo
	@ManyToOne
	@JoinColumn(name="fk_modulo",nullable = false)
	public Modulo modulo;
	
	
	//Relacion con banco comunal
	@ManyToOne
	@JoinColumn(name="fk_bancocomunal",nullable = false)
	public BancoComunal banco;
	
}
