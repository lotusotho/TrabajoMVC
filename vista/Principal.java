package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Central;

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

    public Principal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JButton botonTodos = new JButton("Botón Todos");
        botonTodos.setBounds(325, 217, 89, 23);
        panel.add(botonTodos);

        JButton botonNombre = new JButton("Botón Nombre");
        botonNombre.setBounds(141, 145, 89, 20);
        panel.add(botonNombre);

        inputNombre = new JTextField();
        inputNombre.setBounds(195, 80, 86, 20);
        panel.add(inputNombre);
        inputNombre.setColumns(10);

        JButton botonRaza = new JButton("Botón Raza");
        botonRaza.setBounds(509, 289, 89, 26);
        panel.add(botonRaza);
        
        inputRaza = new JTextField();
        inputRaza.setBounds(195, 80, 86, 20);
        panel.add(inputRaza);
        inputRaza.setColumns(10);
        
        JCheckBox botonFaccion = new JCheckBox("Checkbox Facción");
        botonFaccion.setBounds(509, 289, 89, 26);
        panel.add(botonFaccion);

        
        inputFaccion = new JCheckBox();
        inputFaccion.setBounds(195, 80, 86, 20);
        panel.add(inputFaccion);
        inputFaccion.setEnabled(true);
        
        JButton botonTitulo = new JButton("Botón Título");
        botonTitulo.setBounds(509, 289, 89, 26);
        panel.add(botonTitulo);

        
        inputTitulo = new JTextField();
        inputTitulo.setBounds(195, 80, 86, 20);
        panel.add(inputTitulo);
        inputTitulo.setColumns(10);

        JButton botonVida = new JButton("Botón Vida");
        botonVida.setBounds(693, 473, 89, 29);
        panel.add(botonVida);
        
        inputVida = new JTextField();
        inputVida.setBounds(195, 80, 86, 20);
        panel.add(inputVida);
        inputVida.setColumns(10);
        
        JButton botonPRunico = new JButton("Botón Poder Rúnico");
        botonPRunico.setBounds(693, 473, 89, 29);
        panel.add(botonPRunico);
        
        inputPoderRunico = new JTextField();
        inputPoderRunico.setBounds(195, 80, 86, 20);
        panel.add(inputPoderRunico);
        inputPoderRunico.setColumns(10);

        JButton botonFuerza = new JButton("Botón Fuerza");
        botonFuerza.setBounds(693, 473, 89, 29);
        panel.add(botonFuerza);
        
        inputFuerza = new JTextField();
        inputFuerza.setBounds(195, 80, 86, 20);
        panel.add(inputFuerza);
        inputFuerza.setColumns(10);

        JButton botonEstamina = new JButton("Botón Estamina");
        botonEstamina.setBounds(693, 473, 89, 29);
        panel.add(botonEstamina);
        
        inputEstamina = new JTextField();
        inputEstamina.setBounds(195, 80, 86, 20);
        panel.add(inputEstamina);
        inputEstamina.setColumns(10);

        // LOGICA BOTONES
        //TODO: QUERYS QUE INVOLUCRA CENTRAL.JAVA
        botonNombre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = inputNombre.getText();
                new Central().buscarPersonaje(nombre);
            }
        });

        botonRaza.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String raza = inputRaza.getText();
                new Central().busquedaCustom(raza, "raza");
            }
        });

        
        botonFaccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(inputFaccion.isSelected()) {
                    new Central().busquedaCustom("Alianza", "faccion");
                } else {
                    new Central().busquedaCustom("Horda", "faccion");
                }
            }
        });
        
        botonTitulo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titulo = inputTitulo.getText();
                new Central().busquedaCustom(titulo, "titulo");
            }
        });
        
        botonVida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String vida = inputVida.getText();
                new Central().busquedaCustom(vida, "vida");
            }
        });

        botonPRunico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pRunico = inputPoderRunico.getText();
                new Central().busquedaCustom(pRunico, "poderRunico");
            }
        });

        botonFuerza.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fuerza = inputFuerza.getText();
                new Central().busquedaCustom(fuerza, "fuerza");
            }
        });
        
        botonTodos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Central().verTodos();
            }
        });
    }

}
