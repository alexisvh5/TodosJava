package ar.edu.unlam.dominio;

public class Cliente {

	private long cuil;
	private String dni;

	public Cliente(long cuil, String dni) {
		this.cuil = cuil;
		this.dni = dni;
	}

	public long getCuil() {
		return cuil;
	}

	public void setCuil(int cuil) {
		this.cuil = cuil;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Cliente [cuil=" + cuil + ", dni=" + dni + "]";
	}

}
