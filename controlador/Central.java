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

    //TODO: QUERYS QUE INVOLUCRA PRINCIPAL.JAVA
    public void verTodos() {
        ArrayList<Personaje> personajes = new modelo.Personajes().recogerTodosPersonajes();

        new vista.Tabla(personajes);
    }

    public void setRaza(String raza){
        ArrayList<Personaje> personajes = new modelo.Personajes().recogerTodosPersonajesQuery("raza", raza);

        new vista.Tabla(personajes);
    }
    
    public void setTitulo(String titulo){
        ArrayList<Personaje> personajes = new modelo.Personajes().recogerTodosPersonajesQuery("titulo", titulo);

        new vista.Tabla(personajes);
    }

    public void setVida(String vida){
        ArrayList<Personaje> personajes = new modelo.Personajes().recogerTodosPersonajesQuery("vida", vida);

        new vista.Tabla(personajes);
    }

    public void setFaccion(String faccion){
        ArrayList<Personaje> personajes = new modelo.Personajes().recogerTodosPersonajesQuery("faccion", faccion);

        new vista.Tabla(personajes);
    }

}