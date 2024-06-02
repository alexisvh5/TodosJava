package ar.edu.unlam.dominio;


import java.util.Objects;


public abstract class Instrumento   {
	
    private Integer codigo;
	private String color;
	private String marca;
	private String modelo;
	private Integer anioFabricacion;
	private Integer stock;
private Double precioBase;

	public Instrumento(Integer codigo,String color, String marca, Integer stock,String modelo,  Integer anioFabricacion, Double precioBase) {
	this.codigo=codigo;
	this.color=color;
	this.marca=marca;
	this.stock=stock;
	this.modelo=modelo;
	this.anioFabricacion=anioFabricacion;
	this.precioBase=precioBase;
	}


	public Integer getCodigo() {
		return codigo;
	}
	
	public Double getPrecioBase() {
		return this.precioBase;
	};
	
	public abstract Double obtenerPrecio();

	
	public abstract String emitirSonido();

//
//	@Override
//	public int hashCode() {
//		return Objects.hash(codigo);
//	}
//
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Instrumento other = (Instrumento) obj;
//		return Objects.equals(codigo, other.codigo);
//	}
	
	
	
	

}








