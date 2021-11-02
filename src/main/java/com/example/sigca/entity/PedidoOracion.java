package com.example.sigca.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_pedidooracion")
public class PedidoOracion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedidooracion")
	int id_pedidooracion;
	@Column(name = "de_pedidooracion")
	String de_pedidooracion;
	@Column(name = "fe_predidooracion")
	String fe_pedidooracion;
	
	@ManyToOne
	@JoinColumn(name = "fk_persona")
	public Socio socio;
}
