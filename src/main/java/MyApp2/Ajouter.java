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

// @WebServlet("/Ajouter")
public class Ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // Récupérer les paramètres du formulaire
        String libeler = request.getParameter("libeler");
        String nom_produit = request.getParameter("nom_produit");    
        String prixStr = request.getParameter("prix");
        double prix;

        try {
            // Vérifier que le champ "prix" est un nombre valide
            prix = Double.parseDouble(prixStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            // Renvoyer une erreur à la page JSP
            request.setAttribute("error", "Le champ 'prix' doit être un nombre valide.");
            request.getRequestDispatcher("produit.jsp").forward(request, response);
            return;
        }

        
        Connection con;
        
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
            String sql = "INSERT INTO produit (libeler, nom_produit, prix) VALUES (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, libeler);
            statement.setString(2, nom_produit);
            statement.setDouble(3, prix);

            // Exécuter la requête
            statement.executeUpdate();

            // Rediriger vers la page de connexion
            response.sendRedirect("index.jsp");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Renvoyer une erreur à la page JSP
            request.setAttribute("error", "Une erreur est survenue lors de l'enregistrement.");
            request.getRequestDispatcher("produit.jsp").forward(request, response);
        }
	}

}
