<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrada?acao=AlteraEmpresa" var="linkServletAlteraEmpresa"/>
<fmt:parseDate value="${ data }" pattern="yyyy-MM-dd" var="parsedDate"/>
<fmt:formatDate value="${ parsedDate }" pattern="dd/MM/yyyy" var="newDate"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edita empresa</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/>
	<form action="${ linkServletAlteraEmpresa }" method="post">
		<label for="nome">Nome: </label>
		<input type="text" name="nome" value="${ empresa }">
		<label for="nome">Data: </label>
		<input type="text" name="data" value="${ newDate }">
		<input type="hidden" name="id" value="${ id }">
		<input type="hidden" name="acao" value="AlteraEmpresa">
		<button>Enviar</button>
	</form>

</body>
</html>