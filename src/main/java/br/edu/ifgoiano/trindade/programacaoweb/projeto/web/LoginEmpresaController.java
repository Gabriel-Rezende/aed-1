package br.edu.ifgoiano.trindade.programacaoweb.projeto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Empresa;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.EmpresaRepository;

@Controller
@RequestMapping(path = "/login-empresa")
public class LoginEmpresaController extends HtmlController<Empresa, Integer> {

	@Autowired
	private EmpresaRepository empresaRepository;

	    @Override
	    public String getNome() {
	        return "login-empresa";
	    }

	    @Override
	    protected JpaRepository<Empresa, Integer> getRepository() {
	        return empresaRepository;
	    }	   
}
