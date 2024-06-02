package ar.edu.unlam.pb1;

public class Credencial {

	/****
	 * Guarda el valor del largo minimo
	 * @param LargoMinimo 
	 */
	public void setLargoMinimo(int LargoMinimo) {
		
	}

	/****
	 * Guarda el valor del largo m�ximo
	 * @param LargoMaximo
	 */
	public void setLargoMaximo(int LargoMaximo) {
		
	}

	/****
	 * Guarda el valor de la cantidad de caracteres num�ricos m�nimos
	 * @param caracteresNumericosMinimos 
	 */
	public void setCaracteresNumericosMinimos(int caracteresNumericosMinimos) {
		
	}
	
	/****
	 * Guarda el valor de la cantidad de caracteres num�ricos m�ximos
	 * @param caracteresNumericosMaximos 
	 */
	public void setCaracteresNumericosMaximos(int caracteresNumericosMaximos) {
		
	}

	/****
	 * Guarda el valor de la cantidad de caracteres especiales m�nimos
	 * @param caracteresEspecialesMinimos 
	 */
	public void setCaracteresEspecialesMinimos(int caracteresEspecialesMinimos) {
		
	}
	
	/****
	 * Guarda el valor de la cantidad de caracteres especiales m�ximos
	 * @param caracteresEspecialesM�ximos
	 */	
	public void setCaracteresEspecialesMaximos(int caracteresEspecialesMaximos) {
		
	}

	/****
	 * Guarda el valor de la secuencia m�xima.
	 * @param CaracteresEspecialesM�ximos
	 */	
	public void setSecuenciaMaxima(int secuenciaMaxima) {
		
	}
	
	/****
	 * Verifica que la credencial cumpla con los requisitos especificados (reutilizar los m�todos de abajo).
	 * @param valor Es el valor que se est� intentando guardar (ya sea para el userName o el password).
	 * @return true en caso de cumplir con los requisitos o false en caso contrario.
	 */
	public boolean verificarSiLaCredencialCumpleConLosRequisitos(String valor) {
		return false;
	}
	
	/***
	 * Este m�todo verifica el largo de la credencial. 
	 * @param valor Credencial que se est� verificando.
	 * @return Devuelve true para el caso que el largo sea v�lido 
	 * 	o false en caso que la cantidad de caracteres de la credencial no cumpla con los requisitos establecidos
	 */
	public boolean verificarLargo(String valor) {
		return false;
	}
	
	/****
	 * Este m�todo verifica que la cantidad de caracteres num�ricos sea v�lida en funci�n de la configuraci�n.
	 * @param valor Credencial que se est� verificando 
	 * @return Devuelve true si se cumple las caracter�sitcas de cantidad de caracteres num�ricos o false en caso contrario 
	 */
	public boolean verificarCantidadDeCaracteresNumericos(String valor) {
		return false;
	}
	
	/****
	 * Este m�todo verifica que la cantidad de caracteres especiales sea v�lida en funci�n de la configuraci�n.
	 * Es aceptable definir un subconjunto de los caracteres especiales aceptados, por ejemplo {@, #, $, %, &, /, (, ), =}
	 * @param valor Credencial que se est� verificando  
	 * @return Devuelve true si se cumple las caracter�sitcas de cantidad de caracteres especiales o false en caso contrario 
	 */
	public boolean verificarCantidadDeCaracteresEspeciales(String valor) {
		return false;
	}
	
	/****
	 * Este m�todo verifica que no se supere la secuencia m�xima definida. 
	 * Es decir, si la secuencia m�xima es 3, la secuencia 123 es v�lida, pero la secuencia 1234 ya no lo es. 
	 * Misma situaci�n con la secuencia abc cuando el valor m�ximo sea 3 ser�a v�lida pero abcd ya no.
	 * @return Devuelve true si se cumple las caracter�sitcas de secuencia m�xima y false en caso contrario 
	 */
	public boolean verificarSecuencia(String credencial) {
		return false;
	}

}
