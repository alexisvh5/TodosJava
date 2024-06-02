package ar.edu.unlam.pb1;

public class Credencial {

	/****
	 * Guarda el valor del largo minimo
	 * @param LargoMinimo 
	 */
	public void setLargoMinimo(int LargoMinimo) {
		
	}

	/****
	 * Guarda el valor del largo máximo
	 * @param LargoMaximo
	 */
	public void setLargoMaximo(int LargoMaximo) {
		
	}

	/****
	 * Guarda el valor de la cantidad de caracteres numéricos mínimos
	 * @param caracteresNumericosMinimos 
	 */
	public void setCaracteresNumericosMinimos(int caracteresNumericosMinimos) {
		
	}
	
	/****
	 * Guarda el valor de la cantidad de caracteres numéricos máximos
	 * @param caracteresNumericosMaximos 
	 */
	public void setCaracteresNumericosMaximos(int caracteresNumericosMaximos) {
		
	}

	/****
	 * Guarda el valor de la cantidad de caracteres especiales mínimos
	 * @param caracteresEspecialesMinimos 
	 */
	public void setCaracteresEspecialesMinimos(int caracteresEspecialesMinimos) {
		
	}
	
	/****
	 * Guarda el valor de la cantidad de caracteres especiales máximos
	 * @param caracteresEspecialesMáximos
	 */	
	public void setCaracteresEspecialesMaximos(int caracteresEspecialesMaximos) {
		
	}

	/****
	 * Guarda el valor de la secuencia máxima.
	 * @param CaracteresEspecialesMáximos
	 */	
	public void setSecuenciaMaxima(int secuenciaMaxima) {
		
	}
	
	/****
	 * Verifica que la credencial cumpla con los requisitos especificados (reutilizar los métodos de abajo).
	 * @param valor Es el valor que se está intentando guardar (ya sea para el userName o el password).
	 * @return true en caso de cumplir con los requisitos o false en caso contrario.
	 */
	public boolean verificarSiLaCredencialCumpleConLosRequisitos(String valor) {
		return false;
	}
	
	/***
	 * Este método verifica el largo de la credencial. 
	 * @param valor Credencial que se está verificando.
	 * @return Devuelve true para el caso que el largo sea válido 
	 * 	o false en caso que la cantidad de caracteres de la credencial no cumpla con los requisitos establecidos
	 */
	public boolean verificarLargo(String valor) {
		return false;
	}
	
	/****
	 * Este método verifica que la cantidad de caracteres numéricos sea válida en función de la configuración.
	 * @param valor Credencial que se está verificando 
	 * @return Devuelve true si se cumple las caracterísitcas de cantidad de caracteres numéricos o false en caso contrario 
	 */
	public boolean verificarCantidadDeCaracteresNumericos(String valor) {
		return false;
	}
	
	/****
	 * Este método verifica que la cantidad de caracteres especiales sea válida en función de la configuración.
	 * Es aceptable definir un subconjunto de los caracteres especiales aceptados, por ejemplo {@, #, $, %, &, /, (, ), =}
	 * @param valor Credencial que se está verificando  
	 * @return Devuelve true si se cumple las caracterísitcas de cantidad de caracteres especiales o false en caso contrario 
	 */
	public boolean verificarCantidadDeCaracteresEspeciales(String valor) {
		return false;
	}
	
	/****
	 * Este método verifica que no se supere la secuencia máxima definida. 
	 * Es decir, si la secuencia máxima es 3, la secuencia 123 es válida, pero la secuencia 1234 ya no lo es. 
	 * Misma situación con la secuencia abc cuando el valor máximo sea 3 sería válida pero abcd ya no.
	 * @return Devuelve true si se cumple las caracterísitcas de secuencia máxima y false en caso contrario 
	 */
	public boolean verificarSecuencia(String credencial) {
		return false;
	}

}
