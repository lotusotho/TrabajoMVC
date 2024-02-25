package beans;

public class Usuario {
	private int id;
	private String nombre;
	private String contrasena;
	private boolean rol;
	
	
	public Usuario(int id, String nombre, String contrasena, boolean rol) {
		this.id = id;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.rol = rol;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public boolean isRol() {
		return rol;
	}


	public void setRol(boolean rol) {
		this.rol = rol;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasena=" + contrasena + ", rol=" + rol + "]";
	}
}
