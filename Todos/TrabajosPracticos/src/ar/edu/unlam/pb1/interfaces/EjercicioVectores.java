package ar.edu.unlam.pb1.interfaces;

import java.util.Scanner;

public class EjercicioVectores {
	
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		int vectorDeNumerosEnteros[]=new int [5];
		int i =0;
	
		// """""LIMPIEZA""""""""
		
		for (i=0; i < vectorDeNumerosEnteros.length; i++) {
			vectorDeNumerosEnteros[i]=0;
		}
		//  CARGA DEL VECTOR
		
		for ( i = 0; i < vectorDeNumerosEnteros.length; i++) {
			System.out.println("En la posicion "+ (i+1)+ " guardo en el subindice "+i );
vectorDeNumerosEnteros[i] = teclado.nextInt();
		}
		
		// MOSTRAR EL CONTTENIDO
		for ( i = 0; i < vectorDeNumerosEnteros.length; i++) {
			System.out.println("Contiene \t "+ vectorDeNumerosEnteros[i]);
		}
		
		// hago abecedario
		
		char array[]=new char[26];
		
		char letra = 'a';
		
		for (int j = 0; j < array.length; j++) {
			array[j] = letra;
			System.out.println("la letra es : "+ letra);
		letra++;
		}
		
		///otro
		System.out.println("\n\n\nOTROOOOOOOOOOOOOOOOOO");
		
		char[]arrayABC = new char[26];
		
		char numeroInicial = 97;
		
		for (int j = 0; j < arrayABC.length; j++) {
			arrayABC[i]= numeroInicial;
			numeroInicial++;
			System.out.println(arrayABC[i]);
		}
	
		
		
	}

}
