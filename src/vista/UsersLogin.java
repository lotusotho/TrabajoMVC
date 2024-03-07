package vista;

import java.awt.EventQueue;

import controlador.UsersControllerDDBB;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * Interfaz del logeo de usuarios. PAGINA DE INICIO
 */

public class UsersLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userTextField;
	private JTextField passTextField;
	private JPanel panelFormUsers;

	/**
	 * Create the frame.
	 */
	public UsersLogin() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginTitle = new JLabel("Introduce tus datos:");
		lblLoginTitle.setForeground(Color.WHITE);
		lblLoginTitle.setBounds(497, 83, 292, 35);
		lblLoginTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblLoginTitle);
		lblLoginTitle.setFont(new Font("Verdana", Font.PLAIN, 28));
		
		panelFormUsers = new JPanel();
		panelFormUsers.setBounds(442, 182, 385, 164);
		panelFormUsers.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelFormUsers.setForeground(UIManager.getColor(Color.BLUE));
		contentPane.add(panelFormUsers);
		panelFormUsers.setLayout(null);
		
		JLabel lblUserTitle = new JLabel("Usuario:");
		lblUserTitle.setBounds(56, 25, 82, 24);
		panelFormUsers.add(lblUserTitle);
		lblUserTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserTitle.setFont(new Font("Verdana", Font.PLAIN, 19));
		
		JLabel lblPassTitle = new JLabel("Contraseña:");
		lblPassTitle.setBounds(56, 102, 116, 24);
		panelFormUsers.add(lblPassTitle);
		lblPassTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassTitle.setFont(new Font("Verdana", Font.PLAIN, 19));
		
		userTextField = new JTextField();
		userTextField.setBounds(195, 27, 143, 29);
		panelFormUsers.add(userTextField);
		userTextField.setColumns(10);
		
		passTextField = new JTextField();
		passTextField.setBounds(195, 97, 143, 29);
		panelFormUsers.add(passTextField);
		passTextField.setColumns(10);
		
		JButton btnUserLogin = new JButton("Entrar");
		btnUserLogin.setBounds(575, 377, 136, 42);
		btnUserLogin.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsersControllerDDBB.usersLogin(userTextField.getText(), passTextField.getText());
			}
		});
		contentPane.add(btnUserLogin);
		
		JButton btnUserRegister = new JButton("Registrarse");
		btnUserRegister.setBounds(575, 441, 136, 42);
		btnUserRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UsersRegister userReg = new UsersRegister();					
					userReg.setVisible(true);
					
				} catch(Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		btnUserRegister.setFont(new Font("Verdana", Font.PLAIN, 17));
		contentPane.add(btnUserRegister);
		
		JLabel lblBGImage = new JLabel("");
		lblBGImage.setIcon(new ImageIcon(UsersLogin.class.getResource("/img/bgLogin.png")));
		lblBGImage.setBounds(1, 1, 1280, 720);
		contentPane.add(lblBGImage);
	}
}
