package ar.edu.unlam.pb2.colecciones;

import java.util.Objects;

public class Vehiculo {

	private Integer id;
	private String nombre;
	public Vehiculo(Integer id, String nombre) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.nombre =nombre;
	}

	public Integer getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

	

}
