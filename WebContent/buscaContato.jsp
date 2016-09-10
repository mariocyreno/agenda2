<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="br.com.agenda.beans.Contato"%>
<%@page import="br.com.agenda.web.BuscaContato"%>


<!DOCTYPE html>
<html>
	<head>
		<title>Busca Contatos | Agenda Virtual</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	</head>
	<body>
		Resultado da Busca
		<ul>

				<c:forEach var="contato" items="${contatos}">
				
			<li> ${contato.nome}</li>
			
				</c:forEach>

		</ul>
	</body>
</html>