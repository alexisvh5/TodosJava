package ar.edu.unlam.pb1.dominios;


public class Consecionaria {

	private String nombre;
	private Coche [] flota;
	int cantidadDeCoches;
	
	private final int CANTIDAD_MAXIMA_DE_COCHES=100;
	
	public Consecionaria(String nombre) {
		this.nombre=nombre;
		this.flota=new Coche[CANTIDAD_MAXIMA_DE_COCHES];
	}
	
	
	public void IngresarNuevoVehiculo(Coche nuevo) {

//	boolean resultado= false;
		for (int i = 0; i < flota.length; i++) {
			
			if (flota[i]==null) {
				flota[i]=nuevo;
				break;
			}
			
		}
	
//		for (int i = 0; i < flota.length; i++) {
//			
//			if (flota[i]==null) {
//				flota[i]=nuevo;
//				resultado= true;
//				return resultado;
//			}
//			
//		}return resultado;
		
		//otra opcion -- la mas correcta; SIEMPRE DOS CONDICIONES EN EL WHILE; CORTE Y TAMANIO A RECORRER
//		while (resultado== false && i<flota.length) {
//			if(flota[i]==null) {
//				flota[i]= nuevo;
//				resultado = true;
//			}
//		i++; // es lo mismo si se pone "else{i++}"
//		}
//		return resultado;
//		
		// tiene desventaja... en caso de eliminar algun auto, quedan huecos
//		if (cantidadDeCoches < CANTIDAD_MAXIMA_DE_COCHES) {
//			flota[cantidadDeCoches++]=nuevo;
//		}
		
		
		
	}
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

//
//	public Coche[] getFlota() {
//		return flota;
//	}



	public int getCantidadDeCoches() {
		return cantidadDeCoches;
	}
	
	
	
	public String toString() {
		
		
		String listado ="lisdo de vehiculos \n";
		
		for (int i = 0; i < flota.length; i++) {
			if (flota[i]!=null) {
				listado +=flota[i].toString()+"\n";
			}
		}
		return listado;
		
	}
	
	public Coche[] obtenerFlotaOrdenadaPorPrecio() {
		
		Coche flotaOrdenada[]= new Coche[flota.length];
		Coche auxiliar = null;
		
		for (int i = 0; i < flota.length; i++) {
			flotaOrdenada[i]= flota[i];
		}
// para copiarlo
		for (int i = 1; i <= flotaOrdenada.length; i++) {
			for (int j = 0; j < flotaOrdenada.length - 1; j++) {
				if (flotaOrdenada[j]!=null && flotaOrdenada[j+1]!=null  && flotaOrdenada[j].getPrecio() > flotaOrdenada[j].getPrecio() ) {
					auxiliar = flotaOrdenada[j+1];
					flotaOrdenada[j+1]=flotaOrdenada[j];
					flotaOrdenada[j]= auxiliar;
				}
			}
		}
		return flotaOrdenada; 
	}
	
	public Coche buscarAuto(int codigo) {
		return flota[codigo];
	};
	public Coche buscarAuto(String modelo) {
		
//		for (int i = 0; i < flota.length; i++) {
//			if (flota[i]!=null && flota[i].getModelo().equals(modelo)){
//				return flota[i];
//			}
//		}
//		
//		return null;
//		
		// opcion 2
		Coche buscado =null;
		int i=0;
		
		while (buscado==null && i<CANTIDAD_MAXIMA_DE_COCHES) {
			if (flota[i]!=null && flota[i].getModelo().equals(modelo)){
buscado = flota[i];
				
			} else{i++;}
		}
		return buscado;
		
	};
	
}
