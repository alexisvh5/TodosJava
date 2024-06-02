package ar.edu.unlam.pb1.dominio;

import java.util.Arrays;

public class Usuario {

	private String nombre;
	private String apellido;
	private String correo;
	private String contrasenia;
	private Juego[] misJuegos;

	public Usuario(String nombre, String apellido, String correo, String contrasenia) {
		// Daremos un espacio de 1000 juegos a cada nuevo usuario
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.misJuegos = new Juego[1000];
	}

	/////////////////////////////////////////////////// METODOS///////////////////////////////

	public boolean agregarAMisJuegos(Juego juego) {
		// TODO: Verificar no tener el juego adquirido ( Ver el metodo tengoElJuegoDe())
		// En caso de no tenerlo, se agrega el juego suministrado a los juegos del
		// usuario

		if (tengoElJuegoDe(juego.getId()) == false) {
			for (int i = 0; i < misJuegos.length; i++) {
				if (misJuegos[i] == null) {
					misJuegos[i] = juego;
					return true;
				}
			}
		}

		return false;
	}

	public boolean tengoElJuegoDe(int id) {
		// TODO: Verifica si tengo un juego con el id suministrado en mis juegos
		// Devuelve verdadero en caso de poseer el juego.

		boolean tengo = false;
		int i = 0;
		while (i < misJuegos.length) {
			if (misJuegos[i] != null && misJuegos[i].getId() == id) {
				tengo = true;
				i=misJuegos.length;
			} else {
				i++;
			}
		}
		return tengo;
	}

	public Juego obtenerJuegoMasJugadoPorCategoria(Categoria categoria) {
		// TODO: Revisa los juegos que cumplen con la categoria suministrada y obtiene
		// el
		// juego mas jugado de dicha categoria
		// Si no existe un juego para esa categoria, devuelve null
//		Juego ordenadoPorHoras = null;
//for (int i = 0; i < misJuegos.length; i++) {
//	for (int j = 0; j < misJuegos.length-1; j++) {
//		if ((misJuegos[j] != null && misJuegos[j + 1] != null)&&(misJuegos[j].getCategoria() == categoria)) {
//			if (misJuegos[j].getCategoria() == categoria) {
//				if (misJuegos[j].getCantidadDeHorasJugadas() < misJuegos[j + 1].getCantidadDeHorasJugadas()) {
//					ordenadoPorHoras = misJuegos[j + 1];
//					misJuegos[j + 1] = misJuegos[j];
//					misJuegos[j] = ordenadoPorHoras;
//				}
//			}
//
//		}
//	}
//	
//}
//		
//		return misJuegos[0];

		Juego juegoMasJugadoPorCategoria = null;

		for (int i = 0; i < misJuegos.length; i++) {
			if (misJuegos[i] != null && misJuegos[i].getCategoria()==categoria) {
				if (juegoMasJugadoPorCategoria == null || juegoMasJugadoPorCategoria
						.getCantidadDeHorasJugadas() < misJuegos[i].getCantidadDeHorasJugadas()) {
					juegoMasJugadoPorCategoria = misJuegos[i];
				}
			}
		}
		return juegoMasJugadoPorCategoria;
	}

	public Juego[] obtenerJuegosOrdenadosPorCategoria() {

		// TODO: Obtiene los juegos del usuario ordenados por categoria.

		Juego aux = null;

		for (int i = 0; i < misJuegos.length; i++) {
			for (int j = 0; j < misJuegos.length - 1; j++) {
				if (misJuegos[i] != null && misJuegos[i + 1] != null) {
					if (misJuegos[i].getCategoria().compareTo(misJuegos[i].getCategoria()) > 0) {
						aux = misJuegos[i + 1];
						misJuegos[i + 1] = misJuegos[i];
						misJuegos[i] = aux;
					}
				}
			}
		}

		return misJuegos;
	}

	//////////////////////////////////////////////////// geters y
	//////////////////////////////////////////////////// seters///////////////////////////////////////////
	public void jugarAlJuegoDe(int id) {
		// TODO: Revisa entre los juegos si alguno tiene el id suministrado. Si lo
		// encuentra, le agrega 1 hora y media (1.5) a la cantidad de horas jugadas.
		// Siempre deberia encontrar el juego con el id que llega como parametro
		int i=0;
		while (i< misJuegos.length) {
			if (misJuegos[i]!= null && misJuegos[i].getId() == id){
				misJuegos[i].setCantidadDeHorasJugadas(1.5); // es lo mismo que getCant + 1,5?
				i=misJuegos.length;
			}else {i++;}
		}

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

	public Juego[] getCantidadDeJuegosPosibles() {
		return misJuegos;
	}

	public void setCantidadDeJuegosPosibles(Juego[] cantidadDeJuegosPosibles) {
		this.misJuegos = cantidadDeJuegosPosibles;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", contrasenia="
				+ contrasenia + ", cantidadDeJuegosPosibles=" + Arrays.toString(misJuegos) + "]";
	}

}
