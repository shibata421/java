<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
<%@ page import="java.util.List,br.com.alura.gerenciador.modelo.Empresa" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Java Standard</title>
</head>

<body>
    <p>Lista de empresas:</p>

    <ul>
		<% 	
			List<Empresa> lista = (List<Empresa>) request.getAttribute("empresas"); 
			for(Empresa empresa : lista) { 
		%>
        	<li><%= empresa.getNome() %></li>
        <%	
        	} 
        %>
    </ul>
    
</body>
</html>