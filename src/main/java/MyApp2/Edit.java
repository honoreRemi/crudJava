package MyApp2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Edit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String libeler = request.getParameter("libeler");
        String nomProduit = request.getParameter("nom_produit");
        String prix = request.getParameter("prix");
        
        // Connexion à la base de données
        try {
            // Chargement du pilote
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Pilote chargé avec succès");
            
            String url = "jdbc:mysql://localhost:3306/supermarche";
            String user = "root";
            String password = "";
            
            try (Connection con = DriverManager.getConnection(url, user, password)) {
                System.out.println("Connexion établie à la base de données avec succès");
                // Requête de mise à jour
                String query = "UPDATE produit SET libeler=?, nom_produit=?, prix=? WHERE id=?";
                PreparedStatement statement = con.prepareStatement(query);
                statement.setString(1, libeler);
                statement.setString(2, nomProduit);
                statement.setString(3, prix);
                statement.setString(4, id);
                
                // Exécution de la requête de mise à jour
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    // La mise à jour a été effectuée avec succès
                    response.sendRedirect("index.jsp");
                } else {
                    // La mise à jour a échoué
                    response.sendRedirect("edit;jsp");
                }
            }
        } catch (ClassNotFoundException e) {
            // Gestion des erreurs de chargement du pilote
            e.printStackTrace();
            response.sendRedirect("edit.jsp");
        } catch (SQLException e) {
            // Gestion des erreurs de base de données
            e.printStackTrace();
            response.sendRedirect("edit.jsp");
        }
    }
}