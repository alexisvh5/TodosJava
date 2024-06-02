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

		do {
			mostrarPorPantalla("\n Ingrese la contrasenia para continuar:");

			// TODO: completar el inicio de sesion y la validacion
			String contraseniaIngresada = teclado.next();
			sesionIniciada = false;

			if (contraseniaIngresada.equals(vivero.getContrasenia())) {
				sesionIniciada = true;
				System.out.println("BIENVENIDO!");
			}

		} while (sesionIniciada == false);

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

				agregarPlanta(vivero);

				break;
			case MODIFICAR_STOCK_PLANTA:
				// TODO: Solicitar el codigo y nuevo stock de la planta a la cual se le quiere
				// actualizar el stock e indicar con mensajes si fue posible realizar la
				// operacion

				modificarStockDePlantas(vivero);

				break;
			case BUSCAR_PLANTA_POR_CODIGO:
				// TODO: Ingresar el codigo de la planta para buscarla, en caso de existir
				// mostrarla, caso contrario indicar con un mensaje que no se encontro

				buscarPlantaPorCodigo(vivero);

				break;
			case BUSCAR_PLANTAS_QUE_CONTIENEN:
				// TODO: Ingresar el texto a buscar en los nombres de las plantas y mostrar las
				// que contenga el texto (se provee de un metodo mostrarPlantas())

				buscarPlantasQueContienen(vivero);

				break;
			case VENDER_PLANTA:
				// TODO: Se debe solicitar el ingreso del codigo y cantidad a vender de la
				// planta. Mostrar un mensaje de exito o error segun corresponda
				
				venderPlanta(vivero);

				break;
			case OBTENER_PLANTAS_DEL_TIPO:
				// TODO: Ingresar el tipo de planta utilizando el metodo
				// ingresarTipoDePlanta(MENU_TIPO_DE_PLANTA). Luego se debe obtener las plantas
				// de ese tipo y mostrarlas (se provee de un metodo mostrarPlantas())

				obtenerPlantasDelTipo(vivero);

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

	public static void venderPlanta(Vivero vivero) {
		int codigo;
		//para pruebas
		System.out.println(vivero.mostrarPlantas());
		
		codigo = ingresarNumeroEntero("Ingrese el codigo de la planta");
		int cantidadVendida = ingresarNumeroEntero("Ingrese la cantidad vendida");
		if (vivero.venderPlanta(codigo, cantidadVendida)) {
			System.out.println("Planta vendida!");
		} else {
			System.out.println("No se pudo realizar la operacion");
		}

		System.out.println("Saldo actual: " + Vivero.obtenerSaldo());
	}

	public static void agregarPlanta(Vivero vivero) {
		if (vivero.agregarPlanta(ingresarPlanta())) {
			System.out.println("Planta agregada!");
		} else
			System.out.println("No fue posible agregar la planta");
	}

	public static void buscarPlantasQueContienen(Vivero vivero) {
		Planta[] plantas;
		String plantaBuscada = ingresarString("Ingrese el nombre de la planta que desea buscar");
		plantas = vivero.buscarPlantasQueContienen(plantaBuscada);
		mostrarPlantas(plantas);
	}

	public static void obtenerPlantasDelTipo(Vivero vivero) {
		Planta[] plantas;
		TipoDePlanta tipoDePlantasAObtener = ingresarTipoDePlanta(MENU_TIPO_DE_PLANTA);
		plantas = vivero.obtenerPlantasDeTipoOrdenadasPorNombreAscendende(tipoDePlantasAObtener);
		mostrarPlantas(plantas);
	}

	public static void buscarPlantaPorCodigo(Vivero vivero) {
		int codigo;
		Planta planta;
		codigo = ingresarNumeroEntero("Ingrese el codigo de la planta");
		planta = vivero.buscarPlantaPorCodigo(codigo);
		if (planta == null) {
			System.out.println("La planta no existe o el código es erróneo");
		} else {
			System.out.println(planta);
		}
	}

	public static void modificarStockDePlantas(Vivero vivero) {
		int codigo;
		codigo = ingresarNumeroEntero("Ingrese el codigo de la planta");

		int stockIngresado = ingresarNumeroEntero("Ingrese el stock actualizado");
		if (vivero.modificarStockDePlantaPorCodigo(codigo, stockIngresado)) {
			System.out.println("Modificación exitosa");
		} else
			System.out.println("No existe esa planta, pruebe registrarla");
	}

	private static Planta ingresarPlanta() {
		// TODO: Solicitar el ingreso de los datos de una planta y devolver una
		// instancia de Planta. Considerar el uso del metodo
		// ingresarTipoDePlanta(MENU_TIPO_DE_PLANTA)

		System.out.println("Ingrese el codigo de la planta");
		int codigoDePLanta = teclado.nextInt();
		teclado.nextLine();

		System.out.println("Ingrese el nobmre de la planta");
		String nombreDePlanta = teclado.nextLine();

		System.out.println("Ingrese el precio de la planta");
		double precioDePlanta = teclado.nextDouble();

		System.out.println("Ingrese el stock actual de la planta");
		int stockDePlanta = teclado.nextInt();

		TipoDePlanta tipoDePlanta = ingresarTipoDePlanta(MENU_TIPO_DE_PLANTA);

		Planta nueva_planta = new Planta(codigoDePLanta, tipoDePlanta, nombreDePlanta, precioDePlanta, stockDePlanta);

		return nueva_planta;
	}

	private static MenuPrincipal obtenerOpcionDeMenuPrincipal(int numeroIngresado) {
		// TODO: Devolver la opcion seleccionada por el usuario existente en el enum
		if (numeroIngresado == 99) {
			return MenuPrincipal.SALIR;
		} else if (numeroIngresado >= 1 && numeroIngresado <= MenuPrincipal.values().length) {
			return MenuPrincipal.values()[numeroIngresado - 1];
		} else {
			mostrarPorPantalla("OPCION INVALIDA, reintentar");
			return obtenerOpcionDeMenuPrincipal(ingresarNumeroEntero("Ingrese una opcion valida:"));
		}
	}

	private static TipoDePlanta ingresarTipoDePlanta(String mensaje) {
		// TODO: Solicitar el ingreso de la opcion requerida y devolver la opcion del
		// enum

		mostrarPorPantalla(mensaje);
		int opcionElegida = teclado.nextInt();
		TipoDePlanta plantaElegida = TipoDePlanta.values()[opcionElegida - 1];

		return plantaElegida;
	}

	private static int ingresarNumeroEntero(String mensaje) {
		// TODO: Mostrar el mensaje y devolver el dato ingresado
		mostrarPorPantalla(mensaje);
		int numeroEntero = teclado.nextInt();
		return numeroEntero;
	}

	private static String ingresarString(String mensaje) {
		// TODO: Mostrar el mensaje y devolver el dato ingresado
		mostrarPorPantalla(mensaje);

		String stringIngresado = teclado.nextLine();

		return stringIngresado;
	}

	private static double ingresarDouble(String mensaje) {
		// TODO: Mostrar el mensaje y devolver el dato ingresado
		mostrarPorPantalla(mensaje);
		double numero = teclado.nextInt();
		return numero;
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
