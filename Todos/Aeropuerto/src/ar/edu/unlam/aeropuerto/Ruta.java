package ar.edu.unlam.aeropuerto;

import java.time.LocalTime;
import java.util.Objects;

public class Ruta {
	private String origen;
	private String destino;
	private LocalTime duracion;
	private Integer idRuta;

	public Ruta(Integer idRuta,String origen, String destino, LocalTime duracion) {
		this.setIdRuta(idRuta);
		this.setOrigen(origen);
		this.setDestino(destino);
		this.setDuracion(duracion);

	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public LocalTime getDuracion() {
		return duracion;
	}

	public void setDuracion(LocalTime duracion) {
		this.duracion = duracion;
	}

	public Integer getIdRuta() {
		return idRuta;
	}

	public void setIdRuta(Integer idRuta) {
		this.idRuta = idRuta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(destino, idRuta, origen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ruta other = (Ruta) obj;
		
		return Objects.equals(destino, other.destino) && Objects.equals(idRuta, other.idRuta)
				&& Objects.equals(origen, other.origen);
	}

	
	
	
}
