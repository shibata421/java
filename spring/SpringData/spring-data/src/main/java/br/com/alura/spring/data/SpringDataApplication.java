package br.com.alura.spring.data;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeTrabalhoService;
import br.com.alura.spring.data.service.RelatorioFuncionarioDinamico;
import br.com.alura.spring.data.service.RelatoriosService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;
	private boolean system = true;
	private final RelatoriosService relatoriosService;
	private final RelatorioFuncionarioDinamico dinamicoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeTrabalhoService unidadeService;
	
	public SpringDataApplication(
			CrudCargoService cargoService, 
			CrudFuncionarioService funcionarioService, 
			CrudUnidadeTrabalhoService unidadeService,
			RelatoriosService relatoriosService,
			RelatorioFuncionarioDinamico dinamicoService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.relatoriosService = relatoriosService;
		this.unidadeService = unidadeService;
		this.dinamicoService = dinamicoService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);
		
		while(system) {
			System.out.println("Qual ação você quer executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidades de Trabalho");
			System.out.println("4 - Relatorios");
			System.out.println("5 - Relatorios Dinâmicos");
			
			int action = scanner.nextInt();
			switch (action) {
			case 0:
			default:
				system = false;
				break;
			case 1:
				cargoService.inicial(scanner);
				break;
			case 2:
				funcionarioService.inicial(scanner);
				break;
			case 3:
				unidadeService.inicial(scanner);
				break;
			case 4:
				relatoriosService.inicial(scanner);
				break;
			case 5:
				dinamicoService.inicial(scanner);
				break;
			}
		}
		System.out.println("Tchau!");
		scanner.close();
	}
}
