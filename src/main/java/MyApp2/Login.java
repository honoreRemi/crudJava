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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String login = request.getParameter("login");
		String password1 = request.getParameter("password");
		
    Connection con;
        
        try {
            // chargement du pilote
            Class.forName("com.mysql.jdbc.Driver");
             System.out.println("Pilote chargé avec succès");
            
            //String url = "jdbc:mysql://localhost/superMarche?useSSL=false&verifyServerCertificate=false";
            String url = "jdbc:mysql://localhost:3306/supermarche";
            String user = "root";
            String password = "";
            
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion établie à la base de données avec succès");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM user WHERE login = ? AND password = ?");
            pst.setString(1, login);
            pst.setString(2, password1);
            ResultSet res = pst.executeQuery();
            
            if(res.next() == true) {
	            session.setAttribute("login", login);
	            System.out.println();
	            response.sendRedirect("index.jsp");
            }else {
            	response.sendRedirect("login.jsp");
            }
            
           con.close();
            
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur : Pilote introuvable");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erreur : Échec de la connexion à la base de données");
            e.printStackTrace();
        }
	}

}
