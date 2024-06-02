package ar.edu.unlam.dominio;

public class CuentaCorriente extends Cuenta{
	
	private Double descubierto;

	public CuentaCorriente(Cliente cliente, Double saldo, Integer numeroCuenta,Double descubierto) { /// agregoo descubierto
		super(cliente, saldo, numeroCuenta);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean extraerDinero(Double monto) {
		// TODO Auto-generated method stub
		return null;
	}

}
