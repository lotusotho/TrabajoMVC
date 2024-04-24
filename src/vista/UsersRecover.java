package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controlador.FunctionsHandler;

/**
 * Interfaz del registro de usuarios
 */

public class UsersRecover extends JFrame {

	private JPanel contentPane;
	private JTextField userTextField;
	private JTextField oldPassTextField;
	private JTextField newPassTextField;

	public UsersRecover() {
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		Image iconImg = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/wowIcon.png"));
		setIconImage(iconImg);

		setBounds(0, 0, 720, 500);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnBack = new JButton("Volver");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler.UserLoginPanel(true);
			}
		});
		btnBack.setBounds(20, 21, 89, 23);
		contentPane.add(btnBack);

		JPanel panelTitle = new JPanel();
		panelTitle.setBorder(UIManager.getBorder("ScrollPane.border"));
		panelTitle.setBounds(161, 36, 366, 35);
		contentPane.add(panelTitle);
		panelTitle.setLayout(null);

		JLabel lblRegistroDeUsuarios = new JLabel("Recuperar contraseña:");
		lblRegistroDeUsuarios.setBounds(0, 0, 366, 35);
		panelTitle.add(lblRegistroDeUsuarios);
		lblRegistroDeUsuarios.setBackground(new Color(0, 0, 0));
		lblRegistroDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeUsuarios.setForeground(Color.BLACK);
		lblRegistroDeUsuarios.setFont(new Font("Verdana", Font.PLAIN, 28));

		JPanel panelFormUsers = new JPanel();
		panelFormUsers.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panelFormUsers.setLayout(null);
		panelFormUsers.setForeground((Color) null);
		panelFormUsers.setBackground(Color.WHITE);
		panelFormUsers.setBounds(136, 120, 439, 208);
		contentPane.add(panelFormUsers);

		JLabel lblUserTitle = new JLabel("Usuario:");
		lblUserTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserTitle.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblUserTitle.setBounds(57, 25, 82, 24);
		panelFormUsers.add(lblUserTitle);

		JLabel lblOldPassTitle = new JLabel("Antigua contraseña:");
		lblOldPassTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblOldPassTitle.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblOldPassTitle.setBounds(57, 89, 183, 24);
		panelFormUsers.add(lblOldPassTitle);

		userTextField = new JTextField();
		userTextField.setColumns(10);
		userTextField.setBounds(250, 27, 143, 29);
		panelFormUsers.add(userTextField);

		oldPassTextField = new JPasswordField();
		oldPassTextField.setColumns(10);
		oldPassTextField.setBounds(250, 84, 143, 29);
		panelFormUsers.add(oldPassTextField);

		JLabel lblNewPassTitle = new JLabel("Nueva contraseña:");
		lblNewPassTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewPassTitle.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewPassTitle.setBounds(57, 144, 183, 24);
		panelFormUsers.add(lblNewPassTitle);

		newPassTextField = new JTextField();
		newPassTextField.setColumns(10);
		newPassTextField.setBounds(250, 139, 143, 29);
		panelFormUsers.add(newPassTextField);

		JButton btnRegistrar = new JButton("Cambiar contraseña");
		btnRegistrar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnRegistrar.setBounds(258, 361, 189, 42);
		btnRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler.RecoverPassUser(oldPassTextField.getText(), newPassTextField.getText(), userTextField.getText());
			}
		});
		contentPane.add(btnRegistrar);

		JLabel bgLabel = new JLabel("");
		bgLabel.setIcon(new ImageIcon(UsersRecover.class.getResource("/img/bgRegister.png")));
		bgLabel.setBounds(0, 0, 720, 500);
		contentPane.add(bgLabel);

	}
}
