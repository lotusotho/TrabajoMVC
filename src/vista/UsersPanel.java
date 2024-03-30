package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.FunctionsHandler;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

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
		
		Image iconImg = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/wowIcon.png"));
		setIconImage(iconImg);
		
		setBounds(0, 0, 720, 500);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPanelDelUsuario = new JLabel("Panel del usuario:");
		lblPanelDelUsuario.setBounds(199, 32, 305, 35);
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
		btnCreateChar.setBounds(229, 119, 236, 80);
		btnCreateChar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler.CharacterCreationPanel(true);
			}
		});
		contentPane.add(btnCreateChar);
		
		JButton btnAdminChars = new JButton("Admin. Personajes");
		btnAdminChars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler.CharacterManagementPanel(true);
			}
		});
		btnAdminChars.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnAdminChars.setBounds(229, 234, 236, 80);
		contentPane.add(btnAdminChars);
		
		JButton btnBack = new JButton("Volver");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler.UserLoginPanel(true);
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
		
		if(FunctionsHandler.isCurrentUserAdmin()) {
			JButton btnAdminUsers = new JButton("Admin. Usuarios");
			btnAdminUsers.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FunctionsHandler.UsersManagementPanel(true);
				}
			});
			btnAdminUsers.setFont(new Font("Verdana", Font.PLAIN, 17));
			btnAdminUsers.setBounds(229, 344, 236, 80);
			contentPane.add(btnAdminUsers);
		}
	}
}
