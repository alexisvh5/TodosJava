package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominio.Actividad;
import ar.edu.unlam.pb1.dominio.Cliente;
import ar.edu.unlam.pb1.dominio.Gimnasio;
import ar.edu.unlam.pb1.dominio.MenuCliente;
import ar.edu.unlam.pb1.dominio.MenuPrincipal;
import ar.edu.unlam.pb1.dominio.TipoActividad;


public class GestionDeGimnasio {
	private static final int SALIR = 99;
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int numeroIngresado = 0;
		MenuPrincipal opcionMenuPrincipal = null;
		Gimnasio gimnasio = new Gimnasio("Mi Gimnasio");

		do {
			mostrarPorPantalla("\nHola! Quememos calorias");
			mostrarMenuPrincipal();

			numeroIngresado = ingresarNumeroEntero("\n\nIngrese opcion:");
			opcionMenuPrincipal = obtenerOpcionDeMenuPrincipal(numeroIngresado);

			switch (opcionMenuPrincipal) {
			case INICIAR_SESION:
				iniciarSesion(gimnasio);
				break;
			case REGISTRARME:
				registrarme(gimnasio);
				break;
			}

		} while (!opcionMenuPrincipal.equals(MenuPrincipal.INICIAR_SESION)
				|| !opcionMenuPrincipal.equals(MenuPrincipal.REGISTRARME));

	}

	private static void iniciarSesion(Gimnasio gimnasio) {
		mostrarPorPantalla("\n\nIniciemos sesion!");
		// Pide el ingreso de credenciales (DNI y contrasenia)
		// Verifica si con esas credenciales se puede iniciar sesion
		// Si el inicio de sesion es exitoso, se muestra un mensaje de exito y seguido
		// el menu del cliente. Caso
		// contrario, se muestra el mensaje de error: "Usuario y/o contrasenia invalido"
		// Si el inicio de sesion fue exitoso, se debera mostrar el menu del cliente
		// Tener presente que parametros recibe el metodo menuCliente
		
		
		int dni = ingresarNumeroEntero("DNI: ");
		String contrasenia = ingresarString("contrasenia: ");
		boolean ingresoExitoso = gimnasio.iniciarSesion(dni, contrasenia);
		
		if(ingresoExitoso) {
			mostrarPorPantalla("ingresoExitoso");
			Cliente clienteIngresa = gimnasio.buscarClientePorDni(dni);
			menuCliente(clienteIngresa,gimnasio);
		}else {
			mostrarPorPantalla("usuario y/ocontrasenia invalido");
		}
		
	}
	
	private static void registrarme(Gimnasio gimnasio) {
		// Pide el ingreso de los datos necesarios para crear un cliente
		// Debe verificar que la contrasenia sea valida. En caso de no ser valida, se
		// debera volver a ingresar hasta que sea valida.
		// Se debe corroborar que el cliente no exista buscandolo por su dni. Si existe,
		// mostrar el mensaje: "El DNI ingresado ya existe."
		// Si no existe, entonces se procede a registrar el cliente en el gimnasio. Se
		// debe mostrar un mensaje en caso de exito y otro de error si no se pudo
		// registrar.
	}

	private static void menuCliente(Cliente cliente, Gimnasio gimnasio) {
		MenuCliente opcionMenuCliente = null;
		int numeroIngresado = 0;

		do {
			mostrarMenuCliente();
			numeroIngresado = ingresarNumeroEntero("\n\nIngrese opcion:");
			opcionMenuCliente = obtenerOpcionDeMenuCliente(numeroIngresado);
			int opcion = 0;

			switch (opcionMenuCliente) {
			case REGISTRAR_ACTIVIDAD:
				// TODO: Obtiene las actividades disponibles para realizar en el gimnasio.
				// (obtenerActividadesOrdenadasPorCaloriasQueQuemaDescendente()) y las muestra.
				//------ Mientas que no se indique salir con 99, se debe pedir el ingreso del ID de la
				// actividad que se desea realizar, buscarla por su id en el gimnasio y luego hacer que el
				// cliente realice la actividad obtenida.
				
				registrarActividad(cliente,gimnasio);
				break;
			case ELIMINAR_ACTIVIDAD_POR_ID:
				// TODO: Mientras que no se ingrese 99 para salir, se debera mostrar la lista de
				// actividades del cliente para luego solicitar el ingreso del ID de la
				// actividad que se desea eliminar de la lista de actividades del cliente.
				// En caso de ser eliminada con exito, mostrar un mensaje acorde. Hacer lo
				// propio en caso de error.
				 eliminarActividadPorId(cliente,gimnasio);
				
				break;
			case CALORIAS_QUEMADAS_POR_ACTIVIDAD:
				// TODO: Mostrar un menu que incluya los tipos de actividad para que el usuario
				// pueda elegir un tipo de actividad.
				// Obtener la cantidad de calorias quemadas por actividad del tipo de actividad
				// ingresada por el usuario
				///y mostrar por pantalla el mensaje: Actividad:
				// AEROBICO - Calorias quemadas: 400 donde "AEROBICO" representa la opcion
				// ingresada por el usuario y 400 el valor obtenido.
				
				caloriasQuemadasPorActividad(cliente, gimnasio);				
				break;
			case CLIENTE_MENOS_ACTIVIDADES_REALIZO:
				// TODO: Obtiene al cliente que menos actividades realizo y lo muestra por pantalla.
				clienteQueMenosActRealizo(cliente, gimnasio);
				break;
			case SALIR:
				break;
			}

		} while (!opcionMenuCliente.equals(MenuCliente.SALIR));

	}



	private static void clienteQueMenosActRealizo(Cliente cliente, Gimnasio gimnasio) {
Cliente clienteVago = gimnasio.obtenerElClienteQueMenosActividadesRealizo();
if(clienteVago !=null) {mostrarPorPantalla(clienteVago.toString());}		
else {
	mostrarPorPantalla("no hay cliente con menor actividad");}
	}

	private static void caloriasQuemadasPorActividad(Cliente cliente, Gimnasio gimnasio) {
		// TODO Auto-generated method stub
	
		mostrarPorPantalla("elegir tipo de actividad : 1-aerobico - 2-funcional o 3-pesas");
		int opcionElegida = teclado.nextInt();
		TipoActividad tipoDeActividadElegida = TipoActividad.values()[opcionElegida - 1];
	
		switch (tipoDeActividadElegida) {
		case AEROBICO: 
			double cantidad =cliente.obtenerCantidadDeCaloriasQuemadasPorActividadDeTipo(tipoDeActividadElegida);
			mostrarPorPantalla("Actividad: AEROBICO - Calorias quemadas: "+ cantidad);
			break;
		case FUNCIONAL: 
			double cantidadFuncional =cliente.obtenerCantidadDeCaloriasQuemadasPorActividadDeTipo(tipoDeActividadElegida);
			mostrarPorPantalla("Actividad: Funcional - Calorias quemadas: "+ cantidadFuncional);
			break;
		case PESAS: 
			double cantidadPesas = cliente.obtenerCantidadDeCaloriasQuemadasPorActividadDeTipo(tipoDeActividadElegida);
			mostrarPorPantalla("Actividad: pesas - Calorias quemadas: "+ cantidadPesas);
			break;
			
		default:
			
		}
	}

	private static void eliminarActividadPorId(Cliente cliente, Gimnasio gimnasio) {
		int id = 0;
		
	do {
			mostrarActividades(gimnasio.obtenerActividadesOrdenadasPorCaloriasQueQuemaDescendente());
			
			mostrarPorPantalla("99 para salir");
		
			 id = ingresarNumeroEntero("ingrese numero de la act: ");
	if (id != SALIR) {
				Actividad  actividadEncontrada = gimnasio.buscarActividadPorId(id);
			if (actividadEncontrada != null) {
				cliente.eliminarActividadPorId(id);
				mostrarPorPantalla("listo eliminada");
			}
			else {
				mostrarPorPantalla("actividad no encontrada");
			}		
	}
			
			
		}	while(id!=SALIR);
		
	}

	private static void registrarActividad(Cliente cliente, Gimnasio gimnasio) {
		
		int id = 0;
		
	do {
			mostrarActividades(gimnasio.obtenerActividadesOrdenadasPorCaloriasQueQuemaDescendente());
			
			mostrarPorPantalla("99 para salir");
		
			 id = ingresarNumeroEntero("ingrese numero de la act: ");
	if (id != SALIR) {
				Actividad  actividadEncontrada = gimnasio.buscarActividadPorId(id);
			if (actividadEncontrada != null) {
				cliente.realizarActividad(actividadEncontrada);
			}
			else {
				mostrarPorPantalla("actividad no encontrada");
			}		
	}
			
			
		}	while(id!=SALIR);
			
		
	}

	private static void mostrarActividades(Actividad[] actividades) {

		for (int i = 0; i < actividades.length; i++) {
			if (actividades[i] != null) {
				mostrarPorPantalla(actividades[i].toString());
			}
		}
	}

	private static MenuCliente obtenerOpcionDeMenuCliente(int numeroIngresado) {
		return MenuCliente.values()[numeroIngresado - 1];
	}

	private static MenuPrincipal obtenerOpcionDeMenuPrincipal(int numeroIngresado) {
		return MenuPrincipal.values()[numeroIngresado - 1];
	}

	private static int ingresarNumeroEntero(String mensaje) {
		mostrarPorPantalla(mensaje);
		return teclado.nextInt();
	}

	private static String ingresarString(String mensaje) {
		mostrarPorPantalla(mensaje);
		return teclado.next();
	}

	private static void mostrarMenuCliente() {
		mostrarPorPantalla(
				"\n\n1) Realizar actividad\n2) Eliminar actividad por su ID\n3) Obtener cantidad de calorias quemadas por tipo de actividad\n4) Obtener el cliente que menos actividades realizo\n5) Salir");
	}

	private static void mostrarMenuPrincipal() {
		mostrarPorPantalla("\n\n1) Iniciar sesion\n2) Registrame");
	}

	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}

}
