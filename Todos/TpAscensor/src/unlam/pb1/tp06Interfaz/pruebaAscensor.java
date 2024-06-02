package unlam.pb1.tp06Interfaz;

import unlam.pb1.tp06Dominio.Ascensor;

public class pruebaAscensor {
	
	public static void main(String[]args) {
		Ascensor subito = new Ascensor(0 , 5, 1000.0 , 5) ; 
		subito.cerrarPuerta();
		subito.irAlPiso(4);
		System.out.println("Estamos en el piso "+ subito.getPisoActual());
	}

}
