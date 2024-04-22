package modelo;

/**
 * Bean del usuario
 */

public class User {
	private String name;
	private String password;


	public User(int id, String name, String password) {
		this.name = name;
		this.password = password;
	}


	public String getNombre() {
		return name;
	}


	public void setNombre(String name) {
		this.name = name;
	}


	public String getContrasena() {
		return password;
	}


	public void setContrasena(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}
}
