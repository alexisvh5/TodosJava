package ar.edu.unlam.pb1.interfaces;

import java.util.Scanner;

public class PruebaCapicua {

	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
	
		char elNumero[];
		
		// ingreso
		System.out.println("ingrese el numero");
		
		String ingresoDelUsuario = teclado.next();
		
		elNumero = new char [ingresoDelUsuario.length()];
		
		for (int i = 0; i < ingresoDelUsuario.length(); i++) {
			elNumero[i]=ingresoDelUsuario.charAt(i);
		}
		
		// validacion
		int i=0, j=elNumero.length-1;
		
		while (elNumero[i]==elNumero[j] && i<=j) { /// porque no i<=J?
			i++;
			j--;
		}
		if (i>=j) {
			System.out.println("es capicua");
		}else {
			System.out.println("no es capicua");
		}
		
		

	}

}
