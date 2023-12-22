package br.com.ldnovaes.animalservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class GatoDTO extends AnimalDTO{
		
	private String corPelagem;

}
