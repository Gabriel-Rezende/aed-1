package br.edu.ifgoiano.trindade.programacaoweb.projeto.test;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Cliente;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ClienteRepository;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Empresa;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.EmpresaRepository;

public class InterfaceGrafica {

	@Autowired
	EmpresaRepository empresaRep;

	@Autowired
	ClienteRepository clienteRep;

	public void menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println(
				"1- Nova Empresa\n" + "2- Novo Cliente\n" + "3- Entrar como Empresa\n" + "4- Entrar como Cliente\n");
		Integer opcao = scan.nextInt();

		if (opcao == 1) {
			this.cadastrarNovaEmpresa();
		} else if (opcao == 2) {
			this.cadastrarNovoCliente();
		} else if (opcao == 3) {

		}
	}

	public void cadastrarNovaEmpresa() {
		Empresa empresa = new Empresa();
		Scanner scan = new Scanner(System.in);
		System.out.println("Nome:");
		empresa.setNome(scan.nextLine());

		System.out.println("Email:");
		empresa.setEmail(scan.nextLine());

		System.out.println("Descricao:");
		empresa.setDescricao(scan.nextLine());

		System.out.println("Ramo:");
		empresa.setRamo(scan.nextLine());

		empresaRep.save(empresa);

		scan.reset();
	}

	public void cadastrarNovoCliente() {
		Cliente cliente = new Cliente();
		Scanner scan = new Scanner(System.in);
		System.out.println("Nome:");
		cliente.setNome(scan.nextLine());

		System.out.println("Email:");
		cliente.setEmail(scan.nextLine());

		System.out.println("Telefone:");
		cliente.setTelefone(scan.nextLine());

		clienteRep.save(cliente);

		scan.reset();
	}

	public void loginEmpresa() {
		Empresa ep = new Empresa();
		Scanner scan = new Scanner(System.in);

		System.out.println("Nome:");
		ep.setNome(scan.nextLine());

		System.out.println("Email:");
		ep.setEmail(scan.nextLine());

		List<Empresa> empresas = empresaRep.findAll();

		boolean loginValido = false;
		for (Empresa s : empresas) {
			if (ep.getNome().equals(s.getNome()) && (ep.getEmail().equals(s.getEmail()))) {
				loginValido = true;
			}
		}

		if (loginValido) {
			// Sessão de empresa
		} else {
			System.out.println("Login inválido!");
			this.menu();
		}

	}
}
