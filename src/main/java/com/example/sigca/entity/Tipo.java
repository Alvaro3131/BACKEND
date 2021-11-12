package com.example.sigca.entity;

import java.io.Serializable;
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
@Table(name="tbl_tipo")
public class Tipo implements Serializable {
		
	private static final long serialVersionUID = 6647357831920610109L;
	
	
		public Tipo(String nombre) {
		super();
		this.nombre = nombre;
	}

		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column(name = "id_tipo")
		private int id_tipo;
		
		@Column(name="no_tipo")
		private String nombre;
		
		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipo")
		private List<Recurso> recurso;
}
