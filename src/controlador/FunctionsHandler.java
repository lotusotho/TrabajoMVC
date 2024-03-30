package controlador;

import java.awt.Window;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Hero;
import modelo.User;
import servicio.UsersControllerDDBB;
import vista.CharacterCreation;
import vista.CharacterView;
import vista.UsersRegister;
import vista.UsersView;
import vista.UsersLogin;
import vista.UsersPanel;
import servicio.CharControllerDDBB;
import servicio.ConnectionDDBB;

public class FunctionsHandler {
	private static ArrayList<JFrame> panels = new ArrayList<JFrame>();

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
		} catch (Exception e) {
			e.printStackTrace();
			StringHandler.MessageHandler("createCSVKO");
		}
	}

	public static String[] GetAllCharacters() {
		return CharControllerDDBB.ShowAllColumns();
	}

	public static void ViewCharactersTable(JTable jtable) {
		try {
			if (((DefaultTableModel) jtable.getModel()).getRowCount() > 0) {
				ClearTable(jtable);
			}

			CharControllerDDBB.ShowAllRows(jtable);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void DeleteLastCharacter(JTable jtable) {
		try {
			CharControllerDDBB.DeleteLastCharacterDB();

			((DefaultTableModel) jtable.getModel()).removeRow(jtable.getModel().getRowCount() - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ClearTable(JTable jtable) {
		try {
			((DefaultTableModel) jtable.getModel()).setRowCount(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ReadCSV() {
		try {
			CharControllerDDBB.ReadCSV();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isCurrentUserAdmin() {
		try {
			return UsersControllerDDBB.isCurrentUserAdmin();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	// UsersView
	
	public static void ViewUsersTable(JTable jtable) {
		try {
			if (((DefaultTableModel) jtable.getModel()).getRowCount() > 0) {
				ClearTable(jtable);
			}

			UsersControllerDDBB.ShowAllRows(jtable);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void DeleteLastUser(JTable jtable) {
		try {
			UsersControllerDDBB.DeleteLastUserDB();

			((DefaultTableModel) jtable.getModel()).removeRow(jtable.getModel().getRowCount() - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Vista Panels
	private static void CloseAllWindows() {
		System.gc();

		for (Window window : Window.getWindows()) {
			window.dispose();
		}
	}

	public static void UserLoginPanel(boolean visible) {
		try {
			CloseAllWindows();
			UsersLogin usersLogin = new UsersLogin();
			usersLogin.setVisible(visible);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void UserRegisterPanel(boolean visible) {
		try {
			CloseAllWindows();
			UsersRegister userReg = new UsersRegister();
			userReg.setVisible(visible);
		} catch (Exception e) {
			// TODO: Cambiar a StringHandler
			e.printStackTrace();
		}
	}

	public static void UsersControlPanel(boolean visible) {
		try {
			CloseAllWindows();
			UsersPanel usersPanel = new UsersPanel();
			usersPanel.setVisible(visible);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void CharacterCreationPanel(boolean visible) {
		try {
			CloseAllWindows();
			CharacterCreation charCreation = new CharacterCreation();
			charCreation.setVisible(visible);
		} catch (Exception e) {
			// TODO: Cambiar a StringHandler
			e.printStackTrace();
		}
	}

	public static void CharacterManagementPanel(boolean visible) {
		try {
			CloseAllWindows();
			CharacterView charView = new CharacterView();
			charView.setVisible(visible);

		} catch (Exception e) {
			// TODO: Cambiar a StringHandler
			e.printStackTrace();
		}
	}
	
	public static void UsersManagementPanel(boolean visible) {
		try {
			CloseAllWindows();
			UsersView userView = new UsersView();
			userView.setVisible(visible);
		} catch (Exception e) {
			// TODO: Cambiar a StringHandler
			e.printStackTrace();
		}
	}
}
