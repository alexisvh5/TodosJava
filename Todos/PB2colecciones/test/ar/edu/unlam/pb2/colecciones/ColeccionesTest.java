package ar.edu.unlam.pb2.colecciones;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ColeccionesTest {
	
	private final Integer CANTIDAD_MAXIMA_VEHICULOS=3;

	@Test
	
	public void queSePuedaAgregarUnVehiculoAUnaColeccion() {
	
	// preparacion
	
	Integer id = 7;
	String nombre = "Corsa";
	
	
	Vehiculo vehiculo = this.generarVehiculo(id,nombre); /// refactorizo para que quede mas modularizado- en este caso ingresaria directo el valor sin hacer las variales, etc
	
	//Integer cantidadMaxima=3;
	
	Garage garage = new Garage(CANTIDAD_MAXIMA_VEHICULOS);
	
	// ejecucion 
	
	Boolean agregado = garage.agregar(vehiculo);
	
	ArrayList<Vehiculo> vehiculos = garage.obtenerVehiculos();
	
	
	// verificacion

	assertTrue(agregado);


	
	int cantidadEsperada=1; // pongo int xq sinbo no lo toma
	
	
	assertEquals(cantidadEsperada, vehiculos.size());
	
	// menera de hacerlo correctamente(?
	
	//assertEquals(vehiculo.getId(), vehiculos.get(0).getId());
	// otra manera mas SEGURA 
	//assertEquals(vehiculo.getNombre(), vehiculos.get(0).getNombre());
	
	// AHORA PARA ACHICACR EL CODIGO
	//assertEquals(vehiculo, vehiculos.get(0));
	
	//AHORA CONSIDERANDO AL EQUALS...MAS EXACTO
	
	Vehiculo vehiculoEsperado = this.generarVehiculo(id,nombre); ///// contibubo refactorizando, los de abajo no lo haogo--etc
	assertEquals(vehiculoEsperado,vehiculos.get(0));
	
	
	
	}
	@Test
	
	public void queSePuedaObtenerUnVehiculoExistente() {
		
		//preparacion
		Integer id = 7;
		String nombre = "Corsa";
		
		
		Vehiculo vehiculo = new Vehiculo(id,nombre);
		Vehiculo otroVehiculo = new Vehiculo(2,"Palio");
		
	//	Integer cantidadMaxima=3; --------------losHAGO CONSTANTE
		
		Garage garage = new Garage(CANTIDAD_MAXIMA_VEHICULOS);
		
		 garage.agregar(vehiculo);
		 garage.agregar(otroVehiculo);
		
		//ejecucion --- no seria agregar aca--- seria OBTENER... etnonces como necesito agregar, eso va en preparacion
		 
			
			Vehiculo vehiculoObtenido = garage.obtener(otroVehiculo);
			
			Vehiculo vehiculoEsperado = new Vehiculo(2,"Palio");;
		
		//verificacion
			
			//assertEquals(otroVehiculo,vehiculoObtenido);
		//HACERLO FALLAR
			assertEquals(vehiculoEsperado,vehiculoObtenido);
	}
	

	
@Test
	
	public void queNoSePuedaAgregarMasDeLaCantidadMax() {
	
	
Garage garage = new Garage(CANTIDAD_MAXIMA_VEHICULOS);	
Integer id = 7;
String nombre = "Corsa";


Vehiculo vehiculo1 = this.generarVehiculo(id,nombre);
Vehiculo vehiculo2= this.generarVehiculo(id,nombre);
Vehiculo vehiculo3 = this.generarVehiculo(id,nombre);


garage.agregar(vehiculo1);
garage.agregar(vehiculo2);
garage.agregar(vehiculo3);


Vehiculo vehiculo4 =  this.generarVehiculo(8, nombre);

boolean resultado = garage.agregar(vehiculo4);

assertEquals(false,resultado);

 // otra cosa, ver si estan los tres y no son nullos

assertEquals(vehiculo1, garage.obtener(vehiculo1));
assertEquals(vehiculo2, garage.obtener(vehiculo2));
assertEquals(vehiculo3, garage.obtener(vehiculo3));

assertNull(garage.obtener(vehiculo4));

	}

private Vehiculo  generarVehiculo(Integer id,String nombre) {
return new Vehiculo(id,nombre);}

@Test

public void queSePuedaEliminarUnVehiculo() {
	Integer id = 7;
	String nombre = "Corsa";
	Vehiculo vehiculo1 = this.generarVehiculo(id,nombre);
	Vehiculo vehiculo2 = this.generarVehiculo(2,"queLoPalio");

	Garage garage = new Garage(CANTIDAD_MAXIMA_VEHICULOS);	
	
	ArrayList<Vehiculo>vehiculos = garage.obtenerVehiculos();
	
	garage.agregar(vehiculo1);
	garage.agregar(vehiculo2);
	
	garage.eliminarVehiculo(vehiculo1);
	
	Integer cantidadEsperada = 1;
	Integer cantidadVehiculos= vehiculos.size();
	
	assertEquals(cantidadEsperada, cantidadVehiculos);
	
}



}
