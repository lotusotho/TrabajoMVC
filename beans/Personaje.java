package beans;

public class Personaje {
    private int id;
    private String nombre;
    private String raza;
    private String faccion;
    private String titulo;
    private double vida;
    private int poderRunico;
    private double fuerza;
    private double estamina;

    public Personaje(int id, String nombre, String raza, String faccion, String titulo, double vida, int poderRunico,
            double fuerza, double estamina) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.faccion = faccion;
        this.titulo = titulo;
        this.vida = vida;
        this.poderRunico = poderRunico;
        this.fuerza = fuerza;
        this.estamina = estamina;
    }

    public int getId() {
        return id;
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

    public String getFaccion() {
        return faccion;
    }

    public void setFaccion(String faccion) {
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

    public double getEstamina() {
        return estamina;
    }

    public void setEstamina(double estamina) {
        this.estamina = estamina;
    }

    @Override
    public String toString() {
        return "Personaje [id=" + id + ", nombre=" + nombre + ", raza=" + raza + ", faccion=" + faccion + ", titulo="
                + titulo + ", vida=" + vida + ", poderRunico=" + poderRunico + ", fuerza=" + fuerza + ", estamina="
                + estamina + "]";
    }
}
