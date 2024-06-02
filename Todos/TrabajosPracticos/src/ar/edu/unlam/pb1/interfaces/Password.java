package ar.edu.unlam.pb1.interfaces;

public class Password {
private int longitud;
private String contrasenia;

public Password() {
	this.longitud = 8;
	this.contrasenia =generarPassword();
}

public Password(int longitud) {
	this.longitud=longitud;
	this.contrasenia=generarPassword();
}

public String getContrasenia() {
	return this.contrasenia;
};


public String generarPassword() {
	String contaseniaGenerada = "";
	char caracterAleatorio='\0';
	
	int contadorMayuscula=0, contadorMinuscula=0, contadorNumeros =0;
	
	for (int i = 0; i < this.longitud; i++) {
		boolean esCaracterValido = false;
		
		while (!esCaracterValido) {
			caracterAleatorio = (char)((Math.random()*93)+33); // va dentro xq asi se auto genera infinitamente hasta que salga, cumple la condicion en cada iteracion(5)
			
			if (caracterAleatorio >=48 && caracterAleatorio <=57 && contadorNumeros<5 ) {
				contadorNumeros++;
				esCaracterValido =true;
			}else if (caracterAleatorio >=65 && caracterAleatorio <=90 && contadorMayuscula<5 ) {
				contadorMayuscula++;
				esCaracterValido = true;
			}else if (caracterAleatorio >=97 && caracterAleatorio <=122 && contadorMinuscula<1 ) {
				contadorMinuscula++;
				esCaracterValido=true;
			}
			
		}
		
		contaseniaGenerada += caracterAleatorio;
		
	}
	
	return contaseniaGenerada;
}

public boolean esFuerte() { // no se si esta bien

boolean esFuerte = false;

int contadorMayuscula = 0;
int contadorMinuscula =0;
int contadorNumeros=0;

char caracterEvaluado ='\0';

for (int i = 0; i < contrasenia.length(); i++)
{
	caracterEvaluado = this.contrasenia.charAt(i);
	if (caracterEvaluado >=48 && caracterEvaluado <=57 && contadorNumeros<5 ) {
		contadorNumeros++;
		
	}else if (caracterEvaluado >=65 && caracterEvaluado <=90 && contadorMayuscula<2 ) {
		contadorMayuscula++;
		
	}else if (caracterEvaluado >=97 && caracterEvaluado <=122 && contadorMinuscula<1 ) {
		contadorMinuscula++;
		
	}
}

if (contadorMayuscula>2 && contadorMinuscula>1 && contadorNumeros>5) {
	esFuerte = true;
}

	return esFuerte;
}
	
}
