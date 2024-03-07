package controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import vista.UsersPanel;

/**
 * Aqui definimos las funciones necesarias para gestionar
 * la base de datos de la tabla characters
 */

public class UsersControllerDDBB {
	
	private static int currentUserId;
	
	public static void usersLogin(String nombre, String contrasena) {
		Connection conx = ConnectionDDBB.connectBBDD();
		Statement stmt;
		ResultSet result;
		
		String loginQuery = "SELECT user_id, name, passwd FROM users WHERE name='"+nombre+"' AND passwd='"+contrasena+"';";
		
		try {
			stmt = conx.createStatement();
			result = stmt.executeQuery(loginQuery);
			
			// Intentar basico mediante la base de datos
			if(result.next()) {
				new UsersPanel().setVisible(true);
				currentUserId = result.getInt("user_id");
			} else {
				JOptionPane.showMessageDialog(null, result.next());
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	// TODO: Cambiar de "permit" a otra cosa diferente que tenga una mejor nomenglatura
	public static boolean usersRegister(String nombre, String contrasena, boolean permiso) {
		Connection conx = ConnectionDDBB.connectBBDD();
		
		String rolConv = permiso ? "admin" : "normalUser";
		
		String regQuery = "INSERT INTO users (name, passwd, permit) VALUES('"+nombre+"','"+contrasena+"','"+rolConv+"');";
		
		try {
			conx.prepareStatement(regQuery).execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static int getUserId() {
		return currentUserId;
	}
	
}
