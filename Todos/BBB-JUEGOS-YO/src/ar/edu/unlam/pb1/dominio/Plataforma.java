package ar.edu.unlam.pb1.dominio;

import java.util.Arrays;
import java.util.Iterator;

public class Plataforma {

	private Usuario[] usuarios;
	@Override
	public String toString() {
		return "Plataforma [usuarios=" + Arrays.toString(usuarios) + ", juegos=" + Arrays.toString(juegos) + "]";
	}

	private Juego[] juegos;

	public Plataforma() {
		this.usuarios = new Usuario[1000];
		this.juegos = new Juego[10];
		this.inicializarPlataforma(); // :)
	}

	public Usuario buscarUsuarioConCorreo(String correo) {
		// TODO:Busca un usuario entre los usuarios de la plataforma que tenga el correo
		// suministrado.
		// Si encuentra un usuario con ese correo, lo devuelve. Si NO encuentra un
		// usuario con ese correo, entonces devuelve null.
	
	 for (int i = 0; i < usuarios.length; i++) {
		if (usuarios[i] !=null && usuarios[i].getCorreo().equals(correo)) {
			return usuarios[i];
		}	
	}
		return null;
	}

	public Usuario iniciarSesion(String correo, String contrasenia) {
		// TODO: Obtiene un usuario buscandolo por su correo.
		// Si existe, verifica que la contrasenia sea correcta. Si asi es, devuelve el
		// usuario.
		// Si ningun usuario tiene ese correo o la contrasenia no coincide, debe devolver null
		
		Usuario usuarioEncontrado = null;
		
		if (buscarUsuarioConCorreo(correo) != null && buscarUsuarioConCorreo(correo).getContrasenia().equals(contrasenia)) {
			    usuarioEncontrado=buscarUsuarioConCorreo(correo);
				return usuarioEncontrado;
			}return null;
		}
			

	public boolean esValidoEl(String correo) {
		// TODO: Validar el correo. Para que el correo sea valido, tiene que tener un caracter arroba ('@') y terminar en ".com"
		
	if (correo.contains("@") && correo.endsWith(".com")) {
		return true;
	}
		return false;
	}

	public boolean registrarUsuario(Usuario usuario) {
		// TODO: Agregar un usuario a la plataforma.
		// En caso de exito, devuelve verdadero.
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
		// TODO: Busca entre los juegos de la plataforma si alguno tiene el id suministrado.
		// Si hay un juego con ese id, se devuelve el juego, caso contrario, se devuelve null
	 for (int i = 0; i < juegos.length; i++) {
		if (juegos[i] != null && juegos[i].getId() == id) {
			return juegos[i];
		}
	}
		return null;
		
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
