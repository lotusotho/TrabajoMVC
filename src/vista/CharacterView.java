package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.FunctionsHandler;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

public class CharacterView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable charTable;
	private JScrollPane tableScrollPane;

	public CharacterView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tableScrollPane = new JScrollPane();
		tableScrollPane.setBounds(285, 104, 744, 500);
		contentPane.add(tableScrollPane);
		
		
		charTable = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Char Id", "User Id", "Nombre", "Raza", "Faccion", "Titulo", "Vida", "Poder Runico", "Fuerza", "Estamina"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableScrollPane.setViewportView(charTable);
		charTable.setBorder(UIManager.getBorder("CheckBox.border"));
		charTable.setForeground(new Color(0, 0, 0));
		
		JButton btnViewChars = new JButton("Ver Personajes");
		btnViewChars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler.ViewCharactersTable((DefaultTableModel)charTable.getModel());
			}
		});
		
		btnViewChars.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnViewChars.setBounds(1039, 109, 214, 61);
		contentPane.add(btnViewChars);
		
		JButton btnDelLastRow = new JButton("Borrar Ultimo Personaje");
		btnDelLastRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler.DeleteLastCharacter();
				
				// TODO: Pasar a FunctionsHandler
				if(charTable.getModel().getRowCount() > 0) {
					((DefaultTableModel)charTable.getModel()).removeRow(charTable.getModel().getRowCount() - 1);
				}
			}
		});
		btnDelLastRow.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnDelLastRow.setBounds(1039, 200, 214, 61);
		contentPane.add(btnDelLastRow);
		
		JLabel lblPanelDelUsuario = new JLabel("Vista de Personajes:");
		lblPanelDelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelDelUsuario.setForeground(Color.BLACK);
		lblPanelDelUsuario.setFont(new Font("Verdana", Font.PLAIN, 28));
		lblPanelDelUsuario.setBackground(Color.BLACK);
		lblPanelDelUsuario.setBounds(511, 43, 305, 35);
		contentPane.add(lblPanelDelUsuario);
		
		JButton btnGenerateCsv = new JButton("Generar CSV");
		btnGenerateCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler.CreateCSV();
			}
		});
		btnGenerateCsv.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnGenerateCsv.setBounds(1039, 292, 214, 61);
		contentPane.add(btnGenerateCsv);
	}
}
