package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

	
	System.out.println("inicio del programa");

	System.out.println("elija un color para el semaforo si quiere que sea: Rojo(r) - Verde(v) - Amarillo(a) ");
	
	
char semaforoColor=  sc.next().charAt(0);
		

	switch(semaforoColor) {
	
	case'r':
	case'R':
		System.out.println("el semaforo se pondra Rojo ");
		break;
	case 'V': 
	case 'v': 
		System.out.println("el semaforo se pondra verde ");
		break;
	case 'a':
	case 'A': 
		System.out.println("el semaforo se pondra Amarillo ");
		break;
		default:
			System.out.println("Opcion no valida");
			
	}
	
	System.out.println("fin del programa");
	
	
	}

}