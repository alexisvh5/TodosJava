package ar.edu.unlam.pb1.interfaces;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominios.Persona;

public class PruebaEstadisticaDePersonas {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		char deseaSeguirIngresando = 'S';

		// la clasificacion la hacemos aca
		//double pesoPromedio = 0.0;/// ?????
//		double edadPromedioDePesonasConBajoPeso = 0.0, 
//				edadPromedioDePersonasConSobrePeso = 0.0;

		int cantidadDePersonasConBajoPeso = 0, cantidadDePersonasConPesoNormal = 0, cantidadDePersonasConSobrePeso = 0;
		// para calcular el promedio de edades tengo q calcular la suma de edades x peso
		int sumaDeEdadDePersonasConBajoPeso = 0, 
				sumaDeEdadDePersonasConSobrePeso = 0;

		double sumatoriaDePesos = 0.0;

		double pesoActual = 0.0, alturaActual = 0.0;
		int edadActual = 0;

		Persona actual;
		// pido los datos necesarios para ingersar a la persona
		System.out.println("bienvenido!!");//// ingreso a la pesona

		while (deseaSeguirIngresando == 'S' || deseaSeguirIngresando == 's') {
			
			System.out.println("Persona "+ (cantidadDePersonasConBajoPeso + cantidadDePersonasConPesoNormal + cantidadDePersonasConSobrePeso+1));
			
			System.out.println("\nIngerse el peso");
			pesoActual = teclado.nextDouble();
			System.out.println("\ningrese la altura:");
			alturaActual = teclado.nextDouble();
			System.out.println("\ningrese edad");
			edadActual = teclado.nextInt();

			actual = new Persona(pesoActual, alturaActual, edadActual);

			switch (actual.calcularTipoDePeso()) {
			case BAJO_PESO:
				cantidadDePersonasConBajoPeso++;
				sumaDeEdadDePersonasConBajoPeso += edadActual;
				break;
			case PESO_NORMAL:
				cantidadDePersonasConPesoNormal++;

				break;
			case SOBRE_PESO:
				cantidadDePersonasConSobrePeso++;
				sumaDeEdadDePersonasConSobrePeso += edadActual;
				break;
			}
			sumatoriaDePesos += pesoActual;
			System.out.println("desea continuar? S/N");
			deseaSeguirIngresando=teclado.next().charAt(0);
		}
		int cantidadDePersonas = cantidadDePersonasConBajoPeso + cantidadDePersonasConPesoNormal
				+ cantidadDePersonasConSobrePeso;

		System.out.println("a. el peso promedio es: " + calcularPromedio(sumatoriaDePesos, cantidadDePersonas));

		System.out.println("b. la cantidad de pesonas con bajo peso es :" + cantidadDePersonasConBajoPeso);
		System.out.println("c. la cantidad de pesonas con normal peso es :" + cantidadDePersonasConPesoNormal);
		System.out.println("d. la cantidad de pesonas con sobrepeso es :" + cantidadDePersonasConSobrePeso);
		System.out.println("promedio de edad de pesonas con bajo peso "
				+ calcularPromedio(sumaDeEdadDePersonasConBajoPeso, cantidadDePersonasConBajoPeso));
		System.out.println("promedio de edad de pesonas con sobre peso "
				+ calcularPromedio(sumaDeEdadDePersonasConSobrePeso, cantidadDePersonasConSobrePeso));

	}

	public static double calcularPromedio(double suma, int cantidad) {
		return suma / cantidad;
	}
}
