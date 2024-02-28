package controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class UsersControllerDDBB {
	
	public static void usersLogin(String nombre, String contrasena) {
		Connection conx = ConexionDDBB.connectBBDD();
		Statement stmt;
		ResultSet result;
		
		String loginQuery = "SELECT nombre, contrasena FROM users WHERE nombre='"+nombre+"' AND contrasena='"+contrasena+"';";
		
		try {
			stmt = conx.createStatement();
			result = stmt.executeQuery(loginQuery);
			JOptionPane.showMessageDialog(null, result.next());
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public static boolean usersRegister(String nombre, String contrasena, boolean permiso) {
		Connection conx = ConexionDDBB.connectBBDD();
		
		String rolConv = permiso ? "admin" : "normalUser";
		
		String regQuery = "INSERT INTO users (nombre, contrasena, permiso) VALUES('"+nombre+"','"+contrasena+"','"+rolConv+"');";
		
		try {
			conx.prepareStatement(regQuery).execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
