package ar.edu.unlam.pb1.dominio;

import ar.edu.unlam.pb1.dominio.enums.TipoDePintura;

public class LataDePintura {
	
	// TODO: Completar getters, setters, constructor y metodos necesarios para garantizar el correcto funcionamiento.

	private final double PRECIO_BASE = 1000;

	private int codigo;
	private String nombre;
	private TipoDePintura tipoDePintura;
	private int stock;
	private double porcentajeDeGanancia;

	public LataDePintura(int codigo, String nombre, double porcentajeDeGanancia, TipoDePintura tipoDePintura,
			int stock) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.porcentajeDeGanancia=porcentajeDeGanancia;
		this.tipoDePintura = tipoDePintura;
		this.stock = stock;
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
		double precio=0.0;
		double tonalizarPorSatinada = (this.PRECIO_BASE* 15)/100; 
		double tonalizarPorMate =(this.PRECIO_BASE* 5)/100;
		double impuestoMate=(this.PRECIO_BASE*3)/100;
		double ganancia = (this.PRECIO_BASE*this.porcentajeDeGanancia)/100;
		
		if (this.tipoDePintura==TipoDePintura.MATE) {
			precio = this.PRECIO_BASE + tonalizarPorMate + impuestoMate + ganancia;
		}else if(this.tipoDePintura==TipoDePintura.SATINADA) {
			precio = this.PRECIO_BASE + tonalizarPorSatinada + ganancia;
		}else {precio = 0.0;}
		return precio;
	
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
		return "LataDePintura [codigo=" + codigo + ", nombre=" + nombre + ", tipoDePintura=" + tipoDePintura
				+ ", stock=" + stock + ", porcentajeDeGanancia=" + porcentajeDeGanancia + "]";
	}
	

}
















//
//double ganancia = PRECIO_BASE*(this.porcentajeDeGanancia);
//double incremento=0;
//double precioDeLaLata=0;
//double impuesto=0;
//
//
//switch (this.tipoDePintura) {
//case SATINADA:
//	incremento = (PRECIO_BASE * 15)/100;
//	precioDeLaLata = PRECIO_BASE + incremento + ganancia;
//	
//	break;
//case MATE:
//	incremento = (PRECIO_BASE * 5)/100;
//	impuesto=(PRECIO_BASE * 3)/100;
//	precioDeLaLata = PRECIO_BASE + incremento + impuesto +ganancia;
//	break;
//default:
//	break;
//}
//
//return precioDeLaLata;