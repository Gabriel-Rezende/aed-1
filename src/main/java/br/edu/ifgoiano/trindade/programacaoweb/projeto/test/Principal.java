package br.edu.ifgoiano.trindade.programacaoweb.projeto.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Cliente;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ClienteRepository;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Empresa;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.EmpresaRepository;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Servico;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ServicoRepository;

@Component
public class Principal implements CommandLineRunner {

	@Autowired
	private EmpresaRepository empresaRep;

	@Autowired
	private ClienteRepository clienteRep;
	
	@Autowired
	private ServicoRepository servicoRep;

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}

		// Instancia uma Interface Gráfica
		InterfaceGrafica ig = new InterfaceGrafica();

		int auxWhile = 0;
		// Inicia o while
		while (auxWhile != 5) {
			// Limpa as variáveis
			String nome = "";
			String email = "";
			String descricao = "";
			String ramo = "";
			String telefone = "";

			Scanner sc = new Scanner(System.in);

			String aux = "";

			ig.mostrarMenu();

			aux = sc.nextLine();
			// Entra no try que vai tratar se o usuário está digitando um número
			try {
				Integer.parseInt(aux);

				// Menu 1
				if (Integer.parseInt(aux) == 1) {
					// Lê os dados de uma Empresa
					System.out.println("Nome:");
					nome = sc.nextLine();
					System.out.println("Email:");
					email = sc.nextLine();
					System.out.println("Descrição:");
					descricao = sc.nextLine();
					System.out.println("Ramo:");
					ramo = sc.nextLine();
					// Cadastra só se respeitar o tamanho do varchar no banco
					if (nome.length() <= 20 && email.length() <= 30 && descricao.length() <= 50
							&& ramo.length() <= 30) {
						Empresa empresa = new Empresa();
						empresa.setNome(nome);
						empresa.setEmail(email);
						empresa.setDescricao(descricao);
						empresa.setRamo(ramo);

						empresa = empresaRep.save(empresa);

						sc.reset();
					} else {
						// Caso extrapole, joga uma mensagem na tela
						System.out.println("Dados extrapolaram o tamanho permitido");
					}

					// Menu 2
				} else if (Integer.parseInt(aux) == 2) {

					// Lê os dados de um Cliente
					System.out.println("Nome:");
					nome = sc.nextLine();
					System.out.println("Telefone:");
					telefone = sc.nextLine();
					System.out.println("Email:");
					email = sc.nextLine();
					// Cadastra só se respeitar o tamanho do varchar no banco
					if (nome.length() <= 20 && telefone.length() <= 11 && email.length() <= 50) {
						Cliente cliente = new Cliente();
						cliente.setNome(nome);
						cliente.setTelefone(telefone);
						cliente.setEmail(email);

						cliente = clienteRep.save(cliente);

						sc.reset();
					} else {
						// Caso extrapole, joga uma mensagem na tela
						System.out.println("Dados extrapolaram o tamanho permitido");
					}

				}else if(Integer.parseInt(aux) == 3) {
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
			            System.out.println("1- Cadastrar Serviço");
			            scan = new Scanner(System.in);
			            Integer opcao = scan.nextInt();
			            
			            if(opcao == 1) {
			            	Servico servico = new Servico();
			            	scan = new Scanner(System.in);
					        System.out.println("Nome: ");
			            	servico.setNome(scan.next());
					        
			            	System.out.println("Descrição: ");
					        servico.setDescricao(scan.nextLine());
					        
					        System.out.println("Preço: ");
					        servico.setPreco(scan.nextDouble());
					        
					        servico.setEmpresa(ep);
					        
					        servico = servicoRep.save(servico);
			            }
			        } else {
			            System.out.println("Login inválido!");
			        }
				}
			} catch (Exception e) {
				// Joga a mensagem de erro quando o usuário digitar texto ao
				// invés de um número
				System.out.println("Erro, digite um número \n");
			}
			// Limpa o Buffer do scanner
			sc.reset();
		}
	}
}
