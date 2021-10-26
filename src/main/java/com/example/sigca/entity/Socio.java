package com.example.sigca.entity;

import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Socio {
		
	@Id
	@Column(name = "id_persona")
	int id;
	
	@Column(name = "es_socio")
	public int  estado;
	
	@ManyToOne
	@JoinColumn(name="fk_bancocomunal", nullable = false)
	public BancoComunal banco;
}
