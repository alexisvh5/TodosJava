package ar.edu.unlam.aeropuerto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Vuelo {
	
	private Integer idVuelo;
	private Ruta ruta;
	private LocalDate fechaDelVuelo;
	private LocalTime horaDePartida;

	public Vuelo(Integer idVuelo,Ruta ruta, LocalDate fechaDelVuelo, LocalTime horaDePartida) {
		this.setRuta(ruta);
		this.setFechaDelVuelo(fechaDelVuelo);
		this.setHoraDePartida(horaDePartida);
		this.setIdVuelo(idVuelo);
		
	}



	public Integer getIdVuelo() {
		return idVuelo;
	}



	public void setIdVuelo(Integer idVuelo) {
		this.idVuelo = idVuelo;
	}



	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public LocalDate getFechaDelVuelo() {
		return fechaDelVuelo;
	}

	public void setFechaDelVuelo(LocalDate fechaDelVuelo) {
		this.fechaDelVuelo = fechaDelVuelo;
	}

	public LocalTime getHoraDePartida() {
		return horaDePartida;
	}

	public void setHoraDePartida(LocalTime horaDePartida) {
		this.horaDePartida = horaDePartida;
	}



	@Override
	public int hashCode() {
		return Objects.hash(idVuelo);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		return Objects.equals(idVuelo, other.idVuelo);
	}
	
	
	

}
