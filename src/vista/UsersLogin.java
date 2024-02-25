package vista;

import java.awt.EventQueue;

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

public class UsersLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userTextField;
	private JTextField passTextField;
	private JPanel panel;

	/**
	 * Create the frame.
	 */
	public UsersLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginTitle = new JLabel("Introduce tus datos:");
		lblLoginTitle.setBounds(436, 26, 292, 35);
		lblLoginTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblLoginTitle);
		lblLoginTitle.setFont(new Font("Verdana", Font.PLAIN, 28));
		
		panel = new JPanel();
		panel.setForeground(UIManager.getColor(Color.BLUE));
		panel.setBounds(378, 141, 385, 164);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUserTitle = new JLabel("Usuario:");
		lblUserTitle.setBounds(56, 25, 82, 24);
		panel.add(lblUserTitle);
		lblUserTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserTitle.setFont(new Font("Verdana", Font.PLAIN, 19));
		
		JLabel lblPassTitle = new JLabel("Contraseña:");
		lblPassTitle.setBounds(56, 102, 116, 24);
		panel.add(lblPassTitle);
		lblPassTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassTitle.setFont(new Font("Verdana", Font.PLAIN, 19));
		
		userTextField = new JTextField();
		userTextField.setBounds(195, 27, 143, 29);
		panel.add(userTextField);
		userTextField.setColumns(10);
		
		passTextField = new JTextField();
		passTextField.setBounds(195, 97, 143, 29);
		panel.add(passTextField);
		passTextField.setColumns(10);
	}
}
