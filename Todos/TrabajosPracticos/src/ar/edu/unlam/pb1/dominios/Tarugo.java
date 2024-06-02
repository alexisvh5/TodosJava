package ar.edu.unlam.pb1.dominios;

public class Tarugo {
	private final int LONGITUD;
	
	public Tarugo(int longitud){
		this.LONGITUD = longitud;
	}

	public int getLONGITUD() {
		return LONGITUD;
	}

	@Override
	public String toString() {
		return "Tarugo [LONGITUD=" + LONGITUD + "]";
	}
	
}
