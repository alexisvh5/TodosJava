package ar.edu.unlam.pb1.dominio;

public class Usuario {
	private String nombre;
	private String apellido;
	private String correo;
	private String contrasenia;
	private Juego[] juegosUsuario;

	public Usuario(String nombre, String apellido, String correo, String contrasenia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.juegosUsuario = new Juego[1000];
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCorreo() {
		return this.correo;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public boolean agregarAMisJuegos(Juego juego) {
		// TODO: Verificar no tener el juego adquirido ( Ver el metodo tengoElJuegoDe())
		// En caso de no tenerlo, se agrega el juego suministrado a los juegos del
		// usuario
		if (tengoElJuegoDe(juego.getId()) == false) {
			for (int i = 0; i < juegosUsuario.length; i++) {
				if (juegosUsuario[i] == null) {
					juegosUsuario[i] = juego;
					return true; // Juego agregado con éxito
				}
			}
		}
		return false;
	}

	public boolean tengoElJuegoDe(int id) {
		// TODO: Verifica si tengo un juego con el id suministrado en mis juegos
		// Devuelve verdadero en caso de poseer el juego.
		for (int i = 0; i < juegosUsuario.length; i++) {
			if (juegosUsuario[i] != null && juegosUsuario[i].getId() == id) {
				return true;
			}
		}
		return false;
	}

	public Juego obtenerJuegoMasJugadoPorCategoria(Categoria categoria) {
		// TODO: Revisa los juegos que cumplen con la categoria suministrada y obtiene
		// el
		// juego mas jugado de dicha categoria
		// Si no existe un juego para esa categoria, devuelve null

		Juego juegoMasJugadoPorCategoria = null;

		for (int i = 0; i < juegosUsuario.length; i++) {
			if (juegosUsuario[i] != null && juegosUsuario[i].getCategoria().equals(categoria)) {
				if (juegoMasJugadoPorCategoria == null
						|| juegoMasJugadoPorCategoria.getHorasJugadas() < juegosUsuario[i].getHorasJugadas()) {
					juegoMasJugadoPorCategoria = juegosUsuario[i];
				}
			}
		}
		return juegoMasJugadoPorCategoria;
	}

	public Juego[] obtenerJuegosOrdenadosPorCategoria() {

		Juego auxiliar;
		for (int i = 0; i < juegosUsuario.length - 1; i++) {
			for (int j = 0; j < juegosUsuario.length - 1; j++) {
				if (juegosUsuario[j] != null && juegosUsuario[j + 1] != null
						&& juegosUsuario[j].getId() > juegosUsuario[j + 1].getId()) {
					auxiliar = juegosUsuario[j];
					juegosUsuario[j] = juegosUsuario[j + 1];
					juegosUsuario[j + 1] = auxiliar;
				}
			}
		}
		return juegosUsuario;
	}

	public void jugarAlJuegoDe(int id) {
		// TODO: Revisa entre los juegos si alguno tiene el id suministrado. Si lo
		// encuentra, le agrega 1 hora y media (1.5) a la cantidad de horas jugadas.
		// Siempre deberia encontrar el juego con el id que llega como parametro
		if (tengoElJuegoDe(id) == true) {
			for (int i = 0; i < juegosUsuario.length; i++) {
				if (juegosUsuario[i] != null && juegosUsuario[i].getId() == id) {
					juegosUsuario[i].setHorasJugadas(1.5);
				}
			}
		}
	}

}
