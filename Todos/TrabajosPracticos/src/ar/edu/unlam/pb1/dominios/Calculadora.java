package ar.edu.unlam.pb1.dominios;

public class Calculadora {
	
public Calculadora() {};	
	
public double potencia(double numeroBase, double numeroPotencia) {
	double resultado= numeroBase;
	
	if (numeroPotencia == 1 ) {
		resultado = numeroBase;
	}
	if (numeroPotencia ==  0) {
		resultado= 1;
	}
	if (numeroPotencia > 1) {
		for (int i = 0; i < numeroPotencia; i++) {
			resultado = (resultado* numeroBase);
		}
	}
	
	return resultado;
	
}

public double productoria(int limite) {
	double resultado = 1;
	for (int i = 1 ; i <=   limite ; i++) {
		resultado = resultado * i;
	}
	return resultado;
};

public double productoria(int limiteInferior, int limiteSuperior) {
	double resultado = 1;
	for (int i = limiteInferior ; i >= limiteInferior && i <=   limiteSuperior; i++) {
		resultado = resultado*i;
	}
	return resultado;
};


public String contarDivisores(int numero) {
	
	String sonDivisores = "Son divisores: ";
	for (int i = 1; i <= numero ; i++) {
		if (numero%i == 0) {
			
			sonDivisores = sonDivisores + i + " ";
			
		}
	}
	return sonDivisores;
}

public boolean esPrimo(int numero) {
	
	boolean esPrimo=true;
 
	for (int i = 1; i < numero; i++) {
		if (numero % i == 0 ) {
			esPrimo = false;
			break;
		}else{
			esPrimo = true;
		}
	}
	return esPrimo;
}

}
