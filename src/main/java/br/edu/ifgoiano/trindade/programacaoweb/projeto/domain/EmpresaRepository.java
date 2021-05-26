package br.edu.ifgoiano.trindade.programacaoweb.projeto.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{

	Empresa findByEmail(String email);
}
