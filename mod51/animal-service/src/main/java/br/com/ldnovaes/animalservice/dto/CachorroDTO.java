package br.com.ldnovaes.animalservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class CachorroDTO extends AnimalDTO {

	private String raca;
	
	private String porte;


}
