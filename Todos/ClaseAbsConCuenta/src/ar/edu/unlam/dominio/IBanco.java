package ar.edu.unlam.dominio;

public interface IBanco {
	
	Boolean agregarCuenta(Cuenta cuenta);
	Boolean agregarCliente(Cliente cliente);
void extraerDineroDeCuenta(Integer numeroDeCuenta, Double monto);
void ingresarDineroEnCuenta(Integer numeroDeCuenta, Double monto);
	
}
