<%@page import="br.com.fabricadeprogramador.persistencia.entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuários</title>

<script type="text/javascript">
	function confirmaExclusao(id){
		if (window.confirm("Tem certeza que deseja excluir?")){
			location.href="usucontroller.do?acao=exc&id="+id;
		}
	}
</script>

</head>
<body>
<%
	List<Usuario> lista = (List<Usuario>)request.getAttribute("lista");
%>
	<table>
		<tr><th>ID</th><th>Nome</th><th>Ação</th></tr>
	<% for (Usuario u:lista){ %>
		<tr>
			<td><%= u.getId() %></td>
			<td><%= u.getNome() %></td>
			<td><a href="javascript:confirmaExclusao(<%= u.getId() %>)">Excluir</a> | <a href="usucontroller.do?acao=alt&id=<%= u.getId() %>">Alterar</a></td>
		</tr>
	<%}%>
	
	</table>
</body>
</html>