package br.com.alura.spring.data.orm;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private BigDecimal salario;
	private LocalDate dataContratacao;

	@ManyToOne
	private Cargo cargo;

	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<UnidadeTrabalho> unidade;

	public Funcionario() {
	}

	public Collection<UnidadeTrabalho> getUnidade() {
		return unidade;
	}

	public void setUnidade(Collection<UnidadeTrabalho> unidade) {
		this.unidade = unidade;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", salario=" + salario
				+ ", dataContratacao=" + dataContratacao + ", cargo=" + cargo + ", unidade=" + unidade + "]";
	}
}
