package ar.edu.unlam.pb1.dominio;

import ar.edu.unlam.pb1.dominio.enums.TipoDePintura;

public class LataDePintura {

	// TODO: Completar getters, setters, constructor y metodos necesarios para
	// garantizar el correcto funcionamiento.

	private final double PRECIO_BASE = 1000;

	private int codigo;
	private String nombre;
	private TipoDePintura tipoDePintura;
	private int stock;
	private double porcentajeDeGanancia;
	private double ganancia;
	private double precio;

	public LataDePintura(int codigo, String nombre, double porcentajeDeGanancia, TipoDePintura tipoDePintura,
			int stock) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.porcentajeDeGanancia = porcentajeDeGanancia;
		this.tipoDePintura = tipoDePintura;
	}

	public double obtenerPrecio() {
		// TODO: Calcular y obtener el precio de la lata de pintura, el cual se calcula
		// segun su TipoDePintura.
		// Todas las latas de pinturas son blancas y tienen un precio base. En caso de
		// ser satinadas, tonalizar la pintura blanca cuesta un 15% extra. En cambio,
		// tonalizar las pinturas mate, cuesta un 5%, pero incluye otro 3% de impuestos
		// (calculado sobre el precio base) que se debe agregar al precio final. No
		// olvidar agregar el porcentaje de ganancia, tambien calculado sobre el precio
		// base.

//		double ganancia = PRECIO_BASE*(this.porcentajeDeGanancia + 1);
//		double incremento;
//		double precioDeLaLata =0;
//		double impuesto;
//		for (int i = 0; i < TipoDePintura.values().length; i++) {
//			
//			if(TipoDePintura.values()[i] == TipoDePintura.SATINADA) {
//				incremento = (PRECIO_BASE * 15)/100;
//				precioDeLaLata = PRECIO_BASE + incremento + ganancia;
//			}
//			if(TipoDePintura.values()[i] == TipoDePintura.MATE) {
//				incremento = (PRECIO_BASE * 5)/100;
//				impuesto=(PRECIO_BASE * 3)/100;
//				precioDeLaLata = PRECIO_BASE + incremento + impuesto +ganancia;
//			}
//		}
//		
//		return precioDeLaLata;

		double extraSatinada = PRECIO_BASE * 0.15;

		double extraMate = PRECIO_BASE * 0.05;
		double impuestoMate = PRECIO_BASE * 0.03;

		this.ganancia = PRECIO_BASE * this.porcentajeDeGanancia;

		switch (this.tipoDePintura) {
		case SATINADA:
			this.precio = PRECIO_BASE + extraSatinada + this.ganancia;
			break;
		case MATE:
			this.precio = PRECIO_BASE + extraMate + impuestoMate + this.ganancia;
			break;
		default:
			break;
		}

		return this.precio;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoDePintura getTipoDePintura() {
		return tipoDePintura;
	}

	public void setTipoDePintura(TipoDePintura tipoDePintura) {
		this.tipoDePintura = tipoDePintura;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPorcentajeDeGanancia() {
		return porcentajeDeGanancia;
	}

	public void setPorcentajeDeGanancia(double porcentajeDeGanancia) {
		this.porcentajeDeGanancia = porcentajeDeGanancia;
	}

	@Override
	public String toString() {
		return "LataDePintura [PRECIO_BASE=" + PRECIO_BASE + ", codigo=" + codigo + ", nombre=" + nombre
				+ ", tipoDePintura=" + tipoDePintura + ", stock=" + stock + ", porcentajeDeGanancia="
				+ porcentajeDeGanancia + "]";
	}

}
