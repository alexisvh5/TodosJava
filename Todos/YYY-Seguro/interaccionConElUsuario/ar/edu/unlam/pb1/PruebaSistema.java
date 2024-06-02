package ar.edu.unlam.pb1;

import java.util.Scanner;

public class PruebaSistema {
	
	private static Scanner teclado = new Scanner(System.in);
	private static final int CONFIGURAR_USERNAME = 1, CONFIGURAR_PASSWORD = 2, CREAR_NUEVO_USUARIO = 3, PROBAR_LOGIN = 4, SALIR = 9;
	
	public static void main(String args[]) {
		SistemaSeguro actual;
		String nombre;
		
		System.out.println("Ingrese el nombre del sistema");
		nombre = teclado.next();
		actual = new SistemaSeguro(nombre);
		
		int opcion = 0;
		do {
			System.out.println(actual);
			mostrarMenu();
			opcion = teclado.nextInt();
			switch(opcion) {
			case CONFIGURAR_USERNAME:
				configurarCaracteristicasDelUserName(actual);
				break;
			case CONFIGURAR_PASSWORD:
				configurarCaracteristicasDelPassword(actual);
				break;			
			case CREAR_NUEVO_USUARIO:
				crearNuevoUsuario(actual);
				break;
			case PROBAR_LOGIN:
				probarLogin(actual);
				break;
			case SALIR:
				System.out.println();
				break;
			default:
				System.out.println("Opci�n inv�lida");
			}		
		} while(opcion!=SALIR);	
	}

	private static void mostrarMenu() {
		System.out.println("Opciones");
		System.out.println(CONFIGURAR_USERNAME + ". Configurar las caracter�sticas que deben tener los nombres de usuario");
		System.out.println(CONFIGURAR_PASSWORD + ". Configurar las caracter�sticas que deben tener las contrase�as");
		System.out.println(CREAR_NUEVO_USUARIO + ". Agregar un nuevo usuario al sistema");
		System.out.println(PROBAR_LOGIN + ". Verificar que los usuarios se puedan loguear");
		System.out.println(SALIR + ". Salir");
		System.out.println("Ingrese la opci�n deseada");
	}
	
	private static void configurarCaracteristicasDelUserName(SistemaSeguro actual) {
		Credencial userNameConfiguration = configurarCaracteristicasDeLaCredencial();
		actual.setUserNameConfiguration(userNameConfiguration);
	}
	
	private static void configurarCaracteristicasDelPassword(SistemaSeguro actual) {
		Credencial password = configurarCaracteristicasDeLaCredencial();
		actual.setPasswordConfiguration(password);
	}
	
	private static Credencial configurarCaracteristicasDeLaCredencial() {
		Credencial aModificar = new Credencial();
		
		System.out.println("Ingrese el largo m�nimo del nombre de usuario");
		aModificar.setLargoMinimo(teclado.nextInt());
		
		System.out.println("Ingrese el largo m�ximo del nombre de usuario");
		aModificar.setLargoMaximo(teclado.nextInt());
		
		System.out.println("Ingrese la cantidad de caracteres num�ricos m�nimos del nombre de usuario");
		aModificar.setCaracteresNumericosMinimos(teclado.nextInt());
		
		System.out.println("Ingrese la cantidad de caracteres num�ricos m�ximos del nombre de usuario");
		aModificar.setCaracteresNumericosMaximos(teclado.nextInt());
		
		System.out.println("Ingrese la cantidad de caracteres especiales m�nimos del nombre de usuario");
		aModificar.setCaracteresEspecialesMinimos(teclado.nextInt());
		
		System.out.println("Ingrese la cantidad de caracteres especiales m�ximos del nombre de usuario");
		aModificar.setCaracteresEspecialesMaximos(teclado.nextInt());
		
		System.out.println("Ingrese la secuencia m�xima permitida");
		aModificar.setSecuenciaMaxima(teclado.nextInt());	
		
		return aModificar;
	}
	
	private static void crearNuevoUsuario(SistemaSeguro actual) {
		String userName = "", password = "";
		
		System.out.println("Ingrese el usuario");
		userName = teclado.next();
		System.out.println("Ingrese la contrase�a");
		password = teclado.next();
		
		if(actual.nuevoUsuario(userName, password)) {
			System.out.println("Usuario dado de alta");
		}
		else {
			System.out.println("No se cumple con los requisitos de nombre de usuario o contrase�a");
		}
	}
	
	private static void probarLogin(SistemaSeguro actual) {
		String userName = "", password = "";
		
		System.out.println("Ingrese el nombre de Usuario");
		userName = teclado.next();
		System.out.println("Ingrese el nombre de Usuario");
		password = teclado.next();
		
		if(actual.loguear(userName, password)) {
			if(actual.buscar(userName).isLogueado()) {
				System.out.println("Login correcto");				
			}
			else {
				System.out.println("Si bien los datos parecen correctos, ocurri� un problema al loguearse.");
			}
		}
		else {
			if(actual.buscar(userName).isBloqueado()) {
				System.out.println("Se super� la cantidad de intentos y el usuario ha sido bloqueado.");	
			}
			else {
				System.out.println("Nombre de usuario o contrase�a incorrecta. Intente nuevamente.");
			}
		}
	}
}
