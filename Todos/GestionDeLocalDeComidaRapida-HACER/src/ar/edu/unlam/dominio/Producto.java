package ar.edu.unlam.dominio;

import ar.edu.unlam.interfaz.enums.ProductosDisponibles;

/****
 * 
 * @author Cátedra PBI
 * Se deben identificar los atributos necesarios y no modificar las firmas de los métodos.
 *
 */
public class Producto {
	private static int identificadorDeProd;
	private int codigo;
	private double precio;
	ProductosDisponibles tipoDeProducto;
	

	/****
	 * Constructor de la clase. El código se debe calcular automáticamente de manera incremental.
	 * @param precio
	 * @param productosDisponibles
	 */
	public Producto(double precio, ProductosDisponibles productosDisponibles) {
		this.codigo = identificadorDeProd++;
		this.precio = precio;
		this.tipoDeProducto=productosDisponibles;
	}

	public double getPrecio() {
		return this.precio;
	}
	
	public int getCodigo() {
		return this.codigo;
	}

	@Override
	public String toString() {
		return "\n Producto [codigo=" + codigo + ", precio=" + precio + ", tipoDeProducto=" + tipoDeProducto + "]\n";
	}
	
	
}
