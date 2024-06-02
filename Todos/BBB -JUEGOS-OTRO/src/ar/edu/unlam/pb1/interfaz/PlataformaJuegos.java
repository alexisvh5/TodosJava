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
	private static Usuario nuevoUsuario = null;

	public static void main(String[] args) {

		Plataforma plataforma = new Plataforma();
		MenuPrincipal opcionMenuPrincipal = null;
		int numeroIngresado = 0;

		do {
			mostrarPorPantalla("\nHola! Que deseas hacer en la plataforma de juegos?");

			do {
				mostrarMenuPrincipal();
				numeroIngresado = ingresarNumeroEntero("\n\nIngrese opcion:");
			} while (numeroIngresado < (MenuPrincipal.INICIAR_SESION.ordinal() + 1)
					|| numeroIngresado > (MenuPrincipal.SALIR.ordinal() + 1));

			opcionMenuPrincipal = obtenerOpcionDeMenuPrincipal(numeroIngresado);

			switch (opcionMenuPrincipal) {
			case INICIAR_SESION:
				iniciarSesionEn(plataforma);
				break;
			case REGISTRARME:
				registrarme(plataforma);
				break;
			case SALIR:
				mostrarPorPantalla("Usted ha salido de la plataforma. ");
				break;
			}

			// TODO: Complete la condicion para que el programa funcione correctamente
		} while (!opcionMenuPrincipal.equals(MenuPrincipal.SALIR));
	}

	private static void registrarme(Plataforma plataforma) {

		String nombre = ingresarString("Nombre: ");
		String apellido = ingresarString("Apellido: ");
		String correo;
		do {
			correo = ingresarString("Correo electrónico: ");
			if (!plataforma.esValidoEl(correo)) {
				mostrarPorPantalla("El correo es inválido. Reingresar");
			} else if (plataforma.buscarUsuarioConCorreo(correo) != null) {
				mostrarPorPantalla("El correo ya existe. Reingresar");
			}
		} while (!plataforma.esValidoEl(correo) || plataforma.buscarUsuarioConCorreo(correo) != null);
		String contrasenia = ingresarString("Contraseña: ");

		nuevoUsuario = new Usuario(nombre, apellido, correo, contrasenia);
		plataforma.registrarUsuario(nuevoUsuario);

		mostrarPorPantalla("¡Usuario registrado con éxito!");
	}

	private static void iniciarSesionEn(Plataforma plataforma) {

		String correo = "", contrasenia = "";

		if (nuevoUsuario != null) {
			mostrarPorPantalla("\n\nIniciemos sesion!");

			do {
				correo = ingresarString("Correo electrónico: ");
				contrasenia = ingresarString("Contraseña: ");
				plataforma.iniciarSesion(correo, contrasenia);
				if (plataforma.iniciarSesion(correo, contrasenia) == null) {
					mostrarPorPantalla("Datos incorrectos: No ha sido posible iniciar sesión. Reingresar");
				} else {
					mostrarPorPantalla("¡Sesión iniciada con éxito!");

					menuUsuario(nuevoUsuario, plataforma);

				}
			} while (plataforma.iniciarSesion(correo, contrasenia) == null);

		} else {
			mostrarPorPantalla("Primero debés registrarte. Por favor, registrarse");
		}

	}

	private static void menuUsuario(Usuario usuario, Plataforma plataforma) {
		MenuUsuario opcionMenuUsuario = null;
		int numeroIngresado = 0;

		do {
			do {
				mostrarMenuUsuario();
				numeroIngresado = ingresarNumeroEntero("\n\nIngrese opcion:");
			} while (numeroIngresado < (MenuUsuario.MIS_JUEGOS.ordinal() + 1)
					|| numeroIngresado > (MenuUsuario.SALIR.ordinal() + 1));
			opcionMenuUsuario = obtenerOpcionDeMenuUsuario(numeroIngresado);
			int opcion = 0;

			switch (opcionMenuUsuario) {

			case MIS_JUEGOS:

				if (nuevoUsuario.obtenerJuegosOrdenadosPorCategoria()[0] == null) {
					mostrarPorPantalla("Usted no tiene juegos comprados.");
				} else {
					mostrarJuegos(nuevoUsuario.obtenerJuegosOrdenadosPorCategoria());

					opcion = ingresarNumeroEntero("\nDesea jugar? \n1) Si \n2) No");

					if (opcion == 1) {
						int id = ingresarNumeroEntero("\nIngrese la ID del juego a jugar");
						do {
							nuevoUsuario.jugarAlJuegoDe(id);
							if (nuevoUsuario.tengoElJuegoDe(id) == true) {
								mostrarJuego(plataforma.obtenerJuegoPorSuId(id));
								opcion = ingresarNumeroEntero("Desea seguir jugando? \n1) Sí \n2) No");
							} else {
								id = ingresarNumeroEntero("\nUsted no tiene ese juego. Ingrese otra id: ");
							}
						} while (opcion != 2);
						mostrarJuego(plataforma.obtenerJuegoPorSuId(id));
					}
				}
				break;

			case TIENDA:

				do {
					mostrarJuegos(plataforma.getJuegos());
					mostrarMenuTienda();
					opcion = ingresarNumeroEntero("\nIngrese opcion:");

					if (opcion >= 1 && opcion <= 10) {
						if (nuevoUsuario.tengoElJuegoDe(opcion) == true) {
							mostrarPorPantalla(
									"No fue posible agregar el juego, verifica que no hayas adquirido antes.");
						} else {
							nuevoUsuario.agregarAMisJuegos(plataforma.obtenerJuegoPorSuId(opcion));
							mostrarPorPantalla("¡Gracias por su compra!");
						}
					} else if (opcion == SALIR) {
						mostrarPorPantalla("Has salido de la tienda, ¡hasta pronto!");
					} else {
						mostrarPorPantalla("Opción fuera de rango. Reingresar. ");
					}

					mostrarMenuTienda();

				} while (opcion != SALIR);

				break;
			case JUEGO_MAS_JUGADO_POR_CATEGORIA:

				Categoria categoria = Categoria.DEPORTES;

				do {

					opcion = menuJuegoMasJugadoPorCategoria();
					categoria = obtenerCategoria(opcion);

					mostrarPorPantalla("\nEl juego más jugado de la categoria " + categoria.name() + " es:");
					mostrarJuego(nuevoUsuario.obtenerJuegoMasJugadoPorCategoria(categoria));

					opcion = ingresarNumeroEntero("\nDesea visualizar otra categoria? \n1) Si \n2) No");

				} while (opcion != 2);

				break;

			case SALIR:
				break;
			}

		} while (!opcionMenuUsuario.equals(MenuUsuario.SALIR));

	}

	private static Categoria obtenerCategoria(int opcion) {
		Categoria categoria = Categoria.values()[opcion - 1];
		return categoria;
	}

	private static int menuJuegoMasJugadoPorCategoria() {
		int opcion;
		opcion = ingresarNumeroEntero("Seleccionar categoría: \n1) Aventura \n2) Acción \n3) Deportes");
		return opcion;
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
		mostrarPorPantalla("\n\n1) Iniciar sesion\n2) Registrame\n3) Salir");
	}

	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}

}
