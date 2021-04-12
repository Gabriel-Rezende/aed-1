package br.edu.ifgoiano.trindade.programacaoweb.projeto.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Principal implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		InterfaceGrafica ig = new InterfaceGrafica();
		ig.menu();
	}
}
