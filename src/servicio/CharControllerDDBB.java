package servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.FunctionsHandler;
import vista.StringHandler;

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

			String insertQuery = "INSERT INTO hero (user_id, name, race_id, faction_id, class_id, title, "
					+ "life, runicpower, strength, stamina) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement preStmt = conx.prepareStatement(insertQuery);

			preStmt.setInt(1, UsersControllerDDBB.getCurrentUserId());
			preStmt.setString(2, heroObj.getName());
			preStmt.setInt(3, heroObj.getRace_id());
			preStmt.setBoolean(4, heroObj.getFaction_id());
			preStmt.setInt(5, heroObj.getHeroClass_id());
			preStmt.setString(6, heroObj.getTitle());
			preStmt.setBigDecimal(7, heroObj.getLife());
			preStmt.setInt(8, heroObj.getRunicPower());
			preStmt.setBigDecimal(9, heroObj.getStrength());
			preStmt.setBigDecimal(10, heroObj.getStamina());

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

			String allQueryUser = "SELECT name, r.raceName, c.className, f.factionName, title, life, "
					+ "runicpower, strength, stamina FROM hero h "
					+ "LEFT JOIN race r on h.race_ID = r.ID "
					+ "LEFT JOIN heroClass c on h.class_ID = c.ID "
					+ "LEFT JOIN faction f on h.faction_ID = f.ID where user_id=" + UsersControllerDDBB.getCurrentUserId() + " ORDER BY name ASC;";

			String allQuery = "SELECT name, r.raceName, c.className, f.factionName, title, life, "
					+ "runicpower, strength, stamina FROM hero h "
					+ "LEFT JOIN race r on h.race_ID = r.ID "
					+ "LEFT JOIN heroClass c on h.class_ID = c.ID "
					+ "LEFT JOIN faction f on h.faction_ID = f.ID ORDER BY name ASC;";

			Statement stmt = conx.prepareStatement(isAdmin ? allQuery : allQueryUser);
			ResultSet result = stmt.executeQuery(isAdmin ? allQuery : allQueryUser);

			String name, race, heroClass, faction, title, life, rpower, strength, stamina;

			while (result.next()) {
				if(result.wasNull()) {
					StringHandler.MessageHandler("noChars");
				} else {
					name = result.getString(1);
					race = result.getString(2);
					faction = result.getString(3);
					heroClass = result.getString(4);
					title = result.getString(5);
					life = result.getString(6);
					rpower = result.getString(7);
					strength = result.getString(8);
					stamina = result.getString(9);

					String[] rows = { name, race, faction, heroClass, title, life, rpower, strength, stamina };
					System.out.println(Arrays.toString(rows));
					((DefaultTableModel) jtable.getModel()).addRow(rows);
				}
			}

			stmt.close();
			conx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	public static String[] ShowAllColumns() {
//		try {
//			String[] charArr = new String[0];
//
//			Connection conx = FunctionsHandler.ConnectDDBB();
//
//			boolean isAdmin = UsersControllerDDBB.isCurrentUserAdmin();
//
//			String allQueryUser = "SELECT * FROM hero WHERE=" + UsersControllerDDBB.getCurrentUserId() +";";
//
//			String allQuery = "SELECT * FROM hero;";
//
//			Statement stmt = conx.prepareStatement(isAdmin ? allQuery : allQueryUser);
//			ResultSet result = stmt.executeQuery(isAdmin ? allQuery : allQueryUser);
//			
//			if(result.next()) {
//				for (int i = 0; i < result.getMetaData().getColumnCount(); i++) {
//					charArr[i] = result.getMetaData().getColumnName(i);
//				}
//			}
//
//			stmt.close();
//			conx.close();
//
//			return charArr;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return new String[0];
//		}
//
//	}

	public static void DeleteLastCharacterDB() {
		try {
			Connection conx = FunctionsHandler.ConnectDDBB();
			String selectQuery = "SELECT user_id FROM hero ORDER BY name DESC LIMIT 1;";
			PreparedStatement prepStmt = conx.prepareStatement(selectQuery);
			ResultSet result = prepStmt.executeQuery();

			if (result.next()) {
				String delQuery = "DELETE FROM hero WHERE user_id=? LIMIT 1;";
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

	public static ArrayList<String> GetCharacterFRC(int selector) {
		try {
			ArrayList<String> factions = new ArrayList<>();

			Connection conx = FunctionsHandler.ConnectDDBB();

			String selectQuery = "";

			if(selector == 1) {
				selectQuery = "SELECT factionName FROM faction;";
			} else if(selector == 2) {
				selectQuery = "SELECT raceName FROM race;";
			} else if(selector == 3) {
				selectQuery = "SELECT className FROM heroclass;";
			}

			PreparedStatement prepStmt = conx.prepareStatement(selectQuery);
			ResultSet result = prepStmt.executeQuery();

			while(result.next()) {
				factions.add(result.getString(1));
			}

			prepStmt.close();
			conx.close();

			return factions;
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public static void GenerateCSV() {
		Connection conx = FunctionsHandler.ConnectDDBB();

		String allQuery = "SELECT * FROM hero;";

		String path = "src/hero.csv";

		try {
			Statement stmt = conx.prepareStatement(allQuery);
			ResultSet rst = stmt.executeQuery(allQuery);

			FileWriter wrt = new FileWriter(path);
			
//			for (int i = 0; i < rst.getMetaData().getColumnCount(); i++) {
//				wrt.write(rst.getMetaData().getColumnName(i));
//			}

			while (rst.next()) {
				wrt.write(rst.getInt(1) + ";" + rst.getInt(2) + ";" + rst.getString(3) + ";" + rst.getInt(4) + ";"
						+ rst.getInt(5) + ";" + rst.getInt(6) + ";" + rst.getString(7) + ";" + rst.getBigDecimal(8)
						+ ";" + rst.getInt(9) + ";" + rst.getBigDecimal(10) + ";" + rst.getBigDecimal(11) + "\n");
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

		String path = "src/hero.csv";

		try (Scanner scanner = new Scanner(new File(path))) {
		    while (scanner.hasNextLine()) {
		        features.add(getRecordFromLine(scanner.nextLine()));
		    }

		    for (List<String> feature : features) {

	        	Connection conx = FunctionsHandler.ConnectDDBB();

	        	String insertQuery = "INSERT INTO hero (char_id ,user_id, name, race_id, faction_id, class_id, title, "
						+ "life, runicpower, strength, stamina) "
						+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        		conx.prepareStatement(insertQuery);

        		PreparedStatement preStmt = conx.prepareStatement(insertQuery);

        		preStmt.setInt(1, Integer.parseInt(feature.get(0)));
        		preStmt.setInt(2, UsersControllerDDBB.getCurrentUserId());
        		preStmt.setString(3, feature.get(2));
        		preStmt.setInt(4, Integer.parseInt(feature.get(3)));
        		preStmt.setInt(5, Integer.parseInt(feature.get(4)));
        		preStmt.setInt(6, Integer.parseInt(feature.get(5)));
        		preStmt.setString(7, feature.get(6));
        		preStmt.setString(8, feature.get(7));
        		preStmt.setString(9, feature.get(8));
        		preStmt.setString(10, feature.get(9));
        		preStmt.setString(11, feature.get(10));

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
