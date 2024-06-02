package ar.edu.unlam.pb1.dominio;

import java.util.Arrays;

public class Sucursal {
	private final int CANTIDAD_MAXIMA_VENTAS = 100;
	private String nombre;
	private Stock stock;
	private Venta[] ventas;

	public Sucursal(String nombre) {
		this.nombre = nombre;
		this.ventas = new Venta[CANTIDAD_MAXIMA_VENTAS];
		this.stock = new Stock();
	}

	public String getNombre() {
		return nombre;
	}

	public Stock getStock() {
		return stock;
	}

	public boolean agregarProductoNuevoAlStock(Producto producto, int cantidad) {
		// TODO: No es necesario modificar este metodo.
		return this.stock.agregarProductoNuevoAlStock(producto, cantidad);
	}

	public boolean agregarProductoExistenteAlStock(Producto producto, int cantidad) {
		// TODO: No es necesario modificar este metodo.		
		return this.stock.agregarProductoExistenteAlStock(producto, cantidad);
	}

	public boolean quitarProductoAlStock(Producto producto, int cantidad) {
		// TODO: No es necesario modificar este metodo.		
		return this.stock.quitarProductoAlStock(producto, cantidad);
	}

	public void mostrarStockDeSucursal() {
		// TODO: No es necesario modificar este metodo.		
		this.stock.mostrarProductosEnStock();
	}

	public Producto buscarProductoPorCodigoDeBarras(String codigoDeBarras) {
		// TODO: No es necesario modificar este metodo.
		return this.stock.buscarProductoPorCodigoDeBarras(codigoDeBarras);
	}

	public StockProducto buscarStockProductoPorCodigoDeBarras(String codigoDeBarras) {
		// TODO: No es necesario modificar este metodo.
		return this.stock.buscarStockProductoPorCodigoDeBarras(codigoDeBarras);
	}

	public boolean agregarVenta(Venta venta) {
		// TODO: Este metodo debe agregar la venta a la sucursal.
		
		for (int i = 0; i < ventas.length; i++) {
			if (ventas[i]==null ) {
				ventas[i] =venta;
				return true;
			}
		}
		
		return false;
	}

	public void mostrarVentas() {
		// TODO: Este metodo debe mostrar los datos de las venta por pantalla.
		System.out.println(ventas.length);
		for (int i = 0; i < ventas.length; i++) {
			if(ventas[i]!=null) {
				System.out.println("\n"+(i+1)+"-"+ventas[i]);
			}
		
		}
		
	}

	public void mostrarVentaMayorMonto() {
		// TODO: Este metodo debe buscar la venta de mayor monto y mostrar los datos por pantalla.
		Venta ventaMayorMonto=null;
		for (int i = 0; i < ventas.length; i++) {
			if (ventas[i]!=null) {
				if (ventaMayorMonto == null || ventaMayorMonto.getMonto()<ventas[i].getMonto()) {
					ventaMayorMonto = ventas[i];
				}
			}
			
		}
		System.out.println(ventaMayorMonto.toString());
	}
	
	public void mostrarVentaOrdenadasPorMonto() {
		// TODO: Este metodo debe ordenar las ventas de mayor a menor por monto y mostrar los datos por pantalla.	
		Venta aux = null;
		
		for (int i = 0; i < ventas.length-1; i++) {
			for (int j = 0; j < ventas.length-1-i; j++) {
				if (ventas[j]!=null && ventas[j+1]!=null) {
					if (ventas[j].getMonto()<ventas[j+1].getMonto()) {
						aux=ventas[j+1];
						ventas[j+1]=ventas[j];
						ventas[j]=aux;
					}
				}
			}
		}
//		for (int i = 0; i < ventas.length; i++) {
//			System.out.println(ventas[i]);
//		}
		System.out.println(Arrays.toString(ventas));
	}
	

}
