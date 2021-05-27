package br.edu.ifgoiano.trindade.programacaoweb.projeto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ServicoCliente;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ServicoClienteRepository;

@Controller
@RequestMapping(path = "/servicos-contratados")
public class ServicosContratadosController extends HtmlController<ServicoCliente, Integer> {

	@Autowired
	private ServicoClienteRepository scRepository;

	@Override
	public String getNome() {
		return "servicos-contratados";
	}

	@Override
	protected JpaRepository<ServicoCliente, Integer> getRepository() {
		return scRepository;
	}
}
