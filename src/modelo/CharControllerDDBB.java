package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.FunctionsHandler;
import controlador.StringHandler;

/**
 * Aqui definimos las funciones necesarias para gestionar la base de datos de la
 * tabla users
 */

public class CharControllerDDBB {
	private static List<String> getRecordFromLine(String line) {
	    List<String> values = new ArrayList<>();

	    try (Scanner rowScanner = new Scanner(line)) {
	        rowScanner.useDelimiter(";");
	        while (rowScanner.hasNext()) {
	            values.add(rowScanner.next());
	        }
	    }
	    return values;
	}

	public static void InsertCharacter(Hero heroObj) {
		try {
			Connection conx = ConnectionDDBB.connectBBDD();
			
			String insertQuery = "INSERT INTO characters (user_id, name, race, faction, title, life, runicpower, strength, stamina) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement preStmt = conx.prepareStatement(insertQuery);

			preStmt.setInt(1, UsersControllerDDBB.getCurrentUserId());
			preStmt.setString(2, heroObj.getName());
			preStmt.setString(3, heroObj.getRace());
			preStmt.setString(4, heroObj.getFaction());
			preStmt.setString(5, heroObj.getTitle());
			preStmt.setBigDecimal(6, heroObj.getLife());
			preStmt.setInt(7, heroObj.getRunicPower());
			preStmt.setBigDecimal(8, heroObj.getStrength());
			preStmt.setBigDecimal(9, heroObj.getStamina());

			preStmt.execute();

			preStmt.close();
			conx.close();

		} catch (SQLException e) {
			StringHandler.ErrorHandler(e.toString());
			e.printStackTrace();
		}
	}

	public static void ShowAllRows(JTable jtable) {
		try {
			Connection conx = FunctionsHandler.ConnectDDBB();

			boolean isAdmin = UsersControllerDDBB.isCurrentUserAdmin();

			String allQueryUser = "SELECT * FROM characters WHERE user_id=" + UsersControllerDDBB.getCurrentUserId()
					+ " ORDER BY name ASC;";

			String allQuery = "SELECT * FROM characters ORDER BY name ASC;";

			Statement stmt = conx.prepareStatement(isAdmin ? allQuery : allQueryUser);
			ResultSet result = stmt.executeQuery(isAdmin ? allQuery : allQueryUser);

			String char_id, user_id, name, race, faction, title, life, rpower, strength, stamina;

			while (result.next()) {
				char_id = result.getString(1);
				user_id = result.getString(2);
				name = result.getString(3);
				race = result.getString(4);
				faction = result.getString(5);
				title = result.getString(6);
				life = result.getString(7);
				rpower = result.getString(8);
				strength = result.getString(9);
				stamina = result.getString(10);

				String[] rows = { char_id, user_id, name, race, faction, title, life, rpower, strength, stamina };
				System.out.println(Arrays.toString(rows));
				((DefaultTableModel) jtable.getModel()).addRow(rows);
			}

			stmt.close();
			conx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String[] ShowAllColumns() {
		try {
			String[] charArr = new String[0];

			Connection conx = FunctionsHandler.ConnectDDBB();

			boolean isAdmin = UsersControllerDDBB.isCurrentUserAdmin();

			String allQueryUser = "SELECT * FROM characters WHERE user_id='" + UsersControllerDDBB.getCurrentUserId() + "';";

			String allQuery = "SELECT * FROM characters;";

			Statement stmt = conx.prepareStatement(isAdmin ? allQuery : allQueryUser);
			ResultSet result = stmt.executeQuery(isAdmin ? allQuery : allQueryUser);

			while (result.next()) {
				for (int i = 0; i < result.getMetaData().getColumnCount(); i++) {
					charArr[i] = result.getString(i);
				}
			}
			
			stmt.close();
			conx.close();

			return charArr;
		} catch (SQLException e) {
			e.printStackTrace();
			return new String[0];
		}

	}

	public static void DeleteLastCharacterDB() {
		try {
			Connection conx = FunctionsHandler.ConnectDDBB();
			String selectQuery = "SELECT user_id FROM characters ORDER BY name DESC LIMIT 1;";
			PreparedStatement prepStmt = conx.prepareStatement(selectQuery);
			ResultSet result = prepStmt.executeQuery();

			if (result.next()) {
				String delQuery = "DELETE FROM characters WHERE user_id=? LIMIT 1;";
				PreparedStatement delStmt = conx.prepareStatement(delQuery);
				delStmt.setInt(1, result.getInt(1));
				delStmt.execute();
			}

			prepStmt.close();
			conx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void GenerateCSV() {
		Connection conx = FunctionsHandler.ConnectDDBB();
		String allQuery = "SELECT * from characters ORDER BY name ASC;";
		String path = "src/characters.csv";

		try {
			Statement stmt = conx.prepareStatement(allQuery);
			ResultSet rst = stmt.executeQuery(allQuery);

			FileWriter wrt = new FileWriter(path);

			while (rst.next()) {
				wrt.write(rst.getString(3) + ";" + rst.getString(4) + ";"
						+ rst.getString(5) + ";" + rst.getString(6) + ";" + rst.getDouble(7) + ";" + rst.getDouble(8)
						+ ";" + rst.getDouble(9) + ";" + rst.getDouble(10) + "\n");
			}

			wrt.close();
			stmt.close();
			conx.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ReadCSV() {

		List<List<String>> features = new ArrayList<>(10);

		String path = "src/characters.csv";

		try (Scanner scanner = new Scanner(new File(path))) {
		    while (scanner.hasNextLine()) {
		        features.add(getRecordFromLine(scanner.nextLine()));
		    }
		    
		    for (List<String> feature : features) {

	        	Connection conx = FunctionsHandler.ConnectDDBB();

        		String insertQuery = "INSERT INTO characters (user_id, name, race, faction, title, life, runicpower, strength, stamina) "
        				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";

        		conx.prepareStatement(insertQuery);

        		PreparedStatement preStmt = conx.prepareStatement(insertQuery);

        		preStmt.setInt(1, UsersControllerDDBB.getCurrentUserId());
        		preStmt.setString(2, feature.get(0));
        		preStmt.setString(3, feature.get(1));
        		preStmt.setString(4, feature.get(2));
        		preStmt.setString(5, feature.get(3));
        		preStmt.setString(6, feature.get(4));
        		preStmt.setString(7, feature.get(5));
        		preStmt.setString(8, feature.get(6));
        		preStmt.setString(9, feature.get(7));

        		preStmt.execute();

        		preStmt.close();
        		conx.close();
	        }
		    
		} catch (SQLException | IOException e) {
			StringHandler.ErrorHandler(e.toString());
			e.printStackTrace();
		}

	}
}
