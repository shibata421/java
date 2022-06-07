package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BancoDeDados {

	private static List<Empresa> empresas = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	private static final BancoDeDados intancia = new BancoDeDados();
	
	static {
		empresas.add(new Empresa(chaveSequencial++, "Alura"));
		empresas.add(new Empresa(chaveSequencial++, "Caelum"));
		
		usuarios.add(new Usuario("nico", "12345"));
		usuarios.add(new Usuario("ana", "12345"));
	}
	
	private BancoDeDados() {}

	public static BancoDeDados getInstancia() {
		return intancia;
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Collections.unmodifiableList(empresas);
	}

	public void deleta(String id) {
		int empresaId = Integer.valueOf(id);
		
//		Iterator<Empresa> it = lista.iterator();
//		while (it.hasNext()) {
//			Empresa emp = it.next();
//			if(emp.getId() == empresaId) {
//				it.remove();
//			}
//		}
		
		empresas = empresas.stream()
				.filter(empresa -> empresa.getId() != empresaId)
				.collect(Collectors.toList());
		
	}

	public Empresa pega(String id) {
		return empresas.stream()
				.filter(empresa -> empresa.getId() == Integer.valueOf(id))
				.findFirst()
				.orElseThrow();
	}

	public void edita(String id, String nome, String data) {
		Empresa empresa = pega(id);
		empresa.setNome(nome);
		empresa.setData(data);
	}

	public Usuario existeUsuario(String login, String senha) {
		return usuarios.stream()
			.filter(usuario -> usuario.ehIgual(login, senha))
			.findFirst()
			.orElse(null);
	}

}
