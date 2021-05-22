package br.edu.ifgoiano.trindade.programacaoweb.projeto.web;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Servico;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ServicoRepository;

@Controller
@RequestMapping(path = "/datatable")
public class DatatableHtmlController extends HtmlController<Servico, Integer> {

    @Autowired
    private ServicoRepository servicoRepository;

    @Override
    public String getNome() {
        return "table-datatable";
    }

    @Override
    protected JpaRepository<Servico, Integer> getRepository() {
        return servicoRepository;
    }



}