package main;

import java.awt.EventQueue;

import bbdd.Conexion;
import vista.Principal;

public class Main{
    public static void main(String[] args) {
        
        // Vista principal
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal frame = new Principal();
                    frame.setVisible(true);
                    //Conexion.Conectar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}