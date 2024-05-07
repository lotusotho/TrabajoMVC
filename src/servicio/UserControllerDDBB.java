package servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.FunctionsHandler;
import vista.StringHandler;

/**
 * Aqui definimos las funciones necesarias para gestionar la base de datos de la
 * tabla characters
 */

public class UserControllerDDBB {

	private static int currentUserId;

	public void usersLogin(String name, String passwd) {
		try {
			Connection conx = ConnectionDDBB.connectDDBB();

			Encryption encryption = new Encryption();

			String tempHashedPassd = encryption.Encrypt(passwd);

			String loginQuery = "SELECT user_id, name, passwd FROM user WHERE name=? AND passwd=?;";

			PreparedStatement prepStmt = conx.prepareStatement(loginQuery);
			prepStmt.setString(1, name);
			prepStmt.setString(2, tempHashedPassd);

			ResultSet result = prepStmt.executeQuery();

			if (result.next()) {
				setCurrentUserid(result.getInt(1));
				FunctionsHandler functionsHandler = new FunctionsHandler();
				functionsHandler.UsersControlPanel(true);
			} else {
				StringHandler stringHandler = new StringHandler();
				stringHandler.MessageHandler("userLoginKO");
			}

			prepStmt.close();
			conx.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public boolean usersRegister(String name, String passwd, boolean isAdmin) {
		try {
			Connection conx = ConnectionDDBB.connectDDBB();

			String regQuery = "INSERT INTO user (name, passwd, isAdmin) VALUES(?, ?, ?);";

			PreparedStatement preStmt = conx.prepareStatement(regQuery);

			Encryption encryption = new Encryption();

			preStmt.setString(1, name);
			preStmt.setString(2, encryption.Encrypt(passwd));
			preStmt.setBoolean(3, isAdmin);

			preStmt.execute();

			preStmt.close();
			conx.close();

			StringHandler stringHandler = new StringHandler();
			stringHandler.MessageHandler("userRegOK");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();

			StringHandler stringHandler = new StringHandler();
			stringHandler.MessageHandler("userRegKO");
			return false;
		}
	}

	/**
	 * Checkea si el usuario actual es admin o no
	 *
	 * @return
	 */
	public static boolean isCurrentUserAdmin() {
		try {
			Connection conx = ConnectionDDBB.connectDDBB();

			String isAdminQuery = "SELECT isAdmin FROM user WHERE user_id=?;";

			PreparedStatement prepStmt = conx.prepareStatement(isAdminQuery);

			prepStmt.setInt(1, getCurrentUserId());

			ResultSet result = prepStmt.executeQuery();

			boolean finalResult = false;

			if (result.next()) {
				finalResult = result.getBoolean(1);
			}

			prepStmt.close();

			conx.close();

			return finalResult;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void ShowAllRows(JTable jtable) {
		try {
			Connection conx = FunctionsHandler.ConnectDDBB();

			String allQuery = "SELECT * FROM user ORDER BY name ASC;";

			Statement stmt = conx.prepareStatement(allQuery);
			ResultSet result = stmt.executeQuery(allQuery);

			String user_id, name, passwd, admin;

			while (result.next()) {
				user_id = result.getString(1);
				name = result.getString(2);
				passwd = result.getString(3);
				admin = result.getString(4).equals("1") ? "Es Admin" : "No Es Admin";

				String[] rows = { user_id, name, passwd, admin };
				System.out.println(Arrays.toString(rows));
				((DefaultTableModel) jtable.getModel()).addRow(rows);
			}

			stmt.close();
			conx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void DeleteLastUserDB() {

		try {
			Connection conx = FunctionsHandler.ConnectDDBB();
			String selQuery = "SELECT user_id FROM user ORDER BY name DESC LIMIT 1;";

			PreparedStatement stmt = conx.prepareStatement(selQuery);
			ResultSet result = stmt.executeQuery(selQuery);

			while (result.next()) {
				if (result.getInt(1) != getCurrentUserId()) {
					String delQuery = "DELETE FROM user ORDER BY name DESC LIMIT 1;";
					PreparedStatement delStmt = conx.prepareStatement(delQuery);
					delStmt.execute();
					delStmt.close();
				} else {
					StringHandler stringHandler = new StringHandler();
					stringHandler.MessageHandler("NoDeleteCurrentUser");
				}
			}

			stmt.close();
			conx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void RecoverPassUser(String oldPasswd, String newPasswd, String name) {
		try {
			Connection conx = FunctionsHandler.ConnectDDBB();
			String selQuery = "SELECT name, passwd FROM user WHERE name=?;";

			PreparedStatement prepStmt = conx.prepareStatement(selQuery);

			prepStmt.setString(1, name);

			ResultSet result = prepStmt.executeQuery();

			Encryption encryption = new Encryption();
			StringHandler stringHandler = new StringHandler();

			if (result.next() && result.getString(2).equals(encryption.Encrypt(oldPasswd))) {
				String updateQuery = "UPDATE user SET passwd=? WHERE name=?;";

				PreparedStatement prepStmt2 = conx.prepareStatement(updateQuery);
				prepStmt2.setString(1, encryption.Encrypt(newPasswd));
				prepStmt2.setString(2, name);

				prepStmt2.execute();

				prepStmt2.close();
				prepStmt.close();

				stringHandler.MessageHandler("passChangeOK");
				result.close();
			} else {
				stringHandler.MessageHandler("passChangeKO");

				prepStmt.close();
				conx.close();
			}
		} catch (SQLException e) {
			StringHandler stringHandler = new StringHandler();
			stringHandler.MessageHandler("passChangeKO");
			e.printStackTrace();
		}
	}

	public static int getCurrentUserId() {
		return currentUserId;
	}

	public static void setCurrentUserid(int userId) {
		currentUserId = userId;
	}

}
