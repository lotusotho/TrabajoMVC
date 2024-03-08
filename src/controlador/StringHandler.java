package controlador;

import javax.swing.JOptionPane;

/**
 * Aqui gestionamos los errores con mensajes
 * JOptionPane mucho mas amigables al usuario
 */

public class StringHandler {
	public static void ErrorHandler(String error) {
		if(error.contains("Duplicate entry")) {
			JOptionPane.showMessageDialog(null, "Ese nombre de personaje ya existe, por favor, introduce otro");
		}
	}
	
	public static void MessageHandler(String message) {
		switch(message) {
		case "charCreate":
			JOptionPane.showMessageDialog(null, "El personaje a sido creado satisfactoriamente");
			break;
		case "charDelete":
			JOptionPane.showMessageDialog(null, "El personaje a sido borrado satisfactoriamente");
			break;
		}
	}
}
