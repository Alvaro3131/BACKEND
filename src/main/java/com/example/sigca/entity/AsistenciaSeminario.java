package com.example.sigca.entity;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_asistencia_seminario")
public class AsistenciaSeminario implements Serializable{
	
	private static final long serialVersionUID = -1942395296462336245L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	@Column(name = "ID_ASISTENCIA_SEMINARIO")
	int ID_ASISTENCIA_SEMINARIO;
	
	
	@Column(name = "ES_ASISTENCIA")
	public int ES_ASISTENCIA;
	
	
	
	@Column(name = "DE_ASISTENCIA")
	public String DE_ASISTENCIA;
	
	@Column(name = "FE_ASISTENCIA")
	public Time FE_ASISTENCIA;
	
	@Column(name = "NU_VALORACION")
	public int NU_VALORACION;
	
	
	@ManyToOne
	@JoinColumn(name="FK_SEMINARIO", referencedColumnName = "ID_SEMINARIO")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public Seminario seminario;
	
	@ManyToOne
	@JoinColumn(name="FK_SOCIO", referencedColumnName = "ID_PERSONA")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public Socio socio;
}
