package ar.edu.unlam.pb1.interfaces;

import ar.edu.unlam.pb1.dominios.Alarma;

public class PruebaAlarma {

	public static void main(String[] args) {

Alarma adt = new Alarma(1234);

//
//adt.setEncendida(false);
//adt.setSensorDeSonido(true);
//
//System.out.println(adt.estaSonando());

// inicialmente la alarma va a estar apagada => si aprieto el boton power, lo q se espera es q prenda

adt.power(1234);

	}

}
