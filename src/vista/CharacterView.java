package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class CharacterView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable charTable;
	private JScrollPane tableScrollPane;

	public CharacterView() {
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
				"Char Id", "User Id", "Nombre", "Raza", "Faccion", "Titulo", "Vida", "Poder Runico", "Fuerza", "Estamina"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			@Override
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false
			};
			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableScrollPane.setViewportView(charTable);
		charTable.setBorder(UIManager.getBorder("CheckBox.border"));
		charTable.setForeground(new Color(0, 0, 0));

		JButton btnViewChars = new JButton("Ver Personajes");
		btnViewChars.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler.ViewCharactersTable(charTable);
			}
		});

		btnViewChars.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnViewChars.setBounds(998, 104, 214, 61);
		contentPane.add(btnViewChars);

		JButton btnDelLastRow = new JButton("Borrar Ultimo Personaje");
		btnDelLastRow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler.DeleteLastCharacter(charTable);
			}
		});

		btnDelLastRow.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnDelLastRow.setBounds(998, 195, 214, 61);
		contentPane.add(btnDelLastRow);

		JButton btnGenerateCsv = new JButton("Generar CSV");
		btnGenerateCsv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler.CreateCSV();
			}
		});
		btnGenerateCsv.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnGenerateCsv.setBounds(998, 287, 214, 61);
		contentPane.add(btnGenerateCsv);

		JButton btnPasteCSV = new JButton("Introducir CSV");
		btnPasteCSV.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler.ReadCSV();
			}
		});
		btnPasteCSV.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnPasteCSV.setBounds(998, 382, 214, 61);
		contentPane.add(btnPasteCSV);

		JLabel lblPanelDelUsuario = new JLabel("Vista de Personajes:");
		lblPanelDelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelDelUsuario.setForeground(Color.BLACK);
		lblPanelDelUsuario.setFont(new Font("Verdana", Font.PLAIN, 28));
		lblPanelDelUsuario.setBackground(Color.BLACK);
		lblPanelDelUsuario.setBounds(431, 43, 305, 35);
		contentPane.add(lblPanelDelUsuario);

		JButton btnBack = new JButton("Volver");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FunctionsHandler.UsersControlPanel(true);
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
	}
}
