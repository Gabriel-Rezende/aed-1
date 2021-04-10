package br.edu.ifgoiano.trindade.programacaoweb.projeto.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Empresa;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.EmpresaRepository;

@RestController
@RequestMapping("/empresa")
public class EmpresaController extends AbstractController<Empresa> {

	@Autowired
	private EmpresaRepository rep;

	@Override
	public JpaRepository<Empresa, Integer> getRepository() {
		return this.rep;
	}
}