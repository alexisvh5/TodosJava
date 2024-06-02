package ar.edu.unlam.pb1.dominio;

public class Juego {
	// TODO: Completar la clase con lo necesario para garantizar el correcto funcionamiento
	private int id;
	private String nombre;
	private Categoria categoria;
	private double cantidadDeHorasJugadas;

	public Juego(int id, String nombre, Categoria categoria, double cantidadDeHorasJugadas) {
		
		this.id= id;
		this.nombre=nombre;
		this.categoria=categoria;
		this.cantidadDeHorasJugadas=cantidadDeHorasJugadas;
		
	}

	public Juego(int id2, String nombre2,Categoria categoria2) {
		// TODO Auto-generated constructor stub
		this.id= id2;
		this.nombre=nombre2;
		this.categoria=categoria2;
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

	public double getCantidadDeHorasJugadas() {
		return cantidadDeHorasJugadas;
	}

	public void setCantidadDeHorasJugadas(double cantidadDeHorasJugadas) {
		this.cantidadDeHorasJugadas += cantidadDeHorasJugadas;
	}

	@Override
	public String toString() {
		return "Juego [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", tiempoJugado="+this.cantidadDeHorasJugadas +"]";
	}
	

}
