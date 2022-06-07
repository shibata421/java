package br.com.alura.gerenciador.servlets.notused;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.BancoDeDados;

//@WebServlet("/editarEmpresa")
public class EditaEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BancoDeDados banco = BancoDeDados.getInstancia();
		
		String nome = request.getParameter("nome");
		String data = request.getParameter("data");
		String id = request.getParameter("id");
		
		banco.edita(id, nome, data);
		response.sendRedirect("listaEmpresas");
	}
}
