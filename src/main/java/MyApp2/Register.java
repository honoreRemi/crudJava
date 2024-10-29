package MyApp2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.*;

// @WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // Récupérer les paramètres du formulaire
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String password1 = request.getParameter("password");
        String passwordConfirmation = request.getParameter("password_c");
        Connection con;

        // Vérifier que les mots de passe correspondent
        if (!password1.equals(passwordConfirmation)) {
            // Renvoyer une erreur à la page JSP
            request.setAttribute("error", "Les mots de passe ne correspondent pas.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        try {
            // Connexion à la base de données
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Pilote chargé avec succès");
            
            //String url = "jdbc:mysql://localhost/superMarche?useSSL=false&verifyServerCertificate=false";
            String url = "jdbc:mysql://localhost:3306/supermarche";
            String user = "root";
            String password = "";
            
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion établie à la base de données avec succès");

            // Préparer la requête SQL
            String sql = "INSERT INTO register (nom, prenom, password) VALUES (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, nom);
            statement.setString(2, prenom);
            statement.setString(3, password1);

            // Exécuter la requête
            statement.executeUpdate();

            // Rediriger vers la page de connexion
            response.sendRedirect("login.jsp");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Renvoyer une erreur à la page JSP
            request.setAttribute("error", "Une erreur est survenue lors de l'enregistrement.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
	}

}
