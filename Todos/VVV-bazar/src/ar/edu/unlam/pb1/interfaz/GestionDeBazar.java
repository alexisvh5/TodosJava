package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominio.Bazar;
import ar.edu.unlam.pb1.dominio.Producto;
import ar.edu.unlam.pb1.dominio.enums.TipoDeIva;
import ar.edu.unlam.pb1.interfaz.enums.MenuPrincipal;

public class GestionDeBazar {

	private static final Scanner TECLADO = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO: Escriba el codigo necesario para garantizar el correcto funcionamiento
		// del software. Para armar el menu, se debera utilizar el enum MenuPrincipal,
		// buscando llevar el codigo a ejecutarse (en cada caso del menu) a un metodo
		// apropiado (Ver los métodos incluídos a continuación).
		Bazar nuevoBazar = new Bazar("alexisBazado");
		mostrarPorPantalla("hola " + nuevoBazar.getNombre());
		MenuPrincipal opcion = null;

		do {

			opcion = obtenerOpcionDeEnumParaMenuPrincipal();

			switch (opcion) {

			case AGREGAR_PRODUCTO:
				agregarProducto(nuevoBazar);
				break;
			case AGREGAR_STOCK_A_PRODUCTO:
			agregarStockAProducto(nuevoBazar);
				break;
			case INCREMENTAR_COSTO_DE_PRODUCTO_EN_PORCENTAJE:
				nuevoBazar.incrementarCostoDeProductoConPorcentaje(null, 0);

				break;
			case MOSTRAR_PRODUCTOS_POR_SECCION:
				mostrarProductosPorSeccion(nuevoBazar);// no muestra igual; con elprivate si

				break;
			case MOSTRAR_PROMEDIO_DE_PRECIO_VENTA_DE_PRODUCTOS_POR_SECCION_CON_O_SIN_IVA:
				mostrarPromedioDePrecioVentaDeProductosPorSeccionConOSinIva(nuevoBazar);

			//	nuevoBazar.obtenerPromedioDePrecioDeVentaDeProductosPorSeccionConOSinIva(0, false);// ver como mostrar

				break;

			case SALIR:
				System.out.println("chauuuu");
				break;
			}

		} while (opcion != MenuPrincipal.SALIR);
	}

	private static void agregarProducto(Bazar bazar) {
		// TODO: El usuario debera ingresar los datos de un producto. Para la "seccion"
		// ver el metodo
		// ingresarSeccionValidada().
		// El porcentaje de ganancia y costo del producto, no pueden ser menores a cero.
		// En caso de que se ingrese un valor menor a cero, se debera continuar
		// solicitando el dato hasta que se ingrese uno valido.
		// Si el mensaje de respuesta al momento de agregar no esta vacio, mostrar el
		// mensaje "\nNo se pudo agregar el producto:" seguido del contenido del mensaje
		// de respuesta.
		// Si el mensaje esta vacio, mostrar un mensaje de exito.

		String codigoDeBarras = ingresarString("ingrese el cod de barras");

		char seccion = ingresarSeccionValidada();

		String nombre = ingresarString("ingrese el nombre del prod");
		
		TipoDeIva tipoDeIva = elegirTipoDeIva(); 
		
		int stock = ingresarNumeroEntero("ingrese el stock");

		double porcentajeDeGanancia = 0.0;
		do {
			porcentajeDeGanancia =ingresarDouble("ingrese el porcentaje de ganancia");
			if (porcentajeDeGanancia<=0) {
				mostrarPorPantalla("ingresa bien el numero");
			}
			
		} while (porcentajeDeGanancia<=0);

		double costoProducto = 0.0;
		do {
			costoProducto =ingresarDouble("ingrese el costo del producto");
			if (costoProducto<=0) {
				mostrarPorPantalla("ingresa bien el numero");
			}
			
		} while (costoProducto<=0);
		
		
		bazar.agregarProducto(codigoDeBarras, seccion, nombre, tipoDeIva, stock, porcentajeDeGanancia, costoProducto);
		
		mostrarPorPantalla(bazar.agregarProducto(codigoDeBarras, seccion, nombre, tipoDeIva, stock, porcentajeDeGanancia, costoProducto));

	}

	private static TipoDeIva elegirTipoDeIva() {
		int opcion = 0;
		
		mostrarPorPantalla("ingrese el tipo de iva :");
		for (int i = 0; i < TipoDeIva.values().length; i++) {
			mostrarPorPantalla((i+1)+")" + TipoDeIva.values()[i]);
		}
		opcion=TECLADO.nextInt();
		
		return TipoDeIva.values()[opcion-1];
	}

	private static void agregarStockAProducto(Bazar bazar) {
		// TODO: Se deben mostrar los productos. El usuario debe ingresar el codigo de
		// barras del producto al que
		// se le agregara stock. Si el valor para agregar al stock es menor a cero, se
		// debera seguir solicitando el dato.
		// Mostrar un mensaje de exito en caso de concretar la operacion o "\nProducto
		// inexistente." si no fue posible agregarle stock al producto.
		mostrarProductos(bazar.getProductos());

	}

	private static void incrementarCostoDeProductoEnPorcentaje(Bazar bazar) {
		// TODO: Se deben mostrar los productos. El usuario debera ingresar el codigo de
		// barras del producto al que se
		// le quiere incrementar el costo y, el porcentaje que se debera incrementar.
		// Ejemplo de datos ingresados por el usuario:
		// codigoDeBarras = 111111111111, porcentaje = 10%
		// Luego de incrementar el costo, mostrar el producto actualizado.
	}

	private static void mostrarProductosPorSeccion(Bazar bazar) {
		char seccion = ingresarSeccionValidada();
		mostrarProductos(bazar.obtenerProductosPorSeccion(seccion));
	}

	private static void mostrarPromedioDePrecioVentaDeProductosPorSeccionConOSinIva(Bazar bazar) {
		// TODO: Se debe solicitar el ingreso de la seccion y si los precios llevan IVA
		// para obtener el promedio solicitado.
		// Si los precios deben incluir el IVA, el usuario debe ingresar una S, caso
		// contrario una letra N.
		// Mostrar por pantalla el promedio de precios de venta de productos en la
		// seccion indicada contemplando el IVA.
	}

	private static char ingresarSeccionValidada() {
		// TODO: Solicitar al usuario el ingreso de un caracter dentro de los siguientes
		// posibles: A - B - C - D.
		// En caso de ingresar una opcion invalida, continuar solicitando el dato hasta
		// que se ingrese una opcion valida.

		char datoIngresado = '\0';

		do {

			datoIngresado = ingresarChar("ingerse el caracter : A - B - C - D, en mayus");

		} while (datoIngresado != 'A' && datoIngresado != 'B' && datoIngresado != 'C' && datoIngresado != 'D');

		return datoIngresado;

	}

	private static void mostrarMenuPrincipal() {

		String menu = "";

		for (int i = 0; i < MenuPrincipal.values().length; i++) {
			menu += "\n" + (i + 1) + ") " + MenuPrincipal.values()[i];
		}

		mostrarPorPantalla(menu);
	}

	private static MenuPrincipal obtenerOpcionDeEnumParaMenuPrincipal() {
		int opcion = 0;
		mostrarMenuPrincipal();
		opcion = ingresarNumeroEntero("\nIngrese opcion: ");
		MenuPrincipal menuPrincipal = MenuPrincipal.values()[opcion - 1];
		return menuPrincipal;
	}

	private static int ingresarNumeroEntero(String mensaje) {
		mostrarPorPantalla(mensaje);
		return TECLADO.nextInt();
	}

	private static String ingresarString(String mensaje) {
		mostrarPorPantalla(mensaje);
		return TECLADO.next();
	}

	private static double ingresarDouble(String mensaje) {
		mostrarPorPantalla(mensaje);
		return TECLADO.nextDouble();
	}

	private static char ingresarChar(String mensaje) {
		mostrarPorPantalla(mensaje);
		return TECLADO.next().charAt(0);
	}

	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}

	private static void mostrarProductos(Producto[] productos) {
		for (int i = 0; i < productos.length; i++) {
			if (productos[i] != null) {
				mostrarPorPantalla(productos[i].toString());
			}
		}
	}
}

///
//Bazar bazar = new Bazar("alexis");
//mostrarPorPantalla("hola "+bazar.getNombre());
//
//MenuPrincipal opcion;
//do {
//	opcion = obtenerOpcionDeEnumParaMenuPrincipal();
//
//	switch (opcion) {
//	case AGREGAR_PRODUCTO:
//		
//		agregarProducto(bazar);
//
//		break;
//	case AGREGAR_STOCK_A_PRODUCTO:
//		agregarStockAProducto(bazar);
//		break;
//	case INCREMENTAR_COSTO_DE_PRODUCTO_EN_PORCENTAJE:
//		incrementarCostoDeProductoEnPorcentaje(bazar);
//
//		break;
//	case MOSTRAR_PRODUCTOS_POR_SECCION:
//		mostrarProductosPorSeccion( bazar);
//		break;
//	case MOSTRAR_PROMEDIO_DE_PRECIO_VENTA_DE_PRODUCTOS_POR_SECCION_CON_O_SIN_IVA:
//		mostrarPromedioDePrecioVentaDeProductosPorSeccionConOSinIva(bazar);
//		break;
//	case SALIR:
//		mostrarPorPantalla("chaaaaaaaaaaaaaaaau");
//		break;
//
//	default:
//		break;
//	}
//
//} while (opcion != MenuPrincipal.SALIR);
//
//}
//
//String codigoBarras;
//do {
//	codigoBarras = ingresarString("ungrese codigo de barras");
//
//if (bazar.obtenerProductoPorCodigoDeBarras(codigoBarras)!=null) {
//	mostrarPorPantalla("este codigo ya existe");
//}
//} while (bazar.obtenerProductoPorCodigoDeBarras(codigoBarras)!=null);
// 
//
//char seccion = ingresarSeccionValidada();
//String nombre = ingresarString("ingresar nombre");
//int opcionIva;
//do {
//	opcionIva = ingresarNumeroEntero("ingrese 1 si es iva general 2 si es reducido1 3 si es reducido2 4 si es superReducido"); 
//} while (opcionIva <1 || opcionIva>4);
//TipoDeIva tipoDeIva = TipoDeIva.values()[opcionIva-1];
//int stock=ingresarNumeroEntero("ingrese stock");	
//
//double porcentajeGanancia;
//double costo;
//do {
//	porcentajeGanancia=ingresarDouble("ingrese %de cganancia");
//	if (porcentajeGanancia<0) {
//		mostrarPorPantalla("el % de ganancia no puee ser negativo");
//	}
//	costo=ingresarDouble("ingrese costo");
//	if (costo <0) {
//		mostrarPorPantalla("el costo no puee ser negativo");
//	}
//} while (porcentajeGanancia <0 ||costo<0 );
//
//if(bazar.agregarProducto(codigoBarras, seccion, nombre, tipoDeIva, stock, porcentajeGanancia, costo)!="")
//	{
//mostrarPorPantalla("\nNo se pudo agregar el producto:");
//	}else{
//
//		mostrarPorPantalla("\n Se pudo agregar el producto:");};
//		mostrarProductos(bazar.getProductos());
//		String codi;
//		boolean verdad= false;
//		do {
//			codi= ingresarString("ingerse el cod de barras del prod al que se le agregara el stock");
//			if (bazar.obtenerProductoPorCodigoDeBarras(codi)==null) {
//			mostrarPorPantalla("producto inexistente");
//		}else {verdad = true;}
//		} while (!verdad);
//		int stock = ingresarNumeroEntero("ingrese el estock a agregar: ");
//		if (stock<0) {
//			mostrarPorPantalla("no se puede agregar un stock negativo");
//		}else {mostrarPorPantalla("stock agregado");
//		bazar.obtenerProductoPorCodigoDeBarras(codi).setStock(bazar.obtenerProductoPorCodigoDeBarras(codi).getStock()+stock);};
//		
//		char caracter =' ';
//		do {
//			caracter = ingresarChar("ingrese caracter :A - B - C - D ");
//			
//		} while (!Character.isLetter(caracter)||!(caracter=='A'||caracter=='B'||caracter=='C'||caracter=='D'));
//		
//		
//		
//		return caracter;
