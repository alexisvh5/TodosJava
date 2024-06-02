package ar.edu.unlam.pb1.dominio;

public class Juego {
	private static int id;
	private Jugador[] jugadores;
	private Jugador[] ganadores;

	public Juego() {
		this.jugadores = new Jugador[20];
		this.ganadores = new Jugador[jugadores.length];
	}

	public static int obtenerSiguienteId() {
		id++;
		return id;
	}

	public Jugador jugar(Jugador jugadorUno, Jugador jugadorDos, int rondas) {
		// Jugar la cantidad de rondas especificada
		// Determinar el ganador
		// Acumular los puntos al jugador ganador
		// Actualizar los puntos del ganador en el array de ganadores
		
		int puntosJug1 =1;
		int puntosJug2 =1;
		
		Jugador ganador = null;
		Jugador jugadorAleatorio=null;
		
		
		for (int i = 0; i < rondas; i++) {
				do {
				jugadorAleatorio= jugadores[(int)((Math.random()*jugadores.length)+1)];
				} while (jugadorAleatorio.getId()!=jugadorUno.getId()||jugadorAleatorio.getId()!=jugadorDos.getId());

			if (jugadorAleatorio.getId()== jugadorUno.getId()) {
				puntosJug1++;
			}
			if (jugadorAleatorio.getId()== jugadorDos.getId()) {
				puntosJug1++;
			}	
			
		}
	
			if (puntosJug1>puntosJug2) {
			ganador = jugadorUno;
			ganador.setPuntaje(puntosJug1);
			
		}else {
			ganador =jugadorDos;
			ganador.setPuntaje(puntosJug2);
		}
	
		
		return ganador;
	}



	public Jugador obtenerPorNombre(String nombreJugador) {

		Jugador jugadorBuscado = null;
		int i = 0;

		while (i < jugadores.length && jugadorBuscado == null) {
			if (jugadores[i] != null && jugadores[i].getNombre().equalsIgnoreCase(nombreJugador)) {
				jugadorBuscado = jugadores[i];
			}i++;
		}
		return jugadorBuscado;
	}

	public Jugador[] obtenerJugadoresOrdenadosPorPuntajeDescendente() {
		// Ordenar los jugadores en el array por puntos de manera descendente
		
		Jugador aux = null; 
		
		for (int i = 0; i < jugadores.length; i++) {
			for (int j = 0; j < jugadores.length-1; j++) {
				if (jugadores[j]!=null && jugadores[j+1]!=null) {
					if (jugadores[j].getPuntaje()< jugadores[j+1].getPuntaje()) {
						aux=jugadores[j+1];
						jugadores[j+1]=jugadores[j];
						jugadores[j]=aux;
					}
				}
			}
		}
		
		return jugadores;
	}

	public double obtenerPromedioPuntaje() {
		// Calcula el promedio de puntaje de los jugadores y lo devuelve
		return 0D;
	}

	public Jugador[] getJugadores() {
		return jugadores;
	}

	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
	}

	private void actualizarPuntos(Jugador ganador) {
		// Buscar el jugador por id. En caso de existir, asignar al jugador del array
		// los puntos del ganador
		// En caso de no existir, agregar el jugador al array

		int i = 0;

		while (i < ganadores.length ) {
			if (ganadores[i] != null && ganadores[i].getId()==ganador.getId()) {
				ganadores[i].setPuntaje(ganador.getPuntaje());
			}i++;
		}
	
		
	}

	private void agregarJugador(Jugador ganador) {
		// Busca un lugar y agrega un jugador
		int i = 0;

		while (i < ganadores.length) {
			if (ganadores[i] == null) {
				ganadores[i] = ganador;
				i = ganadores.length;
			}i++;
		}

	}

}
