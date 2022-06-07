<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<%
		String nomeEmpresa = (String) request.getAttribute("empresa");
		System.out.println(nomeEmpresa);
	%>
		
	<p>Empresa <% out.println(nomeEmpresa); %> cadastrada com sucesso!</p> 
	<p>Empresa <%= nomeEmpresa %> cadastrada com sucesso!</p> 
		
</body>
</html>