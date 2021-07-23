<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Aluno</title>
</head>
<body>

	<form action="aluControll" method="post">
		<input type="text" name="idAluno" value="0" readonly="readonly"/>
		<input type="text" name="nome" autofocus="autofocus" placeholder="Nome..."/>
		<input type="text" name="idade" placeholder="Idade..."/>
		<input type="submit" name="save" value="Save"/>
	</form>

</body>
</html>