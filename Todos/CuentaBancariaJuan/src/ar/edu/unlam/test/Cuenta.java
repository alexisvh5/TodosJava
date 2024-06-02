package ar.edu.unlam.test;

public class Cuenta {
	
	private Integer numero;
	protected Double saldo;
	private Cliente cliente;
	
	public Cuenta(Integer numero, Double saldoInicial, Cliente cliente) {
		this.numero=numero;
		this.saldo=saldoInicial;
		this.cliente=cliente;
	}

	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/// reutilizando metodosde otras clases
	public Boolean extraer(Double dineroAExtraer) {
		if (dineroAExtraer <= this.saldo) {
			this.saldo -= dineroAExtraer;
			return true;
		}
		return false;

	}

	public void depositar(Double dineroADepositar) {
		this.saldo += dineroADepositar;

	}

}
