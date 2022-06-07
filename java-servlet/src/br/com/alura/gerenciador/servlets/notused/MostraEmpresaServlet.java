package br.com.alura.gerenciador.servlets.notused;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.BancoDeDados;
import br.com.alura.gerenciador.modelo.Empresa;

//@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BancoDeDados banco = BancoDeDados.getInstancia();
		String id = request.getParameter("id");
		
		Empresa empresa = banco.pega(id);
		request.setAttribute("empresa", empresa.getNome());
		request.setAttribute("data", empresa.getDataAbertura().toString());
		request.setAttribute("id", empresa.getId());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mostraEmpresa.jsp");
		dispatcher.forward(request, response);
	}

}
