<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List,br.com.alura.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- Para isto funcionar, precisa baixar o JSTL e colocar o jar 
dentro de WEB-INF/lib -->

<c:url value="/entrada?acao=DeletaEmpresa" var="deletaEmpresaLink"/>
<c:url value="/entrada?acao=MostraEmpresa" var="mostraEmpresaLink"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Java Standard Taglib</title>
</head>

<body>
	<c:import url="logout-parcial.jsp"/>
	<p>Usuario Logado: ${ usuarioLogado.login }</p>
	<c:if test="${ not empty empresa }">
		<fmt:parseDate value="${ data }" pattern="yyyy-MM-dd" var="parsedDate"/>
		<fmt:formatDate value="${ parsedDate }" pattern="dd/MM/yyyy" var="newDate"/>
		<p>Empresa ${ empresa } cadastrada com sucesso no dia ${ newDate }!</p> 
	</c:if>
	<p>Lista de empresas:</p>
	<ul>
		<c:forEach items="${ empresas }" var="empresa">
			<fmt:parseDate value="${ empresa.dataAbertura }" type="date" pattern="yyyy-MM-dd" var="parsedDate"/>
			<li>
				${ empresa.nome } - <fmt:formatDate value="${ parsedDate }" pattern="dd/MM/yyyy"/> 
				<a href="${ mostraEmpresaLink }&id=${ empresa.id }">edita</a> 
				<a href="${ deletaEmpresaLink }&id=${ empresa.id }" >remove</a> 
			</li>
		</c:forEach>
	</ul>
</body>
</html>