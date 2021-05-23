package br.edu.ifgoiano.trindade.programacaoweb.projeto.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.EmpresaRepository;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Servico;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ServicoRepository;

@RestController
@RequestMapping("/servico")
public class ServicoController extends AbstractController<Servico> {

	@Autowired
	private ServicoRepository rep;
	
	@Autowired
	private EmpresaRepository empresaRep;

	@GetMapping(path="/empresa/{id}")
	public List<Servico> getServicosByEmpresa(@PathVariable("id") Integer id) {
		return rep.findByEmpresa(empresaRep.findById(id));
	}
	
	@Override
	public JpaRepository<Servico, Integer> getRepository() {
		return this.rep;
	}
}