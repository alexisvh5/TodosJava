package ar.edu.dominio;


public class Album {

	private static String selecciones[] = { "Qatar", "Ecuador", "Senegal", "Paises Bajos", "Inglaterra", "Irán", "EEUU",
			"Gales", "Argentina", "Arabia Saudita", "México", "Polonia", "Francia", "Australia", "Dinamarca", "Tunez",
			"España", "Costa Rica", "Alemania", "Japón", "Bélgica", "Canadá", "Marruecos", "Croacia", "Brasil",
			"Serbia", "Suiza", "Camerún", "Portugal", "Ghana", "Uruguay", "Corea del Sur" };

	private static Figurita figuritasDisponibles[] = new Figurita[704];
	private Figurita figuritasActuales[];

	public Album() {
		/*
		 * El constructor debe generar las condiciones necesaias para garantizar el
		 * correcto funcionamiento de la app
		 */
		this.figuritasActuales = new Figurita[figuritasDisponibles.length];

	}

	public static void inicializarCodigosDeFiguritas() {
		/*
		 * Por cada país debe generar 22 códigos de manera automática por ejemplo QAT1,
		 * URU12, COS10----a 22 figuritas hasta 704
		 */
//		String codigo = "";
//		int contador = 0;
//		
//		
//		for (int i = 0; i < selecciones.length; i++) {
//			for (int j = 1; j < 23; j++) {
//				codigo = selecciones[i].substring(0, 3).toUpperCase() + j;
//				Figurita nuevaFigurita = new Figurita(codigo,selecciones[i]);
//				figuritasDisponibles[contador] = nuevaFigurita;
//				contador++;
//			}
//		}
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
	}

	public static void actualizarDatosFigurita(String codigo, char grupo, String nombreJugador, double valor) {
		/*
		 * En función del código de figurita, se deben actualizar los datos de la misma
		 * en figuritasDisponibles
		 */
//
//		if (getFigurita(codigo) != null) {
//			
//			getFigurita(codigo).setNombreJugador(nombreJugador);
//			getFigurita(codigo).setGrupo(grupo);
//			getFigurita(codigo).setValor(valor);
//
//		}
		for (int i = 0; i < Album.figuritasDisponibles.length; i++) {
			if (Album.figuritasDisponibles[i] != null && Album.figuritasDisponibles[i].getCodigo().equals(codigo)) {
				Album.figuritasDisponibles[i].setGrupo(grupo);
				Album.figuritasDisponibles[i].setNombreJugador(nombreJugador);
				Album.figuritasDisponibles[i].setValor(valor);
			}
		}

	}

	public static Figurita getFigurita(String codigo) {
		/*
		 * En función del código de figurita, devuelve la figurita de
		 * figuritasDisponibles
		 */
		
		Figurita figuBuscada=null;
		int i=0;
		
		while (i< figuritasDisponibles.length) {
			if (figuritasDisponibles[i] != null && figuritasDisponibles[i].getCodigo() == codigo) {
				figuBuscada= figuritasDisponibles[i];
				i = figuritasDisponibles.length;
			}else {i++;}
		}
		
		return figuBuscada;
	}

	public Figurita[] comprarSobre() {
		/*
		 * Se debe calcular y devolver 5 códigos de figurita de manera aleatoria.===> 5
		 * figus
		 */
		Figurita sobre[] = new Figurita[5];
		int random=0;
		

//		for (int i = 0; i < sobre.length; i++) {
//			if (sobre[i] == null) {
//				random=  (int) (Math.random()*(704))+1;////////////////////
//				sobre[i] = figuritasDisponibles[random];
//			}
//		}
//		return sobre;
// otra manera de hacerlo
		int j=0;
		while ( j < sobre.length) {
			if (sobre[j]==null) {
				random=  (int)( (Math.random()*(704))+1);////////////////////
				sobre[j] = figuritasDisponibles[random];
			}j++;
		}
		return sobre;
		
		
	}
	

	public void agregarFigurita(Figurita nueva) {
		/*
		 * Agrega una nueva figurita al array figuritasActuales
		 */
		for (int i = 0; i < this.figuritasActuales.length; i++) {
			if (this.figuritasActuales[i] == null) {
				this.figuritasActuales[i] = nueva;
				break;
			}
		}
	}

	public void ordenarFiguritasActuales() {
		/*
		 * Debe ordenar el array figuritasActuales
		 */
		Figurita aux = null;
		for (int a = 0; a < figuritasActuales.length; a++) {
				for (int i = 0; i < figuritasActuales.length - 1; i++) {
			if (figuritasActuales[i] != null && figuritasActuales[i + 1] != null) {
				if (figuritasActuales[i].getSeleccion().equals(figuritasActuales[i + 1].getSeleccion())) {
					aux = figuritasActuales[i + 1];
					figuritasActuales[i + 1] = figuritasActuales[i];
					figuritasActuales[i] = aux;
				}
			}
		}
		}
	

	}

	public boolean elAlbumEstaCompleto() {
		/*
		 * Debe verificar que todas las figuritas disponibles estén presentes al menos
		 * una vez en las figuritas actuales
		 */
		boolean verdad = false;

		for (int i = 0; i < figuritasDisponibles.length; i++) {
		for (int j = 0; j < figuritasActuales.length; j++) {
				if(figuritasDisponibles[i]!=null && figuritasActuales[j]!=null) {
				if (figuritasDisponibles[i].getCodigo() == figuritasActuales[j].getCodigo()
						&& figuritasActuales.length == 704) {
					verdad = true;
				}
			}}
		}

		return verdad;
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

	public void setFiguritasActuales(Figurita[] figuritasActuales) {
		this.figuritasActuales = figuritasActuales;
	}








}