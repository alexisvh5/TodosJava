package ar.edu.unlam.dominio;

import java.util.List;

public interface ICasaDeMusica {
 Boolean agregarInstrumento(Instrumento instrumento) ;// no una guitarra electrica, xq puede entrartcualquier cosa
 Instrumento buscar(Integer Codigo);
Double obtenerPrecioInstrumento(Integer codigo);


Boolean agregarEvento(Evento evento);
Boolean agregarConciertoAUnEvento(Evento evento, Concierto concierto);
Boolean asignarInstrumentoAConciertoDeEvento(Evento evento, Concierto concierto,
		Instrumento guitarraCriolla);
Boolean agregarInstrumentoAConciertoDeEvento(Evento evento, Concierto concierto,
		Instrumento guitarraElectrica);

List<Instrumento> obtenerLosInstrumentosDeUnConciertoParaUnEvento(Evento evento1, Concierto concierto,
		Instrumento guitarraElectrica);
}
