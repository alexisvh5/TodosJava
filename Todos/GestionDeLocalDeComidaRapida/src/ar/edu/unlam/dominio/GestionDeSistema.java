package ar.edu.unlam.dominio;

import ar.edu.unlam.dominio.enums.OpcionesDePago;
import ar.edu.unlam.interfaz.enums.ProductosDisponibles;

/****
 * 
 * @author Cátedra PBI
 * Se deben identificar los atributos necesarios y no modificar las firmas de los métodos.
 *
 */
public class GestionDeSistema {

	public static int CANTIDAD_DE_PRODUCTOS = 10;
	private static int identificadorDeGestion;
	int numeroDeGestion;
	private Producto[] catalogoDeproductos, productos;
	private Pedido pedido;

	/****
	 * Constructor de la clase. Se deben generar las condiciones para el correcto funcionamiento de los objetos de este tipo. Tener en cuenta que se tienen habilitarProductosDisponiblesDelDia a partir del precio máximo y precio mínimo definido.
	 * @param maximo precio máximo definido para los productos a comercializar en el día 
	 * @param minimo precio mínimo definido para los productos a comercializar en el día
	 */
	public GestionDeSistema(double maximo, double minimo) {

		this.numeroDeGestion = identificadorDeGestion++;
		this.catalogoDeproductos = new Producto[CANTIDAD_DE_PRODUCTOS];
		this.productos = new Producto[CANTIDAD_DE_PRODUCTOS];
		this.pedido = new Pedido();
		this.habilitarProductosDisponiblesDelDia(maximo, minimo);
	}

	/****
	 * A partir de los ProductosDisponibles, se debe generar el catalogoDeProductos. El precio de cada producto se debe calcular de manera aleatoria tomando como parámetros los precios máximos y mínimos recibidos por parámetro.
	 * @param maximo precio máximo definido para los productos a comercializar en el día 
	 * @param minimo precio mínimo definido para los productos a comercializar en el día
	 */
	public void habilitarProductosDisponiblesDelDia(double maximo, double minimo) {

	}

	/****
	 * Devuelve la lista de productos
	 * @return productos
	 */
	public Producto[] getProductos() {
		return null;
	}

	/****
	 * Devvuelve el catálogo de productos ordenados por precio de menor a mayor.
	 * @return catalogoDeProductosOrdenados
	 */
	public Producto[] ObtenerProductosDisponiblesDelDiaOrdenadosPorPrecio() {

		Producto[] catalogoDeProductosOrdenados = null;

		return catalogoDeProductosOrdenados;
	}

	/****
	 * Agrega un nuevo producto
	 * @param nuevo producto a agregar
	 * @return true si se pudo agregar, false, en caso contrario
	 */
	public boolean agregarProducto(Producto nuevo) {

		boolean agregado = false;
		return agregado;
	}

	/***
	 * Busca un producto en el catlálogo de productos.
	 * @param codigo del producto a buscar
	 * @return el producto buscado o null si no lo encuentra
	 */
	public Producto buscarProductoAAgregar(int codigo) {

		Producto producto = null;

		return producto;
	}

	/****
	 * Verifica que el EMail del cliente sea valido. Para eso el EMail debe tener el caractare '@' y debe finalizar en '.com' o en '.org' o en 'ar'
	 * @param email a validar
	 * @return true si el eMail es válido. False en caso contrario
	 */
	public boolean validarEmailDeCliente(String email) {

		boolean esValido = false;
		return esValido;
	}

	/****
	 * Agrega un conjunto de productos al pedido.
	 * @param cliente asociado al pedido
	 * @param productos el conjunto de productos que se deben agregar al pedido
	 * @return el pedido generado
	 */
	public Pedido generarPedido(Cliente cliente, Producto[] productos) {

		return null;
	}

	/****
	 * Calcula el monto del pedido y retorna su valor
	 * @return el monto del pedido
	 */
	public double cobrarPedido() {

		return 0.0;
	}

	/****
	 * Calcula el descuento en función de la opción de pago:
	 * MERCADO_PAGO tiene un 15% de descuento
	 * TARJETA_DE_DEBITO tiene un 20% de descuento
	 * TARJETA_DE_CREDITO tiene un 25% de descuento
	 * @param opcion
	 * @param montoSinDescuento
	 * @return el monto a cobrar (con el descuento aplicado)
	 */
	public double aplicarDescuento(OpcionesDePago opcion, Double montoSinDescuento) {

		return 0.0;
	}

}
