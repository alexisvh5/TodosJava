package ar.edu.unlam.pb1.interfaces;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominios.Ahorcado;

public class PruebaAhorcado {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String palabraAAdivinar = "";
		Ahorcado juegoActual = new Ahorcado();

		int opcionSeleccionada = 0;

		System.out.println("bienvenido!!!!!!");
		System.out.println("ingerse la palabra a adivinar: ");
		palabraAAdivinar = teclado.next();
		juegoActual.setPalabraAAdivinar(palabraAAdivinar);
		do {
			System.out.println(juegoActual.getLetrasCorrectas() ); // seria en base al getPalabraAdivinar lo q
																			// devuleve son las lineas, cantidades
			System.out.println(juegoActual.getLetrasIncorrectas() );

			System.out.println("le quedan " + juegoActual.getVidasDisponibles() + "  vidas");

			System.out.println("1. Ingresar una letra");
			System.out.println("2. Arriesgas la palabra");
			opcionSeleccionada = teclado.nextInt();
	

			switch (opcionSeleccionada) {
			case 1:
				boolean esCorrecta = false;
				System.out.println("ingrese la letra: ");
				char letraIngresada = '\0';// variable local tipo char

				letraIngresada = teclado.next().charAt(0);
				// enviar la letra al objeto ahoracado para verificar

				esCorrecta = juegoActual.ingresarLetra(letraIngresada);

				if (esCorrecta) {
					System.out.println("Bien! Esa letra forma parte de la palabra");
				} else {
					System.out.println("error. La letra no esta en la palanbra");
				}

				break;
			case 2:
				String palabraArriesgada = "";
				System.out.println("Inngrese la palabra: ");
				palabraArriesgada = teclado.next();

				// enviar la palabra al objeto para verificar
				juegoActual.arriesgarPalabra(palabraArriesgada);

				break;

			default:
				System.out.println("opcion invalida, ingersela nuevamente");

				break;
			}

		} while (!juegoActual.perdio() && !juegoActual.gano());
		if (juegoActual.gano()) {
			System.out.println("FELIICITACiONES");
		} else {
			System.out.println("USTED  ES UN BURRO");
		}
	}

}
