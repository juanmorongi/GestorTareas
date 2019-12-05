<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Modelo.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<%@include file = "includes/nav.jsp" %>
<section>
	<%
		Tarea t = new Tarea();
		if(request.getParameter("id")!=null){
			int id = Integer.parseInt(request.getParameter("id"));
			ListaTareas c = new ListaTareas();
			c.obtener();
			t = c.getTareaById(Integer.parseInt(request.getParameter("id")));
		}
	%>
	<form name="altas" action="AltaTarea" method="post" accept-charset="UTF-8">
		<input type="hidden" name="id" value="<%=t.getId()%>">
		<label>Nombre</label>
		<input type="text" name="nombre" value="<%=t.getNombre()%>">
		<p></p>
		<label>Id padre</label>
		<input type="number" name="pid" value="<%=t.getPid()%>">
		<p></p>
		<label>Descripcion</label>
		<textarea name="desc"><%if(t!=null)out.println(t.getDescripcion());%></textarea>
		<p></p>
		<label>Categoria</label>
		<select name="categoria" selected="">
			<option value="0" <%if(t.getCategoria()==0) out.println("selected");%>>Sin categoría</option>
			<option value="1" <%if(t.getCategoria()==1) out.println("selected");%>>Cat 1</option>
			<option value="2" <%if(t.getCategoria()==2) out.println("selected");%>>Cat 2</option>
		</select>
		<p></p>
		<label>Fecha inicio</label>
		<input type="date" name="ini" value="<%=t.getFechaIni()%>"">
		<p></p>
		<label>Fecha fin</label>
		<input type="date" name="fin" value="<%=t.getFechaFin()%>">
		<p></p>
		<label>Prioridad</label>
		<select name="prioridad">
			<option value="1" <%if(t.getImportancia()==1) out.println("selected");%>>Baja</option>
			<option value="2" <%if(t.getImportancia()==2) out.println("selected");%>>Media</option>
			<option value="3" <%if(t.getImportancia()==3) out.println("selected");%>>Alta</option>
		</select>
		<p></p>
		<input type="submit" value="sendnudes" onclick="index.jsp">
	</form>
</section>
</div>
</body>
</html>