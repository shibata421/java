<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServlet"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastrar nova empresa</title>
</head>
<body>

	<form action="${ linkServlet }" method="post">
		<label for="login">Login: </label>
		<input type="text" name="login">
		
		<label for="senha">Senha: </label>
		<input type="password" name="senha">
		
		<input type="hidden" name="acao" value="Login">
		<button>Enviar</button>
	</form>

</body>
</html>