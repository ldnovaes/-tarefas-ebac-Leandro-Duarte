package br.com.ldnovaes.animalservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("CACHORRO")
public class Cachorro extends Animal{

	@Column
	private String raca;
	
	@Column
	private String porte;

}
