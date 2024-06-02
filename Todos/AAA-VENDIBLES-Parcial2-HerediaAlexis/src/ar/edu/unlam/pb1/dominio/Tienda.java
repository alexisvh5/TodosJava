package ar.edu.unlam.pb1.dominio;

import java.util.Arrays;
import java.util.Iterator;

import ar.edu.unlam.pb1.dominio.enums.TipoDeVendible;

public class Tienda {

	private Vendible[] vendibles;
	private Venta[] ventas;
	private String razonSocial; 
	private String codigo;

	public Tienda(String codigo, String razonSocial) {
	
		this.vendibles = new Vendible[20];
		this.ventas= new Venta[20];
		this.razonSocial = razonSocial;
		this.codigo=codigo;
		this.inicializarTienda(); // Esta linea debe ejecutarse en el constructor
	}

	public String getRazonSocial() {
	
		return razonSocial;
	}

	public Vendible[] buscarVendiblesCuyoCodigoIniciaConTexto(String textoABuscar) {
		// TODO: Se debera devolver un array de vendibles cuyo codigo comienza con el
		// texto indicado indicado para buscar.
		
		Vendible[]vendiblesEncontrados = new Vendible[vendibles.length];
		int contadorNull = 0;
		for (int i = 0; i < vendibles.length; i++) {
			if ( this.vendibles[i].getCodigo().startsWith(textoABuscar) ) { // podria poner this.vendibles[i] != null && pero todo el array de vendibles ya fue inicializado
				vendiblesEncontrados[contadorNull++] = this.vendibles[i];
			}
		} return vendiblesEncontrados;
	
	}

	public Vendible[] getVendibles() {
		return vendibles;
	}

	public void setVendibles(Vendible[] vendibles) {
		this.vendibles = vendibles;
	}

	public Vendible obtenerVendiblePorCodigo(String codigo) {
		// TODO: Se debera encontrar y devolver un vendible en el array de vendibles que
		// cumpla con el codigo suministrado. En caso de no encontrarlo, se debera
		// devolver null.
		
//	
//		for (int i = 0; i < vendibles.length; i++) {
//			if (vendibles[i] != null && vendibles[i].getCodigo().equals(codigo)) {
//				return vendibles[i];
//			}
//		}
//		return null;
//		
		int posicion = 0 ;
		Vendible encontrado = null;
		
		/// todo esto es el while-- emplear cuando hay q buscar y cortar, no recorrer todo, siempre posicion y lo que se quiera encontrar
		while (encontrado ==null && posicion < this.vendibles.length) {
			
			if (vendibles[posicion] != null && vendibles[posicion].getCodigo().toUpperCase().equals(codigo)) {
				encontrado = vendibles[posicion];
		}
			posicion ++;
		}///
		return encontrado;
		
		}
	

	public boolean crearVentaDeProductosOServicios(String cliente, String vendedor, Vendible[] vendiblesParaVenta) {
		// TODO: Se debera instanciar una venta utilizando los parametros y luego
		// agregar la misma al array de ventas.
		// El metodo debe devolver verdadero en caso de completar la operacion o falso
		// en caso de no lograrlo por alguna razon.
		
		Venta venta = new Venta(cliente, vendedor, vendiblesParaVenta);
		for (int i = 0; i < ventas.length; i++) {
			if (ventas[i] == null) {
				ventas[i] = venta;
				return true;
			}
		}
		return false;
	}

	public int obtenerCantidadDeServiciosEnVentas() { //ENVENTASSSSSS!!!!!!!!! no son los mismos vendibles el de tienda y ventas
		// TODO: Se debera devolver la cantidad de servicios presentes en todas las
		// ventas.
		// Cada venta contiene los vendibles (PRODUCTO o SERVICIO) que se incluyeron en
		// la misma. De estos, nos interesa saber cuantos vendibles son de tipo
		// "SERVICIO". Es
		// importante mirar los vendibles en todas las ventas de la tienda.
		
		int cantidadDeServiciosPresentes=0;
		
		for (int i = 0; i < this.ventas.length; i++) {
			
			Vendible[]vendiblesDeVenta = this.ventas[i].getVendibles();
			
			for (int j = 0; j < vendiblesDeVenta.length; j++) {
				
				if(vendiblesDeVenta[j] != null && vendiblesDeVenta[j].getTipoDeVendible().equals(TipoDeVendible.SERVICIO)) {
				cantidadDeServiciosPresentes++;
			}
			
			}
		}
		
		return cantidadDeServiciosPresentes++;
	}

	
	public Vendible[] obtenerProductosConStockMaximoOrdenadosPorPrecioDescendente() {
		
		// TODO: Armar y devolver un array de vendibles de tipo producto, cuyo stock sea
		// el maximo admitido por la tienda (Revisar la constante). El array a devolver
		// debera estar ordenado por precio de manera descendente (ver
		// ordenarVendiblesPorPrecioPrescendente()).
		
		
		Vendible[] vendiblesProducto = new Vendible[vendibles.length];
		int contador = 0;
		int stockMaximo = Vendible.CANTIDAD_MAXIMA_PRODUCTOS;
		Vendible aux = null;
		for (int i = 0; i < vendibles.length; i++) {
			if (vendibles[i] != null && vendibles[i].getStock() == stockMaximo) {
				vendiblesProducto[contador++] = vendibles[i];	
			
			for (int e = 0; e < vendiblesProducto.length; e++) {
				for (int j = 0; j < vendiblesProducto.length - 1; j++) {
					if (vendiblesProducto[j] != null && vendiblesProducto[j].getPrecio() > vendiblesProducto[j + 1].getPrecio()) {
						aux = vendiblesProducto[j];
						vendiblesProducto[j] = vendiblesProducto[j + 1];
						vendiblesProducto[j + 1] = aux;
					   }
					}
				}
			}
		}return vendiblesProducto;
		
				}
	

	private void ordenarVendiblesPorPrecioPrescendente(Vendible[] vendibles) {
		// TODO: Ordenar el array de vendibles suministrado por precio del vendible, de
		// manera descendente.
		
		Vendible aux = null;

		for (int i = vendibles.length -1; i > 0; i--) {

			for (int j = 0; j < i; j++) {
				if (vendibles[j] != null && vendibles[j + 1] != null) {
				
					if(vendibles[j].getPrecio() > vendibles[j+1].getPrecio()) {
					aux = vendibles[j + 1];
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
		// Los servicios no tienen cantidad maxima, en este atributo se debera ingresar un cero.
		// Ejemplos: codigos de productos: "P0", "P1", etc.
		// Ejemplos: codigos de servicios: "S0", "S1", etc.
		
		
		
//		int contadorProducto = 0; /// PODria haber sido un contador para los dos
//		int contadorServicio = 0;
//		for (int i = 0; i < this.vendibles.length; i++) {
//			if (vendibles[i] == null && (i % 2 == 0)) {
//
//Vendible vendibleDeTipoProducto =new Vendible(("P" + contadorProducto++), TipoDeVendible.PRODUCTO, 0,(Math.random()*(15000 - 1000 + 1) + 1000));
//				vendibles[i] = vendibleDeTipoProducto;
//			} else {
//				Vendible vendibleDeTipoServicio = new Vendible(("S" + contadorServicio++), TipoDeVendible.SERVICIO, 0, 8500.0);
//				vendibles[i] = vendibleDeTipoServicio;
//			}
//		}
	
		for (int i = 0; i < vendibles.length; i++) {
			if( vendibles[i] !=null && i % 2 == 0 ) {
				vendibles[i] = new Vendible(("P"+i), TipoDeVendible.PRODUCTO, 10, (100*i)+3);
			}else 
			{vendibles[i] = new Vendible(("S"+i), TipoDeVendible.SERVICIO, 0, 1);};
		}
		
	}

}
