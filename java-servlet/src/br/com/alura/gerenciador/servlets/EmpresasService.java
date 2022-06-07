package br.com.alura.gerenciador.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.BancoDeDados;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		List<Empresa> empresas = BancoDeDados.getInstancia().getEmpresas();

		String valor = request.getHeader("Accept");
		
		System.out.println(valor);
		
		response.setContentType("application/json");
		String resposta = "{\"message\":\"no content\"}";
		if(valor.contains("xml")) {
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			resposta = xstream.toXML(empresas);
			
			response.setContentType("application/xml");			
		} else if (valor.contains("json")){
			Gson gson = new Gson();
			resposta = gson.toJson(empresas);
		}
		
		response.getWriter().print(resposta);			
 	}

}
