package ar.edu.unlam.pb1.dominio;

public class Plataforma {

	private Usuario[] usuarios;
	private Juego[] juegos;

	public Plataforma() {
		this.usuarios = new Usuario[1000];
		this.juegos = new Juego[10];
		this.inicializarPlataforma(); // :)
	}
	
	public Usuario buscarUsuarioConCorreo(String correo) {
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null && usuarios[i].getCorreo().equals(correo)) {
				return usuarios[i];
			}
		} return null;
	}

	public Usuario iniciarSesion(String correo, String contrasenia) {
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null && usuarios[i].getCorreo().equals(correo)) {
				if (usuarios[i].getContrasenia().equals(contrasenia)) {
					return usuarios[i];
				}
			}
		} return null;
	}

	public boolean esValidoEl(String correo) {
		boolean correoValido = false;
		if (correo.contains("@") && correo.endsWith(".com")) {
				correoValido = true;
		}
		return correoValido;
	}

	public boolean registrarUsuario(Usuario usuario) {
		
		//Usuario nuevoUsuario = new Usuario(nombre, apellido, correo, contrasenia);
		//Plataforma.registrarUsuario(nuevoUsuario);
		
		if (esValidoEl(usuario.getCorreo()) == true && buscarUsuarioConCorreo(usuario.getCorreo()) == null) {
			for (int i = 0; i < usuarios.length; i++) {
		        if (usuarios[i] == null) {
		            usuarios[i] = usuario;
		            return true; // Registro exitoso, devuelve true
		        }
		    }
		} return false;
	}

	public Juego obtenerJuegoPorSuId(int id) {
		for (int i = 0; i < juegos.length; i++) {
			if (juegos[i].getId() == id) {
				return juegos[i];
			}
		} return null;
	}
	
	public Juego[] getJuegos() {
		return this.juegos;
	}

	private Juego crearJuego(int id, String nombre, Categoria categoria) {
		return new Juego(id, nombre + " " + id, categoria);
	}

	private void inicializarPlataforma() {

		String nombre = "";
		Categoria categoria;

		for (int i = 0; i < this.juegos.length; i++) {

			if (i < 3) {
				nombre = "Aventura";
				categoria = Categoria.AVENTURA;
			} else if (i < 7) {
				nombre = "Accion";
				categoria = Categoria.ACCION;
			} else {
				nombre = "Deportes";
				categoria = Categoria.DEPORTES;
			}

			this.juegos[i] = crearJuego((i + 1), nombre, categoria);
		}

	}

}
