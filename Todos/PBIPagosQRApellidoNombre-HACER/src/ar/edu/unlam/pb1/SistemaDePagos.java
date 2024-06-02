package ar.edu.unlam.pb1;

import java.util.Arrays;

public class SistemaDePagos {

	/***
	 * Se deben agregar todos los atributos que se requieran.
	 */

	/***
	 * El constructor debe realizar todas las acciones necesarias para garantizar el
	 * correcto funcionamiento
	 * 
	 * @param nombre - Este es el nombre del sistema
	 */
	private String nombre;
	private Producto[] productos;
	private Venta[] ventas;
	private double importeTotal;

	public SistemaDePagos(String nombre) {
		this.nombre = nombre;
		this.productos = new Producto[20];
		this.ventas = new Venta[20];
		this.importeTotal=0.0;
	}

	/****
	 * Agrega una nuevo producto
	 * 
	 * @param nuevo Producto
	 * @return true si se pudo agregar o false en caso contrario
	 */
	public boolean agregarProducto(Producto nuevo) {
		int i = 0;
		boolean agregado = false;
		while (i < productos.length && !agregado) {
			if (productos[i] == null) {
				productos[i] = nuevo;
				agregado = true;
			}
			i++;
		}

		return agregado;
	}

	/****
	 * Agrega una nuevo producto
	 * 
	 * @param codigo del producto buscado
	 * @return true si se pudo agregar o false en caso contrario
	 */
	public Producto buscarProducto(int codigo) {
		
		int i=0;
		Producto prodBuscado=null;
		
		while (i<productos.length && prodBuscado==null) {
		if (productos[i]!=null && productos[i].getCodigo()==codigo) {
			prodBuscado=productos[i];
		}i++;
		}
		
		return prodBuscado;
	}

	/***
	 * Genera un nuevo c�digo QR para una nueva compra. El mismo se debe generar de
	 * manera aleatoria, pero no puede repetirse, es decir se debe verificar que no
	 * se haya generado para otra compra anterior. Su valor est� dado entre 1000 y
	 * el valor m�ximo que soporta el tipo de dato Long
	 * 
	 * @return nuevo c�digo QR
	 */
	public long generarNuevoCodigoQR() {
		boolean verdad = false;
		long nuevoCod = 0;

		do {

			for (int i = 0; i < ventas.length; i++) {
				nuevoCod = (long) (Math.random() * 1000) + 1;

				if (ventas[i] != null && ventas[i].getCodigoQR() == nuevoCod) {
					verdad = false;
					break;
				} else {
					verdad = true;
					break;
				}
			}
		} while (!verdad);

		return nuevoCod;
	}

	/****
	 * Agrega una nueva compra
	 * 
	 * @param nueva Compra
	 * @return true si se pudo agregar o false en caso contrario
	 */
	public boolean agregarVenta(Venta nueva) {
		
		for (int i = 0; i < ventas.length; i++) {
			if (ventas[i]==null) {
				ventas[i]=nueva;
				return true;
			}
		}
		
		return false;
	}

	/****
	 * Calcula el improte total de las ventas realizadas
	 * 
	 * @return importe total de las ventas realizadas
	 */
	public double calcularImporteTotal() {
		
		
		
		for (int i = 0; i < ventas.length; i++) {
			if (ventas[i]!=null) {
				this.importeTotal+= ventas[i].getImporteTotal();
			}
		}
		
		return this.importeTotal;
	}

	/****
	 * Calcula el improte promedio de las ventas realizadas
	 * 
	 * @return importe promedio de las ventas realizadas
	 */
	public double calcularImportePromedio() {
		
		int cantidadDeVentas=0;
		
		for (int i = 0; i < ventas.length; i++) {
			if (ventas[i]!=null) {
				cantidadDeVentas++;
			}
		}
		
		calcularImporteTotal();
		
		return this.importeTotal/cantidadDeVentas;
	}

	@Override
	public String toString() {
		return "SistemaDePagos [nombre=" + nombre + ", productos=" + Arrays.toString(productos) + ", ventas="
				+ Arrays.toString(ventas) + "]";
	}

	/****
	 * Devuelve en formato String un resumen de las ventas realizadas
	 * 
	 * @return Listado de las ventas realizadas
	 */

}
