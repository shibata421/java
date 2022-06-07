package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.BancoDeDados;

public class DeletaEmpresa implements Acao {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("deletando empresa");
		
		BancoDeDados banco = BancoDeDados.getInstancia();
		String id = request.getParameter("id");
		banco.deleta(id);
		
		System.out.println(String.format("empresa de id %s deletada", id));
		
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
