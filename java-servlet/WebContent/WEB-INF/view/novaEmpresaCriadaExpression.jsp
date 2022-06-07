<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/>
	<c:if test="${ not empty empresa }">
		<fmt:parseDate value="${ data }" pattern="yyyy-MM-dd" var="parsedDate"/>
		<fmt:formatDate value="${ parsedDate }" pattern="dd/MM/yyyy" var="newDate"/>
		<p>Empresa ${ empresa } cadastrada com sucesso no dia ${ newDate }!</p> 
	</c:if>

	<c:if test="${ empty empresa }">
		<p>Nenhuma empresa cadastrada</p> 
	</c:if>
		
</body>
</html>