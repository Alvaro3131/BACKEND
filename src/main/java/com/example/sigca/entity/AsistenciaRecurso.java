package com.example.sigca.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_asistencia_recurso")
public class AsistenciaRecurso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_asistencia_recurso")
	int id_asistencia_recurso;
	@Column( name = "fk_socio")
	int fk_socio;
	@Column( name = "fk_recurso")
	int fk_recurso;
	@Column( name = "es_asistencia")
	int es_asistencia;
	@Column( name = "nu_valoracion")
	int nu_valoracion;
	
	//enlaces...
}
