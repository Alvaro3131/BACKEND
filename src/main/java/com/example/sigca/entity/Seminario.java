package com.example.sigca.entity;

import java.time.LocalDateTime;

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
	@Column(name = "id_seminario")
	int ID_SEMINARIO;
	
	@Column(name = "no_seminario")
	public String NO_SEMINARIO;
	
	@Column(name = "fe_incio")
	public LocalDateTime FE_INICIO;
	
	@Column(name = "fe_fin")
	public LocalDateTime FE_FIN;
	
	@Column(name = "URL_SEMINARIO")
	public String URL_SEMINARIO;
}
