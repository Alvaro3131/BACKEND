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
@Table(name="tbl_distrito")
public class Distrito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_distrito")
	public int id_distrito;
	@Column(name="no_distrito")
	public String no_distrito;
	
	@ManyToOne
	@JoinColumn(name="fk_sede",nullable = false)
	public Sede sede;
	
	
	
	
	
	
	
}
