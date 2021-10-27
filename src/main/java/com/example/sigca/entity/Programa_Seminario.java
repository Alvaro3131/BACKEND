package com.example.sigca.entity;

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
//Tabla Ariana 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_programa_seminario")
public class Programa_Seminario {
		
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int ID_PROGRAMA_CAPACITACION;
	
	
	@ManyToOne
	@JoinColumn(name = "fk_bancocomunal", nullable = false)
	private BancoComunal banco;
}
