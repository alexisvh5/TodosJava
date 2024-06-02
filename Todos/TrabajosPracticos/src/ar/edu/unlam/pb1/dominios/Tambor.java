package ar.edu.unlam.pb1.dominios;

public class Tambor {
	
private final int POSICION_MINIMA; 
private final int POSICION_MAXIMA;
private int posicion;

public Tambor() {
this.POSICION_MINIMA = 1;
this.POSICION_MAXIMA = 8;
this.posicion = 0;
}
	public int getPosicion() {return this.posicion;};
	
	public void girar () {
		this.posicion =(int)( Math.random() * POSICION_MAXIMA)+POSICION_MINIMA; // random devuelve valores entre 0 y 0.99=> entre 0 y 7.9 en este caso => +  1 xq el int redondea a 7 
	};
}
