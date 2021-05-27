package br.edu.ifgoiano.trindade.programacaoweb.projeto.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoClienteRepository extends JpaRepository<ServicoCliente, Integer> {
	
	List<ServicoCliente> findByServico(Servico servico);
}
