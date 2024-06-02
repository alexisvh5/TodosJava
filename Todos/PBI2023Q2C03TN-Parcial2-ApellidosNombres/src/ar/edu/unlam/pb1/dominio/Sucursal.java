package ar.edu.unlam.pb1.dominio;

import ar.edu.unlam.pb1.dominio.enums.TipoDeCeramica;

public class Sucursal {
	// TODO: Completar el constructor, getter, setters y método necesarios para
	// asegurar el correcto funcionamiento

	public static final int CANTIDAD_PEDIDOS = 20;

	private String nombre;
	private CajaDeCeramica[] ceramicasDisponibles;
	private Pedido[] pedidos;
	private double montoTotal;

	public Sucursal(String nombre) {
		this.nombre = nombre;
		this.agregarCeramicasDisponibles(); // Esta linea debe ejecutarse en el constructor
		this.cargarPedidos(); // Esta linea debe ejecutarse en el constructor
		this.montoTotal = 0;
	}

	public String getNombre() {
		return this.nombre;
	}

	public CajaDeCeramica buscarCajaDeCeramicaPorCodigo(String codigoCajaDeCeramica) {
		// TODO: Buscar y devolver la caja de ceramica que cumpla con el codigo
		// suministrado. Es necesario no discernir entre mayusculas y minusculas (el
		// usuario puede ingresar el codigo tanto con mayusculas como con minusculas).
		int i = 0;
		CajaDeCeramica cajaBuscada = null;

		while (i < this.ceramicasDisponibles.length && cajaBuscada == null) {
			if (ceramicasDisponibles[i] != null
					&& ceramicasDisponibles[i].getCodigo().equalsIgnoreCase(codigoCajaDeCeramica)) {
				cajaBuscada = ceramicasDisponibles[i];
			}
			i++;
		}

		return cajaBuscada;
	}

	public int calcularCantidadDeCajasDeCeramicaPorAreaDeCobertura(double areaACubrir, CajaDeCeramica cajaDeCeramica) {
		// TODO Calcular y devolver la cantidad de cajas necesarias para cubrir el area
		// especificada. Cada caja conoce el area de cobertura segun el tamanio de las
		// ceramicas. Necesitamos entonces dividir el area a cubrir, con el area de
		// cobertura de una caja, para conocer cuantas cajas se necesitan. En caso de
		// que la division contenga decimales, se debera redondear al siguiente numero
		// entero.

		double cantidadDeCajasNecesarias = 0;

		double areaDeCoberturaDeLaCaja = cajaDeCeramica.obtenerAreaDeCoberturaDeUnaCaja();

		cantidadDeCajasNecesarias = areaACubrir / areaDeCoberturaDeLaCaja;

		return (int) Math.round(cantidadDeCajasNecesarias);
	}

	public boolean agregarCajasDeCeramicaAPedido(int numeroPedido, CajaDeCeramica cajaDeCeramica, int cantidadCajas) {
		// TODO: Agregar al pedido la cantidad de cajas de ceramica especificada como
		// parametro. Cuando se agregan cajas de ceramica a un pedido, el mismo se debe
		// marcar como utilizado. Devuelve verdadero en caso de poder agregar todas las
		// cajas. Caso contrario, devuelve falso.

		int i = 0;
		Pedido pedido = null;

		while (i < this.pedidos.length && pedido == null) {
			if (pedidos[i] != null && pedidos[i].getNumero() == numeroPedido) {
				pedido = pedidos[i];
			}
			i++;
		}

		if (cantidadCajas <= pedido.getCantidadDeLugaresLibresParaCeramicas()) {
			for (int j = 0; j < cantidadCajas; j++) {
				pedido.agregarCajaDeCeramica(cajaDeCeramica);
			}
			pedido.setCantidadDeLugaresLibresParaCeramicas(
					(pedido.getCantidadDeLugaresLibresParaCeramicas()) - cantidadCajas);
			pedido.setUtilizado(true);
			
		
			return true;
		}

		return false;
	}

	public double obtenerMontoTotalDeLosPedidosUtilizados() {
		// TODO: Calcular y devolver el monto total de los pedidos utilizados.

//		for (int i = 0; i < pedidos.length; i++) {
//			if (pedidos[i] != null && pedidos[i].isUtilizado()) {
//				CajaDeCeramica[] cajasPorPedido = pedidos[i].getCeramicas();
//				
//				
//				for (int j = 0; j < cajasPorPedido.length; j++) {
//					
//					if (cajasPorPedido[j] != null && !(cajasPorPedido[j].isContado())) {
//						this.montoTotal+= cajasPorPedido[j].getPrecio();
//						cajasPorPedido[j].setContado(true);
//					}
//				}
//			}
//		}
//
//		return this.montoTotal;
//		
		for (int i = 0; i < pedidos.length; i++) {
			if (pedidos[i] != null && pedidos[i].isUtilizado()) {
				this.montoTotal= pedidos[i].calcularMontoTotal();};
			}
		return this.montoTotal;
	}

	public double obtenerPromedioDePrecioDeCajasDeCeramicaDeUnTipoDeCeramicaEnUnPedido(int numeroPedido,
			TipoDeCeramica tipoDeCeramica) {

		// TODO: Dado el numero de pedido y el tipo de ceramica, obtener el promedio de
		// precio de cajas de ceramica incluidas en dicho pedido que sean del tipo de
		// ceramica especificado. Si un pedido no fue utilizado, devolver cero.
		int i = 0;
		Pedido pedido = null;

		while (i < this.pedidos.length && pedido == null) {
			if (pedidos[i] != null && pedidos[i].getNumero() == numeroPedido) {
				pedido = pedidos[i];
			}
			i++;
		}
		double precioAc;
		
		if (pedido.isUtilizado()) {
			 precioAc= pedido.calcularCantDeCajasPorTipo(tipoDeCeramica);
		}
		else {
			precioAc=0.0;
		}
		
		
		return precioAc;
	}

	public CajaDeCeramica[] obtenerCeramicasDisponiblesOrdenadasPorTipoDeCeramicaAscendente() {
		// TODO: Ordenar el array de cajas existente por tipo de ceramica ascendente y
		// devolverlo.
		CajaDeCeramica aux = null;

		for (int i = 0; i < ceramicasDisponibles.length; i++) {
			for (int j = 0; j < ceramicasDisponibles.length - 1; j++) {
				if (ceramicasDisponibles[j] != null && ceramicasDisponibles[j + 1] != null) {
					if (ceramicasDisponibles[j].getTipoDeCeramica()
							.compareTo(ceramicasDisponibles[j + 1].getTipoDeCeramica()) < 0) {
						aux = ceramicasDisponibles[j + 1];
						ceramicasDisponibles[j + 1] = ceramicasDisponibles[j];
						ceramicasDisponibles[j] = aux;

					}
				}
			}
		}

		return ceramicasDisponibles;
	}

	private void cargarPedidos() {
		// Metodo necesario para usar el soft
		if (this.pedidos == null) {
			this.pedidos = new Pedido[CANTIDAD_PEDIDOS];
		}

		for (int i = 0; i < CANTIDAD_PEDIDOS; i++) {
			this.pedidos[i] = new Pedido();
		}
	}

	private void agregarCeramicasDisponibles() {
		// Metodo necesario para usar el soft
		if (this.ceramicasDisponibles == null) {
			this.ceramicasDisponibles = new CajaDeCeramica[5];
		}

		int posicion = 0;
		this.ceramicasDisponibles[posicion++] = new CajaDeCeramica("N" + (posicion - 1),
				("Ceramica: " + (posicion - 1)), 0.1, 0.1, 125.70, TipoDeCeramica.NORMAL, 100);
		this.ceramicasDisponibles[posicion++] = new CajaDeCeramica("AD" + (posicion - 1),
				("Ceramica: " + (posicion - 1)), 0.2, 0.2, 145.70, TipoDeCeramica.ANTI_DESLIZANTE, 35);
		this.ceramicasDisponibles[posicion++] = new CajaDeCeramica("AT" + (posicion - 1),
				("Ceramica: " + (posicion - 1)), 0.3, 0.3, 185.70, TipoDeCeramica.ALTO_TRANSITO, 25);
		this.ceramicasDisponibles[posicion++] = new CajaDeCeramica("AD" + (posicion - 1),
				("Ceramica: " + (posicion - 1)), 0.4, 0.4, 235.70, TipoDeCeramica.ANTI_DESLIZANTE, 10);
		this.ceramicasDisponibles[posicion++] = new CajaDeCeramica("N" + (posicion - 1),
				("Ceramica: " + (posicion - 1)), 50, 50, 500.70, TipoDeCeramica.NORMAL, 10);
	}

	//
	public Pedido getPedidoByNumPedido(int numeroPedido) {

		for (int i = 0; i < getPedidos().length; i++) {
			if (getPedidos()[i] != null && getPedidos()[i].getNumero() == numeroPedido) {
				return getPedidos()[i];
			}
		}
		return null;

	}

	//////
	public CajaDeCeramica[] getCeramicasDisponibles() {
		return ceramicasDisponibles;
	}

	public Pedido[] getPedidos() {
		return this.pedidos;
	}

}
