package ar.edu.unlam.pb1.dominio;

public class Bot {

	public Bot(String nombre, double saldo, double cantidadCrypto) {
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
}
