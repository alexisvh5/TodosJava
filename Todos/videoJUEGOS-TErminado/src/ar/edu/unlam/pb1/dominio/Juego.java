package ar.edu.unlam.pb1.dominio;

public class Juego {
	private int id;
	private String nombre;
	private Categoria categoria;
	private double horasJugadas = 0;

	public Juego(int id, String nombre, Categoria categoria) {
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public double getHorasJugadas() {
		return horasJugadas;
	}

	public void setHorasJugadas(double horasJugadas) {
		this.horasJugadas += horasJugadas;
	}

	@Override
	public String toString() {
		return "Juego [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", horasJugadas=" + horasJugadas
				+ "]";
	}

	
	
	
}

