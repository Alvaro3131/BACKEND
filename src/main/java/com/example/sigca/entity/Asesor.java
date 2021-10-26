package com.example.sigca.entity;





import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Asesor {
	@Id
	@Column(name = "id_persona")
	public int id_persona;
	
	@OneToOne(mappedBy = "asesor", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	public Persona persona;
	
	@Column(name = "es_asesor")
	public String es_asesor;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_bancocomunal")
	private Set<BancoComunal> banco;

}

