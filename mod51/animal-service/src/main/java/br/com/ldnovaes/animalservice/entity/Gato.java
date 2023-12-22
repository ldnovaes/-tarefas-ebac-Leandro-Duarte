package br.com.ldnovaes.animalservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("GATO")
public class Gato extends Animal {
	
	@Column
	private String corPelagem;
}
