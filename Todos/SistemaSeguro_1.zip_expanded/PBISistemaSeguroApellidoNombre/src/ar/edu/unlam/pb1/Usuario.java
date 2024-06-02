package ar.edu.unlam.pb1;

public class Usuario {
	
	/****
	 * Determina si un usuario est� logueado en el sistema
	 * @return Devuelve true si est� logueado o false en caso contrario 
	 */
	private String nombre ;
	private String contrasenia;
	private final int INTENTOSMAX =3;
	private int intentos;
	private boolean logueado;
	
	public Usuario(String nombre, String contrasenia) {
	this.nombre=nombre;
	this.contrasenia=contrasenia;
	this.intentos=0;
	this.logueado=false;
	};
	
	public boolean isLogueado() {
		
		return this.logueado;
	}
	
	public void setLog(Boolean verdad) {
		this.logueado=verdad;
	}
	

	/****
	 * Determina si un usuario est� bloqueado
	 * @return Devuelve true si est� bloqueado o false en caso contrario 
	 */
	public boolean isBloqueado() {
		if (intentos==INTENTOSMAX) {
			return true;
		}
		return false;
	}
	
	/****
	 * Intenta loguearse al Sistema. Devuelve true si se pudo loguear o false en caso contrario.
	 * Es importante tener en cuenta que si se supera la cantidad de intentos m�ximos el usuario debe quedar bloqueado
	 * @param userName - Nombre de usuario que se intenta loguear 
	 * @param password - Contrase�a con la que se intenta loguear
	 * @return Devuelve true si se pudo loguear o false en caso contrario 
	 */
	public boolean loguear(String userName, String password) {
		boolean log=false;
		isLogueado();
		
		if (!isBloqueado() && this.nombre.equalsIgnoreCase(userName) && this.contrasenia.equalsIgnoreCase(password)) {
			log= true;
			setLog(true);
		}else {
			setIntentos();
		}
		
		return log;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setIntentos() {
		this.intentos++;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contrasenia=" + contrasenia + ", INTENTOSMAX=" + INTENTOSMAX
				+ ", intentos=" + intentos + ", logueado=" + logueado + "]";
	}
	
}
