package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Curso {

	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}

	@Override
	public String toString() {
		return nome;
	}
}

public class ExemploCurso {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<>(List.of(
				new Curso("Python", 45), 
				new Curso("JavaScript", 150),
				new Curso("Java 8", 113), 
				new Curso("C", 55)));

		cursos.sort(Comparator.comparing(Curso::getAlunos));

		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.mapToInt(Curso::getAlunos)
			.average()
			.ifPresent(System.out::println);
		
//		System.out.println(sum);
		
		cursos.stream()
				.filter(curso -> curso.getAlunos() >= 100)
				.findAny()
				.ifPresent(c -> System.out.println(c.getNome()));

//		cursos = cursos.stream()
//			.filter(curso -> curso.getAlunos() >= 100)
//			.collect(Collectors.toList());
		
		cursos.stream()
				.filter(curso -> curso.getAlunos() >= 100)
				.collect(Collectors.toMap(
						c -> c.getNome(), 
						c -> c.getAlunos()))
				.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
		
	}
}