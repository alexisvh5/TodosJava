package ar.edu.unlam.pb1.dominio;

public class Producto {
	
	private String descripcion;
	private float precio;
	private String codigoBarra;
	private CategoriaProducto categoria;

	public Producto(String descripcion, float precio, String codigoBarra, CategoriaProducto categoria) {
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
		this.codigoBarra=codigoBarra;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public CategoriaProducto getCategoria() {
		return categoria;
	}

	@Override
	public String toString() {
		return descripcion + ", precio=" + precio + ", codigoBarra=" + codigoBarra + ", categoria=" + categoria.name();
	}
}
