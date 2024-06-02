package ar.edu.unlam.pb1;

public class SistemaDePagos {

	/***
	 * Se deben agregar todos los atributos que se requieran.
	 */
	
	/***
	 * El constructor debe realizar todas las acciones necesarias para garantizar el correcto funcionamiento
	 * @param nombre - Este es el nombre del sistema
	 */
	public SistemaDePagos(String nombre) {
		
	}
	
	/****
	 * Agrega una nuevo producto
	 * @param nuevo Producto
	 * @return true si se pudo agregar o false en caso contrario
	 */
	public boolean agregarProducto(Producto nuevo) {
		return false;
	}
	
	/****
	 * Agrega una nuevo producto
	 * @param codigo del producto buscado
	 * @return true si se pudo agregar o false en caso contrario
	 */
	public Producto buscarProducto(int codigo) {
		return null;
	}
	
	/***
	 * Genera un nuevo código QR para una nueva compra. El mismo se debe generar de manera aleatoria, pero no puede repetirse, es decir se debe verificar que no se haya generado para otra compra anterior.
	 * Su valor está dado entre  1000 y el valor máximo que soporta el tipo de dato Long
	 * 
	 * @return nuevo código QR
	 */
	public long generarNuevoCodigoQR() {
		return 0;
	}
	
	/****
	 * Agrega una nueva compra
	 * @param nueva Compra
	 * @return true si se pudo agregar o false en caso contrario
	 */
	public boolean agregarVenta(Venta nueva) {
		return false;
	}

	/****
	 * Calcula el improte total de las ventas realizadas
	 * @return importe total de las ventas realizadas
	 */
	public double calcularImporteTotal() {
		return 0.0;
	}
	
	/****
	 * Calcula el improte promedio de las ventas realizadas
	 * @return importe promedio de las ventas realizadas
	 */
	public double calcularImportePromedio() {
		return 0.0;
	}
	
	/****
	 * Devuelve en formato String un resumen de las ventas realizadas 
	 * @return Listado de las ventas realizadas
	 */
	public String toString() {
		return "";
	}
}
