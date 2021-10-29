package com.example.sigca.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tbl_programa_seminario" )
public class ProgramaSeminario {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_programa_capacitacion")
	public int id_programa_capacitacion;
	
	@ManyToOne
	@JoinColumn(name="fk_seminario", nullable = false)
	public Seminario seminario;
	
	@ManyToOne
	@JoinColumn(name="fk_bancocomunal", nullable = false)
	public BancoComunal banco;

}
