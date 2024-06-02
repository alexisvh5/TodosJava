package ar.edu.unlam.registroPersona;

import static org.junit.Assert.*;

import org.junit.Test;

public class testUniversidad {

	
	/*notation*/
	@Test
	public void queSePuedaRegistrarUnNuevoAlumno() {
//		fail("Not yet implemented");/* asi es como se presenta el metodo al crear el test*/
		
		//-------------------------------------------- PREPARACION de datos o ingreso de datos--que datos necesito?
		/*
		 * nombre 
		 * epellido
		 * dni email
		 * */
		//---esto va a ser "unAlumno"
		
		String nombre = "Sol";
		String apellido = "Arias";
        Integer dni =  400000;
		String email = "solArias@unlam.edu.ar";
		
		Alumno alumno = new Alumno(nombre, apellido, dni, email);
		
		//¿DONDE LO REGISTROOOOOO?
		String nombreUniversidad ="unlamm";
		Universidad  unlam= new Universidad(nombreUniversidad);
		
		
		// ------------------------------------------EJECUCION 
		/*
		 * unlam.rregistrar(registratr)*/
		Boolean registroExitoso =  unlam.registrar(alumno);
		
	   //--------------------------------------------VERIFICACION ver si se encuentra en la bd o del array
		
		/*VARIAS FORMAS DE VERIFFICAr
		 * 
		 * traigo --unAlumnoEncontrado = unlam.buscarAlumno(dni)
		 * 
		 * unAlumnoEncontrado != null;
		 * 
		 * otra forma -- unAlumnoEncontrado.getDni == dni;
		 * 
		 * */
		
		assertTrue(registroExitoso); 
		 // otra manera de probar
		
		Integer valorEsperado = 1; // ahora mismo estoy registrarno uno solo --entonces
		Integer valorObtenido = unlam.obtenerCantidadDeAlumnos();
		
		assertEquals(valorEsperado, valorObtenido);
		
		//Alumno unAlumnoEncontrado = unlam.buscarAlumno(dni);
		
	
	}

	@Test
	public void otroTest() {
		
	}
	@Test
	public void queNoSePuedaRegistrarDosAlumnosConElMismoDni() {
		//ppreparacion
		
		String nombre = "Sol";
		String apellido = "Arias";
        Integer dni =  400000;
		String email = "solArias@unlam.edu.ar";
		
		Alumno alumno = new Alumno(nombre, apellido, dni, email);
		String nombreUniversidad ="unlamm";
		Universidad  unlam= new Universidad(nombreUniversidad);
		
		// ejecucion

		Boolean registro1= unlam.registrar(alumno) ;	
		Boolean registro2= unlam.registrar(alumno) ;	

		assertTrue(registro1);
		//verificacion
		
		assertFalse(registro2);		//-------este seria la verificacion de la verificacion
	
		
	}
	
/*
	public void queNoSePuedaRegistrarDosAlumnosConElMismoDni() {
		//ppreparacion
		
		String nombre = "Sol";
		String apellido = "Arias";
        Integer dni =  400000;
		String email = "solArias@unlam.edu.ar";
		
		Alumno alumno = new Alumno(nombre, apellido, dni, email);
		Alumno alumno2 = new Alumno(nombre, apellido, dni, email);
		String nombreUniversidad ="unlamm";
		Universidad  unlam= new Universidad(nombreUniversidad);
		
		// ejecucion

		Boolean registro1= unlam.registrar(alumno) ;	
		Boolean registro2= unlam.registrar(alumno) ;	
		//verificacion
		
		assertTrue(registro1);
		assertFalse(registro2);		
	
		
	}
*/	
	
}
