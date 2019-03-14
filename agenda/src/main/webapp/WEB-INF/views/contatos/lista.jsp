<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Contatos</title>
</head>
<body>

	<h1>Lista de Contatos</h1>

	<table>
	    <tr>
	        <td>Nome</td>
	        <td>Número</td>
	    </tr>
	
	    <c:forEach items="${contatos}" var="contato">
	        <tr>
	            <td>${contato.nome}</td>
	            <td>${contato.numero}</td>
	            <td>
	            	<a href="<c:url value='/contatos/remover'/>/${contato.id}"> Remover </a>
	            </td>
	        </tr>
	    </c:forEach>
	</table>

</body>
</html>