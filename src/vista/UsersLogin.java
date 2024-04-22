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
 * Interfaz del logeo de usuarios. PAGINA DE INICIO
 */

public class UsersLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userTextField;
	private JTextField passTextField;
	private JPanel panelFormUsers;

	public UsersLogin() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		Image iconImg = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/wowIcon.png"));
		setIconImage(iconImg);

		setBounds(0, 0, 900, 506);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnUserRecover = new JButton("Contraseña Olvidada");
		btnUserRecover.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler.UsersRecoverPanel(true);
			}
		});
		btnUserRecover.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnUserRecover.setBounds(360, 402, 199, 42);
		contentPane.add(btnUserRecover);

		JLabel lblLoginTitle = new JLabel("Introduce tus datos:");
		lblLoginTitle.setForeground(Color.WHITE);
		lblLoginTitle.setBounds(315, 35, 292, 35);
		lblLoginTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblLoginTitle);
		lblLoginTitle.setFont(new Font("Verdana", Font.PLAIN, 28));

		panelFormUsers = new JPanel();
		panelFormUsers.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		panelFormUsers.setBounds(260, 94, 385, 164);
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

		passTextField = new JPasswordField();
		passTextField.setBounds(195, 97, 143, 29);
		panelFormUsers.add(passTextField);
		passTextField.setColumns(10);

		JButton btnUserLogin = new JButton("Entrar");
		btnUserLogin.setBounds(391, 278, 136, 42);
		btnUserLogin.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnUserLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler.UsersLogin(userTextField.getText(), passTextField.getText());
			}
		});
		contentPane.add(btnUserLogin);

		JButton btnUserRegister = new JButton("Registrarse");
		btnUserRegister.setBounds(391, 342, 136, 42);
		btnUserRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler.UserRegisterPanel(true);
			}
		});
		btnUserRegister.setFont(new Font("Verdana", Font.PLAIN, 17));
		contentPane.add(btnUserRegister);

		JLabel bgImage = new JLabel("");
		bgImage.setIcon(new ImageIcon(UsersLogin.class.getResource("/img/bgLogin.png")));
		bgImage.setBounds(0, 0, 900, 506);
		contentPane.add(bgImage);
	}
}
