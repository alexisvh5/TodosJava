package ar.edu.unlam.pb1.dominio;

public class Gimnasio {

	private Actividad[] actividades;
	private Cliente[] clientes;

	public Gimnasio(String nombre) {
		// TODO: se debe adminitar hasta 10000 clientes
		this.clientes = new Cliente[1000];
		this.actividades = new Actividad[20];
		this.agregarActividades(); // :O
	}

	public boolean iniciarSesion(int dni, String contrasenia) {
		// TODO: obtiene un cliente por su dni y, si existe, verifica que la contrasenia
		// sea la suministrada. Devuelve verdadero en caso de que las credenciales sean
		// validas.
		boolean inicio = false;
		Cliente clienteBuscado = buscarClientePorDni(dni);

		if (clienteBuscado != null && clienteBuscado.getContrasenia().equalsIgnoreCase(contrasenia)) {
			inicio = true;
		}

		return inicio;
	}

	public boolean registrarCliente(Cliente cliente) {
		// TODO: se debe registrar el cliente, agregandolo a los clientes del gimnasio,
		// solo en caso de que el dni del cliente suministrado no exista entre los
		// clientes actuales. Devuelve verdadero en caso de exito.
		boolean truea = false;
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] == null) {
				clientes[i] = cliente;
				return truea = true;
			}
		}

		return truea;
	}

	public Actividad buscarActividadPorId(int id) {
		// TODO: Buscar entre las actividades del gimnasio alguna que aplique con el id
		// suministrado y devolverla
		for (int i = 0; i < actividades.length; i++) {
			if (actividades[i] != null && actividades[i].getId() == id) {
				return actividades[i];
			}
		}
		return null;
	}

	public Cliente buscarClientePorDni(int dni) {
		// TODO: Revisa entre los clientes del gimnasio, si algun posee el dni indicado
		// y lo devuelve.

		Cliente clienteBuscado = null;
		int i = 0;

		while (i < clientes.length) {
			if (clientes[i] != null && clientes[i].getDni() == dni) {
				clienteBuscado = clientes[i];
				i = clientes.length;
			} else {
				i++;
			}
		}
		return clienteBuscado;

	}

	public boolean validarContrasenia(String contrasenia) {
		// TODO: Devuelve verdadero en caso de que la contrasenia contenga: 2 o mas
		// mayusculas, un largo minimo de 8 caracteres y, si tiene numeros y estan
		// juntos, no pueden
		// ser consecutivos. Ejemplo valido: PassWord77 - Ejemplos invalidos:
		// PassWord123 o PassWord234 o PassWord345
		// -> notar que los numeros consecutivos son: 1 y 2 o 2 y 3, etc.
		boolean contraseniaValida = false;
		int contadorDeMayus = 0;
		boolean numerosConsec = false;

		for (int i = 0; i < contrasenia.length(); i++) {
			if (Character.isUpperCase(contrasenia.charAt(i))) {
				contadorDeMayus++;
			}
			if (Character.isDigit(contrasenia.charAt(i)) && (i + 1) < contrasenia.length() // hace falta esta condicion?
					&& Character.isDigit(contrasenia.charAt(i + 1))) {

				int siguiente = contrasenia.charAt(i) + 1;

				numerosConsec = siguiente == (contrasenia.charAt(i + 1)); // condicion booleanda
			}

		}
		contraseniaValida = contadorDeMayus >= 2 && contrasenia.length() >= 8 && !numerosConsec; // todo esto es una
																									// condcion

		return contraseniaValida;
	}

	public Cliente obtenerElClienteQueMenosActividadesRealizo() {
		// TODO: devuelve el cliente que menos actividades realizo
		Cliente aux = null;
		Cliente clienteBuscado=null;

		for (int i = 0; i < clientes.length; i++) {
			for (int j = 0; j < clientes.length - 1; j++) {
				if (clientes[j] != null && clientes[j + 1] != null) {
					if (clientes[j].obtenerCantidadDeActividadesRealizadas() > clientes[j + 1]
							.obtenerCantidadDeActividadesRealizadas()) {
						aux = clientes[j];
						clientes[j] = clientes[j + 1];
						clientes[j + 1] = aux;
					}
				}
			}clienteBuscado=clientes[0];
		}

		return clienteBuscado;


	}

	public Actividad[] obtenerActividadesOrdenadasPorCaloriasQueQuemaDescendente() {
		// TODO: Ordenar las actividades de forma descendente por la cantidad de
		// calorias que se queman y devolverlas
		Actividad[] actOrdenadas = new Actividad[actividades.length];
		int a = 0;
		Actividad aux = null;
		for (int i = 0; i < actividades.length; i++) {
			for (int j = 0; j < actividades.length - 1 - i; j++) { // tambien puedo poner la otra manera -i
				if (actividades[j] != null && actividades[j + 1] != null) {
					if (actividades[j].getCaloriasQueQuema() < actividades[j + 1].getCaloriasQueQuema()) {
						aux = actividades[j];
						actividades[j] = actividades[j + 1];
						actividades[j + 1] = aux;
					}
				}
			}

		}

		for (int b = 0; b < actividades.length; b++) {
			actOrdenadas[a] = actividades[b];
			a++;

		}

		return actOrdenadas;
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
