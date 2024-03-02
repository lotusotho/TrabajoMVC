package controlador;

import javax.swing.JOptionPane;

public class ErrorHandlerDDBB {
	public static void HandleError(String error) {
		if(error.contains("Duplicate entry")) {
			JOptionPane.showMessageDialog(null, "Ese nombre de personaje ya existe, por favor, introduce otro");
		}
	}
}
