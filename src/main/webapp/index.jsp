<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>

<%
    // Connexion à la base de données
    String url = "jdbc:mysql://localhost:3306/supermarche";
    String username = "root";
    String password = "";
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
        // Chargement du pilote
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Pilote chargé avec succès");

        // Connexion à la base de données
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connexion établie à la base de données avec succès");

        // Exécution de la requête SQL pour récupérer les utilisateurs
        String query = "SELECT * FROM produit";
        statement = connection.prepareStatement(query);
        resultSet = statement.executeQuery();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>

<%
    if (session.getAttribute("login") == null) {
        // L'utilisateur n'est pas connecté, rediriger vers la page de login
        response.sendRedirect("login.jsp");
    }
    String login = (String) session.getAttribute("login");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des produits</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css">
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        table th, table td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        table th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="text-center text-muted mb-3 mt-5">Bienvenue <%= login %> sur notre site !</h1>
    <form action="Logout" method="post" class="d-flex justify-content-end">
        <input type="submit" class="btn btn-primary" value="Logout" name="Logout">
    </form>
</div>
<div class="container mt-5">
    <h1 class="text-center text-muted mb-3">Liste des produits</h1>
    <div class="text-right mb-3">
        <a href="produit.jsp" class="btn btn-primary">Ajouter un produit</a>
    </div>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>LIBELER</th>
                <th>NOM_PRODUIT</th>
                <th>PRIX</th>
                <th>ACTIONS</th>
            </tr>
        </thead>
        <tbody>
           <% while (resultSet.next()) { %>
                <tr>
                    <td><%= resultSet.getInt("id") %></td>
                    <td><%= resultSet.getString("libeler") %></td>
                    <td><%= resultSet.getString("nom_produit") %></td>
                    <td><%= resultSet.getString("prix") %></td>
                    <td>
                        <a href="delete.jsp?id=<%= resultSet.getInt("id") %>" class="btn btn-danger">SUPPRIMER</a>
                        <a href="edit.jsp?id=<%= resultSet.getInt("id") %>" class="btn btn-primary">MODIFIER</a>
                    </td>
                </tr>
            <% } %> 
        </tbody>
    </table>
</div>

<%
    // Fermeture des ressources et de la connexion à la base de données
    if (resultSet != null) {
        resultSet.close();
    }
    if (statement != null) {
        statement.close();
    }
    if (connection != null) {
        connection.close();
    }
%>

</body>
</html>