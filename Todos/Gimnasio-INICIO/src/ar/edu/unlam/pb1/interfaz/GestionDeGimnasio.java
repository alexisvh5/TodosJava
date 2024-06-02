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

			do {
				numeroIngresado = ingresarNumeroEntero("\n\nIngrese opcion:");
			} while (numeroIngresado  <1 || numeroIngresado >3);
			
			opcionMenuPrincipal = obtenerOpcionDeMenuPrincipal(numeroIngresado);

			switch (opcionMenuPrincipal) {
			case INICIAR_SESION:
				iniciarSesion(gimnasio);
				break;
			case REGISTRARME:
				registrarme(gimnasio);
				break;
			case SALIR:
				System.out.println("chauuuuu");
				break;
			}

		} while (opcionMenuPrincipal != MenuPrincipal.SALIR); 

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

		int dni;
		String contrasenia;
		boolean sale = false;
		do {
			dni = ingresarNumeroEntero("ingrese el numero de dni: ");
			contrasenia = ingresarString("ingrese la contrasenia: ");
			
			if (gimnasio.iniciarSesion(dni, contrasenia)) {
				mostrarPorPantalla("you got it");
				sale = true;
				menuCliente(gimnasio.buscarClientePorDni(dni), gimnasio);
			} else {
				mostrarPorPantalla("alguno de los dos esta mal, volve a ingersar");
			}
		} while (!sale);

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
		int dni;
		boolean correcto = false;
		do {
			dni = ingresarNumeroEntero("ingrese el numero de dni: ");
			if (gimnasio.buscarClientePorDni(dni) == null) {
				correcto = true;
			} else {
				mostrarPorPantalla("El DNI ingresado ya existe.");
			}
		} while (!correcto);

		String nombre = ingresarString("ingrese el nombre: ");

		String contrasenia = "";
		boolean verda = false;
		do {
			contrasenia = ingresarString("ingrese la contrasenia: ");
			if (gimnasio.validarContrasenia(contrasenia)) {   
				
				mostrarPorPantalla("buena contrasenia elegida");

				Cliente nuevoCliente = new Cliente(dni, nombre, contrasenia);
				
				verda = gimnasio.registrarCliente(nuevoCliente);

			} else {
				mostrarPorPantalla("esa contrasenia no es valida, tiene que tener,,..PassWord77.");
			}
		} while (!verda);

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
				// Mientas que no se indique salir con 99, se debe pedir el ingreso del ID de la
				// actividad que se desea realizar, buscarla por su id en el gimnasio y luego
				// hacer que el
				// cliente realice la actividad obtenida.
				
				
				int id ; 
				boolean salgo = false;
				Actividad[]actividades =  gimnasio.obtenerActividadesOrdenadasPorCaloriasQueQuemaDescendente();
				do {
					mostrarActividades(actividades);
				
					id = ingresarNumeroEntero("\n\nIngrese el id de la actividad q desea realizar  o 99 para salir:");
					if (gimnasio.buscarActividadPorId(id)!=null) {
						cliente.realizarActividad(gimnasio.buscarActividadPorId(id));
						mostrarPorPantalla("bien! realizamos la actividad");
						salgo =true;
					}else if(id == 99)
					{System.out.println("\n cahuuuu");}
					else
					{mostrarPorPantalla("no podemos hacer esa actividad xq no existe");}
					
				} while (!salgo && id !=SALIR);
				//PassWord77
				
				break;
			case ELIMINAR_ACTIVIDAD_POR_ID:
				// TODO: Mientras que no se ingrese 99 para salir, se debera mostrar la lista de
				// actividades del cliente para luego solicitar el ingreso del ID de la
				// actividad que se desea eliminar de la lista de actividades del cliente.
				// En caso de ser eliminada con exito, mostrar un mensaje acorde. Hacer lo
				// propio en caso de error.
				int id1 = 0 ; 
				boolean salgo1 = false;
				Actividad[]actividades1 =  cliente.getActividadesQuePuedeRealizar();
				do {
					mostrarActividades(actividades1);
				
					id1 = ingresarNumeroEntero("\n\nIngrese el id de la actividad q desea eliminar  o 99 para salir:");
					if ( cliente.eliminarActividadPorId(id1)) {
						mostrarPorPantalla("bien! YAFUE ELIMINADO");
						salgo1 =true;
					}else if(id1 == 99)
					{System.out.println("\n cahuuuu");}
					else
					{mostrarPorPantalla("no podemos eliminar esa actividad xq no existe");}
					
				} while (!salgo1 && id1 !=SALIR);
				
				break;
			case CALORIAS_QUEMADAS_POR_ACTIVIDAD:
				// TODO: Mostrar un menu que incluya los tipos de actividad para que el usuario
				// pueda elegir un tipo de actividad.
				// Obtener la cantidad de calorias quemadas por actividad del tipo de actividad
				// ingresada por el usuario y mostrar por pantalla el mensaje: Actividad:
				// AEROBICO - Calorias quemadas: 400 donde "AEROBICO" representa la opcion
				// ingresada por el usuario y 400 el valor obtenido.
				mostrarTiposDeActvidades();
				int opcionAct =0;
				 mostrarPorPantalla("ingrese opcoon");
				 opcionAct=teclado.nextInt();
				 
				TipoActividad actElegida = obtenerOpcionDeTipoActividad(opcionAct);
			if (cliente.obtenerCantidadDeCaloriasQuemadasPorActividadDeTipo(actElegida)==0.0) {
				System.out.println("no tenes actividades realizadas");
			}else {System.out.println("ACTIVIDAD : "+actElegida+" -  calorias quemadas: "+cliente.obtenerCantidadDeCaloriasQuemadasPorActividadDeTipo(actElegida));}
					
			
				break;
			case CLIENTE_MENOS_ACTIVIDADES_REALIZO:
				// TODO: Obtiene al cliente que menos actividades realizo y lo muestra por
				// pantalla.
				System.out.println("el cliente q menos realizo es "+ gimnasio.obtenerElClienteQueMenosActividadesRealizo());
				break;
			case SALIR:
				break;
			}

		} while (opcionMenuCliente != MenuCliente.SALIR);

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
	private static TipoActividad obtenerOpcionDeTipoActividad(int numeroIngresado) {
		return TipoActividad.values()[numeroIngresado - 1];
	}

	private static int ingresarNumeroEntero(String mensaje) {
		mostrarPorPantalla(mensaje);
		return teclado.nextInt();
	}

	private static String ingresarString(String mensaje) {
		mostrarPorPantalla(mensaje);
		return teclado.next();
	}
private static void mostrarTiposDeActvidades() {
	mostrarPorPantalla(
			"\n\n1) AEROBICO  \n2) FUNCIONAL ID\n3) PESAS");

}
	private static void mostrarMenuCliente() {
		mostrarPorPantalla(
				"\n\n1) Realizar actividad\n2) Eliminar actividad por su ID\n3) Obtener cantidad de calorias quemadas por tipo de actividad\n4) Obtener el cliente que menos actividades realizo\n5) Salir");
	}

	private static void mostrarMenuPrincipal() {
		mostrarPorPantalla("\n\n1) Iniciar sesion\n2) Registrame\n3)salir");
	}

	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}

}
