package ar.edu.unlam.pb1.dominio;

public class Planta {

	private final double GANANCIA_HIERBA_MATA = 0.20;
	private final double GANANCIA_ARBUSTO = 0.60;
	private final double GANANCIA_ARBOL = 1.30;

	private int codigo;
	private TipoDePlanta tipoDePlanta;
	private String nombre;
	private double precioBase;
	private int stock;

	public Planta(int codigo, TipoDePlanta tipoDePlanta, String nombre, double precio, int stock) {
		// TODO: Completar el constructor
		this.codigo = codigo;
		this.tipoDePlanta = tipoDePlanta;
		this.nombre = nombre;
		this.precioBase = precio;
		this.stock = stock;
	}

	public double obtenerPrecioFinal() {
		// TODO: Calcular y devolver el precio final de la planta. Para ello, se debera
		// revisar el TipoDePlanta considerando:
		// Hierba o Mata: se incrementa un 20% el precio base.
		// Arbusto: se incrementa un 60% el precio base.
		// Arbol: se incrementa un 130% el precio base.
		// Usar las constantes

		double incrementoHierbaMata = this.precioBase * GANANCIA_HIERBA_MATA;
		double incrementoArbusto = this.precioBase * GANANCIA_ARBUSTO;
		double incrementoArbol = this.precioBase * GANANCIA_ARBOL;
		double precioFinal = 0.0;

		if (this.tipoDePlanta.equals(TipoDePlanta.HIERBA) || this.tipoDePlanta.equals(TipoDePlanta.MATA)) {
			precioFinal = this.precioBase + incrementoHierbaMata;
		} else if (this.tipoDePlanta.equals(TipoDePlanta.ARBUSTO)) {
			precioFinal = this.precioBase + incrementoArbusto;
		} else if (this.tipoDePlanta.equals(TipoDePlanta.ARBOL)) {
			precioFinal = this.precioBase + incrementoArbol;
		}

		return precioFinal;
	}
	
	

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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Planta [GANANCIA_HIERBA_MATA=" + GANANCIA_HIERBA_MATA + ", GANANCIA_ARBUSTO=" + GANANCIA_ARBUSTO
				+ ", GANANCIA_ARBOL=" + GANANCIA_ARBOL + ", codigo=" + codigo + ", tipoDePlanta=" + tipoDePlanta
				+ ", nombre=" + nombre + ", precioBase=" + precioBase + ", stock=" + stock + "]";
	}

}
