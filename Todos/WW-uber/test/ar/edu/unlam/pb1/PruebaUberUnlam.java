package ar.edu.unlam.pb1;

import java.util.Arrays;
import java.util.Scanner;

/****
 * Interfaz de usuario para la ejecuci�n del software para gesti�n de viajes desde la UNLAM
 * @author Juan Monteagudo
 *
 */
public class PruebaUberUnlam {

	private static Scanner teclado = new Scanner(System.in);
	private static final int INCORPORAR_VEHICULO = 1, AGREGAR_UBICACION = 2, INICIAR_VIAJE = 3, FINALIZAR_VIAJE = 4, CALCULAR_IMPORTE_PROMEDIO = 5, SALIR = 9;
	
	/****
	 * M�todo principal
	 * @param args
	 */
	public static void main (String args[]) {
		String nombreDeLaRemiseria = "Remis UNLAM";
		double precioPorKilometro = 10;
		Remiseria actual = null;
		
		System.out.println("Ingrese el nombre de la remiser�a");
		nombreDeLaRemiseria = teclado.next();
		actual = new Remiseria(nombreDeLaRemiseria, precioPorKilometro);
		
		int opcion = 0;
		do {
			System.out.println(actual);
			mostrarMenu();
			
			opcion = teclado.nextInt();
			
			switch(opcion) {
			case INCORPORAR_VEHICULO:
				incorporarVehiculo(actual);
				break;
			case AGREGAR_UBICACION:
				agregarUbicacion(actual);
				break;
			case INICIAR_VIAJE:
				iniciarViaje(actual);
				break;
			case FINALIZAR_VIAJE:
				finalizarViaje(actual);
				break;
			case CALCULAR_IMPORTE_PROMEDIO:
				calcularImportePromedio(actual);
			default:
				System.out.println("Opci�n inv�lida");
			}		
		} while(opcion!=SALIR);	
	}


	/****
	 * Se visualizan las opciones del men�
	 */
	private static void mostrarMenu() {
		System.out.println("Opciones");
		System.out.println(INCORPORAR_VEHICULO + ". Incorporar nuevo vehiculo");
		System.out.println(AGREGAR_UBICACION + ". Agregar nueva ubicaci�n");
		System.out.println(INICIAR_VIAJE + ". Iniciar nuevo viaje");
		System.out.println(FINALIZAR_VIAJE + ". Finalizar viaje");
		System.out.println(CALCULAR_IMPORTE_PROMEDIO + ". Calcular el importe promedio de viajes");
		System.out.println(SALIR + ". Salir");
		System.out.println("Ingrese la opci�n deseada");
	}
	
	/****
	 * Incorporaci�n de un nuevo veh�culo a la remiser�a
	 * @param actual La remiser�a sobre la cual se est� incorporando el nuevo veh�culo
	 */
	private static void incorporarVehiculo(Remiseria actual) {

	}

	/****
	 * Agregar un destino posible a la remiseria
	 * @param actual La remiser�a sobre la cual se est� incorporando el nuevo destino
	 */
	private static void agregarUbicacion(Remiseria actual) {

	}

	/****
	 * Inicia un viaje
	 * @param actual La remiser�a sobre la cual se est� iniciando el viaje
	 */
	private static void iniciarViaje(Remiseria actual) {
		
	}
	
	/****
	 * Finaliza un viaje
	 * @param actual La remiser�a sobre la cual se est� iniciando el viaje
	 */
	private static void finalizarViaje(Remiseria actual) {

	}
	
	private static void calcularImportePromedio(Remiseria actual) {
	
		
	}

	
}

//String patente, nombreDelConductor, marca, modelo;
//Vehiculo nuevo = null;
//
//System.out.println("Ingrese la marca del veh�culo: ");
//marca = teclado.next();
//System.out.println("Ingrese el modelo del veh�culo: ");
//modelo = teclado.next();
//System.out.println("Ingrese la patente: ");
//patente = teclado.next();
//System.out.println("Ingrese el nombre del conductor: ");
//nombreDelConductor = teclado.next();
//		
//nuevo = new Vehiculo(marca, modelo, patente, nombreDelConductor);
//
//if(actual.agregarNuevoVehiculo(nuevo)) {
//	System.out.println("Se dio de alta el nuevo veh�culo: " + nuevo);
//}
//else {
//	System.out.println("Ocurri� un error. Posiblemente se llen� la capacidad de la flota");
//}


//String nombreUbicacion;
//int distanciaEnKilometros;
//Ubicacion nueva = null;
//
//System.out.println("Ingrese la descripci�n de la nueva ubicaci�n");
//nombreUbicacion = teclado.next();
//System.out.println("Ingrese la distancia en kil�metros");
//distanciaEnKilometros = teclado.nextInt();
//
//nueva = new Ubicacion(nombreUbicacion, distanciaEnKilometros);
//
//boolean resultado = actual.agregarNuevaUbicacion(nueva);
//if(resultado) {
//	System.out.println("Se agreg� la nueva ubicaci�n " + nueva);
//}
//else {
//	System.out.println("Ocurri� un error agregando la ubicaci�n");
//}

//String ubicacionDeseada, patente;
//double precio;
//Vehiculo disponibles[] = actual.buscarVehiculosDisponibles();
//
//System.out.println(Arrays.toString(disponibles));
//System.out.println("Ingrese el vehiculo deseado");
//patente = teclado.next();
//
//System.out.println("Ingrese la ubicaci�n a la que desea ir:");
//ubicacionDeseada = teclado.next();
//
//precio = actual.iniciarViaje(patente, ubicacionDeseada); 
//if(precio > 0) {
//	System.out.println("Se inici� el viaje. El precio ser� $ " + precio + ". Recuerde avisar cuando finaliza para liberar el vehiculo");
//}		

////		String patente;
//Vehiculo enViaje[] = actual.buscarVehiculosEnViaje();
//
//System.out.println(Arrays.toString(enViaje));
//System.out.println("Ingrese el vehiculo que termin� su viaje");
//patente = teclado.next();
//
//if(actual.finalizarViaje(patente)) {
//	System.out.println("Se finaliz� el viaje. El vehiculo utilizado ya se encuentra disponible nuevamente");
//}		
//else {
//	System.out.println("Ese veh�culo no estaba en ning�n viaje");
//}