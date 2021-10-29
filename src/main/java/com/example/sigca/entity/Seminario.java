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
@Table(name = "tbl_seminario")
//Tabla Ariana 
public class Seminario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SEMINARIO")
	int ID_SEMINARIO;
	
	@Column(name = "NO_SEMINARIO")
	public String NO_SEMINARIO;
	
	@Column(name = "FE_INICIO")
	public String FE_INICIO;
	
	@Column(name = "FE_FIN")
	public String FE_FIN;
	
	@Column(name = "URL_SEMINARIO")
	public String URL_SEMINARIO;
	
	
	
}
