package main;

import java.awt.EventQueue;

import controlador.FunctionsHandler;

/**
 * Comenzamos el programa desde Main
 * llamando a que se renderice la ventana
 * UsersLogin
 */

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FunctionsHandler functionsHandler = new FunctionsHandler();
					functionsHandler.UserLoginPanel(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
