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
		// TODO: completar el inicio de sesion y la validacion

		do {
			String contraseniaIngresada = ingresarString("Ingresa la contrasenia: ");
			if (contraseniaIngresada.equals(vivero.getContrasenia())) {
				mostrarPorPantalla("Bienvenido!");
				sesionIniciada = true;
			} else {
				mostrarPorPantalla("Contrasenia incorrecta");
			}
		} while (!sesionIniciada);
		
		

		do {
			mostrarPorPantalla("\n\n################################\nVivero " + vivero.getNombre());
			mostrarMenuPrincipal();
			numeroIngresado = ingresarNumeroEntero("\n\nIngrese opcion o 99 para salir:");

			// TODO: Obtener la opcion del menu principal indicada por el usuario.
			// Considerar el caso de ingresar 99 (Salir)

			if ( numeroIngresado  == 99||  MenuPrincipal.values()[numeroIngresado-1] == MenuPrincipal.SALIR) {
				opcionMenuPrincipal = MenuPrincipal.SALIR;
			} else {
				opcionMenuPrincipal = obtenerOpcionDeMenuPrincipal(numeroIngresado);
			}


			switch (opcionMenuPrincipal) {
			case AGREGAR_PLANTA:
				// TODO: Ingresar una planta utilizando el metodo ingresarPlanta() y luego
				// mostrar si fue posible o no realizar la accion
				vivero.agregarPlanta(ingresarPlanta());

				break;
			case MODIFICAR_STOCK_PLANTA:
				// TODO: Solicitar el codigo y nuevo stock de la planta a la cual se le quiere
				// actualizar el stock e indicar con mensajes si fue posible realizar la
				// operacion
				modificarStockDePlanta(vivero);

				break;
			case BUSCAR_PLANTA_POR_CODIGO:
				// TODO: Ingresar el codigo de la planta para buscarla, en caso de existir
				// mostrarla, caso contrario indicar con un mensaje que no se encontro
				int codi = ingresarNumeroEntero("\n\nIngrese codigo de la planta a buscar:");
				if (vivero.buscarPlantaPorCodigo(codi) != null) {
					mostrarPorPantalla("se pudo encontrar " + vivero.buscarPlantaPorCodigo(codi).toString());
				} else {
					mostrarPorPantalla("no se pudo encontrar ");
				}
				break;
				
				
			case BUSCAR_PLANTAS_QUE_CONTIENEN:
				// TODO: Ingresar el texto a buscar en los nombres de las plantas y mostrar las
				// que contenga el texto (se provee de un metodo mostrarPlantas())

				String textoABuscar = ingresarString("ingrese el texto a buscar:");
				if (vivero.buscarPlantasQueContienen(textoABuscar) != null) {
					mostrarPlantas(vivero.buscarPlantasQueContienen(textoABuscar));
				} else {
					mostrarPorPantalla("no se encontro una planta con eso en el nombre");
				}
				break;
			case VENDER_PLANTA:
				// TODO: Se debe solicitar el ingreso del codigo y cantidad a vender de la
				// planta. Mostrar un mensaje de exito o error segun corresponda
				int codig = ingresarNumeroEntero("\n\nIngrese codigo de la planta a buscar:");
				int cantidadAVender = ingresarNumeroEntero("\n\nIngrese la cantidad de plantas a vender:");
				if (vivero.venderPlanta(codig, cantidadAVender) == true) {
					mostrarPorPantalla("SE veNDIDOOO");
				} else {
					mostrarPorPantalla("no se vENDIO");
				}

				break;
			case OBTENER_PLANTAS_DEL_TIPO:
				// TODO: Ingresar el tipo de planta utilizando el metodo
				// ingresarTipoDePlanta(MENU_TIPO_DE_PLANTA). Luego se debe obtener las plantas
				// de ese tipo y mostrarlas (se provee de un metodo mostrarPlantas())
				
				TipoDePlanta tipoDePLanta=ingresarTipoDePlanta(MENU_TIPO_DE_PLANTA);
				
				mostrarPlantas(vivero.obtenerPlantasDeTipoOrdenadasPorNombreAscendende(tipoDePLanta));

				break;
			case SALIR:
				// TODO: Antes de salir, mostrar el estado actual del vivero para visualizar el
				// saldo
				mostrarPorPantalla("\n\nHasta luego!");
				break;
			}

			// TODO: Completar la condicion
		} while (opcionMenuPrincipal != MenuPrincipal.SALIR);

	}

	private static void modificarStockDePlanta(Vivero vivero) {
		int codigoIng = ingresarNumeroEntero("\n\nIngrese codigo de la planta a modificar:");
		int nuevoStok = ingresarNumeroEntero("\n\nIngrese nuevo stock:");

		vivero.modificarStockDePlantaPorCodigo(codigoIng, nuevoStok);
		if (vivero.modificarStockDePlantaPorCodigo(codigoIng, nuevoStok) == true) {
			mostrarPorPantalla("se pudo realizar la modificacion");
		} else {
			mostrarPorPantalla("no se pudo realizar la modificacion");
		}
	}

	private static Planta ingresarPlanta() {
		// TODO: Solicitar el ingreso de los datos de una planta y devolver una
		// instancia de Planta. Considerar el uso del metodo
		// ingresarTipoDePlanta(MENU_TIPO_DE_PLANTA)

		int codigoIngresado = ingresarNumeroEntero("ingrese el codigo de la planta a ingresar");

		TipoDePlanta tipoDePlantaIngresada = ingresarTipoDePlanta("ingrese el tipo de planta escribiendo \n"+MENU_TIPO_DE_PLANTA);

		String nombre = ingresarString("ingerse el nombre de la planta:");

		double precioBase = ingresarDouble("ingrese el precio:");

		int stock = ingresarNumeroEntero("ingrese el stock");

		Planta plantaNueva = new Planta(codigoIngresado, tipoDePlantaIngresada, nombre, precioBase, stock);

		mostrarPorPantalla("PERFECTO SE INGRESO");


		return plantaNueva;
	}

	private static MenuPrincipal obtenerOpcionDeMenuPrincipal(int numeroIngresado) {
		// TODO: Devolver la opcion seleccionada por el usuario existente en el enum

		return MenuPrincipal.values()[numeroIngresado - 1];
	}

	private static TipoDePlanta ingresarTipoDePlanta(String mensaje) {
		// TODO: Solicitar el ingreso de la opcion requerida y devolver la opcion del
		// enum
		mostrarPorPantalla(mensaje);

		String opcion = teclado.next();

		return TipoDePlanta.valueOf(opcion.toUpperCase());
	}

	private static int ingresarNumeroEntero(String mensaje) {
		// TODO: Mostrar el mensaje y devolver el dato ingresado
		System.out.println(mensaje);
		int option = teclado.nextInt();
		return option;
	}

	private static String ingresarString(String mensaje) {
		// TODO: Mostrar el mensaje y devolver el dato ingresado
		System.out.println(mensaje);

		String opcion = teclado.next();

		return opcion;
	}

	private static double ingresarDouble(String mensaje) {
		// TODO: Mostrar el mensaje y devolver el dato ingresado
		System.out.println(mensaje);
		double option = teclado.nextDouble();
		return option;

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
						+ "\n5) Vender planta\n6) Mostrar plantas por tipo de planta\n\n99) Salir");
	}

	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}

}
