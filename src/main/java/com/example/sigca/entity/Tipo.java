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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_tipo")
public class Tipo implements Serializable {
		private static final long serialVersionUID = -1942395296462336245L;
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column(name = "id_tipo")
		private int id;
		@Column(name="no_tipo")
		private String nombre;
		/*@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name="id_recurso")
		private Set<Recurso> recursos;*/
}