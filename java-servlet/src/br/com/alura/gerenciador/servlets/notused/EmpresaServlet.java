package br.com.alura.gerenciador.servlets.notused;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.BancoDeDados;

//@WebServlet("/empresa")
public class EmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BancoDeDados banco = BancoDeDados.getInstancia();
		
		String param = request.getParameter("id");
		
		System.out.println(banco.getEmpresas().get(Integer.valueOf(param)).getNome());
	}
}
