package controlador;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.Heroes;

public class CharCreationControllerDDBB {
	public static void InsertCharacter(Heroes hero) {
		Connection conx = ConexionDDBB.connectBBDD();
				
		String insertQuery = "INSERT INTO characters (name, race, faccion, title, life, runicpower, strength, stamina) "
				+ "VALUES('"+hero.getName()+"','"+hero.getRace()+"','"+hero.getFaction()+"','"+hero.getTitle()+"','"+hero.getLife()+"','"
				+hero.getRunicPower()+"','"+hero.getStrength()+"','"+hero.getStamina()+"');";
		
		try {
			conx.prepareStatement(insertQuery).execute();
			JOptionPane.showMessageDialog(null, "El personaje ha sido introducido de forma satisfactoria");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
