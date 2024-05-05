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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.FunctionsHandler;

public class UsersView extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable charTable;
	private JScrollPane tableScrollPane;

	public UsersView() {
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		Image iconImg = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/wowIcon.png"));
		setIconImage(iconImg);

		setBounds(0, 0, 1280, 720);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tableScrollPane = new JScrollPane();
		tableScrollPane.setBounds(205, 104, 744, 500);
		contentPane.add(tableScrollPane);


		charTable = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Usuario", "Nombre", "Contraseña", "Es Admin"
			}
		));
		tableScrollPane.setViewportView(charTable);
		charTable.setBorder(UIManager.getBorder("CheckBox.border"));
		charTable.setForeground(new Color(0, 0, 0));

		JButton btnViewChars = new JButton("Ver Usuarios");
		btnViewChars.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler functionsHandler = new FunctionsHandler();
				functionsHandler.ViewUsersTable(charTable);
			}
		});

		btnViewChars.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnViewChars.setBounds(998, 104, 214, 61);
		contentPane.add(btnViewChars);

		JButton btnDelLastRow = new JButton("Borrar Último Usuario");
		btnDelLastRow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler functionsHandler = new FunctionsHandler();
				functionsHandler.DeleteLastUser(charTable);
			}
		});

		btnDelLastRow.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnDelLastRow.setBounds(998, 195, 214, 61);
		contentPane.add(btnDelLastRow);

		JPanel TitleJPanel = new JPanel();
		TitleJPanel.setBorder(UIManager.getBorder("InternalFrame.border"));
		TitleJPanel.setBounds(431, 43, 305, 35);
		contentPane.add(TitleJPanel);
		TitleJPanel.setLayout(null);

		JLabel lblPanelDelUsuario = new JLabel("Vista de Usuarios:");
		lblPanelDelUsuario.setBounds(0, 0, 305, 35);
		TitleJPanel.add(lblPanelDelUsuario);
		lblPanelDelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelDelUsuario.setForeground(Color.BLACK);
		lblPanelDelUsuario.setFont(new Font("Verdana", Font.PLAIN, 28));
		lblPanelDelUsuario.setBackground(Color.BLACK);

		JButton btnBack = new JButton("Volver");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler functionsHandler = new FunctionsHandler();
				functionsHandler.UsersControlPanel(true);
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);

		JLabel BGlbl = new JLabel("");
		BGlbl.setIcon(new ImageIcon(UsersView.class.getResource("/img/usersManagementBG.jpeg")));
		BGlbl.setBounds(0, 0, 1264, 681);
		contentPane.add(BGlbl);
	}
}
