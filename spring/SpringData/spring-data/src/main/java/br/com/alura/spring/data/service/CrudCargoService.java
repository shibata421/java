package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {

	private final CargoRepository repository;
	private boolean system = true;

	public CrudCargoService(CargoRepository repository) {
		this.repository = repository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual ação de cargo você quer executar?");
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
		System.out.println("Digite o id do cargo a ser deletado: ");
		Long id = scanner.nextLong();
		repository.deleteById(id);
		System.out.println("Deletado");
	}

	private void salvar(Scanner scanner) {
		System.out.println("Descrição do cargo: ");
		String descricao = scanner.next();

		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);

		repository.save(cargo);
		System.out.println("Salvo");
	}

	private void atualizar(Scanner scanner) {
		System.out.println("Digite o id do cargo a ser atualizado: ");
		Long id = scanner.nextLong();
		System.out.println("Digite a nova descrição do cargo: ");
		String descricao = scanner.next();

		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);

		repository.save(cargo);
		System.out.println("Atualizado");
	}
	
	private void visualizar() {
		Iterable<Cargo> cargos = repository.findAll();
		cargos.forEach(System.out::println);
	}
}
