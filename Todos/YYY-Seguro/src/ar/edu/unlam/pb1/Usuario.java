package ar.edu.unlam.pb1;

public class Usuario {
	
	/****
	 * Determina si un usuario está logueado en el sistema
	 * @return Devuelve true si está logueado o false en caso contrario 
	 */
	public boolean isLogueado() {
		return false;
	}

	/****
	 * Determina si un usuario está bloqueado
	 * @return Devuelve true si está bloqueado o false en caso contrario 
	 */
	public boolean isBloqueado() {
		return false;
	}
	
	/****
	 * Intenta loguearse al Sistema. Devuelve true si se pudo loguear o false en caso contrario.
	 * Es importante tener en cuenta que si se supera la cantidad de intentos máximos el usuario debe quedar bloqueado
	 * @param userName - Nombre de usuario que se intenta loguear 
	 * @param password - Contraseña con la que se intenta loguear
	 * @return Devuelve true si se pudo loguear o false en caso contrario 
	 */
	public boolean loguear(String userName, String password) {
		return false;
	}
}
