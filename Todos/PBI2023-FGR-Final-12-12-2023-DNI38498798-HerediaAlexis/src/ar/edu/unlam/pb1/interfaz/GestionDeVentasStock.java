package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominio.CategoriaProducto;
import ar.edu.unlam.pb1.dominio.OpcionMenuPrincipal;
import ar.edu.unlam.pb1.dominio.Producto;
import ar.edu.unlam.pb1.dominio.StockProducto;
import ar.edu.unlam.pb1.dominio.Sucursal;
import ar.edu.unlam.pb1.dominio.Venta;
import ar.edu.unlam.pb1.tools.Keyboard;

public class GestionDeVentasStock {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Sucursal nuevaSucursal = new Sucursal("Sucursal 1");
		System.out.println("hola " + nuevaSucursal.getNombre());
//
//		for (int i = 0; i < OpcionMenuPrincipal.values().length; i++) {
//			System.out.println("dame el valor de cada " + OpcionMenuPrincipal.values()[i]);
//		}

		cargaInicialDeStock(nuevaSucursal);

		OpcionMenuPrincipal opcion = null;
		do {
			opcion = obtenerOpcionParaMenuPrincipal();

			switch (opcion) {

			case OPCION1:
				mostrarStockDeSucursal(nuevaSucursal);

				break;
			case OPCION2:
				agregarProductoNuevoAlStockDeSucursal(nuevaSucursal);

				break;
			case OPCION3:
				agregarProductoExistenteAlStockDeSucursal(nuevaSucursal);
				break;
			case OPCION4:
				vender(nuevaSucursal);
				break;
			case OPCION5:
				mostrarVentas(nuevaSucursal);

				break;
			case OPCION6:
				mostrarVentaMayorMonto(nuevaSucursal);

				break;
			case OPCION7:
				mostrarVentaOrdenadasPorMonto(nuevaSucursal);

				break;
			case SALIR:

				break;

			default:
				break;
			}

		} while (opcion != OpcionMenuPrincipal.SALIR);

	}

	private static void cargaInicialDeStock(Sucursal sucursal) {
		// TODO: No es necesario modificar este metodo.
		sucursal.agregarProductoNuevoAlStock(
				new Producto("Sugus masticables", 30.5f, "000001", CategoriaProducto.GOLOSINAS), 10);
		sucursal.agregarProductoNuevoAlStock(
				new Producto("Capitan del espacio", 100.0f, "000002", CategoriaProducto.GOLOSINAS), 10);
		sucursal.agregarProductoNuevoAlStock(new Producto("Camel 10u", 930.5f, "000003", CategoriaProducto.CIGARRILLOS),
				10);
		sucursal.agregarProductoNuevoAlStock(
				new Producto("Marlboro box", 1500.5f, "000004", CategoriaProducto.CIGARRILLOS), 10);
		sucursal.agregarProductoNuevoAlStock(
				new Producto("Juego de dados", 3000.0f, "000005", CategoriaProducto.JUGUETES), 10);
		sucursal.agregarProductoNuevoAlStock(
				new Producto("Mazo de cartas españolas", 2000.5f, "000006", CategoriaProducto.JUGUETES), 10);
		sucursal.agregarProductoNuevoAlStock(
				new Producto("Villavicencio 500ml", 200.0f, "000007", CategoriaProducto.AGUAS), 10);
		sucursal.agregarProductoNuevoAlStock(new Producto("Eco 500ml", 210.5f, "000008", CategoriaProducto.AGUAS), 10);
		sucursal.agregarProductoNuevoAlStock(
				new Producto("Coca Cola 1.5l", 2000.5f, "000009", CategoriaProducto.GASEOSAS), 10);
		sucursal.agregarProductoNuevoAlStock(
				new Producto("Paso de los toros 1.5l", 1000.0f, "000010", CategoriaProducto.GASEOSAS), 10);
	}

	private static void mostrarStockDeSucursal(Sucursal sucursal) {
		// TODO: No es necesario modificar este metodo.
		System.out.println("-----------------------------------------------------------------");
		sucursal.mostrarStockDeSucursal();
		System.out.println("-----------------------------------------------------------------");
	}

	private static void agregarProductoNuevoAlStockDeSucursal(Sucursal sucursal) {
		// TODO: Este metodo debe agregar un producto nuevo al stock,
		// se entiende producto nuevo un producto con un nuevo codigo de barras.
		// Se debe validar que el producto no exista.

		String descripcion = ingreseDescripcion("ingrese la descripcion del prod");
		teclado.nextLine();
		float precio = ingresarFloat("ingrese el precio del prod");

		String categoriaString;

		CategoriaProducto categoria = null;
		do {
			categoriaString = ingreseString(" ingrese si es: \nGOLOSINAS \nJUGUETES \nTABACO \nGASEOSAS \nAGUAS");
			categoria = ingreseCategoria(categoriaString);
			// System.out.println(categoria);
		} while (categoria == null);

		int cantidad = ingreseInt("ingrese el stock");
		String codigoDeBarra = cargarCodigoDeBarras();

		if (sucursal.buscarProductoPorCodigoDeBarras(codigoDeBarra) == null) {
			Producto nuevo = new Producto(descripcion, precio, codigoDeBarra, categoria);
			sucursal.agregarProductoNuevoAlStock(nuevo, cantidad);
		}
	}

	private static void agregarProductoExistenteAlStockDeSucursal(Sucursal sucursal) {
		// TODO: Este metodo debe agregar cantidad a un producto existente en el stock,
		// se entiende que el producto existe y se lo debe buscar por su codigo de
		// barras.
		// Se debe validar que el producto exista.
		String codigoBarra;
		do {
			codigoBarra = ingreseString("ingrese el cod de barra");
			if (sucursal.buscarProductoPorCodigoDeBarras(codigoBarra) == null) {
				System.out.println("no existe un producto con ese codigo");
			}
		} while (sucursal.buscarProductoPorCodigoDeBarras(codigoBarra) == null);

		int cantidad = ingresarInt("ingrese la cantidad");

		if (sucursal.agregarProductoExistenteAlStock(sucursal.buscarProductoPorCodigoDeBarras(codigoBarra), cantidad)) {
			System.out.println("se agrego correctamente");
			System.out.println("cantidad nueva " + sucursal.buscarStockProductoPorCodigoDeBarras(codigoBarra));
		} else {
			System.out.println("hubo algun error y no se pudo");
		}
		;

	}

	private static void vender(Sucursal sucursal) {
		// TODO: Este metodo debe permitir realizar una venta de N productos existentes
		// en el stock,
		// se entiende que el producto existe y se lo debe buscar por su codigo de
		// barras.
		// Se debe validar que el producto exista.
		// Se debe finalizar la venta mediante una corte, quizas preguntanto al usuario.
		// No se puede vender 0 (cero productos)
		// No se puede vender mas cantidad de la existente en el stock.
		int cantidadAVender = 0;
		boolean salida=false;
		String seguir=" ";
		
		do {
			String codigo = ingreseString("ingrese el cod de barras");
			Producto prodBuscado = sucursal.buscarProductoPorCodigoDeBarras(codigo);
			cantidadAVender = ingreseInt("ingerse cantidad a vender");
			
			if (prodBuscado != null && cantidadAVender !=0 && sucursal.buscarStockProductoPorCodigoDeBarras(codigo).getCantidad() >= cantidadAVender) {

				if (sucursal.quitarProductoAlStock(sucursal.buscarProductoPorCodigoDeBarras(codigo), cantidadAVender)) {

					System.out.println("se pudo vender!!!!");

					System.out.println(sucursal.buscarStockProductoPorCodigoDeBarras(codigo));
					
					System.out.println("queeres continuar vendiendo? si/no");
					seguir =teclado.next();
					if (seguir.equals("no")) {
						salida=true;
					}else {System.out.println("continuemos");}
				}
			} else {
				System.out.println("ese codigo no existe o ingersaste mal la cantidad de productos a vender");
			}
		} while (!salida);
		

	}

	private static void mostrarVentas(Sucursal sucursal) {
		// TODO: No es necesario modificar este metodo.
		sucursal.mostrarVentas();
	}

	private static void mostrarVentaMayorMonto(Sucursal sucursal) {
		// TODO: No es necesario modificar este metodo.
		sucursal.mostrarVentaMayorMonto();
	}

	private static void mostrarVentaOrdenadasPorMonto(Sucursal sucursal) {
		// TODO: No es necesario modificar este metodo.
		sucursal.mostrarVentaOrdenadasPorMonto();
	}

	private static String cargarCodigoDeBarras() {
		// TODO: Este metodo debe permitir la carga de un codifo de barras con el
		// siguiente formato:
		// Longitud de 6 caracteres, solo numeros. ej: "000001"
		String codigoDeBarras = "";
		boolean verdad = false;

		do {
//			ingreseString("ingrese cod de barras, debe ser de 6 numeros : ");
//			codigoDeBarras = teclado.next();
			codigoDeBarras = ingreseString("ingrese codigo de barras, deben ser 6 numeros:");
			System.out.println(codigoDeBarras.length());

			if (codigoDeBarras.length() == 6) {
				verdad = true;
			} else {
				System.out.println("intente colocando la cantidad indicada");
			}

		} while (!verdad);

		return codigoDeBarras;
	}

	private static OpcionMenuPrincipal obtenerOpcionParaMenuPrincipal() {
		// TODO: Mostrar las opciones del menu principal, solicitar el ingreso de la
		// opcion deseada, obtenerla desde el enum y devolverla.
		// Se debera validar que la opcion ingresada este dentro de los valores del
		// enum.
		// Se debera utilizar los metodos del enum (ver metodos max/min y obtenerOpcion)

		for (int i = 0; i < OpcionMenuPrincipal.values().length; i++) {
			System.out.println(OpcionMenuPrincipal.values()[i]);
		}

		int opcion;
		do {
			opcion = ingresarInt("ingrese la opcion deseada");
			if (opcion == 8) {
				System.out.println("chauuuuuuu");
			}
		} while (opcion < 1 || opcion > 8);

		return OpcionMenuPrincipal.values()[opcion - 1];
	}

	private static int ingresarInt(String mensaje) {

		System.out.println(mensaje);

		return teclado.nextInt();

	}

	private static CategoriaProducto obtenerCategoriaProducto() {
		// TODO: Mostrar las categorias de productos, solicitar el ingreso de la
		// categoria deseada, obtenerla desde el enum y devolverla.
		// Se debera validar que la opcion ingresada este dentro de los valores del
		// enum.
		// Se debera utilizar los metodos del enum (ver metodos max/min y obtenerOpcion)

		CategoriaProducto opcionCat = null;
		String opcion;

		do {
			for (int i = 0; i < CategoriaProducto.values().length; i++) {
				System.out.println(CategoriaProducto.values()[i]);
			}
			opcion = ingreseString("ingrese el la categoria");
			opcionCat = CategoriaProducto.valueOf(opcion.toUpperCase());

		} while (CategoriaProducto.valueOf(opcion.toUpperCase()).ordinal() < CategoriaProducto.min()
				|| CategoriaProducto.valueOf(opcion.toUpperCase()).ordinal() > CategoriaProducto.max());

		return opcionCat;
	}

	private static String ingreseDescripcion(String mensaje) {
		System.out.println(mensaje);
		return teclado.nextLine();
	}

	private static int ingreseInt(String mensaje) {
		// TODO Auto-generated method stub
		System.out.println(mensaje);
		return teclado.nextInt();
	}

	private static CategoriaProducto ingreseCategoria(String categoria) {
		// TODO Auto-generated method stub

		int i = 0;
//		String opcionIngresada = ;
		CategoriaProducto opcionCategoria = null;

		while (i < CategoriaProducto.values().length) {
//System.out.println(CategoriaProducto.values()[i].toString().toUpperCase() + ", "+ categoria.toUpperCase());

			if (CategoriaProducto.values()[i].toString().toUpperCase().equals(categoria.toUpperCase())) {

				opcionCategoria = CategoriaProducto.values()[i];

				i = CategoriaProducto.values().length;

			}
			i++;

			// System.out.println("total: "+ CategoriaProducto.values().length);2

		}

		return opcionCategoria;
	}

	private static float ingresarFloat(String mensaje) {
		System.out.println(mensaje);
		return teclado.nextFloat();
	}

	private static String ingreseString(String mensaje) {
		System.out.println(mensaje);
		return teclado.next();
	}

}
