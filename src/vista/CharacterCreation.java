package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CharacterCreation extends JFrame {

	private JPanel contentPane;
	
	public CharacterCreation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 242, 243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreacinDePersonajes = new JLabel("Creación de personajes:");
		lblCreacinDePersonajes.setBounds(458, 53, 366, 35);
		lblCreacinDePersonajes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreacinDePersonajes.setForeground(Color.BLACK);
		lblCreacinDePersonajes.setFont(new Font("Verdana", Font.PLAIN, 28));
		lblCreacinDePersonajes.setBackground(Color.BLACK);
		contentPane.add(lblCreacinDePersonajes);
	}
}
