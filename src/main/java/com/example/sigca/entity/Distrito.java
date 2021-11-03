package com.example.sigca.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_distrito")
public class Distrito {
	
	//JOSUE DOMINGUEZ
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_distrito")
	private int id_distrito;
	@Column(name="no_distrito")
	private String no_distrito;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="FK_SEDE",referencedColumnName = "id_sede")
	private Sede sede;
	
	@OneToMany(fetch = FetchType.LAZY ,mappedBy ="distrito" )
	//@JoinColumn(name = "id_bancocomunal")
	private List<BancoComunal> banco;
	
	
	
	
	
}
