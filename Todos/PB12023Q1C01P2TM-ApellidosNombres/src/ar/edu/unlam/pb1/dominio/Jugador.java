package ar.edu.unlam.pb1.dominio;

public class Jugador {
	private String nombre;
	private int id;
	private int puntaje;
	
	public Jugador(int id, String nombre) {
		this.nombre=nombre;
		this.id=id;
		this.puntaje=0;
	}
	public String getNombre() {
		return nombre;
	}
	public int getId() {
		return id;
	}
	
	public int getPuntaje() {
		return this.puntaje;
	}
	public void setPuntaje(int num) {
	this.puntaje += num;
	}
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", id=" + id + ", puntaje=" + puntaje + "]";
	}
	
	
}
