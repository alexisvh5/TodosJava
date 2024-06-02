package ar.edu.unlam.pb2.colecciones;

import java.util.ArrayList;
import java.util.Iterator;

public class Garage {
	
	private ArrayList <Vehiculo> vehiculos;
	private Integer cantidadMax;

	public Garage(Integer cantidadMaxima) {
		// TODO Auto-generated constructor stub
		this.cantidadMax=cantidadMaxima;
		this.vehiculos= new ArrayList<>();;
	}

	public Boolean agregar(Vehiculo vehiculo) {
		
		if (vehiculos.size()<this.cantidadMax) {
			return vehiculos.add(vehiculo);
		}
		
		return false	;
	}

	public ArrayList<Vehiculo> obtenerVehiculos() {
		// TODO Auto-generated method stub

		return this.vehiculos;
	}

	public Vehiculo obtener(Vehiculo vehiculoBuscado) {
		
		//FOREEHACHHCHCHH
		
		for (Vehiculo vehiculo : this.vehiculos) {
			if (vehiculo.equals(vehiculoBuscado)) { // ppodria poner vehiculo !=null && vehiculoBuscado !=null
				return vehiculo;
			}
		}
		
		return null;
	}

	public void eliminarVehiculo(Vehiculo vehiculo1) {
	
//		Boolean termino = false;
//		Integer inte = 1;
//		
//	while (inte < vehiculos.size() && !termino) {
//		if (vehiculos.get(inte)!=null && vehiculos.get(inte).getId().equals(vehiculo1.getId())) {
//			vehiculos.remove(inte);
//			termino = true;
//		}inte++;
//	}
		
		for (Vehiculo vehiculo : vehiculos) {
			if (vehiculo!=null && vehiculo.getId().equals(vehiculo1.getId())) {
				vehiculos.remove(vehiculo);
				break;/////(???????????????)
			}
		}
		
	}

}
