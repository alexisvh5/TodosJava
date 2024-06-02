package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominio.Tienda;
import ar.edu.unlam.pb1.dominio.Vendible;
import ar.edu.unlam.pb1.dominio.enums.TipoDeVendible;
import ar.edu.unlam.pb1.interfaz.enums.MenuPrincipal;

public class GestionDeTienda {

	private static final Scanner TECLADO = new Scanner(System.in);

	public static void main(String[] args) {
		MenuPrincipal opcionMenuPrincipal = null;
		Tienda tienda = new Tienda("T001", "Tienda 1");

		do {
			mostrarMenuPrincipal();

			mostrarPorPantalla("\n\n" + tienda.getRazonSocial());

			opcionMenuPrincipal = obtenerOpcionDeEnumParaMenuPrincipal();

			switch (opcionMenuPrincipal) {
			case BUSCAR_VENDIBLES_CUYO_CODIGO_INICIA_CON_TEXTO:
				buscarVendiblesCuyoCodigoIniciaContexto(tienda);
				break;
			case CREAR_VENTA_DE_PRODUCTOS_O_SERVICIOS:
				crearVentaDeProductosOServicios(tienda);
				break;
			case OBTENER_CANTIDAD_DE_SERVICIOS_EN_VENTAS:
				obtenerCantidadDeServiciosEnVentas(tienda);
				break;
			case OBTENER_PRODUCTOS_CON_STOCK_MAXIMO_ORDENADOS_POR_PRECIO_DESCENDENTE:
				obtenerProductosConStockMaximoOrdenadosPorPrecioPrescendente(tienda);
				break;
			case SALIR:
				mostrarPorPantalla("\n\nHasta luego!");
				break;
			}

		} while (opcionMenuPrincipal != MenuPrincipal.SALIR);

	}

	private static void buscarVendiblesCuyoCodigoIniciaContexto(Tienda tienda) {
		// TODO: Solicitarle al usuario el ingreso del texto que se usara para buscar en
		// el comienzo del codigo de cada vendible. Mostrar los vendibles que cumplan
		// con la busqueda.
		String texto = ingresarString("ingrese el texto que empieza el codigo del P/S");
		mostrarVendibles(tienda.buscarVendiblesCuyoCodigoIniciaConTexto(texto));

	}

	private static void crearVentaDeProductosOServicios(Tienda tienda) {
		// TODO: Solicitar al usuario el ingreso del cliente y el vendedor, para luego
		// proceder a agregar los vendibles que seran parte de la venta.
		// Se debe permitir al usuario ingresar la cantidad de vendibles que quiera,
		// pero con un maximo de 1000. Se deberán mostrar los vendibles para que el
		// usuario pueda elegir cual es el que desea incluir en la venta, ingresando su
		// codigo.
		// Si se quiere continuar agregando vendibles a la venta, se debera indicar
		// mediante el ingreso del caracter 's'. En caso de no querer continuar con el
		// agregado de vendigles a la venta, se debera ingresar el caracter 'n'.
		// Con el vendedor, cliente y vendibles ingresados, se debe proceder a la
		// creacion de la venta (ver el metodo crearVentaDeProductosOServicios() de la
		// Tienda). En caso de que la venta se concrete, mostrar un mensaje de exito,
		// caso contrario, mostrar un mensaje que indique que la venta fue cancelada.
		String cliente = ingresarString("Ingrese el cliente:");
		String vendedor = ingresarString("Ingrese al vendedor:");
		Vendible[] arrayDeVendibles = new Vendible[1000];
		char caracter = 's';
		int cantidadDeVendiblesAgregados = 0;

		do {
			mostrarVendibles(tienda.obtenerProductosConStockMaximoOrdenadosPorPrecioDescendente());
			String codigoDeVendibleAAgregar = ingresarString("Ingrese el vendible que quiere agregar a la venta ingresando su codigo:");

			if (tienda.obtenerVendiblePorCodigo(codigoDeVendibleAAgregar) != null) {
				for (int i = 0; i < arrayDeVendibles.length; i++) {
					if (arrayDeVendibles[i] == null) {
						arrayDeVendibles[i] = tienda.obtenerVendiblePorCodigo(codigoDeVendibleAAgregar);
					}
				}
			}
			caracter = ingresarChar("Ingrese S para seguir agregando vendibles a la venta o N para no agregar ninguno mas:");
			cantidadDeVendiblesAgregados++;
		} while (cantidadDeVendiblesAgregados <= 1000 && caracter != 'n');

		if (tienda.crearVentaDeProductosOServicios(cliente, vendedor, arrayDeVendibles) == true) {
			mostrarPorPantalla("Se pudo crear la venta.");
		} else {
			mostrarPorPantalla("La venta fue cancelada");
		}
	}

	private static void obtenerCantidadDeServiciosEnVentas(Tienda tienda) {
		int cantidadServiciosEnVentas = tienda.obtenerCantidadDeServiciosEnVentas();
		mostrarPorPantalla("\nLa cantidad de servicios en ventas es: " + cantidadServiciosEnVentas);
	}

	private static void obtenerProductosConStockMaximoOrdenadosPorPrecioPrescendente(Tienda tienda) {
		Vendible[] vendibles = tienda.obtenerProductosConStockMaximoOrdenadosPorPrecioDescendente();
		mostrarVendibles(vendibles);
	}

	private static void mostrarMenuPrincipal() {
		// TODO: Mostrar el menu principal de manera dinamica utilizando las opciones
		// del enum.
		// La presentacion de las opciones debe ser una debajo de otra, comenzando con
		// el numero 1 como primera opcion.
		// Ejemplo:
		// "1) BUSCAR_VENDIBLES_CUYO_CODIGO_INICIA_CON_TEXTO"
		// "2) CREAR_VENTA_DE_PRODUCTOS_O_SERVICIOS"
		for (int i = 0; i < MenuPrincipal.values().length; i++) {
			mostrarPorPantalla("\n" + (i + 1) + ") " + MenuPrincipal.values()[i]);
		}
	}

	private static TipoDeVendible obtenerOpcionDeEnumParaTipoDeVendible() {
		// TODO: Solicitar al usuario el ingreso de la opcion requerida para el
		// TipoDeVendible (PRODUCTO o SERVICIO) deseado y devolverla.
		// Se debe validar que el usuario ingrese una opcion valida, caso contrario se
		// debe continuar mostrando las opciones y solicitando el ingreso.
		int numeroIngresado = 0;
		do {
			mostrarPorPantalla("Ingrese el número correspondiente a la opción deseada:");
			numeroIngresado = TECLADO.nextInt();

			if (numeroIngresado < 1 || numeroIngresado > TipoDeVendible.values().length) {
				mostrarPorPantalla("Opción inválida. Intente nuevamente.");
			}
		} while (numeroIngresado < 1 || numeroIngresado > TipoDeVendible.values().length);

		TipoDeVendible opcionMenuPrincipal = TipoDeVendible.values()[numeroIngresado - 1];
		return opcionMenuPrincipal;
	}

	private static MenuPrincipal obtenerOpcionDeEnumParaMenuPrincipal() {
		// TODO: Obtener la opcion seleccionada por el usuario del menu principal. Se
		// debe validar que la opcion ingresada por el usuario, se encuentre entre las
		// disponibles.
		int numeroIngresado;
		do {

			numeroIngresado = ingresarNumeroEntero("Ingrese el número correspondiente a la opción deseada:");

			if (numeroIngresado < 1 || numeroIngresado > MenuPrincipal.values().length) {
				mostrarPorPantalla("Opción inválida. Intente nuevamente.");
			}
		} while (numeroIngresado < 1 || numeroIngresado > MenuPrincipal.values().length);

		MenuPrincipal opcionMenuPrincipal = MenuPrincipal.values()[numeroIngresado - 1];
		return opcionMenuPrincipal;

	}

	private static int ingresarNumeroEntero(String mensaje) {
		mostrarPorPantalla(mensaje);
		return TECLADO.nextInt();
	}

	private static String ingresarString(String mensaje) {
		mostrarPorPantalla(mensaje);
		return TECLADO.next();
	}

	private static char ingresarChar(String mensaje) {

		mostrarPorPantalla(mensaje);
		return TECLADO.next().toLowerCase().charAt(0);
	}

	private static void mostrarVendibles(Vendible[] vendibles) {
		for (int i = 0; i < vendibles.length; i++) {
			if (vendibles[i] != null) {
				mostrarPorPantalla("\n" + vendibles[i].toString());
			}
		}
	}

	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}
}
