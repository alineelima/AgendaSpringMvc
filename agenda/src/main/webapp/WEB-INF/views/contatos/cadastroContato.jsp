<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salvar Contato</title>
</head>
<body>

	<form action="${s:mvcUrl('CC#salvar').build() }" method="post">
		<div>
			<label>Nome</label>
			<input type="text" name="nome">
		</div>
		
		<div>
			<label>Número</label>
			<input type="text" name="numero">
		</div>
		<button type="submit">Salvar</button>
	</form>

</body>
</html>