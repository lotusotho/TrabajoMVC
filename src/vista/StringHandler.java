package vista;

import javax.swing.JOptionPane;

/**
 * Aqui gestionamos los errores con mensajes
 * JOptionPane mucho mas amigables al usuario
 */

public class StringHandler {
	/**
	 * Usamos esta funcion para detectar que tipo de error es dependiendo de las palabras que contiene
	 * @param error
	 */
	public void ErrorHandler(String error) {
		if(error.contains("Duplicate entry")) {
			JOptionPane.showMessageDialog(null, "Ese nombre de personaje ya existe, por favor, introduce otro");
		}
	}

	/**
	 * Usamos esta funcion para detectar el mensaje que debemos monstrar en pantalla a partir de un codigo de tipo String
	 * @param message
	 */
	public void MessageHandler(String message) {
		switch(message) {
		case "charCreate":
			JOptionPane.showMessageDialog(null, "El personaje a sido creado satisfactoriamente");
			break;
		case "charDelete":
			JOptionPane.showMessageDialog(null, "El personaje a sido borrado satisfactoriamente");
			break;
		case "createCSVOK":
			JOptionPane.showMessageDialog(null, "El fichero se ha creado con exito");
			break;
		case "createCSVKO":
			JOptionPane.showMessageDialog(null, "Ha habido un error creando el fichero");
			break;
		case "userLoginKO":
			JOptionPane.showMessageDialog(null, "El usuario/contraseña son incorrectos");
			break;
		case "userRegOK":
			JOptionPane.showMessageDialog(null, "Se ha registrado correctamente el usuario");
			break;
		case "userRegKO":
			JOptionPane.showMessageDialog(null, "Ha habido un error registrando en usuario");
			break;
		case "NoDeleteCurrentUser":
			JOptionPane.showMessageDialog(null, "No se puede borrar al usuario que está actualmente en la sesión");
			break;
		case "passChangeOK":
			JOptionPane.showMessageDialog(null, "La contraseña se ha cambiado correctamente");
			break;
		case "passChangeKO":
			JOptionPane.showMessageDialog(null, "El usuario o contraseña establecidos no son correctos");
			break;
		case "noChars":
			JOptionPane.showMessageDialog(null, "Este usuario no tiene todavía ningún personaje");
			break;
		case "passUserRegisterKO":
			JOptionPane.showMessageDialog(null, "Por favor, introduce un usuario/contraseña");
			break;
		}
	}
}
