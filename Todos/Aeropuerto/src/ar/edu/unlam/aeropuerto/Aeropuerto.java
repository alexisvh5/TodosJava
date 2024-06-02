package ar.edu.unlam.aeropuerto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class Aeropuerto {
	private String nombreDelAeropuerto;
	private ArrayList<Vuelo> vuelos;
	private HashSet<Cliente> clientes;
	private ArrayList<Reserva> reservas;
	private ArrayList<Ruta> rutas;
	// private ArrayList<Voucher> vouchers;
	private ArrayList<ReservaVuelo> reservasDeVuelos;

	public Aeropuerto(String nombreDelAeropuerto) {
		this.setNombreDelAeropuerto(nombreDelAeropuerto);
		this.rutas = new ArrayList<>();
		this.vuelos = new ArrayList<>();
		this.clientes = new HashSet<>();
		this.reservas = new ArrayList<>();
		this.reservasDeVuelos = new ArrayList<>();

	}

	public void setNombreDelAeropuerto(String nombreDelAeropuerto) {
		this.nombreDelAeropuerto = nombreDelAeropuerto;
	}

	public Boolean agregarRuta(Ruta ruta) {
		return this.rutas.add(ruta);
	}

	public Boolean agregarVuelo(Vuelo vuelo) {
		return this.vuelos.add(vuelo);
	}

	public Boolean agregarCliente(Cliente cliente) {
		return this.clientes.add(cliente);
	}

	public Boolean agregarReserva(Reserva reserva) {
		return this.reservas.add(reserva);
	}

	public Boolean agregarReservaVuelo(ReservaVuelo reservaVuelo) {
		// TODO Auto-generated method stub
		return this.reservasDeVuelos.add(reservaVuelo);
	}

	public ArrayList<Cliente> obtenerListadoDePersonaEnDeUnVuelo(Integer idVuelo) {

		ArrayList<Cliente> listadoDePersonasEnUnVuelo = new ArrayList<>();

		if (comprobarVuelo(idVuelo) == true) {
			for (ReservaVuelo reservaVuelo : this.reservasDeVuelos) {
				if (reservaVuelo.getVuelo().getIdVuelo().equals(idVuelo)) {
					listadoDePersonasEnUnVuelo.add(reservaVuelo.getReserva().getCliente());
				}
			}
		}
		 Collections.sort(listadoDePersonasEnUnVuelo);
		 return listadoDePersonasEnUnVuelo;
		
		

	}

	public Boolean comprobarVuelo(Integer idVuelo) {
		for (Vuelo vuelo : this.vuelos) {
			if (vuelo.getIdVuelo().equals(idVuelo)) {
				return true;
			}
		}
		return false;
	}
	
	
	public Boolean comprobarReserva(Integer idReserva) {
		for (Reserva reserva : this.reservas) {
			if (reserva.getIdReserva().equals(idReserva)) {
				return true;
			}
		}
		return false;
	}


	public Double obtenerLaRecaudacionTotalDeUnaReserva(Integer idReserva) {
		
		
		Double recaudacionTotal = 0.0;
		if(comprobarReserva(idReserva) == true) {
			for(ReservaVuelo reservaVuelo : this.reservasDeVuelos) {
				if(reservaVuelo.getReserva().getIdReserva().equals(idReserva)) {
					recaudacionTotal += reservaVuelo.getReserva().getPrecio();
				}
				
			}
		}
		return recaudacionTotal;
	}
	
	


}
