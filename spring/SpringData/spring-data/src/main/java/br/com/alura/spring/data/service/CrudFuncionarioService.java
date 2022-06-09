package br.com.alura.spring.data.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;

@Service
public class CrudFuncionarioService {

	private boolean system = true;
	private final FuncionarioRepository funcionarioRepository;
	private final UnidadeTrabalhoRepository unidadeRepository;
	private final CargoRepository cargoRepository;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository,
			UnidadeTrabalhoRepository unidadeRepository, CargoRepository cargoRepository) {
		this.funcionarioRepository = funcionarioRepository;
		this.unidadeRepository = unidadeRepository;
		this.cargoRepository = cargoRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual ação da unidade de trabalho você quer executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			int action = scanner.nextInt();
			switch (action) {
			case 0:
			default:
				system = false;
				break;
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar(scanner);
				break;
			case 4:
				deletar(scanner);
				break;
			}
		}

	}

	private void deletar(Scanner scanner) {
		System.out.println("Digite o id do funcionario a ser deletado: ");
		Long id = scanner.nextLong();
		funcionarioRepository.deleteById(id);
		System.out.println("Deletado");
	}

	private void salvar(Scanner scanner) {
		System.out.println("Nome do funcionario: ");
		String nome = scanner.next();

		System.out.println("CPF do funcionario:");
		String cpf = scanner.next();

		System.out.println("Salario do funcionario:");
		BigDecimal salario = new BigDecimal(scanner.nextDouble());
		
		System.out.println("Data de contratação do funcionario:");
		LocalDate data = LocalDate.parse(scanner.next(), formatter);

		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setSalario(salario);
		funcionario.setDataContratacao(data);
		funcionario.setUnidade(unidade(scanner));
		funcionario.setCargo(cargo(scanner));

		funcionarioRepository.save(funcionario);
		System.out.println("Salvo");
	}
	
	private Cargo cargo(Scanner scanner) {
		System.out.println("Digite o id do cargo: ");
		Long id = scanner.nextLong();
		return cargoRepository.findById(id).orElseThrow();
	}

	private Collection<UnidadeTrabalho> unidade(Scanner scanner) {
		Collection<UnidadeTrabalho> unidades = new ArrayList<>();
		
		Long id;
		do {
			System.out.println("Digite o id da unidade de trabalho ou 0 para sair: ");
			id = scanner.nextLong();
			
			if(id != 0L) {
				unidadeRepository.findById(id).ifPresent(u -> unidades.add(u));
			}
			
		} while(id != 0L);
		
		return unidades;
	}

	private void atualizar(Scanner scanner) {
		System.out.println("Digite o id do funcionario: ");
		Long id = scanner.nextLong();

		Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow();
		
		System.out.println("Digite o novo nome do funcionario: ");
		String nome = scanner.next();
		
		System.out.println("Digite o novo salario do funcionario: ");
		BigDecimal salario = new BigDecimal(scanner.nextDouble());
		
		System.out.println("Digite a nova data de contrataçãoo do funcionario: ");
		LocalDate data = LocalDate.parse(scanner.next(), formatter);
		
		funcionario.setNome(nome);
		funcionario.setSalario(salario);
		funcionario.setCargo(cargo(scanner));
		funcionario.setDataContratacao(data);

		funcionarioRepository.save(funcionario);
		System.out.println("Atualizado");
	}

	private void visualizar(Scanner scanner) {
		System.out.println("Qual página você deseja visualizar?");
		Integer page = scanner.nextInt();
		
		Pageable pageable = PageRequest.of(page, 5, Sort.by(Sort.Direction.ASC, "salario"));
		Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);
		
		System.out.println("Total de páginas: " + funcionarios);
		System.out.println("Página atual: " + funcionarios.getNumber());
		System.out.println("Total de elementos: " + funcionarios.getTotalElements());
		funcionarios.forEach(System.out::println);
	}
}
