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
	 * Guarda las características que deben tener los nombres de usuario en este sistema
	 * @param userNameConfiguration - Objeto de tipo credencial con las características que deben tener los nombres de usuario
	 */
	public void setUserNameConfiguration(Credencial userNameConfiguration) {
		
	}
	
	/***
	 * Guarda las características que deben tener los contraseñas en este sistema
	 * @param passwordConfiguration - Objeto de tipo credencial con las características que deben tener las contraseñas
	 */
	public void setPasswordConfiguration(Credencial passwordConfiguration) {
		
	}
	
	/***
	 * Este método agrega un nuevo usuario a la lista de usuarios del sistema. 
	 * @param userName Este parámetro identifica unívocamente al usuario del sistema.
	 * @param password Este parámetro identifica la contraseña del usuario.
	 * @return true si se  pudo agregar al usuario y false en caso contrario. 
	 * 		Es importante mencionar que NO se deben agregar usuarios que no cumplan con los requisitos (características) de 
	 * 		userName y password. Es decir se debe verificar verificarSiLaCredencialCumpleConLosRequisitos para el userName 
	 * 		y también se debe verificarSiLaCredencialCumpleConLosRequisitos para el password.
	 */
	public boolean nuevoUsuario(String userName, String password) {
		return false;
	}
	
	/****
	 * Este método verifica que un usuario se puede loguear en el Sistema.
	 * @param userName - Nombre de usuario que se intenta loguear 
	 * @param password - Contraseña con la que se intenta loguear
	 * @return Devuelve true si se pudo loguear o false en caso contrario 
	 */
	public boolean loguear(String userName, String password) {
		return false;
	}
	
	/****
	 * Este método busca un usuario en el sistema.
	 * @param userName - Nombre de usuario que se está buscando
	 * @return Devuelve al usuario en caso de encontrarlo o null en caso que el usuario no exista 
	 */
	public Usuario buscar(String userName) {
		return null;
	}
}
