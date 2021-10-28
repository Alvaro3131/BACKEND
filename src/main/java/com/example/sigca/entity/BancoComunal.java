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
@Table(name = "tbl_bancocomunal" )
public class BancoComunal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bancocomunal")
	public int id_bancocomunal;
	
	@Column(name = "no_bancocomunal")
	public String no_bancocomunal;
	
	@ManyToOne
	@JoinColumn(name="fk_distrito", nullable = false)
	public Distrito distrito;
	
	@ManyToOne
	@JoinColumn(name="fk_asesor", nullable = false)
	public Asesor asesor;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_programa_capacitacion")
	private Set<ProgramaSeminario> ps;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_programacion")
	private Set<Programacion> programacion;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_persona")
	private Set<Socio> socio;
	
	
}
