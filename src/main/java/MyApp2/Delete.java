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
import java.sql.*;

public class Delete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        
        
        try  {
            // Chargement du pilote
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Pilote chargé avec succès");
            
            String url = "jdbc:mysql://localhost:3306/supermarche";
            String user = "root";
            String password = "";
            
         // Connexion à la base de données
            try (Connection con = DriverManager.getConnection(url, user, password)) {
                System.out.println("Connexion établie à la base de données avec succès");
                // Requête de suppression
                String query = "DELETE FROM produit WHERE id=?";
                PreparedStatement statement = con.prepareStatement(query);
                statement.setString(1, id);
                
                // Exécution de la requête de suppression
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    // La suppression a été effectuée avec succès
                    response.sendRedirect("index.jsp");
                } else {
                    // La suppression a échoué
                    response.sendRedirect("delete.jsp");
                }
            }
        } catch (ClassNotFoundException e) {
            // Gestion des erreurs de chargement du pilote
            e.printStackTrace();
            response.sendRedirect("delete.jsp");
        } catch (SQLException e) {
            // Gestion des erreurs de base de données
            e.printStackTrace();
            response.sendRedirect("delete.jsp");
        }
    }
}