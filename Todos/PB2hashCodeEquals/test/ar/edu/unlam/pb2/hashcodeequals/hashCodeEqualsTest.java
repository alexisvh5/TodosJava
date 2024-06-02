package ar.edu.unlam.pb2.hashcodeequals;

import static org.junit.Test.*;

import org.junit.Test;

public class hashCodeEqualsTest {

	@Test
	public void hashCodeTest() {
		Integer identificador = 1;
		String nombre = "Corsa";
		Vehiculo vehiculo = new Vehiculo(identificador, nombre);
	}

}
