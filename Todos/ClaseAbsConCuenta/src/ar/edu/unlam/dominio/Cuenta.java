package ar.edu.unlam.dominio;

public abstract class Cuenta {
	
	private Cliente cliente;
	private Double saldo;
	private Integer numeroCuenta;
	public Cuenta(Cliente cliente, Double saldo, Integer numeroCuenta) {
		this.cliente = cliente;
		this.saldo = saldo;
		this.numeroCuenta = numeroCuenta;
	}
	
	public Boolean ingresarDinero(Double monto) {
		this.saldo +=monto;
		return true;
	}
	
 ////////////// genero getters an set
	
	
	public abstract  Boolean extraerDinero(Double monto);

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Integer getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Integer numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	
	
	
}
