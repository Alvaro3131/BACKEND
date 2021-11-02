package com.example.sigca.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_categoria")
public class Categoria {
	
	//JOSUE DOMINGUEZ 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_categoria")
	private int id_categoria;
	@Column(name="no_categoria")
	private String no_categoria;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	//@JoinColumn(name="id_modulo")
	private List<Modulo> modulo;
	
	
}
