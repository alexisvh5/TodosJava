package ar.edu.unlam.pb1.dominio;

import ar.edu.unlam.pb1.dominio.enums.TipoDeVendible;

public class Tienda {
	private String codigo;
	private String razonSocial;
	private Vendible[] vendibles;
	private Venta[] ventas;

	public Tienda(String codigo, String razonSocial) {
		this.codigo = codigo;
		this.razonSocial = razonSocial;
		this.vendibles = new Vendible[Vendible.CANTIDAD_MAXIMA_PRODUCTOS];
		this.ventas = new Venta[10]; // maximo permitido en el main
		this.inicializarTienda(); // Esta linea debe ejecutarse en el constructor
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public Vendible[] buscarVendiblesCuyoCodigoIniciaConTexto(String textoABuscar) {
		// TODO: Se debera devolver un array de vendibles cuyo codigo comienza con el
		// texto indicado indicado para buscar.
		Vendible[] ArrayVendiblesPorCod = new Vendible[vendibles.length];
		int contador = 0;
		int i = 0;
		while (i < vendibles.length) {
			if (vendibles[i] != null && vendibles[i].getCodigo().equalsIgnoreCase(textoABuscar)) {
				ArrayVendiblesPorCod[contador] = vendibles[i];
			}
				contador++;
				i++;
		}

		return ArrayVendiblesPorCod;
	}

	public Vendible obtenerVendiblePorCodigo(String codigo) {
		// TODO: Se debera encontrar y devolver un vendible en el array de vendibles que
		// cumpla con el codigo suministrado. En caso de no encontrarlo, se debera
		// devolver null.
		Vendible vendibleEncontradoPorCod = null;
		int i = 0;
		while (i < vendibles.length) {
			if (vendibles[i] != null && vendibles[i].getCodigo().equalsIgnoreCase(codigo)) {
				vendibleEncontradoPorCod = vendibles[i];
				i = vendibles.length;
			} else {
				i++;
			}
		}

		return vendibleEncontradoPorCod;
	}

	public boolean crearVentaDeProductosOServicios(String cliente, String vendedor, Vendible[] vendiblesParaVenta) {
		// TODO: Se debera instanciar una venta utilizando los parametros y luego
		// agregar la misma al array de ventas.
		// El metodo debe devolver verdadero en caso de completar la operacion o falso
		// en caso de no lograrlo por alguna razon.
		boolean verdadero = false;
		Venta nuevaVenta = new Venta(cliente, vendedor, vendiblesParaVenta);
		int i = 0;
		while (i < ventas.length && !verdadero) {
			if (ventas[i] == null) {
				ventas[i] = nuevaVenta;
				verdadero = true;
			} 
				i++;
		}

		return verdadero;
	}

	public int obtenerCantidadDeServiciosEnVentas() { /////// chequeo
		// TODO: Se debera devolver la cantidad de servicios presentes en todas las
		// ventas.
		// Cada venta contiene los vendibles (PRODUCTO o SERVICIO) que se incluyeron en
		// la misma. De estos, nos interesa saber cuantos vendibles son de tipo
		// "SERVICIO". Es
		// importante mirar los vendibles en todas las ventas de la tienda.

		int contador = 0;
		int i = 0;
		while (i < ventas.length) {
			if (ventas[i] != null) {
				for (int j = 0; j < ventas[i].getVendibles().length; j++) {
					if (ventas[i].getVendibles()[j] != null
							&& ventas[i].getVendibles()[j].getTipoDeVendible() == TipoDeVendible.SERVICIO) {
						contador++;
					}
				}
			}
				i++;
		}

		return contador;

	}

	public Vendible[] obtenerProductosConStockMaximoOrdenadosPorPrecioDescendente() {
		// TODO: Armar y devolver un array de vendibles de tipo producto, cuyo stock sea
		// el maximo admitido por la tienda (Revisar la constante). El array a devolver
		// debera estar ordenado por precio de manera descendente (ver
		// ordenarVendiblesPorPrecioPrescendente()).
		Vendible[] vendiblesConStockMaxOrdenadosPorPrecioDesc = new Vendible[vendibles.length];

		int numero = 0;
		int i = 0;

		while (i < vendibles.length ) {
			if (vendibles[i] != null && vendibles[i].getTipoDeVendible() == TipoDeVendible.PRODUCTO
					&& vendibles[i].getStock() == Vendible.CANTIDAD_MAXIMA_PRODUCTOS) {
				vendiblesConStockMaxOrdenadosPorPrecioDesc[numero] = vendibles[i];

			}
			numero++;
			i++;

		}
		ordenarVendiblesPorPrecioPrescendente(vendiblesConStockMaxOrdenadosPorPrecioDesc);

		return vendiblesConStockMaxOrdenadosPorPrecioDesc;
	}

	private void ordenarVendiblesPorPrecioPrescendente(Vendible[] vendibles) {
		// TODO: Ordenar el array de vendibles suministrado por precio del vendible, de
		// manera descendente.
		Vendible aux = null;

		for (int i = 0; i < vendibles.length; i++) {
			for (int j = 0; j < vendibles.length - 1 - i; j++) {
				if (vendibles[j] != null && vendibles[j + 1] != null) {
					if (vendibles[j].getPrecio() < vendibles[j + 1].getPrecio()) {
						vendibles[j + 1] = aux;
						vendibles[j + 1] = vendibles[j];
						vendibles[j] = aux;
					}
				}
			}
		}

	}

	private void inicializarTienda() {
		// TODO: Se deberan generar los vendibles que estaran disponibles para que la
		// tienda pueda operar.
		// Es necesario asignar cada posicion del array de vendibles con una instancia
		// de vendible. En las posiciones pares, se debera colocar un vendible de tipo
		// PRODUCTO, mientras que en las posiciones impares, se debera colocar un
		// vendible de tipo SERVICIO.
		// El codigo de los vendibles debe ser la letra 'P' seguido de un numero para
		// los productos. Para los servicios, el codigo del vendible debe ser una letra
		// 'S' seguido de un numero.
		// El precio de los productos se debera generar considerando que no sean todos
		// iguales (nos sirve para ordenar). El precio de los servicios puede ser fijo.
		// Los servicios no tienen cantidad maxima, en este atributo se debera ingresar
		// un cero.
		// Ejemplos: codigos de productos: "P0", "P1", etc.
		// Ejemplos: codigos de servicios: "S0", "S1", etc.

		// Vendible(String codigo, TipoDeVendible tipoDeVendible, int stock, double
		// precio
		int contadorProd = 0;
		int contadorSer = 0;
		int i = 0;
		while (i < vendibles.length) {
			if (vendibles[i] == null && i % 2 == 0) {
				double precioRandom = (double) ((Math.random() * 100) + 1);
				// int stock=(int)(Math.random() * 10) + 1;
				vendibles[i] = new Vendible(("P" + contadorProd), TipoDeVendible.PRODUCTO,
						Vendible.CANTIDAD_MAXIMA_PRODUCTOS, precioRandom);
				contadorProd++;
			} else if (vendibles[i] == null && i % 2 != 0) {
				vendibles[i] = new Vendible(("S" + contadorSer), TipoDeVendible.SERVICIO, 0, 120.6);
				contadorSer++;
			} else {
				i++;
			}
		}

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Vendible[] getVendibles() {
		return vendibles;
	}

	public void setVendibles(Vendible[] vendibles) {
		this.vendibles = vendibles;
	}

	public Venta[] getVentas() {
		return ventas;
	}

	public void setVentas(Venta[] ventas) {
		this.ventas = ventas;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	// inicializar

//	int contadorProducto = 0;
//	int contadorServicio = 0;
//	
//	for (int i = 0; i < vendibles.length; i++) {
//		if (vendibles[i] == null && (i % 2 == 0)) {
//
//			Vendible vendibleDeTipoProducto = new Vendible(("P" + contadorProducto++), TipoDeVendible.PRODUCTO, 0,
//					(Math.random() * (15000 - 1000 + 1) + Vendible.CANTIDAD_MAXIMA_PRODUCTOS));
//			vendibles[i] = vendibleDeTipoProducto;
//		} else {
//			Vendible vendibleDeTipoServicio = new Vendible(("S" + contadorServicio++), TipoDeVendible.SERVICIO, 0,
//					8500.0);
//			vendibles[i] = vendibleDeTipoServicio;
//		}
//		crearVentaDeProductosOServicios("comprador", "vendedor", vendibles);
//	}

	// ordenar
//	Vendible aux = null;

//	for (int i = 0; i < vendibles.length; i++) {
//		for (int j = 0; j < vendibles.length - 1; j++) {
//			if (vendibles[i] != null && vendibles[i + 1] != null) {
//				if (vendibles[i].getPrecio() > vendibles[i + 1].getPrecio()) {
//					aux = vendibles[i];
//					vendibles[i] = vendibles[i + 1];
//					vendibles[i + 1] = aux;
//				}
//			}
//		}
//	}
// ordenar //		Vendible[] vendiblesProducto = new Vendible[vendibles.length];
	//
//	int contador = 0;
//	int stockMaximo = Vendible.CANTIDAD_MAXIMA_PRODUCTOS;
//	Vendible aux = null;
//	for (int i = 0; i < vendibles.length; i++) {
//		if (vendibles[i] != null && vendibles[i].getStock() == stockMaximo
//				&& vendibles[i].getTipoDeVendible().equals(TipoDeVendible.PRODUCTO)) {
//			vendiblesProducto[contador++] = vendibles[i];
//
//		}
//	}
//
//	ordenarVendiblesPorPrecioPrescendente(vendiblesProducto);
//	return vendiblesProducto;

	//// int cantidadDeServicios = 0;
	//
//	for (int i = 0; i < ventas.length; i++) {
//		Vendible[] vendibles = ventas[i].getVendibles();
//		for (int j = 0; j < vendibles.length; j++) {
//			if (ventas[i] != null && vendibles[j].getTipoDeVendible().equals(TipoDeVendible.SERVICIO)) {
//				cantidadDeServicios++;
//			}
//		}
//	}
//
//	return cantidadDeServicios;

//	
//	//obtener cant de servicios en venta 
//	boolean verdadero = false;
//	Venta nuevaVenta = new Venta(cliente, vendedor, vendiblesParaVenta);
//	for (int i = 0; i < ventas.length; i++) {
//		if (ventas[i] == null) {
//			ventas[i] = nuevaVenta;
//			verdadero = true;
//		}
//	}
//
//	return verdadero;

//	for (int i = 0; i < vendibles.length; i++) {
//		if (vendibles[i] != null && vendibles[i].getCodigo().equals(codigo)) {
//			return vendibles[i];
//		}
//
//	}
//
//	return null;

	// buscar vendible x cod
//	Vendible[] arrayEncontrados = new Vendible[vendibles.length];
//	int contador = 0;
//	for (int i = 0; i < vendibles.length; i++) {
//		if (vendibles[i] != null && vendibles[i].getCodigo().startsWith(textoABuscar)) {
//			arrayEncontrados[contador] = vendibles[i];
//			contador++;
//		}
//	}
//
//	return arrayEncontrados;
}
