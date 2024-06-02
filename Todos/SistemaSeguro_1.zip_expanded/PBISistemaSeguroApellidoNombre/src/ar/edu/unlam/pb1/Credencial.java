package ar.edu.unlam.pb1;

public class Credencial {
	private int largoMinimo;
	private int largoMaximo;
	private int caracteresNumericosMinimos;
	private int caracteresNumericosMaximos;
	private int caracteresEspecialesMinimos;
	private int caracteresEspecialesMaximos;
	private int secuenciaMaxima;

	public Credencial() {
		this.largoMaximo = 0;
		this.largoMinimo = 0;
		this.caracteresNumericosMinimos = 0;
		this.caracteresNumericosMaximos = 0;
		this.caracteresEspecialesMaximos = 0;
		this.caracteresEspecialesMinimos = 0;
		this.secuenciaMaxima = 0;

	};

	/****
	 * Guarda el valor del largo minimo
	 * 
	 * @param LargoMinimo
	 */
	public void setLargoMinimo(int LargoMinimo) {
		this.largoMinimo = LargoMinimo;
	}

	/****
	 * Guarda el valor del largo m�ximo
	 * 
	 * @param LargoMaximo
	 */
	public void setLargoMaximo(int LargoMaximo) {
		this.largoMaximo = LargoMaximo;
	}

	/****
	 * Guarda el valor de la cantidad de caracteres num�ricos m�nimos
	 * 
	 * @param caracteresNumericosMinimos
	 */
	public void setCaracteresNumericosMinimos(int caracteresNumericosMinimos) {
		this.caracteresNumericosMinimos = caracteresNumericosMinimos;
	}

	/****
	 * Guarda el valor de la cantidad de caracteres num�ricos m�ximos
	 * 
	 * @param caracteresNumericosMaximos
	 */
	public void setCaracteresNumericosMaximos(int caracteresNumericosMaximos) {
		this.caracteresNumericosMaximos = caracteresNumericosMaximos;
	}

	/****
	 * Guarda el valor de la cantidad de caracteres especiales m�nimos
	 * 
	 * @param caracteresEspecialesMinimos
	 */
	public void setCaracteresEspecialesMinimos(int caracteresEspecialesMinimos) {
		this.caracteresEspecialesMinimos = caracteresEspecialesMinimos;
	}

	/****
	 * Guarda el valor de la cantidad de caracteres especiales m�ximos
	 * 
	 * @param caracteresEspecialesM�ximos
	 */
	public void setCaracteresEspecialesMaximos(int caracteresEspecialesMaximos) {
		this.caracteresEspecialesMaximos = caracteresEspecialesMaximos;
	}

	/****
	 * Guarda el valor de la secuencia m�xima.
	 * 
	 * @param CaracteresEspecialesM�ximos
	 */
	public void setSecuenciaMaxima(int secuenciaMaxima) {
		this.secuenciaMaxima = secuenciaMaxima;
	}

	/****
	 * Verifica que la credencial cumpla con los requisitos especificados
	 * (reutilizar los m�todos de abajo).
	 * 
	 * @param valor Es el valor que se est� intentando guardar (ya sea para el
	 *              userName o el password).
	 * @return true en caso de cumplir con los requisitos o false en caso contrario.
	 */
	public boolean verificarSiLaCredencialCumpleConLosRequisitos(String valor) {
		
		boolean verificado=false;

		if (verificarLargo(valor)&& verificarCantidadDeCaracteresNumericos(valor)&&verificarCantidadDeCaracteresEspeciales(valor)&&verificarSecuencia(valor)) {
			verificado = true;
		}
		
		return verificado;
	}

	/***
	 * Este m�todo verifica el largo de la credencial.
	 * 
	 * @param valor Credencial que se est� verificando.
	 * @return Devuelve true para el caso que el largo sea v�lido o false en caso
	 *         que la cantidad de caracteres de la credencial no cumpla con los
	 *         requisitos establecidos
	 */
	public boolean verificarLargo(String valor) {
		boolean verificadoLargo =false;
		
		if (valor.length() >= this.largoMinimo && valor.length()<= this.largoMaximo) {
			verificadoLargo=true;
		}
		
		return verificadoLargo;
	}

	/****
	 * Este m�todo verifica que la cantidad de caracteres num�ricos sea v�lida en
	 * funci�n de la configuraci�n.
	 * 
	 * @param valor Credencial que se est� verificando
	 * @return Devuelve true si se cumple las caracter�sitcas de cantidad de
	 *         caracteres num�ricos o false en caso contrario
	 */
	public boolean verificarCantidadDeCaracteresNumericos(String valor) {
		boolean verificadoCantidadDeCaracteresNumericos = false;
		int cantidadDeCaracteresNumericos = 0;

		for (int i = 0; i < valor.length(); i++) {
			if ( Character.isDigit(valor.charAt(i))) { //valor.charAt(i) != ' ' &&
				cantidadDeCaracteresNumericos++;
			}
			if (cantidadDeCaracteresNumericos >= this.caracteresNumericosMinimos
					&& cantidadDeCaracteresNumericos <= this.caracteresNumericosMaximos) {
				verificadoCantidadDeCaracteresNumericos=true;
			}

		}

		return verificadoCantidadDeCaracteresNumericos;
	}

	/****
	 * Este m�todo verifica que la cantidad de caracteres especiales sea v�lida en
	 * funci�n de la configuraci�n. Es aceptable definir un subconjunto de los
	 * caracteres especiales aceptados, por ejemplo {@, #, $, %, &, /, (, ), =}
	 * 
	 * @param valor Credencial que se est� verificando
	 * @return Devuelve true si se cumple las caracter�sitcas de cantidad de
	 *         caracteres especiales o false en caso contrario
	 */
	public boolean verificarCantidadDeCaracteresEspeciales(String valor) {
		
		boolean verificadoCantidadDeCaracteresEspeciales =false;
		int cantidadDeCaracteresEspeciales= 0;
		char [] caracteresAceptados =  {'@', '#', '$', '%', '&', '/', '(', ')','='};	
		
		for (int i = 0; i < valor.length(); i++) {
			for(int j = 0; j < caracteresAceptados.length; j++) {
			if (valor.charAt(i) != ' ' && (valor.charAt(i)==caracteresAceptados[j])) {
				cantidadDeCaracteresEspeciales++;
			}
			}
			
			if (cantidadDeCaracteresEspeciales >= this.caracteresNumericosMinimos
					&& cantidadDeCaracteresEspeciales <= this.caracteresNumericosMaximos) {
				verificadoCantidadDeCaracteresEspeciales=true;
			}

		}
		
		return verificadoCantidadDeCaracteresEspeciales;
	}

	/****
	 * Este m�todo verifica que no se supere la secuencia m�xima definida. Es decir,
	 * si la secuencia m�xima es 3, la secuencia 123 es v�lida, pero la secuencia
	 * 1234 ya no lo es. Misma situaci�n con la secuencia abc cuando el valor m�ximo
	 * sea 3 ser�a v�lida pero abcd ya no.
	 * 
	 * @return Devuelve true si se cumple las caracter�sitcas de secuencia m�xima y
	 *         false en caso contrario
	 */
	public boolean verificarSecuencia(String credencial) {
		
		boolean verificadoSecuencia =false;
		int numQueLeDeberiaSeguir=0;
		int numeroActual=0;
		int cantidadSecuencia=1;
	
			for (int i = 0; i < credencial.length()-1; i++) {
				numeroActual = credencial.charAt(i);
				numQueLeDeberiaSeguir = (credencial.charAt(i))+1;
				if (numeroActual<credencial.charAt(i+1) && numQueLeDeberiaSeguir == (credencial.charAt(i+1))) {
					cantidadSecuencia++;
				}
				else  {
					cantidadSecuencia=1;
				}
				
				if (cantidadSecuencia <= this.secuenciaMaxima ) {
					verificadoSecuencia=true;
				}else {return verificadoSecuencia =false;}
		}
		
		
		return verificadoSecuencia;
	}

	@Override
	public String toString() {
		return " [largoMinimo=" + largoMinimo + ", largoMaximo=" + largoMaximo
				+ ", caracteresNumericosMinimos=" + caracteresNumericosMinimos + ", caracteresNumericosMaximos="
				+ caracteresNumericosMaximos + ", caracteresEspecialesMinimos=" + caracteresEspecialesMinimos
				+ ", caracteresEspecialesMaximos=" + caracteresEspecialesMaximos + ", secuenciaMaxima="
				+ secuenciaMaxima + "]";
	}

}
