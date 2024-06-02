package ar.edu.unlam.pb1.dominios;

public class Alarma {
	
	private boolean sensorDeSonido;
	private boolean sensorDeMovimiento;
	private boolean sensorDeTemperatura;
	
	private boolean encendida;
	private int codigo;

	public Alarma(int codigo) {
		this.codigo=codigo;
		this.sensorDeSonido=false;
		this.sensorDeMovimiento=false;
		this.encendida=false;
		this.sensorDeTemperatura=false;
	}

	public boolean isSensorDeSonido() {
		return sensorDeSonido;
	}

	public void setSensorDeSonido(boolean sensorDeSonido) {
		this.sensorDeSonido = sensorDeSonido;
	}

	public boolean isSensorDeMovimiento() {
		return sensorDeMovimiento;
	}

	public void setSensorDeMovimiento(boolean sensorDeMovimiento) {
		this.sensorDeMovimiento = sensorDeMovimiento;
	}

	public boolean isSensorDeTemperatura() {
		return sensorDeTemperatura;
	}

	public void setSensorDeTemperatura(boolean sensorDeTemperatura) {
		this.sensorDeTemperatura = sensorDeTemperatura;
	}

	public boolean isEncendida() {
		return encendida;
	}

	public void setEncendida(boolean encendida) {
		this.encendida = encendida;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public boolean estaSonando() {
		boolean ruido =false;
		
		if (encendida==true && (this.sensorDeMovimiento==true||this.sensorDeSonido==true||this.sensorDeTemperatura==true)) {
			ruido = true;
		}
		return ruido;
	}
	
	public void power(int codigo) {
//		if(this.encendida) {
//			this.encendida=false;
//		}else {this.encendida=true;}
		
		this.encendida=!this.encendida;
	}
}
