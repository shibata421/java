package br.com.alura.spring.data.orm;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "unidadesTrabalho")
public class UnidadeTrabalho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private String endereco;

	@ManyToMany(mappedBy = "unidade", fetch = FetchType.EAGER)
	private Collection<Funcionario> funcionarios;

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getEndereco() {
		return endereco;
	}

	public Collection<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Collection<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setEndereco(String endereço) {
		this.endereco = endereço;
	}

}
