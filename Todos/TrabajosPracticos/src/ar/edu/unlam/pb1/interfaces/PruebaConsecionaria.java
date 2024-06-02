package ar.edu.unlam.pb1.interfaces;

import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unlam.pb1.dominios.Consecionaria;
import ar.edu.unlam.pb1.dominios.Coche;

public class PruebaConsecionaria {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Consecionaria actual = new Consecionaria("moco");

		
		
		char opcionIngresada = '\0';

		final char NUEVO_VEHICULO = '1', VER_LISTADO = '2', VER_VEHICULO = '3',VER_LISTADO_ORDENADO_POR_PRECIO ='4', SALIR = 's';

		System.out.println("Bienvenido");

		do {
			System.out.println("1 - Ingresar nuevo vehiculo");
			System.out.println("2 - Mostrar el listado de los vehiculos");
			System.out.println("3 -  ver un vehiculo determinado");
			System.out.println("4 -  ver listado ordenado por precio");
			System.out.println("9 - Salir");
			
			opcionIngresada = teclado.next().charAt(0);

			switch (opcionIngresada) {
			case NUEVO_VEHICULO://instanciar un nuevo vehiculo, dentro de aca xq son "n" canctidad de coches los que vpy a meter en un array 
				Coche nuevo;
				
				String marca;
				String modelo;
				int kilometros;
				int  anio;
				double precio;
				
				System.out.println("Ingresa la marca");
				marca = teclado.next();
				System.out.println("Ingrese el modelo");
				modelo=teclado.next();
				System.out.println("Ingrese los kilometros");
				kilometros=teclado.nextInt();
				System.out.println("Ingrese el año");
				anio=teclado.nextInt();
				System.out.println("ingrese el precio");
				precio=teclado.nextDouble();
				
				nuevo= new Coche(marca, modelo, kilometros, anio, precio);
		
				actual.IngresarNuevoVehiculo(nuevo);
				
				break;
			case VER_LISTADO:
			System.out.println(actual);// es lo mismo q actual.toString
				
				break;
			case VER_LISTADO_ORDENADO_POR_PRECIO:
				Coche cochesOrdenados[]= actual.obtenerFlotaOrdenadaPorPrecio();
				System.out.println("coches ordenados por precio:\n");
				for (int i = 0; i < cochesOrdenados.length; i++) {
					if (cochesOrdenados[i]!=null) {
						System.out.println(cochesOrdenados[i]);
					}
					
				}
				
				System.out.println("");
				
				break;
			case VER_VEHICULO:
				//primero un criterio de busqueda
//				int codigo;
//				System.out.println("ingrese el codigo del auto a buscar");
//				codigo = teclado.nextInt();
//				System.out.println(actual.buscarAuto(codigo));
				String modeloBuscado = "";
				System.out.println("ingerse el modelo");// aunqe puede devolver varios, le pido uno
				modeloBuscado = teclado.next();
				
		if (actual.buscarAuto(modeloBuscado) == null) {
			System.out.println("ese coche noo se encontro");
		}else {System.out.println(actual.buscarAuto(modeloBuscado));
		}
				
				break;
			case SALIR:

				break;

			default:
				System.out.println("la opcion ingressada es invalidad");
				break;
			}

		} while (opcionIngresada != SALIR);

	}

}
