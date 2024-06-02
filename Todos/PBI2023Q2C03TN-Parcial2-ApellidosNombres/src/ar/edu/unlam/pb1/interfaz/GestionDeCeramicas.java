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

		double area = ingresarDouble("ingrese el area a cubrir");
		CajaDeCeramica cajaSolicitada = obtenerCajaDeCeramica(sucursal);

		mostrarPorPantalla("la cantidad de cajas es "
				+ sucursal.calcularCantidadDeCajasDeCeramicaPorAreaDeCobertura(area, cajaSolicitada));

	}

	private static void agregarCajasDeCeramicaAPedido(Sucursal sucursal) {
		// TODO: Se debera ingresar el numero de pedido, la caja de ceramicas que se
		// agregaran (ver metodo obtenerCajaDeCeramica()) y la cantidad de cajas a
		// agregar. Con estos tres datos, se deberan agregar las cajas al pedido de la
		// sucursal y mostrar un mensaje en caso de exito u otro en caso de no lograr
		// completar la operacion.

		int numPedido = 0, cantidadDeCAjas = 0;

		mostrarPedidosDisponibles(sucursal.getPedidos());
		Pedido pedidoSeleccionado = null;

		do {
			numPedido = ingresarNumeroEntero("ingrese el numero de pedido");
			pedidoSeleccionado = sucursal.getPedidoByNumPedido(numPedido);
		} while (pedidoSeleccionado == null);

		CajaDeCeramica cajaDeCeramicaBuscada = obtenerCajaDeCeramica(sucursal);

		System.out.println("en este pedido tenes libre la cantidad de: "
				+ pedidoSeleccionado.getCantidadDeLugaresLibresParaCeramicas() + " cajas para agregar"
				+ "\n" + pedidoSeleccionado);

		cantidadDeCAjas = ingresarNumeroEntero("ingerese la canridad de cajas a agregar: ");

		if (sucursal.agregarCajasDeCeramicaAPedido(numPedido, cajaDeCeramicaBuscada, cantidadDeCAjas)) {
			System.out.println("se agrego correctamente");
		} else {
			System.out.println(
					"la cantidad no puede ser mas del max permitido, 20 cajas por pedido, fijate tambien si el pedido ya fue utilizado");
		}

		mostrarPedidosDisponibles(sucursal.getPedidos());
	}

	private static void obtenerMontoTotalDeLosPedidosUtilizados(Sucursal sucursal) {
		// TODO: obtener el monto total de los pedidos utilizados en la sucursal y
		// mostrarlo.
		
		mostrarPorPantalla("el monto total de los pedidos utilizados es = "+ sucursal.obtenerMontoTotalDeLosPedidosUtilizados());
		
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
		
		int numPedido = 0;

		mostrarPedidosDisponibles(sucursal.getPedidos());
		Pedido pedidoSeleccionado = null;

		do {
			numPedido = ingresarNumeroEntero("ingrese el numero de pedido");
			pedidoSeleccionado = sucursal.getPedidoByNumPedido(numPedido);
		} while (pedidoSeleccionado == null);
		
		TipoDeCeramica tipo= null;
		
		tipo = ingresarTipoDeCeramica();
		
	System.out.println("el promedio de  precio de ese tipo en el pedido es :"+	sucursal.obtenerPromedioDePrecioDeCajasDeCeramicaDeUnTipoDeCeramicaEnUnPedido(numPedido, tipo));		
		
	}

	private static CajaDeCeramica obtenerCajaDeCeramica(Sucursal sucursal) {
		// TODO: Mostrar las cajas de ceramica disponibles ordenadas por tipo de
		// ceramica de manera ascendente, solicitar el ingreso del codigo de la caja de
		// ceramica y con este buscar la caja en la sucursal y devolverla.
		
		CajaDeCeramica cajaBuscada = null;
		mostrarCeramicasDisponibles(sucursal.obtenerCeramicasDisponiblesOrdenadasPorTipoDeCeramicaAscendente());

		String codigo = "";

		do {
			codigo = ingresarString("ingrese el codigo de la caja: ");
			if (sucursal.buscarCajaDeCeramicaPorCodigo(codigo) == null) {
				mostrarPorPantalla("ingerse un codigo valido");
			}
		} while (sucursal.buscarCajaDeCeramicaPorCodigo(codigo) == null);

		cajaBuscada = sucursal.buscarCajaDeCeramicaPorCodigo(codigo);

		return cajaBuscada;
	}

	private static MenuPrincipal obtenerOpcionDeEnumParaMenuPrincipal() {
		// TODO: mostrar las opciones del menu principal (ver metodo
		// mostrarMenuPrincipal()), solicitar el ingreso de la opcion deseada, obtenerla
		// desde el enum y devolverla.

		mostrarMenuPrincipal();

		int opcion = 0;

		do {
			opcion = ingresarNumeroEntero("ingrese la opcion");

			if (opcion < 1 || opcion > 5) {
				mostrarPorPantalla("ingrese una opcion valida");
			}

		} while (opcion < 1 || opcion > 5);

		return MenuPrincipal.values()[opcion - 1];
	}

	private static TipoDeCeramica ingresarTipoDeCeramica() {
		// TODO: mostrar las opciones de los tipos de ceramica (ver metodo
		// mostrarTiposDeCeramica()), solicitar el ingreso de la opcion deseada,
		// obtenerla desde el enum y devolverla.
		
		for (int i = 0; i < TipoDeCeramica.values().length; i++) {
			System.out.println(""+(i+1)+" "+  TipoDeCeramica.values()[i]);
		}
		int opcion =  ingresarNumeroEntero("ingerse opciom");
		
		return TipoDeCeramica.values()[opcion-1];
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

	private static void mostrarPedidosDisponibles(Pedido[] pedidos) {

		for (int i = 0; i < pedidos.length; i++) {
			mostrarPorPantalla(pedidos[i].toString());
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
