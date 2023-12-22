package br.com.ldnovaes.animalservice.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class AnimalDTO {

	private Long id;

	private String nomeProvisorio;

	private Integer idadeEstimada;

	private Date dataEntrada;

	private Date dataAdocao;

	private String condicoesChegada;

	private String nomeRecebedor;

	private Date dataObito;
	
	private String tipoAnimal;

}
