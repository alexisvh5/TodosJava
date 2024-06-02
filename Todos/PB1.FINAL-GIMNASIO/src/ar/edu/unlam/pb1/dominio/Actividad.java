package ar.edu.unlam.pb1.dominio;

public class Actividad {
	private static int siguienteId = 1;
	private int id;

	public Actividad(String nombre, int duracion, double caloriasQueQuema, TipoActividad tipoActividad) {
		this.id = siguienteId++;
	}
}
