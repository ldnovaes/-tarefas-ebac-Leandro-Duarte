package br.com.ldnovaes.animalservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ldnovaes.animalservice.entity.Animal;

public interface AnimalRepositorio extends JpaRepository<Animal, Long>{
	
	@Query(value = "SELECT a from Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada ASC")
	List<Animal> findNotAdopted();
	
	@Query(value = "SELECT a from Animal a WHERE a.dataAdocao IS NOT NULL ORDER BY a.dataEntrada ASC")
	List<Animal> findAdopted();
	
	@Query(value = "SELECT a from Animal a WHERE a.tipoAnimal = 'CACHORRO'")
	List<Animal> findDogs();
	
	@Query(value = "SELECT a from Animal a WHERE a.tipoAnimal = 'GATO'")
	List<Animal> findCats();
	
	@Query(value = "SELECT a from Animal a WHERE a.nomeRecebedor = :nomeRecebedor")
	List<Animal> findByEmployee(@Param("nomeRecebedor") String nomeRecebedor);
}
