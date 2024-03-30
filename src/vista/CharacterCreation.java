package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.FunctionsHandler;
import modelo.Hero;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Interfaz de la creacion de personajes
 */

public class CharacterCreation extends JFrame {

	private JPanel contentPane;
	private JTextField NameTextField;
	private JTextField RaceTextField;
	private JTextField FactionTextField;
	private JTextField TitleTextField;
	private JTextField LifeTextField;
	private JTextField RunicPTextField;
	private JTextField StrTextField;
	private JTextField StmTextField;
	
	public CharacterCreation() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Image iconImg = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/wowIcon.png"));
		setIconImage(iconImg);

		setBounds(0, 0, 1280, 720);
		
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 242, 243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
				
				JButton btnBack = new JButton("Volver");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FunctionsHandler.UsersControlPanel(true);
					}
				});
				btnBack.setBounds(10, 11, 89, 23);
				contentPane.add(btnBack);
		
				JButton btnCreateChar = new JButton("Crear Personaje");
				btnCreateChar.setFont(new Font("Tahoma", Font.PLAIN, 19));
				btnCreateChar.setBounds(542, 457, 187, 53);
				contentPane.add(btnCreateChar);
				btnCreateChar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Hero tempHero = new Hero(NameTextField.getText(), RaceTextField.getText(), 
								FactionTextField.getText(), TitleTextField.getText(), Double.parseDouble(LifeTextField.getText()), 
								Integer.parseInt(RunicPTextField.getText()), Double.parseDouble(StrTextField.getText()), Double.parseDouble(StmTextField.getText()));
						
						FunctionsHandler.InsertCharacter(tempHero);
					}
				});
		
		
		JPanel panelFormStamina = new JPanel();
		panelFormStamina.setLayout(null);
		panelFormStamina.setForeground((Color) null);
		panelFormStamina.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelFormStamina.setBounds(792, 338, 328, 46);
		contentPane.add(panelFormStamina);
		
		JLabel lblStamina = new JLabel("Estamina:");
		lblStamina.setHorizontalAlignment(SwingConstants.LEFT);
		lblStamina.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblStamina.setBounds(22, 11, 105, 24);
		panelFormStamina.add(lblStamina);
		
		StmTextField = new JTextField();
		StmTextField.setColumns(10);
		StmTextField.setBounds(157, 13, 143, 29);
		panelFormStamina.add(StmTextField);
		
		JPanel panelFormStrength = new JPanel();
		panelFormStrength.setLayout(null);
		panelFormStrength.setForeground((Color) null);
		panelFormStrength.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelFormStrength.setBounds(792, 252, 328, 46);
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
		panelFormRPower.setLayout(null);
		panelFormRPower.setForeground((Color) null);
		panelFormRPower.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelFormRPower.setBounds(792, 160, 328, 46);
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
		panelFormLife.setLayout(null);
		panelFormLife.setForeground((Color) null);
		panelFormLife.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelFormLife.setBounds(792, 68, 328, 46);
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
		panelFormTitle.setLayout(null);
		panelFormTitle.setForeground((Color) null);
		panelFormTitle.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelFormTitle.setBounds(118, 338, 328, 46);
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
		
		JPanel panelFormRace_1 = new JPanel();
		panelFormRace_1.setLayout(null);
		panelFormRace_1.setForeground((Color) null);
		panelFormRace_1.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelFormRace_1.setBounds(118, 252, 328, 46);
		contentPane.add(panelFormRace_1);
		
		JLabel lblFaccin = new JLabel("Facción:");
		lblFaccin.setHorizontalAlignment(SwingConstants.LEFT);
		lblFaccin.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblFaccin.setBounds(22, 11, 105, 24);
		panelFormRace_1.add(lblFaccin);
		
		FactionTextField = new JTextField();
		FactionTextField.setColumns(10);
		FactionTextField.setBounds(157, 13, 143, 29);
		panelFormRace_1.add(FactionTextField);
		
		JPanel panelFormRace = new JPanel();
		panelFormRace.setLayout(null);
		panelFormRace.setForeground((Color) null);
		panelFormRace.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelFormRace.setBounds(118, 160, 328, 46);
		contentPane.add(panelFormRace);
		
		JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setHorizontalAlignment(SwingConstants.LEFT);
		lblRaza.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblRaza.setBounds(22, 11, 105, 24);
		panelFormRace.add(lblRaza);
		
		RaceTextField = new JTextField();
		RaceTextField.setColumns(10);
		RaceTextField.setBounds(157, 13, 143, 29);
		panelFormRace.add(RaceTextField);
		
		JPanel panelFormName = new JPanel();
		panelFormName.setBounds(118, 68, 328, 46);
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
}
