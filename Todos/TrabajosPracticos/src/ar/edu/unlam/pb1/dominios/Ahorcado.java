package ar.edu.unlam.pb1.dominios;

public class Ahorcado {
	private String palabraAAdivinar;
	private char letrasCorrectas[];
	private char letrasIncorrectas[];
	private int vidasDisponibles;
	private boolean gano;
	private boolean perdio;

	private final int CANTIDAD_DE_EXTREMIDADES = 6;

	public Ahorcado() {
		this.palabraAAdivinar = "";
		this.vidasDisponibles = CANTIDAD_DE_EXTREMIDADES;
		this.letrasIncorrectas = new char[CANTIDAD_DE_EXTREMIDADES];
		this.gano = false;
		this.perdio=false;
	}

	public void setPalabraAAdivinar(String palabraAAdivinar) {

		this.palabraAAdivinar = palabraAAdivinar;
		generarLetrasCorrectas();

	}

	public int getVidasDisponibles() {
		return this.vidasDisponibles;
	};

	public char[] getLetrasCorrectas() {

		return letrasCorrectas;
	}

	public char[] getLetrasIncorrectas() {

		return letrasIncorrectas;

	}

	public boolean ingresarLetra(char letraIngresada) {
		boolean resultado = false;

		char palabraAAdivinarEnFormaDeArray[] = palabraAAdivinar.toCharArray();
		// seria lo mismo q recorrer palabraAAdivinar y palabra.charAt[i] la vamos
		// guardando en el nuevo array palabraAAdivinarEnFormaDeArray
		for (int i = 0; i < palabraAAdivinarEnFormaDeArray.length; i++) {
			if (letraIngresada == palabraAAdivinarEnFormaDeArray[i]) {

				letrasCorrectas[i] = letraIngresada;
				resultado = true;
			}
		}
		if (resultado == false) {
			letrasIncorrectas[CANTIDAD_DE_EXTREMIDADES - vidasDisponibles] = letraIngresada;
			this.vidasDisponibles--;

		}

		return resultado;
	};

	public void arriesgarPalabra(String palabraArriesgada) {

		if (palabraArriesgada.equalsIgnoreCase(this.palabraAAdivinar)) {
			this.gano = true;
		}else {this.perdio=true;}

	}

	public boolean gano() {
		boolean resultado = false;
		if (this.gano || verificarSiAdivinoTodasLasLetras()) {
			resultado = true;
		}
		return resultado;

	}

	private boolean verificarSiAdivinoTodasLasLetras() {
		boolean resultado = true;

		for (int i = 0; i < letrasCorrectas.length; i++) {
			if (letrasCorrectas[i] == '_') {
				resultado = false;
			}

		}
// OTRA ALTERNATIVA		en caso q no quiera poner break para hacerlo mas rapiddo
//		int i = 0;
//		while (resultado == true && i < letrasCorrectas.length) {
//			if (letrasCorrectas[i] == '_') {
//				resultado = false;
//			}
//			i++;
//		}
		
		//OPCION C  --pero no funca, xq son dos objetos => tengoq  comparar de otra manera
		
//		if (letrasCorrectas == palabraAAdivinar.toCharArray()) { aca converti un string en array de char
//			resultado = true;
//		}else {return resultado = false;}
		
		// la que si funcioaria es convertir un array de char en string y comparar
//		if (String.copyValueOf(letrasCorrectas).equalsIgnoreCase(palabraAAdivinar)) { aca converti un string en array de char
//		resultado = true;
//	}else {return resultado = false;}
		
		return resultado;
	}

	private void generarLetrasCorrectas() {
		this.letrasCorrectas = new char[palabraAAdivinar.length()];
		for (int i = 0; i < letrasCorrectas.length; i++) {
			letrasCorrectas[i] = '_';
		}

	}

	public boolean perdio() {
		boolean resultado = false;
		if (this.perdio || this.vidasDisponibles==0) {
			resultado = true;
		}
		return resultado;

	}

}
