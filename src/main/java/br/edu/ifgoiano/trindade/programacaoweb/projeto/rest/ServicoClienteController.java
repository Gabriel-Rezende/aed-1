package br.edu.ifgoiano.trindade.programacaoweb.projeto.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ServicoCliente;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ServicoClienteRepository;

@RestController
@RequestMapping("/servico_cliente")
public class ServicoClienteController extends AbstractController<ServicoCliente> {

	@Autowired
	private ServicoClienteRepository rep;

	@Override
	public JpaRepository<ServicoCliente, Integer> getRepository() {
		return this.rep;
	}
}