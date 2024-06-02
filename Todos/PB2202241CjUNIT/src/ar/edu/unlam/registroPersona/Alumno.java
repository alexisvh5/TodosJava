package ar.edu.unlam.registroPersona;

public class Alumno {
	
	private String nombre;
	private String apellido;
	private Integer dni;
	private String email;
	
	public Alumno(String nombre, String apellido, Integer dni, String email) {

this.nombre=nombre;
this.apellido=apellido;
this.dni=dni;
this.email=email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
