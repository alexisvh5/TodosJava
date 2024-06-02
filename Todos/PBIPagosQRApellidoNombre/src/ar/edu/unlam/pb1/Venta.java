package ar.edu.unlam.pb1;

public class Venta {

	/****
	 * Constructor de la clase
	 * @param eMail eMail del Ventador
	 * @param cuil del Ventador
	 * @param codigoQR de la Venta
	 * @param porcentajeDescuento Determina el porcentaje de descuento asociado a la Venta. Su valor está dado entre 0 y 1
	 */
	public Venta(String eMail, String cuil, long codigoQR, double porcentajeDescuento) {
		
	}
	
	/****
	 * Devuelve el código QR asociado a la Venta
	 * @return Devuelve el código QR asociado a la Venta
	 */
	public long getCodigoQR() {
		return 0;
	}

	/****
	 * Devuelve el E-Mail del Ventador
	 * @param eMail
	 */
	public String getEMailVentador() {
		return "";
	}

	/****
	 * Devuelve el CUIL del Ventador
	 * @param cuil
	 */
	public String getCuilVentador() {
		return ""; 
	}

	/****
	 * Agrega un nuevo producto a la Venta
	 * @param nuevo Producto
	 * @return true si se pudo agregar o false en caso contrario
	 */
	public boolean agregarProducto(Producto nuevo) {
		return false;
	}
	
	/****
	 * Calcula el importe total de la Venta, el cual está dado por la sumatoria de los importes de los productos incluidos, menos el porcentaje de descuento
	 * @return Devuelve el importe total de la Venta
	 */
	public double getImporteTotal() {
		return 0.00;
	}
	
	/****
	 * Devuelve información descripctiva de la Venta 
	 * @return String que describa el estado del objeto
	 */
	public String toString() {
		return "";
	}

}
