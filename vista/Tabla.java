package vista;

import java.awt.BorderLayout;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import beans.Personaje;

public class Tabla extends JFrame {
    private JPanel contentPane;
    private JTable table;

    public Tabla(ArrayList<Personaje> personajes) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        DefaultTableModel defTableModel = new DefaultTableModel();
        table = new JTable(defTableModel);
        contentPane.add(table, BorderLayout.CENTER);

        defTableModel.addColumn("ID");
        defTableModel.addColumn("Nombre");
        defTableModel.addColumn("Raza");
        defTableModel.addColumn("Facción");
        defTableModel.addColumn("Título");
        defTableModel.addColumn("Vida");
        defTableModel.addColumn("Poder Runico");
        defTableModel.addColumn("Fuerza");
        defTableModel.addColumn("Estamina");

        for(Personaje persI : personajes){
            Object[] fila = new Object[9];
            fila[0] = persI.getId();
            fila[1] = persI.getNombre();
            fila[2] = persI.getRaza();
            fila[3] = persI.isFaccion();
            fila[4] = persI.getTitulo();
            fila[5] = persI.getVida();
            fila[6] = persI.getPoderRunico();
            fila[7] = persI.getFuerza();
            fila[8] = persI.getEstamina();
            
            defTableModel.addRow(fila);
        };

        setVisible(true);
    }
}
