package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominio.LataDePintura;
import ar.edu.unlam.pb1.dominio.Pintureria;
import ar.edu.unlam.pb1.dominio.enums.TipoDePintura;
import ar.edu.unlam.pb1.interfaz.enums.MenuPrincipal;

public class GestionDePintureria {

	private static final Scanner TECLADO = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO: Escriba el codigo necesario para garantizar el correcto funcionamiento
		// del software. Para armar el menu, se debera utilizar el enum MenuPrincipal,
		// buscando llevar el codigo a ejecutarse (en cada caso del menu) a un metodo
		// apropiado (Ver los métodos incluídos a continuación).Es necesario solicitar
		// la cantidad de latas posibles de almacenar en una pinturería.
		String ingreseNombre = ingresarString("ingrese el nombre de la pintureria");

		int cantidadDeLatas = ingresarNumeroEntero("hola, ingerse la cantidad de latas que queres almacenar :");

		Pintureria pintureria = new Pintureria(ingreseNombre, cantidadDeLatas);

		mostrarPorPantalla("hola " + pintureria.getNombre());

		MenuPrincipal opcion = null;

		do {
			opcion = obtenerOpcionDeEnumParaMenuPrincipal();

			switch (opcion) {
			case AGREGAR_LATA_PINTURA:

				agregarLataDePintura(pintureria);
				break;
			case VENDER_LATAS_PINTURA:
				venderLatasDePintura(pintureria);
				break;
			case MOSTRAR_CANTIDAD_LATAS_EN_STOCK_POR_TIPO:
				mostrarCantidadDeLatasEnStockPorTipoDePintura(pintureria);

				break;
			case MOSTRAR_LATAS_PINTURA_MAS_BARATA_POR_TIPO:
				mostrarLatasDePinturaMasBarataPorTipoDePintura(pintureria);

				break;
			case MOSTRAR_RESUMEN_PINTURERIA:
				mostrarResumenPintureria(pintureria);

				break;
			case SALIR:
				mostrarPorPantalla("chaucito");
				break;

			}
		} while (opcion != MenuPrincipal.SALIR);

	}

	private static void agregarLataDePintura(Pintureria pintureria) {
		// TODO: El usuario debera ingresar los datos de una lata de pintura para que
		// sea agregada a las latas que posee la pintureria.
		// Cuando se agrega una lata, no debe tener el mismo codigo de una lata ya
		// existente. Es necesario validar el codigo que se ingresa. En caso existir en
		// la pintureria, una lata con el codigo ingresado, se debera mostrar un mensaje
		// apropiado y seguir solicitando el ingreso de un nuevo codigo, hasta obtener
		// un codigo no existente. Para los tipos de pintura se debera ingresar la
		// palabra MATE o SATINADA, sin importar si es en mayusculas o minusculas (o
		// mixto). El stock ingresado debe ser mayor a cero y se debe seguir solicitando
		// en caso de ingresar un valor invalido.
		// Si se agrega correctamente la lata de pintura a la pintureria, mostrar un
		// mensaje de exito, caso contrario, uno de error.

		// LataDePintura(int codigo, String nombre, double porcentajeDeGanancia,
		// TipoDePintura tipoDePintura,int stock)
		int codigo = 0;
		do {
			 codigo = ingresarNumeroEntero("ingrese el codigo");
			 if (pintureria.obtenerLataDePinturaPorCodigo(codigo)!=null) {
				System.out.println("ingrese un codigo nuevo!, ese ya exxiste");
			}
			 
		} while (pintureria.obtenerLataDePinturaPorCodigo(codigo)!=null);
		
		String nombre = ingresarString("ingrese el nombre");
		TipoDePintura tipoDePintIngersada = obtenerTipoDePintura("Ingerse si Es mate o satinada");
		double porcentajeDeGanancia = ingresarDouble("ingrese el porcentaje de ganancia");
		
		
		int stock = 0;
		do {
			stock = ingresarNumeroEntero("ingrese stock");
			if (stock<=0) {
				System.out.println("ingresa un valor mayor a 0");
			}
		} while (stock<=0);
		
		if (pintureria.agregarLataDePintura(codigo, nombre, porcentajeDeGanancia, tipoDePintIngersada, stock)) {
			System.out.println("lo agregaste bien");
		}else {System.out.println("algo paso,no s epudo");}

	}

	private static void venderLatasDePintura(Pintureria pintureria) {
		// TODO: Se deberan mostrar las latas de pintura ordenadas por nombre
		// ascendente, que dispone la pintureria para
		// que el usuario pueda ingresar el codigo y la cantidad de latas que desea
		// vender. Solo se puede vender si tenemos en stock la cantidad de latas de
		// pintura ingresada.
		// En caso de ingresar un numero de latas de pintura a vender, mayor al stock de
		// esa lata de pintura,
		// mostrar un mensaje acorde y no procesar la venta. Si la cantidad es valida,
		// proceder a realizar la venta y mostrar un mensaje de exito.
		
		mostrarLatasDePintura(pintureria.obtenerLatasDePinturaOrdenadasPorNombreAscendente());
		int codigo=0;
		int cantidad = 0;
		do {
			codigo = ingresarNumeroEntero("ingerse el codigo");
			if (pintureria.obtenerLataDePinturaPorCodigo(codigo)==null) {
				System.out.println("ese no existe");
			}
		} while (pintureria.obtenerLataDePinturaPorCodigo(codigo)==null);
		
		do {
			cantidad = ingresarNumeroEntero("ingerse el stockk");
			if (!(pintureria.hayStock(codigo, cantidad))) {
				System.out.println("fijate bien el stock, no podes pedir mas de lo q hay");
			}
		} while (!(pintureria.hayStock(codigo, cantidad)));
		
		pintureria.venderLatasDePintura(codigo, cantidad);
		
		System.out.println("fiajte el saldo, se incremetno ? "+ pintureria);

	}

	private static void mostrarLatasDePinturaMasBarataPorTipoDePintura(Pintureria pintureria) {
		// TODO: Deberan mostrarse las latas de pintura mas baratas para cada tipo de
		// pintura (SATINADA o MATE) de la pintureria. Cabe destacaer que solo se puede
		// mostrar una lata por tipo de pintura. Si no existe al menos una lata para el
		// tipo, mostrar un mensaje apropiado.
		// Ejemplo: Pintura SATINADA mas barata: <pintura>
		// Ejemplo: Pintura MATE mas barata: <pintura>
System.out.println("la mas barata de las sati es "+pintureria.obtenerLataDePinturaMasBarataPorTipo(TipoDePintura.SATINADA));
System.out.println("la mas bara de las mate es " +pintureria.obtenerLataDePinturaMasBarataPorTipo(TipoDePintura.MATE));

	}

	private static void mostrarCantidadDeLatasEnStockPorTipoDePintura(Pintureria pintureria) {
		// TODO: Mostrar la cantidad de latas de pinturas satinadas y la cantidad de
		// latas de pinturas mate que tiene la pintureria.
		// Ejemplo: Pinturas SATINADAS: 10 - Pinturas MATE: 5
		
		System.out.println("SATINAdas: " + pintureria.obtenerCantidadDeLatasDePinturasEnStockPorTipo(TipoDePintura.SATINADA) );
System.out.println("MAte : "+ pintureria.obtenerCantidadDeLatasDePinturasEnStockPorTipo(TipoDePintura.MATE));
	}

	private static void mostrarResumenPintureria(Pintureria pintureria) {
		// TODO: Se debera mostrar como resumen, las latas de pintura que tiene
		// actualmente la pintureria (con stock actualizado y precio), ordenadas por
		// nombre ascendente.
		// Ademas, debe mostrarse la cantidad de latas de pintura vendidas y el saldo
		// actual de la pintureria.
		
		mostrarLatasDePintura(pintureria.obtenerLatasDePinturaOrdenadasPorNombreAscendente());
		System.out.println("la cantidad de vendidads  "+ pintureria.getCantidadLatasVendidas());
		System.out.println("el saldo acumulado "+ pintureria.getSaldo());

	}

	private static void mostrarMenuPrincipal() { ////////////////////

		String menu = "";

		for (int i = 0; i < MenuPrincipal.values().length; i++) {
			menu += "\n" + (i + 1) + ") " + MenuPrincipal.values()[i];
		}

		mostrarPorPantalla(menu);
	}

	private static MenuPrincipal obtenerOpcionDeEnumParaMenuPrincipal() { /////////////////////
		int opcion = 0;

		do {
			mostrarMenuPrincipal();
			opcion = ingresarNumeroEntero("\nIngrese opcion: ");
		} while (opcion < 1 || opcion > MenuPrincipal.values().length);

		MenuPrincipal menuPrincipal = MenuPrincipal.values()[opcion - 1];

		return menuPrincipal;
	}

	private static TipoDePintura obtenerTipoDePintura(String mensaje) { ////////////////////////
		String opcion;


		do {
			mostrarPorPantalla(mensaje);

			opcion = TECLADO.next().toUpperCase();

		} while (TipoDePintura.valueOf(opcion) == null);// valido ==false

		return TipoDePintura.valueOf(opcion);
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

	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}

	private static void mostrarLatasDePintura(LataDePintura[] latasDePintura) {
		
		for (int i = 0; i < latasDePintura.length; i++) {
			if (latasDePintura[i] != null) {
				mostrarPorPantalla(latasDePintura[i].toString());
			}
		}
	}
}

//TipoDePintura tipoDeLata = obtenerTipoDePintura("ingerse si es MATE o SATINADA");
//LataDePintura masBarata = pintureria.obtenerLataDePinturaMasBarataPorTipo(tipoDeLata);
//
//if (masBarata != null) {
//	mostrarPorPantalla("\nLa lata de pintura más barata es: \n" + masBarata.toString());
//} else {
//	mostrarPorPantalla("\nNo se encontraron latas de ese tipo");
//}
//

//
////
//mostrarLatasDePintura(pintureria.obtenerLatasDePinturaOrdenadasPorNombreAscendente());
//mostrarPorPantalla("\n" + pintureria.toString());

////for (int i = 0; i < pintureria.getLatasDePintura().length; i++) {
////if (pintureria.getLatasDePintura()[i] != null
////	&& pintureria.getLatasDePintura()[i].getTipoDePintura() == TipoDePintura.MATE) {
////
////mostrarPorPantalla("la cantidad es :"
////		+ pintureria.obtenerCantidadDeLatasDePinturasEnStockPorTipo(TipoDePintura.MATE));
////} else {
////
////mostrarPorPantalla("la cantidad es : "
////		+ pintureria.obtenerCantidadDeLatasDePinturasEnStockPorTipo(TipoDePintura.SATINADA));
////}
////}
//
//int cantidadSatinadas = pintureria.obtenerCantidadDeLatasDePinturasEnStockPorTipo(TipoDePintura.SATINADA);
//int cantidadMate = pintureria.obtenerCantidadDeLatasDePinturasEnStockPorTipo(TipoDePintura.MATE);
//
//mostrarPorPantalla("Cantidad de pinturas SATINADAS: " + cantidadSatinadas + "\nCantidad de pinturas MATE: " + cantidadMate);
//
//LataDePintura[] latasOrdenadas = pintureria.obtenerLatasDePinturaOrdenadasPorNombreAscendente();
//mostrarLatasDePintura(latasOrdenadas);
//
//int codigo =0;
//int cantidadAVender = 0;
//
// do {
//	codigo =  ingresarNumeroEntero("ingerse el codigo de la pintura :");
//	if (pintureria.obtenerLataDePinturaPorCodigo(codigo)==null) {
//		mostrarPorPantalla("No encontramos una lata con dicho código. Reingresar");
//	} // validacion Si existe
//				
//} while (pintureria.obtenerLataDePinturaPorCodigo(codigo) == null);
// 
// cantidadAVender=ingresarNumeroEntero("ingerse la cantidad a vender:");
// 
//if (pintureria.hayStock(codigo, cantidadAVender)) {   // validacion si existe stock
//	pintureria.venderLatasDePintura(codigo, cantidadAVender);
//	mostrarPorPantalla("se pudo vender!!!");
//	mostrarPorPantalla("Stock actualizado: " + pintureria.obtenerLataDePinturaPorCodigo(codigo).toString());// agregado
//} else {
//	mostrarPorPantalla("no se pudo vender");
//}

//, String nombre, double porcentajeGanancia,
//TipoDePintura tipoDePintura, int stock

//int codigo;
//boolean bandera =false;
//
//do {
//	if (!bandera) {
//		bandera=true;
//	}else {mostrarPorPantalla("ya existe ese codigo");}
//	codigo = ingresarNumeroEntero("ingrese el numero de cod");
//} while (pintureria.obtenerLataDePinturaPorCodigo(codigo)!=null);
//
//String nombre = ingresarString("ingrese el nombre");
//
//TipoDePintura tipo= obtenerTipoDePintura("ingerse si es MATE o SATINADA");
//
//int stock;
//boolean banderita = false;
//do {
//	if (!banderita) {
//		banderita=true;
//	}else {mostrarPorPantalla("el codigo no puede ser menor q cero");}
//	stock=ingresarNumeroEntero("ingresar stock"); 
//} while (stock<=0);
//
//
//if (pintureria.agregarLataDePintura(codigo, nombre, codigo, tipo, stock)) {
//	mostrarPorPantalla("se agrego correctamente");
//	
//}else {mostrarPorPantalla("no se pudo agregar, algun dato debe estar mal");}
//mostrarPorPantalla(pintureria.obtenerLataDePinturaPorCodigo(codigo).toString());
//
//
//int opcion1 = ingresarNumeroEntero("22 para salir o 1 para seguir agregando:");
//
//while (opcion1 != 22) {
//	int codigo = ingresarNumeroEntero("ingerse el codigo de la pintura :");
//	// System.out.println(codigo);
//	String nombre = ingresarString("ingrese el nombre :");
//	double porcentajeDeGanancia = ingresarDouble("ingrese el porcentaje de ganancia : ");
//	TipoDePintura tipoDePintura = obtenerTipoDePintura(
//			"ingrese 1 si la pintura es satinada o 2 si la pintura es mate :");
//	int stock = ingresarNumeroEntero("ingerse el stock de la pintura :");
//
//	pintureria.agregarLataDePintura(codigo, nombre, porcentajeDeGanancia, tipoDePintura, stock);
//
//	opcion1 = ingresarNumeroEntero("22 para salir o 1 para seguir agregando:");
//	System.out.println();
//}