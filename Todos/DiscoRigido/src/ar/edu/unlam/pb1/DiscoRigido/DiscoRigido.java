package ar.edu.unlam.pb1.DiscoRigido;

public class DiscoRigido {
	
	double tamaño;

	public DiscoRigido(double tamaño) {
		
	this.tamaño = tamaño;
	}
	
	public int getCuantosDvd() {
		double cantidadDeEspacioDvd = 4.5;
		double cantidadDvd = this.tamaño / cantidadDeEspacioDvd;
		if(cantidadDvd %1 > 0){return (int)cantidadDvd + 1;}	
		return (int)cantidadDvd;
	}
	

	public int getCuantosBlueRay() {
		double cantidadDeEspacioBlue = 15.0;
		double cantidadBlue = this.tamaño / cantidadDeEspacioBlue;
		if(cantidadBlue %1 > 0){return (int)cantidadBlue + 1;}	
		return (int)cantidadBlue;
	}

}
