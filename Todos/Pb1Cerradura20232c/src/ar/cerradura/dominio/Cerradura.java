package ar.cerradura.dominio;

public class Cerradura {
	
	private int clave;
	private boolean estaAbierta;
	private int cantidadIntentosFallidosConsecutivos;
	private int CuantosIntentosQuedan;
	private boolean estaBloqueada;
	
	public  Cerradura(int clave) {
		this.clave = clave;
		this.estaAbierta = false;
	this.CuantosIntentosQuedan = 3;
	this.estaBloqueada =false;
	}

	public boolean abrir(int claveDeApertura) {

		if(clave == claveDeApertura && this.estaBloqueada == false) {
			this.estaAbierta = true;
			this.cantidadIntentosFallidosConsecutivos =0;
		}else {
			this.cantidadIntentosFallidosConsecutivos ++;
		}
		
		if(cantidadIntentosFallidosConsecutivos == this.CuantosIntentosQuedan)
		{this.estaBloqueada = true;}
		
		
		return estaAbierta;
	}

	public void cerrar() {
	this.estaAbierta=false;
	}

	public boolean isEstaAbierta() {
		return estaAbierta;
	}



	public int cuantosIntentosQuedan() {
		
	return this.CuantosIntentosQuedan;
	}

	public int cuantosIntentosRestantes() {
		return this.CuantosIntentosQuedan - this.cantidadIntentosFallidosConsecutivos;
	}

	public boolean estaBloqueda() {
	if(CuantosIntentosQuedan - cantidadIntentosFallidosConsecutivos == 0) {
		return true;
	}
		return false;
	}

	public boolean cambiarClave(int claveNueva, int claveActual, int repetidaClaveNueva) {
		
		if(this.clave !=claveActual) 
			return false;
		
		if (claveNueva != repetidaClaveNueva)
			return false;
		
		this.clave = claveNueva;
		return true;
	}


	

}
