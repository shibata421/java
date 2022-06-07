package br.com.alura.gerenciador.servlets.notused;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.BancoDeDados;
import br.com.alura.gerenciador.modelo.Empresa;

//@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		BancoDeDados banco = BancoDeDados.getInstancia();
		List<Empresa> lista = banco.getEmpresas();
		request.setAttribute("empresas", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("listaEmpresasExpression.jsp");
		rd.forward(request, response);
	}
	
	
}
