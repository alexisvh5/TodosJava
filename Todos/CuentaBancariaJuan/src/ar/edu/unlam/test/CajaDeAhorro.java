package ar.edu.unlam.test;

public class CajaDeAhorro extends Cuenta {
//	
//	private Integer numero;
//	private Cliente cliente;
//	private Double saldo;
	private Integer cantidadDeExtracciones;
	private final Integer CANTIDAD_EXTRACCIONES_SIN_COSTO=5;
	private final Double MULTA=6.0;

	public CajaDeAhorro(Integer numero, Cliente cliente) {
	super(numero,0.0,cliente);
		this.cantidadDeExtracciones=0;
	}
	
	//sobreescrituraaaaaaaaaaaa del metodo gral en cuenta
// @Override , opcional, para confirmar que vas a sobreeescribir un met del padre
	public Boolean extraer(Double dineroAExtraer) {
		
		boolean resultado =false;
		
		this.cantidadDeExtracciones++;
		
		Double multa = 0.0;
		
		if (this.cantidadDeExtracciones > this.CANTIDAD_EXTRACCIONES_SIN_COSTO) {
			multa=this.MULTA;
		}
		
		if (dineroAExtraer<=(this.saldo+multa)) {
			this.saldo -= (dineroAExtraer + multa);
	
			
			return true; 
		}
		
		return resultado;	
		}
	

}
