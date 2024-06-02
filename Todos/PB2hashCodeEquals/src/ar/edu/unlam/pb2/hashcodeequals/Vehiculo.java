package ar.edu.unlam.pb2.hashcodeequals;

import java.util.Objects;

public class Vehiculo {
	private Integer identificador;
	private String nombre;

	public Vehiculo(Integer identificador, String nombre) {
		// TODO Auto-generated constructor stub
		
	}
//	
//	@Override
//	public int hashCode() {
//		return Objects.hash(identificador,nombre);
//	}
//	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// generado desde el source
	
	@Override
	public int hashCode() {
		return Objects.hash(identificador, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) // this represneta la direccion de memoria
			return true;
		
		if (obj == null) // si el objeto q le paso es null => false
			
			return false;
		if (getClass() != obj.getClass()) // compararcion de clases, no de objetos... clase auto y clase animal
			
			return false;
		
		
		Vehiculo other = (Vehiculo) obj; // a eso q vino de manera general-object..  considerala  como un vehiculo...casteo
		
		return Objects.equals(identificador, other.identificador) && Objects.equals(nombre, other.nombre); // despues de todo esto, puedo comparar
	}

	
	
}
