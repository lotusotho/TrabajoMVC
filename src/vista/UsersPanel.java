package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.FunctionsHandler;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Interfaz del panel de gestion de usuario
 */

public class UsersPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public UsersPanel() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPanelDelUsuario = new JLabel("Panel del usuario:");
		lblPanelDelUsuario.setBounds(482, 32, 305, 35);
		lblPanelDelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelDelUsuario.setForeground(Color.BLACK);
		lblPanelDelUsuario.setFont(new Font("Verdana", Font.PLAIN, 28));
		lblPanelDelUsuario.setBackground(Color.BLACK);
		contentPane.add(lblPanelDelUsuario);
		
		JLabel lblBG = new JLabel("");
		lblBG.setBounds(279, 383, 46, 14);
		contentPane.add(lblBG);
		
		JButton btnCreateChar = new JButton("Creación de Personajes");
		btnCreateChar.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnCreateChar.setBounds(500, 145, 236, 80);
		btnCreateChar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler.CharacterCreationPanel(true);
			}
		});
		contentPane.add(btnCreateChar);
		
		JButton btnAdminChars = new JButton("Admin Personajes");
		btnAdminChars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler.CharacterManagementPanel(true);
			}
		});
		btnAdminChars.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnAdminChars.setBounds(500, 273, 236, 80);
		contentPane.add(btnAdminChars);
	}
}
