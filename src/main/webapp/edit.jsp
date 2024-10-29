<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier le produit</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css">
</head>
<body>
    <h1  class="text-center text-muted mb-3 mt-5">Modifier le produit</h1>
     <div class="container">
    	<div class="row">
    		<div class="col-md-4 mx-auto">
			    <form action="Edit" method="post">
			        <input type="hidden" name="id" value="<%= request.getParameter("id") %>" class="form-control mb-3" >
			        <input type="text" name="libeler" value="<%= request.getParameter("libeler") %>"  class="form-control mb-3" placeholder="Entrez le libelé du produit" >
			        <input type="text" name="nom_produit" value="<%= request.getParameter("nom_produit") %>"  class="form-control mb-3" placeholder="Entrez le nom du produit" >
			        
			        <input type="text" name="prix" value="<%= request.getParameter("prix") %>"   class="form-control mb-3" placeholder="Entrez le prix du produit" >
			        <div class="d-grid gap-2">
			           <button class="btn btn-primary" type="submit" value="Enregistrer les modifications">Modifier</button>
			        </div>
			    </form>
    		</div>	
    	</div>
    </div>
</body>
</html>