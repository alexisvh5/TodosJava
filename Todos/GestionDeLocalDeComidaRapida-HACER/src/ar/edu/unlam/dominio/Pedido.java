package ar.edu.unlam.dominio;

import java.util.Arrays;
import java.util.Iterator;

import ar.edu.unlam.interfaz.enums.ProductosDisponibles;

/****
 * 
 * @author Cátedra PBI Se deben identificar los atributos necesarios y no
 *         modificar las firmas de los métodos.
 *
 */
public class Pedido {

	/****
	 * Constructor de la clase.
	 */

	double monto;
	private Producto[] productos;
	private Cliente clienteAsociadoAlPedido;

	public Pedido() {
		this.productos = new Producto[10];
		this.clienteAsociadoAlPedido=null;
	}

	/****
	 * Retorna el cliente asociado a un pedido
	 * 
	 * @return cliente
	 */
	public Cliente getCliente() {
		return this.clienteAsociadoAlPedido;
	}

	/****
	 * Establece el cliente asociado a un pedido
	 * 
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.clienteAsociadoAlPedido = cliente;
	}

	/****
	 * Agregar un nuevo producto al pedido.
	 * 
	 * @param posicion del producto en la lista de productos asociados al pedido
	 * @param producto a agregar
	 */
	public void agregarProducto(int posicion, Producto producto) {

		this.productos[posicion]=producto;
		
	}

	/*****
	 * Devuelve la lista de productos que forman parte del pedido
	 * 
	 * @return
	 */
	public Producto[] getListaDeProductos() {
		return this.productos;
	}

	/****
	 * Obtiene el monto del pedido
	 * 
	 * @param monto
	 * @return
	 */
	public double getMonto(double monto) {
		return this.monto += monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Pedido [ " + Arrays.toString(productos) + ", clienteAsociadoAlPedido="
				+ clienteAsociadoAlPedido + "]";
	}
	

}
