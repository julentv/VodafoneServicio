package pr.vodafone.dao.dto;

public class Cliente {
	private String dni;
	private String nombre;
	private String direccion;
	private String email;
	
	public Cliente(){
		super();
	}
	public Cliente(String dni, String nombre, String direccion, String email) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.email = email;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
