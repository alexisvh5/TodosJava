package ar.edu.unlam.pb1;

public class SistemaSeguro {

	/***
	 * Se deben agregar todos los atributos que se requieran.
	 */
	
	/***
	 * El constructor debe realizar todas las acciones necesarias para garantizar el correcto funcionamiento
	 * @param nombre - Este es el nombre del sistema
	 */
	public SistemaSeguro(String nombre) {
		
	}
	
	/***
	 * Guarda las caracter�sticas que deben tener los nombres de usuario en este sistema
	 * @param userNameConfiguration - Objeto de tipo credencial con las caracter�sticas que deben tener los nombres de usuario
	 */
	public void setUserNameConfiguration(Credencial userNameConfiguration) {
		
	}
	
	/***
	 * Guarda las caracter�sticas que deben tener los contrase�as en este sistema
	 * @param passwordConfiguration - Objeto de tipo credencial con las caracter�sticas que deben tener las contrase�as
	 */
	public void setPasswordConfiguration(Credencial passwordConfiguration) {
		
	}
	
	/***
	 * Este m�todo agrega un nuevo usuario a la lista de usuarios del sistema. 
	 * @param userName Este par�metro identifica un�vocamente al usuario del sistema.
	 * @param password Este par�metro identifica la contrase�a del usuario.
	 * @return true si se  pudo agregar al usuario y false en caso contrario. 
	 * 		Es importante mencionar que NO se deben agregar usuarios que no cumplan con los requisitos (caracter�sticas) de 
	 * 		userName y password. Es decir se debe verificar verificarSiLaCredencialCumpleConLosRequisitos para el userName 
	 * 		y tambi�n se debe verificarSiLaCredencialCumpleConLosRequisitos para el password.
	 */
	public boolean nuevoUsuario(String userName, String password) {
		return false;
	}
	
	/****
	 * Este m�todo verifica que un usuario se puede loguear en el Sistema.
	 * @param userName - Nombre de usuario que se intenta loguear 
	 * @param password - Contrase�a con la que se intenta loguear
	 * @return Devuelve true si se pudo loguear o false en caso contrario 
	 */
	public boolean loguear(String userName, String password) {
		return false;
	}
	
	/****
	 * Este m�todo busca un usuario en el sistema.
	 * @param userName - Nombre de usuario que se est� buscando
	 * @return Devuelve al usuario en caso de encontrarlo o null en caso que el usuario no exista 
	 */
	public Usuario buscar(String userName) {
		return null;
	}
}
