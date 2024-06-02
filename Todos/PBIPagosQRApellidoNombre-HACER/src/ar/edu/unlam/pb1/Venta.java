package ar.edu.unlam.pb1;

import java.util.Arrays;

public class Venta {

	/****
	 * Constructor de la clase
	 * @param eMail eMail del Ventador
	 * @param cuil del Ventador
	 * @param codigoQR de la Venta
	 * @param porcentajeDescuento Determina el porcentaje de descuento asociado a la Venta. Su valor est� dado entre 0 y 1
	 */
	private String eMail;
	private String cuil;
	private long codigoQR;
	private double porcentajeDescuento;
	private Producto[]productosParaLaVenta;
	
	public Venta(String eMail, String cuil, long codigoQR, double porcentajeDescuento) {
		this.eMail=eMail;
		this.cuil=cuil;
		this.codigoQR=codigoQR;
		this.porcentajeDescuento =porcentajeDescuento;
		this.productosParaLaVenta=new Producto[20];
	}
	
	/****
	 * Devuelve el c�digo QR asociado a la Venta
	 * @return Devuelve el c�digo QR asociado a la Venta
	 */
	public long getCodigoQR() {
		return this.codigoQR;
	}

	/****
	 * Devuelve el E-Mail del Ventador
	 * @param eMail
	 */
	public String getEMailVentador() {
		return this.eMail;
	}

	/****
	 * Devuelve el CUIL del Ventador
	 * @param cuil
	 */
	public String getCuilVentador() {
		return this.cuil; 
	}

	/****
	 * Agrega un nuevo producto a la Venta
	 * @param nuevo Producto
	 * @return true si se pudo agregar o false en caso contrario
	 */
	public boolean agregarProducto(Producto nuevo) {
		
		for (int i = 0; i < productosParaLaVenta.length; i++) {
			if (productosParaLaVenta[i]==null) {
				productosParaLaVenta[i]=nuevo;
				return true;
			}
		}
		
		return false;
	}
	
	/****
	 * Calcula el importe total de la Venta, el cual est� dado por la sumatoria de los importes de los productos incluidos, menos el porcentaje de descuento
	 * @return Devuelve el importe total de la Venta
	 */
	public double getImporteTotal() {
		double totalImporteSinDescuento = 0.0;
		
		for (int i = 0; i < productosParaLaVenta.length; i++) {
			if (productosParaLaVenta[i]!=null) {
				totalImporteSinDescuento+=productosParaLaVenta[i].getPrecio();
			}
		}
		double totalImporteConDescuento = totalImporteSinDescuento-(totalImporteSinDescuento*this.porcentajeDescuento);
		
		return totalImporteConDescuento;
	}

	@Override
	public String toString() {
		return "Venta [eMail=" + eMail + ", cuil=" + cuil + ", codigoQR=" + codigoQR + ", porcentajeDescuento="
				+ porcentajeDescuento + ", productosParaLaVenta=" + Arrays.toString(productosParaLaVenta) + "]";
	}
	
	/****
	 * Devuelve informaci�n descripctiva de la Venta 
	 * @return String que describa el estado del objeto
	 */
	

}
