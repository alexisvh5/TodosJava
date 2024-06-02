package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominio.MenuPrincipal;
import ar.edu.unlam.pb1.dominio.Planta;
import ar.edu.unlam.pb1.dominio.TipoDePlanta;
import ar.edu.unlam.pb1.dominio.Vivero;

public class GestionDeVivero {
	private static final int SALIR = 99;
	private static final String MENU_TIPO_DE_PLANTA = "\n\nIngrese el tipo de planta:\n1 - Hierba\n2 - Mata\n3 - Arbusto\n4 - Arbol";
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int numeroIngresado = 0;
		MenuPrincipal opcionMenuPrincipal = null;

		String nombreVivero = ingresarString("\nIngrese el nombre del vivero");

		int cantidadMacetas = ingresarNumeroEntero("\nIngrese la cantidad maxima de macetas");

		Vivero vivero = new Vivero(nombreVivero, cantidadMacetas);

		mostrarPorPantalla("\n\nLa contrasenia generada es: " + vivero.getContrasenia());

		boolean sesionIniciada = false;

		String contraseniaIngresada = "";

		do {
			mostrarPorPantalla("\n Ingrese la contrasenia para continuar:");
			// TODO: completar el inicio de sesion y la validacion
			contraseniaIngresada = teclado.next();
			sesionIniciada = vivero.iniciarSesion(contraseniaIngresada);
		} while (!sesionIniciada);

		do {
			mostrarPorPantalla("\n\n################################\nVivero " + vivero.getNombre());
			mostrarMenuPrincipal();
			numeroIngresado = ingresarNumeroEntero("\n\nIngrese opcion:");

			// TODO: Obtener la opcion del menu principal indicada por el usuario.
			// Considerar el caso de ingresar 99 (Salir)
			opcionMenuPrincipal = obtenerOpcionDeMenuPrincipal(numeroIngresado);

			int codigo = 0;
			Planta planta = null;
			Planta[] plantas = null;

			switch (opcionMenuPrincipal) {
			case AGREGAR_PLANTA:
				// TODO: Ingresar una planta utilizando el metodo ingresarPlanta() y luego
				// mostrar si fue posible o no realizar la accion
				planta = ingresarPlanta();
				boolean plantaIngresada = vivero.agregarPlanta(planta);

				if (plantaIngresada) {
					mostrarPorPantalla("\nPlanta ingresada!");
				} else {
					mostrarPorPantalla("\nPlanta NO ingresada.");
				}
				break;
			case MODIFICAR_STOCK_PLANTA:
				// TODO: Solicitar el codigo y nuevo stock de la planta a la cual se le quiere
				// actualizar el stock e indicar con mensajes si fue posible realizar la
				// operacion
				codigo = ingresarNumeroEntero("\nIngrese el codigo de la planta para modificar el stock");
				int stock = ingresarNumeroEntero("\nIngrese el nuevo stock");
				boolean plantaModificada = vivero.modificarStockDePlantaPorCodigo(codigo, stock);

				if (plantaModificada) {
					mostrarPorPantalla("\nStock de la planta modificado!");
				} else {
					mostrarPorPantalla("\nNo fue posible modificar el stock de la planta.");
				}
				break;
			case BUSCAR_PLANTA_POR_CODIGO:
				// TODO: Ingresar el codigo de la planta para buscarla, en caso de existir
				// mostrarla, caso contrario indicar con un mensaje que no se encontro
				codigo = ingresarNumeroEntero("\nIngrese el codigo de la planta para modificar el stock");
				planta = vivero.buscarPlantaPorCodigo(codigo);

				if (planta != null) {
					mostrarPorPantalla("La planta es: " + planta.toString());
				} else {
					mostrarPorPantalla("\nPlanta no encontrada");
				}

				break;
			case BUSCAR_PLANTAS_QUE_CONTIENEN:
				// TODO: Ingresar el texto a buscar en los nombres de las plantas y mostrar las
				// que contenga el texto (se provee de un metodo mostrarPlantas())
				String texto = ingresarString("\nIngrese el texto a buscar en el nombre de la planta");
				plantas = vivero.buscarPlantasQueContienen(texto);
				mostrarPlantas(plantas);
				break;
			case VENDER_PLANTA:
				// TODO: Se debe solicitar el ingreso del codigo y cantidad a vender de la
				// planta. Mostrar un mensaje de exito o error segun corresponda
				codigo = ingresarNumeroEntero("\nIngrese el codigo de la planta a vender");
				int cantidad = ingresarNumeroEntero("\nIngrese la cantidad a vender");
				
				if (vivero.venderPlanta(codigo, cantidad)) {
					mostrarPorPantalla("\nVenta realizada!");
				} else {
					mostrarPorPantalla("\nNo fue posible vender la/s planta/s.");
				}
				break;
			case OBTENER_PLANTAS_DEL_TIPO:
				// TODO: Ingresar el tipo de planta utilizando el metodo
				// ingresarTipoDePlanta(MENU_TIPO_DE_PLANTA). Luego se debe obtener las plantas
				// de ese tipo y mostrarlas (se provee de un metodo mostrarPlantas())
				TipoDePlanta tipoDePlanta = ingresarTipoDePlanta(MENU_TIPO_DE_PLANTA);
				plantas = vivero.obtenerPlantasDeTipoOrdenadasPorNombreAscendende(tipoDePlanta);
				mostrarPlantas(plantas);
				break;
			case SALIR:
				// TODO: Antes de salir, mostrar el estado actual del vivero para visualizar el
				// saldo
				mostrarPorPantalla(vivero.toString());
				mostrarPorPantalla("\n\nHasta luego!");
				break;
			}

			// TODO: Completar la condicion
		} while (!opcionMenuPrincipal.equals(MenuPrincipal.SALIR));

	}

	private static Planta ingresarPlanta() {
		// TODO: Solicitar el ingreso de los datos de una planta y devolver una
		// instancia de Planta. Considerar el uso del metodo
		// ingresarTipoDePlanta(MENU_TIPO_DE_PLANTA)

		int codigo = ingresarNumeroEntero("\nIngrese el codigo de la planta");
		TipoDePlanta tipoDePlanta = ingresarTipoDePlanta(MENU_TIPO_DE_PLANTA);
		String nombre = ingresarString("\ningrese el nombre de la planta");
		double precio = ingresarDouble("\nIngrese el precio de la planta");
		int stock = ingresarNumeroEntero("\nIngrese el stock de la planta");

		Planta planta = new Planta(codigo, tipoDePlanta, nombre, precio, stock);

		return planta;
	}

	private static MenuPrincipal obtenerOpcionDeMenuPrincipal(int numeroIngresado) {
		// TODO: Devolver la opcion seleccionada por el usuario existente en el enum

		MenuPrincipal opcionSeleccionada = null;

		// Salir 99
		if (numeroIngresado == SALIR) {
			opcionSeleccionada = MenuPrincipal.SALIR;
		} else {
			opcionSeleccionada = MenuPrincipal.values()[numeroIngresado - 1];
		}

		return opcionSeleccionada;
	}

	private static TipoDePlanta ingresarTipoDePlanta(String mensaje) {
		// TODO: Solicitar el ingreso de la opcion requerida y devolver la opcion del
		// enum
		int numeroIngresado = ingresarNumeroEntero(mensaje);
		TipoDePlanta opcionSeleccionada = TipoDePlanta.values()[numeroIngresado - 1];
		return opcionSeleccionada;
	}

	private static int ingresarNumeroEntero(String mensaje) {
		// TODO: Mostrar el mensaje y devolver el dato ingresado
		mostrarPorPantalla(mensaje);
		return teclado.nextInt();
	}

	private static String ingresarString(String mensaje) {
		// TODO: Mostrar el mensaje y devolver el dato ingresado
		mostrarPorPantalla(mensaje);
		return teclado.next();
	}

	private static double ingresarDouble(String mensaje) {
		// TODO: Mostrar el mensaje y devolver el dato ingresado
		mostrarPorPantalla(mensaje);
		return teclado.nextDouble();
	}

	private static void mostrarPlantas(Planta[] plantas) {

		for (int i = 0; i < plantas.length; i++) {
			if (plantas[i] != null) {
				mostrarPorPantalla(plantas[i].toString());
			}
		}
	}

	private static void mostrarMenuPrincipal() {
		mostrarPorPantalla(
				"\n\n1) Agregar planta\n2) Modificar stock de planta\n3) Buscar planta por su codigo\n4) Buscar plantas que en su nombre contienen"
						+ "\n5) Vender planta\n6) Mostrar plantas por tipo de planta\n\n" + SALIR + ") Salir");
	}

	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}

}
