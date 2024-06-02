package ar.edu.unlam.pb1.dominio;

public class Transaccion {
	private static int id = 0;
	private TipoTransaccion tipoTransaccion;
	private  double cantidad;
	private  double monto;

	public Transaccion(TipoTransaccion tipoTransaccion, double cantidad, double monto) {
		obtenerSiguienteId();
		this.tipoTransaccion =  tipoTransaccion;
		this.cantidad = cantidad;
		this.monto = monto;
	}

	private static int obtenerSiguienteId() {
		// Devuelve el siguiente id consecutivo al anterior
		id++;
		return id;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Transaccion.id = id;
	}

	public TipoTransaccion getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
	
}
