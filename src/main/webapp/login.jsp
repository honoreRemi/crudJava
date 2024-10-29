<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<style>
    body {
        background-color: #f8f9fa;
    }
    
    .container {
        max-width: 400px;
        margin: 0 auto;
        padding-top: 100px;
    }
    
    .login-header {
        text-align: center;
        margin-bottom: 30px;
    }
    
    .login-form {
        background-color: #ffffff;
        padding: 30px;
        border-radius: 5px;
        box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
    }
    
    .login-form .form-control {
        width: 100%;
        margin-bottom: 20px;
    }
    
    .login-form .btn-primary {
        width: 100%;
    }
    
    .login-form .text-center {
        margin-top: 20px;
    }
</style>
</head>
<body>
    <div class="container">
        <div class="login-header">
            <h1 class="h3 mb-3 font-weight-normal">Formulaire d'authentification</h1>
        </div>
        <div class="login-form">
            <form action="Login" method="POST">
                <div class="form-group">
                    <input type="text" name="login" id="login" class="form-control" placeholder="Entrez votre nom" required>
                </div>
                <div class="form-group">
                    <input type="password" name="password" id="password" class="form-control" placeholder="Entrez votre mot de passe" minlength="6" required>
                </div>
                <button class="btn btn-primary btn-block" type="submit" name="Valider" value="Valider">Login</button>
            </form>
            <p class="text-center mt-3">Vous n'avez pas de compte? <a href="register.jsp">Créer un compte</a></p>
        </div>
    </div>
</body>
</html>