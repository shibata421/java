package br.com.alura;

public class Aluno implements Comparable<Aluno> {

	private String nome;
	private int numeroMatricula;

	public Aluno(String nome, int numeroMatriculo) {
		if(nome == null) {
			throw new NullPointerException("O nome não pode ser nulo");
		}
		this.nome = nome;
		this.numeroMatricula = numeroMatriculo;
	}

	public String getNome() {
		return nome;
	}

	public int getNumeroMatriculo() {
		return numeroMatricula;
	}

	@Override
	public String toString() {
		return "[Aluno: " + nome + ", matricula: " + numeroMatricula + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numeroMatricula;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroMatricula != other.numeroMatricula)
			return false;
		return true;
	}

	@Override
	public int compareTo(Aluno aluno) {
		return this.nome.compareTo(aluno.nome);
	}
	
	
	
//	@Override
//	public boolean equals(Object obj) {
//		Aluno aluno = (Aluno) obj;
//		return this.nome.equals(aluno.nome);
//	}
//	
//	@Override
//	public int hashCode() {
//		return this.nome.hashCode();
//	}
}
