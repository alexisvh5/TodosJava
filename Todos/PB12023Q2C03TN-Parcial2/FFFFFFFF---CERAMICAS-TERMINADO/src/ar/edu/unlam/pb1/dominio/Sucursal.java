package ar.edu.unlam.pb1.dominio;

import ar.edu.unlam.pb1.dominio.enums.TipoDeCeramica;

public class Sucursal {
	// TODO: Completar el constructor, getter, setters y método necesarios para
	// asegurar el correcto funcionamiento

	public static final int CANTIDAD_PEDIDOS = 10000;
	private String nombre;
	private CajaDeCeramica[] ceramicasDisponibles;
	private Pedido[] pedidos;

	public Sucursal(String nombre) {
		this.ceramicasDisponibles = new CajaDeCeramica[15];
		this.agregarCeramicasDisponibles(); // Esta linea debe ejecutarse en el constructor
		this.cargarPedidos(); // Esta linea debe ejecutarse en el constructor
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public CajaDeCeramica buscarCajaDeCeramicaPorCodigo(String codigoCajaDeCeramica) {
		// TODO: Buscar y devolver la caja de ceramica que cumpla con el codigo
		// suministrado. Es necesario no discernir entre mayusculas y minusculas (el
		// usuario puede ingresar el codigo tanto con mayusculas como con minusculas).
		CajaDeCeramica cajaDeCeramicaAdevolver = null;

		for (int i = 0; i < ceramicasDisponibles.length; i++) {
			if (this.ceramicasDisponibles[i] != null
					&& this.ceramicasDisponibles[i].getCodigo().equals(codigoCajaDeCeramica) == true) {
				cajaDeCeramicaAdevolver = this.ceramicasDisponibles[i];
			}
		}
		return cajaDeCeramicaAdevolver;
	}

	public int calcularCantidadDeCajasDeCeramicaPorAreaDeCobertura(double areaACubrir, CajaDeCeramica cajaDeCeramica) {
		// TODO Calcular y devolver la cantidad de cajas necesarias para cubrir el area
		// especificada. Cada caja conoce el area de cobertura segun el tamanio de las
		// ceramicas. Necesitamos entonces dividir el area a cubrir, con el area de
		// cobertura de una caja, para conocer cuantas cajas se necesitan. En caso de
		// que la division contenga decimales, se debera redondear al siguiente numero
		// entero.
		return (int) Math.round(areaACubrir / cajaDeCeramica.obtenerAreaDeCoberturaDeUnaCaja());
	}

	public boolean agregarCajasDeCeramicaAPedido(int numeroPedido, CajaDeCeramica cajaDeCeramica, int cantidadCajas) {
		// TODO: Agregar al pedido la cantidad de cajas de ceramica especificada como
		// parametro. Cuando se agregan cajas de ceramica a un pedido, el mismo se debe
		// marcar como utilizado. Devuelve verdadero en caso de poder agregar todas las
		// cajas. Caso contrario, devuelve falso.
		boolean seAgrego = false;
		int cantidadDeCajasdeCeramicasAgregadas = 0;

		for (int i = 0; i < this.pedidos.length; i++) {
			if (this.pedidos[i] != null && this.pedidos[i].getNumero() == numeroPedido
					&& !this.pedidos[i].isUtilizado()) {
				for (int j = 0; j < this.pedidos[i].getCeramicas().length; j++) {
					if (this.pedidos[i].getCeramicas()[j] == null
							&& cantidadDeCajasdeCeramicasAgregadas < cantidadCajas) {
						this.pedidos[i].getCeramicas()[j] = cajaDeCeramica; // De Esta forma no se si tengo que utilizar
																			// el metodo de la clase Pedido,
																			// agregarCajaDeCeramica o no.
						this.pedidos[i].setUtilizado(true);
						cantidadDeCajasdeCeramicasAgregadas++;
					}
				}
			}
		}

		if (cantidadDeCajasdeCeramicasAgregadas == cantidadCajas) {
			seAgrego = true;
		}

		return seAgrego;
	}

	public double obtenerMontoTotalDeLosPedidosUtilizados() {
		// TODO: Calcular y devolver el monto total de los pedidos utilizados.
		double montoTotalDeLosPedidosUtilizados = 0.0;

		for (int i = 0; i < this.pedidos.length; i++) {
			if (this.pedidos[i] != null && this.pedidos[i].isUtilizado()) {
				montoTotalDeLosPedidosUtilizados += this.pedidos[i].calcularMontoTotalDelPedido();
			}
		}

		return montoTotalDeLosPedidosUtilizados;
	}

	public double obtenerPromedioDePrecioDeCajasDeCeramicaDeUnTipoDeCeramicaEnUnPedido(int numeroPedido,
			TipoDeCeramica tipoDeCeramica) {
		// TODO: Dado el numero de pedido y el tipo de ceramica, obtener el promedio de
		// precio de cajas de ceramica incluidas en dicho pedido que sean del tipo de
		// ceramica especificado. Si un pedido no fue utilizado, devolver cero.
		double promedioDePrecio = 0.0;
		double precioTotal = 0.0;
		int cantidadDeCajasDeCeramicaDeUnTipo = 0;

		for (int i = 0; i < this.pedidos.length; i++) {
			for (int j = 0; j < this.pedidos[i].getCeramicas().length; j++) {
				if (this.pedidos[i].getCeramicas()[j] != null
						&& this.pedidos[i].getCeramicas()[j].getTipoDeSeramica().equals(tipoDeCeramica)) {
					precioTotal += this.pedidos[i].getCeramicas()[j].getPrecio();
					cantidadDeCajasDeCeramicaDeUnTipo++;
				}

			}
		}

		promedioDePrecio = precioTotal / cantidadDeCajasDeCeramicaDeUnTipo;

		return promedioDePrecio;
	}

	public CajaDeCeramica[] obtenerCeramicasDisponiblesOrdenadasPorTipoDeCeramicaAscendente() {
		// TODO: Ordenar el array de cajas existente por tipo de ceramica ascendente y
		// devolverlo.
		CajaDeCeramica auxiliar = null;

		for (int i = 1; i < ceramicasDisponibles.length; i++) {
			for (int j = 0; j < ceramicasDisponibles.length - 1; j++) {
				if (this.ceramicasDisponibles[j + 1] != null && this.ceramicasDisponibles[j] != null) {
					if (this.ceramicasDisponibles[j + 1].getTipoDeSeramica()
							.compareTo(this.ceramicasDisponibles[j].getTipoDeSeramica()) > 0) {
						auxiliar = this.ceramicasDisponibles[j + 1];
						this.ceramicasDisponibles[j + 1] = this.ceramicasDisponibles[j];
						this.ceramicasDisponibles[j] = auxiliar;
					}
				}
			}
		}
		return this.ceramicasDisponibles;
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

	public boolean elPedidoYafueUtilizado(int numeroDePedido) {
		boolean yaSeUtilizo = false;
		
		for (int i = 0; i < this.pedidos.length; i++) {
			if (this.pedidos[i] != null && this.pedidos[i].getNumero() == numeroDePedido && this.pedidos[i].isUtilizado()) {
				yaSeUtilizo = true;
			}	
		}
		return yaSeUtilizo;
	}
}
