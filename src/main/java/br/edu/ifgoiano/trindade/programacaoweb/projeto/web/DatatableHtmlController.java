package br.edu.ifgoiano.trindade.programacaoweb.projeto.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Empresa;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.EmpresaRepository;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Servico;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ServicoRepository;

@Controller
@RequestMapping(path = "/servicos")
public class DatatableHtmlController extends HtmlController<Servico, Integer> {

	@Autowired
	private ServicoRepository servicoRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@GetMapping("/empresa/{id}")
	public ModelAndView listarServicosEmpresa(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("/" + getNome());
		List<Servico> servicos = servicoRepository.findByEmpresa(empresaRepository.findById(id));
		mv.addObject("objetos", servicos);
		mv.addObject("id", id);

		return mv;
	}
	
	@RequestMapping("/add")
	@Override
	public ModelAndView add(Servico obj) {
		ModelAndView mv = new ModelAndView("/" + getNome() + "Add");
		mv.addObject("objeto", obj);
		
		Empresa empresa = new Empresa();
		mv.addObject("e", empresa);
		
		List<Empresa> empresas = empresaRepository.findAll();
		mv.addObject("empresas", empresas);
		return mv;
	}

	@Override
	public String getNome() {
		return "servicos";
	}

	@Override
	protected JpaRepository<Servico, Integer> getRepository() {
		return servicoRepository;
	}
}