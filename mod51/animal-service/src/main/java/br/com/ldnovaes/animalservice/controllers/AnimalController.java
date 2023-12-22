package br.com.ldnovaes.animalservice.controllers;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<AnimalDTO> findByEmployee(@PathVariable String nomeRecebedor) {
		return this.service.findByEmployee(nomeRecebedor);
	}
	
	@GetMapping("/{nomeRecebedor}/count")
    public Map<String, Object> countAnimalsRescuedByDates(
    		@PathVariable String nomeRecebedor,
            @RequestParam("initial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam("final") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {

        Duration diff = Duration.between(dataInicial.atStartOfDay(), dataFinal.atStartOfDay());
        Duration umAno = Duration.ofDays(365);
        
        if (diff.compareTo(umAno) > 0) {
        	Map<String, Object> erro = new HashMap<>();
        	erro.put("erro", "Intervalor maior que um ano");
        	return erro;
        }
        
        return this.service.countAnimalsRescuedByDates(nomeRecebedor, dataInicial, dataFinal);
    }
}
