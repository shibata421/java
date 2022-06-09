package br.com.alura.spring.data.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;

@Repository
public interface FuncionarioRepository extends 
PagingAndSortingRepository<Funcionario, Long>, JpaSpecificationExecutor<Funcionario> {

	Collection<Funcionario> findByNome(String nome);

	@Query("SELECT f FROM Funcionario f "
			+ "WHERE f.nome = :nome "
			+ "AND f.dataContratacao = :dataContratacao "
			+ "AND f.salario > :salario")
	Collection<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, LocalDate dataContratacao,
			BigDecimal salario);
	
	@Query(value = "SELECT * FROM funcionarios "
			+ "WHERE data_contratacao >= :dataContratacao", 
			nativeQuery = true)
	Collection<Funcionario> findDataContratacaoMaior(LocalDate dataContratacao);
	
	@Query(value = "SELECT id, nome, salario FROM funcionarios", nativeQuery = true)
	Collection<FuncionarioProjecao> findFuncionarioSalario();
}
