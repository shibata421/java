package br.com.shibata;

import java.util.ArrayList;
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

}

public class ExemploCurso {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<>(List.of(
				new Curso("Python", 45), 
				new Curso("JavaScript", 150),
				new Curso("Java 8", 113), 
				new Curso("C", 55)));
		
		cursos.stream()
			.filter(curso -> curso.getAlunos() > 50)
			.findFirst()
			.ifPresent(curso -> System.out.println(curso.getNome()));
		
		cursos.stream()
			.mapToInt(Curso::getAlunos)
			.average()
			.ifPresent(System.out::println);
		
		 cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .collect(Collectors.toList());

	}
}