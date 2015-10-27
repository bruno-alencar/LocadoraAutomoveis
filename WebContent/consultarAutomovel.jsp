<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.usjt.arqdesis.model.Automovel" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Automoveis</title>
<link rel="stylesheet" type="text/css" href="css/style-menu.css">
</head>
<body>
	<header>
		<h1>Cadastrar Automóvel</h1>
	</header>
	<nav>
		<ul class="menu clearfix">
			<li><a href="#">Automóvel</a>

				<ul class="sub-menu clearfix">
					<li><a href="cadastrarAutomovel.html">Cadastrar</a></li>
					<li><a href="automovel.do">Consultar</a></li>
					<li><a href="#">Alterar</a></li>
					<li><a href="#">Deletar</a></li>
				</ul></li>
			<li><a href="">Cliente</a>

				<ul class="sub-menu clearfix">
					<li><a href="#">Cadastrar</a></li>
					<li><a href="#">Consultar</a></li>
					<li><a href="#">Alterar</a></li>
					<li><a href="#">Deletar</a></li>
				</ul></li>
			<li><a href="">Locação</a>

				<ul class="sub-menu clearfix">
					<li><a href="#">Locar</a></li>
					<li><a href="#">Devolver</a></li>
				</ul></li>
		</ul>
	</nav>
	
	<article style="padding-top: 10px;">
	
	<form action="automovel.do" method="POST">
		<table border="2px">
			<th></th>
			<th>Chassi</th>
			<th>Placa</th>
			<th>Cidade</th>
			<th>Km</th>
			<th>Estado</th>
			<th>Modelo</th>
			<th>Fabricante</th>
			<th>Km Livre</th>
			<th>Km Controlado</th>
			<%
				List<Automovel> listaAutomoveis = (List<Automovel>) request.getAttribute("listaAutomoveis");
				for(Automovel automovel: listaAutomoveis){
			%>
				<tr>
					<td><input type="radio" name="automovel" value="${automovel.getCodigo()}"></td>
					<td><%= automovel.getChassi() %></td>
					<td><%= automovel.getPlaca() %></td>
					<td><%= automovel.getCidade() %></td>
					<td><%= automovel.getKm() %></td>
					<td><%= automovel.getEstado() %></td>
					<td><%= automovel.getModelo() %></td>
					<td><%= automovel.getFabricante() %></td>
					<td><%= automovel.getTarifa_km_livre() %></td>
					<td><%= automovel.getTarifa_km_controlado() %></td>
				</tr>
			<%
				}
			%>
			<tr>
				<td><input type="submit"  onclick="option=alterar"></td>
				<td><input type="submit"  onclick="option=excluir"></td>
<!-- 				<button onclick="javascript:location.document='alterarAutomovel.jsp?option=alterar">Alterar</button> -->
			</tr>
		</table>
		</form>
	</article>
		
		
		
		
</body>
</html>