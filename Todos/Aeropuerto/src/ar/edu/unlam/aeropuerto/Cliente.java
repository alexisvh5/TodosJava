package ar.edu.unlam.aeropuerto;

import java.util.Objects;

public class Cliente implements Comparable<Cliente> {
	private String nombre;
	private String apellido;
	private Integer dni;
	

	public Cliente(String nombre, String apellido, Integer dni) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDni(dni);
		
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


	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}


	@Override
	public int compareTo(Cliente otroCliente) {
		// TODO Auto-generated method stub
		return this.nombre.compareTo(otroCliente.getNombre());
	}
	
	
	
	

}
