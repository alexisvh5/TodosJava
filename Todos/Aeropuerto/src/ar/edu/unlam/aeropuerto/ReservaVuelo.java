package ar.edu.unlam.aeropuerto;

public class ReservaVuelo {
	private Integer idReservaVuelo;
	private Vuelo vuelo;
	private Reserva reserva;

	public ReservaVuelo(Integer idReservaVuelo, Vuelo vuelo, Reserva reserva) {
		this.setIdReservaVuelo(idReservaVuelo);
		this.setVuelo(vuelo);
		this.setReserva(reserva);
		
	}

	public Integer getIdReservaVuelo() {
		return idReservaVuelo;
	}

	public void setIdReservaVuelo(Integer idReservaVuelo) {
		this.idReservaVuelo = idReservaVuelo;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	
	
}
