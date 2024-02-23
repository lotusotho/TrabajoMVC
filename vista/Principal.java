package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {
    private JPanel contentPane;
    private JTextField inputNombre;
    private JTextField inputRaza;
    private JCheckBox inputFaccion;
    private JTextField inputTitulo;
    private JTextField inputVida;
    private JTextField inputPoderRunico;
    private JTextField inputFuerza;
    private JTextField inputEstamina;

    public Principal(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JButton boton1 = new JButton("Boton 1");
        boton1.setBounds(141, 145, 89, 20);
        panel.add(boton1);

        inputNombre = new JTextField();
        inputNombre.setBounds(195, 80, 86, 20);
        panel.add(inputNombre);
        inputNombre.setColumns(10);
        
        inputRaza = new JTextField();
        inputRaza.setBounds(195, 80, 86, 20);
        panel.add(inputRaza);
        inputRaza.setColumns(10);
    }
}
