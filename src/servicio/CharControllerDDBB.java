package servicio;

import java.io.FileWriter;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.sql.ResultSetMetaData;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controlador.FunctionsHandler;
import controlador.StringHandler;
import modelo.Hero;

/**
 * Aqui definimos las funciones necesarias para gestionar
 * la base de datos de la tabla users
 */

public class CharControllerDDBB {
	private static boolean oneShotTable = false;
	
	public static void InsertCharacter(Hero heroObj) {
		Connection conx = ConnectionDDBB.connectBBDD();
				
		String insertQuery = "INSERT INTO characters (user_id, name, race, faction, title, life, runicpower, strength, stamina) "
				+ "VALUES('"+UsersControllerDDBB.currentUserId+"','"+heroObj.getName()+"','"+heroObj.getRace()+"','"+heroObj.getFaction()+"','"+heroObj.getTitle()+"','"+heroObj.getLife()+"','"
				+heroObj.getRunicPower()+"','"+heroObj.getStrength()+"','"+heroObj.getStamina()+"');";
		
		try {
			conx.prepareStatement(insertQuery).execute();
			JOptionPane.showMessageDialog(null, "El personaje se ha creado satisfactoriamente");
		} catch (SQLException e) {
			StringHandler.ErrorHandler(e.toString());
			e.printStackTrace();
		}
	}
	
	public static void DeleteCharacter(String name) {
		Connection conx = FunctionsHandler.ConnectDDBB();
		
		String deleteQuery = "DELETE FROM characters WHERE name='"+name+"';";
		
		try {
			conx.prepareStatement(deleteQuery).execute();
			JOptionPane.showMessageDialog(null, "El personaje ha sido eliminado satisfactoriamente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void GetDataDB(DefaultTableModel dtm) {
		
		Connection conx = FunctionsHandler.ConnectDDBB();
		String allQuery = "SELECT * FROM characters WHERE user_id="+UsersControllerDDBB.currentUserId+" ORDER BY name ASC;";
		
		try {
			Statement stmt = conx.prepareStatement(allQuery);
			ResultSet result = stmt.executeQuery(allQuery);
			
			String char_id, user_id, name, race, faction, title, life, rpower, strength, stamina;
			
			while(result.next()) {
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
				
				if(!oneShotTable) {
					dtm.addRow(rows);
					oneShotTable = true;
				} else {
					System.out.println("Ya he imprimido la tabla!");
				}
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String[] ShowAllCharacters() {
		String[] charArr = new String[0];
		
		Connection conx = FunctionsHandler.ConnectDDBB();
		String allQuery = "SELECT * FROM characters WHERE user_id='"+UsersControllerDDBB.currentUserId+"';";
		
		try {
			Statement stmt = conx.prepareStatement(allQuery);
			ResultSet result = stmt.executeQuery(allQuery);
			
			while(result.next()) {
				for(int i = 0; i < result.getMetaData().getColumnCount(); i++) {
					charArr[i] = result.getString(i);
				}
			}
			
			return charArr;
		} catch(SQLException e) {
			e.printStackTrace();
			return new String[0];
		}
		
	}
	
	public static void DeleteLastCharacterDB() {
		Connection conx = FunctionsHandler.ConnectDDBB();
		String delQuery = "DELETE FROM characters ORDER BY name DESC;";
		
		try {
			Statement stmt = conx.prepareStatement(delQuery);
			stmt.execute(delQuery);
			
			} catch(SQLException e) {
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
			wrt.write("char_id;user_id;name;race;faction;title;life;runicpower;strength;stamina\n");
			
			while(rst.next()) {
				wrt.write(rst.getInt(1) + ";" + rst.getInt(2) + ";" + rst.getString(3) + ";" + rst.getString(4)
				+ ";" + rst.getString(5) + ";" + rst.getString(6) + ";" + rst.getString(7) + ";" + rst.getString(8)
				+ ";" + rst.getDouble(9) + rst.getDouble(10));
			}
			
			wrt.close();
			JOptionPane.showMessageDialog(null, "El fichero se ha creado con exito");
			
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ha habido un error creando el fichero");
		}
	}
	// TODO: Borrar mas tarde si no acabo usando
//	public static String[] GetCharactersNames() {
//		Connection conx = ConexionDDBB.connectBBDD();
//		
//		Statement stmt;
//		ResultSet result;
//		
//		String getNameQuery = "SELECT name FROM characters;";
//		
//		try {
//			stmt = conx.createStatement();
//			
//			result = stmt.executeQuery(getNameQuery);
//			
//			return finalResult;
//		} catch(SQLException e) {
//			e.printStackTrace();
//			return new String[0];
//		}
//	}
//	
//	public static boolean CompareCharactersName(String name) {
//		String[] charNames = GetCharactersNames();
//		
//		for(int i = 0; i < charNames.length; i++) {
//			if(charNames[i] == name) {
//				return true;
//			}
//		}
//		
//		return false;
//	}
}
