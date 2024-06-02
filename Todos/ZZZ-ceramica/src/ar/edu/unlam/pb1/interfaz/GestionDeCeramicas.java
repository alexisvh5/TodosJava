package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominio.CajaDeCeramica;
import ar.edu.unlam.pb1.dominio.Pedido;
import ar.edu.unlam.pb1.dominio.Sucursal;
import ar.edu.unlam.pb1.dominio.enums.TipoDeCeramica;
import ar.edu.unlam.pb1.interfaz.enums.MenuPrincipal;

public class GestionDeCeramicas {

	private static final Scanner TECLADO = new Scanner(System.in);

	public static void main(String[] args) {
		MenuPrincipal opcionMenuPrincipal = null;
		Sucursal sucursal = new Sucursal("Sucursal");

		do {
			mostrarPorPantalla("\n\n\n" + sucursal.getNombre());

			opcionMenuPrincipal = obtenerOpcionDeEnumParaMenuPrincipal();

			switch (opcionMenuPrincipal) {
			case CALCULAR_CANTIDAD_CAJAS_CERAMICA_POR_AREA_COBERTURA:
				calcularCantidadDeCajasDeCeramicaPorAreaDeCobertura(sucursal);
				break;
			case AGREGAR_CAJAS_DE_CERAMICA_A_PEDIDO:
				agregarCajasDeCeramicaAPedido(sucursal);
				break;
			case OBTENER_MONTO_TOTAL_DE_PEDIDOS_UTILIZADOS:
				obtenerMontoTotalDeLosPedidosUtilizados(sucursal);
				break;
			case OBTENER_PROMEDIO_PRECIOS_CAJAS_CERAMICAS_POR_TIPO_CERAMICA_EN_PEDIDO:
				obtenerPromedioDePrecioDeCajasDeCeramicaDeUnTipoDeCeramicaEnUnPedido(sucursal);
				break;
			case SALIR:
				mostrarPorPantalla("\n\nHasta luego!");
				break;
			}

		} while (opcionMenuPrincipal != MenuPrincipal.SALIR);

	}

	private static void calcularCantidadDeCajasDeCeramicaPorAreaDeCobertura(Sucursal sucursal) {
		// TODO: Se debera ingresar el area (cantidad de metros cuadrados) a cubrir y la
		// caja de ceramicas deseada ((ver metodo obtenerCajaDeCeramica())). Luego
		// calcular la cantidad de cajas necesarias (ver en Sucursal) e informarla.



	}

	private static void agregarCajasDeCeramicaAPedido(Sucursal sucursal) {
		// TODO: Se debera ingresar el numero de pedido, la caja de ceramicas que se
		// agregaran (ver metodo obtenerCajaDeCeramica()) y la cantidad de cajas a
		// agregar. Con estos tres datos, se deberan agregar las cajas al pedido de la
		// sucursal y mostrar un mensaje en caso de exito u otro en caso de no lograr
		// completar la operacion.

//	
	}

	private static void obtenerMontoTotalDeLosPedidosUtilizados(Sucursal sucursal) {
		// TODO: obtener el monto total de los pedidos utilizados en la sucursal y
		// mostrarlo.
		
//	
	}

	private static void obtenerPromedioDePrecioDeCajasDeCeramicaDeUnTipoDeCeramicaEnUnPedido(Sucursal sucursal) {
		// TODO: Se debera solicitar el ingreso del numero de pedido el cual no puede
		// ser menor que cero, ni mayor que la cantida de pedidos que puede tener la
		// sucursal. En caso de no ser valido, se debera continuar solicitando el
		// ingreso del dato, hasta que se ingrese un dato valido.
		// Se debera solicitar el ingreso del tipo de ceramica para el cual se calculara
		// el promedio (ver metodo ingresarTipoDeCeramica()) y luego se debera obtener y
		// mostrar
		// el promedio de precio de cajas de ceramica, en el pedido ingresado, para el
		// tipo de ceramica ingresado.
		

	}

	private static CajaDeCeramica obtenerCajaDeCeramica(Sucursal sucursal) {
		// TODO: Mostrar las cajas de ceramica disponibles ordenadas por tipo de
		// ceramica de manera ascendente, solicitar el ingreso del codigo de la caja de
		// ceramica y con este buscar la caja en la sucursal y devolverla.4

	

	
	}

	private static MenuPrincipal obtenerOpcionDeEnumParaMenuPrincipal() {
		// TODO: mostrar las opciones del menu principal (ver metodo
		// mostrarMenuPrincipal()), solicitar el ingreso de la opcion deseada, obtenerla
		// desde el enum y devolverla.


	}

	private static TipoDeCeramica ingresarTipoDeCeramica() {
		// TODO: mostrar las opciones de los tipos de ceramica (ver metodo
		// mostrarTiposDeCeramica()), solicitar el ingreso de la opcion deseada,
		// obtenerla desde el enum y devolverla.

	
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

	private static void mostrarMenuPrincipal() {
		String menu = "";
		for (int i = 0; i < MenuPrincipal.values().length; i++) {
			menu += "\n" + (i + 1) + ") " + MenuPrincipal.values()[i];
		}

		mostrarPorPantalla(menu);
	}

	private static void mostrarCeramicasDisponibles(CajaDeCeramica[] ceramicasDisponibles) {

		for (int i = 0; i < ceramicasDisponibles.length; i++) {
			mostrarPorPantalla(ceramicasDisponibles[i].toString());
		}

	}

	private static void mostrarTiposDeCeramica() {
		for (int i = 0; i < TipoDeCeramica.values().length; i++) {
			mostrarPorPantalla("\n" + (i + 1) + ") " + TipoDeCeramica.values()[i]);
		}
	}

	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}
}




















































//		int pedido;

//do {
// pedido=ingresarNumeroEntero("ingrese el numero de pedido");
//} while (pedido <0 || pedido > 10000);	
//
//TipoDeCeramica tipoCer = ingresarTipoDeCeramica();
//
//System.out.println("el promedio es "+sucursal.obtenerPromedioDePrecioDeCajasDeCeramicaDeUnTipoDeCeramicaEnUnPedido(pedido, tipoCer));



/// en orden 
//int cantidadDeMetrosCuadrados;
//boolean bandera = false;
//
//do {
//	if (!bandera) {
//		bandera = true;
//	} else {
//		mostrarPorPantalla("error, reingrese");
//	}
//
//	cantidadDeMetrosCuadrados = ingresarNumeroEntero("ingresar cantidad de metros cuadrados :");
//
//} while (cantidadDeMetrosCuadrados <= 0);
//
//if (obtenerCajaDeCeramica(sucursal)!=null) {
//	
//	sucursal.calcularCantidadDeCajasDeCeramicaPorAreaDeCobertura(cantidadDeMetrosCuadrados, obtenerCajaDeCeramica(sucursal));
//	
//	mostrarPorPantalla("la cantidad es "+sucursal.calcularCantidadDeCajasDeCeramicaPorAreaDeCobertura(cantidadDeMetrosCuadrados, obtenerCajaDeCeramica(sucursal)));
//}else {mostrarPorPantalla("no se puedo");}

//	int numeroDePedido = ingresarNumeroEntero("ingresar numero del pedido");
//
//Pedido[] pedidosDondeBusco = sucursal.getPedidos();
//
//
//if (sucursal.buscarPedidoPorNumero(pedidosDondeBusco, numeroDePedido)) {
//	mostrarPorPantalla("el num de pedido ya existe");
//} 
//else {
//      CajaDeCeramica aAgregar = obtenerCajaDeCeramica(sucursal);
//      int cantidadDeCajasAAgregar;
//      do {
//    	  cantidadDeCajasAAgregar = ingresarNumeroEntero("ingresar cantidadDECajasa a agregar");
//	} while (cantidadDeCajasAAgregar<=0);
//      
//	    if (sucursal.agregarCajasDeCeramicaAPedido(numeroDePedido, aAgregar, cantidadDeCajasAAgregar)) {
//		    mostrarPorPantalla("perfecto, agregado");
//	       } 
//	     else {
//		      mostrarPorPantalla("no se pudo agregar");
//	         }
//      }
//	System.out.println("el monto total es "+sucursal.obtenerMontoTotalDeLosPedidosUtilizados());
//
 //	mostrarCeramicasDisponibles(sucursal.getCeramicasDisponibles());
//String codigo;
//boolean verdad = false;
//do {
//	if (!verdad) {
//		verdad = true;
//		
//	} else {
//		mostrarPorPantalla("error, reingrese");
//	}
//	codigo = ingresarString("ingersar el codigo de la caja--------------");
//	
//} while (sucursal.buscarCajaDeCeramicaPorCodigo(codigo) == null);
//
//
//return sucursal.buscarCajaDeCeramicaPorCodigo(codigo);
//////////
//
//int numero;
//do {
//	mostrarTiposDeCeramica();
//	numero = ingresarNumeroEntero("ingrese la opcion deseadoa");
//	if (numero < 1 || numero > 3) {
//		mostrarPorPantalla("eliga una opcion correcta");
//	}
//} while (numero < 1 || numero > 3);
//
//return TipoDeCeramica.values()[numero - 1];

/////////////
//int numero;
//do {
//	mostrarMenuPrincipal();
//	numero = ingresarNumeroEntero("ingrese la opcion deseadoa");
//	if (numero < 1 || numero > 5) {
//		mostrarPorPantalla("eliga una opcion correcta");
//	}
//} while (numero < 1 || numero > 5);
//
//return MenuPrincipal.values()[numero - 1];
