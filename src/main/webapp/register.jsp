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
   	<h1 class="text-center text-muted mb-3 mt-5">Formulaire d'authentification</h1>
    <div class="container">
    	<div class="row">
    		<div class="col-md-4 mx-auto">
    			<form action="Register" method="POST">
           		 <div class="login">
                	<input type="text" name="nom" id="nom" class="form-control mb-3" placeholder="Entrez votre nom" required>
                	<input type="text" name="prenom" id="prenom" class="form-control mb-3" placeholder="Entrez votre prenom" required>
                	<input type="password" name="password" id="password" class="form-control mb-3" placeholder="Entrez votre mot de passe" required>
                	<input type="password" name="password_c" id="passwordc" class="form-control mb-3" placeholder="Entrez votre mot de passe de confirmaton" required>
              
                	<div class="d-grid gap-2">
                		<button class="btn btn-primary" type="submit" name="Valider" value="Valider">Register</button>
                		<p class="text-center text-muted mt-5">Avez vous un compte?<a href="login.jsp">Connectez vous ici</a></p>
                	</div>
            	</div>
        	</form>
    		</div>	
    	</div>
    </div>
</body>
</html>