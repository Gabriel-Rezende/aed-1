package br.edu.ifgoiano.trindade.programacaoweb.projeto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.EmpresaRepository;

@Controller
public class ViewController {

	@Autowired
    private EmpresaRepository empresaRep;
     
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
}