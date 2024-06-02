package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominio.Categoria;
import ar.edu.unlam.pb1.dominio.Juego;
import ar.edu.unlam.pb1.dominio.MenuPrincipal;
import ar.edu.unlam.pb1.dominio.MenuUsuario;
import ar.edu.unlam.pb1.dominio.Plataforma;
import ar.edu.unlam.pb1.dominio.Usuario;

public class PlataformaJuegos {
	private static final int SALIR = 99;
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Plataforma plataforma = new Plataforma();
		MenuPrincipal opcionMenuPrincipal = null;
		int numeroIngresado = 0;

		do {
			mostrarPorPantalla("\nHola! Que deseas hacer en la plataforma de juegos?");
			mostrarMenuPrincipal();

			numeroIngresado = ingresarNumeroEntero("\n\nIngrese opcion r:");
			if (numeroIngresado == 99) {
				opcionMenuPrincipal = MenuPrincipal.SALIR;
			} else {
				opcionMenuPrincipal = obtenerOpcionDeMenuPrincipal(numeroIngresado);
			}

			switch (opcionMenuPrincipal) {
			case INICIAR_SESION:

				iniciarSesionEn(plataforma);

				break;
			case REGISTRARME:
				registrarme(plataforma);
				break;

			case SALIR:
				mostrarPorPantalla("chauuuuuuuuuuuu");
				break;
			}

			// TODO: Complete la condicion para que el programa funcione correctamente
		} while (opcionMenuPrincipal != MenuPrincipal.SALIR);
	}

	private static void registrarme(Plataforma plataforma) {
		// TODO: Pide el ingreso de los datos necesarios para crear un usuario
		// Debe verificar que el correo sea valido y que no exista otro usuario
		// registrado en la plataforma con dicho correo (se sugiere buscar el usuario
		// por correo)
		// Una vez obtenidos los datos, se procede a registrar el usuario en la
		// plataforma mostrando un mensaje en caso de exito y otro en caso de error.

		String nombre = ingresarString("ingrese nombre");
		String apellido = ingresarString("ingrese apellido");
		String correo;
		do {
			correo = ingresarString("ingrese correo");

			if (!plataforma.esValidoEl(correo)) {
				mostrarPorPantalla(
						"el correo es invalido, tiene que tener un caracter arroba ('@') y terminar en \".com\"");
			}
			if (plataforma.buscarUsuarioConCorreo(correo) != null) {
				mostrarPorPantalla("el correo ya existe");
			}
		} while (!plataforma.esValidoEl(correo) || plataforma.buscarUsuarioConCorreo(correo) != null);

		String contrasenia = ingresarString("ingrese contrasenia");
		Usuario nuevoUser = new Usuario(nombre, apellido, correo, contrasenia);

		if (plataforma.registrarUsuario(nuevoUser)) {
			mostrarPorPantalla("¡Usuario registrado con éxito!");
		} else {
			mostrarPorPantalla("no se pudo che");
		}

	}

	private static void iniciarSesionEn(Plataforma plataforma) {
		mostrarPorPantalla("\n\nIniciemos sesion!");
		// TODO: Pide el ingreso de credenciales (usuario y contrasenia)
		// Verifica si con esas credenciales se puede iniciar sesion en la plataforma
		// Si el inicio de sesion es exitoso, se muestra un mensaje de exito y seguido
		// el menu del usuario (metodo menuUsuario() ), caso
		// contrario, se muestra el mensaje de error: "Usuario y/o contrasenia invalido"
		String usuario = ingresarString("ingrese el email del user");
		String contra = ingresarString("ingrese la contra");
		if (plataforma.iniciarSesion(usuario, contra) != null) {
			mostrarPorPantalla("bien! pudiste iniciar");
			menuUsuario(plataforma.iniciarSesion(usuario, contra), plataforma);
		} else {
			mostrarPorPantalla("no se pudo iniciar, quiza tengas que registrarte primero o pusiste mal algun dato");
		}

	}

	private static void menuUsuario(Usuario usuario, Plataforma plataforma) {
		MenuUsuario opcionMenuUsuario = null;
		int numeroIngresado = 0;

		do {
			mostrarMenuUsuario();
			numeroIngresado = ingresarNumeroEntero("\n\nIngrese opcion:");
			opcionMenuUsuario = obtenerOpcionDeMenuUsuario(numeroIngresado);
			int opcion = 0;

			switch (opcionMenuUsuario) {
			case MIS_JUEGOS:
				// TODO: Obtiene los juegos del usuario y los muestra.
				// Solicita el ingreso de un numero entero mostrando un mensaje. Dicho numero
				// corresponde con el ID de algun juego.
				// Se debe jugar al juego ingresado. Si se ingresa 99 se sale del menu actual.
				mostrarJuegos(usuario.obtenerJuegosOrdenadosPorCategoria());
				int id;

				do {
					id = ingresarNumeroEntero("\nIngrese id del juego para jugarlo o 99 para salir:");
					if (usuario.tengoElJuegoDe(id)) {
						usuario.jugarAlJuegoDe(id);
						mostrarPorPantalla("se jugo zarpado");
					}
					else if (id == 99) {
						System.out.println("chauuuuuuuu");}
				

				} while (id != SALIR);

				break;
			case TIENDA:

				do {
					mostrarJuegos(plataforma.getJuegos());
					mostrarMenuTienda();

					opcion = ingresarNumeroEntero("\nIngrese opcion:");
					if ((opcion >= 1 && opcion <= 10)) {
						Juego jueboAAdquirir = null;
						if (plataforma.obtenerJuegoPorSuId(opcion) != null) {
							jueboAAdquirir = plataforma.obtenerJuegoPorSuId(opcion);
						}
						if (usuario.agregarAMisJuegos(jueboAAdquirir)) {
							mostrarPorPantalla("you made it");
					} else {
						mostrarPorPantalla("no pudite, elegi bien el numero del 1 al 10");
					}
						
					
					}
					// TODO: Si el numero ingresado se encuentra entre 1 y 10 inclusive, entonces se
					// procede a adquirir el juego
					// Se sugiere obtener desde la plataforma el juego por su ID y luego agregarlo a
					// los juegos del usuario
					// Es necesario mostrar un mensaje de exito en caso de adquirir el juego.
					// Si no se pudo adquirir el juego, entonces mostrar el mensaje: "No fue posible
					// agregar el juego, verifica que no hayas adquirido antes."

				} while (opcion != SALIR);

				break;
			case JUEGO_MAS_JUGADO_POR_CATEGORIA:
				// TODO: Mostrar un titulo que indique para que categoria se mostrara el juego
				// mas jugado y luego mostrar el juego mas jugado de esa categoria.
				mostrarPorPantalla("\nel juego mas jugado para la categoria AVENTURA es "
						+ usuario.obtenerJuegoMasJugadoPorCategoria(Categoria.AVENTURA));
				mostrarPorPantalla("el juego mas jugado para la categoria ACCION es "
						+ usuario.obtenerJuegoMasJugadoPorCategoria(Categoria.ACCION));
				mostrarPorPantalla("el juego mas jugado para la categoria DEPORTES es "
						+ usuario.obtenerJuegoMasJugadoPorCategoria(Categoria.DEPORTES));
				break;
			case SALIR:
				break;
			}

		} while (!(opcionMenuUsuario == MenuUsuario.SALIR));

	}

	private static void mostrarJuego(Juego juego) {

		if (juego != null) {
			mostrarPorPantalla("\n" + juego.toString());
		} else {
			mostrarPorPantalla("\nSin juego");
		}
	}

	private static void mostrarJuegos(Juego[] juegos) {

		for (int i = 0; i < juegos.length; i++) {
			if (juegos[i] != null) {
				mostrarPorPantalla("\n" + juegos[i].toString());
			}
		}
	}

	private static MenuPrincipal obtenerOpcionDeMenuPrincipal(int numeroIngresado) {
		return MenuPrincipal.values()[numeroIngresado - 1];
	}

	private static MenuUsuario obtenerOpcionDeMenuUsuario(int numeroIngresado) {
		return MenuUsuario.values()[numeroIngresado - 1];
	}

	private static int ingresarNumeroEntero(String mensaje) {
		mostrarPorPantalla(mensaje);
		return teclado.nextInt();
	}

	private static String ingresarString(String mensaje) {
		mostrarPorPantalla(mensaje);
		return teclado.next();
	}

	private static void mostrarMenuTienda() {
		mostrarPorPantalla("\n\nIngrese el ID del juego que desea adquirir o 99 para salir:");
	}

	private static void mostrarMenuUsuario() {
		mostrarPorPantalla("\n\n1) Mis juegos\n2) Tienda\n3) Juego mas jugado por categoria\n4) Salir");
	}

	private static void mostrarMenuPrincipal() {
		mostrarPorPantalla("\n\n1) Iniciar sesion\n2) Registrame");
	}

	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}

}
