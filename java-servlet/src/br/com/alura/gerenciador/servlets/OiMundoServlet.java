package br.com.alura.gerenciador.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
//@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet {
	
	//Tomcat eh um middleware -> ele que gera o método main e cria as instâncias dos servlets
	//Tomcat eh lazy. Ele soh cria o objeto quando é necessario e usa Singleton
	public OiMundoServlet() {
		System.out.println("Criando OiMundoServlet");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("Oi Mundo!");
		out.print("</body>");
		out.print("</html>");

		System.out.println("OiMundoServlet foi chamado");
	}

}
