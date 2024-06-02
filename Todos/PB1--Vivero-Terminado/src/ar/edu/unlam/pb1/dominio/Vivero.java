package ar.edu.unlam.pb1.dominio;

import java.util.*;;

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
		this.contrasenia = generarContrasenia();
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

		if (buscarPlantaPorCodigo(planta.getCodigo()) == null) {
			for (int inicio = 0; inicio < this.plantas.length; inicio++) {
				if (this.plantas[inicio] == null) {
					this.plantas[inicio] = planta;
					return true;
				}
			}
		}
		return false;
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
		Planta planta = buscarPlantaPorCodigo(codigo);
		for (int inicio = 0; inicio < this.plantas.length; inicio++) {
			if (planta == this.plantas[inicio] && planta.getStock() >= cantidadAVender) {

				saldo += planta.obtenerPrecioFinal() * cantidadAVender;
				int stockActual = planta.getStock() - cantidadAVender;
				modificarStockDePlantaPorCodigo(codigo, stockActual);
				return true;

			}
		}

		return false;
	}

	public Planta buscarPlantaPorCodigo(int codigo) {
		// TODO: Buscar la planta en el array de plantas utilizando el codigo de la
		// planta. En caso de no existir, devolver null.
		Planta planta = null;
		boolean seEncontro = false;
		int contador = 0;
		while (!seEncontro && contador < this.plantas.length) {
			if (this.plantas[contador] != null && this.plantas[contador].getCodigo() == codigo) {
				planta = this.plantas[contador];
				seEncontro = true;
			}
			contador++;
		}
		return planta;
	}

	public Planta[] buscarPlantasQueContienen(String texto) {
		// TODO: Generar un nuevo array con las plantas que en su nombre, contengan el
		// texto suministrado. El array no debe poseer espacios, es decir, las plantas
		// deben ingresar ordenadamente (no permitir posiciones en null entre las
		// plantas ingresadas).

		Planta[] buscarPlantas = new Planta[this.plantas.length];
		int contadorNull = 0;
		for (int inicio = 0; inicio < buscarPlantas.length; inicio++) {
			if (this.plantas[inicio] != null && this.plantas[inicio].getNombre().contains(texto)) {

				buscarPlantas[contadorNull] = this.plantas[inicio];
				contadorNull++;
			}
		}
		return buscarPlantas;
	}

	public boolean modificarStockDePlantaPorCodigo(int codigo, int stock) {
		// TODO: Iterar el array de plantas y en caso de existir alguna y que coincida
		// con el codigo suministrado, actualizar el stock de la misma.

		for (int inicio = 0; inicio < this.plantas.length; inicio++) {
			if (this.plantas[inicio] != null && this.plantas[inicio].getCodigo() == codigo) {
				this.plantas[inicio].setStock(stock);
				return true;

			}
		}

		return false;
	}

	public Planta[] obtenerPlantasDeTipoOrdenadasPorNombreAscendende(TipoDePlanta tipoDePlanta) {
		// TODO: Generar un nuevo array de plantas que coincidan con el tipo de planta
		// suministrado. Antes de devolverlo, se debera ordenar por nombre ascendente.
		// Considerar el metodo ordenarPlantasPorNombreAscendente(array)
		Planta[] ordenarPlantas = new Planta[this.plantas.length];
		int contadorNull = 0;
		for (int inicio = 0; inicio < this.plantas.length; inicio++) {
			if (this.plantas[inicio] != null && this.plantas[inicio].getTipoDePlanta().equals(tipoDePlanta)) {
				ordenarPlantas[contadorNull] = this.plantas[inicio];
				contadorNull++;
			}
		}

		for (int inicio = 0; inicio < ordenarPlantas.length; inicio++) {
			for (int control = 0; control < ordenarPlantas.length - 1; control++) {
				if (ordenarPlantas[control] != null && ordenarPlantas[control + 1] != null && ordenarPlantas[control]
						.getTipoDePlanta().compareTo(ordenarPlantas[control + 1].getTipoDePlanta()) > 0) {
					Planta aux = ordenarPlantas[control];
					ordenarPlantas[control] = ordenarPlantas[control + 1];
					ordenarPlantas[control + 1] = aux;
				}
			}
		}
		return ordenarPlantas;
	}
	
	//--------------------- porque???

	@Override
	public String toString() {
		return "Vivero '" + nombre + "'. Saldo actual=" + saldo + "]";
	}
	
	
	///________________ FALTAAAAAAAAAAAAAA

	public String generarContrasenia() {
		// TODO: Generar un contrasenia aleatoria y devolverla. La misma debe poseer:
		// 4 caracteres (en el orden que desee) los cuales deben ser:
		// 1 numero.
		// 1 letra mayuscula.
		// 2 letras minusculas.
		// Considerar el metodo obtenerCaracterAleatorio(1,10).
		int numero = 0;
		int letraMayuscula = 0;
		int letraMinuscula = 0;
		String contrasenia = "";
		boolean esValida = false;
	

		do {
			char caracter = obtenerCaracterAleatorio(1, 10);

			if (Character.isDigit(caracter) && numero != 1) {
				contrasenia += caracter;
				numero++;
			} else if (Character.isUpperCase(caracter) && letraMayuscula != 1) {
				letraMayuscula++;
				contrasenia += caracter;
			} else if (Character.isLowerCase(caracter) && letraMinuscula != 2) {
				letraMinuscula++;
				contrasenia += caracter;
			}

			if (numero == 1 && letraMayuscula == 1 && letraMinuscula == 2) {
				esValida = true;
			}

		} while (!esValida);

		return contrasenia;
	}
	
	//______________________________

	private char obtenerCaracterAleatorio(int posicionInicial, int posicionFinal) {
		// TODO: Generar un caracter aleatorio considerando las posiciones de los
		// caracteres en la tabla ASCII
		int caracterAleatorio = (int) (Math.random() * posicionFinal) + posicionInicial;
		char caracter = ' ';
		
		Random random = new Random();
		
		int opcion = random.nextInt(3);

		switch (opcion) {
		case 0:
			caracter = (char) ((char) caracterAleatorio + 'A');
			return caracter;
		case 1:
			caracter = (char) ((char) caracterAleatorio + 'a');
			return caracter;
		case 2:
			caracter = (char) ((char) caracterAleatorio + '0');
			return caracter;
		}

		return ' ';
	}                                  
	
	
	//----------------

	private Planta[] ordenarPlantasPorNombreAscendente(Planta[] plantas) {
		// TODO: Ordenar las plantas en el array suministrado por nombre de manera
		// ascendente y devolver el array
		Planta[] plantaOrdenar = plantas;
		for (int i = 0; i < plantaOrdenar.length; i++) { 
			
			for (int j = 0; j < plantaOrdenar.length - 1; j++) {
				
				if 
				(plantaOrdenar[j] != null && plantaOrdenar[j].getNombre().compareTo(plantaOrdenar[j + 1].getNombre()) > 0) 
				{
					Planta aux = plantaOrdenar[j];
					plantaOrdenar[j] = plantaOrdenar[j + 1];
					plantaOrdenar[j + 1] = aux;
				}
			}

		}
		return plantaOrdenar;
	}
}
