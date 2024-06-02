package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CasaDeMusica implements ICasaDeMusica {

	private String nombre;
	private List<Instrumento> instrumentos;
	private List<Evento> eventos;

	public CasaDeMusica(String nombre) {
		this.nombre = nombre;
		this.instrumentos = new ArrayList<>();
		this.eventos =new ArrayList<>();
	}

	// cuando pongo implements--
	@Override

	public Boolean agregarInstrumento(Instrumento instrumento) { // modifico gutarElectrica a instrumento

		return instrumentos.add(instrumento);
	}

	@Override
	public Instrumento buscar(Integer codigo) { /// buscarInstruPorCodigo

		Instrumento instuBuscado = null;

		for (Instrumento instrumento : this.instrumentos) {

			if (instrumento.getCodigo().equals(codigo)) {
				instuBuscado = instrumento;
				break;// -----------------------------------------------------
			}
		}
		return instuBuscado;
	}

	public List<Instrumento> obtenerInstrumentosGuitarraElectrica() {

		List<Instrumento> instrumentosGuitarrasElectrionicas = new ArrayList<>();

		for (Instrumento instrumento : instrumentos) {
			if (instrumento instanceof GuitarraElectrica) {
				instrumentosGuitarrasElectrionicas.add(instrumento);
			}
		}

		return instrumentosGuitarrasElectrionicas;
	}

	@Override
	public Double obtenerPrecioInstrumento(Integer codigo) {
	
		Instrumento instuBuscado = this.buscar(codigo);
		
		return instuBuscado.obtenerPrecio();
		
	}

	@Override
	public Boolean agregarEvento(Evento evento) { //selo agrego a la casa interfaz
		
		return this.eventos.add(evento);
	}

	public Boolean agregarConciertoAUnEvento(Evento evento, Concierto concierto) {

		for (Evento eventoEncontrado : this.eventos) {
			if (eventoEncontrado.equals(evento)) { /// para que esto funque se sobrescribe el EQUALS
				eventoEncontrado.agregarConcierto(concierto);
				return true;
			}
		}
		return false;
		
	}

	public Boolean asignarInstrumentoAConciertoDeEvento(Evento evento, Concierto concierto,
			Instrumento guitarraCriolla) {

		for (Evento eventoEncontrado : eventos) {
			if (eventoEncontrado.equals(evento)) {
				for (ConciertoInstrumento ci: eventoEncontrado.getConciertosInstrumentos()) {
					if (ci.getConcierto().equals(concierto)) { /// entonces concierto hascode de equals
						ci.setInstrumento(guitarraCriolla);
						return true;
					}
				}
			}
		}
		
		return false;
	}

	@Override
	public Boolean agregarInstrumentoAConciertoDeEvento(Evento evento, Concierto concierto,
			Instrumento guitarraElectrica) {

		for (Evento eventoEncontrado : eventos) {
			if (eventoEncontrado.equals(evento)) {
				
				eventoEncontrado.agregarConciertoInstrumento(new ConciertoInstrumento(concierto, guitarraElectrica)); /// para que agregue los dos
				return true;
			}
		}
		
		return false;
		
	}

	public List<Instrumento> obtenerInstrumentos() {

Collections.sort(instrumentos, (o1,o2)->o1.getCodigo().compareTo(o2.getCodigo()));
		
		return this.instrumentos;
	}

	public List<Instrumento> obtenerLosInstrumentosDeUnConciertoParaUnEvento(Evento evento1, Concierto concierto) {

		List<Instrumento> instrumentosDelConcierto = new ArrayList<>();
		

		for (Evento eventoEncontrado : eventos) {
			if (eventoEncontrado.equals(evento1)) {
				
			for (ConciertoInstrumento ci : eventoEncontrado.getConciertosInstrumentos() ) {
				if (ci.getConcierto().equals(concierto)) {
				
					instrumentosDelConcierto.add(ci.getInstrumento());
					
				}
			}
			}
		}
		
		return instrumentosDelConcierto;
	}

	@Override
	public List<Instrumento> obtenerLosInstrumentosDeUnConciertoParaUnEvento(Evento evento1, Concierto concierto,
			Instrumento guitarraElectrica) {
		// TODO Auto-generated method stub
		return null;
	}



}
