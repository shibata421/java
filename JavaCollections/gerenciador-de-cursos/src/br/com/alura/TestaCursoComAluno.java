package br.com.alura;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestaCursoComAluno {

	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 24));

		Aluno a1 = new Aluno("Rodrigo Turini", 34672);
		Aluno a2 = new Aluno("Guilherme Silveira", 5617);
		Aluno a3 = new Aluno("Mauricio Aniche", 17645);
		
		javaColecoes.matricular(a1);
		javaColecoes.matricular(a2);
		javaColecoes.matricular(a3);
		
		System.out.println("Todos os alunos matriculados: ");
		javaColecoes.getAlunos().forEach(System.out::println);
		
		System.out.println(javaColecoes.estaMatriculado(a1));
		
		Aluno turini = new Aluno("Rodrigo Turini", 34672);
		System.out.println(javaColecoes.estaMatriculado(turini));
		System.out.println(a1.equals(turini));
		
		List<String> letras = new LinkedList<>();
		letras.add("A");
		letras.add("B");
		letras.add("C");

		Iterator<String> iterator = letras.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
