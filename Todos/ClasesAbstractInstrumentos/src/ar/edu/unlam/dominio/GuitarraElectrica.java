package ar.edu.unlam.dominio;

public class GuitarraElectrica extends Instrumento {
	private final Double PORCENTAJE_GANANCIA=1.1;
	private Integer cantidadDeCuerdas;
	private Boolean microfonosActivos;
		private Integer stock;


		
	public GuitarraElectrica(Integer codigo, Integer cantidadDeCuerdas, Boolean microfonosActivos, Integer stock, String color, String marca, String modelo,
			Integer anioFabricacion, Double precioBase) {
	super(codigo,color,marca,stock,modelo,anioFabricacion,precioBase);
	this.cantidadDeCuerdas=cantidadDeCuerdas;
	this.microfonosActivos=microfonosActivos;
	}



	@Override
	public String emitirSonido() {

		return "sonido guitarra";
	}



	@Override
	public Double obtenerPrecio() {
		return this.getPrecioBase()	*PORCENTAJE_GANANCIA;
	}





}
