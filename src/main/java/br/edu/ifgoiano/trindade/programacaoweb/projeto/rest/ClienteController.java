package br.edu.ifgoiano.trindade.programacaoweb.projeto.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Cliente;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController extends AbstractController<Cliente> {

	@Autowired
	private ClienteRepository rep;

	@Override
	public JpaRepository<Cliente, Integer> getRepository() {
		return this.rep;
	}
}