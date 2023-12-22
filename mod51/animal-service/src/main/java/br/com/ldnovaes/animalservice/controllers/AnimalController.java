package br.com.ldnovaes.animalservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ldnovaes.animalservice.dto.AnimalDTO;
import br.com.ldnovaes.animalservice.entity.Animal;
import br.com.ldnovaes.animalservice.entity.Cachorro;
import br.com.ldnovaes.animalservice.entity.Gato;
import br.com.ldnovaes.animalservice.service.AnimalService;

@RestController
@RequestMapping("/animais")
public class AnimalController {
	
	@Autowired
	private AnimalService service;
	
	@GetMapping
	private List<AnimalDTO> findAll() {
		return this.service.findAll();
	}
	
	@GetMapping("/cachorro")
	private List<AnimalDTO> findDogs() {
		return this.service.findDogs();
	}
	
	
	@GetMapping("gato")
	private List<AnimalDTO> findCats() {
		return this.service.findCats();
	}

	@PostMapping("/cachorro")
	@ResponseStatus(code = HttpStatus.CREATED)
	private Animal createDo(@RequestBody Cachorro cachorro) {
		return this.service.save(cachorro);
	}
	
	@PostMapping("/gato")
	@ResponseStatus(code = HttpStatus.CREATED)
	private Animal createCat(@RequestBody Gato gato) {
		return this.service.save(gato);
	}
	
	@GetMapping(path = "/not-adopted")
	private List<AnimalDTO> findNotAdopted() {
		return this.service.findNotAdopted();
	}
	
	@GetMapping(path = "/adopted")
	private List<AnimalDTO> findAdopted() {
		return this.service.findAdopted();
	}
	
	/**
	 * Pode ser possivel visualizar:
	 * http://localhost:8081/animais/Leandro
	 * http://localhost:8081/animais/Dapheny
	 * @param nomeRecebedor
	 * @return
	 */
	@GetMapping("/{nomeRecebedor}")
	public List<AnimalDTO> getCourseById(@PathVariable String nomeRecebedor) {
		return this.service.findByEmployee(nomeRecebedor);
	}
}
