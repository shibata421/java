package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

public class Curso {

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new ArrayList<>();
	private Set<Aluno> alunos = new TreeSet<>();
	private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();

	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}

	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}

	public String getNome() {
		return nome;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public int getTempoTotal() {
//		return tempoTotal;
		return aulas.stream().mapToInt(Aula::getTempo).sum();
	}

	@Override
	public String toString() {
		return "[Curso: " + nome + ", tempo total: " + this.getTempoTotal() + ", aulas: " + this.aulas + "]";
	}

	public void matricular(Aluno aluno) {
		alunos.add(aluno);
		this.matriculaParaAluno.put(aluno.getNumeroMatriculo(), aluno);
	}

	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}

	public boolean estaMatriculado(Aluno a1) {
		return alunos.contains(a1);
	}

	public Aluno buscaMatriculado(int numero) {
		if(!matriculaParaAluno.containsKey(numero)) {
			throw new NoSuchElementException();
		}
		return this.matriculaParaAluno.get(numero);
	}
}
