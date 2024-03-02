package main;

import java.awt.EventQueue;

import vista.UsersLogin;

/**
 * Comenzamos el programa desde Main
 * llamando a que se renderice la ventana
 * UsersLogin
 */

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsersLogin frame = new UsersLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
