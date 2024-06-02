package ar.edu.unlam.pb1.interfaz.enums;


public enum MenuPrincipal {
	BUSCAR_VENDIBLES_CUYO_CODIGO_INICIA_CON_TEXTO, CREAR_VENTA_DE_PRODUCTOS_O_SERVICIOS, OBTENER_CANTIDAD_DE_SERVICIOS_EN_VENTAS,
	OBTENER_PRODUCTOS_CON_STOCK_MAXIMO_ORDENADOS_POR_PRECIO_DESCENDENTE, SALIR;
	
	public static int min() {
		int minIndex = 1;
		for (MenuPrincipal d : MenuPrincipal.values()) {
			minIndex = Math.min(d.ordinal() + 1, minIndex);
		}
		return minIndex;
	}
	
	public static int max() {
		int maxIndex = 1;
		for (MenuPrincipal d : MenuPrincipal.values()) {
			maxIndex = Math.max(d.ordinal() + 1, maxIndex);
		}
		return maxIndex;
	}	

}
