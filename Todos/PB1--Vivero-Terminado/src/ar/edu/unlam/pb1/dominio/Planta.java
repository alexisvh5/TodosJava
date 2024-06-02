package ar.edu.unlam.pb1.dominio;

public class Planta {
// CONSTANTES
	private final double GANANCIA_HIERBA_MATA = 0.2;
	private final double GANANCIA_ARBUSTO = 0.6;
	private final double GANANCIA_ARBOL = 1.3;
	
	//--------------------------------

	private int codigo;
	//
	private TipoDePlanta tipoDePlanta;
	//
	private String nombre;
	//
	private double precioBase;
	//
	private int stock;
	private final int STOCK_INICIAL; 
	
	
	
	
	///____________________________________________________________

	public Planta(int codigo, TipoDePlanta tipoDePlanta, String nombre, double precio, int stock) {
		// TODO: Completar el constructor
		this.codigo = codigo;
		this.tipoDePlanta = tipoDePlanta;
		this.nombre = nombre;
		this.precioBase = precio;
		this.stock = stock;
		STOCK_INICIAL = stock;

	}
	
	// __________________________________________

	public double obtenerPrecioFinal() {
		// TODO: Calcular y devolver el precio final de la planta. Para ello, se debera
		// revisar el TipoDePlanta considerando:
		// Hierba o Mata: se incrementa un 20% el precio base.
		// Arbusto: se incrementa un 60% el precio base.
		// Arbol: se incrementa un 130% el precio base.
		// Usar las constantes
		double precioFinal = 0;
		if (this.getTipoDePlanta().equals(TipoDePlanta.HIERBA) || this.getTipoDePlanta().equals(TipoDePlanta.MATA)) {
			double incremento = this.precioBase * GANANCIA_HIERBA_MATA;
			precioFinal = this.precioBase + incremento;
		} else if (this.getTipoDePlanta().equals(TipoDePlanta.ARBUSTO)) {
			double incremento = this.precioBase * GANANCIA_ARBUSTO;
			precioFinal = this.precioBase + incremento;
		} else {
			double incremento = this.precioBase * GANANCIA_ARBOL;
			precioFinal = this.precioBase + incremento;
		}

		return precioFinal;
	}
	
	
	//-----------------------------------------

/*	public boolean disminuyoStock() {

		if (STOCK_INICIAL < this.stock) {
			return true;
		}

		return false;
	}*/

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public TipoDePlanta getTipoDePlanta() {
		return tipoDePlanta;
	}

	public void setTipoDePlanta(TipoDePlanta tipoDePlanta) {
		this.tipoDePlanta = tipoDePlanta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean actualizarStock(int stock) {
		this.stock += stock;
		return true;
	}

	public double getGANANCIA_HIERBA_MATA() {
		return GANANCIA_HIERBA_MATA;
	}

	public double getGANANCIA_ARBUSTO() {
		return GANANCIA_ARBUSTO;
	}

	public double getGANANCIA_ARBOL() {
		return GANANCIA_ARBOL;
	}
	
	//______________________________________

	@Override
	public String toString() {
		return "Planta [codigo=" + codigo + ", tipoDePlanta=" + tipoDePlanta + ", nombre=" + nombre + ", precioBase="
				+ precioBase + ", stock=" + stock + ",precioFinal=" + obtenerPrecioFinal() + "]";
	}

}
