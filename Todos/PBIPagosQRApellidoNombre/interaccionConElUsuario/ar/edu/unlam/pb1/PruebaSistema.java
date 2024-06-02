package ar.edu.unlam.pb1;

import java.util.Scanner;

public class PruebaSistema {
	
	private static Scanner teclado = new Scanner(System.in);
	private static final int AGREGAR_PRODUCTO = 1, AGREGAR_Venta = 2, VER_RESUMEN = 3, SALIR = 9;
	
	public static void main(String args[]) {
		SistemaDePagos actual;
		String nombre;
		
		System.out.println("Ingrese el nombre del sistema");
		nombre = teclado.next();
		actual = new SistemaDePagos(nombre);
		
		int opcion = 0;
		do {
			System.out.println(actual);
			mostrarMenu();
			opcion = teclado.nextInt();
			switch(opcion) {
			case AGREGAR_PRODUCTO:
				agregarNuevoProducto(actual);
				break;
			case AGREGAR_Venta:
				agregarVenta(actual);
				break;			
			case VER_RESUMEN:
				agregarNuevoProducto(actual);
				break;
			case SALIR:
				System.out.println();
				break;
			default:
				System.out.println("Opción inválida");
			}		
		} while(opcion!=SALIR);	
	}

	private static void mostrarMenu() {
		System.out.println("Opciones");
		System.out.println(AGREGAR_PRODUCTO + ". Agregar un nuevo producto al sistema");
		System.out.println(AGREGAR_Venta + ". Agregar una nueva Venta al sistema");
		System.out.println(VER_RESUMEN + ". Ver el resumen de las Ventas realizadas");
		System.out.println(SALIR + ". Salir");
		System.out.println("Ingrese la opción deseada");
	}
	

	private static void agregarNuevoProducto(SistemaDePagos actual) {
		int codigo = 0;
		double precio = 0.0;
		String descripcion = "";
		
		System.out.println("Ingrese el código");
		codigo = teclado.nextInt();
		System.out.println("Ingrese el precio");
		precio = teclado.nextDouble();
		System.out.println("Ingrese la descripción");
		descripcion = teclado.next();
		
		Producto nuevo = new Producto (codigo, precio, descripcion);
		
		if(actual.agregarProducto(nuevo)) {
			System.out.println("Producto agregado correctamente");
		}
		else {
			System.out.println("No se pudo agregar el producto");
		}
	}
	
	private static void agregarVenta(SistemaDePagos actual) {
		int codigoDeProducto = 0;
		long codigoQR = 0;
		String eMail = "", cuil = "";
		double porcentajeDescuento = 0.0;
		
		System.out.println("Ingrese el eMail del cliente");
		eMail = teclado.next();
		System.out.println("Ingrese el CUIL del cliente");
		cuil = teclado.next();
		System.out.println("Ingrese el porcentaje de descuento. Por ejemplo 0.10 para un 10% de descuento");
		porcentajeDescuento = teclado.nextDouble();
		codigoQR = actual.generarNuevoCodigoQR();
		Venta nueva = new Venta(eMail, cuil, codigoQR, porcentajeDescuento);
		
		do {
			System.out.println("Ingrese el código de producto que desea agregar. Para finalizar ingrese -1");
			codigoDeProducto = teclado.nextInt();
			Producto aIncorporar = actual.buscarProducto(codigoDeProducto);
			if(aIncorporar != null && nueva.agregarProducto(aIncorporar)) {
				System.out.println("El producto se agregó correctamente");
			}
			else {
				System.out.println("El producto no se pudo agregar");
			}
			System.out.println("Importe total: " + nueva.getImporteTotal());
		} while(codigoDeProducto!=-1);	
		 
		if(actual.agregarVenta(nueva)) {
			System.out.println("La venta se agregó correctamente");
		}
		else {
			System.out.println("No se pudo agregar la venta");
		}
	}
	
	private static void verResumen(SistemaDePagos actual) {
		System.out.println("A continuación se imprime un resumen de las ventas realizadas");
		System.out.println(actual);
		System.out.println("El importe promedio es: " + actual.calcularImportePromedio());
		System.out.println("El importe total es: " + actual.calcularImporteTotal());		
	}
}
