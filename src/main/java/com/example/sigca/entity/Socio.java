package com.example.sigca.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Socio {
		
	@Id
	@Column(name = "id_persona")
	int id_persona;
}
