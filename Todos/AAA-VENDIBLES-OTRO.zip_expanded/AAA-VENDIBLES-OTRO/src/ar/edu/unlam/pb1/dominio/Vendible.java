package ar.edu.unlam.pb1.dominio;

import ar.edu.unlam.pb1.dominio.enums.TipoDeVendible;

public class Vendible {
	private String codigo;
	private TipoDeVendible tipoVendible;
	private int stock;
	private double precio;
	// TODO: Representa la abstracción de algo posible de ser vendido en la tienda.
	// Para este producto software podrá ser de tipo PRODUCTO o SERVICIO. Completar
	// el constructor, getters, setters y otros métodos necesarios.

	public static final int CANTIDAD_MAXIMA_PRODUCTOS = 10;

	public Vendible(String codigo, TipoDeVendible tipoDeVendible, int stock, double precio) {
		setCodigo(codigo);
		setTipoVendible(tipoDeVendible);
		setStock(stock);
		setPrecio(precio);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public TipoDeVendible getTipoVendible() {
		return tipoVendible;
	}

	public void setTipoVendible(TipoDeVendible tipoVendible) {
		this.tipoVendible = tipoVendible;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Vendible [codigo=" + codigo + ", tipoVendible=" + tipoVendible + ", stock=" + stock + ", precio="
				+ precio + "]";
	}
}
