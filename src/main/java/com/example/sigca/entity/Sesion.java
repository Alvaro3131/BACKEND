package com.example.sigca.entity;

import java.io.Serializable;
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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_sesion")

public class Sesion implements Serializable {

	private static final long serialVersionUID = -1942395296462336245L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_SESION")
	public int ID_SESION;
	@Column(name="NO_SESION")
	public String NO_SESION;
	@ManyToOne
	@JoinColumn(name="FK_MODULO",nullable = false)
	public Modulo modulo;
	
	@Column(name="NU_RECURSOS")
	public String no_recursos;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_recurso")
	private Set<Recurso> recurso;
	
}
