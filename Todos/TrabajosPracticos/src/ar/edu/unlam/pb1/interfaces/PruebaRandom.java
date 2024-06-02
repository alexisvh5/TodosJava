package ar.edu.unlam.pb1.interfaces;

public class PruebaRandom {

	public static void main(String[] args) {
		
		// generar un numero de  48 a 57
		
		char caracterNumericoAleatorio='\0';
		
		for (int i = 0; i < 100; i++) {
			int numeroAleatorio = (int)(Math.random()*10)+ 48;
			
			caracterNumericoAleatorio = (char)numeroAleatorio;
			
			System.out.println(numeroAleatorio+"-"+ caracterNumericoAleatorio);
		}
		

		
		
		//cuando math me de 0 entonces le sumo el minimo
		//cuando math me de 0.999; similar a uno... seria 8,999 =>10
		
		// mayus es de 65 a 97
		
		
		
		
		
		// generar los char e ir concatenando en un sting
		

		

	}

}
