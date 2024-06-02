package ar.edu.unlam.dominio;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;


public class Concierto {
private String nombre;
	
	public Concierto(Integer id,String nombreConcierto) {
		this.nombre=nombreConcierto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Concierto other = (Concierto) obj;
		return Objects.equals(nombre, other.nombre);
	}



//construct
}
