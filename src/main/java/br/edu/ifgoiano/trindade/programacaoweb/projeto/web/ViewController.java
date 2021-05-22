package br.edu.ifgoiano.trindade.programacaoweb.projeto.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/")
    public String index(Model model) {
        return "index.html";
    }

//	@RequestMapping("/usuario/{id}")
//	public String usuario(@PathVariable("id") Integer id, Model model) {
//		model.addAttribute("id", id);
//		return "paginaInicial";
//	}

}