package ar.edu.unlam.interfaz;

import java.util.Scanner;

import ar.edu.unlam.dominio.Cliente;
import ar.edu.unlam.dominio.GestionDeSistema;
import ar.edu.unlam.dominio.Pedido;
import ar.edu.unlam.dominio.Producto;
import ar.edu.unlam.dominio.enums.OpcionesDePago;
import ar.edu.unlam.interfaz.enums.MenuPrincipal;

public class PruebaDeSistema {

	private static final Scanner teclado = new Scanner(System.in);
	private static final int SALIR = 99;

	/****
	 * Se debe modificar el método main cumpliendo las siguientes condiciones: 1. Se
	 * debe solicitar el ingreso de las variables máximo y minimo hasta que se
	 * cumpla la condición que el máximo sea mayor al mínimo. 2. Se debe mostrar el
	 * menú principal hasta que el usuario decida finalizar (salir). 3. En
	 * SELECCIONAR_PRODUCTO, se debe repetir la acción hasta que la condición
	 * productosIngresados sea true.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		double maximo, minimo = 0;

		// ¿Que agregarías en esta línea
		mostrarPorPantalla("Ingrese monto maximo y minimo del dia de los productos");
		do {
			maximo = ingresarNumeroDecimal();
			minimo = ingresarNumeroDecimal();
			if (maximo < minimo) {
				mostrarPorPantalla("no puede ser q el maximo sea menor que el minimo");
			}
		} while (maximo < minimo);

		//

		GestionDeSistema actual = new GestionDeSistema(maximo, minimo);

		MenuPrincipal opcionDeMenuPrincipal = null;
		int numeroIngresado = 0;

		// ¿Que agregarías en esta línea

		do {

			mostrarMenuPrincipal();
			numeroIngresado = ingresarNumeroEntero();
			opcionDeMenuPrincipal = obtenerOpcionDelMenuPrincipal(numeroIngresado);

			switch (opcionDeMenuPrincipal) {

			case SELECCIONAR_PRODUCTO:
			
				mostrarCatalogoDeProductos(actual.ObtenerProductosDisponiblesDelDiaOrdenadosPorPrecio());

				Producto encontrado = null;
				boolean productosIngresados = false;

				// ¿Que agregarías en esta línea

				do {
					
					mostrarPorPantalla("\nIngrese el codigo del producto. Para salir de la opcion, ingrese 99");
					numeroIngresado = ingresarNumeroEntero();
					encontrado = actual.buscarProductoAAgregar(numeroIngresado);

					if (encontrado != null && actual.agregarProducto(encontrado)) {
						mostrarPorPantalla("\nProducto agregado correctamente");
						mostrarCatalogoDeProductos(actual.getProductos());

					} else if (numeroIngresado == SALIR) {
						productosIngresados = true;
					} else {
						mostrarPorPantalla("\nError. No se ha podido insertar el producto solicitado");
					}
				} while (!productosIngresados);

				//
				break;
			case GENERAR_PEDIDO:
				imprimirPedido(generarPedido(actual));
				break;
			case COBRAR_PEDIDO:

				double montoSinDescuento = cobrarPedido(actual);

				OpcionesDePago opcionesDePago = null;

				mostrarOpcionesDePago();
				numeroIngresado = ingresarNumeroEntero();
				opcionesDePago = obtenerOpcionDePago(numeroIngresado);

				double montoTotal = actual.aplicarDescuento(opcionesDePago, montoSinDescuento);
				System.out.println("\n\tMonto total a coobrar :" + montoTotal);
				break;
			case SALIR:
				System.out.println("El programa se ha cerrado correctamente");
				teclado.close();
				break;
			default:
				System.out.println("Opcion invalida");
			}
		} while (opcionDeMenuPrincipal != MenuPrincipal.SALIR);
		//

	}

	private static double ingresarNumeroDecimal() {

		return teclado.nextDouble();
	}

	private static void mostrarMenuPrincipal() {

		System.out.println("\n\tSeleccione alguna de las siguientes opciones\n");

		String menu = "\t1-" + MenuPrincipal.SELECCIONAR_PRODUCTO + ". Agrega el producto solicitado por el usuario"
				+ "\n\t2-" + MenuPrincipal.GENERAR_PEDIDO
				+ ". Genera un pedido con los detalles de los productos y del cliente" + "\n\t3-"
				+ MenuPrincipal.COBRAR_PEDIDO + ". Realiza el cobro de pedido" + "\n\t4-" + MenuPrincipal.SALIR
				+ ". Finaliza el programa";

		mostrarPorPantalla(menu + "\n\n\tIngrese la opcion deseada");
	}

	private static int ingresarNumeroEntero() {
		return teclado.nextInt();
	}

	private static MenuPrincipal obtenerOpcionDelMenuPrincipal(int numeroIngresado) {
		return MenuPrincipal.values()[numeroIngresado - 1];
	}

	private static void mostrarPorPantalla(String mensaje) {

		System.out.println(mensaje);
	}

	private static void mostrarCatalogoDeProductos(Producto[] catalogo) {

		for (Producto producto : catalogo) {
			if (producto != null) {
				mostrarPorPantalla("" + producto);
			}
		}
	}

	private static Pedido generarPedido(GestionDeSistema actual) {

		Pedido pedido = new Pedido();
		Cliente cliente = null;

		mostrarPorPantalla("Ingrese cuil del cliente");
		long cuil = ingresarNumeroLong();
		mostrarPorPantalla("Ingrese email del cliente");
		String email = ingresarString();

		if (actual.validarEmailDeCliente(email)) {
			cliente = new Cliente(cuil, email);
			pedido = actual.generarPedido(cliente, actual.getProductos());
	
		
		}else {System.out.println("esta mal, ingresaste mal al cliente ");}
		return pedido;
	}

	private static void imprimirPedido(Pedido pedido) {

		System.out.println(pedido.toString());

	}

	private static double cobrarPedido(GestionDeSistema actual) {

		return actual.cobrarPedido();
	}

	private static void mostrarOpcionesDePago() {
		System.out.println("\n\tSeleccione alguna de las siguientes opciones\n");

		String menu = "\t1-" + OpcionesDePago.EFECTIVO + " y " + OpcionesDePago.MERCADO_PAGO
				+ ". Opcion con descuento del 15%" + "\n\t2-" + OpcionesDePago.TARJETA_DE_DEBITO
				+ ". Opcion con descuento de un 20%" + "\n\t3-" + OpcionesDePago.TARJETA_DE_CREDITO
				+ ". Opcion con descuento de un 25%";

		mostrarPorPantalla(menu + "\n\n\tIngrese la opcion deseada");
	}

	private static OpcionesDePago obtenerOpcionDePago(int numeroIngresado) {
		return OpcionesDePago.values()[numeroIngresado - 1];
	}

	private static long ingresarNumeroLong() {

		return teclado.nextLong();

	}

	private static String ingresarString() {

		return teclado.next();

	}
}
