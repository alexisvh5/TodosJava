package ar.edu.unlam.pb1.dominio;

import ar.edu.unlam.pb1.dominio.enums.TipoDeCeramica;

public class CajaDeCeramica {
	// TODO: Completar el constructor, getters, setters y metodos necesarios para
	// garantizar el correcto funcionamiento. El
	// precio de la caja se calcula en base al precio de la ceramica por la cantidad
	// que trae la caja.

	private String codigo;
	private double alturaDeCeramica;
	private double largoDeCeramica;
	private double precio;
	private int cantidadEnCaja;
	private TipoDeCeramica tipoDeCeramica;
private boolean contado;
	public CajaDeCeramica(String codigo, String nombre, double altura, double largo, double precioDeCeramica,
			TipoDeCeramica tipoDeCeramica, int cantidadEnCaja) {
		this.codigo = codigo;
		this.alturaDeCeramica = altura;
		this.largoDeCeramica = largo;
		this.cantidadEnCaja = cantidadEnCaja;
		this.tipoDeCeramica=tipoDeCeramica;
		this.precio=precioDeCeramica;
	//	this.contado=false;
	}

	public double obtenerAreaDeCoberturaDeUnaCaja() {
		return this.largoDeCeramica * this.alturaDeCeramica * this.cantidadEnCaja;
	}

	////
	public TipoDeCeramica getTipoDeCeramica() {
		return this.tipoDeCeramica;
	}


	public String getCodigo() {
		return this.codigo;
	}

	public double getPrecio(){
		return this.precio;
	}
	
	@Override
	public String toString() {
		return "CajaDeCeramica [codigo=" + codigo + ", ya fue contado: "+this.contado+ ", alturaDeCeramica=" + alturaDeCeramica + ", largoDeCeramica="
				+ largoDeCeramica + ", precio=" + precio + ", cantidadEnCaja=" + cantidadEnCaja + ", tipoDeCeramica="
				+ tipoDeCeramica +"]";
	}

//	public boolean isContado() {
//		return contado;
//	}
//	public void setContado(boolean verdad) {
//		 contado=verdad;
//	}

}
