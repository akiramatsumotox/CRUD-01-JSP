<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Alunos</title>
</head>
<body>
	<a href="aluControll?action=formAddAluno">New</a>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Idade</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listAlu}" var="aluno">
				<tr>
					<td>${aluno.idAluno}</td>
					<td>${aluno.nome}</td>
					<td>${aluno.idade}</td>
					<td>
						<a href="aluControll?action=formUpdateAluno&idAluno=${aluno.idAluno}">EDIT</a> ||
						<a href="aluControll?action=deleteAluno&idAluno=${aluno.idAluno}">DELETE</a>
					</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>