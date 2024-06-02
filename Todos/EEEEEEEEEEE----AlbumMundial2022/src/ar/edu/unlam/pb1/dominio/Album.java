package ar.edu.unlam.pb1.dominio;

public class Album {
	
	private static final int NUMERO_JUGADORES = 22;
	private static String[] selecciones = {"Qatar", "Ecuador", "Senegal", "Paises Bajos", "Inglaterra", "Irán", "EEUU", "Gales", "Argentina", "Arabia Saudita", "México", "Polonia", "Francia", "Australia", "Dinamarca", "Tunez", "España", "Costa Rica", "Alemania", "Japón", "Bélgica", "Canadá", "Marruecos", "Croacia", "Brasil", "Serbia", "Suiza", "Camerún", "Portugal", "Ghana", "Uruguay", "Corea del Sur"};
	private static Figurita[] figuritasDisponibles = new Figurita[704];
	private Figurita[] figuritasActuales;
	
	public Album() {
		/*
		 * El constructor debe generar las condiciones necesaias para garantizar el correcto funcionamiento de la app
		 */
		this.figuritasActuales = new Figurita[figuritasDisponibles.length];
		inicializarCodigosDeFiguritas();
		ordenarFiguritas(figuritasDisponibles);
	}
	
	public static void inicializarCodigosDeFiguritas() {
		/*
		 * Por cada país debe generar 22 códigos de manera automática por ejemplo QAT1, URU12, COS10
		 */
		int contador = 0;
		for (int i = 0; i < selecciones.length; i++) {
			for(int j = 0;j<NUMERO_JUGADORES; j++) {
	figuritasDisponibles[contador]= new Figurita(selecciones[i].substring(0, 3).toUpperCase() + (j+1));
				contador++;
			}
		}
	}
	
	public static void actualizarDatosFigurita(String codigo, char grupo, String nombreJugador, double valor) {
		/*
		 * En función del código de figurita, se deben actualizar los datos de la misma en figuritasDisponibles 
		 */
		for (int i = 0; i < figuritasDisponibles.length; i++) {
			if (figuritasDisponibles[i].getCodigo().equals(codigo)) {
				figuritasDisponibles[i].setGrupo(grupo);
				figuritasDisponibles[i].setNombreJugador(nombreJugador);
				figuritasDisponibles[i].setValor(valor);
				break;
			}
		}
	}
	
	public static Figurita getFigurita(String codigo) {
		/*
		 * En función del código de figurita, devuelve la figurita de figuritasDisponibles
		 */
		for (int i = 0; i < figuritasDisponibles.length; i++) {
			if (figuritasDisponibles[i].getCodigo().equals(codigo)) {
				return figuritasDisponibles[i];
			}
		}
		return null;
	}
	
	public Figurita[] comprarSobre() {
		/*
		 * Se debe calcular y devolver 5 códigos de figurita de manera aleatoria.
		 */
		
		Figurita sobre[] = new Figurita[5];
		for (int i = 0; i < sobre.length; i++) {
			int codigoRandom = (int) (Math.random()*figuritasDisponibles.length);
			sobre[i] = figuritasDisponibles[codigoRandom];
		}
		return sobre;
	}
	
	public void agregarFigurita(Figurita nueva) {
		/*
		 * Agrega una nueva figurita al array figuritasActuales
		 */
		boolean existe = false;
		for (int i = 0; i < figuritasActuales.length; i++) {
			if (figuritasActuales[i]!=null && figuritasActuales[i].getCodigo().equals(nueva.getCodigo())) {
				existe = true;
				break;
			}
		}
		if (!existe) {
			for (int i = 0; i < figuritasActuales.length; i++) {
				if (figuritasActuales[i]==null) {
					figuritasActuales[i] = nueva;
					break;
				}
			}
		}
		ordenarFiguritasActuales();
//		for (int i = 0; i < figuritasActuales.length; i++) {
//			if (figuritasActuales[i].equals(nueva)) {
//				
//			}
//		}
		
		
	}
	public void ordenarFiguritas(Figurita[] figuritas) {
		/*
		 * Debe ordenar el array figuritasActuales
		 */
		for (int i = 0; i < figuritas.length-1; i++) {
			for (int j = 0; j < figuritas.length-1-i; j++) {
				Figurita figurita = figuritas[j];
				if (figuritas[j]!=null&&figuritas[j+1]!=null) {
					if (figuritas[j].getCodigo().compareTo(figuritas[j+1].getCodigo())>0) {
						figurita = figuritas[j];
						figuritas[j] = figuritas[j+1];
						figuritas[j+1] = figurita;
					}
				}
			}
		}
	}
	public void ordenarFiguritasActuales() {
		/*
		 * Debe ordenar el array figuritasActuales
		 */
		ordenarFiguritas(this.figuritasActuales);
//			if (figuritasActuales[i]!=null&&figuritasActuales[i+1]!=null) {
//				if (figuritasActuales[i].getCodigo().compareTo(figuritasActuales[i+1].getCodigo())>0) {
//					aux = figuritasActuales[i];
//					figuritasActuales[i] = figuritasActuales[i+1];
//					figuritasActuales[i+1] = aux;
//				}
//			}
	}

	public boolean elAlbumEstaCompleto() {
		/*
		 * Debe verificar que todas las figuritas disponibles estén presentes al menos una vez en las figuritas actuales 
		 */	
		int contador = 0;
		for (int i = 0; i < figuritasActuales.length; i++) {
			if (figuritasActuales[i]!=null &&figuritasActuales[i].getCodigo().equals(figuritasDisponibles[i].getCodigo())) {
				contador++;
			}
		}
		if (contador == figuritasDisponibles.length) {
			return true;
		}
		return false;
	}
	
	public double calcularPorcentajeCompletado() {
		/*
		 * Debe calcular el porcentaje de figuritas del album que está completo. Para esto se debe basar en la información de las figuritasDisponibles en relación a las figuritasActuales que se tiene en el album.
		 */
		int figusObtenidas = 0;
		for (int i = 0; i < figuritasActuales.length; i++) {
			if (figuritasActuales[i].getCodigo().equals(figuritasDisponibles[i].getCodigo())) {
				figusObtenidas++;
			}
		}
		return (figusObtenidas*100)/704;
	}
	
	public String mostrarFigusActuales() {
		String figus = "";
		for (int i = 0; i < figuritasActuales.length; i++) {
			if (figuritasActuales[i]!=null) {
				figus+=figuritasActuales[i].toString() + "\n";
			}
		}
		return figus;
	}
}
