package ar.edu.unlam.pb1.dominio;

public class Pedido {
	// TODO: Completar el constructor, getters, setters y metodos necesarios para
	// garantizar el correcto funcionamiento.
	// Podemos tener hasta 10000 ceramicas en un pedido!

	private static int proximoNumero = 1;
	private int numero;
	private boolean utilizado;
	private CajaDeCeramica[] ceramicas;

	public Pedido() {
		this.numero = proximoNumero++;
		this.ceramicas= new CajaDeCeramica[1000];
		this.utilizado=false;
	}

	public boolean agregarCajaDeCeramica(CajaDeCeramica ceramicaDeCeramica) {
		// TODO: Agregar una caja de ceramica al array de cajas de ceramicas.
		
		boolean agrego =false;
		
		for (int i = 0; i < ceramicas.length; i++) {
			if (ceramicas[i]==null) {
				ceramicas[i]=ceramicaDeCeramica;
				agrego=true;
				break;
			}
		}
		

		return agrego;
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

	public void setCeramicas(CajaDeCeramica[] ceramicas) {
		this.ceramicas = ceramicas;
	}

	public double calcularMontoTotalDelPedido() {
		double monto = 0.0;
		
		for (int i = 0; i < ceramicas.length; i++) {
			if (this.ceramicas[i] != null) {
				monto += this.ceramicas[i].getPrecio();
			}
		}
	
		return monto;
	}
	
}
