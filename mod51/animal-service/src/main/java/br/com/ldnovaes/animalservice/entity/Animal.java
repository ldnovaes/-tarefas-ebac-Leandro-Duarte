package br.com.ldnovaes.animalservice.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_animal", discriminatorType = DiscriminatorType.STRING)
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private String nomeProvisorio;
	
	@Column(nullable = false)
	private Integer idadeEstimada;
	
	@Column(nullable = false)
	private Date dataEntrada;
	
	@Column
	private Date dataAdocao;
	
	@Column(nullable = false)
	private String condicoesChegada;
	
	@Column(nullable = false)
	private String nomeRecebedor;
	
	@Column
	private Date dataObito;
	
	@Column(name = "tipo_animal", insertable = false, updatable = false)
	private String tipoAnimal;

}
