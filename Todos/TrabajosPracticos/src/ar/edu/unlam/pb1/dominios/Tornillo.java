package ar.edu.unlam.pb1.dominios;

public class Tornillo {

	private final char TIPO_DE_CABEZA;
	private final int LONGITUD;
	private final int CANTIDAD_ROSCA;

	private int posicionActual;// la can de rosca es la pos max y la minima es cero

	public Tornillo(char tipoDeCabeza, int longitud, int cantidadDeRosca) {
		this.TIPO_DE_CABEZA = tipoDeCabeza;
		this.CANTIDAD_ROSCA = cantidadDeRosca;
		this.LONGITUD = longitud;
		this.posicionActual = 0;
	}

	public char getTIPO_DE_CABEZA() {
		return TIPO_DE_CABEZA;
	}

	public int getLONGITUD() {
		return LONGITUD;
	}

	public boolean girar(char sentido) {
		
		boolean sePudoGirar = false ;
		
		switch (sentido) {
		case 'H':
		case 'h':// de horario--atornillando
			if (posicionActual<this.CANTIDAD_ROSCA) {
				this.posicionActual++;
				sePudoGirar = true;
			}
			
			break;
		case 'A':	
		case 'a': // antihorario--desatornilla
			if (posicionActual>0) {
				this.posicionActual--;
				sePudoGirar = true;
			}
			break;

		}
		
		return sePudoGirar;
	}

	@Override
	public String toString() {
		return "Tornillo [TIPO_DE_CABEZA=" + TIPO_DE_CABEZA + ", LONGITUD=" + LONGITUD + ", CANTIDAD_ROSCA="
				+ CANTIDAD_ROSCA + ", posicionActual=" + posicionActual + "]";
	}
	
	

}
