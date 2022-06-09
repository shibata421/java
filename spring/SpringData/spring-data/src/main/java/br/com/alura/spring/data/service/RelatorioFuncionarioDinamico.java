package br.com.alura.spring.data.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.specification.SpecificationFuncionario;

@Service
public class RelatorioFuncionarioDinamico {

	private final FuncionarioRepository repository;
	
	public RelatorioFuncionarioDinamico(FuncionarioRepository repository) {
		this.repository = repository;
	}
	
	public void inicial(Scanner scanner) {
		System.out.println("Digite um nome: ");
		String nome = scanner.next();
		
		if(nome.equalsIgnoreCase("null")) {
			nome = null;
		}
		
		System.out.println("Digite um cpf: ");
		String cpf = scanner.next();
		
		if(cpf.equalsIgnoreCase("null")) {
			cpf = null;
		}
		
		System.out.println("Digite um salario: ");
		BigDecimal salario = new BigDecimal(scanner.nextDouble());
		
		if(salario.equals(BigDecimal.ZERO)) {
			salario = null;
		}
		
		System.out.println("Digite uma data de contratacao: ");
		String data = scanner.next();
		LocalDate dataContratacao = null;
		if(!data.equalsIgnoreCase("Null")) {
			dataContratacao = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		}
		
		List<Funcionario> funcionarios = repository
				.findAll(Specification.where(
						SpecificationFuncionario.nome(nome))
						.or(SpecificationFuncionario.cpf(cpf))
						.or(SpecificationFuncionario.salario(salario))
						.or(SpecificationFuncionario.dataContratacao(dataContratacao))
						);
		
		funcionarios.forEach(System.out::println);
	}
}
