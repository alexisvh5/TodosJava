package ar.edu.unlam.pb1.dominios;

public class Tragamonedas {
	
	private Tambor tambor1;
	private Tambor tambor2;
	private Tambor tambor3;
	
	
	// como no esta dentro de los parametros, quiere decir que estos obbjetos "viven" dentro de esta clase
	// fuera del tragamonedas estos objetos no existes
	// por ende se tiene que instanciar en el constructor, sino no los puedo usar
	public Tragamonedas() {
		tambor1= new Tambor();
		tambor2= new Tambor();
		tambor3= new Tambor();
		
	};
public boolean gano() {
	if (tambor1.getPosicion() == tambor2.getPosicion() && tambor1.getPosicion() == tambor3.getPosicion()) {
		return true;
	}else {return false;}
};

public void jugar() {
	tambor1.girar();
	tambor2.girar();
	tambor3.girar();
}
public Tambor getTambor1() {
	return tambor1;
}
public Tambor getTambor2() {
	return tambor2;
}
public Tambor getTambor3() {
	return tambor3;
};

}
