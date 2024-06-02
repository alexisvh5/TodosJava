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
		this.nombre = nombre;
		this.plantas = new Planta[cupoMacetas];
		this.contrasenia = this.generarContrasenia();
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
		boolean PlantaAgregada = false;

		if (this.buscarPlantaPorCodigo(planta.getCodigo()) == null) {
			for (int i = 0; i < plantas.length; i++) {
				if (plantas[i] == null) {
					plantas[i] = planta;
					PlantaAgregada = true;
					break;
				}
			}
		}
		return PlantaAgregada;
	}

	public boolean venderPlanta(int codigo, int cantidadAVender) {
		// TODO: Para vender una planta, primero debemos revisar que exista (buscando
		// por codigo por ejemplo) y luego verificar que tenga stock para satisfacer la
		// cantidad a vender. Si es viable la venta, se debera modificar el stock de la
		// planta en el array de plantas (considerar el metodo
		// modificarStockDePlantaPorCodigo()) para
		// disminuir el mismo, y se deberá
		// acumular el precio final de la venta al saldo del vivero. Ejemplo: Precio
		// final de planta $10, cantidad de plantas en la venta 10 unidades, entonces se
		// acumulan $100 al saldo del vivero
		boolean seVendio = false;
		int nuevoStockDePlantas = 0;
		for (int i = 0; i < plantas.length; i++) {
			if (plantas[i] != null && plantas[i].getCodigo() == codigo && plantas[i].getStock() >= cantidadAVender) {

				nuevoStockDePlantas = cantidadAVender - plantas[i].getStock();
				this.modificarStockDePlantaPorCodigo(codigo, nuevoStockDePlantas);
				saldo += plantas[i].obtenerPrecioFinal();
				seVendio = true;
			}
		}

		return seVendio;
	}

	public Planta buscarPlantaPorCodigo(int codigo) {
		// TODO: Buscar la planta en el array de plantas utilizando el codigo de la
		// planta. En caso de no existir, devolver null.
		Planta plantaEncontrada = null;

		for (int i = 0; i < plantas.length; i++) {
			if (plantas[i] != null && codigo == plantas[i].getCodigo()) {
				plantaEncontrada = plantas[i];
				break;
			}
		}

		return plantaEncontrada;
	}

	public Planta[] buscarPlantasQueContienen(String texto) {
		// TODO: Generar un nuevo array con las plantas que en su nombre, contengan el
		// texto suministrado. El array no debe poseer espacios, es decir, las plantas
		// deben ingresar ordenadamente (no permitir posiciones en null entre las
		// plantas ingresadas).
		int cantidadDePlantasQueContienen = 0;
		Planta[] plantasQueContienen = null;

		for (int i = 0; i < plantas.length; i++) {

			if (plantas[i] != null && plantas[i].getNombre().contains(texto)) {
				cantidadDePlantasQueContienen++;
			}
		}

		plantasQueContienen = new Planta[cantidadDePlantasQueContienen];

		int indice = 0;
		for (int i = 0; i < plantas.length; i++) {
			if (plantas[i] != null && plantas[i].getNombre().contains(texto)) {
				plantasQueContienen[indice] = plantas[i];
				indice++;
			}
		}

		return plantasQueContienen;

	}

	public boolean modificarStockDePlantaPorCodigo(int codigo, int stock) {
		// TODO: Iterar el array de plantas y en caso de existir alguna y que coincida
		// con el codigo suministrado, actualizar el stock de la misma.
		boolean stockModificado = false;

		for (int i = 0; i < plantas.length; i++) {
			if (plantas[i] != null && plantas[i].getCodigo() == codigo) {
				plantas[i].setStock(stock);
				stockModificado = true;
				break;
			}
		}

		return stockModificado;
	}

	public Planta[] obtenerPlantasDeTipoOrdenadasPorNombreAscendende(TipoDePlanta tipoDePlanta) {
		// TODO: Generar un nuevo array de plantas que coincidan con el tipo de planta
		// suministrado. Antes de devolverlo, se debera ordenar por nombre ascendente.
		// Considerar el metodo ordenarPlantasPorNombreAscendente(array)
		Planta temp = null;
		Planta[] plantasOrdenadas = new Planta[plantas.length];

		for (int i = 0; i < plantas.length; i++) {
			plantasOrdenadas[i] = plantas[i];

		}

		for (int i = 1; i < plantasOrdenadas.length; i++) {

			for (int j = 0; j < plantasOrdenadas.length - 1; j++) {
				if (plantasOrdenadas[j] != null && plantasOrdenadas[j + 1] != null
						&& plantasOrdenadas[i].getTipoDePlanta().compareTo(tipoDePlanta) > 0) {
					temp = plantasOrdenadas[j + 1];
					plantasOrdenadas[j + 1] = plantasOrdenadas[j];
					plantasOrdenadas[j] = temp;
				}

			}
		}

		this.ordenarPlantasPorNombreAscendente(plantasOrdenadas);
		return plantasOrdenadas;
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
		// TODO: Generar un caracter aleatorio considerando las posiciones de los
		// caracteres en la tabla ASCII
		char caracter = ' ';

		int caracterAleatorio = (int) (Math.random() * (posicionFinal - posicionInicial + 1)) + posicionInicial;

		caracter = (char) caracterAleatorio;
		return caracter;
	}

	private Planta[] ordenarPlantasPorNombreAscendente(Planta[] plantas) {
		// TODO: Ordenar las plantas en el array suministrado por nombre de manera
		// ascendente y devolver el array

		Planta[] plantasOrdenadas = new Planta[plantas.length];

		for (int i = 0; i < plantas.length; i++) {
			plantasOrdenadas[i] = plantas[i];
		}

		for (int i = 1; i < plantasOrdenadas.length - 1; i++) {

			for (int j = 0; j < plantasOrdenadas.length - 1; j++) {

				if (plantasOrdenadas[j] != null && plantasOrdenadas[j + 1] != null
						&& plantasOrdenadas[j].getNombre().compareTo(plantasOrdenadas[j + 1].getNombre()) > 0) {

					Planta temp = plantasOrdenadas[j];
					plantasOrdenadas[j] = plantasOrdenadas[j + 1];
					plantasOrdenadas[j + 1] = temp;

				}
			}
		}

		return plantasOrdenadas;
	}
	
	//metodo solo hecho para ver el codigo de las plantas a la hora de hacer pruebas
	public String mostrarPlantas() {
		String listaDePlantas = "";
		for (int i = 0; i < plantas.length; i++) {
			if (plantas[i] != null) {
				listaDePlantas += plantas[i].toString() + "\n";
			}
		}

		return listaDePlantas;
	}
}
