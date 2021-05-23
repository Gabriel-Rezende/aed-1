package br.edu.ifgoiano.trindade.programacaoweb.projeto.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
	
	List<Servico> findByEmpresa(Optional<Empresa> optional);
}
