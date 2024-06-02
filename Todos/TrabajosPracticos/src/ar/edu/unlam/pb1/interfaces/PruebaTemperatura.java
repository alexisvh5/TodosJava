package ar.edu.unlam.pb1.interfaces;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominios.Temperatura;

public class PruebaTemperatura {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Temperatura termometro = new Temperatura();
		
		byte unidad;
		double temperatura;

		System.out.println("ingrese en que unidad quiere ingresar la temperatura:");
		System.out.println(Temperatura.CELSIUS + " Grados centigrados");
		System.out.println(Temperatura.FARENHEIT + " Grados Farenheit");
		System.out.println(Temperatura.KELVIN + " Grados Kelvin");
		unidad = teclado.nextByte();
		System.out.println("ingrese la temperatura:");
		temperatura = teclado.nextDouble();

		termometro.setValor(temperatura, unidad);
		System.out.println("ingrese en que unidad desea visualizarlo:");
		unidad = teclado.nextByte();
		System.out.println("la temperatura en la unidad solicitada es: " + termometro.convertir(unidad));
	}

}
