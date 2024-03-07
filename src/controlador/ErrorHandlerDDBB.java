package controlador;

import javax.swing.JOptionPane;

/**
 * Aqui gestionamos los errores con mensajes
 * JOptionPane mucho mas amigables al usuario
 */

public class ErrorHandlerDDBB {
	public static void HandleError(String error) {
		if(error.contains("Duplicate entry")) {
			JOptionPane.showMessageDialog(null, "Ese nombre de personaje ya existe, por favor, introduce otro");
		}
	}
}
