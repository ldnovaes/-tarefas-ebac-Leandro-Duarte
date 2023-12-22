package br.com.ldnovaes.animalservice.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ldnovaes.animalservice.dto.AnimalDTO;
import br.com.ldnovaes.animalservice.dto.CachorroDTO;
import br.com.ldnovaes.animalservice.dto.GatoDTO;
import br.com.ldnovaes.animalservice.entity.Animal;
import br.com.ldnovaes.animalservice.entity.Cachorro;
import br.com.ldnovaes.animalservice.entity.Gato;
import br.com.ldnovaes.animalservice.repository.AnimalRepositorio;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepositorio repository;
	
	public List<AnimalDTO> findAll() {
		return this.getCorrectImplementation(this.repository.findAll());	
	}
	
	public Animal save(Animal animal) {
		return this.repository.save(animal);
	}

	public List<AnimalDTO> findNotAdopted() {
		return this.getCorrectImplementation(this.repository.findNotAdopted());
	}

	public List<AnimalDTO> findAdopted() {
		return this.getCorrectImplementation(this.repository.findAdopted());
	}
	
	public List<AnimalDTO> findDogs() {
		return this.getCorrectImplementation(this.repository.findDogs());
	}

	public List<AnimalDTO> findCats() {
		return this.getCorrectImplementation(this.repository.findCats());
	}
	
	private List<AnimalDTO> getCorrectImplementation(List<Animal> animais) {
		return animais.stream()
		.map(animal -> {
			if (animal.getTipoAnimal().equals("CACHORRO")) {
				CachorroDTO cachorro = CachorroDTO
						.builder()
						.id(animal.getId())
						.tipoAnimal(animal.getTipoAnimal())
						.nomeProvisorio(animal.getNomeProvisorio())
						.idadeEstimada(animal.getIdadeEstimada())
						.dataEntrada(animal.getDataEntrada())
						.dataAdocao(animal.getDataAdocao())
						.condicoesChegada(animal.getCondicoesChegada())
						.nomeRecebedor(animal.getNomeRecebedor())
						.dataObito(animal.getDataObito())
						.raca(((Cachorro) animal).getRaca())
						.porte(((Cachorro) animal).getPorte())
						.build();
				return cachorro;
			}
			
			GatoDTO gato = GatoDTO
					.builder()
					.id(animal.getId())
					.tipoAnimal(animal.getTipoAnimal())
					.nomeProvisorio(animal.getNomeProvisorio())
					.idadeEstimada(animal.getIdadeEstimada())
					.dataEntrada(animal.getDataEntrada())
					.dataAdocao(animal.getDataAdocao())
					.condicoesChegada(animal.getCondicoesChegada())
					.nomeRecebedor(animal.getNomeRecebedor())
					.dataObito(animal.getDataObito())
					.corPelagem(((Gato) animal).getCorPelagem())
					.build();
			return gato;
		})
		.map(animalDto -> (AnimalDTO) animalDto)
		.collect(Collectors.toList());
	}

	public List<AnimalDTO> findByEmployee(String nomeRecebedor) {
		return this.getCorrectImplementation(this.repository.findByEmployee(nomeRecebedor));
	}

	public Map<String, Object> countAnimalsRescuedByDates(String nomeRecebedor, LocalDate dataInicial, LocalDate dataFinal) {

		Date initial = Date.valueOf(dataInicial);
		Date dateFinal = Date.valueOf(dataFinal);
		
		Map<String, Object> animalsPerEmployee = new HashMap<>();
		
		animalsPerEmployee.put(nomeRecebedor, (int) this.findByEmployee(nomeRecebedor).stream()
				.filter(o -> (o.getDataEntrada().after(initial) || o.getDataEntrada().equals(initial)) && (o.getDataEntrada().before(dateFinal) || o.getDataEntrada().equals(dateFinal))).count());
        return animalsPerEmployee;
	}
}
