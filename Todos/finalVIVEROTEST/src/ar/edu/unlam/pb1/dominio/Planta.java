package ar.edu.unlam.pb1.dominio;

public class Planta {

	private final double GANANCIA_HIERBA_MATA = 1.2;
	private final double GANANCIA_ARBUSTO = 1.6;
	private final double GANANCIA_ARBOL = 2.3;

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
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getStock() {
		return this.stock;
	}
	
	public TipoDePlanta getTipoDePlanta() {
		return this.tipoDePlanta;
	}

	public double obtenerPrecioFinal() {
		// TODO: Calcular y devolver el precio final de la planta. Para ello, se debera
		// revisar el TipoDePlanta considerando:
		// Hierba o Mata: se incrementa un 20% el precio base.
		// Arbusto: se incrementa un 60% el precio base.
		// Arbol: se incrementa un 130% el precio base.
		// Usar las constantes

		double precioFinal = 0;

		switch (this.tipoDePlanta) {
		case HIERBA:
		case MATA:
			precioFinal = this.precioBase * GANANCIA_HIERBA_MATA;
			break;
		case ARBUSTO:
			precioFinal = this.precioBase * GANANCIA_ARBUSTO;
			break;
		case ARBOL:
			precioFinal = this.precioBase * GANANCIA_ARBOL;
			break;
		}

		return precioFinal;
	}

	@Override
	public String toString() {
		// TODO: Mostrar la informacion actual de la planta incluyendo el precio final.
		// Considerar el metodo: obtenerPrecioFinal()
		return "Planta [GANANCIA_HIERBA_MATA=" + GANANCIA_HIERBA_MATA + ", GANANCIA_ARBUSTO=" + GANANCIA_ARBUSTO
				+ ", GANANCIA_ARBOL=" + GANANCIA_ARBOL + ", codigo=" + codigo + ", tipoDePlanta=" + tipoDePlanta
				+ ", nombre=" + nombre + ", precioBase=" + precioBase + ", stock=" + stock + " precioFinal= " + this.obtenerPrecioFinal() + "]";
	}
}
