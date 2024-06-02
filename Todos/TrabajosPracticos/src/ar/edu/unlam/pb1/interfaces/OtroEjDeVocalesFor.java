package ar.edu.unlam.pb1.interfaces;

import java.util.Scanner;

public class OtroEjDeVocalesFor {
	
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		String palabra="";
		String vocales = "AEIOU";
		int contadorVocales = 0;
		
		System.out.println("ingrese palabra:  ");
		palabra = teclado.next().toUpperCase();
		
		System.out.println("\nVOCAL\t\tCANTIDAD\n-----\t\t--------\n");
		
		
		for (int i = 0; i < vocales.length(); i++) {
			char vocal = vocales.charAt(i);
			int contadorIndependiente = 0;
			
			for (int j = 0; j < palabra.length(); j++) {
				if (vocal == palabra.charAt(j)) {
					contadorVocales++;
					contadorIndependiente++;
				}
			}
			System.out.println(vocal + "\t\t"+ contadorIndependiente );
		}
System.out.println("\n\n  > la cantidad de vocales totales es: "+contadorVocales);
	
	}

}
