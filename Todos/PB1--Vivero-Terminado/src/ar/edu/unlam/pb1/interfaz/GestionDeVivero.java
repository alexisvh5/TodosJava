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

		String ss = vivero.generarContrasenia();
		
		mostrarPorPantalla("\n\nLa contrasenia generada es: " + vivero.getContrasenia());
		

		boolean sesionIniciada = false;

		do {
			mostrarPorPantalla("\n Ingrese la contrasenia para continuar:");
			// TODO: completar el inicio de sesion y la validacion
			String contrasenia = ingresarString("");

			if (contrasenia.equals(vivero.getContrasenia())) {
				sesionIniciada = true;
			} else {
				sesionIniciada = false;
			}

		} while (!sesionIniciada);
		
		
		// ----------------------------

		do {
			mostrarPorPantalla("\n\n\nVivero " + vivero.getNombre());
			
			
			
			mostrarMenuPrincipal();
			
			
			
			numeroIngresado = ingresarNumeroEntero("\n\nIngrese opcion:");

			// TODO: Obtener la opcion del menu principal indicada por el usuario.
			// Considerar el caso de ingresar 99 (Salir)
			
			
			if (numeroIngresado == SALIR) {
				opcionMenuPrincipal = MenuPrincipal.SALIR;
			} else {
				opcionMenuPrincipal = obtenerOpcionDeMenuPrincipal(numeroIngresado);
			}

			// int codigo = 0;
			Planta planta = null;
			Planta[] plantas = null;

			switch (opcionMenuPrincipal) {
			case AGREGAR_PLANTA:
				// TODO: Ingresar una planta utilizando el metodo ingresarPlanta() y luego
				// mostrar si fue posible o no realizar la accion

				planta = ingresarPlanta();
				boolean seAgrego = vivero.agregarPlanta(planta);
				if (seAgrego) {
					mostrarPorPantalla("Planta agregada!");
				} else {
					mostrarPorPantalla("La planta no pudo ser agregada");
				}

				break;
			case MODIFICAR_STOCK_PLANTA:
				// TODO: Solicitar el codigo y nuevo stock de la planta a la cual se le quiere
				// actualizar el stock e indicar con mensajes si fue posible realizar la
				// operacion

				int codigoPlanta = ingresarNumeroEntero("Ingrese codigo de la planta");
				int nuevoStock = ingresarNumeroEntero("Ingrese nuevo Stock");

				boolean seModifico = vivero.buscarPlantaPorCodigo(codigoPlanta).actualizarStock(nuevoStock);

				if (seModifico) {
					mostrarPorPantalla("Stock modificado");
				} else {
					mostrarPorPantalla("El stock no pudo ser modificado");
				}
				break;
			case BUSCAR_PLANTA_POR_CODIGO:
				// TODO: Ingresar el codigo de la planta para buscarla, en caso de existir
				// mostrarla, caso contrario indicar con un mensaje que no se encontro
				int buscarPlanta = ingresarNumeroEntero("Ingrese codigo de la planta");

				Planta plantaBuscada = vivero.buscarPlantaPorCodigo(buscarPlanta);

				if (plantaBuscada != null) {
					mostrarPorPantalla(plantaBuscada.toString());
				}
				break;
			case BUSCAR_PLANTAS_QUE_CONTIENEN:
				// TODO: Ingresar el texto a buscar en los nombres de las plantas y mostrar las
				// que contenga el texto (se provee de un metodo mostrarPlantas()
				String texto = ingresarString("Ingrese texto que contiene las plantas");
				Planta[] plantaTexto = vivero.buscarPlantasQueContienen(texto);

				mostrarPlantas(plantaTexto);
				break;
			case VENDER_PLANTA:
				// TODO: Se debe solicitar el ingreso del codigo y cantidad a vender de la
				// planta. Mostrar un mensaje de exito o error segun corresponda

				int codigoplanta = ingresarNumeroEntero("ingrese codigo de planta");
				int cantidadAVender = ingresarNumeroEntero("Cantidad a vender");

				boolean seVendio = vivero.venderPlanta(codigoplanta, cantidadAVender);

				if (seVendio) {
					mostrarPorPantalla("Planta vendida");
				} else {
					mostrarPorPantalla("La planta no pudo ser venidida, codigo y/o falta de stock");
				}
				break;
			case OBTENER_PLANTAS_DEL_TIPO:
				// TODO: Ingresar el tipo de planta utilizando el metodo
				// ingresarTipoDePlanta(MENU_TIPO_DE_PLANTA). Luego se debe obtener las plantas
				// de ese tipo y mostrarlas (se provee de un metodo mostrarPlantas())

				TipoDePlanta obtener = ingresarTipoDePlanta("Ingrese tipo de planta (HIERBA, MATA, ARBUSTO, ARBOL)");

				Planta[] tiposDeplantas = vivero.obtenerPlantasDeTipoOrdenadasPorNombreAscendende(obtener);

				mostrarPlantas(tiposDeplantas);
				break;
			case SALIR:
				// TODO: Antes de salir, mostrar el estado actual del vivero para visualizar el
				// saldo
				mostrarPorPantalla("Estado del viviero \n" + vivero.toString());
				mostrarPorPantalla("\n\nHasta luego!");
				break;
			}

			// TODO: Completar la condicion
		} while (opcionMenuPrincipal != MenuPrincipal.SALIR);

	}

	private static Planta ingresarPlanta() {
		// TODO: Solicitar el ingreso de los datos de una planta y devolver una
		// instancia de Planta. Considerar el uso del metodo
		// ingresarTipoDePlanta(MENU_TIPO_DE_PLANTA)

		int codigo = ingresarNumeroEntero("Ingrese codigo");
		TipoDePlanta tipo = ingresarTipoDePlanta("Ingrese planta (HIERBA, MATA, ARBUSTO, ARBOL)");
		String nombre = ingresarString("Ingrese nombre de la planta");
		double precioBase = ingresarDouble("ingrese el precio base de la planta");
		int stock = ingresarNumeroEntero("Ingrese stock");

		Planta planta = new Planta(codigo, tipo, nombre, precioBase, stock);

		return planta;
	}

	private static MenuPrincipal obtenerOpcionDeMenuPrincipal(int numeroIngresado) {
		// TODO: Devolver la opcion seleccionada por el usuario existente en el enum

		return MenuPrincipal.values()[numeroIngresado - 1];
	}

	private static TipoDePlanta ingresarTipoDePlanta(String mensaje) {
		// TODO: Solicitar el ingreso de la opcion requerida y devolver la opcion del
		// enum
		mostrarPorPantalla(mensaje);

		String planta = teclado.next();
		TipoDePlanta tipo = TipoDePlanta.valueOf(planta.toUpperCase());

		return tipo;
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
						+ "\n5) Vender planta\n6) Mostrar plantas por tipo de planta\n\n99) Salir");
	}

	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}

}
