package ar.edu.unlam.pb1.interfaz;

import java.util.Iterator;
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
		
		double area= ingresarDouble("ingerse metros cuarados :");
		CajaDeCeramica cajaDeCerDeseada = obtenerCajaDeCeramica(sucursal);
		int cantidadDeCajasDeseadas =sucursal.calcularCantidadDeCajasDeCeramicaPorAreaDeCobertura(area,cajaDeCerDeseada);
	    mostrarPorPantalla("esta es la cantidad :" +cantidadDeCajasDeseadas+ " cajas.");
	}

	private static void agregarCajasDeCeramicaAPedido(Sucursal sucursal) {
		// TODO: Se debera ingresar el numero de pedido, la caja de ceramicas que se
		// agregaran (ver metodo obtenerCajaDeCeramica()) y la cantidad de cajas a
		// agregar. Con estos tres datos, se deberan agregar las cajas al pedido de la
		// sucursal y mostrar un mensaje en caso de exito u otro en caso de no lograr
		// completar la operacion.
		int numeroPedido= ingresarNumeroEntero("ingerse numero de pedido");
		int canti= ingresarNumeroEntero("cantiad de cajas a agregar");
		mostrarCeramicasDisponibles(sucursal.getCeramicasDisponibles());
		obtenerCajaDeCeramica(sucursal);
		
		for (int i = 0; i < sucursal.getPedidos().length; i++) {

			if (sucursal.getPedidos()[i]!=null) {
				
			
				sucursal.agregarCajasDeCeramicaAPedido(numeroPedido, obtenerCajaDeCeramica(sucursal), canti);
				mostrarPorPantalla("bien ahi pibe");
			}	
		 else {mostrarPorPantalla("no se pudo che");}
		}	
		
		
	}

	private static void obtenerMontoTotalDeLosPedidosUtilizados(Sucursal sucursal) {
		// TODO: obtener el monto total de los pedidos utilizados en la sucursal y
		// mostrarlo.
		
		
		mostrarPorPantalla("el monto toral de los pedidos utilizados es "+sucursal.obtenerMontoTotalDeLosPedidosUtilizados() + " pesos.");
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
		int numeroPedido = 0;
		Pedido pedidoBuscado = null;
do {
		numeroPedido = ingresarNumeroEntero("ingrese el num de pedido, acuerdese q no puede ser menor a 0" );
	
		for (int i = 0; i < sucursal.getPedidos().length; i++) {
		if(sucursal.getPedidos()[i].getNumero() != numeroPedido) {
			numeroPedido=1;
		}else {
		numeroPedido = -1;
		pedidoBuscado = sucursal.getPedidos()[i];}
	}
		
} while (numeroPedido<0 && numeroPedido>sucursal.getPedidos().length);

ingresarTipoDeCeramica();
double prom = sucursal.obtenerPromedioDePrecioDeCajasDeCeramicaDeUnTipoDeCeramicaEnUnPedido(numeroPedido, ingresarTipoDeCeramica());
String n1 = Double.toString(prom);
mostrarPorPantalla(n1);
	}

	private static CajaDeCeramica obtenerCajaDeCeramica(Sucursal sucursal) {
		// TODO: Mostrar las cajas de ceramica disponibles ordenadas por tipo de
		// ceramica de manera ascendente, solicitar el ingreso del codigo de la caja de
		// ceramica y con este buscar la caja en la sucursal y devolverla.
		
//		sucursal.obtenerCeramicasDisponiblesOrdenadasPorTipoDeCeramicaAscendente().toString();
//	
//	
//			String codigoABusc=ingresarString("ingerse el codigo buscado");
//			int contador = 0;
//			if ( sucursal.getCeramicasDisponibles()[contador].getCodigo().equals(codigoABusc)) {
//				for (int i = 0; i < sucursal.getCeramicasDisponibles().length; i++) {
//			if (sucursal.getCeramicasDisponibles()[i] != null) {
//				return sucursal.getCeramicasDisponibles()[i];
//				
//			}
//			}
//		}
		int numeroDePedido = 0;
		do {
			numeroDePedido = ingresarNumeroEntero("Ingrese el numero de pedido:");	
			if (sucursal.elPedidoYafueUtilizado(numeroDePedido)) {
				System.out.println("Ese pedido ya fue utilizado.");
			}
		} while (sucursal.elPedidoYafueUtilizado(numeroDePedido));
		CajaDeCeramica cajaDeCeramicaAAgregar = null;
		
		do {
			cajaDeCeramicaAAgregar = obtenerCajaDeCeramica(sucursal); 			
		} while (cajaDeCeramicaAAgregar == null);
		
		int cantidadDeCajasAAgregar = ingresarNumeroEntero("Ingrese la cantidas de cajas a agregar: ");//este numero no lo tengo que obtener mediante el metodo que te calcula la cantida de cajas a llevar segun su cobertura?
		
		if (sucursal.agregarCajasDeCeramicaAPedido(numeroDePedido, cajaDeCeramicaAAgregar, cantidadDeCajasAAgregar)) {
			mostrarPorPantalla("Se agregaron la/s caja/s de ceramicas al pedido.");
		}else {
			mostrarPorPantalla("No se pudo agregar la/s caja/s de ceramicas al pedido.");
		}
	}
		
	}

	private static MenuPrincipal obtenerOpcionDeEnumParaMenuPrincipal() {
		// TODO: mostrar las opciones del menu principal (ver metodo
		// mostrarMenuPrincipal()), solicitar el ingreso de la opcion deseada, obtenerla
		// desde el enum y devolverla.
		
		mostrarMenuPrincipal();
		int opcion =ingresarNumeroEntero("ingrese opcion deseada");		
		MenuPrincipal tipoDeOpcionBuscada = MenuPrincipal.values()[opcion - 1];
		return tipoDeOpcionBuscada;
		
	}

	private static TipoDeCeramica ingresarTipoDeCeramica() {
		// TODO: mostrar las opciones de los tipos de ceramica (ver metodo
		// mostrarTiposDeCeramica()), solicitar el ingreso de la opcion deseada,
		// obtenerla desde el enum y devolverla.
		mostrarTiposDeCeramica();
		int opcion =ingresarNumeroEntero("ingrese opcion deseada");		
		TipoDeCeramica tipoDeCeramicaBuscada = TipoDeCeramica.values()[opcion - 1];
		return tipoDeCeramicaBuscada;
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
		mostrarPorPantalla("\n" + mensaje);
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
