package com.example.sigca.entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tbl_seminario")

public class Seminario {
	//Tabla_Ariana 
	
	public Seminario(String nO_SEMINARIO, String fE_INICIO, String fE_FIN, String uRL_SEMINARIO) {
		super();
		NO_SEMINARIO = nO_SEMINARIO;
		FE_INICIO = fE_INICIO;
		FE_FIN = fE_FIN;
		URL_SEMINARIO = uRL_SEMINARIO;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SEMINARIO")
	int ID_SEMINARIO;
	

	@Column(name = "NO_SEMINARIO")
	public String NO_SEMINARIO;
	
	@Column(name = "FE_INICIO")
	public String FE_INICIO;
	
	@Column(name = "FE_FIN")
	public String FE_FIN;
	
	@Column(name = "URL_SEMINARIO")
	public String URL_SEMINARIO;
	
    @JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "seminario")
	private Set<AsistenciaSeminario> as;
	
    @JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "seminario")
	//@JoinColumn(name="id_programa_capacitacion")
	private Set<ProgramaSeminario> ps;
	
	
}
