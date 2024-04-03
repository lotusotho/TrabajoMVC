package servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

	public static void usersLogin(String name, String passwd) {
		try {
			Connection conx = ConnectionDDBB.connectBBDD();

			String tempHashedPassd = Encryption.Encrypt(passwd);

			String loginQuery = "SELECT user_id, name, passwd FROM users WHERE name=? AND passwd=?;";

			PreparedStatement prepStmt = conx.prepareStatement(loginQuery);
			prepStmt.setString(1, name);
			prepStmt.setString(2, tempHashedPassd);

			ResultSet result = prepStmt.executeQuery();

			if (result.next()) {
				currentUserId = result.getInt("user_id");
				FunctionsHandler.UsersControlPanel(true);
			} else {
				StringHandler.MessageHandler("userLoginKO");
			}
			
			prepStmt.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public static boolean usersRegister(String name, String passwd, boolean isAdmin) {
		try {
			Connection conx = ConnectionDDBB.connectBBDD();

			String rolConv = isAdmin ? "admin" : "normalUser";

			String regQuery = "INSERT INTO users (name, passwd, isAdmin) VALUES(?, ?, ?);";

			PreparedStatement preStmt = conx.prepareStatement(regQuery);

			preStmt.setString(1, name);
			preStmt.setString(2, Encryption.Encrypt(passwd));
			preStmt.setString(3, rolConv);

			preStmt.execute();
			preStmt.close();

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
	 * 
	 * @return
	 */
	public static boolean isCurrentUserAdmin() {
		Connection conx = ConnectionDDBB.connectBBDD();

		String adminQuery = "SELECT isAdmin from users WHERE user_id=?;";

		try {
			PreparedStatement prepStmt = conx.prepareStatement(adminQuery);
			prepStmt.setInt(1, currentUserId);
			
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				return "admin".equals(result.getString(1));
			}
			
			prepStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return false;
	}

	// UsersView
	public static void ShowAllRows(JTable jtable) {
		try {
			Connection conx = FunctionsHandler.ConnectDDBB();

			String allQuery = "SELECT * FROM users ORDER BY name ASC;";

			Statement stmt = conx.prepareStatement(allQuery);
			ResultSet result = stmt.executeQuery(allQuery);

			String user_id, name, passwd, admin;

			while (result.next()) {
				user_id = result.getString(1);
				name = result.getString(2);
				passwd = result.getString(3);
				admin = result.getString(4);

				String[] rows = { user_id, name, passwd, admin };
				System.out.println(Arrays.toString(rows));
				((DefaultTableModel) jtable.getModel()).addRow(rows);
			}

			conx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void DeleteLastUserDB() {

		try {
			Connection conx = FunctionsHandler.ConnectDDBB();
			String selQuery = "SELECT user_id FROM users ORDER BY name DESC LIMIT 1;";

			Statement stmt = conx.prepareStatement(selQuery);
			ResultSet result = stmt.executeQuery(selQuery);

			while (result.next()) {
				if (result.getInt(1) != currentUserId) {
					String delQuery = "DELETE FROM users ORDER BY name DESC LIMIT 1;";
					Statement delStmt = conx.prepareStatement(delQuery);
					delStmt.executeQuery(delQuery);
					delStmt.close();
				} else {
					StringHandler.MessageHandler("NoDeleteCurrentUser");
				}
			}

			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void RecoverPassUser(String oldPasswd, String newPasswd, String name) {
		try {
			Connection conx = FunctionsHandler.ConnectDDBB();
			String selQuery = "SELECT name, passwd FROM users WHERE name=?;";

			PreparedStatement prepStmt = conx.prepareStatement(selQuery);
			
			prepStmt.setString(1, name);

			ResultSet result = prepStmt.executeQuery();

			if (result.next() && result.getString(2).equals(Encryption.Encrypt(oldPasswd))) {
				String updateQuery = "UPDATE users SET passwd=? WHERE name=?;";

				PreparedStatement prepStmt2 = conx.prepareStatement(updateQuery);
				prepStmt2.setString(1, Encryption.Encrypt(newPasswd));
				prepStmt2.setString(2, name);

				prepStmt2.execute();
				
				prepStmt2.close();
				prepStmt.close();

				StringHandler.MessageHandler("passChangeOK");
				result.close();
			} else {
				StringHandler.MessageHandler("passChangeKO");
			}
		} catch (SQLException e) {
			StringHandler.MessageHandler("passChangeKO");
			e.printStackTrace();
		}
	}

}
