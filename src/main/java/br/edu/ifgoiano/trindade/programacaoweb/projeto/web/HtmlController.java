package br.edu.ifgoiano.trindade.programacaoweb.projeto.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.EmpresaRepository;

@Controller
public abstract class HtmlController<T extends Object, ID extends Object> {

	public abstract String getNome();

	protected abstract JpaRepository<T, ID> getRepository();

	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/" + getNome());
		List<T> lista = getRepository().findAll(Sort.by(Sort.Direction.ASC, "nome"));
		mv.addObject("objetos", lista);
		return mv;
	}

	@PostMapping("")
	public ModelAndView inserir(@Valid T obj) {
		getRepository().save(obj);
		ModelAndView mv = new ModelAndView("/" + getNome());
		mv.addObject("objetos", getRepository().findAll(Sort.by(Sort.Direction.ASC, "id")));
		return mv;
	}

	@RequestMapping("/add")
	public ModelAndView add(T obj) {
		ModelAndView mv = new ModelAndView("/" + getNome() + "Add");
		mv.addObject("objeto", obj);
		return mv;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") ID id) {
		return add(getRepository().getOne(id));
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") ID id) {
		getRepository().deleteById(id);
		return listar();
	}

}