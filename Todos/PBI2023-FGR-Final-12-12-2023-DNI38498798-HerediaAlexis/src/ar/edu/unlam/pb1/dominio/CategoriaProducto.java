package ar.edu.unlam.pb1.dominio;

// **********************************************
// TODO: No es necesario modificar este enum.
// **********************************************

public enum CategoriaProducto {
	GOLOSINAS("Golosinas"), 
	JUGUETES("Juguetes"), 
	CIGARRILLOS("Tabaco"), 
	GASEOSAS("Gaseosas"), 
	AGUAS("Aguas");
	
	private CategoriaProducto(String descripcion) {
		this.descripcion = descripcion;
	}
	
	private String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}	
	
	public static CategoriaProducto obtenerOpcion(int opcion) {
		return CategoriaProducto.values()[opcion - 1];
	}
	
	public static int min() {
		int minIndex = 1;
		
		for (CategoriaProducto d : CategoriaProducto.values()) {
			minIndex = Math.min(d.ordinal() + 1, minIndex);
		}
		return minIndex;
	}
	
	public static int max() {
		int maxIndex = 1;
		for (CategoriaProducto d : CategoriaProducto.values()) {
			maxIndex = Math.max(d.ordinal() + 1, maxIndex);
		}
		return maxIndex;
	}	
	
	public String toString() {
		//(this.ordinal() + 1) + ") " + 
		return this.descripcion;
	}	
	
}
