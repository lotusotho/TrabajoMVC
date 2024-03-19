package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.FunctionsHandler;
import servicio.UsersControllerDDBB;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

/**
 * Interfaz del registro de usuarios
 */

public class UsersRegister extends JFrame {

	private JPanel contentPane;
	private JTextField userTextField;
	private JTextField passTextField;

	public UsersRegister() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(1080, 20, 720, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeUsuarios = new JLabel("Registro de usuarios:");
		lblRegistroDeUsuarios.setBackground(new Color(0, 0, 0));
		lblRegistroDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeUsuarios.setForeground(Color.BLACK);
		lblRegistroDeUsuarios.setFont(new Font("Verdana", Font.PLAIN, 28));
		lblRegistroDeUsuarios.setBounds(161, 36, 366, 35);
		contentPane.add(lblRegistroDeUsuarios);
		
		JPanel panelFormUsers = new JPanel();
		panelFormUsers.setLayout(null);
		panelFormUsers.setForeground((Color) null);
		panelFormUsers.setBackground(Color.WHITE);
		panelFormUsers.setBounds(142, 120, 385, 208);
		contentPane.add(panelFormUsers);
		
		JLabel lblUserTitle = new JLabel("Usuario:");
		lblUserTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserTitle.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblUserTitle.setBounds(56, 25, 82, 24);
		panelFormUsers.add(lblUserTitle);
		
		JLabel lblPassTitle = new JLabel("Contraseña:");
		lblPassTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassTitle.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblPassTitle.setBounds(56, 102, 116, 24);
		panelFormUsers.add(lblPassTitle);
		
		userTextField = new JTextField();
		userTextField.setColumns(10);
		userTextField.setBounds(195, 27, 143, 29);
		panelFormUsers.add(userTextField);
		
		passTextField = new JTextField();
		passTextField.setColumns(10);
		passTextField.setBounds(195, 97, 143, 29);
		panelFormUsers.add(passTextField);
		
		JCheckBox adminCheckBox = new JCheckBox("Administrador");
		adminCheckBox.setFont(new Font("Verdana", Font.PLAIN, 16));
		adminCheckBox.setBounds(56, 149, 252, 41);
		panelFormUsers.add(adminCheckBox);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnRegistrar.setBounds(263, 363, 136, 42);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler.UsersRegister(userTextField.getText(), passTextField.getText(), adminCheckBox.isEnabled());
			}
		});
		contentPane.add(btnRegistrar);
		
	}
}
