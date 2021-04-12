package br.edu.ifgoiano.trindade.programacaoweb.projeto.test;

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
		Integer opcao = Integer.parseInt(JOptionPane.showInputDialog(
				"1- Nova Empresa\n" + "2- Novo Cliente\n" + "3- Entrar como Empresa\n" + "4- Entrar como Cliente\n"));

		if (opcao == 1) {
			this.cadastrarNovaEmpresa();
		} else if (opcao == 2) {
			this.cadastrarNovoCliente();
		} else if(opcao == 3) {
			
		}
	}

	public void cadastrarNovaEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setNome(JOptionPane.showInputDialog("Digite o nome da Empresa: "));
		empresa.setEmail(JOptionPane.showInputDialog("Digite o email da Empresa: "));
		empresa.setDescricao(JOptionPane.showInputDialog("Digite o descricao da Empresa: "));
		empresa.setRamo(JOptionPane.showInputDialog("Digite o ramo da Empresa: "));

		empresaRep.save(empresa);
	}

	public void cadastrarNovoCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome(JOptionPane.showInputDialog("Digite o nome do Cliente: "));
		cliente.setEmail(JOptionPane.showInputDialog("Digite o email do Cliente: "));
		cliente.setTelefone(JOptionPane.showInputDialog("Digite o telefone do Cliente: "));

		clienteRep.save(cliente);
	}
}
