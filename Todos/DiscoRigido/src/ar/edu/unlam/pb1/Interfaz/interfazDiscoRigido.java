package ar.edu.unlam.pb1.Interfaz;

import ar.edu.unlam.pb1.DiscoRigido.DiscoRigido;

public class interfazDiscoRigido {

	public static void main(String[] args) {

		DiscoRigido disco1;// = new DiscoRigido(1234.50);
		
		disco1 = new DiscoRigido(1234.50);
		
		System.out.println("la cantidad de dvds q podria llenar este discoRigido es de "+ disco1.getCuantosDvd() + ""
				+ "DVDS");
		
		System.out.println("la cantidad de BlueRAYS q podria llenar este discoRigido es de "+ disco1.getCuantosBlueRay()
				+ " BlUES");
	}

}
