<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastrar nova empresa</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/>
	<form action="${ linkServletNovaEmpresa }" method="post">
		<label for="nome">Nome: </label>
		<input type="text" name="nome">
		<label for="nome">Data: </label>
		<input type="text" name="data">
		<input type="hidden" name="acao" value="NovaEmpresa">
		<button>Enviar</button>
	</form>

</body>
</html>