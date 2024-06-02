package ar.edu.unlam.pb1.interfaces;


public class pruebaPassword {

	public static void main(String[] args) {

Password prueba = new Password();


prueba.generarPassword();


System.out.println(prueba.getContrasenia());

// no creo q este este bien

System.out.println(" LA password es fuerte ?? "  +  prueba.esFuerte());

	}

}
