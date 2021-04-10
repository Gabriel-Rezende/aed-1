package br.edu.ifgoiano.trindade.programacaoweb.projeto.rest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Domain;


public abstract class AbstractController <T extends Domain> {

	public abstract JpaRepository<T, Integer> getRepository();
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<T> getAll() {
		return getRepository().findAll();
	}
	
	@GetMapping(path="/{id}")
	public T getById(@PathVariable Integer id) {
		return getRepository().findById(id).get();
	}
	
	@PostMapping(path="")
	public T insert(@RequestBody T obj) {
		return getRepository().save(obj);
	}
	
	@PutMapping(path="")
	public T update(@RequestBody T obj) {
		return getRepository().save(obj);
	}
	
	@DeleteMapping(path="/{id}")
	public void delete(@PathVariable Integer id) {
		getRepository().deleteById(id);
	}	
}