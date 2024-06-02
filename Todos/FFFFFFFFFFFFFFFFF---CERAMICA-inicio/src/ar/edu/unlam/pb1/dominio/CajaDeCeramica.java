package ar.edu.unlam.pb1.dominio;

import ar.edu.unlam.pb1.dominio.enums.TipoDeCeramica;

public class CajaDeCeramica {
	// TODO: Completar el constructor, getters, setters y metodos necesarios para
	// garantizar el correcto funcionamiento. El
	// precio de la caja se calcula en base al precio de la ceramica por la cantidad
	// que trae la caja.
	
	private String codigo;
	private String nombre;
	private double alturaDeCeramica;
	private double largoDeCeramica;
	private double precio;
	private int cantidadEnCaja;
private TipoDeCeramica tipoDeCeramica;


	public CajaDeCeramica(String codigo, String nombre, double altura, double largo, double precioDeCeramica,
			TipoDeCeramica tipoDeCeramica, int cantidadEnCaja) {
this.codigo=codigo;
		this.alturaDeCeramica = altura;
		this.largoDeCeramica = largo;
		this.cantidadEnCaja = cantidadEnCaja;
		this.tipoDeCeramica=tipoDeCeramica;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getAlturaDeCeramica() {
		return alturaDeCeramica;
	}

	public void setAlturaDeCeramica(double alturaDeCeramica) {
		this.alturaDeCeramica = alturaDeCeramica;
	}

	public double getLargoDeCeramica() {
		return largoDeCeramica;
	}

	public void setLargoDeCeramica(double largoDeCeramica) {
		this.largoDeCeramica = largoDeCeramica;
	}

	public int getCantidadEnCaja() {
		return cantidadEnCaja;
	}

	public void setCantidadEnCaja(int cantidadEnCaja) {
		this.cantidadEnCaja = cantidadEnCaja;
	}

	public TipoDeCeramica getTipoDeCeramica() {
		return tipoDeCeramica;
	}

	public void setTipoDeCeramica(TipoDeCeramica tipoDeCeramica) {
		this.tipoDeCeramica = tipoDeCeramica;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public double obtenerAreaDeCoberturaDeUnaCaja() {
		return this.precio * this.cantidadEnCaja;
	}
	
	public double obtenerPrecio() {
		return this.precio = this.precio * this.cantidadEnCaja;
	}

	@Override
	public String toString() {
		return "CajaDeCeramica [codigo=" + codigo + ", nombre=" + nombre + ", alturaDeCeramica=" + alturaDeCeramica
				+ ", largoDeCeramica=" + largoDeCeramica + ", precio=" + precio + ", cantidadEnCaja=" + cantidadEnCaja
				+ ", tipoDeCeramica=" + tipoDeCeramica + "]";
	}

}
