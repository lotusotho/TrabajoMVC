package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CharacterView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable charTable;

	public CharacterView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		charTable = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"char_id", "user_id", "Nombre", "Raza", "Faccion", "Titulo", "Vida", "Poder Runico", "Fuerza", "Estamina"
			}
		));
		charTable.setBounds(224, 95, 822, 444);
		contentPane.add(charTable);
		
		JLabel lblPanelDelUsuario = new JLabel("Vista de Personajes:");
		lblPanelDelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelDelUsuario.setForeground(Color.BLACK);
		lblPanelDelUsuario.setFont(new Font("Verdana", Font.PLAIN, 28));
		lblPanelDelUsuario.setBackground(Color.BLACK);
		lblPanelDelUsuario.setBounds(472, 31, 305, 35);
		contentPane.add(lblPanelDelUsuario);
		
		JButton btnViewChars = new JButton("Ver Personajes");
		btnViewChars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Implement method
			}
		});
		btnViewChars.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnViewChars.setBounds(507, 570, 236, 80);
		contentPane.add(btnViewChars);
		
		// TODO: Anadir personajes a la tabla conectando con FunctionsHandler
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn(model);
	}
}
