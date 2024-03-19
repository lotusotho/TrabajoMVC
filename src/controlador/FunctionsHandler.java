package controlador;

import java.sql.Connection;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Hero;
import servicio.UsersControllerDDBB;
import vista.CharacterCreation;
import vista.CharacterView;
import vista.UsersRegister;
import servicio.CharControllerDDBB;
import servicio.ConnectionDDBB;

public class FunctionsHandler {
	// DDBB Stuff
	public static Connection ConnectDDBB() {
		return ConnectionDDBB.connectBBDD();
	}
	
	public static void InsertCharacter(Hero hero) {
		CharControllerDDBB.InsertCharacter(hero);
		StringHandler.MessageHandler("charCreate");
	};
	
	public static void DeleteCharacter(String name) {
		CharControllerDDBB.DeleteCharacter(name);
		StringHandler.MessageHandler("charDelete");
	}
	
	public static void UsersLogin(String name, String passwd) {
		UsersControllerDDBB.usersLogin(name, passwd);
	}
	
	public static void UsersRegister(String name, String passwd, boolean adminCheck) {
		try {
			UsersControllerDDBB.usersRegister(name, passwd, adminCheck);
		} catch (Exception e) {
			// TODO: Cambiar a StringHandler
			e.printStackTrace();
		}
	}
	
	public static void CreateCSV() {
		try {
			CharControllerDDBB.GenerateCSV();
			StringHandler.MessageHandler("createCSVOK");
		} catch(Exception e) {
			e.printStackTrace();
			StringHandler.MessageHandler("createCSVKO");
		}
	}
	
	public static String[] GetAllCharacters() {
		return CharControllerDDBB.ShowAllColumns();
	}
	
	public static void ViewCharactersTable(JTable jtable) {
		try {
			CharControllerDDBB.ShowAllRows(jtable);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void DeleteLastCharacter(JTable jtable) {
		try {
			CharControllerDDBB.DeleteLastCharacterDB();
			
			if(jtable.getModel().getRowCount() > 0) {
				((DefaultTableModel)jtable.getModel()).removeRow(jtable.getModel().getRowCount() - 1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ClearTable(JTable jtable) {
		try {
			((DefaultTableModel)jtable.getModel()).setRowCount(0);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Vista Panels
	public static void UserRegisterPanel(boolean visible) {
		try {
			UsersRegister userReg = new UsersRegister();
			userReg.setVisible(visible);
		} catch (Exception e) {
			// TODO: Cambiar a StringHandler
			e.printStackTrace();
		}
	}
	
	public static void CharacterCreationPanel(boolean visible) {
		try {
			CharacterCreation charCreation = new CharacterCreation();
			charCreation.setVisible(visible);
		} catch (Exception e) {
			// TODO: Cambiar a StringHandler
			e.printStackTrace();
		}
	}
	
	public static void CharacterManagementPanel(boolean visible) {
		try {
			CharacterView charView = new CharacterView();
			charView.setVisible(visible);
			
		} catch(Exception e) {
			// TODO: Cambiar a StringHandler
			e.printStackTrace();
		}
	}
}
