package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

public class UsersRegister extends JFrame {


	private JPanel contentPane;
	private JTextField userTextField;
	private JTextField passTextField;

	public UsersRegister() {
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
				FunctionsHandler functionsHandler = new FunctionsHandler();
				functionsHandler.UserLoginPanel(true);
			}
		});
		btnBack.setBounds(20, 21, 89, 23);
		contentPane.add(btnBack);

		JPanel panelTitle = new JPanel();
		panelTitle.setBorder(UIManager.getBorder("ScrollPane.border"));
		panelTitle.setBounds(161, 36, 366, 35);
		contentPane.add(panelTitle);
		panelTitle.setLayout(null);

		JLabel lblRegistroDeUsuarios = new JLabel("Registro de usuarios:");
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
		panelFormUsers.setBounds(153, 120, 385, 208);
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
		userTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (userTextField.getText().toCharArray().length > 9) {
					e.consume();
				}
			}
		});
		userTextField.setColumns(10);
		userTextField.setBounds(195, 27, 143, 29);
		panelFormUsers.add(userTextField);

		passTextField = new JPasswordField();
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
			@Override
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler functionsHandler = new FunctionsHandler();
				functionsHandler.UsersRegister(userTextField.getText(), passTextField.getText(), adminCheckBox.isSelected());
			}
		});
		contentPane.add(btnRegistrar);

		passTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (passTextField.getText().toCharArray().length > 19) {
					e.consume();
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
					FunctionsHandler functionsHandler = new FunctionsHandler();
					functionsHandler.UsersRegister(userTextField.getText(), passTextField.getText(), adminCheckBox.isSelected());
				}
			}
		});

		JLabel bgLabel = new JLabel("");
		bgLabel.setIcon(new ImageIcon(UsersRegister.class.getResource("/img/bgRegister.png")));
		bgLabel.setBounds(0, 0, 720, 500);
		contentPane.add(bgLabel);

	}
}
