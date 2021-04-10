package br.edu.ifgoiano.trindade.programacaoweb.projeto.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Empresa;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.EmpresaRepository;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Cliente;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ClienteRepository;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Servico;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ServicoRepository;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ServicoCliente;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ServicoClienteRepository;

@Component
public class Principal implements CommandLineRunner {

	@Autowired
	private ServicoClienteRepository servicoClienteRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ServicoRepository servicoRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public void run(String... args) throws Exception {
		
	}

}
