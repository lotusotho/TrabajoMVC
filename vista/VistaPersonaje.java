package vista;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beans.Personaje;

public class VistaPersonaje extends JFrame {
    private JPanel contentPane;

    public VistaPersonaje(Personaje personaje) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
       
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel labelNombre = new JLabel(personaje.getNombre());
        labelNombre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Tu nombre: " + personaje.getNombre());
            }
        });
        
        labelNombre.setBounds(168, 49, 142, 14);
        panel.add(labelNombre);

        JLabel labelRaza = new JLabel(personaje.getRaza());
        
        labelRaza.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Tu raza: " + personaje.getRaza());
            }
        });

        
        JLabel labelFaccion = new JLabel(personaje.getFaccion());

        labelFaccion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Tu facción: " + personaje.getFaccion());
            }
        });

        JLabel labelTitulo = new JLabel(personaje.getTitulo());

        labelTitulo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Tu título: " + personaje.getTitulo());
            }
        });

        setVisible(true);
    }
}
