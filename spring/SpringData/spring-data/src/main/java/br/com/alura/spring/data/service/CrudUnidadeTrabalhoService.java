package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;

@Service
public class CrudUnidadeTrabalhoService {

	private final UnidadeTrabalhoRepository repository;
	private boolean system = true;
	
	public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository repository) {
		this.repository = repository;
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
				visualizar();
				break;
			case 4:
				deletar(scanner);
				break;
			}
		}

	}

	private void deletar(Scanner scanner) {
		System.out.println("Digite o id da unidade a ser deletada: ");
		Long id = scanner.nextLong();
		repository.deleteById(id);
		System.out.println("Deletada");
	}

	private void salvar(Scanner scanner) {
		System.out.println("Nome da unidade de trabalho: ");
		String descricao = scanner.next();

		System.out.println("Endereço da unidade de trabalho: ");
		String endereco = scanner.next();
		
		UnidadeTrabalho unidade = new UnidadeTrabalho();
		unidade.setDescricao(descricao);
		unidade.setDescricao(endereco);

		repository.save(unidade);
		System.out.println("Salvo");
	}

	private void atualizar(Scanner scanner) {
		System.out.println("Digite o id da unidade a ser atualizada: ");
		Long id = scanner.nextLong();
		
		System.out.println("Digite o novo nome da unidade de trabalho: ");
		String descricao = scanner.next();
		
		System.out.println("Digite o novo endereço da unidade de trabalho: ");
		String endereco = scanner.next();

		UnidadeTrabalho unidade = new UnidadeTrabalho();
		unidade.setId(id);
		unidade.setDescricao(descricao);
		unidade.setEndereco(endereco);

		repository.save(unidade);
		System.out.println("Atualizado");
	}
	
	private void visualizar() {
		Iterable<UnidadeTrabalho> unidades = repository.findAll();
		unidades.forEach(System.out::println);
	}
}
