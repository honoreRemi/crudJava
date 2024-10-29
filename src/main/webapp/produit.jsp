<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css">
</head>
<body>
   	<h1 class="text-center text-muted mb-3 mt-5">Ajouter un produit</h1>
    <div class="container">
    	<div class="row">
    		<div class="col-md-4 mx-auto">
    			<form action="Ajouter" method="POST">
           		 <div class="login">
                	<input type="text" name="libeler" id="libeler" class="form-control mb-3" placeholder="Entrez le libeler du produit" required>
                	<input type="text" name="nom_produit" id="nom_produit" class="form-control mb-3" placeholder="Entrez le nom du produit" required>
                	<input type="text" name="prix" id="prix" class="form-control mb-3" placeholder="Entrez le prix du produit" required>
              
                	<div class="d-grid gap-2">
                		<button class="btn btn-primary" type="submit" name="Valider" value="Valider">Ajouter</button>
                	</div>
            	</div>
        	</form>
    		</div>	
    	</div>
    </div>
</body>
</html>