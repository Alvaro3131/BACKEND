package com.example.sigca.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_sesion")

public class Sesion implements Serializable {

	//PAULO HUAMAN (QBay)(
	
	private static final long serialVersionUID = -1942395296462336245L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_SESION")
	private int ID_SESION;
	@Column(name="NO_SESION")
	private String NO_SESION;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="FK_MODULO",referencedColumnName = "id_modulo")
	private Modulo modulo;
	
	@Column(name="NU_RECURSOS")
	private String no_recursos;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sesion")
	//@JoinColumn(name = "id_recurso")
	private List<Recurso> recurso;
	
}
