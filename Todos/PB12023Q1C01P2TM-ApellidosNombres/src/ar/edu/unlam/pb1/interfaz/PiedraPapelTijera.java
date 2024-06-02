package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominio.Juego;
import ar.edu.unlam.pb1.dominio.Jugador;
import ar.edu.unlam.pb1.dominio.MenuAdministrador;
import ar.edu.unlam.pb1.dominio.MenuPrincipal;

public class PiedraPapelTijera {
	private static final Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		mostrarPorPantalla("Piedra papel o tijera!");
		int numeroIngresado = 0;
		MenuPrincipal opcionMenuPrincipal = null;
		Juego piedraPapelTijera = new Juego();

		do {
			mostrarMenuPrincipal();
			numeroIngresado = ingresarNumeroEnteroValidado("ingrese la opcion :", 1, 2);

			opcionMenuPrincipal = obtenerOpcionDeMenuPrincipal(numeroIngresado);

			switch (opcionMenuPrincipal) {
			case JUGAR:
				jugar(piedraPapelTijera);
				break;
			case STATS:
				gestionarEstadisticas(piedraPapelTijera);
				break;
			case SALIR:
				break;
			}

			// Completar la condicion para continuar
		} while (opcionMenuPrincipal != MenuPrincipal.SALIR);

	}

	private static void jugar(Juego piedraPapelTijera) {
		// Ingrese la cantidad de rondas validando que sea al menos 1 y siempre impar
		// Ingresar el jugador uno
		// Ingresar el jugador dos
		// Jugar
		// Mostrar al ganador
		
		int cantRondas=0;
		do {
			System.out.println("ingrese cantidad de rondas");
			cantRondas=teclado.nextInt();
			if ((cantRondas%2==0) && (cantRondas<1)) {
				System.out.println("ingrese bien eñ valor, impar y mayor o igual q uno");
			}
		} while ((cantRondas%2==0) && (cantRondas<1));
		
		Jugador jugador1 = ingresarJugador("ingresando jugador1: ",piedraPapelTijera);
		Jugador jugador2 = ingresarJugador("ingresando jugador2: ",piedraPapelTijera);
		
		if (piedraPapelTijera.jugar(jugador1, jugador2, cantRondas)!=null) {
			mostrarPorPantalla("ganador : "+piedraPapelTijera.jugar(jugador1, jugador2, cantRondas));
		}else {mostrarPorPantalla("hubo un error");}
	}

	private static void gestionarEstadisticas(Juego piedraPapelTijera) {
		// Mostrar el menu de estadisticas
		// Ingresar un numero validado entre 1 y 3
		// En caso de seleccionar Tabla actual, mostrar la tabla de jugadores ordenados
		// por puntos de manera descendente
		// En caso de ver el promedio de puntajes, solicitarlo al juego y mostrarlo
	}

	private static void mostrarTablaJugadores(String mensaje, Jugador[] jugadores) {
		mostrarPorPantalla(mensaje);

		for (int i = 0; i < jugadores.length; i++) {

			if (jugadores[i] != null) {
				mostrarPorPantalla("\n" + jugadores[i].toString());
			}

		}
	}

	private static MenuPrincipal obtenerOpcionDeMenuPrincipal(int numeroIngresado) {
		// Obtener la opcion del menu correspondiente al valor ingresado
		return MenuPrincipal.values()[numeroIngresado -1 ];
	}

	private static MenuAdministrador obtenerOpcionDeMenuAdministrador(int numeroIngresado) {
		// Obtener la opcion del menu correspondiente al valor ingresado
		return MenuAdministrador.values()[numeroIngresado -1 ];
	}

	private static int ingresarNumeroEnteroValidado(String mensaje, int valorMinimo, int valorMaximo) {
		// Mostrar el mensaje por pantalla y validar el numero ingresado para que este
		// dentro de los parametros
		
		System.out.println(mensaje);
		int opcion=0;
		do {
			opcion = teclado.nextInt();
			if(opcion<valorMinimo || opcion>valorMaximo) {
				System.out.println("ingresa un nium valido");
			}
		} while (opcion<valorMinimo || opcion>valorMaximo);
		
		return opcion;
	}

	private static void mostrarMenuPrincipal() {
		mostrarPorPantalla("\n\n1 -> Jugar 1 vs 1\n2 -> Ver stats\n3 -> Salir");
	}

	private static void mostrarMenuStats() {
		mostrarPorPantalla("\n\n1 -> Tabla actual\n2 -> Promedio de puntaje\n3 -> Volver");
	}

	private static Jugador ingresarJugador(String mensaje, Juego piedraPapelTijera) {
		// Solicitar el nombre del jugador
		// Obtener el jugador mediante el metodo
		// piedraPapelTijera.obtenerPorNombre(nombreJugador)
		// Si el jugador no existe, entonces instanciar un nuevo jugador, solicitando el
		// proximo id al juego
		mostrarPorPantalla(mensaje);
		System.out.println("ingerse el nombre del jugador : ");
		String nombre = teclado.next();
		
		Jugador jugadorBuscado = null;
		int id=Juego.obtenerSiguienteId();
		if (piedraPapelTijera.obtenerPorNombre(nombre)==null) {
			id++;
			jugadorBuscado = new Jugador(id,nombre);
		}
		else {
			jugadorBuscado =piedraPapelTijera.obtenerPorNombre(nombre);
		}
		
		
		return jugadorBuscado;
	}

	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}
}
