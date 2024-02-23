package controlador;

import javax.swing.JOptionPane;

import beans.Personaje;
import modelo.Personajes;

public class Central {
    public void buscarPersonaje(String nombre){
        Personaje recogerPersonaje = new Personajes().recogerPersonaje(nombre);

        if(recogerPersonaje != null) {
            JOptionPane.showMessageDialog(null, "Tu personaje es: " + recogerPersonaje.getNombre());
        }
    }
}