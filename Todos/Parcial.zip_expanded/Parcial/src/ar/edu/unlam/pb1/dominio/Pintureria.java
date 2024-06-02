package ar.edu.unlam.pb1.dominio;

import java.util.Arrays;
import java.util.Iterator;

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
		this.saldo = 0;
		this.cantidadLatasVendidas = 0;
	}

	public LataDePintura obtenerLataDePinturaPorCodigo(int codigo) {
		// TODO: Se debe buscar una lata de pintura por codigo entre las latas de
		// pintura que tiene la pintureria y devolverla. En caso de no existir alguna
		// que cumpla con el codigo, devolver null.
		LataDePintura lataEncontrada = null;
		int i = 0;
		while (i < latasDePintura.length) {
			if (latasDePintura[i] != null && latasDePintura[i].getCodigo() == codigo) {
				lataEncontrada = latasDePintura[i];
				i = latasDePintura.length;
			} else {
				i++;
			}
		}

		return lataEncontrada;
	}

	public boolean agregarLataDePintura(int codigo, String nombre, double porcentajeGanancia,
			TipoDePintura tipoDePintura, int stock) {
		// TODO: Se debera instanciar una lata de pintura y agregarla al array de latas
		// de pintura.
		boolean agregada = false;
		int i = 0;
		LataDePintura nuevaLata = new LataDePintura(codigo, nombre, porcentajeGanancia, tipoDePintura, stock);

		while (i < this.latasDePintura.length && !agregada) {
			if (this.latasDePintura[i] == null) {
				this.latasDePintura[i] = nuevaLata;
				agregada = true;
			} else {
				i++;
			}
		}
		return agregada;

	}

	public boolean hayStock(int codigo, int cantidadDeLatas) {
		// TODO: Se debera verificar si la pintureria cuenta con stock suficiente segun
		// el codigo de la lata de pintura solicitado. Se debe devolver verdadero en
		// caso de que el stock de la lata de pintura (que cumpla con el codigo), sea
		// mayor o igual a la cantidadDeLatas deseada.
		boolean tieneStock = false;
		LataDePintura lataBuscada = obtenerLataDePinturaPorCodigo(codigo);

		if (lataBuscada.getStock() >= cantidadDeLatas) {
			tieneStock = true;
		}

		return tieneStock;
	}

	public void venderLatasDePintura(int codigo, int cantidadDeLatas) {
		// TODO: Se debera actualizar el stock de la lata de pintura, debiendo buscarla
		// por codigo, y luego restando la cantidad de latas a vender, al stock actual
		// de la lata de pintura.
		// Tambien es necesario contabilizar cuantas latas se vendieron y acumular el
		// /////x esto crearon nuevo atributo
		// precio total (precio de la lata por cantidad a vender) al saldo de la
		// pintureria.
		LataDePintura lataBuscada = obtenerLataDePinturaPorCodigo(codigo);
		lataBuscada.setStock(lataBuscada.getStock() - cantidadDeLatas);
		this.saldo += lataBuscada.obtenerPrecio() * cantidadDeLatas;
		this.cantidadLatasVendidas += cantidadDeLatas;

	}

	public int obtenerCantidadDeLatasDePinturasEnStockPorTipo(TipoDePintura tipoDePintura) {///////
		// TODO: Se debera obtener el numero (cantidad) de latas de pintura en stock
		// (considerando el stock de cada lata de pintura) que sean del tipo de pintura
		// especificado.
		int i = 0, cantidadDeLatasDePintDeEseTipo = 0;
		while (i < this.latasDePintura.length) {
			if (this.latasDePintura[i] != null && this.latasDePintura[i].getTipoDePintura() == tipoDePintura) {
				cantidadDeLatasDePintDeEseTipo += latasDePintura[i].getStock();
			}
			i++;
		}
		return cantidadDeLatasDePintDeEseTipo;
	}

	public LataDePintura obtenerLataDePinturaPorTipo(TipoDePintura tipoDePintura) {
		LataDePintura lataBuscadaPorTipo = null;
		int i = 0;
		while (i < this.latasDePintura.length) {
			if (this.latasDePintura[i] != null && this.latasDePintura[i].getTipoDePintura() == tipoDePintura) {
				lataBuscadaPorTipo = latasDePintura[i];
				i = this.latasDePintura.length;
			} else {
				i++;
			}
		}

		return lataBuscadaPorTipo;
	}

	public LataDePintura obtenerLataDePinturaMasBarataPorTipo(TipoDePintura tipoDePintura) {
		// TODO: Se debera obtener la lata de pintura mas barata que aplique al tipo de
		// pintura especificado.

		LataDePintura lataMasBarataPorTipo = null;
		int i = 0;

		while (i < this.latasDePintura.length) {
			if (latasDePintura[i]!=null && latasDePintura[i].getTipoDePintura()==tipoDePintura) {
				if (lataMasBarataPorTipo == null
						|| lataMasBarataPorTipo.obtenerPrecio() < latasDePintura[i].obtenerPrecio()) {
					lataMasBarataPorTipo = latasDePintura[i];
				}
			}
			i++;
		}

		return lataMasBarataPorTipo;
	}

	public LataDePintura[] obtenerLatasDePinturaOrdenadasPorNombreAscendente() {
		// TODO: Se debera devolver un array de latas de pintura ordenados por el nombre
		// de la lata de pintura de manera ascendente.
		// Ejemplo: nombre "Azul" antes que "Rojo".
	//	LataDePintura[]latasOrdenadas = new LataDePintura[this.latasDePintura.length];
		LataDePintura aux= null;
		for (int i = 0; i < latasDePintura.length; i++) {
			for (int j = 0; j < latasDePintura.length-1-i; j++) {
				if (latasDePintura[j]!=null &&latasDePintura[j+1]!=null) {
					if (latasDePintura[j].getNombre().compareTo(latasDePintura[j+1].getNombre())>0) {
						aux=latasDePintura[j];
						latasDePintura[j]=latasDePintura[j+1];
						latasDePintura[j+1]=aux;
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
		return "Pintureria [nombre=" + nombre +" saldo: "+ saldo + ", cantidadLatasVendidas=" + cantidadLatasVendidas + "]";
	}
}

//for (int j = 0; j < latasDePintura.length; j++) {
//if(latasDePintura[j] != null && latasDePintura[j].getTipoDePintura().equals(tipoDePintura)){
//	return latasDePintura[j];
//}
//}
//return null;

//for (int i = 0; i < latasDePintura.length; i++) {
//	if (latasDePintura[i] != null && latasDePintura[i].getCodigo() == codigo) {
//		return latasDePintura[i];
//	}
//}
//
//return null;
//boolean cierto = false;
//LataDePintura lataDePinturaNueva=new LataDePintura(codigo,nombre,porcentajeGanancia, tipoDePintura,stock);
//
//for (int i = 0; i < latasDePintura.length; i++) {
//	if(latasDePintura[i]==null) {
//		latasDePintura[i] = lataDePinturaNueva;
//		cierto = true;
//	}
//		}
//
//return cierto;

//LataDePintura aux=null;
//
//for (int i = 0; i < latasDePintura.length; i++) {
//	
//for (int j = 0; j < latasDePintura.length -1; j++) {
//	if (latasDePintura[j+1]!=null && latasDePintura[j]!=null) {
//		if(latasDePintura[i].equals(tipoDePintura)) {
//		if (latasDePintura[j].obtenerPrecio() >latasDePintura[j+1].obtenerPrecio()) {
//			aux = latasDePintura[j+1];
//			latasDePintura[j+1]=latasDePintura[j];
//			latasDePintura[j]=aux;
//			
//		}
//	}}
//}
//}
//
//return latasDePintura[0];
//
//LataDePintura aux=null;
//
//	
//for (int i = 0; i < latasDePintura.length; i++) {
//		
//	for (int j = 0; j < latasDePintura.length -1; j++) {
//		
//		if (latasDePintura[j+1]!=null && latasDePintura[j]!=null) {
//			if (latasDePintura[j].getNombre().toUpperCase().compareTo(latasDePintura[j+1].getNombre())>0) {
//				aux = latasDePintura[j+1];
//				latasDePintura[j+1]=latasDePintura[j];
//				latasDePintura[j]=aux;
//			}
//			}
//		}
//	}
//	
//
//	return latasDePintura;

//
//int contadorDeLatas = 0;
//
//for (int i = 0; i < latasDePintura.length; i++) {
//	if (latasDePintura[i] != null && latasDePintura[i].getTipoDePintura().equals(tipoDePintura)) {
//		contadorDeLatas += latasDePintura[i].getStock();
//	}
//}
//
//return contadorDeLatas;
////int cantidadDeLatasMate = 0;
////int cantidadDeLatasSatinada = 0;
////obtenerLataDePinturaPorTipo(tipoDePintura);
////
////
////		switch (tipoDePintura) {
////		case MATE:
////			cantidadDeLatasMate += obtenerLataDePinturaPorTipo(tipoDePintura).getStock();
////			break;
////		case SATINADA:
////			cantidadDeLatasSatinada += obtenerLataDePinturaPorTipo(tipoDePintura).getStock();
////			break;
////
////		default:
////			break;
////		}
////				
//boolean cierto= false;
//
//if (obtenerLataDePinturaPorCodigo(codigo)!=null &&obtenerLataDePinturaPorCodigo(codigo).getStock()>=cantidadDeLatas) {
//	cierto = true;
//}
//
//
//return cierto;
////		
////       
////
////
////
////return 0;
//LataDePintura buscada= obtenerLataDePinturaPorCodigo(codigo);
//double precioTotal = 0.0;
//
//for (int i = 0; i < latasDePintura.length; i++) {
//	if (latasDePintura[i]!= null && latasDePintura[i]==buscada) {
//		latasDePintura[i].setStock(latasDePintura[i].getStock()-cantidadDeLatas);
//		
//		this.cantidadLatasVendidas +=cantidadDeLatas;
//		
//		precioTotal = latasDePintura[i].obtenerPrecio()*cantidadDeLatas;
//		this.saldo +=precioTotal;
//	}
//}