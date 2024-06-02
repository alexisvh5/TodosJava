package ar.edu.unlam.pb1.dominio;

import ar.edu.unlam.pb1.dominio.enums.TipoDePintura;

public class Pintureria {

	// TODO: Completar getters, setters, constructor y metodos necesarios para
	// garantizar el correcto funcionamiento.

	private String nombre;
	private LataDePintura[] latasDePintura;
	private double saldo;
	private int cantidadLatasVendidas;

	public Pintureria(String nombre, int cantidadLatasPintura) {
		this.nombre = nombre;
		this.latasDePintura = new LataDePintura[cantidadLatasPintura];
	}

	public LataDePintura obtenerLataDePinturaPorCodigo(int codigo) {
		// TODO: Se debe buscar una lata de pintura por codigo entre las latas de
		// pintura que tiene la pintureria y devolverla. En caso de no existir alguna
		// que cumpla con el codigo, devolver null.
		for (int i = 0; i < latasDePintura.length; i++) {
			if (latasDePintura[i] != null && latasDePintura[i].getCodigo() == codigo) {
				return latasDePintura[i];
			}
		}

		return null;
	}

	public boolean agregarLataDePintura(int codigo, String nombre, double porcentajeGanancia,
			TipoDePintura tipoDePintura, int stock) {
		// TODO: Se debera instanciar una lata de pintura y agregarla al array de latas
		// de pintura.
		boolean cierto = false;// breaaaaaaaaaaaaaaaaaaaakkkkkkkk
		
		LataDePintura lataDePinturaNueva = new LataDePintura(codigo, nombre, porcentajeGanancia, tipoDePintura, stock);

		for (int i = 0; i < latasDePintura.length; i++) {
			if (latasDePintura[i] == null) {
				latasDePintura[i] = lataDePinturaNueva;
				cierto = true;
			}
		}

		return cierto;
	}

	public boolean hayStock(int codigo, int cantidadDeLatas) {
		// TODO: Se debera verificar si la pintureria cuenta con stock suficiente segun
		// el codigo de la lata de pintura solicitado. Se debe devolver verdadero en
		// caso de que el stock de la lata de pintura (que cumpla con el codigo), sea
		// mayor o igual a la cantidadDeLatas deseada.

		boolean cierto = false;

		if (obtenerLataDePinturaPorCodigo(codigo) != null
				&& obtenerLataDePinturaPorCodigo(codigo).getStock() >= cantidadDeLatas) {
			cierto = true;
		}

		return cierto;
	}

	public void venderLatasDePintura(int codigo, int cantidadDeLatas) {
		// TODO: Se debera actualizar el stock de la lata de pintura, debiendo buscarla
		// por codigo, y luego restando la cantidad de latas a vender, al stock actual
		// de la lata de pintura.
		// Tambien es necesario contabilizar cuantas latas se vendieron y acumular el
		// precio total (precio de la lata por cantidad a vender) al saldo de la
		// pintureria.


		LataDePintura buscada = obtenerLataDePinturaPorCodigo(codigo);
		if (buscada != null) { // validacion del metodo, no hago de nuevo la iteracion, xq el metodo ya lo hizo
			buscada.setStock(buscada.getStock() - cantidadDeLatas);// actualizoStok
			this.cantidadLatasVendidas += cantidadDeLatas; // contabilizo las latas vendidas.. sumo a las anteriores
			this.saldo += (buscada.obtenerPrecio() * cantidadDeLatas); // acumulo el precio total
		}
	}

	public int obtenerCantidadDeLatasDePinturasEnStockPorTipo(TipoDePintura tipoDePintura) {
		// TODO: Se debera obtener el numero (cantidad) de latas de pintura en stock
		// (considerando el stock de cada lata de pintura) que sean del tipo de pintura
		// especificado.


		int contadorDeLatas = 0;

		for (int i = 0; i < latasDePintura.length; i++) {
			if (latasDePintura[i] != null && latasDePintura[i].getTipoDePintura().equals(tipoDePintura)) {
				contadorDeLatas += latasDePintura[i].getStock();
			}
		}

		return contadorDeLatas;

	}

	public LataDePintura obtenerLataDePinturaPorTipo(TipoDePintura tipoDePintura) {
		for (int j = 0; j < latasDePintura.length; j++) {
			if (latasDePintura[j] != null && latasDePintura[j].getTipoDePintura().equals(tipoDePintura) ) {
				return latasDePintura[j];
			}
		}
		return null;
		
	
	}

	public LataDePintura obtenerLataDePinturaMasBarataPorTipo(TipoDePintura tipoDePintura) {
		// TODO: Se debera obtener la lata de pintura mas barata que aplique al tipo de
		// pintura especificado.
		LataDePintura[] latasPorTipo = new LataDePintura[latasDePintura.length];
		int conta=0;
		for (int j = 0; j < latasDePintura.length; j++) {
			if (latasDePintura[j] != null && latasDePintura[j].getTipoDePintura().equals(tipoDePintura) ) {
				latasPorTipo[conta++]= latasDePintura[j];
			}
		}
		
		
		LataDePintura aux = null;

		for (int i = 0; i < latasPorTipo.length; i++) {

			for (int j = 0; j < latasPorTipo.length - 1; j++) {
				if (latasPorTipo[j + 1] != null && latasPorTipo[j] != null) {
					if (latasPorTipo[j].obtenerPrecio() > latasPorTipo[j + 1].obtenerPrecio()) {
						aux = latasPorTipo[j + 1];
						latasPorTipo[j + 1] = latasPorTipo[j];
						latasPorTipo[j] = aux;

					}
				}
			}
		}

		return latasPorTipo[0];
	}

	public LataDePintura[] obtenerLatasDePinturaOrdenadasPorNombreAscendente() {
		// TODO: Se debera devolver un array de latas de pintura ordenados por el nombre
		// de la lata de pintura de manera ascendente.
		// Ejemplo: nombre "Azul" antes que "Rojo".
		LataDePintura aux = null;

		for (int i = 0; i < latasDePintura.length; i++) {

			for (int j = 0; j < latasDePintura.length - 1; j++) {

				if (latasDePintura[j + 1] != null && latasDePintura[j] != null) {
					
					if (latasDePintura[j].getNombre().toUpperCase().compareTo(latasDePintura[j + 1].getNombre()) > 0) {
						aux = latasDePintura[j + 1];
						latasDePintura[j + 1] = latasDePintura[j];
						latasDePintura[j] = aux;

					}
				}
			}
		}

		return latasDePintura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LataDePintura[] getLatasDePintura() {
		return latasDePintura;
	}

	public void setLatasDePintura(LataDePintura[] latasDePintura) {
		this.latasDePintura = latasDePintura;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getCantidadLatasVendidas() {
		return cantidadLatasVendidas;
	}

	public void setCantidadLatasVendidas(int cantidadLatasVendidas) {
		this.cantidadLatasVendidas = cantidadLatasVendidas;
	}

	@Override
	public String toString() {
		return "Pintureria [nombre=" + nombre + ", saldo=" + saldo + ", cantidadLatasVendidas=" + cantidadLatasVendidas
				+ "]";
	}
}
