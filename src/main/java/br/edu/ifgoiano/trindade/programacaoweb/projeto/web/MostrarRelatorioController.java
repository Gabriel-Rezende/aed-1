package br.edu.ifgoiano.trindade.programacaoweb.projeto.web;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ServicoCliente;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ServicoClienteRepository;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ServicoRepository;

@Controller
@RequestMapping(path = "/relatorio")
public class MostrarRelatorioController extends HtmlController<Servico, Integer> {

	@Autowired
	private ServicoRepository servicoRepository;

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private ServicoClienteRepository scRepository;

	@GetMapping("/empresa/{id}")
	public ModelAndView listarServicosEmpresa(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("/show-relatorio");
		Optional<Empresa> emp = empresaRepository.findById(id);
		Empresa empresa = emp.get();
		
		List<Servico> servicos = servicoRepository.findByEmpresa(empresaRepository.findById(id));
		mv.addObject("objetos", servicos);
		
		Set<Servico> set = new HashSet<Servico>();

		Integer qtdServicos = 0, qtdClientes = 0;
		Double arrecadacaoTotal = 0.0, arrecadacaoMensal = 0.0;
		
		Date d = new Date();

		for(ServicoCliente sc: scRepository.findAll()) {
			if(sc.getServico().getEmpresa().equals(empresa)){
				set.add(sc.getServico());
				arrecadacaoTotal += sc.getServico().getPreco();
				qtdClientes++;
				Integer mes = Integer.parseInt(sc.getDataAssinatura().substring(5, 7));
				if(mes == (d.getMonth() + 1)) {
					arrecadacaoMensal += sc.getServico().getPreco();
				}
			}
		}
		
		List<Servico> servicosAux = servicoRepository.findAll();
		for(Servico s: servicosAux) {
			if(s.getEmpresa().getId() == id) {
				qtdServicos++;
			}
		}
		
		DecimalFormat df = new DecimalFormat("#.00");
	    String angleFormated = df.format(arrecadacaoTotal);
	    
	    DecimalFormat fd = new DecimalFormat("#.00");
	    String aux = fd.format(arrecadacaoMensal);
	    
		mv.addObject("arrecadacaoTotal", angleFormated);
		mv.addObject("qtdServicos", qtdServicos);
		mv.addObject("qtdClientes", qtdClientes);
		mv.addObject("arrecadacaoMensal", aux);
		mv.addObject("id", id);
		return mv;
	}

	public void sort(List<Empresa> list) {
		list.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
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