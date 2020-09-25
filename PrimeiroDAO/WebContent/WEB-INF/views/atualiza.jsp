<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar</title>
</head>
<body>

<form action='Atualiza' method='post'>
Tarefa: <input type='text' name='tarefa'value='${param.tarefa }'>
<input type='hidden' name='id' value='${param.id}'>
<input type='submit' value='Urgente' name='urgente'>
<input type='submit' value='Não Urgente' name='nao'>
</form>

</body>
</html>