package br.edu.ifgoiano.trindade.programacaoweb.projeto.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
}
