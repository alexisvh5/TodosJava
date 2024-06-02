package ar.edu.unlam.pb1.dominio;


public class Album {

	private static String selecciones[] = { "Qatar", "Ecuador", "Senegal", "Paises Bajos", "Inglaterra", "Irán", "EEUU",
			"Gales", "Argentina", "Arabia Saudita", "México", "Polonia", "Francia", "Australia", "Dinamarca", "Tunez",
			"España", "Costa Rica", "Alemania", "Japón", "Bélgica", "Canadá", "Marruecos", "Croacia", "Brasil",
			"Serbia", "Suiza", "Camerún", "Portugal", "Ghana", "Uruguay", "Corea del Sur" };//32

	private static Figurita figuritasDisponibles[] = new Figurita[704];
	private Figurita figuritasActuales[];

	public Album() {
		this.figuritasActuales = new Figurita[Album.figuritasDisponibles.length];
		/*
		 * El constructor debe generar las condiciones necesaias para garantizar el
		 * correcto funcionamiento de la app
		 */
	}

	public static void inicializarCodigosDeFiguritas() {
		String codigo = "";
		int contador = 0;
		for (int i = 0; i < Album.selecciones.length; i++) {
			for (int j = 1; j < 23; j++) {
				codigo = Album.selecciones[i].substring(0,3).toUpperCase() + j;
				Figurita nuevaFigurita = new Figurita(codigo, Album.selecciones[i]);
				Album.figuritasDisponibles[contador] = nuevaFigurita;
				contador++;
			}
		}
		/*
		 * Por cada país debe generar 22 códigos de manera automática por ejemplo QAT1,
		 * URU12, COS10
		 */

	}

	public static void actualizarDatosFigurita(String codigo, char grupo, String nombreJugador, double valor) {
		for (int i = 0; i < Album.figuritasDisponibles.length; i++) {
			if (Album.figuritasDisponibles[i] != null && Album.figuritasDisponibles[i].getCodigo().equals(codigo)) {
				
				Album.figuritasDisponibles[i].setGrupo(grupo);
				Album.figuritasDisponibles[i].setNombreJugador(nombreJugador);
				Album.figuritasDisponibles[i].setValor(valor);
			}
		}
		/*
		 * En función del código de figurita, se deben actualizar los datos de la misma
		 * en figuritasDisponibles
		 */
	}


	public static Figurita getFigurita(String codigo) {
		Figurita figuritaEncontrada = null;
		
		for (int i = 0; i < Album.figuritasDisponibles.length; i++) {
			if (Album.figuritasDisponibles[i] != null && Album.figuritasDisponibles[i].getCodigo().equals(codigo)) {
				figuritaEncontrada = Album.figuritasDisponibles[i];
			}
		}
		/*
		 * En función del código de figurita, devuelve la figurita de
		 * figuritasDisponibles
		 */
		return figuritaEncontrada;
	}

	public Figurita[] comprarSobre() {
		/*
		 * Se debe calcular y devolver 5 códigos de figurita de manera aleatoria.
		 */
		Figurita sobre[] = new Figurita[5];
		int random = 0;
		for (int i = 0; i < sobre.length; i++) {
			if (sobre[i]  == null) {
				random = (int) (Math.random()*(703-0+1)+1);
				sobre[i] = Album.figuritasDisponibles[random];				
			}
		}
		return sobre;
	}

	public void agregarFigurita(Figurita nueva) {
		for (int i = 0; i < this.figuritasActuales.length; i++) {
			if (this.figuritasActuales[i] == null) {
				this.figuritasActuales[i] = nueva;
				break;
			}
		}
		/*
		 * Agrega una nueva figurita al array figuritasActuales
		 */
	}

	public void ordenarFiguritasActuales() {
		
		Figurita auxiliar = null;
		for (int i = 1; i < this.figuritasActuales.length; i++) {
			for (int j = 0; j < this.figuritasActuales.length-1; j++) { /// solo tengo q fijam¡rme en la sig cond
				if (this.figuritasActuales[j+1] != null &&  this.figuritasActuales[j] != null && this.figuritasActuales[j].getCodigo().compareTo(this.figuritasActuales[j+1].getCodigo()) > 0) {
				auxiliar = this.figuritasActuales[j];
				this.figuritasActuales[j] = this.figuritasActuales[j+1];
				this.figuritasActuales[j+1] = auxiliar;
				
				}
			}
		}
		
//		int comparacion = 0;
//		int primerNum = 0;
//		int segundoNum = 0;
//		
//		for (int i = 1; i < figuritasActuales.length; i++) {
//			for (int j = 0; j < figuritasActuales.length-1; j++) {
//				if (this.figuritasActuales[j+1] != null && this.figuritasActuales[i] != null) {
//					
//					String primerasLetrasDeUnaPosicion = this.figuritasActuales[j].getCodigo().substring(0, 3);
//					String primerasLetrasDeOtraPosicion = this.figuritasActuales[j].getCodigo().substring(0, 3);
//					comparacion = primerasLetrasDeUnaPosicion.compareTo(primerasLetrasDeOtraPosicion);
//					
//					if (comparacion == 0) {
//						primerNum = Integer.parseInt(this.figuritasActuales[j].getCodigo().substring(3, this.figuritasActuales[j].getCodigo().length()));
//						segundoNum = Integer.parseInt(this.figuritasActuales[j+1].getCodigo().substring(3, this.figuritasActuales[j+1].getCodigo().length()));
//						if (primerNum > segundoNum) {
//							auxiliar = this.figuritasActuales[j+1];
//							this.figuritasActuales[j+1] = this.figuritasActuales[j];
//							this.figuritasActuales[j] = auxiliar;
//						}
//					}else if(comparacion > 0){
//						if (this.figuritasActuales[j+1] != null &&  this.figuritasActuales[j] != null && this.figuritasActuales[j].getCodigo().compareTo(this.figuritasActuales[j+1].getCodigo()) > 0) {
//							auxiliar = this.figuritasActuales[j];
//							this.figuritasActuales[j] = this.figuritasActuales[j+1];
//							this.figuritasActuales[j+1] = auxiliar;
//						}
//					}
//				}
//			}
//		}
		
		/*
		 * Debe ordenar el array figuritasActuales
		 */
	}

	public boolean elAlbumEstaCompleto() {
		boolean EstaCompleto = false;
		int figuritasCompletadas = 0;
		for (int i = 0; i < this.figuritasActuales.length; i++) {
			if (this.figuritasActuales[i] != null) {
				figuritasCompletadas++;
			}
		}
		if (figuritasCompletadas == Album.figuritasDisponibles.length) {
			EstaCompleto = true;
		}
		/*
		 * Debe verificar que todas las figuritas disponibles estén presentes al menos
		 * una vez en las figuritas actuales
		 */
		return EstaCompleto;
	}

	public double calcularPorcentajeCompletado() {
		double porcentajeCompletado = 0.0;
		double cantidadDeFiguritasActuales = 0.0;
		double cantidadDeFiguritasDisponibles = Album.figuritasDisponibles.length;
		for (int i = 0; i < figuritasActuales.length; i++) {
			if (this.figuritasActuales[i] != null) {
				cantidadDeFiguritasActuales++;
			}
		}
		porcentajeCompletado = ((cantidadDeFiguritasActuales*100)/cantidadDeFiguritasDisponibles);
		/*
		 * Debe calcular el porcentaje de figuritas del album que está completo. Para
		 * esto se debe basar en la información de las figuritasDisponibles en relación
		 * a las figuritasActuales que se tiene en el album.
		 * 
		 */
		return porcentajeCompletado;
	}

	public Figurita[] getFiguritasActuales() {
		return figuritasActuales;
	}
}
