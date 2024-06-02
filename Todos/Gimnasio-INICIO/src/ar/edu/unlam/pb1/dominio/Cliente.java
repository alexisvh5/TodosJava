package ar.edu.unlam.pb1.dominio;


public class Cliente {

	private int dni;
	private String nombre;
	private String contrasenia;
	private Actividad[]actividadesQuePuedeRealizar;
	
	public Cliente(int dni, String nombre, String contrasenia) {
		// TODO: El cliente podra realizar hasta 10000 actividades
		this.dni = dni;
		this.nombre = nombre;
		this.contrasenia =contrasenia;
		this.actividadesQuePuedeRealizar = new Actividad[20];
	}

	public void realizarActividad(Actividad actividad) {
		// TODO: Agrega una actividad a las actividades del cliente
		
//		for (int i = 0; i < actividadesQuePuedeRealizar.length; i++) {
//			if (actividadesQuePuedeRealizar[i]==null) {
//				actividadesQuePuedeRealizar[i]=actividad;
//			}
//		}
		int i =0;
		while (i < actividadesQuePuedeRealizar.length) {
			if (actividadesQuePuedeRealizar[i]==null) {
				actividadesQuePuedeRealizar[i]=actividad;
				i=actividadesQuePuedeRealizar.length;
			}else {i++;}
		}
		
	}

	public boolean eliminarActividadPorId(int id) {
		// TODO: busca una actividad por su id y en caso de existir, la elimina.
		
		for (int i = 0; i < actividadesQuePuedeRealizar.length; i++) {
			if (actividadesQuePuedeRealizar[i] != null && actividadesQuePuedeRealizar[i].getId()==id) {
				actividadesQuePuedeRealizar[i]=null;
				return true;
			}
		}
		
		return false;
	}

	public int obtenerCantidadDeActividadesRealizadas() {
		// TODO: revisar cuantas actividades realizo el cliente y devolver el valor
		// correspondiente
		
		int cantidadDeActividadesRealizadas=0;
		for (int i = 0; i < actividadesQuePuedeRealizar.length; i++) {
			if (actividadesQuePuedeRealizar[i]!=null) {
				cantidadDeActividadesRealizadas++;
			}
		}
		
		return cantidadDeActividadesRealizadas;
	}

	public double obtenerCantidadDeCaloriasQuemadasPorActividadDeTipo(TipoActividad tipoActividad) {

		// TODO: Obtener la cantidad de calorias quemadas por el cliente al realizar
		// actividades de un tipo determinado
		
		int i =0;
		
		double cantidadDeCaloriasQuemadasPorAct = 0;
		
		while (i < actividadesQuePuedeRealizar.length) {
			if (actividadesQuePuedeRealizar[i]!=null && actividadesQuePuedeRealizar[i].getTipoActividad()==tipoActividad) {
				cantidadDeCaloriasQuemadasPorAct = actividadesQuePuedeRealizar[i].getCaloriasQueQuema();
				i=actividadesQuePuedeRealizar.length;
			}else {i++;}
		}
		
		
		return cantidadDeCaloriasQuemadasPorAct;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Actividad[] getActividadesQuePuedeRealizar() {
		return actividadesQuePuedeRealizar;
	}

	public void setActividadesQuePuedeRealizar(Actividad[] actividadesQuePuedeRealizar) {
		this.actividadesQuePuedeRealizar = actividadesQuePuedeRealizar;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre ;
	}
	
	
}
