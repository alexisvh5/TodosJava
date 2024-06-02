package ar.edu.unlam.pb1.dominios;

public class Coche {

	private String marca;
	private String modelo;
	private int kilometros;
	private int  anio;
	private double precio;
	private String  patente;
	private int numeroDeCochera;
	
	private static int cantidadDeCoches;
	private final int CERO_KM;
	private final int ANIO_ACTUAL;
	private int cantidadUsados;
	private int cantidad0Km;
	

	public Coche(String marca, String modelo, int kilometros, int anio, double precio) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.kilometros = kilometros;
		this.anio = anio;
		this.precio = precio;
		this.ANIO_ACTUAL=2023;
		this.CERO_KM=0;
		
	}
	
	public Coche(String patente) {
		this.patente = patente;
		this.CERO_KM=0;
		this.ANIO_ACTUAL=2023;
		this.cantidadUsados=0;
		this.cantidad0Km=0;
		this.numeroDeCochera=-1;
	}
	public void setKilometros( int kilometros) {
		this.kilometros = kilometros;
	}
	public String getMarca() {
		return this.marca;
	}
	public String getModelo() {
		
		return this.modelo;
	}
	public double getPrecio() {
		return this.precio;
	}
	public  int getAnio() {
		return anio;
	}
	public void setPrecio(double precio) {
		this.precio= precio;
	}
	
	public int calcularAntiguedad(int anio) {
		int antiguedad =0;
		antiguedad= (2023 - getAnio());
		return antiguedad;
	}
	public int getCochera() {
		return this.numeroDeCochera;
	}
	public String getPatente() {
		return this.patente;
	}
	@Override
	public String toString() {
		return "Coche [marca="+ marca + ", modelo= "+modelo +"]";
	}
}
