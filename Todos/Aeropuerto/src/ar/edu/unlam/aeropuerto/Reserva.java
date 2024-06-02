package ar.edu.unlam.aeropuerto;

import java.util.Objects;

public class Reserva {
	
	
	private Integer idReserva;
	private Cliente cliente;
	private Double precio;

	public Reserva(Integer idReserva, Cliente cliente, Double precio) {
		this.setIdReserva(idReserva);
		this.setCliente(cliente);
		this.setPrecio(precio);
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, idReserva, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(idReserva, other.idReserva)
				&& Objects.equals(precio, other.precio);
	}

	
	
	
}
