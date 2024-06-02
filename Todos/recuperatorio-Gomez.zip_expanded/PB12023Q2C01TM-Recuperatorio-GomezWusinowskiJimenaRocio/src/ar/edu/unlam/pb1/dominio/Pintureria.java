package ar.edu.unlam.pb1.dominio;

import ar.edu.unlam.pb1.dominio.enums.TipoDePintura;

public class Pintureria {
	
	// TODO: Completar getters, setters, constructor y metodos necesarios para garantizar el correcto funcionamiento.

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
		
		LataDePintura lataBuscada = null;
		int i = 0;
		
		while (i < latasDePintura.length && lataBuscada == null) {
			if (latasDePintura[i] != null && latasDePintura[i].getCodigo() == codigo) {
				lataBuscada = latasDePintura[i];
			} else {
				i++;
			}
			
		}
		 
		return lataBuscada;
	}

	public boolean agregarLataDePintura(int codigo, String nombre, double porcentajeGanancia,
			TipoDePintura tipoDePintura, int stock) {
		// TODO: Se debera instanciar una lata de pintura y agregarla al array de latas
		// de pintura.
		
		boolean seAgrego = false;
		int i = 0;
		
		while (i < latasDePintura.length && seAgrego == false) {
			if (latasDePintura[i] == null) {
				latasDePintura[i] = new LataDePintura (codigo, nombre, porcentajeGanancia, tipoDePintura, stock);
				seAgrego = true;
			} else {
				i++;
			}
			
		}
				
		return seAgrego;
	}

	public boolean hayStock(int codigo, int cantidadDeLatas) {
		// TODO: Se debera verificar si la pintureria cuenta con stock suficiente segun
		// el codigo de la lata de pintura solicitado. Se debe devolver verdadero en
		// caso de que el stock de la lata de pintura (que cumpla con el codigo), sea
		// mayor o igual a la cantidadDeLatas deseada.
		
		boolean hayStock = false;	
		LataDePintura aVerificarStock = obtenerLataDePinturaPorCodigo(codigo);
		
		if (aVerificarStock != null && aVerificarStock.getStock() >= cantidadDeLatas) {
			hayStock = true;
		}
		
		return hayStock;
	}

	public void venderLatasDePintura(int codigo, int cantidadDeLatas) {
		// TODO: Se debera actualizar el stock de la lata de pintura, debiendo buscarla
		// por codigo, y luego restando la cantidad de latas a vender, al stock actual
		// de la lata de pintura.
		// Tambien es necesario contabilizar cuantas latas se vendieron y acumular el
		// precio total (precio de la lata por cantidad a vender) al saldo de la
		// pintureria.
		
		LataDePintura aVender = obtenerLataDePinturaPorCodigo(codigo);

		if (aVender != null) {
			aVender.setStock(aVender.getStock() - cantidadDeLatas);	
			this.cantidadLatasVendidas += cantidadDeLatas;
			this.saldo += (aVender.getPrecio() * cantidadDeLatas);
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

	public LataDePintura obtenerLataDePinturaMasBarataPorTipo(TipoDePintura tipoDePintura) {
		// TODO: Se debera obtener la lata de pintura mas barata que aplique al tipo de
		// pintura especificado.
				
		LataDePintura masBarata = null;
		
		for (int i = 0; i < latasDePintura.length; i++) {
			if (latasDePintura[i] != null && latasDePintura[i].getTipoDePintura().equals(tipoDePintura)) {
				if (masBarata == null || latasDePintura[i].getPrecio() < masBarata.getPrecio()) {
					masBarata = latasDePintura[i];
				}
				
			}
		}

		return masBarata;
	}

	public LataDePintura[] obtenerLatasDePinturaOrdenadasPorNombreAscendente() {
		// TODO: Se debera devolver un array de latas de pintura ordenados por el nombre
		// de la lata de pintura de manera ascendente.
		// Ejemplo: nombre "Azul" antes que "Rojo".

		LataDePintura auxiliar = null;
		
		for (int i = 0; i < latasDePintura.length; i++) {
			for (int j = 0; j < latasDePintura.length - 1; j++) {
				if (latasDePintura[j] != null && latasDePintura[j+1] != null && latasDePintura[j].getNombre().compareTo(latasDePintura[j+1].getNombre()) > 0) {
					auxiliar = latasDePintura[j];
					latasDePintura[j] = latasDePintura[j+1];
					latasDePintura[j+1] = auxiliar;
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
		return "Pintureria [nombre = " + nombre + ", saldo = "
				+ saldo + ", cantidad de latas vendidas = " + cantidadLatasVendidas + "]";
	}
	
	
	
	
	

}
