package ar.edu.unlam.dominio;

public class Bateria extends Instrumento {
	
	private final Double PRECIO_TAMBOR=500.0;

	private final Double PRECIO_PLATILLO=200.0;

	private Integer cantidadTambores;
	private Integer cantidadPlatillos;

	public Bateria(Integer codigo, Integer cantidadTambores, Integer cantidadPlatillos, String color, String marca, String modelo,
			Integer anioFabricacion, Integer stock,Double precioBase) {

super(codigo,color,marca,stock,modelo,anioFabricacion,precioBase);

this.cantidadPlatillos=cantidadPlatillos;
this.cantidadTambores=cantidadTambores;

	}

	@Override
	public String emitirSonido() {
		
		return "trutiss";
	}

	@Override
	public Double obtenerPrecio() {
		
		Double precioTambores = this.cantidadTambores * PRECIO_TAMBOR;
		Double precioPlatillos=this.cantidadPlatillos * PRECIO_PLATILLO ;

		return this.getPrecioBase() + precioTambores + precioPlatillos;
	}

}
