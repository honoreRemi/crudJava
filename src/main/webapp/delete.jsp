<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%
    if (session.getAttribute("login") == null) {
        // L'utilisateur n'est pas connecté, rediriger vers la page de login
        response.sendRedirect("login.jsp");
    }
    String login = (String) session.getAttribute("login");
    //String email = (String) session.getAttribute("email");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Supprimer le produit</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css">
</head>
<body>
    <h1 class="text-center text-muted mb-3 mt-5">Supprimer le produit</h1>
      <div class="container">
    	<div class="row">
    		<div class="col-md-4 mx-auto">
		    <form action="Delete" method="post">
		        <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
		        <p class="text-center text-muted mb-3 mt-5"> <%= login %> Voulez-vous vraiment supprimer le produit ?</p>
		         <div class="d-grid gap-2">
                 <button class="btn btn-primary" type="submit" value="Supprimer">Supprimer</button>
                </div>
		    </form>
    		</div>	
    	</div>
    </div>
</body>
</html>