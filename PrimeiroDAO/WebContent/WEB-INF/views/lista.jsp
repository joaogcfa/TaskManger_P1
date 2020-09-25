<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import='java.util.*,br.edu.insper.controller.*' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<meta charset='UTF-8'>
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class="br.edu.insper.mvc.model.DAO"> </jsp:useBean>

<form action='Cria' method='post'>
Adicione uma tarefa: <input type='text' name='tarefa'>
Quem está encarregado? <input type='text' name='pessoa'>
<label for="birthday">Data(dd-mm-yyyy): </label>
<input type="date" id="birthday" name="data"><br>
<input type='submit' value='Urgente' name='urgente'>
<input type='submit' value='Não Urgente' name='nao'>
</form>

<table border='1'>
<c:forEach var="tarefa" items="${dao.lista}" varStatus="id">
	
<tr>
<td style='${tarefa.urgente == "nao" ?  "background-color:#3399ff ":"background-color:#ff3300"}'>${tarefa.tarefa}</td>
<td><fmt:formatDate
value="${tarefa.data.time}"
pattern="dd/MM/yyyy"/></td>
<td>${tarefa.pessoa}</td>
<td>

<form action='remove' method='post'>
<input type='hidden' name='id' value='${tarefa.id}' >
<input type='submit' value='Remover'>
</form>

</td>

<td>

<form action='Atualiza' method='get'>
<input type='hidden' name='id' value='${tarefa.id}'>
<input type='hidden' name='tarefa' value='${tarefa.tarefa}'>
<input type='submit' value='Atualiza'>
</form>

</td>
</tr>

</c:forEach>
</table>



</body>
</html>