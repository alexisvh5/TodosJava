package ar.edu.unlam.pb1.dominio;

import java.util.Iterator;

public class Vivero {

	private String nombre;
	private static double saldo = 0;
	private Planta[] plantas;
	private String contrasenia;

	public Vivero(String nombre, int cupoMacetas) {
		// TODO: Completar el constructor. La contrasenia debe generarse y asignarse al
		// vivero en este constructor
		this.nombre=nombre;
		this.plantas=new Planta[cupoMacetas];
		this.contrasenia= this.generarContrasenia();
		
	}

	public static double obtenerSaldo() {
		return saldo;
	}

	public boolean iniciarSesion(String contrasenia) {
		return this.contrasenia.equals(contrasenia);
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public boolean agregarPlanta(Planta planta) {
		
		// TODO: Agregar la planta al array solo si no existe otra con el mismo codigo
		// en el array de plantas. Considerar usar el metodo
		// buscarPlantaPorCodigo(codigo)
		
		
		for (int i = 0; i < plantas.length; i++) {
			if (plantas[i]==null && buscarPlantaPorCodigo(planta.getCodigo()) ==null ) {
			plantas[i]=	 planta;
			return true;
			}
		}
		
		
		return false;
	}

	public boolean venderPlanta(int codigo, int cantidadAVender) {
		// TODO: Para vender una planta, primero debemos revisar que exista (buscando
		// por codigo por ejemplo) y luego verificar que tenga stock para satisfacer la
		// cantidad a vender. Si es viable la venta, se debera modificar el stock de la
		// planta en el array de plantas (considerar el metodo modificarStockDePlantaPorCodigo()) para
		// disminuir el mismo, y se deberá
		// acumular el precio final de la venta al saldo del vivero. Ejemplo: Precio final de planta $10, cantidad de plantas en la venta 10 unidades, entonces se acumulan $100 al saldo del vivero
		
		Planta plantaAbuscar = buscarPlantaPorCodigo(codigo);
		if (plantaAbuscar!=null && plantaAbuscar.getStock() >= cantidadAVender) {
			int stockModificado = (plantaAbuscar.getStock() - cantidadAVender);
			modificarStockDePlantaPorCodigo(codigo,stockModificado);
			saldo+= plantaAbuscar.obtenerPrecioFinal()*cantidadAVender;
			return true;
		}
		
		return false;
	}

	public Planta buscarPlantaPorCodigo(int codigo) {
		// TODO: Buscar la planta en el array de plantas utilizando el codigo de la
		// planta. En caso de no existir, devolver null.
		
		for (int i = 0; i < plantas.length; i++) {
			if (plantas[i] != null && plantas[i].getCodigo() == codigo) {
				return plantas[i];
			}
		}
		
		return null;
	}

	public Planta[] buscarPlantasQueContienen(String texto) {
		// TODO: Generar un nuevo array con las plantas que en su nombre, contengan el
		// texto suministrado. El array no debe poseer espacios, es decir, las plantas
		// deben ingresar ordenadamente (no permitir posiciones en null entre las plantas ingresadas).
		Planta[]plantasQueContienen = new Planta[plantas.length];
		int cantidadDePlantasQueContienen=0;
		for (int i = 0; i < plantas.length; i++) {
			if (plantas[i] !=null && plantas[i].getNombre().contains(texto) ==true) {
				plantasQueContienen[cantidadDePlantasQueContienen] = plantas[i];
				cantidadDePlantasQueContienen++;
			}
		}
		return plantasQueContienen;
	}

	public boolean modificarStockDePlantaPorCodigo(int codigo, int stock) {
		// TODO: Iterar el array de plantas y en caso de existir alguna y que coincida
		// con el codigo suministrado, actualizar el stock de la misma.
		
		for (int i = 0; i < plantas.length; i++) {
			if (buscarPlantaPorCodigo(codigo) != null) {
				buscarPlantaPorCodigo(codigo).setStock(stock);
				return true;
			}
		}
		
		return false;
	}

	public Planta[] obtenerPlantasDeTipoOrdenadasPorNombreAscendende(TipoDePlanta tipoDePlanta) {
		// TODO: Generar un nuevo array de plantas que coincidan con el tipo de planta
		// suministrado. Antes de devolverlo, se debera ordenar por nombre ascendente.
		// Considerar el metodo ordenarPlantasPorNombreAscendente(array)
		
		Planta[]nuevoArray=new Planta[plantas.length];
		int contador=0;
		for (int i = 0; i < plantas.length; i++) {
			
			if (plantas[i] != null &&  plantas[i].getTipoDePlanta().equals(tipoDePlanta)) {
				nuevoArray[contador]=plantas[i];
				contador++;
				nuevoArray = ordenarPlantasPorNombreAscendente(nuevoArray);}}
		
		;
	
		return nuevoArray;
	}
	private Planta[] ordenarPlantasPorNombreAscendente(Planta[] plantas) {
		// TODO: Ordenar las plantas en el array suministrado por nombre de manera ascendente y devolver el array
		
		Planta aux = null;
		
		for (int i = 0; i < plantas.length; i++) {
			
			for (int j = 0; j < plantas.length - 1; j++) {
				
				if (plantas[j]!=null && plantas[j].getNombre().compareTo(plantas[j+1].getNombre()) > 0) {
					aux = plantas[j+1];
					plantas[j+1]=plantas[j];
					plantas[j] = aux;
				}
			}
		
		}
		
		return plantas;
	}

	@Override
	public String toString() {
		return "Vivero '" + nombre + "'. Saldo actual=" + saldo + "]";
	}

	private String generarContrasenia() {
		// TODO: Generar un contrasenia aleatoria y devolverla. La misma debe poseer:
		// 4 caracteres (en el orden que desee) los cuales deben ser:
		// 1 numero.
		// 1 letra mayuscula.
		// 2 letras minusculas.
		// Considerar el metodo obtenerCaracterAleatorio(1,10).
		char numero = this.obtenerCaracterAleatorio(48, 57);
		char letraMayuscula = this.obtenerCaracterAleatorio(65, 90);
		char letraMinuscula_1 = this.obtenerCaracterAleatorio(97, 122);
		char letraMinuscula_2 = this.obtenerCaracterAleatorio(97, 122);

		String contrasenia = "" + numero + letraMayuscula + letraMinuscula_1 + letraMinuscula_2;

		return contrasenia;
	}

	private char obtenerCaracterAleatorio(int posicionInicial, int posicionFinal) {
		// TODO: Generar un caracter aleatorio considerando las posiciones de los caracteres en la tabla ASCII
	    
		char caracter = ' ';
		int caracterAleatorio =(int) (Math.random()*(posicionFinal - posicionInicial + 1)) + posicionInicial ;
		
		caracter = (char) caracterAleatorio;
		return caracter;
		
	}



}
