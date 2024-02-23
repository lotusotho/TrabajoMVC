package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Personaje;
import modelo.Personajes;

public class Central {
    public void buscarPersonaje(String nombre){
        Personaje recogerPersonaje = new Personajes().recogerPersonaje(nombre);

        if(recogerPersonaje != null) {
            JOptionPane.showMessageDialog(null, "Tu personaje es: " + recogerPersonaje.getNombre());
            new vista.VistaPersonaje(recogerPersonaje);
        } else {
            int opcion = JOptionPane.showConfirmDialog(null, "No se ha encontrado personaje. ¿Deseas crear uno?");

            if(opcion == 0){
                Personaje personaje = new Personaje(0, nombre, "orco", "horda", "El hombre default", 100.0, 10, 10.0, 10.0);

                new Personajes().insertarPersonaje(personaje);
            }
        }
    }

    public void verTodos() {
        ArrayList<Personaje> personajes = new modelo.Personajes().recogerTodosPersonajes();
        
        new vista.Tabla(personajes);
    }
    
    //TODO: CAMBIAR BUSQUEDA CUSTOM PARA QUE MIRE SI LE VIENEN INTS O DOUBLES
    public void busquedaCustom(String QValue, String QType){
        ArrayList<Personaje> personajes = new modelo.Personajes().recogerTodosPersonajesQuery(QType, QValue);

        new vista.Tabla(personajes);
    }
}