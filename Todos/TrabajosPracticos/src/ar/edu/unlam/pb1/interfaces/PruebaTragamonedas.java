package ar.edu.unlam.pb1.interfaces;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominios.Tragamonedas;

public class PruebaTragamonedas {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Tragamonedas juegoActual = new Tragamonedas();
		char deseaContinuar = 's';
		System.out.println(" BIENVENIDOS AL CASINO");
		do {
	
				juegoActual.jugar();
		
			
			System.out.println("Tambor 1: "+ juegoActual.getTambor1().getPosicion());
			System.out.println("Tambor 2: "+ juegoActual.getTambor2().getPosicion());
			System.out.println("Tambor 3: "+ juegoActual.getTambor3().getPosicion());
		
			if (juegoActual.gano()) {
				System.out.println("Felicitaciones!!!!!!!!");
			}else {System.out.println("SIGA PARTICOIPANDO");}
			System.out.println("queres seguir jugando?---S/N");
			deseaContinuar = teclado.next().charAt(0);
		} while (deseaContinuar == 's' || deseaContinuar == 'S');

	}

}
