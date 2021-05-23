package br.edu.ifgoiano.trindade.programacaoweb.projeto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Cliente;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ClienteRepository;

@Controller
@RequestMapping(path = "/clientes")
public class RegistrarClienteController extends HtmlController<Cliente, Integer> {

	 @Autowired
	    private ClienteRepository clienteRepository;

	    @Override
	    public String getNome() {
	        return "clientes";
	    }

	    @Override
	    protected JpaRepository<Cliente, Integer> getRepository() {
	        return clienteRepository;
	    }
}
