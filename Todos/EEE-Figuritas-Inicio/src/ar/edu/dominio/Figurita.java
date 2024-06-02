package ar.edu.dominio;

public class Figurita {
	
	private String codigo;
	private char grupo;
	private String seleccion;
	private String nombreJugador;
	private double valor;
	
	public Figurita(String codigo) {
		this.codigo = codigo;
		this.seleccion = "";
		this.grupo = ' ';
		this.nombreJugador = "";
		this.valor = 0;
	}
	public Figurita(String codigo,String seleccion) {
		
		this.codigo = codigo;
		this.seleccion = seleccion;
		this.grupo = ' ';
		this.nombreJugador = "";
		this.valor = 0;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public char getGrupo() {
		return grupo;
	}

	public void setGrupo(char grupo) {
		this.grupo = grupo;
	}

	public String getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Figurita [codigo=" + codigo + ", grupo=" + grupo + ", seleccion=" + seleccion + ", nombreJugador="
				+ nombreJugador + ", valor=" + valor + "]";
	}
	

}