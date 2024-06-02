package ar.edu.unlam.registroPersona;

import java.util.ArrayList;

public class Universidad {
	
	// otro tipo de arrays pero que lo maneja java
	
	ArrayList <Alumno> alumnos = new ArrayList<>(); ////////////

	public Universidad(String nombreUniversidad) {
		// TODO Auto-generated constructor stub
	}

	public Boolean registrar(Alumno alumno) {
		// TODO Auto-generated method stub
		
		if (!queNoSePuedaRegistrarDosAlumnosConElMismoDni(alumno)) {
			return alumnos.add(alumno);
		}
		return false;
	
		
		//return true;
	}

	public Integer obtenerCantidadDeAlumnos() {
		// TODO Auto-generated method stub
		//return 1; // pongo el valor yo cpara ver si se puede nomas, pero tenogo que hacer la logica ---pondora metodos directos del arraylist... ej. alumnos.size()
	return alumnos.size();
	
	// por ejemplo si repito un alumnos.add(alumno); entonce el size es 2;
	}

	public Boolean queNoSePuedaRegistrarDosAlumnosConElMismoDni(Alumno alumno) {
		Boolean verificarDni=false;
		// TODO Auto-generated method stub
		for (Integer i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getDni().equals(alumno.getDni())) {
				return true;
			}
		}
		
		return verificarDni;
	}

}
