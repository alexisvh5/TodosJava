package ar.edu.unlam.dominio;

public class CajaDeAhorro extends Cuenta implements Impresion{   /// puede ser abs o noo, en ese caso la hija definde los met

	public CajaDeAhorro(Cliente cliente, Double saldo, Integer numeroCuenta) {
		super(cliente, saldo, numeroCuenta);
	}

	@Override
	public Boolean extraerDinero(Double monto) {
	
		return null;
	}

	@Override
	public String imprimirComprobante() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
