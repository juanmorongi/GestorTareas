<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Modelo.*" %> 
<%@ page import="java.util.ArrayList" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<%@include file = "includes/nav.jsp" %>
<section>
	<h1 class="h1">Lista Tareas</h1>
	<% 
	ListaTareas lista = new ListaTareas();
	lista.obtener();
	String txt = lista.imprimirLista();
	%>
	<p><%=txt%></p>
	
</section>
</div>

	
</body>
</html>