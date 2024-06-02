package ar.edu.unlam.pb1.dominio;
import java.util.Arrays;
import java.util.Iterator;

public class Usuario {
	
	private String nombre;
	private String apellido;
	private String correo;
	private String contrasenia;
	private Juego[] misJuegos;

	public Usuario(String nombre, String apellido, String correo, String contrasenia) {
		// Daremos un espacio de 1000 juegos a cada nuevo usuario
		this.nombre=nombre;
		this.apellido=apellido;
		this.correo=correo;
		this.contrasenia=contrasenia;
		this.misJuegos=new Juego[1000];
		
	}

	public boolean agregarAMisJuegos(Juego juego) {
		// TODO: Verificar no tener el juego adquirido ( Ver el metodo tengoElJuegoDe())
		// En caso de no tenerlo, se agrega el juego suministrado a los juegos del usuario
		
		if (!tengoElJuegoDe(juego.getId())) {
			for (int i = 0; i < misJuegos.length; i++) {
				if (misJuegos[i]==null) {
					misJuegos[i]=juego;
					return true;
				}
			}
		}
		
		return false;
	}

	public boolean tengoElJuegoDe(int id) {
		// TODO: Verifica si tengo un juego con el id suministrado en mis juegos
		// Devuelve verdadero en caso de poseer el juego
		for (int i = 0; i < misJuegos.length; i++) {
			if (misJuegos[i] != null && misJuegos[i].getId() == id) {
			return true;
		}
		}
		
		return false;
	}

	public Juego obtenerJuegoMasJugadoPorCategoria(Categoria categoria) {
		// TODO: Revisa los juegos que cumplen con la categoria suministrada y obtiene el
		// juego mas jugado de dicha categoria
		// Si no existe un juego para esa categoria, devuelve null
		
		Juego juegoMasJugadoPorCategoria = null;

		for (int i = 0; i < misJuegos.length; i++) {
			if (misJuegos[i] != null && misJuegos[i].getCategoria().equals(categoria)) {
				if (juegoMasJugadoPorCategoria == null|| juegoMasJugadoPorCategoria.getHorasJugadas() < misJuegos[i].getHorasJugadas()) {
					juegoMasJugadoPorCategoria = misJuegos[i];
				}
			}
		}
		return juegoMasJugadoPorCategoria;
	}

	public Juego[] obtenerJuegosOrdenadosPorCategoria() {
		// TODO: Obtiene los juegos del usuario ordenados por categoria.

		Juego aux=null;
		
		for (int i = 0; i < misJuegos.length; i++) {
			for (int j = 0; j < misJuegos.length -1; j++) {
				if (misJuegos[j] != null && misJuegos[j + 1] != null &&
						misJuegos[j].getCategoria().compareTo(misJuegos[j+1].getCategoria()) > 1) {
					aux = misJuegos[j];
					misJuegos[j] = misJuegos[j + 1];
					misJuegos[j + 1] = aux;
					
			}}
		}
		
		return misJuegos;
		

	}

	public void jugarAlJuegoDe(int id) {
		// TODO: Revisa entre los juegos si alguno tiene el id suministrado. Si lo encuentra, le agrega 1 hora y media (1.5) a la cantidad de horas jugadas.
		// Siempre deberia encontrar el juego con el id que llega como parametro

		
			for (int i = 0; i < misJuegos.length; i++) {
			if ( misJuegos[i]!=null && tengoElJuegoDe(id)) {	
			misJuegos[i].setHorasJugadas(1.5);
			}
		}
	}
	
	
	
	//-------------------------------------------------------
	
	
	public void setMisJuegos(Juego[] misJuegos) {
		this.misJuegos = misJuegos;
	}

	public Juego[] getMisJuegos() {
		return misJuegos;
	}

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + this.nombre + ", apellido=" + this.apellido + ", correo=" + this.correo + ", misJuegos=" + Arrays.toString(misJuegos) + "]";
	}

}
