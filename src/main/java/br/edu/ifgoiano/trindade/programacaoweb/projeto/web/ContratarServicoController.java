package br.edu.ifgoiano.trindade.programacaoweb.projeto.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Cliente;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ClienteRepository;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Servico;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ServicoCliente;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ServicoRepository;

@Controller
@RequestMapping(path = "/contratar-servico")
public class ContratarServicoController extends HtmlController<Servico, Integer> {

	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public String getNome() {
		return "contratar-servico";
	}

	@GetMapping("/{id}")
	public ModelAndView contratarServico(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("/" + getNome());
		Optional<Servico> s = servicoRepository.findById(id);
		Servico servicos = s.get();
		mv.addObject("servicos", servicos);
		mv.addObject("id", id);
		
		Servico servico = new Servico();
		mv.addObject("s", servico);
		
		Cliente cliente = new Cliente();
		mv.addObject("c", cliente);

		List<Cliente> clientes = clienteRepository.findAll();
		this.sort(clientes);

		mv.addObject("clientes", clientes);
		
		ServicoCliente sc = new ServicoCliente();
		mv.addObject("objeto", sc);
		return mv;
	}

	public void sort(List<Cliente> list) {
		list.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
	}

	@Override
	protected JpaRepository<Servico, Integer> getRepository() {
		return servicoRepository;
	}
}
