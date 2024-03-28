package servicio;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import controlador.FunctionsHandler;
import controlador.StringHandler;
import vista.UsersPanel;

/**
 * Aqui definimos las funciones necesarias para gestionar la base de datos de la
 * tabla characters
 */

public class UsersControllerDDBB {

	// TODO: No me gusta declarar esto como publico
	public static int currentUserId;
	
	private static Encryption crypt = new Encryption();

	public static void usersLogin(String name, String passwd) {
		Connection conx = ConnectionDDBB.connectBBDD();
		Statement stmt;
		ResultSet result;
		
		String tempHashedPassd = crypt.Encrypt(passwd);

		String loginQuery = "SELECT user_id, name, passwd FROM users WHERE name='" + name + "' AND passwd='"
				+ tempHashedPassd + "';";

		try {
			stmt = conx.createStatement();
			result = stmt.executeQuery(loginQuery);

			if (result.next()) {
				FunctionsHandler.UserManagementPanel(true);
				currentUserId = result.getInt("user_id");
			} else {
				StringHandler.MessageHandler("userLoginKO");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public static boolean usersRegister(String name, String passwd, boolean isAdmin) {
		Connection conx = ConnectionDDBB.connectBBDD();

		String rolConv = isAdmin ? "admin" : "normalUser";

		String regQuery = "INSERT INTO users (name, passwd, isAdmin) VALUES('" + name + "','" + crypt.Encrypt(passwd) + "','"
				+ rolConv + "');";

		try {
			conx.prepareStatement(regQuery).execute();
			StringHandler.MessageHandler("userRegOK");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			StringHandler.MessageHandler("userRegKO");
			return false;
		}
	}

	
	/**
	 * Checkea si el usuario actual es admin o no
	 * @return
	 */
	public static boolean isUserAdmin() {
		Connection conx = ConnectionDDBB.connectBBDD();

		String adminQuery = "SELECT isAdmin from users WHERE user_id="+ currentUserId +";";
		
		try {
			Statement stmt = conx.createStatement();
			ResultSet result = stmt.executeQuery(adminQuery);
			
			while(result.next()) {
				return "admin".equals(result.getString(1));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return false;
	}

}
