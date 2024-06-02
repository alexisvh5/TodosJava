package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;
import ar.edu.unlam.pb1.dominio.Bot;
import ar.edu.unlam.pb1.dominio.MenuPrincipal;
import ar.edu.unlam.pb1.dominio.Trading;

public class TradingBots {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		// Simulemos compras y ventas!
		mostrarPorPantalla("Simulemos compras y ventas!");
		int numeroIngresado = 0;
		MenuPrincipal opcionMenuPrincipal = null;
		Trading trading = null;

		do {
			mostrarMenuPrincipal();
			numeroIngresado = ingresarNumeroEntero("\n\nIngrese opcion:");
			opcionMenuPrincipal = obtenerOpcionDeMenuPrincipal(numeroIngresado);

			switch (opcionMenuPrincipal) {
			case INGRESAR_BOTS:
				// Ingresar la cantidad de bots, debiendo validar el numero ingresado para que este comprendido entre 3 y 20.
				// Agregar la cantidad de bots que fue ingresada anteriormente al sistema Trading
				// Para ingresar un bot por pantalla, utilizar el metodo "ingresarBot()"
				// Una vez generado el bot, se debera agregar al array de bots de la clase Trading mediante el metodo agregarBot()
				break;
			case SIMULAR_TRANSACCIONES:
				// Simular las transacciones invocando al metodo simularTransacciones() de la clase Trading 
				// Mostrar un mensaje que indique que se inicio la simulacion y otro que indique que se finalizo la tarea
				break;
			case BOTS_ORDENAMOS_POR_CRYPTO:
				// Obtener los bots ordenados consumiendo el metodo obtenerBotsOrdenamosPorCryptoDescendiente() de la clase Trading y mostrarlos 
				break;
			case PROMEDIO_TRANSACCIONES_VENTA:
				// Obtener el promedio del monto de las transacciones de venta consumiendo el metodo obtenerPromedioDeTransaccionesDeVenta() de la clase Trading y mostrarlo
				break;
			case SALIR:
				break;
			}

			// Completar la condicion para que funcione correctamente
		} while (false);

	}
	
	private static void mostrarBots(Bot[] bots) {
		for(int i = 0; i < bots.length; i++) {
			if(bots[i] != null) {
				mostrarPorPantalla(bots[i].toString());
			}
		}
	}

	private static MenuPrincipal obtenerOpcionDeMenuPrincipal(int numeroIngresado) {
		// Tomar del enum el valor correspondiente a la opcion ingresada
		return MenuPrincipal.values()[numeroIngresado - 1];
	}

	private static int ingresarNumeroEntero(String mensaje) {
		// Mostrar un mensaje y solicitar el ingreso del dato
		return teclado.nextInt();
	}

	private static String ingresarString(String mensaje) {
		// Mostrar un mensaje y solicitar el ingreso del dato
		return "";
	}

	private static double ingresarNumeroConDecimales(String mensaje) {
		// Mostrar un mensaje y solicitar el ingreso del dato
		return 0;
	}

	private static Bot ingresarBot(String mensaje) {
		// Mostrar un mensaje y devolver una instancia de Bot
		return null;
	}

	private static void mostrarMenuPrincipal() {
		mostrarPorPantalla(
				"\n\n#1: Ingresar Bots\n#2: Simular transacciones\n#3: Mostrar bots ordenados por cantidad de crypto\n#4: Obtener el valor promedio de las transacciones de venta\n#5: Salir");
	}

	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}
}
