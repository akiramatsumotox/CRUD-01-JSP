<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Aluno</title>
</head>
<body>

	<form action="aluControll" method="post">
		<input type="text"   name="idAluno" value="${findByIdAluno.idAluno}" readonly="readonly"/>
		<input type="text"   name="nome"    value="${findByIdAluno.nome}" autofocus="autofocus"/>
		<input type="text"   name="idade"   value="${findByIdAluno.idade}"/>
		<input type="submit" name="save"    value="Save"/>
	</form>

</body>
</html>