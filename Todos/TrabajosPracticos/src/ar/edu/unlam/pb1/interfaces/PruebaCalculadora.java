package ar.edu.unlam.pb1.interfaces;

import ar.edu.unlam.pb1.dominios.Calculadora;

public class PruebaCalculadora {

	public static void main(String[] args) {
	
		Calculadora casio = new Calculadora();
		
	//	System.out.println("el resultado de divisores "+ casio.contarDivisores(10));
		
		System.out.println("es primo de  10? ");
		
		if (casio.esPrimo(4) == false) {
			System.out.println("No es primo");
		}else {
			System.out.println("Es primo");
		};
	}

}
