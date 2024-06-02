package ar.edu.unlam.pb1.dominio;

import java.util.Iterator;

public class Gimnasio {
	
	
private Cliente[]clientes;
	private Actividad[] actividades;

	public Gimnasio(String nombre) {
		// TODO: se debe adminitar hasta 10000 clientes /// agrego  ARRAY CLIENTE[]cleintes, y los instancioen [1000]
		this.actividades = new Actividad[20];
		this.agregarActividades(); // :O
	}

	public boolean iniciarSesion(int dni, String contrasenia) {
		// TODO: obtiene un cliente por su dni y, si existe, verifica que la contrasenia
		// sea la suministrada. Devuelve verdadero en caso de que las credenciales sean
		// validas.
		
		Cliente cliente =  this.buscarClientePorDni(dni);
		boolean inicioValido = false; // me garanntizo de devolver algo
		if(cliente != null && cliente.getContrasenia().equals(contrasenia)) // ENTONCES AGREGO ESTE MET EN CLIENTE
			inicioValido=true;
		return inicioValido;
	}

	public boolean registrarCliente(Cliente cliente) {
		// TODO: se debe registrar el cliente, agregandolo a los clientes del gimnasio,
		// solo en caso de que el dni del cliente suministrado no exista entre los
		// clientes actuales. Devuelve verdadero en caso de exito.
		return false;
	}

	public  Actividad buscarActividadPorId(int id) {
		// TODO: Buscar entre las actividades del gimnasio alguna que aplique con el id
		// suministrado y devolverla
		return null;
	}

	public  Cliente buscarClientePorDni(int dni) {
		// TODO: Revisa entre los clientes del gimnasio, si algun posee el dni indicado
		// y lo devuelve.
		return null;
	}

	public boolean validarContrasenia(String contrasenia) {
		// TODO: Devuelve verdadero en caso de que la contrasenia contenga: 2 o mas
		// mayusculas, un largo minimo de 8 caracteres (en un string se pide con length) y, si tiene numeros y estan
		// juntos, no pueden
		// ser consecutivos. Ejemplo valido: PassWord77 - Ejemplos invalidos:
		// PassWord123 o PassWord234 o PassWord345
		// -> notar que los numeros consecutivos son: 1 y 2 o 2 y 3, etc.
		
		
		boolean contraseniaValida= false;
		int contadorMayusculas = 0;
		char caracterActual = 'a'; //pongo cualquiera 
		boolean numerosConsecutivos = false;
		//PassWord77
		for (int i = 0; i < contrasenia.length(); i++) {
			
			caracterActual = contrasenia.charAt(i);
			
			if (Character.isUpperCase(caracterActual)) {
				contadorMayusculas ++;
			}
			if (Character.isDigit(caracterActual) && (i+1)< contrasenia.length() // fijarme si hay un siguiente..
					&&  Character.isDigit(contrasenia.charAt(i+1)) ) { //ahora que me interesa?
				
			int siguienteNumero =	(caracterActual+1) ; //8
			numerosConsecutivos = siguienteNumero == contrasenia.charAt(i+1);
			
			if (numerosConsecutivos) {
				break;
			}
			
				
			}
			
		}
		contraseniaValida = contadorMayusculas >= 2 && contrasenia.length() >= 8 && !numerosConsecutivos;

		return contraseniaValida;
	}

	public Cliente obtenerElClienteQueMenosActividadesRealizo() {
		// TODO: devuelve el cliente que menos actividades realizo ---PUEDO AGREGAR EL ATRIBUTO NOMBRE EN CLIENTE
		
		// uso un toString para que me salten los datos como DNI y NOMBRE
		
		
		Cliente clienteMenorActividadRealizo = null;
		
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] !=null && clienteMenorActividadRealizo == null) {
				clienteMenorActividadRealizo = clientes[i];
			}else if(clientes[i] != null && clientes[i].obtenerCantidadDeActividadesRealizadas() < clienteMenorActividadRealizo.obtenerCantidadDeActividadesRealizadas()) {}
			
			clienteMenorActividadRealizo =clientes[i];

		}	
		return clienteMenorActividadRealizo;
	}

	public Actividad[] obtenerActividadesOrdenadasPorCaloriasQueQuemaDescendente() {
		// TODO: Ordenar las actividades de forma descendente por la cantidad de
		// calorias que se queman y devolverlas
		
	
		
		///e este seria un medoto de ordenarActividadesPorCaloriaDescendente
		Actividad aux = null;

		for (int i = actividades.length -1; i > 0; i--) {

			for (int j = 0; j < i; j++) {
				if (actividades[j] != null && actividades[j + 1] != null) {
				
					if(actividades[j].getCaloriasQueQuema() > actividades[j+1].getCaloriasQueQuema()) {
					aux = actividades[j + 1];
					actividades[j + 1] = actividades[j];
					actividades[j] = aux;
				}
				}
					
					
		///				&& plantasOrdenadas[i].getTipoDePlanta().compareTo(tipoDePlanta) > 0) {
					
				}
			}
		// este seria el metodo que lo usa obtenerActividadesOrdenadasPorCaloriasQueQuemaDescendente
		
//	ordenarActividadesPorCaloriaDescendente();
//		return actividades
//		
		

	}
		

	private void agregarActividades() {
		String nombre = "";
		TipoActividad tipoActividad;
		int valor = this.actividades.length / TipoActividad.values().length;
		int duracion = 30;
		double calorias = 400;

		for (int i = 0; i < this.actividades.length; i++) {

			if (i < valor) {
				nombre = TipoActividad.AEROBICO.toString();
				tipoActividad = TipoActividad.AEROBICO;
			} else if (i < (valor * 2)) {
				nombre = TipoActividad.FUNCIONAL.toString();
				tipoActividad = TipoActividad.FUNCIONAL;
				duracion = 60;
				calorias = 281;
			} else {
				nombre = TipoActividad.PESAS.toString();
				tipoActividad = TipoActividad.PESAS;
				duracion = 20;
				calorias = 450;
			}

			nombre += " " + (i + 1);

			this.actividades[i] = new Actividad(nombre, duracion, calorias, tipoActividad);
		}

	}

}
