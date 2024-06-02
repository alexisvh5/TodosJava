package ar.edu.unlam.pb1.dominio;

import java.util.Arrays;

import ar.edu.unlam.pb1.dominio.enums.TipoDeCeramica;

public class Pedido {
	// TODO: Completar el constructor, getters, setters y metodos necesarios para
	// garantizar el correcto funcionamiento.
	// Podemos tener hasta 10000 ceramicas en un pedido!

	private static int proximoNumero = 1;
	private int numero;
	private boolean utilizado;
	private CajaDeCeramica[] ceramicas;
	private int cantidadLibres;

	public Pedido() {
		this.numero = proximoNumero++;
		this.ceramicas = new CajaDeCeramica[20];
		this.utilizado=false;
		this.cantidadLibres=20;
	
	}

	public boolean agregarCajaDeCeramica(CajaDeCeramica ceramicaDeCeramica) {
		// TODO: Agregar una caja de ceramica al array de cajas de ceramicas.
		int i=0;
		boolean verdad=false;
		while (i<this.ceramicas.length) {
			if (ceramicas[i]==null && !verdad) {
				ceramicas[i]=ceramicaDeCeramica;
				verdad=true;
			}else {i++;}
		}

		return verdad;
	}

	public static int getProximoNumero() {
		return proximoNumero;
	}

	public static void setProximoNumero(int proximoNumero) {
		Pedido.proximoNumero = proximoNumero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isUtilizado() {
		return utilizado;
	}


	public void setUtilizado(boolean utilizado) {
		this.utilizado = utilizado;
	}

	public CajaDeCeramica[] getCeramicas() {
		return ceramicas;
	}
	public void setCantidadDeLugaresLibresParaCeramicas(int cantidad) {
	
		this.cantidadLibres=cantidad;
	}
	public int getCantidadDeLugaresLibresParaCeramicas() {
		return cantidadLibres;
	}

	public void setCeramicas(CajaDeCeramica[] ceramicas) {
		this.ceramicas = ceramicas;
	}

	@Override
	public String toString() {
		return "Pedido [numero=" + numero + ", utilizado=" + utilizado + ", ceramicas=" + Arrays.toString(ceramicas)
				+ ", cantidadLibres=" + cantidadLibres + "]";
	}

	public double calcularMontoTotal() {
		// TODO Auto-generated method stub
		double monto=0.0;
		for (int i = 0; i < ceramicas.length; i++) {
			if (ceramicas[i]!=null) {
				monto+= ceramicas[i].getPrecio();
			}
		}
		
		return monto;
	}

	
	public double calcularCantDeCajasPorTipo(TipoDeCeramica tipo) {
		// TODO Auto-generated method stub
		double montoAc=0.0;
		double cantidad = 0;
		for (int i = 0; i < ceramicas.length; i++) {
			if (ceramicas[i]!=null && ceramicas[i].getTipoDeCeramica() == tipo) {
				montoAc+= ceramicas[i].getPrecio();
			}
		}
		
		return montoAc/this.ceramicas.length;
	}
	
	
}
