package ar.edu.unlam.pb1.dominio;

import java.util.Arrays;

public class Venta {
	private final int CANTIDAD_MAXIMA_PRODUCTO_X_VENTAS = 100;
	private StockProducto[] stockProducto;
	private float monto;

	public Venta() {
		this.stockProducto = new StockProducto[CANTIDAD_MAXIMA_PRODUCTO_X_VENTAS];
		this.monto = 0;
		actualizarMonto();///////////////////////
	}

	public float getMonto() {
		return monto;
	}
////////////////// mismo que el otro?
	public boolean agregarProducto(Producto producto, int cantidad) {
		// TODO: Este metodo debe permitir agregar un producto y la cantidad vendida.
		
		for (int i = 0; i < stockProducto.length; i++) {
			if (stockProducto[i] ==null) {
				StockProducto nuevoProd = new StockProducto(producto,cantidad);
				stockProducto[i]= nuevoProd;
				return true;
			}
		}
		
		return false;
	}

	public void actualizarMonto() {
		// TODO: Este metodo debe actualizar el monto total de la venta.
		
		float precioVentas = 0;
		
		
		for (int i = 0; i < stockProducto.length; i++) {
			if (stockProducto[i]!=null) {
				precioVentas+= (stockProducto[i].getCantidad()*stockProducto[i].getProducto().getPrecio());
			}
			
		}
		this.monto=precioVentas;
	}

	@Override
	public String toString() {
		return "Venta [ stockProducto="+ Arrays.toString(stockProducto) + ", monto=" + monto + "]";
	}
	
	
	

//	@Override
//	public String toString() {
//		return "";
//	}
}
