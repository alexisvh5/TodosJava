package ar.edu.unlam.pb1.dominio;

public class Planta {

	private final double GANANCIA_HIERBA_MATA = 0.2;
	private final double GANANCIA_ARBUSTO = 0.6;
	private final double GANANCIA_ARBOL = 1.3;

	private double precioBase;
	private int codigo;
	private TipoDePlanta tipoDePlanta;
	private String nombre;

	private int stock;

	public Planta(int codigo, TipoDePlanta tipoDePlanta, String nombre, double precio, int stock) {
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
		double ganancia = 0;

		switch (this.tipoDePlanta) {
		case HIERBA:
		case MATA:
			ganancia = GANANCIA_HIERBA_MATA;
			break;
		case ARBUSTO:
			ganancia = GANANCIA_ARBUSTO;
			break;
		case ARBOL:
			ganancia = GANANCIA_ARBOL;
			break;
		}

		double precioFinal = precioBase + ganancia * precioBase;

		return precioFinal;
	}

	@Override
	public String toString() {
		// TODO: Mostrar la informacion actual de la planta incluyendo el precio final.
		// Considerar el metodo: obtenerPrecioFinal()
		return "Codigo: " + codigo + ", Tipo de planta: " + tipoDePlanta + ", Nombre: " + nombre + ", Stock: " + stock
				+ ", Precio Base: $" + precioBase + ", Precio final: $" + this.obtenerPrecioFinal();
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

	public double getGANANCIA_HIERBA_MATA() {
		return GANANCIA_HIERBA_MATA;
	}

	public double getGANANCIA_ARBUSTO() {
		return GANANCIA_ARBUSTO;
	}

	public double getGANANCIA_ARBOL() {
		return GANANCIA_ARBOL;
	}

	// no hice verificacion ya que la apliqué en la logica de vivero, consultar.
	public void reducirStock(int cantidadAVender) {
		stock -= cantidadAVender;
	}

}
