package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controlador.FunctionsHandler;
import servicio.Hero;

/**
 * Interfaz de la creacion de personajes
 */

public class CharacterCreation extends JFrame {


	private JPanel contentPane;
	private JTextField NameTextField;
	private JTextField TitleTextField;
	private JTextField LifeTextField;
	private JTextField RunicPTextField;
	private JTextField StrTextField;
	private JTextField StmTextField;
	private JComboBox<String> factionComboBox = new JComboBox<>();
	private JComboBox<String> raceComboBox = new JComboBox<>();
	private JComboBox<String> classComboBox = new JComboBox<>();

	FunctionsHandler functionsHandler = new FunctionsHandler();

	public CharacterCreation() {
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		Image iconImg = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/wowIcon.png"));
		setIconImage(iconImg);

		setBounds(0, 0, 1280, 720);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);


		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 242, 243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnBack = new JButton("Volver");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				functionsHandler.UsersControlPanel(true);
			}
		});
		
		JPanel TitleJPanel = new JPanel();
		TitleJPanel.setBorder(UIManager.getBorder("InternalFrame.border"));
		TitleJPanel.setBounds(458, 35, 314, 74);
		contentPane.add(TitleJPanel);
		TitleJPanel.setLayout(null);
		
		JLabel lblCreaTuPersonaje = new JLabel("Crea Tu Personaje");
		lblCreaTuPersonaje.setBounds(0, 0, 314, 74);
		TitleJPanel.add(lblCreaTuPersonaje);
		lblCreaTuPersonaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreaTuPersonaje.setFont(new Font("Verdana", Font.PLAIN, 26));

		JPanel panelFormClass = new JPanel();
		panelFormClass.setBorder(UIManager.getBorder("InternalFrame.border"));
		panelFormClass.setLayout(null);
		panelFormClass.setForeground((Color) null);
		panelFormClass.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelFormClass.setBounds(119, 421, 328, 46);
		contentPane.add(panelFormClass);

		JLabel lblTtulo_1 = new JLabel("Clase:");
		lblTtulo_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTtulo_1.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblTtulo_1.setBounds(22, 11, 105, 24);
		panelFormClass.add(lblTtulo_1);

		classComboBox.setModel(new DefaultComboBoxModel(functionsHandler.GetFactions(3).toArray()));
		classComboBox.setMaximumRowCount(13);
		classComboBox.setBounds(155, 16, 146, 22);
		panelFormClass.add(classComboBox);
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);

		JButton btnCreateChar = new JButton("Crear Personaje");
		btnCreateChar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnCreateChar.setBounds(543, 540, 187, 53);
		contentPane.add(btnCreateChar);
		btnCreateChar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddCharacter();
			}
		});

		JPanel panelFormStamina = new JPanel();
		panelFormStamina.setBorder(UIManager.getBorder("InternalFrame.border"));
		panelFormStamina.setLayout(null);
		panelFormStamina.setForeground((Color) null);
		panelFormStamina.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelFormStamina.setBounds(793, 421, 328, 46);
		contentPane.add(panelFormStamina);

		JLabel lblStamina = new JLabel("Estamina:");
		lblStamina.setHorizontalAlignment(SwingConstants.LEFT);
		lblStamina.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblStamina.setBounds(22, 11, 105, 24);
		panelFormStamina.add(lblStamina);

		StmTextField = new JTextField();
		StmTextField.setColumns(10);
		StmTextField.setBounds(157, 13, 143, 29);
		
		StmTextField.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
					AddCharacter();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
		
		panelFormStamina.add(StmTextField);

		JPanel panelFormStrength = new JPanel();
		panelFormStrength.setBorder(UIManager.getBorder("InternalFrame.border"));
		panelFormStrength.setLayout(null);
		panelFormStrength.setForeground((Color) null);
		panelFormStrength.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelFormStrength.setBounds(793, 335, 328, 46);
		contentPane.add(panelFormStrength);

		JLabel lblFuerza = new JLabel("Fuerza:");
		lblFuerza.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuerza.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblFuerza.setBounds(22, 11, 105, 24);
		panelFormStrength.add(lblFuerza);

		StrTextField = new JTextField();
		StrTextField.setColumns(10);
		StrTextField.setBounds(157, 13, 143, 29);
		panelFormStrength.add(StrTextField);

		JPanel panelFormRPower = new JPanel();
		panelFormRPower.setBorder(UIManager.getBorder("InternalFrame.border"));
		panelFormRPower.setLayout(null);
		panelFormRPower.setForeground((Color) null);
		panelFormRPower.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelFormRPower.setBounds(793, 243, 328, 46);
		contentPane.add(panelFormRPower);

		JLabel lblPoderRnico = new JLabel("Poder Rúnico:");
		lblPoderRnico.setHorizontalAlignment(SwingConstants.LEFT);
		lblPoderRnico.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblPoderRnico.setBounds(22, 11, 105, 24);
		panelFormRPower.add(lblPoderRnico);

		RunicPTextField = new JTextField();
		RunicPTextField.setColumns(10);
		RunicPTextField.setBounds(157, 13, 143, 29);
		panelFormRPower.add(RunicPTextField);

		JPanel panelFormLife = new JPanel();
		panelFormLife.setBorder(UIManager.getBorder("InternalFrame.border"));
		panelFormLife.setLayout(null);
		panelFormLife.setForeground((Color) null);
		panelFormLife.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelFormLife.setBounds(793, 151, 328, 46);
		contentPane.add(panelFormLife);

		JLabel lblVida = new JLabel("Vida:");
		lblVida.setHorizontalAlignment(SwingConstants.LEFT);
		lblVida.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblVida.setBounds(22, 11, 105, 24);
		panelFormLife.add(lblVida);

		LifeTextField = new JTextField();
		LifeTextField.setColumns(10);
		LifeTextField.setBounds(157, 13, 143, 29);
		panelFormLife.add(LifeTextField);

		JPanel panelFormTitle = new JPanel();
		panelFormTitle.setBorder(UIManager.getBorder("InternalFrame.border"));
		panelFormTitle.setLayout(null);
		panelFormTitle.setForeground((Color) null);
		panelFormTitle.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelFormTitle.setBounds(119, 493, 328, 46);
		contentPane.add(panelFormTitle);

		JLabel lblTtulo = new JLabel("Título:");
		lblTtulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTtulo.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblTtulo.setBounds(22, 11, 105, 24);
		panelFormTitle.add(lblTtulo);

		TitleTextField = new JTextField();
		TitleTextField.setColumns(10);
		TitleTextField.setBounds(158, 11, 143, 29);
		panelFormTitle.add(TitleTextField);

		JPanel panelFormFaction = new JPanel();
		panelFormFaction.setBorder(UIManager.getBorder("InternalFrame.border"));
		panelFormFaction.setLayout(null);
		panelFormFaction.setForeground((Color) null);
		panelFormFaction.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelFormFaction.setBounds(119, 335, 328, 46);
		contentPane.add(panelFormFaction);

		JLabel lblFaction = new JLabel("Facción:");
		lblFaction.setHorizontalAlignment(SwingConstants.LEFT);
		lblFaction.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblFaction.setBounds(22, 11, 105, 24);
		panelFormFaction.add(lblFaction);

		factionComboBox.setModel(new DefaultComboBoxModel(functionsHandler.GetFactions(1).toArray()));
		factionComboBox.setMaximumRowCount(2);
		factionComboBox.setBounds(157, 11, 146, 22);
		panelFormFaction.add(factionComboBox);

		JPanel panelFormRace = new JPanel();
		panelFormRace.setBorder(UIManager.getBorder("InternalFrame.border"));
		panelFormRace.setLayout(null);
		panelFormRace.setForeground((Color) null);
		panelFormRace.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelFormRace.setBounds(119, 243, 328, 46);
		contentPane.add(panelFormRace);

		JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setHorizontalAlignment(SwingConstants.LEFT);
		lblRaza.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblRaza.setBounds(22, 11, 105, 24);
		panelFormRace.add(lblRaza);

		raceComboBox.setModel(new DefaultComboBoxModel(functionsHandler.GetFactions(2).toArray()));
		raceComboBox.setMaximumRowCount(14);
		raceComboBox.setBounds(160, 16, 146, 22);
		panelFormRace.add(raceComboBox);

		JPanel panelFormName = new JPanel();
		panelFormName.setBorder(UIManager.getBorder("InternalFrame.border"));
		panelFormName.setBounds(119, 151, 328, 46);
		panelFormName.setForeground((Color) null);
		panelFormName.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		contentPane.add(panelFormName);
		panelFormName.setLayout(null);

		JLabel lblUserTitle = new JLabel("Nombre:");
		lblUserTitle.setBounds(22, 11, 105, 24);
		lblUserTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserTitle.setFont(new Font("Verdana", Font.PLAIN, 19));
		panelFormName.add(lblUserTitle);

		NameTextField = new JTextField();
		NameTextField.setBounds(157, 13, 143, 29);
		NameTextField.setColumns(10);
		panelFormName.add(NameTextField);

		JLabel lblBG = new JLabel("");
		lblBG.setBounds(0, 0, 1280, 720);
		lblBG.setIcon(new ImageIcon(CharacterCreation.class.getResource("/img/bgCharSelection.png")));
		contentPane.add(lblBG);

		JLabel lblCreacinDePersonajes = new JLabel("Creación de personajes:");
		lblCreacinDePersonajes.setBounds(459, 35, 366, 35);
		lblCreacinDePersonajes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreacinDePersonajes.setForeground(Color.WHITE);
		lblCreacinDePersonajes.setFont(new Font("Verdana", Font.PLAIN, 28));
		lblCreacinDePersonajes.setBackground(Color.BLACK);
		contentPane.add(lblCreacinDePersonajes);
		
	}
	
	private void AddCharacter() {
		Hero tempHero = new Hero(NameTextField.getText(), raceComboBox.getSelectedIndex() + 1, factionComboBox.getSelectedIndex() == 1 ? true : false,
				classComboBox.getSelectedIndex() + 1, TitleTextField.getText(),
				BigDecimal.valueOf(Double.parseDouble(LifeTextField.getText())),
				Integer.parseInt(RunicPTextField.getText()),
				BigDecimal.valueOf(Double.parseDouble(StrTextField.getText())),
				BigDecimal.valueOf(Double.parseDouble(StmTextField.getText())));
		
		functionsHandler.InsertCharacter(tempHero);
		
		ArrayList<JTextField> allTextFields = new ArrayList<>();
		
		allTextFields.add(NameTextField);
		allTextFields.add(TitleTextField);
		allTextFields.add(LifeTextField);
		allTextFields.add(RunicPTextField);
		allTextFields.add(StrTextField);
		allTextFields.add(StmTextField);
		
		for (JTextField textField : allTextFields) {
			textField.setText("");
			factionComboBox.setSelectedIndex(0);
			raceComboBox.setSelectedIndex(0);
			classComboBox.setSelectedIndex(0);
		}
	}
}
