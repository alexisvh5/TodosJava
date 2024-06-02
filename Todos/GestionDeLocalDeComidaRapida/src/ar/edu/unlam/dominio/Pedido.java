package ar.edu.unlam.dominio;

import java.util.Arrays;

import ar.edu.unlam.interfaz.enums.ProductosDisponibles;

/****
 * 
 * @author Cátedra PBI
 * Se deben identificar los atributos necesarios y no modificar las firmas de los métodos.
 *
 */
public class Pedido {
	
	/****
	 * Constructor de la clase. 
	 */

	double monto;
	public Pedido() {

	}

	/****
	 * Retorna el cliente asociado a un pedido
	 * @return cliente
	 */
	public Cliente getCliente() {
		return null;
	}

	/****
	 * Establece el cliente asociado a un pedido
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
	
	}

	/****
	 * Agregar un nuevo producto al pedido.
	 * @param posicion del producto en la lista de productos asociados al pedido
	 * @param producto a agregar
	 */
	public void agregarProducto(int posicion, Producto producto) {
		
	}

	/*****
	 * Devuelve la lista de productos que forman parte del pedido
	 * @return
	 */
	public Producto[] getListaDeProductos() {
		return null;
	}

	/****
	 * Obtiene el monto del pedido
	 * @param monto
	 * @return
	 */
	public double getMonto(double monto) {
		return this.monto += monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}



}
