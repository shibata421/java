package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.BancoDeDados;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("mostrando empresa");
		
		BancoDeDados banco = BancoDeDados.getInstancia();
		String id = request.getParameter("id");
		
		Empresa empresa = banco.pega(id);
		request.setAttribute("empresa", empresa.getNome());
		request.setAttribute("data", empresa.getDataAbertura().toString());
		request.setAttribute("id", empresa.getId());
		
		return "forward:mostraEmpresa.jsp";
	}
}
