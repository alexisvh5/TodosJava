package ar.edu.unlam.pb1.dominio;


import java.util.Arrays;

public class Cliente {
	
	private int dni;
	private String nombre;
	private String contrasenia;
	private Actividad[] actividades;
	private int cantidadDeActividadesRealizadas;

	public Cliente(int dni, String nombre, String contrasenia) {
		// TODO: El cliente podra realizar hasta 10000 actividades
		this.dni=dni;
		this.nombre = nombre;
		this.contrasenia=contrasenia;
		this.actividades= new Actividad[10000];
		this.cantidadDeActividadesRealizadas =0;
	}

	public void realizarActividad(Actividad actividad) {
		// TODO: Agrega una actividad a las actividades del cliente
		
		for (int i = 0; i < actividades.length; i++) {
			if(actividades[i] == null) {
				actividades[i] = actividad;
				cantidadDeActividadesRealizadas++;
				break;
			}
		}
		
		
	}

	public boolean eliminarActividadPorId(int id) {
		// TODO: busca una actividad por su id y en caso de existir, la elimina.
		
		int iteracion=0;
		boolean encontrado=false;
		
	while(!encontrado && iteracion <actividades.length) {
		if (actividades[iteracion] != null && actividades[iteracion].getId() == id) {
			actividades[iteracion] =null;
			disminuirCantidadDeActividadesRealizadas();
			encontrado = true;
		}
	
	iteracion++;}
		
		return encontrado;
	}

	private void disminuirCantidadDeActividadesRealizadas() {
		// TODO Auto-generated method stub
		cantidadDeActividadesRealizadas--;
		
	}

	public int obtenerCantidadDeActividadesRealizadas() {
		// TODO: revisar cuantas actividades realizo el cliente y devolver el valor
		// correspondiente
		return cantidadDeActividadesRealizadas; /// esto si agrego ese atributo, tengo que disminuir tambien, crear otro, cuando elimino uno.. porque sino solo deberia contar  en un for, las cantidad de act que no son null
	}

	public double obtenerCantidadDeCaloriasQuemadasPorActividadDeTipo(TipoActividad tipoActividad) {
		// TODO: Obtener la cantidad de calorias quemadas por el cliente al realizar
		// actividades de un tipo determinado
		return 0;
	}
}
