package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Evento {

	private String nombre;
	private LocalTime horaInicio;
	private LocalDate dia;
	private LocalTime horaFin;
	private List<ConciertoInstrumento> conciertosInstrumentos; // clase intermedia por n-n

	public Evento(String nombre, LocalDate dia, LocalTime horaInicio, LocalTime horaFin) {
		this.nombre = nombre;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;

		this.conciertosInstrumentos = new ArrayList<>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(dia, horaFin, horaInicio, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(dia, other.dia) && Objects.equals(horaFin, other.horaFin)
				&& Objects.equals(horaInicio, other.horaInicio) && Objects.equals(nombre, other.nombre);
	}

	public List<ConciertoInstrumento> getConciertosInstrumentos() {
		return conciertosInstrumentos;
	}

	public void setConciertosInstrumentos(List<ConciertoInstrumento> conciertosInstrumentos) {
		this.conciertosInstrumentos = conciertosInstrumentos;
	}

	public Boolean agregarConcierto(Concierto concierto) {
		// como no me pasaron los o el instrumento, el segundo parametro va en null,
		// para poder agergar

		ConciertoInstrumento consInstrumentoCreadoConLosParametrosQMeDan = new ConciertoInstrumento(concierto, null);

		return this.conciertosInstrumentos.add(consInstrumentoCreadoConLosParametrosQMeDan);

	}

	public Boolean agregarConciertoInstrumento(ConciertoInstrumento conciertoInstrumento) {

		return this.conciertosInstrumentos.add(conciertoInstrumento);

	}

}
