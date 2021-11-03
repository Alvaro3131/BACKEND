package com.example.sigca.entity;





import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_asesor" )

public class Asesor {
	@Id
	@Column(name = "id_persona")
	public int id_persona;
	@Column(name = "es_asesor")
	public String es_asesor;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	@JsonBackReference
	public Persona persona;
	

	
	
/*
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "asesor")
	//@JoinColumn(name="id_bancocomunal")
	@JsonBackReference
	private List<BancoComunal> banco;
*/	
}

