package unlam.pb1.tp06Dominio;

public class Ascensor {

	// estado de los objetos:atributos

	private final int PISO_MINIMO;
	private final int PISO_MAXIMO;
	private final double PESO_MAXIMO;
	private final int CAPACIDAD_MAXIMA;
	
	private int pisoActual;
	private double pesoActual;
	private boolean puertaAbierta;
	private int personasIngresadas;
	
	 // constructorrrrrrr-------
	
	public Ascensor(int pisoMinimo, int pisoMaximo, double pesoMaximo, int capacidadMax) {
		this.CAPACIDAD_MAXIMA=capacidadMax;
		this.PISO_MAXIMO=pisoMaximo;
		this.PISO_MINIMO=pisoMinimo;
		this.puertaAbierta = true;
		this.PESO_MAXIMO = pesoMaximo;
		this.pesoActual = 0.0;
		this.pisoActual=PISO_MINIMO;
		this.personasIngresadas= 0;
	}
	 // metodos------------
	
	public void subir() {
		if (!puertaAbierta && pisoActual<PISO_MAXIMO) {
			pisoActual++;
		}
		
	}
	public void bajar() {
		if (!puertaAbierta && pisoActual>PISO_MAXIMO) {
			pisoActual--;
		}
	}
	
	public void irAlPiso(int pisoDeseado) {
		// es ideal el while. no el do while , porque no siempre voy a subir o bajr alguna vez
		
		while (!puertaAbierta && pisoDeseado <= PISO_MAXIMO && pisoActual<pisoDeseado) {
			this.subir();
		}
		while (!puertaAbierta && pisoDeseado >= PISO_MINIMO && pisoActual>pisoDeseado) {
			this.bajar();
		}
		
	}

	public int getPisoActual() {
		return pisoActual;
	}
	
	public void cerrarPuerta() {
		if (!sobreCarga()) {
			this.puertaAbierta=false;
		}
		
	}
	public void abrirPuerta() {
		this.puertaAbierta=true;
	}	
	
	public void ingresar(double peso) {
		if (puertaAbierta) {
			this.pesoActual+=peso;
			this.personasIngresadas++;
		}

	}
	public void salir(double peso) {
		if (puertaAbierta) {
			this.pesoActual-=peso;
			this.personasIngresadas--;
		}

	}
	 public boolean sobreCarga(){
		 if (pesoActual > PESO_MAXIMO || personasIngresadas > CAPACIDAD_MAXIMA) {
			return true;
		}else {
			return false;}
	 }	
}
