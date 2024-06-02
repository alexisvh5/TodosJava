package ar.edu.unlam.pb1.dominio;

import ar.edu.unlam.pb1.dominio.enums.TipoDeIva;

public class Bazar {

	// TODO: Completar getters, setters, constructor y metodos necesarios para
	// garantizar el correcto funcionamiento.

	private String nombre;
	private Producto[] productos;

	public Bazar(String nombre) {
		this.nombre = nombre;
		this.productos = new Producto[10000];
	}

	public Producto obtenerProductoPorCodigoDeBarras(String codigoDeBarras) {
		// TODO: Buscar y devolver el producto que cumpla con el codigo de barras
		// suministrado. En caso de no existir algun producto, devolver null.
		Producto prodBusc = null;

		for (int i = 0; i < productos.length; i++) {
			if (productos[i] != null && productos[i].getCodigoBarras().equalsIgnoreCase(codigoDeBarras)) {
				prodBusc = productos[i];
			} else {
				return prodBusc;
			}

		}
		return prodBusc;
	}

	public String agregarProducto(String codigoDeBarras, char seccion, String nombre, TipoDeIva tipoDeIva, int stock,
			double porcentajeGanancia, double costo) {

		// TODO: Se debera agregar un producto al bazar. Antes de realizar esta accion,
		// se debera validar el producto (ver metodo productoValido()).
		// Si el mensaje obtenido esta vacio, se debe proceder a agregar el producto al
		// bazar.
		// Devolver el mensaje resultante de validar el producto (puede estar vacio o
		// tener indicaciones de validacion).

		String mensaje = productoValido(codigoDeBarras, stock);
		int i = 0;

		if (productoValido(codigoDeBarras, stock).equalsIgnoreCase("")) {
			Producto nuevoAgregado = new Producto(codigoDeBarras, seccion, nombre, tipoDeIva, stock, porcentajeGanancia,
					costo);

			while (i < productos.length) {
				if (productos[i] == null) {
					productos[i] = nuevoAgregado;
					mensaje = "se puedo hacer todo muy bien";
					i = productos.length;
				}
			}
		}
		return mensaje;
	}

	private String productoValido(String codigoDeBarras, int stock) {
		// TODO: Verificar si los datos para crear un producto son validos. En caso de
		// ser valido, se debera devolver un texto vacio ("").
		// Las siguientes validaciones deben considerarse:
		// - El codigo de barras debe ser valido (ver metodo codigoDeBarrasValido()). En
		// caso de no ser valido agregar al mensaje de respuesta: "\nCodigo de barras
		// invalido."
		// - No debe existir otro producto con el mismo codigo de barras. Si existe,
		// agregar al mensaje de respuesta: "\nCodigo de barras existente."
		// - El stock ingresado debe ser mayor que cero. Si no lo fuera, agregar al
		// mensaje de respuesta: "\nEl stock no puede ser negativo."
		// Ejemplo de texto de respuesta con las 3 validaciones:
		// "\nCodigo de barras invalido.\nCodigo de barras existente.\nEl stock no puede
		// ser negativo."

		// Producto(String codigoBarras, char seccion, String nombre, TipoDeIva
		// tipoDeIva, int stock,
		// double porcentajeGanancia, double costo

		String texto = "";
		if (obtenerProductoPorCodigoDeBarras(codigoDeBarras) != null) {
			return texto = "\nCodigo de barras existente.";
		} else {
		 texto = "";
		}

		if (!codigoDeBarrasValido(codigoDeBarras)) {
			return texto = "\nCodigo de barras invalido.";
		} else {
			texto = "";
		}
	
		if (stock < 0) {
			return texto = "\nEl stock no puede ser negativo";
		} else {
			texto = "";
		}

		return texto;
	}

	private boolean codigoDeBarrasValido(String codigoDeBarras) {
		// TODO: Se debera devolver verdadero en caso de que el codigo de barras este
		// conformado por 12 caracteres y todos ellos sean numeros.
		boolean cierto = false;

		for (int i = 0; i < codigoDeBarras.length(); i++) {
			if (codigoDeBarras.length() == 12 && Character.isDigit(codigoDeBarras.charAt(i))) {
				cierto = true;
			} else {
				return false;
			}
		}

		return cierto;

	}

	public boolean agregarStockAProducto(String codigoDeBarras, int stockParaAgregar) {
		// TODO: Agregar el stock indicado al producto que cumpla con el codigo de
		// barras, solo si el producto existe.
		return false;
	}

	public void incrementarCostoDeProductoConPorcentaje(String codigoDeBarras, double porcentajeIncremento) {
		// TODO: Incrementar el costo de un producto el cual se debera buscar por su
		// codigo de barras, en el porcentaje indicado.
		// Ejemplo: costo = 100, porcentaje 10% -> nuevo costo = 110
	}

	public Producto[] obtenerProductosPorSeccion(char seccion) {
		// TODO: Se debera devolver un array de productos que contengan solo los
		// productos que se encuentren en la seccion indicada.
		return null;
	}

	public double obtenerPromedioDePrecioDeVentaDeProductosPorSeccionConOSinIva(char seccion, boolean incluyeIva) {
		// TODO: Se debera calcular y devolver el promedio de precio de venta de
		// productos que se encuentren en la seccion indicada, considerando si se debe
		// incluir el IVA o no.
		// Si no hay productos en dicha seccion, se debera devolver cero. Si hay, el
		// promedio se debera mostrar redondeado segun si sus decimales son mayor o
		// igual a cinco.
		return 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Producto[] getProductos() {
		return productos;
	}

	public void setProductos(Producto[] productos) {
		this.productos = productos;
	}

}

/// por orden
