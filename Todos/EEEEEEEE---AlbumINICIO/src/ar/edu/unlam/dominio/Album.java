package ar.edu.unlam.dominio;

import java.util.Arrays;



public class Album {
	
	private static final int NUMERO_JUGADORES = 22;
	private static String []selecciones = {"Qatar", "Ecuador", "Senegal", "Paises Bajos", "Inglaterra", "Ir�n", "EEUU", "Gales", "Argentina", "Arabia Saudita", "M�xico", "Polonia", "Francia", "Australia", "Dinamarca", "Tunez", "Espa�a", "Costa Rica", "Alemania", "Jap�n", "B�lgica", "Canad�", "Marruecos", "Croacia", "Brasil", "Serbia", "Suiza", "Camer�n", "Portugal", "Ghana", "Uruguay", "Corea del Sur"};
	private static Figurita []figuritasDisponibles = new Figurita[704];
	private  Figurita []figuritasActuales;
	
	public Album() {
		/*
		 * El constructor debe generar las condiciones necesaias para garantizar el correcto funcionamiento de la app
		 */
		this.figuritasActuales = new Figurita[figuritasDisponibles.length];
		inicializarCodigosDeFiguritas();
	}
	
	public static void inicializarCodigosDeFiguritas() {

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
		 * En funci�n del c�digo de figurita, se deben actualizar los datos de la misma en figuritasDisponibles 
		 */
		for (int i = 0; i < Album.figuritasDisponibles.length; i++) {
			if (figuritasDisponibles[i] != null && figuritasDisponibles[i].getCodigo().equals(codigo)) {

				figuritasDisponibles[i].setGrupo(grupo);
				figuritasDisponibles[i].setNombreJugador(nombreJugador);
				figuritasDisponibles[i].setValor(valor);
		}
		}
		
		
	}
	
	public static Figurita getFigurita(String codigo) {
		/*
		 * En funci�n del c�digo de figurita, devuelve la figurita de figuritasDisponibles
		 */
	
		for (int i = 0; i < figuritasDisponibles.length; i++) {
			if (figuritasDisponibles[i] != null && figuritasDisponibles[i].getCodigo().toUpperCase().equals(codigo)) {
				return figuritasDisponibles[i];
			 
			}
		}
	
		return null;
	}
	
	public Figurita[] comprarSobre() {
		/*
		 * Se debe calcular y devolver 5 c�digos de figurita de manera aleatoria.
		 */
//	Figurita codigosAleatorios[] = new Figurita[5];
//	int numeroRandom=(int)(Math.random()*figuritasDisponibles.length +1);
//	
//			for (int i = 0; i < codigosAleatorios.length; i++) {
//		if (codigosAleatorios[i]==null ) {
//			codigosAleatorios[i]= figuritasDisponibles[numeroRandom] ;
//		} ;
//	}return codigosAleatorios;}
	Figurita sobre[] = new Figurita[5];
	for (int i = 0; i < sobre.length; i++) {
		int codigoRandom = (int) (Math.random()*figuritasDisponibles.length);
		sobre[i] = figuritasDisponibles[codigoRandom];
	}
	return sobre;}

	public void agregarFigurita(Figurita nueva) {
		/*
		 * Agrega una nueva figurita al array figuritasActuales
		 */
		for (int i = 0; i < figuritasActuales.length; i++) {
			if (figuritasActuales[i] == null) {
				figuritasActuales[i] = nueva;
				break;
			}
		}
		
	}
	
	public void ordenarFiguritasActuales() {
		/*
		 * Debe ordenar el array figuritasActuales
		 */
	Figurita aux=null;
		
		for (int i = 0; i < figuritasActuales.length; i++) {
			for (int j = 0; j < figuritasActuales.length-1; j++) {
				if (this.figuritasActuales[j+1] != null &&  this.figuritasActuales[j] != null && this.figuritasActuales[j].getCodigo().compareTo(this.figuritasActuales[j+1].getCodigo()) > 0) {
					aux = this.figuritasActuales[j];
					this.figuritasActuales[j] = this.figuritasActuales[j+1];
					this.figuritasActuales[j+1] = aux;
				}
			}
		}
		
	}
	
	public boolean elAlbumEstaCompleto() {
		/*
		 * Debe verificar que todas las figuritas disponibles est�n presentes al menos una vez en las figuritas actuales 
		 */		
		
//		int contador=0;
//		boolean aver = false;
//		
//for (int i = 0; i < figuritasActuales.length; i++) {
//if (figuritasDisponibles[contador++].getCodigo().indexOf(figuritasActuales[i].getCodigo())!=-1 && figuritasActuales.length >= figuritasDisponibles.length) {
//					aver=true;
//				}
//			}
//
//		
//		
//		return aver;
		
		
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
		 * Debe calcular el porcentaje de figuritas del album que est� completo. Para esto se debe basar en la informaci�n de las figuritasDisponibles en relaci�n a las figuritasActuales que se tiene en el album.
		 */
		double porcentajeCompletado = 0.0;
		double cantidadDeFiguritasActuales = 0.0;
		double cantidadDeFiguritasDisponibles = Album.figuritasDisponibles.length;
		for (int i = 0; i < figuritasActuales.length; i++) {
			if (this.figuritasActuales[i] != null) {
				cantidadDeFiguritasActuales++;
			}
		}
		porcentajeCompletado = ((cantidadDeFiguritasActuales*100)/cantidadDeFiguritasDisponibles);
		return porcentajeCompletado;
	}

	public  Figurita[] getFiguritasActuales() {
		return figuritasActuales;
	}


	public void setFiguritasActuales(Figurita[] figuritasActuales) {
		this.figuritasActuales = figuritasActuales;
	}

	@Override
	public String toString() {
		return "Album [figuritasActuales=" + Arrays.toString(figuritasActuales) + "]";
	}

	
	
	
	
	
	
	
	
	
	
}
