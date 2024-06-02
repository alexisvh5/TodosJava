package ar.edu.unlam.pb1.interfaz;

import ar.edu.unlam.pb1.dominio.*;
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
		Vendible[] vendiblesEncontrados = null;
		String textoAbuscar = ingresarString("ingrese el texto");
		if (tienda.buscarVendiblesCuyoCodigoIniciaConTexto(textoAbuscar) != null) {
			vendiblesEncontrados = tienda.buscarVendiblesCuyoCodigoIniciaConTexto(textoAbuscar);
			mostrarVendibles(vendiblesEncontrados);
		} else {
			mostrarPorPantalla("no se enconrto ni aca");
		}
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

		Vendible[] arrayVendidosElegidos = new Vendible[1000];
		int contador = 0;
		String nombreCliente = ingresarString("ingrese el nombre del cliente:");
		String nombreVendedor = ingresarString("ingerse el nombre del vendedor:");
		String codigo = "";
		String opcion = "";
		boolean salir = false;
		do {
			mostrarVendibles(tienda.getVendibles());

			do {
				codigo = ingresarString("\n ingrese el codigo del vendible a comprar");

				if (tienda.obtenerVendiblePorCodigo(codigo) != null) {
					arrayVendidosElegidos[contador] = tienda.obtenerVendiblePorCodigo(codigo);
					mostrarPorPantalla("perfecto, se agrego");
					salir = true;
					
				} else {
					mostrarPorPantalla("no existe ese codigo");
				}
				
				
				contador++;

			} while (!salir);
			
				opcion = ingresarString("queres seguir agregando ventas? S/N").toUpperCase();

		} while (opcion.charAt(0) != 'N');
		
		tienda.crearVentaDeProductosOServicios(nombreCliente, nombreVendedor, arrayVendidosElegidos);
if (		tienda.crearVentaDeProductosOServicios(nombreCliente, nombreVendedor, arrayVendidosElegidos)) {
		mostrarVentas(tienda.getVentas());
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
			System.out.println((MenuPrincipal.values()[i].ordinal() + 1) + ") " + MenuPrincipal.values()[i]);
		}

	}

	private static TipoDeVendible obtenerOpcionDeEnumParaTipoDeVendible() {
		// TODO: Solicitar al usuario el ingreso de la opcion requerida para el
		// TipoDeVendible (PRODUCTO o SERVICIO) deseado y devolverla.
		// Se debe validar que el usuario ingrese una opcion valida, caso contrario se
		// debe continuar mostrando las opciones y solicitando el ingreso.
		return null;
	}

	private static MenuPrincipal obtenerOpcionDeEnumParaMenuPrincipal() {
		// TODO: Obtener la opcion seleccionada por el usuario del menu principal. Se
		// debe validar que la opcion ingresada por el usuario, se encuentre entre las
		// disponibles.
		MenuPrincipal opcionMenu = null;
		int opcion = 0;
		do {

			opcion = ingresarNumeroEntero("ingerse una opcion ");
		} while (opcion < MenuPrincipal.min() || opcion > MenuPrincipal.max());

		opcionMenu = MenuPrincipal.values()[opcion - 1];

		return opcionMenu;
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
				mostrarPorPantalla("\n" + vendibles[i]);
			}
		}
	}

	private static void mostrarVentas(Venta[] ventas) {
		for (int i = 0; i < ventas.length; i++) {
			if (ventas[i] != null) {
				mostrarPorPantalla("\n" + ventas[i]);
			}
		}
	}

	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}
}

// venta
//String cliente = ingresarString("ingrese el nombre del cliente");
//String vendedor = ingresarString("ingrese el nombre del vendedor");
//
//int numero= ingresarNumeroEntero("ingers cantidad de vendibles");
//
//String codi ;
//char caract = ' ';
//
//
//Vendible[] estosVendibles = null;
//if (numero<=1000) {
//estosVendibles = new Vendible[numero];
//
//
//do {
//mostrarVendibles(tienda.getVendibles());
//codi= ingresarString("ingrese el codigo que quiere a;aodir");
//for (int i = 0; i < estosVendibles.length; i++) {
//if (estosVendibles[i]==null) {
//estosVendibles[i]=tienda.obtenerVendiblePorCodigo(codi.toUpperCase());
//}
//}caract=ingresarChar("ingresar n para seguir o r pra salir");
//} while (tienda.obtenerVendiblePorCodigo(codi.toUpperCase())==null || caract != 'r');
//
//
//
//if (tienda.crearVentaDeProductosOServicios(cliente, vendedor, estosVendibles)) {
//mostrarPorPantalla("Se pudo crear la venta.");
//} else {
//mostrarPorPantalla("La venta fue cancelada");
//}
//
//
//
//}else {System.out.println("te pasaste");};
//
//
//
//
//
//
//String texto = ingresarString("ingrese el texto");
//tienda.buscarVendiblesCuyoCodigoIniciaConTexto(texto);

//
//
//int tipoMenu = 0;
// 
//do {
//	tipoMenu = ingresarNumeroEntero("ingrese 1 BUSCAR_VENDIBLES_CUYO_CODIGO_INICIA_CON_TEXTO, 2 CREAR_VENTA_DE_PRODUCTOS_O_SERVICIOS, 3 OBTENER_CANTIDAD_DE_SERVICIOS_EN_VENTAS, 4	OBTENER_PRODUCTOS_CON_STOCK_MAXIMO_ORDENADOS_POR_PRECIO_DESCENDENTE, 5 SALIR");
//} while (tipoMenu<1|| tipoMenu>5);
//
//return MenuPrincipal.values()[tipoMenu-1];