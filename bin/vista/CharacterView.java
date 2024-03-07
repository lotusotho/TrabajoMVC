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
		
		JLabel lblPanelDelUsuario = new JLabel("Vista de Personajes:");
		lblPanelDelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelDelUsuario.setForeground(Color.BLACK);
		lblPanelDelUsuario.setFont(new Font("Verdana", Font.PLAIN, 28));
		lblPanelDelUsuario.setBackground(Color.BLACK);
		lblPanelDelUsuario.setBounds(472, 31, 305, 35);
		contentPane.add(lblPanelDelUsuario);
		
		// TODO: Anadir personajes a la tabla conectando con FunctionsHandler
		DefaultTableModel model = new DefaultTableModel();
		charTable = new JTable(model);
		charTable.setBounds(288, 95, 700, 500);
		contentPane.add(charTable);
		
		model.addColumn(model);
	}
}
