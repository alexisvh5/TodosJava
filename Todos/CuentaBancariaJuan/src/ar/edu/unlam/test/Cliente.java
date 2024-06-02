package ar.edu.unlam.test;

public class Cliente {
	
	private Integer dni;
	private String nombre;

	public Cliente(Integer dni, String nombre) {
		this.dni=dni;
		this.nombre=nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
