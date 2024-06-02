package ar.edu.unlam.pb1.dominio;



public class Stock {
	private final int CANTIDAD_MAXIMA_PRODUCTOS = 100;
	private StockProducto[] stock;

	public Stock() {
		this.stock = new StockProducto[CANTIDAD_MAXIMA_PRODUCTOS];
	}

	public boolean agregarProductoNuevoAlStock(Producto producto, int cantidad) {
		// TODO: Este metodo debe agregar un producto nuevo al stock.
		
		boolean verdadero=false;
		int i =0;
		
		while (!verdadero && i <stock.length) {
			if (stock[i]==null) {
				StockProducto nuevoProd = new StockProducto(producto,cantidad);
				stock[i]= nuevoProd;
				verdadero = true;
			}
			i++;
		}
		
		
		return verdadero;
	}
/////ver si es equals o compare.to
	public boolean agregarProductoExistenteAlStock(Producto producto, int cantidad) {
		// TODO: Este metodo debe incrementar la cantidad de un producto existente en el
		// stock.
		
		boolean verdadero =false;
		for (int i = 0; i < stock.length; i++) {
			if (stock[i] != null && stock[i].getProducto() == producto) { /// no entiendo xq dijo q esto estaba mal
				
				stock[i].setCantidad(stock[i].getCantidad()+cantidad);
				verdadero = true;
			}
		}
		
		return verdadero;
	}

	public boolean quitarProductoAlStock(Producto producto, int cantidad) {
		// TODO: Este metodo debe decrementar la cantidad de un producto existente en el stock.
		// El stock no puede quedar negativo.
		
		for (int i = 0; i < stock.length; i++) {
			if (stock[i]!=null && stock[i].getProducto().equals(producto)) {
				if(stock[i].getCantidad()>=cantidad)
				{stock[i].setCantidad(stock[i].getCantidad()-cantidad);
				return true;}
				
			}
		}
		
		return false;
	}
	
	
	public void mostrarProductosEnStock() {
		// TODO: Este metodo debe mostrar por pantalla la informacion del stock.
		
		for (int i = 0; i < stock.length; i++) {
			if (stock[i]!=null) {
			System.out.println("\n"+(i+1)+"-"+stock[i].getProducto().toString());	
			}
			
		}
	
	}

	public Producto buscarProductoPorCodigoDeBarras(String codigoDeBarras) {
		// TODO: Este metodo debe buscar un producto por su codigo de barras.
		
		
		for (int i = 0; i < stock.length; i++) {
			if (stock[i]!=null && stock[i].getProducto().getCodigoBarra().equals(codigoDeBarras)) {/////////////
				
				return stock[i].getProducto();
				
	
			}
		}
		
		return null;
	}

	public StockProducto buscarStockProductoPorCodigoDeBarras(String codigoDeBarras) {
		// TODO: Este metodo debe buscar un stock de producto por su codigo de barras.
		
		
		for (int i = 0; i < stock.length; i++) {
			if (stock[i]!=null && stock[i].getProducto().getCodigoBarra().equals(codigoDeBarras)) {
				 return stock[i];
				
	
			}
		}
		
		return null;
	}

}
