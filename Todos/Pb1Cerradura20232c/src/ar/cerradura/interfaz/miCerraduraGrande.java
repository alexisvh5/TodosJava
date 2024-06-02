package ar.cerradura.interfaz;
import java.util.Scanner;

import ar.cerradura.dominio.*;

public class miCerraduraGrande {

	public static void main(String[] args) {

		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("ingrese la clave");

		int clave = teclado.nextInt();
				
		Cerradura miCerradura = new Cerradura(clave);
		
		while (true) {  /// ni importa
		
		System.out.println(" ingrese  1 para abrir");
		System.out.println(" ingrse 2 para cerrar");
		System.out.println(" in grese 3 para cambiar la clave");
		System.out.println("ingrese  4 para  consultar intentos q quedan");
		System.out.println("ingrtese 5 oara ver su esta bloqqueda");
		System.out.println("ingrese 6 para ver si esta abierta o cerrada");
		System.out.println("incerse 0 para salir");
		
		
		int opcion = teclado.nextInt();
		
		switch (opcion) {
		case 1:
			
			System.out.println("ingrese la clave de apertura");
			int claveDeApertura = teclado.nextInt();
			boolean abrio = miCerradura.abrir(claveDeApertura);
			
		if(abrio) {
			System.out.println("La cerdadura esta abierta");
		}else {
			
			System.out.println("la cerradura no se abrio");
		}
					
			break;
	case 2:
		
		System.out.println(" la cerradura se cerro");
			miCerradura.cerrar();
			
			break;

	case 3:
		
		System.out.println("ingrese la clave avtual");
		int claveActual = teclado.nextInt();
		System.out.println("ingrese la clave nueva");
		int claveNueva = teclado.nextInt();
		System.out.println("repita la clave nueva");
		int repetidaClaveNueva = teclado.nextInt();
		
boolean seCambio = miCerradura.cambiarClave(claveNueva,claveActual,repetidaClaveNueva);

if(seCambio) {
	System.out.println("cambio clave exitoso");
}
else
{System.out.println("cambio de clave fallido");}
		
		break;

	case 4:
		
		System.out.println(" te quedan "+ miCerradura.cuantosIntentosRestantes() + " intentos");
		
		break;

	case 5:
		if(miCerradura.estaBloqueda() == false) {
			System.out.println("tu clave no está bloqueda");}
		else {
			System.out.println("tu clave está bloqueda");}
		
		
		break;

	case 6:
		
		miCerradura.isEstaAbierta();
		
		if(	miCerradura.isEstaAbierta() == true) {
			System.out.println("la cerradura esta abierta");
		}
		
		else{System.out.println("la cerra esta cerrada");}
		
		
		break;

	case 0:
		
		System.out.println(" aca se pone la pantalla para abrrir la cerradura");
		
		break;


		default:
			
			System.out.println("opcion invalida");
			break;
		}
		}
		
		}
		
			
	}


