package ar.edu.unlam.pb1.dominio;

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
		boolean plantaAgregada = false;

		Planta plantaEncontrada = this.buscarPlantaPorCodigo(planta.getCodigo());

		if (plantaEncontrada == null) {

			int posicion = 0;
			while (posicion < this.plantas.length && !plantaAgregada) {

				if (this.plantas[posicion] == null) {
					this.plantas[posicion] = planta;
					plantaAgregada = true;
				}

				posicion++;
			}

		}

		return plantaAgregada;
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

		boolean ventaRealizada = false;
		Planta planta = this.buscarPlantaPorCodigo(codigo);

		if (planta != null && planta.getStock() >= cantidadAVender) {

			ventaRealizada = this.modificarStockDePlantaPorCodigo(codigo, (planta.getStock() - cantidadAVender));

			if (ventaRealizada) {
				saldo += planta.obtenerPrecioFinal() * cantidadAVender;
			}
		}

		return ventaRealizada;
	}

	public Planta buscarPlantaPorCodigo(int codigo) {
		// TODO: Buscar la planta en el array de plantas utilizando el codigo de la
		// planta. En caso de no existir, devolver null.
		Planta planta = null;

		boolean encontrada = false;
		int i = 0;
		while (i < this.plantas.length && !encontrada) {

			if (this.plantas[i] != null && this.plantas[i].getCodigo() == codigo) {
				planta = this.plantas[i];
				encontrada = true;
			}

			i++;
		}

		return planta;
	}

	public Planta[] buscarPlantasQueContienen(String texto) {
		// TODO: Generar un nuevo array con las plantas que en su nombre, contengan el
		// texto suministrado. El array no debe poseer espacios, es decir, las plantas
		// deben ingresar ordenadamente (no permitir posiciones en null entre las
		// plantas ingresadas).
		Planta[] plantasEncontradas = new Planta[this.plantas.length];

		int posicion = 0;

		for (int i = 0; i < this.plantas.length; i++) {

			if (this.plantas[i] != null && this.plantas[i].getNombre().toLowerCase().contains(texto.toLowerCase())) {

				plantasEncontradas[posicion++] = this.plantas[i];
			}
		}

		return plantasEncontradas;
	}

	public boolean modificarStockDePlantaPorCodigo(int codigo, int stock) {
		// TODO: Iterar el array de plantas y en caso de existir alguna y que coincida
		// con el codigo suministrado, actualizar el stock de la misma.

		boolean modificada = false;
		int i = 0;
		while (i < this.plantas.length && !modificada) {

			if (this.plantas[i] != null && this.plantas[i].getCodigo() == codigo) {

				this.plantas[i].setStock(stock);
				modificada = true;
			}

			i++;
		}

		return modificada;
	}

	public Planta[] obtenerPlantasDeTipoOrdenadasPorNombreAscendende(TipoDePlanta tipoDePlanta) {
		// TODO: Generar un nuevo array de plantas que coincidan con el tipo de planta
		// suministrado. Antes de devolverlo, se debera ordenar por nombre ascendente.
		// Considerar el metodo ordenarPlantasPorNombreAscendente(array)

		Planta[] plantasDelTipo = new Planta[this.plantas.length];

		int posicion = 0;

		for (int i = 0; i < this.plantas.length; i++) {

			if (this.plantas[i] != null && this.plantas[i].getTipoDePlanta().equals(tipoDePlanta)) {

				plantasDelTipo[posicion++] = this.plantas[i];
			}
		}

		return this.ordenarPlantasPorNombreAscendente(plantasDelTipo);
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

		String contrasenia = "";

		contrasenia += this.obtenerCaracterAleatorio(48, 57); // devuelve un caracter numero
		contrasenia += this.obtenerCaracterAleatorio(65, 90); // devuelve un caracter letra mayuscula
		contrasenia += this.obtenerCaracterAleatorio(97, 122); // devuelve un caracter letra minuscula
		contrasenia += this.obtenerCaracterAleatorio(97, 122); // devuelve un caracter letra minuscula

		return contrasenia;
	}

	private char obtenerCaracterAleatorio(int posicionInicial, int posicionFinal) {
		// TODO: Generar un caracter aleatorio considerando las posiciones de los
		// caracteres en la tabla ASCII

		int posicion = (int) (Math.random() * (posicionFinal - posicionInicial) + posicionInicial);

		return (char) posicion;
	}

	private Planta[] ordenarPlantasPorNombreAscendente(Planta[] plantas) {
		// TODO: Ordenar las plantas en el array suministrado por nombre de manera
		// ascendente y devolver el array

		Planta auxiliar = null;

		for (int i = 0; i < plantas.length; i++) {

			for (int j = 1; j < plantas.length - 1; j++) {

				if (plantas[j] != null && plantas[j + 1] != null
						&& plantas[j].getNombre().compareTo(plantas[j + 1].getNombre()) > 0) {

					auxiliar = plantas[j];
					plantas[j] = plantas[j + 1];
					plantas[j + 1] = auxiliar;
				}
			}

		}

		return plantas;
	}

}
