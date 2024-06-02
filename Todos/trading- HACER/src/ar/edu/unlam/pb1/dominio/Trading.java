package ar.edu.unlam.pb1.dominio;

public class Trading {
	private Bot[]bots;
private Transaccion[] transacciones;
	
	public Trading(int cantidadBots, int cantidadTransacciones) {
		this.bots = new Bot[cantidadBots];
		this.transacciones = new Transaccion[cantidadTransacciones];
		
	}

	public void agregarBot(Bot bot) {
		// Verificar que no exista el bot buscandolo por nombre con el metodo
		// buscarBotPorNombre()
		// En caso de no existir, entonces se debera agregar al array de bots
	Bot buscado = buscarBotPorNombre(bot.getNombre());
	if (buscado==null) {
		for (int i = 0; i < bots.length; i++) {
			if (bots[i]==null) {
				bots[i] = buscado;
				break;
			}
		}
		
	}
		
	}

	private Bot buscarBotPorNombre(String nombre) {
		// Dado el nombre que llega como parametro, se debera buscar en el array de bots
		// Si no existe, se devuelve null
		Bot buscado=null;
		
	for (int i = 0; i < bots.length; i++) {
		if (bots[i]!=null && bots[i].getNombre().equalsIgnoreCase(nombre)) {
			return buscado=bots[i];
		}
	}
		
		return buscado;
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
		
		for (int i = 0; i < transacciones.length; i++) {
			if (transacciones[i]==null) {
				//TipoTransaccion tipoTransaccion, double cantidad, double montoç
				double cantRandom = (Math.random()*30)+2;
				double montoRandom =(Math.random()*5000)+2;
				transacciones[i]= new Transaccion(TipoTransaccion.values()[(int)((Math.random()*2)+1)],cantRandom,montoRandom);
			}
		}
		

		
	
		
	}

	private void generarTransaccion(TipoTransaccion tipoTransaccion, double cantidadTransaccion) {
		// Es necesario saber cual es el monto de la transaccion
		// Una vez instanciada la transaccion, es necesario agregarla al array de transacciones
	}

	private Bot obtenerBotAleatorio() {
		// Devuelve un bot seleccionado de manera aleatoria, del array de bots
		Bot botAleatorio=null;
		botAleatorio = bots[(int)((Math.random()*(this.bots.length)+1))];
		return botAleatorio;
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
