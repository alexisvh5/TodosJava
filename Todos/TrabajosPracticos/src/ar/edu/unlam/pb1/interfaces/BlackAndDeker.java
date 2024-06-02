package ar.edu.unlam.pb1.interfaces;

import ar.edu.unlam.pb1.dominios.*;

import java.util.Scanner;

public class BlackAndDeker {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		final int SELECCIONAR_TORNILLO = 1, SELECCIONAR_PUNTA_DE_DESTORNILLADOR = 2, SELECCIONAR_EL_TARUGO = 3,
				ATORNILLAR_DESATORNILLAR = 4, SALIR =9;

		int opcionSeleccionada = 0;
		
		Tornillo tornilloEnUso = null;
		Destornillador destornilladorEnUso = new Destornillador();
		Tarugo tarugoEnUso = null;
		
	

		do {
			verElEstadoDeLosObjetos(tornilloEnUso, destornilladorEnUso, tarugoEnUso);
	
			mostrarMenu();

			opcionSeleccionada = teclado.nextInt(); // podria hacer otro extrac de opcioon seleccionada pero pide muchos ptos

			switch (opcionSeleccionada) {
			case SELECCIONAR_TORNILLO:
				tornilloEnUso = seleccionarTornillo(); // tuene q devolver un tornillo el cual usamos
				break;
			case SELECCIONAR_PUNTA_DE_DESTORNILLADOR:
				seleccionarPuntaDelDestornillador(destornilladorEnUso);

				break;
			case SELECCIONAR_EL_TARUGO:
				tarugoEnUso = seleccionarTarugo();

				break;
			case ATORNILLAR_DESATORNILLAR: // en este caso no lo hice xq llevaba mas time
				char opcion, usarTarugo = '\0';
				System.out.println("desea atornillar(A) o desatornillar? (D)");
				opcion = Character.toUpperCase(teclado.next().charAt(0));
				System.out.println("desea utilizar tarugo? (S/N)");
				usarTarugo = Character.toUpperCase(teclado.next().charAt(0));
				if (usarTarugo == 'S') {
					if (opcion =='A') {
						destornilladorEnUso.atornillar(tornilloEnUso, tarugoEnUso);
					}else {
						destornilladorEnUso.desatornillar(tornilloEnUso, tarugoEnUso);
					}
				}
				else {
						if (opcion =='A') {
							destornilladorEnUso.atornillar(tornilloEnUso);
						}else {
							destornilladorEnUso.desatornillar(tornilloEnUso);
						}
				}

				break;
			case SALIR:
				System.out.println("saliendo...");
				break;

			default:
				System.out.println("opcion invalida");
				break;
				
			}
			
			
		} while (opcionSeleccionada != SALIR);
		
		
	}

	private static Tarugo seleccionarTarugo() {
		Tarugo tarugoEnUso;
		int longitudDeltarugo = 0;
		System.out.println("ingrese la longitud del tarugo");
		longitudDeltarugo = teclado.nextInt();

		tarugoEnUso = new Tarugo(longitudDeltarugo);
		return tarugoEnUso;
	}

	private static void seleccionarPuntaDelDestornillador(Destornillador destornilladorEnUso) {
		char punta = '\0';
		System.out.println("ingrese la punta del destornillador");
		punta = teclado.next().charAt(0);

		destornilladorEnUso.setTipoDeCabeza(punta);

		// en este caso no es una instanciacion xq hicimos el destonillador
		// intercambiable
	}

	private static Tornillo seleccionarTornillo() {
		Tornillo tornilloEnUso;
		char cabeza = '\0';
		int longitud = 0;
		int cantidadDeRosca = 0;
		System.out.println("ingrese el tipo de tornillo deseado");
		cabeza = teclado.next().charAt(0);

		System.out.println("ingrese la longitud");
		longitud = teclado.nextInt();

		System.out.println("ingreseLaCantidadDeRosca: ");
		cantidadDeRosca = teclado.nextInt();

		tornilloEnUso = new Tornillo(cabeza, longitud, cantidadDeRosca);
		return tornilloEnUso;
	}

	private static void verElEstadoDeLosObjetos(Tornillo tornilloEnUso, Destornillador destornilladorEnUso,
			Tarugo tarugoEnUso) {
		System.out.println("\n\n\n\n\n\n\nTornillo en uso: " + tornilloEnUso);
		System.out.println("Tarugo en uso: " + tarugoEnUso);
		System.out.println("Destornillador en uso: " + destornilladorEnUso);
	}

	private static void mostrarMenu() {
		System.out.println("\n\n\nMENU************************");
		System.out.println("\n1\tSeleccionar tornillo");
		System.out.println("2\tSeleccionar cabeza del destornillador:");
		System.out.println("3\t[opcionar]Seleccionar el tarugo");
		System.out.println("4\tAtornillar/Desatornillar");
		System.out.println("9\tSalir");
		System.out.println("\n\n\n-----\tIngrese la opcion deseada: ");
	}
}
