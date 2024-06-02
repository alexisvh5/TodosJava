package ar.edu.unlam.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class test {

	@Test

	public void queSePuedaCrearUnCliente() {
//prepa		
		Integer dni = 38498798;

		String nombre = "Julian";
//eje
		Cliente cliente = new Cliente(dni, nombre);

//validacion
		assertEquals(dni, cliente.getDni());
		assertEquals(nombre, cliente.getNombre());

	}

	@Test

	public void queSePuedaCrearUnBanco() {
//prepa		

		String nombre = "Unlam";
//eje
		Banco nuevoBanco = new Banco(nombre);

//validacion
		assertEquals(nombre, nuevoBanco.getNombre());

	}

//OTRO TEST que no se pueda

	@Test

	public void queSePuedaCrearUnaCuentaSueldo() {

		Cliente cliente = new Cliente(38498798, "Julian");

		Double saldoInicial = 1000.0;

		Integer numero = 1;

		CuentaSueldo nueva = new CuentaSueldo(numero, saldoInicial, cliente);

		assertEquals(cliente, nueva.getCliente());
		assertEquals(saldoInicial, nueva.getSaldo());
		assertEquals(numero, nueva.getNumero());

	}

//OTRO TESTTTTTTTTTT

	@Test
	public void queSePuedaAgregarUnaCuentaSueldoAlBanco() { //////// a donde? al banco

		Banco unlam = new Banco("unlam");

		Cliente cliente = new Cliente(38498798, "Julian");

		Double saldoInicial = 1000.0;

		Integer numero = 1;

		CuentaSueldo nueva = new CuentaSueldo(numero, saldoInicial, cliente);

		// Boolean sePuedeAgregar = unlam.agregar(nueva); --unaa ==> agregar tendria q
		// ser boolean

		// assertNotNull(buscarCuentaSueldoPorNumero(numero)) --otra

		unlam.agregarCuenta(nueva);

		assertEquals(nueva, unlam.buscarCuentaSueldoPorNumero(numero));
	}

	// teste de QUENO SE PUEDA AGREGAR UNA CTA SUELDo

	@Test
	public void queSePuedaExtraerDineroDeUnaCuentaSueldo() { //////// a donde? al banco

		Banco unlam = new Banco("unlam");

		Cliente cliente = new Cliente(38498798, "Julian");

		Double saldoInicial = 1000.0;

		Integer numero = 1;

		Double dineroAExtraer = 500.0;

		Boolean resultado;

		Double saldoFinal = 500.0;// saldoInicial-dineroAExtraer o directamente pongo el valor xq aca no va logica

		CuentaSueldo nueva = new CuentaSueldo(numero, saldoInicial, cliente);

		// ejecutar------------------

		// Boolean sePuedeAgregar = unlam.agregar(nueva); --unaa ==> agregar tendria q
		// ser boolean

		// assertNotNull(buscarCuentaSueldoPorNumero(numero)) --otra

		assertTrue(unlam.agregarCuenta(nueva));

		resultado = nueva.extraer(dineroAExtraer);

		// verificacion

		assertTrue(resultado);
		assertEquals(saldoFinal, nueva.getSaldo());

		// assertEquals(nueva,unlam.buscarCuentaSueldoPorNumero(numero));
	}

	// que no se pueda extraer!!!!!!!!!!!!!!!!!!!//Antes de hacer este metodo
	// IMPORTANTE hay metodos que si no pueden faltar.. como
	// QUE NO SE PUEDA EXTRAER MAS CANTI DEL DINERO DIISPONIBLE

	@Test
	public void queNoSePuedaExtraerMasDineroDeDeUnaCuentaSueldo() { //////// a donde? al banco

		Banco unlam = new Banco("unlam");

		Cliente cliente = new Cliente(38498798, "Julian");

		Double saldoInicial = 1000.0;

		Integer numero = 1;

		Double dineroAExtraer = 1500.0;

		Boolean resultado;

		Double saldoFinal = 1000.0;//se  mantiene el saldod porque no se realizo la accion

		CuentaSueldo nueva = new CuentaSueldo(numero, saldoInicial, cliente);

		// ejecutar------------------

		// Boolean sePuedeAgregar = unlam.agregar(nueva); --unaa ==> agregar tendria q
		// ser boolean

		// assertNotNull(buscarCuentaSueldoPorNumero(numero)) --otra

		assertTrue(unlam.agregarCuenta(nueva));

		resultado = nueva.extraer(dineroAExtraer);

		// verificacion

		assertFalse(resultado);
		assertEquals(saldoFinal, nueva.getSaldo());

		// assertEquals(nueva,unlam.buscarCuentaSueldoPorNumero(numero));
	}

	@Test
	public void queSePuedaDepositarDineroEnUnaCuentaSueldoAlBanco() { //////// a donde? al banco

		Banco unlam = new Banco("unlam");

		Cliente cliente = new Cliente(38498798, "Julian");

		Double saldoInicial = 1000.0;

		Integer numero = 1;

		Double dineroADepositar = 500.0;

		Double saldoFinal = 1500.0;// saldoInicial-dineroAExtraer o directamente pongo el valor xq aca no va logica

		CuentaSueldo nueva = new CuentaSueldo(numero, saldoInicial, cliente);

		// ejecutar------------------

		// Boolean sePuedeAgregar = unlam.agregar(nueva); --unaa ==> agregar tendria q
		// ser boolean

		// assertNotNull(buscarCuentaSueldoPorNumero(numero)) --otra

		assertTrue(unlam.agregarCuenta(nueva));

		nueva.depositar(dineroADepositar);

		// verificacion

		// assertTrue(resultado); ---lo saco para el caso de deposito
		assertEquals(saldoFinal, nueva.getSaldo());

		// assertEquals(nueva,unlam.buscarCuentaSueldoPorNumero(numero));
	}

	// ---------------------------------------------------------------------------------CAJAAHORRO

	@Test

	public void queSePuedaCrearUnaCajaDeAhorro() {
		
		
		Cliente cliente =  new Cliente(38498798,"Julian");

		
		Integer numero=1;
		//ejecucion
		
		CajaDeAhorro nueva = new CajaDeAhorro(numero, cliente);
		
		//vali
		
		assertEquals(cliente,nueva.getCliente());
		assertEquals(0.00,nueva.getSaldo(),0.01);
		assertEquals(numero,nueva.getNumero());
		
	}

	@Test
	public void queSePuedaAgregarUnaCajaDeAhorroAlBanco() { //////// a donde? al banco

		Banco unlam = new Banco("unlam");

		Cliente cliente = new Cliente(38498798, "Julian");

		Integer numero = 1;

		CajaDeAhorro nueva = new CajaDeAhorro(numero, cliente);

		// Boolean sePuedeAgregar = unlam.agregar(nueva); --unaa ==> agregar tendria q
		// ser boolean

		// assertNotNull(buscarCuentaSueldoPorNumero(numero)) --otra

		assertTrue(unlam.agregarCuenta(nueva)); // ahora lo reutilizo, se sobreescribe, porque tiene otro dato enel
												// parametro

		assertEquals(nueva, unlam.buscarCajaDeAhorroPorNumero(numero));
	}

	// teste de QUENO SE PUEDA AGREGAR UNA CTA SUELDo

	@Test
	public void queSePuedaDepositarDineroDeUnaCajaDeAhorro() { //////// a donde? al banco

		Banco unlam = new Banco("unlam");

		Cliente cliente = new Cliente(38498798, "Julian");

		Integer numero = 1;

		Double dineroADepositar = 500.0;

		Boolean resultado;

		Double saldoFinal = 500.0;// saldoInicial-dineroAExtraer o directamente pongo el valor xq aca no va logica

		CajaDeAhorro nueva = new CajaDeAhorro(numero, cliente);

		// ejecucion

		unlam.agregarCuenta(nueva);
		nueva.depositar(dineroADepositar);

	
		assertEquals(dineroADepositar, nueva.getSaldo());
	}

	@Test
	public void queSePuedaExtraerDineroDeUnaCajaDeAhorro() { //////// a donde? al banco

		Banco unlam = new Banco("unlam");

		Cliente cliente = new Cliente(38498798, "Julian");

		Integer numero = 1;

		// aca primero se necesita DEPOSITAR ---entonces seria primero que se pueda depo
		Double dineroADepositar = 1000.0;

		Double dineroAExtraer = 500.0;

		Boolean resultado;

		Double saldoFinal = 500.0;// saldoInicial-dineroAExtraer o directamente pongo el valor xq aca no va logica

		CajaDeAhorro nueva = new CajaDeAhorro(numero, cliente);

		// ejecutar------------------

		// Boolean sePuedeAgregar = unlam.agregar(nueva); --unaa ==> agregar tendria q
		// ser boolean

		// assertNotNull(buscarCuentaSueldoPorNumero(numero)) --otra

		unlam.agregarCuenta(nueva);

		nueva.depositar(dineroADepositar);

		resultado = nueva.extraer(dineroAExtraer);

		// verificacion

		assertTrue(resultado);
		assertEquals(saldoFinal, nueva.getSaldo());

		// assertEquals(nueva,unlam.buscarCuentaSueldoPorNumero(numero));
	}

	// que no se pueda extraer!!!!!!!!!!!!!!!!!!!//Antes de hacer este metodo
	// IMPORTANTE hay metodos que si no pueden faltar.. como
	// QUE NO SE PUEDA EXTRAER MAS CANTI DEL DINERO DIISPONIBLE

	@Test
	public void queNoSePuedaExtraerMasDineroQueElSaldoDisponibleDeDeUnaCajaDeAhorro() { //////// a donde? al banco

		Banco unlam = new Banco("unlam");

		Cliente cliente = new Cliente(38498798, "Julian");

		Integer numero = 1;

		Double dineroAExtraer = 1500.0;

		Boolean resultado;

		Double saldoFinal = 0.0;// saldoInicial-dineroAExtraer o directamente pongo el valor xq aca no va logica

		CajaDeAhorro nueva = new CajaDeAhorro(numero, cliente);

		// ejecutar------------------

		// Boolean sePuedeAgregar = unlam.agregar(nueva); --unaa ==> agregar tendria q
		// ser boolean

		// assertNotNull(buscarCuentaSueldoPorNumero(numero)) --otra

		unlam.agregarCuenta(nueva);

		resultado = nueva.extraer(dineroAExtraer);

		// verificacion

		assertFalse(resultado);
		assertEquals(saldoFinal, nueva.getSaldo());

		// assertEquals(nueva,unlam.buscarCuentaSueldoPorNumero(numero));
	}

	@Test
	public void queEnLaSextaExtraccionSeApliqueUnCostoDe6PesosEnUnaCajaDeAhorro() { //////// a donde? al banco

		// preparacion
		Banco unlam = new Banco("unlam");

		Cliente cliente = new Cliente(38498798, "Julian");

		Integer numero = 1;

		Double dineroADepositar = 15000.0;
		Double dineroAExtraer = 1500.0;

		Double saldoFinal = 5994.0;// saldoInicial-dineroAExtraer o directamente pongo el valor xq aca no va logica

		CajaDeAhorro nueva = new CajaDeAhorro(numero, cliente);

		// ejecutar------------------

		// Boolean sePuedeAgregar = unlam.agregar(nueva); --unaa ==> agregar tendria q
		// ser boolean

		// assertNotNull(buscarCuentaSueldoPorNumero(numero)) --otra

		unlam.agregarCuenta(nueva);

		nueva.depositar(dineroADepositar);
		nueva.extraer(dineroAExtraer);
		nueva.extraer(dineroAExtraer);
		nueva.extraer(dineroAExtraer);
		nueva.extraer(dineroAExtraer);
		nueva.extraer(dineroAExtraer);
		nueva.extraer(dineroAExtraer);

		// verificacion

		assertEquals(saldoFinal, nueva.getSaldo());

		// assertEquals(nueva,unlam.buscarCuentaSueldoPorNumero(numero));
	}

	////////////// ----------------------CUENTACORRIENTE

	@Test

	public void queSePuedaCrearUnaCuentaCorriente() {

		Cliente cliente = new Cliente(38498798, "Julian");

		Integer numero = 1;
		// ejecucion
		Double descubiertoMaximo = 1500.0;
		CuentaCorriente nueva = new CuentaCorriente(numero, cliente, descubiertoMaximo);

		// vali

		assertEquals(cliente, nueva.getCliente());
		assertEquals(0.00, nueva.getSaldo(), 0.01);
		assertEquals(numero, nueva.getNumero());

	}

	@Test
	public void queSePuedaAgregarUnaCuentaCorrienteAlBanco() { //////// a donde? al banco

		Banco unlam = new Banco("unlam");

		Cliente cliente = new Cliente(38498798, "Julian");

		Integer numero = 1;
		Double descubiertoMaximo = 1500.0;
		CuentaCorriente nueva = new CuentaCorriente(numero, cliente, descubiertoMaximo);

		// Boolean sePuedeAgregar = unlam.agregar(nueva); --unaa ==> agregar tendria q
		// ser boolean

		// assertNotNull(buscarCuentaSueldoPorNumero(numero)) --otra

		assertTrue(unlam.agregarCuenta(nueva)); // ahora lo reutilizo, se sobreescribe, porque tiene otro dato enel
												// parametro

		// ejecucion

		assertNotNull(unlam.buscarCuentaCorriente(numero));
		assertEquals(nueva, unlam.buscarCuentaCorriente(numero));
	}

	// teste de QUENO SE PUEDA AGREGAR UNA CTA SUELDo

	@Test
	public void queSePuedaDepositarDineroEnUnaCajaDeAhorro() { //////// a donde? al banco

		Banco unlam = new Banco("unlam");

		Cliente cliente = new Cliente(38498798, "Julian");

		Integer numero = 1;

		Double dineroADepositar = 500.0;

		Boolean resultado;

		Double saldoFinal = 500.0;// saldoInicial-dineroAExtraer o directamente pongo el valor xq aca no va logica

		Double descubiertoMaximo = 1500.0;
		CuentaCorriente nueva = new CuentaCorriente(numero, cliente, descubiertoMaximo);

		// ejecucion

		unlam.agregarCuenta(nueva);
	 nueva.depositar(dineroADepositar);

	
		assertEquals(dineroADepositar, nueva.getSaldo());
	}

	@Test
	public void queSePuedaExtraerDineroDeUnaCuentaCorriente() { //////// a donde? al banco

		Banco unlam = new Banco("unlam");

		Cliente cliente = new Cliente(38498798, "Julian");

		Integer numero = 1;

		// aca primero se necesita DEPOSITAR ---entonces seria primero que se pueda depo
		Double dineroADepositar = 1000.0;

		Double dineroAExtraer =500.0;

		Boolean resultado;

		Double saldoFinal = 500.0;// saldoInicial-dineroAExtraer o directamente pongo el valor xq aca no va logica

		Double descubiertoMaximo = 1500.0;
		CuentaCorriente nueva = new CuentaCorriente(numero, cliente, descubiertoMaximo);

		// ejecutar------------------

		// Boolean sePuedeAgregar = unlam.agregar(nueva); --unaa ==> agregar tendria q
		// ser boolean

		// assertNotNull(buscarCuentaSueldoPorNumero(numero)) --otra

		unlam.agregarCuenta(nueva);

		nueva.depositar(dineroADepositar);

		resultado = nueva.extraer(dineroAExtraer);

		// verificacion

		assertTrue(resultado);
		assertEquals(saldoFinal, nueva.getSaldo());

		// assertEquals(nueva,unlam.buscarCuentaSueldoPorNumero(numero));
	}

	// que no se pueda extraer!!!!!!!!!!!!!!!!!!!//Antes de hacer este metodo
	// IMPORTANTE hay metodos que si no pueden faltar.. como
	// QUE NO SE PUEDA EXTRAER MAS CANTI DEL DINERO DIISPONIBLE

	@Test
	public void queSePuedaExtraerMasDineroQueElSaldoDisponibleDeDeUnaCuentaCorriente() { //////// a donde? al banco

		Banco unlam = new Banco("unlam");

		Cliente cliente = new Cliente(38498798, "Julian");

		Integer numero = 1;

		Double dineroAExtraer = 1500.0;

		Double descubiertoMaximo = 2000.0;

		Boolean resultado;

		Double saldoFinal = -1500.0;// saldoInicial-dineroAExtraer o directamente pongo el valor xq aca no va logica

		CuentaCorriente nueva = new CuentaCorriente(numero, cliente, descubiertoMaximo);


		unlam.agregarCuenta(nueva);

		resultado = nueva.extraer(dineroAExtraer);

		// verificacion

		assertTrue(resultado);
		assertEquals(saldoFinal, nueva.getSaldo());

		// assertEquals(nueva,unlam.buscarCuentaSueldoPorNumero(numero));
	}

	@Test
	public void queNoSePuedaExtraerMasDineroQueElDescubiertoDisponiblEnUnaCuentaCorriente() { //////// a donde? al banco

		Banco unlam = new Banco("unlam");

		Cliente cliente = new Cliente(38498798, "Julian");

		Integer numero = 1;

		Double dineroAExtraer = 3000.0;

		Double descubiertoMaximo = 1500.0;

		Boolean resultado;

		Double saldoFinal = 0.0;// saldoInicial-dineroAExtraer o directamente pongo el valor xq aca no va logica

		CuentaCorriente nueva = new CuentaCorriente(numero, cliente, descubiertoMaximo);

		// ejecutar------------------

		// Boolean sePuedeAgregar = unlam.agregar(nueva); --unaa ==> agregar tendria q
		// ser boolean

		// assertNotNull(buscarCuentaSueldoPorNumero(numero)) --otra

		unlam.agregarCuenta(nueva);

		resultado = nueva.extraer(dineroAExtraer);

		// verificacion

		assertFalse(resultado);
		assertEquals(saldoFinal, nueva.getSaldo());

		// assertEquals(nueva,unlam.buscarCuentaSueldoPorNumero(numero));
	}
}
