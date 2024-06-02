package ar.edu.unlam.pb1.dominio;

import ar.edu.unlam.pb1.dominio.enums.TipoDeIva;

public class Producto {

	// TODO: Completar getters, setters, constructor y metodos necesarios para
	// garantizar el correcto funcionamiento. No olvidar incluir el precio de venta
	// al mostrar un producto (mostrando el precio de venta con IVA).
	
	private String codigoBarras;
	private char seccion;
	private String nombre;
	private TipoDeIva tipoDeIva;
	private int stock;
	private double porcentajeGanancia;
	private double costo;
	
	
	private double precioVenta;
	private static final double BASE_PORCENTUAL = 1.0;

	public Producto(String codigoBarras, char seccion, String nombre, TipoDeIva tipoDeIva, int stock,
			double porcentajeGanancia, double costo) {
		this.codigoBarras=codigoBarras;
		this.seccion=seccion;
		this.nombre=nombre;
		this.tipoDeIva=tipoDeIva;
		this.stock = stock;
		this.precioVenta=0;
	}

	public double obtenerPrecioDeVenta(boolean incluyeIva) {
		// TODO: Calcular y devolver el precio de venta de un producto considerando la
		// siguiente ecuación:
		// Precio venta = (costo / (Base porcentual - porcentaje de ganancia)) * 100.
		// Para la base porcentual, utilizaremos 100%.
		// Ejemplo: ($100 / (100% - 20%)) * 100 (este valor es constante).
		// En caso de que el precio de venta deba incluir el porcentaje de IVA, se deberá
		// agregar al precio de venta segun su tipo. Siempre devolver el precio de venta
		// redondeado (el valor decimal sea mayor o igual a 5).
		
	return 0.0;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public char getSeccion() {
		return seccion;
	}

	public void setSeccion(char seccion) {
		this.seccion = seccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoDeIva getTipoDeIva() {
		return tipoDeIva;
	}

	public void setTipoDeIva(TipoDeIva tipoDeIva) {
		this.tipoDeIva = tipoDeIva;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	public void setPorcentajeGanancia(double porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
//	double ivaGeneral = this.precioVenta * 0.27;
//	double ivaReducido1 = this.precioVenta * 0.21;
//	double ivaReducido2 = this.precioVenta * 0.105;
//	double superReducido = this.precioVenta * 0.25;
//	this.precioVenta =(this.costo/((BASE_PORCENTUAL*100) -(this.porcentajeGanancia*100)))*100;
//
//	if (incluyeIva && this.tipoDeIva.equals(TipoDeIva.GENERAL)) {
//		return this.precioVenta + ivaGeneral;
//	}
//	if (incluyeIva && this.tipoDeIva.equals(TipoDeIva.REDUCIDO_I)) {
//		return this.precioVenta + ivaReducido1;
//	}
//	if (incluyeIva && this.tipoDeIva.equals(TipoDeIva.REDUCIDO_II)) {
//		return this.precioVenta + ivaReducido2;
//	}
//	if (incluyeIva && this.tipoDeIva.equals(TipoDeIva.SUPER_REDUCIDO)) {
//		return this.precioVenta + superReducido;
//	}
//	
//	return this.precioVenta;

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
////////////// a ver si no lo necetos
//	@Override
//	public String toString() {
//		return "Producto [codigoBarras=" + codigoBarras + ", seccion=" + seccion + ", nombre=" + nombre + ", tipoDeIva="
//				+ tipoDeIva + ", stock=" + stock + ", porcentajeGanancia=" + porcentajeGanancia + ", costo=" + costo
//				+ ", precioVenta=" + precioVenta + "]";
//	}
	
	
	
	
}
