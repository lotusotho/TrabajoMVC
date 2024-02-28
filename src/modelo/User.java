package modelo;

public class User {
	private int id;
	private String name;
	private String password;
	
	
	public User(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
		return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
}
