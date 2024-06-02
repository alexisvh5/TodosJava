package ar.edu.unlam.pb1.dominio;

public class Bot {
	private String nombre;
	private double saldo;
    private double cantidadCrypto;
	public Bot(String nombre, double saldo, double cantidadCrypto) {
		
		this.nombre=nombre;
		this.saldo=saldo;
		this.cantidadCrypto=cantidadCrypto;
		
	}

	public boolean puedeVender(double cantidadCrypto) {
		// Indica si el bot tiene la cantidad de crypto solicitada para la venta
		return false;
	}

	public boolean puedeComprar(double cantidadTransaccion, double valorCrypto) {
		// Indica si el saldo es suficiente para comprar la cantidad de crypto al valor
		// suministrado
		return false;
	}

	/////////// get y seters
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getCantidadCrypto() {
		return cantidadCrypto;
	}

	public void setCantidadCrypto(double cantidadCrypto) {
		this.cantidadCrypto = cantidadCrypto;
	}
	/////tooooooooooooooo

	@Override
	public String toString() {
		return "Bot [nombre=" + nombre + ", saldo=" + saldo + ", cantidadCrypto=" + cantidadCrypto + "]";
	}
	
	
	
}
