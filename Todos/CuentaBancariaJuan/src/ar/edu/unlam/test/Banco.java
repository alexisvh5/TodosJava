package ar.edu.unlam.test;

import java.util.ArrayList;

public class Banco {
	private String nombre;
	private ArrayList<CuentaSueldo> cuentasSueldo;
	private ArrayList<CajaDeAhorro> cajasDeAhorros;
	private ArrayList<CuentaCorriente> cuentasCorrientes;
	public Banco(String nombre) {
		this.nombre = nombre;
		this.cuentasSueldo = new ArrayList<>();
		this.cajasDeAhorros=new ArrayList<>();
		this.cuentasCorrientes=new ArrayList<>();

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public boolean agregarCuenta(CuentaCorriente nueva) {

		return this.cuentasCorrientes.add(nueva);
	}

	public Boolean agregarCuenta(CuentaSueldo nueva) {

		return this.cuentasSueldo.add(nueva);

	}
	
	public Boolean agregarCuenta(CajaDeAhorro nueva) {
	
		return this.cajasDeAhorros.add(nueva);
	}

	public CuentaSueldo buscarCuentaSueldoPorNumero(Integer numero) {
		
		
		for (CuentaSueldo cuentaSueldo : this.cuentasSueldo) {
			if (cuentaSueldo.getNumero().equals(numero)) {
				return cuentaSueldo;
			}
		}	return null;

	}
	public CajaDeAhorro buscarCajaDeAhorroPorNumero(Integer numero) {
		
		for (CajaDeAhorro cajaDeAhorro : cajasDeAhorros) {
			if (cajaDeAhorro.getNumero().equals(numero)) {
				return cajaDeAhorro;
			}
		}

			return null;
	}

	public CuentaCorriente buscarCuentaCorriente(Integer numero) {

		for (CuentaCorriente cuentaCorriente : cuentasCorrientes) {
			if (cuentaCorriente.getNumero().equals(numero)) {
				return cuentaCorriente;
			}
		}

			return null;
	}

	
}
