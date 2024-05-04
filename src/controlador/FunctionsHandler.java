package controlador;

import java.awt.Window;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import servicio.CharControllerDDBB;
import servicio.ConnectionDDBB;
import servicio.Hero;
import servicio.UserControllerDDBB;
import vista.CharacterCreation;
import vista.CharacterView;
import vista.StringHandler;
import vista.UsersLogin;
import vista.UsersPanel;
import vista.UsersRecover;
import vista.UsersRegister;
import vista.UsersView;

public class FunctionsHandler {
	UserControllerDDBB usersControllerDDBB = new UserControllerDDBB();
	StringHandler stringHandler = new StringHandler();
	CharControllerDDBB charControllerDDBB = new CharControllerDDBB();

	// Conexiones a la BBDD
	public static Connection ConnectDDBB() {
		return ConnectionDDBB.connectDDBB();
	}

	public void InsertCharacter(Hero hero) {
		charControllerDDBB.InsertCharacter(hero);
		stringHandler.MessageHandler("charCreate");
	}

	public void UsersLogin(String name, String passwd) {
		usersControllerDDBB.usersLogin(name, passwd);
	}

	public void UsersRegister(String name, String passwd, boolean adminCheck) {
		usersControllerDDBB.usersRegister(name, passwd, adminCheck);
	}

	public void CreateCSV() {
		try {
			charControllerDDBB.GenerateCSV();
			stringHandler.MessageHandler("createCSVOK");
		} catch (Exception e) {
			e.printStackTrace();
			StringHandler stringHandler2 = new StringHandler();
			stringHandler2.MessageHandler("createCSVKO");
		}
	}

//	public String[] GetAllCharacters() {
//		return CharControllerDDBB.ShowAllColumns();
//	}

	public void ViewCharactersTable(JTable jtable) {
		if (((DefaultTableModel) jtable.getModel()).getRowCount() > 0) {
			ClearTable(jtable);
		}

		charControllerDDBB.ShowAllRows(jtable);
	}

	public void DeleteLastCharacter(JTable jtable) {
		charControllerDDBB.DeleteLastCharacterDB();

		((DefaultTableModel) jtable.getModel()).removeRow(jtable.getModel().getRowCount() - 1);
	}

	public void ClearTable(JTable jtable) {
		((DefaultTableModel) jtable.getModel()).setRowCount(0);
	}

	public void ReadCSV() {
		charControllerDDBB.ReadCSV();
	}

	public boolean isCurrentUserAdmin() {
		return UserControllerDDBB.isCurrentUserAdmin();
	}

	public ArrayList<String> GetFactions(int selector){
		return charControllerDDBB.GetCharacterFRC(selector);
	}

	// UsersView

	public void ViewUsersTable(JTable jtable) {
		if (((DefaultTableModel) jtable.getModel()).getRowCount() > 0) {
			ClearTable(jtable);
		}

		usersControllerDDBB.ShowAllRows(jtable);
	}

	public void DeleteLastUser(JTable jtable) {
		usersControllerDDBB.DeleteLastUserDB();

		((DefaultTableModel) jtable.getModel()).removeRow(jtable.getModel().getRowCount() - 1);
	}

	public void RecoverPassUser(String oldPasswd, String newPasswd, String name) {
		usersControllerDDBB.RecoverPassUser(oldPasswd, newPasswd, name);
	}

	// Vista Panels
	private static void CloseAllWindows() {
		System.gc();

		for (Window window : Window.getWindows()) {
			window.dispose();
		}
	}

	public void UserLoginPanel(boolean visible) {
		CloseAllWindows();
		UsersLogin usersLogin = new UsersLogin();
		usersLogin.setVisible(visible);
	}

	public void UserRegisterPanel(boolean visible) {
		CloseAllWindows();
		UsersRegister userReg = new UsersRegister();
		userReg.setVisible(visible);
	}

	public void UsersControlPanel(boolean visible) {
		CloseAllWindows();
		UsersPanel usersPanel = new UsersPanel();
		usersPanel.setVisible(visible);
	}

	public void CharacterCreationPanel(boolean visible) {
		CloseAllWindows();
		CharacterCreation charCreation = new CharacterCreation();
		charCreation.setVisible(visible);
	}

	public void CharacterManagementPanel(boolean visible) {
		CloseAllWindows();
		CharacterView charView = new CharacterView();
		charView.setVisible(visible);
	}

	public void UsersManagementPanel(boolean visible) {
		CloseAllWindows();
		UsersView userView = new UsersView();
		userView.setVisible(visible);
	}

	public void UsersRecoverPanel(boolean visible) {
		CloseAllWindows();
		UsersRecover usersRecover = new UsersRecover();
		usersRecover.setVisible(visible);
	}
}
