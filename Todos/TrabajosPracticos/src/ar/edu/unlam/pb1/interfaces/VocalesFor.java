package ar.edu.unlam.pb1.interfaces;

import java.util.Iterator;
import java.util.Scanner;

public class VocalesFor {

	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		String cadenaDeCaracteres;
		
		System.out.println("ingrese una cadena de caracteres: ");
		cadenaDeCaracteres=teclado.nextLine();
		
		int cantidadDeA=0;
		int cantidadDeE=0;
		int cantidadDeI=0;
		int cantidadDeO=0;
		int cantidadDeU=0;
		int cantidadDeVocales =  0 ;
		
		for (int i = 0; i < cadenaDeCaracteres.length(); i++) {
			
			char letra = Character.toLowerCase(cadenaDeCaracteres.charAt(i));//////////!!!!!!!!!!
			
			switch (letra) {
			case 'a':
				cantidadDeA++;
				break;
			case 'e':
				cantidadDeE++;
				break;
			case 'i':
				cantidadDeI++;
				break;
			case 'o':
				cantidadDeO++;
				break;
			case 'u':
				cantidadDeU++;
				break;

			default:
				break;
			}
		cantidadDeVocales = cantidadDeA + cantidadDeE+cantidadDeO+cantidadDeU;
			
		}
		
		System.out.println("a" + cantidadDeA);
		System.out.println("e" + cantidadDeE);
		System.out.println("i" + cantidadDeI);
		System.out.println("o" + cantidadDeO);
		System.out.println("u" + cantidadDeU);
		System.out.println(cantidadDeVocales);
		

	}

}
