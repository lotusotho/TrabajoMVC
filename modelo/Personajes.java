package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bbdd.Conexion;
import beans.Personaje;

public class Personajes {
    public void insertarPersonaje(Personaje personaje) {
        String nombre = personaje.getNombre();
        String raza = personaje.getRaza();
        String faccion = personaje.getFaccion();
        String titulo = personaje.getTitulo();
        double vida = personaje.getVida();
        int poderRunico = personaje.getPoderRunico();
        double fuerza = personaje.getFuerza();
        double estamina = personaje.getEstamina();

        Conexion.EjecutarSentencia("INSERT INTO personajes (nombre, raza, faccion, titulo, vida, poderRunico, fuerza, estamina) VALUES ('"+nombre+raza+faccion+titulo+vida+poderRunico+fuerza+estamina+"');");
    }

    public Personaje recogerPersonaje(String nombrePersonaje){
        ResultSet resultado = Conexion.EjecutarSentencia("SELECT * FROM personajes WHERE nombre='"+nombrePersonaje+"';");
        try {
            if (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String raza = resultado.getString("raza");
                String faccion = resultado.getString("faccion");
                String titulo = resultado.getString("titulo");
                double vida = resultado.getDouble("vida");
                int poderRunico = resultado.getInt("poderRunico");
                double fuerza = resultado.getDouble("fuerza");
                double estamina = resultado.getDouble("estamina");

                Personaje queryPersonaje = new Personaje(id, nombre, raza, faccion, titulo, vida, poderRunico, fuerza, estamina);
                return queryPersonaje;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Personaje> recogerTodosPersonajes(){
        ArrayList<Personaje> personajes = new ArrayList<Personaje>();
        ResultSet resultado = Conexion.EjecutarSentencia("SELECT * FROM personajes;");
        try {
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String raza = resultado.getString("raza");
                String faccion = resultado.getString("faccion");
                String titulo = resultado.getString("titulo");
                double vida = resultado.getDouble("vida");
                int poderRunico = resultado.getInt("poderRunico");
                double fuerza = resultado.getDouble("fuerza");
                double estamina = resultado.getDouble("estamina");

                personajes.add(new Personaje(id, nombre, raza, faccion, titulo, vida, poderRunico, fuerza, estamina));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return personajes;
    }

    public ArrayList<Personaje> recogerTodosPersonajesFaccion(String faccionQ){
        ArrayList<Personaje> personajes = new ArrayList<Personaje>();
        ResultSet resultado = Conexion.EjecutarSentencia("SELECT * FROM personajes WHERE faccion='"+faccionQ+"';");
        
        try {
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String raza = resultado.getString("raza");
                String faccion = resultado.getString("faccion");
                String titulo = resultado.getString("titulo");
                double vida = resultado.getDouble("vida");
                int poderRunico = resultado.getInt("poderRunico");
                double fuerza = resultado.getDouble("fuerza");
                double estamina = resultado.getDouble("estamina");

                personajes.add(new Personaje(id, nombre, raza, faccion, titulo, vida, poderRunico, fuerza, estamina));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return personajes;
    }
}
