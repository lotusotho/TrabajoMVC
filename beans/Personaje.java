package beans;

import java.util.Arrays;

public class Personaje {
    private String nombre;
    private String raza;
    private boolean faccion;
    private String titulo;
    private double vida;
    private int poderRunico;
    private double fuerza;
    private double stamina;
    private int porCritico;
    private int porVelocidad;
    private int porMaestria;
    private int porVersatilidad;
    private String[] espC;

    public Personaje(String nombre, String raza, boolean faccion, String titulo, double vida, int poderRunico,
            double fuerza, double stamina, int porCritico, int porVelocidad, int porMaestria, int porVersatilidad,
            String[] espC) {
        this.nombre = nombre;
        this.raza = raza;
        this.faccion = faccion;
        this.titulo = titulo;
        this.vida = vida;
        this.poderRunico = poderRunico;
        this.fuerza = fuerza;
        this.stamina = stamina;
        this.porCritico = porCritico;
        this.porVelocidad = porVelocidad;
        this.porMaestria = porMaestria;
        this.porVersatilidad = porVersatilidad;
        this.espC = espC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public boolean isFaccion() {
        return faccion;
    }

    public void setFaccion(boolean faccion) {
        this.faccion = faccion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public int getPoderRunico() {
        return poderRunico;
    }

    public void setPoderRunico(int poderRunico) {
        this.poderRunico = poderRunico;
    }

    public double getFuerza() {
        return fuerza;
    }

    public void setFuerza(double fuerza) {
        this.fuerza = fuerza;
    }

    public double getStamina() {
        return stamina;
    }

    public void setStamina(double stamina) {
        this.stamina = stamina;
    }

    public int getPorCritico() {
        return porCritico;
    }

    public void setPorCritico(int porCritico) {
        this.porCritico = porCritico;
    }

    public int getPorVelocidad() {
        return porVelocidad;
    }

    public void setPorVelocidad(int porVelocidad) {
        this.porVelocidad = porVelocidad;
    }

    public int getPorMaestria() {
        return porMaestria;
    }

    public void setPorMaestria(int porMaestria) {
        this.porMaestria = porMaestria;
    }

    public int getPorVersatilidad() {
        return porVersatilidad;
    }

    public void setPorVersatilidad(int porVersatilidad) {
        this.porVersatilidad = porVersatilidad;
    }

    public String[] getEspC() {
        return espC;
    }

    public void setEspC(String[] espC) {
        this.espC = espC;
    }

    @Override
    public String toString() {
        return "Personaje [nombre=" + nombre + ", raza=" + raza + ", faccion=" + faccion + ", titulo=" + titulo
                + ", vida=" + vida + ", poderRunico=" + poderRunico + ", fuerza=" + fuerza + ", stamina=" + stamina
                + ", porCritico=" + porCritico + ", porVelocidad=" + porVelocidad + ", porMaestria=" + porMaestria
                + ", porVersatilidad=" + porVersatilidad + ", espC=" + Arrays.toString(espC) + "]";
    }
}
