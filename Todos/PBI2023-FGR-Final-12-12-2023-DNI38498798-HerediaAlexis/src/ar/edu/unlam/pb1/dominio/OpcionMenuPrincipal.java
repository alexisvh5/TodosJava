package ar.edu.unlam.pb1.dominio;

//**********************************************
//TODO: No es necesario modificar este enum.
//**********************************************

public enum OpcionMenuPrincipal {
	OPCION1("Mostrar stock de productos"),
	OPCION2("Agregar nuevo producto al stock"),
	OPCION3("Agregar producto existente al stock"),
	OPCION4("Vender"),
	OPCION5("Mostrar ventas"),
	OPCION6("Mostrar la venta de mayor monto"),
	OPCION7("Mostrar ventas ordenadas por monto"),
	SALIR("Salir");
	
	private OpcionMenuPrincipal(String descripcion) {
		this.descripcion = descripcion;
	}
	
	private String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}	
	
	public static OpcionMenuPrincipal obtenerOpcion(int opcion) {
		return OpcionMenuPrincipal.values()[opcion - 1];
	}
	
	public static int min() {
		int minIndex = 1;
		for (OpcionMenuPrincipal d : OpcionMenuPrincipal.values()) {
			minIndex = Math.min(d.ordinal() + 1, minIndex);
		}
		return minIndex;
	}
	
	public static int max() {
		int maxIndex = 1;
		for (OpcionMenuPrincipal d : OpcionMenuPrincipal.values()) {
			maxIndex = Math.max(d.ordinal() + 1, maxIndex);
		}
		return maxIndex;
	}	
	
	public String toString() {
		return (this.ordinal() + 1) + ") " + this.descripcion;
	}	
}
