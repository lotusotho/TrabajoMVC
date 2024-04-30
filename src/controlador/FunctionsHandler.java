package controlador;

import java.awt.Window;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import servicio.CharControllerDDBB;
import servicio.ConnectionDDBB;
import servicio.Hero;
import servicio.UsersControllerDDBB;
import vista.CharacterCreation;
import vista.CharacterView;
import vista.StringHandler;
import vista.UsersLogin;
import vista.UsersPanel;
import vista.UsersRecover;
import vista.UsersRegister;
import vista.UsersView;

public class FunctionsHandler {
	// DDBB Stuff
	public static Connection ConnectDDBB() {
		return ConnectionDDBB.connectBBDD();
	}

	public static void InsertCharacter(Hero hero) {
		CharControllerDDBB.InsertCharacter(hero);
		StringHandler.MessageHandler("charCreate");
	}

	public static void UsersLogin(String name, String passwd) {
		UsersControllerDDBB.usersLogin(name, passwd);
	}

	public static void UsersRegister(String name, String passwd, boolean adminCheck) {
		UsersControllerDDBB.usersRegister(name, passwd, adminCheck);
	}

	public static void CreateCSV() {
		try {
			CharControllerDDBB.GenerateCSV();
			StringHandler.MessageHandler("createCSVOK");
		} catch (Exception e) {
			e.printStackTrace();
			StringHandler.MessageHandler("createCSVKO");
		}
	}

	public static String[] GetAllCharacters() {
		return CharControllerDDBB.ShowAllColumns();
	}

	public static void ViewCharactersTable(JTable jtable) {
		if (((DefaultTableModel) jtable.getModel()).getRowCount() > 0) {
			ClearTable(jtable);
		}

		CharControllerDDBB.ShowAllRows(jtable);
	}

	public static void DeleteLastCharacter(JTable jtable) {
		CharControllerDDBB.DeleteLastCharacterDB();

		((DefaultTableModel) jtable.getModel()).removeRow(jtable.getModel().getRowCount() - 1);
	}

	public static void ClearTable(JTable jtable) {
		((DefaultTableModel) jtable.getModel()).setRowCount(0);
	}

	public static void ReadCSV() {
		CharControllerDDBB.ReadCSV();
	}

	public static boolean isCurrentUserAdmin() {
		return UsersControllerDDBB.isCurrentUserAdmin();
	}
	
	public static ArrayList<String> GetFactions(int selector){
		return CharControllerDDBB.GetCharacterFRC(selector);
	}

	// UsersView

	public static void ViewUsersTable(JTable jtable) {
		if (((DefaultTableModel) jtable.getModel()).getRowCount() > 0) {
			ClearTable(jtable);
		}

		UsersControllerDDBB.ShowAllRows(jtable);
	}

	public static void DeleteLastUser(JTable jtable) {
		UsersControllerDDBB.DeleteLastUserDB();

		((DefaultTableModel) jtable.getModel()).removeRow(jtable.getModel().getRowCount() - 1);
	}

	public static void RecoverPassUser(String oldPasswd, String newPasswd, String name) {
		UsersControllerDDBB.RecoverPassUser(oldPasswd, newPasswd, name);
	}

	// Vista Panels
	private static void CloseAllWindows() {
		System.gc();

		for (Window window : Window.getWindows()) {
			window.dispose();
		}
	}

	public static void UserLoginPanel(boolean visible) {
		CloseAllWindows();
		UsersLogin usersLogin = new UsersLogin();
		usersLogin.setVisible(visible);
	}

	public static void UserRegisterPanel(boolean visible) {
		CloseAllWindows();
		UsersRegister userReg = new UsersRegister();
		userReg.setVisible(visible);
	}

	public static void UsersControlPanel(boolean visible) {
		CloseAllWindows();
		UsersPanel usersPanel = new UsersPanel();
		usersPanel.setVisible(visible);
	}

	public static void CharacterCreationPanel(boolean visible) {
		CloseAllWindows();
		CharacterCreation charCreation = new CharacterCreation();
		charCreation.setVisible(visible);
	}

	public static void CharacterManagementPanel(boolean visible) {
		CloseAllWindows();
		CharacterView charView = new CharacterView();
		charView.setVisible(visible);
	}

	public static void UsersManagementPanel(boolean visible) {
		CloseAllWindows();
		UsersView userView = new UsersView();
		userView.setVisible(visible);
	}

	public static void UsersRecoverPanel(boolean visible) {
		CloseAllWindows();
		UsersRecover usersRecover = new UsersRecover();
		usersRecover.setVisible(visible);
	}
}
