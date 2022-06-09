package br.com.alura.spring.data.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class RelatoriosService {

	private final FuncionarioRepository repository;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private boolean system = true;

	public RelatoriosService(FuncionarioRepository repository) {
		this.repository = repository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual ação de cargo você quer executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Buscar Funcionario por Nome");
			System.out.println("2 - Buscar Funcionario por Nome, Salario e Data");
			System.out.println("3 - Buscar Funcionario por Data de Contratação");
			System.out.println("4 - Buscar Funcionario usando projecao");

			int action = scanner.nextInt();
			switch (action) {
			case 0:
			default:
				system = false;
				break;
			case 1:
				buscaFuncionario(scanner);
				break;
			case 2:
				buscaFuncionarioEspecifico(scanner);
				break;
			case 3:
				buscaFuncionarioPorData(scanner);
				break;
			case 4:
				buscaFuncionarioSalario();
				break;
			}
		}
	}

	private void buscaFuncionarioSalario() {
		Collection<FuncionarioProjecao> funcionarios = repository.findFuncionarioSalario();
		funcionarios.forEach(f -> System.out.println(String.format("Funcionario -> id: %d, nome: %s, salario: R$ %s",
				f.getId(), f.getNome(), f.getSalario().toString())));
	}

	private void buscaFuncionarioPorData(Scanner scanner) {
		System.out.println("Digite a data de contratação desejada");
		LocalDate data = LocalDate.parse(scanner.next(), formatter);
		Collection<Funcionario> funcionarios = repository.findDataContratacaoMaior(data);
		funcionarios.forEach(System.out::println);
	}

	private void buscaFuncionario(Scanner scanner) {
		System.out.println("Digite o nome do funcionário desejado");
		String nome = scanner.next();
		Collection<Funcionario> funcionarios = repository.findByNome(nome);
		funcionarios.forEach(System.out::println);
	}

	private void buscaFuncionarioEspecifico(Scanner scanner) {
		System.out.println("Digite o nome do funcionário desejado");
		String nome = scanner.next();

		System.out.println("Digite a data de contratacao do funcionário desejado");
		LocalDate data = LocalDate.parse(scanner.next(), formatter);

		System.out.println("Digite o salario do funcionário desejado");
		BigDecimal salario = new BigDecimal(scanner.nextDouble());

		Collection<Funcionario> funcionarios = repository.findNomeSalarioMaiorDataContratacao(nome, data, salario);
		funcionarios.forEach(System.out::println);
	}
}
