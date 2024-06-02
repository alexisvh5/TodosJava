package ar.edu.unlam.test;

public class CuentaCorriente extends Cuenta {

	private Double deuda;
	private final Double DESCUBIERTO_MAXIMO;
	private Double descubiertoSolicitado;

	public CuentaCorriente(Integer numero, Cliente cliente, Double descubiertoMaximo) {
		super(numero, 0.0, cliente);
		this.DESCUBIERTO_MAXIMO = descubiertoMaximo;
		this.descubiertoSolicitado=0.0;
		this.deuda = 0.0;
	}

	public Boolean extraer(Double dineroAExtraer) {
		
		Boolean resultado = false;

		
		if ((dineroAExtraer>this.saldo) && (dineroAExtraer <= (this.saldo + this.DESCUBIERTO_MAXIMO))) {
			
			this.descubiertoSolicitado = dineroAExtraer - this.saldo;
		
			
			this.deuda = 1.5 * descubiertoSolicitado;
			
		}
		
	

		if (dineroAExtraer <= (this.saldo + this.DESCUBIERTO_MAXIMO)) {
			this.saldo -= dineroAExtraer;
			resultado = true;
		}
		else {
			return resultado;
		}
		
		return resultado;
	}

}
