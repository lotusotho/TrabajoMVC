package controlador;

import java.sql.Connection;

import modelo.Hero;
import servicio.UsersControllerDDBB;
import vista.CharacterCreation;
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
	
	public static String[] GetAllCharacters() {
		return CharControllerDDBB.ShowAllCharacters();
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
}
