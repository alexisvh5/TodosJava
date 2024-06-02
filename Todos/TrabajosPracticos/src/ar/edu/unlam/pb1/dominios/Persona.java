package ar.edu.unlam.pb1.dominios;

public class Persona {
//
//	private String nombre;
//	private String sexo;
//	private int dni;
	private double peso;
	private int edad;
	private double altura;

	public Persona(double peso, double altura, int edad) {
//		this.nombre=nombre;
//		this.sexo=sexo;
//		this.dni=dni;
		this.altura = altura;
		this.peso = peso;
		this.edad = edad;
	}

	// metodos para la clase persona

	public void alimentar(double cantidadDeAlimento) {
		this.peso += cantidadDeAlimento;
	}

	public TipoDePeso calcularTipoDePeso() {

		// imc 18,5 por abajo bajo
		// 24,9 normal
		// mas, sobrepso

		TipoDePeso resultado = null;
		double imc = this.peso / (this.altura * this.altura);
		final double BAJO_PESO = 18.5, 
				     PESO_NORMAL = 24.9;

		if (imc <= BAJO_PESO) {
			resultado = TipoDePeso.BAJO_PESO;
		} else if (imc > PESO_NORMAL) {
			resultado = TipoDePeso.SOBRE_PESO;
		} else {
			resultado = TipoDePeso.PESO_NORMAL;
		}

		return resultado;
	}
	public int getEdad() {
		return this.edad;
	}

}
