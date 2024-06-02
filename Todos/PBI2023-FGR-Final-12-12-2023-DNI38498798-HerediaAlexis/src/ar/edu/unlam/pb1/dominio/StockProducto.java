package ar.edu.unlam.pb1.dominio;

public class StockProducto {

	private Producto producto;
	private int cantidad;
	
	public StockProducto(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return producto + ", cantidad=" + cantidad;
	}
	
}
