package com.example.sigca.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_programa_seminario" )
public class ProgramaSeminario{
 
	public ProgramaSeminario(Seminario seminario, BancoComunal banco) {
		super();
		this.seminario = seminario;
		this.banco = banco;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_programa_capacitacion")
	private int id_programa_capacitacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_seminario", referencedColumnName = "id_seminario")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Seminario seminario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_bancocomunal", referencedColumnName = "id_bancocomunal")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private BancoComunal banco;

}
