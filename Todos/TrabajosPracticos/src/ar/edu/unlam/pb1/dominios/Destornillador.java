package ar.edu.unlam.pb1.dominios;

public class Destornillador {// nuestro dest va a tener cabezas intercambiables

	private char tipoDeCabeza;

	// constructor

	public Destornillador() {
		tipoDeCabeza = '\0';
	}

	// metdos

	public void atornillar(Tornillo aAtornillar) {
		if (tipoDeCabeza == aAtornillar.getTIPO_DE_CABEZA()) {
// podria pedir la posicion actual del tornillo y comparar si es igual a la de cantidad de rosca, pero eso ya esta calculado en el metodo girar,encima no tengo el getposicionActual y no quieroo hacerlo publico

			boolean sePuedoGirar = false; // yo no lo pondria

			do {
				sePuedoGirar = aAtornillar.girar('h');// ya arranca en false,como en el metodo, pero cuando se ejecuta,
														// se mide de
				// acuerdo ala condicion
			} while (sePuedoGirar);

		}

	}

	public void desatornillar(Tornillo aDesatornillar) {
		if (tipoDeCabeza == aDesatornillar.getTIPO_DE_CABEZA()) {
			// podria pedir la posicion actual del tornillo y comparar si es igual a la de
			// cantidad de rosca, pero eso ya esta calculado en el metodo girar,encima no
			// tengo el getposicionActual y no quieroo hacerlo publico
			boolean sePuedoGirar = false;

			do {
				sePuedoGirar = aDesatornillar.girar('a');// ya arranca en false,como en el metodo, pero cuando se
															// ejecuta, se mide de
				// acuerdo ala condicion
			} while (sePuedoGirar);

		}
	}

	public void atornillar(Tornillo aAtornillar, Tarugo aUtilizar) {
		if (tipoDeCabeza == aAtornillar.getTIPO_DE_CABEZA() && aAtornillar.getLONGITUD() <= aUtilizar.getLONGITUD()) { 
			boolean sePuedoGirar = false;

			do {
				sePuedoGirar = aAtornillar.girar('h');// ya arranca en false,como en el metodo, pero cuando se ejecuta,
														// se mide de
				// acuerdo ala condicion
			} while (sePuedoGirar);

		}


	}

	public void desatornillar(Tornillo aDesatornillar, Tarugo aUtilizar) {
		if (tipoDeCabeza == aDesatornillar.getTIPO_DE_CABEZA()
				&& aDesatornillar.getLONGITUD() <= aUtilizar.getLONGITUD()) {
			// podria pedir la posicion actual del tornillo y comparar si es igual a la de
			// cantidad de rosca, pero eso ya esta calculado en el metodo girar,encima no
			// tengo el getposicionActual y no quieroo hacerlo publico
			boolean sePuedoGirar = false;

			do {
				sePuedoGirar = aDesatornillar.girar('a');// ya arranca en false,como en el metodo, pero cuando se
															// ejecuta, se mide de
				// acuerdo ala condicion
			} while (sePuedoGirar);

		
	}

	}

	public void setTipoDeCabeza(char tipoDeCabeza) {
		this.tipoDeCabeza = tipoDeCabeza;
	}

	public char getTipoDeCabeza() {
		return tipoDeCabeza;
	}

	@Override
	public String toString() {
		return "Destornillador [tipoDeCabeza=" + tipoDeCabeza + "]";
	}

}
