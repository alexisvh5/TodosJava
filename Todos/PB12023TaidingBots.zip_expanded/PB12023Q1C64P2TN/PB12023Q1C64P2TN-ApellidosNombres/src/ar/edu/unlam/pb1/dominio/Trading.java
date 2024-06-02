package ar.edu.unlam.pb1.dominio;

public class Trading {

	public Trading(int cantidadBots, int cantidadTransacciones) {
	}

	public void agregarBot(Bot bot) {
		// Verificar que no exista el bot buscandolo por nombre con el metodo
		// buscarBotPorNombre()
		// En caso de no existir, entonces se debera agregar al array de bots
	}

	private Bot buscarBotPorNombre(String nombre) {
		// Dado el nombre que llega como parametro, se debera buscar en el array de bots
		// Si no existe, se devuelve null
		return null;
	}

	public void simularTransacciones() {

		// Genera transacciones con valores aleatorios. Se debe completar cada posicion
		// del array de transacciones

		// Debemos tener un bot vendedor y otro comprador obtenidos desde el array de
		// bots aleatoriamente, para poder transaccionar
		// El bot comprador no puede ser el mismo que el vendedor
		// La cantidad comprometida en la transaccion, debera ser aleatoria

		// Solo si el vendedor puede vender y el comprador, puede comprar, generaremos
		// transacciones.
		// Se debera generar un transaccion para registrar la venta y otra para
		// registrar la compra consumiento el metodo generarTransaccion()
	}

	private void generarTransaccion(TipoTransaccion tipoTransaccion, double cantidadTransaccion) {
		// Es necesario saber cual es el monto de la transaccion
		// Una vez instanciada la transaccion, es necesario agregarla al array de transacciones
	}

	private Bot obtenerBotAleatorio() {
		// Devuelve un bot seleccionado de manera aleatoria, del array de bots
		return null;
	}

	private double obtenerCantidadCryptoParaTransaccion() {
		// Devuelve un numero double aleatorio entre 1 y 5
		return 0;
	}

	public Bot[] obtenerBotsOrdenamosPorCryptoDescendiente() {
		// Ordena los bots de manera descendiente por la cantidad de crypto monedas que tiene
		return null;
	}

	public double obtenerPromedioDeTransaccionesDeVenta() {
		// Obtiene el promedio del monto de todas las transacciones que sean de venta
		return 0;
	}

}
