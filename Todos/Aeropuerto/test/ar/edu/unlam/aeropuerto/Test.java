package ar.edu.unlam.aeropuerto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Test {

	/*
	 * 
	 * 
	 * Crear/ Agregar vuelo (ruta, fecha y hora de salida)
	 * 
	 * Agregar Personas a una reserva
	 * 
	 * Agregar una reserva al vuelo
	 * 
	 * Obtener listado de personas de un vuelo
	 * 
	 * Obtener precio total de una reserva
	 * 
	 * Obtener lo recaudado para un vuelo
	 */

	@org.junit.Test
	public void queSePuedaCrearRuta() {
		String origen = "Argentina";
		String destino = "Alemania";
		LocalTime duracion = LocalTime.of(13, 30);
		Integer idRuta = 1;
		Ruta ruta = new Ruta(idRuta,origen, destino, duracion);
		assertNotNull(ruta);
		
		
		
		// EQUALS TEST
		Ruta rutaTest = new Ruta(idRuta,origen, destino, duracion);
		assertTrue(ruta.equals(rutaTest));

		

	}

	@org.junit.Test
	public void queVueloObtengaUnaRuta() {
		Integer idRuta = 1;
		String origen = "Argentina";
		String destino = "Alemania";
		LocalTime duracion = LocalTime.of(13, 30);
		Ruta ruta = new Ruta(idRuta, origen, destino, duracion);

		String fecha = "12/07/2024";
		DateTimeFormatter formateadorDeFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaDelVuelo = LocalDate.parse(fecha, formateadorDeFecha);

		LocalTime horaDePartida = LocalTime.of(11, 30);
		Vuelo vuelo = new Vuelo(1, ruta, fechaDelVuelo, horaDePartida);

		assertEquals(ruta, vuelo.getRuta());
	}

	@org.junit.Test
	public void queSePuedaAgregarPersonasAUnaReserva() {

		String nombre = "Kevin";
		String apellido = "Rotela";
		Integer dni = 45285663;

		Integer idReserva = 1;
		Cliente cliente = new Cliente(nombre, apellido, dni);

		Double precio = 250000.0;
		Reserva reserva = new Reserva(idReserva, cliente, precio);

		assertNotNull(reserva.getCliente());

	}

	@org.junit.Test
	public void queSePuedaAgregarReservaAVuelo() {

		// CLIENTE
		String nombre = "Kevin";
		String apellido = "Rotela";
		Integer dni = 45285663;


		Cliente cliente = new Cliente(nombre, apellido, dni);
		
		
		

		// RESERVA--- realacionado con CLIENTE
		Integer idReserva = 1;
		Double precio = 250000.0;
		Reserva reserva = new Reserva(idReserva, cliente, precio);
		
		
        // RUTA
		String origen = "Argentina";
		String destino = "Alemania";
		LocalTime duracion = LocalTime.of(13, 30);
		Integer idRuta = 1;

		Ruta ruta = new Ruta(idRuta, origen, destino, duracion);
		
		
		//VUELO --relacionado con RUTA

		String fecha = "12/07/2024";
		DateTimeFormatter formateadorDeFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaDelVuelo = LocalDate.parse(fecha, formateadorDeFecha);

		LocalTime horaDePartida = LocalTime.of(11, 30);
		Vuelo vuelo = new Vuelo(1, ruta, fechaDelVuelo, horaDePartida);
		
		
		// RESERVAVUELO -- relacionado con RESERVA Y VUELO

		Integer idReservaVuelo = 1;
		ReservaVuelo reservaVuelo = new ReservaVuelo(idReservaVuelo, vuelo, reserva);

		assertNotNull(reservaVuelo.getVuelo());

	}

	@org.junit.Test
	public void queSePuedaAgregarRutasAAeropuerto() {
		// crear Aeropuerto

		String nombreDelAeropuerto = "Aerolineas Argentinas";
		Aeropuerto aeropuerto = new Aeropuerto(nombreDelAeropuerto);

		String origen = "Argentina";
		String destino = "Alemania";
		LocalTime duracion = LocalTime.of(13, 30);
		Integer idRuta = 1;

		Ruta ruta = new Ruta(idRuta, origen, destino, duracion);

		Boolean rutaAgregadaExitosamente = aeropuerto.agregarRuta(ruta);

		assertTrue(rutaAgregadaExitosamente);

	}

	@org.junit.Test
	public void queSePuedaObtenerElListadoDePersonasDeUnVuelo() {

		// CREAMOS EL AEROPUERTO

		String nombreDelAeropuerto = "Aerolineas Argentinas";
		Aeropuerto aeropuerto = new Aeropuerto(nombreDelAeropuerto);

		// CREAMOS LA RUTA
		String origen = "Argentina";
		String destino = "Alemania";
		LocalTime duracion = LocalTime.of(13, 30);
		Integer idRuta = 1;

		Ruta ruta = new Ruta(idRuta, origen, destino, duracion);

		assertTrue(aeropuerto.agregarRuta(ruta));

		// CREAMOS EL CLIENTE
		String nombre = "Kevin";
		String apellido = "Rotela";
		Integer dni = 45285663;
		Cliente cliente = new Cliente(nombre, apellido, dni);
		Cliente cliente2 = new Cliente("Sebastian", "Gonzalez", 23456786);
		Cliente cliente3 = new Cliente("Axel", "Sanchez", 44566778);
		Cliente cliente4 = new Cliente("Nahuel", "Lima", 43555787);

		assertTrue(aeropuerto.agregarCliente(cliente));
		assertTrue(aeropuerto.agregarCliente(cliente2));
		assertTrue(aeropuerto.agregarCliente(cliente3));
		assertTrue(aeropuerto.agregarCliente(cliente4));

		// EQUALS TEST

		Cliente clienteRandom = new Cliente(nombre, apellido, dni);
		assertTrue(cliente.equals(clienteRandom));

		// CREAMOS LA RESERVA
		Integer idReserva = 1;
		Double precio = 250000.0;
		Reserva reserva = new Reserva(idReserva, cliente, precio);
		Reserva reserva2 = new Reserva(2, cliente2, 250000.0);
		Reserva reserva3 = new Reserva(3, cliente3, 250000.0);
		Reserva reserva4 = new Reserva(4, cliente4, 250000.0);

		assertTrue(aeropuerto.agregarReserva(reserva));
		assertTrue(aeropuerto.agregarReserva(reserva2));
		assertTrue(aeropuerto.agregarReserva(reserva3));
		assertTrue(aeropuerto.agregarReserva(reserva4));

		// FECHA DEL VUELO
		String fecha = "12/07/2024";
		DateTimeFormatter formateadorDeFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaDelVuelo = LocalDate.parse(fecha, formateadorDeFecha);

		// HORA DE PARTIDA
		LocalTime horaDePartida = LocalTime.of(11, 30);
		Vuelo vuelo = new Vuelo(1, ruta, fechaDelVuelo, horaDePartida);

		assertTrue(aeropuerto.agregarVuelo(vuelo));

		Integer idReservaVuelo = 1;
		ReservaVuelo reservaVuelo = new ReservaVuelo(idReservaVuelo, vuelo, reserva);
		ReservaVuelo reservaVuelo2 = new ReservaVuelo(2, vuelo, reserva2);
		ReservaVuelo reservaVuelo3 = new ReservaVuelo(3, vuelo, reserva3);
		ReservaVuelo reservaVuelo4 = new ReservaVuelo(4, vuelo, reserva4);

		assertTrue(aeropuerto.agregarReservaVuelo(reservaVuelo));
		assertTrue(aeropuerto.agregarReservaVuelo(reservaVuelo2));
		assertTrue(aeropuerto.agregarReservaVuelo(reservaVuelo3));
		assertTrue(aeropuerto.agregarReservaVuelo(reservaVuelo4));

		ArrayList<Cliente> listaObtenida = aeropuerto.obtenerListadoDePersonaEnDeUnVuelo(vuelo.getIdVuelo());

		assertEquals(4, listaObtenida.size(), 0.01);
		
		 // por el ordenamiento tendrian que estas asi

		assertEquals(cliente3, listaObtenida.get(0));
		assertEquals(cliente, listaObtenida.get(1));
		assertEquals(cliente4, listaObtenida.get(2));
		assertEquals(cliente2, listaObtenida.get(3));

	}

	@org.junit.Test
	public void queSePuedaObtenerElTotalDeUnaReserva() {

		// CREAMOS EL AEROPUERTO

		String nombreDelAeropuerto = "Aerolineas Argentinas";
		Aeropuerto aeropuerto = new Aeropuerto(nombreDelAeropuerto);

		// CREAMOS LA RUTA
		String origen = "Argentina";
		String destino = "Alemania";
		LocalTime duracion = LocalTime.of(13, 30);
		Integer idRuta = 1;

		Ruta ruta = new Ruta(idRuta,origen, destino, duracion);

		assertTrue(aeropuerto.agregarRuta(ruta));

		// CREAMOS EL CLIENTE
		String nombre = "Kevin";
		String apellido = "Rotela";
		Integer dni = 45285663;
		Cliente cliente = new Cliente(nombre, apellido, dni);
		Cliente cliente2 = new Cliente("Sebastian", "Gonzalez", 23456786);
		Cliente cliente3 = new Cliente("Axel", "Sanchez", 44566778);
		Cliente cliente4 = new Cliente("Nahuel", "Lima", 43555787);

		assertTrue(aeropuerto.agregarCliente(cliente));
		assertTrue(aeropuerto.agregarCliente(cliente2));
		assertTrue(aeropuerto.agregarCliente(cliente3));
		assertTrue(aeropuerto.agregarCliente(cliente4));

		// CREAMOS LA RESERVA
		Integer idReserva = 1;
		Double precio = 250000.0;
		Reserva reserva = new Reserva(idReserva, cliente, precio);
		Reserva reserva2 = new Reserva(idReserva, cliente2, 250000.0);
		Reserva reserva3 = new Reserva(idReserva, cliente3, 250000.0);
		Reserva reserva4 = new Reserva(idReserva, cliente4, 250000.0);

		assertTrue(aeropuerto.agregarReserva(reserva));
		assertTrue(aeropuerto.agregarReserva(reserva2));
		assertTrue(aeropuerto.agregarReserva(reserva3));
		assertTrue(aeropuerto.agregarReserva(reserva4));

		// FECHA DEL VUELO
		String fecha = "12/07/2024";
		DateTimeFormatter formateadorDeFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaDelVuelo = LocalDate.parse(fecha, formateadorDeFecha);

		// HORA DE PARTIDA
		LocalTime horaDePartida = LocalTime.of(11, 30);
		Vuelo vuelo = new Vuelo(1, ruta, fechaDelVuelo, horaDePartida);

		assertTrue(aeropuerto.agregarVuelo(vuelo));

		Integer idReservaVuelo = 1;
		ReservaVuelo reservaVuelo = new ReservaVuelo(idReservaVuelo, vuelo, reserva);
		ReservaVuelo reservaVuelo2 = new ReservaVuelo(2, vuelo, reserva2);
		ReservaVuelo reservaVuelo3 = new ReservaVuelo(3, vuelo, reserva3);
		ReservaVuelo reservaVuelo4 = new ReservaVuelo(4, vuelo, reserva4);

		assertTrue(aeropuerto.agregarReservaVuelo(reservaVuelo));
		assertTrue(aeropuerto.agregarReservaVuelo(reservaVuelo2));
		assertTrue(aeropuerto.agregarReservaVuelo(reservaVuelo3));
		assertTrue(aeropuerto.agregarReservaVuelo(reservaVuelo4));

		Double recaudacionObtenida = aeropuerto.obtenerLaRecaudacionTotalDeUnaReserva(idReserva);

		assertEquals(1000000.0, recaudacionObtenida, 0.01);

	}

}
