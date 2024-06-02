package ar.edu.unlam.pb1.dominio;

public class Planta {

	private final double GANANCIA_HIERBA_MATA = 1.2;
	private final double GANANCIA_ARBUSTO = 1.6;
	private final double GANANCIA_ARBOL = 0;

	private int codigo;
	private TipoDePlanta tipoDePlanta;
	private String nombre;
	private double precioBase;
	private int stock;

	public Planta(int codigo, TipoDePlanta tipoDePlanta, String nombre, double precio, int stock) {
		// TODO: Completar el constructor
		this.codigo=codigo;
		this.tipoDePlanta=tipoDePlanta;
		this.nombre=nombre;
		this.precioBase=precio;
		this.stock=stock;
	}

	public double obtenerPrecioFinal() {
		// TODO: Calcular y devolver el precio final de la planta. Para ello, se debera revisar el TipoDePlanta considerando:
		// Hierba o Mata: se incrementa un 20% el precio base.
		// Arbusto: se incrementa un 60% el precio base.
		// Arbol: se incrementa un 130% el precio base.
		// Usar las constantes
		double incremento = 0;
		for (int i = 0; i < TipoDePlanta.values().length; i++) {
			if (TipoDePlanta.values()[i] == TipoDePlanta.HIERBA&&TipoDePlanta.values()[i] == TipoDePlanta.MATA) {
			this.precioBase = (precioBase * GANANCIA_HIERBA_MATA);}
			if (TipoDePlanta.values()[i] == TipoDePlanta.ARBUSTO) {
				this.precioBase = (precioBase * GANANCIA_ARBUSTO);}
			if (TipoDePlanta.values()[i] == TipoDePlanta.ARBOL) {
			 incremento = (precioBase * 130)/100;
			 this.precioBase = this.precioBase + incremento;
	}
		}return this.precioBase;
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

	@Override
	public String toString() {
		return "Planta [ nombre=" + nombre + ", precioBase=" + precioBase + ", stock=" + stock + "]";
	}

}
