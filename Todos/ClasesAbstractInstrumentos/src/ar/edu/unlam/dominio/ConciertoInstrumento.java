package ar.edu.unlam.dominio;

public class ConciertoInstrumento {
	
	private Concierto concierto;
	private Instrumento instrumento;
	
	public ConciertoInstrumento(Concierto concierto, Instrumento instrumento) {
		this.concierto=concierto;
		this.instrumento=instrumento;
	}

	public Object getConcierto() {
		// TODO Auto-generated method stub
		return this.concierto;
	}

	public void setInstrumento(Instrumento guitarraCriolla) {
this.instrumento=guitarraCriolla;		
	}

	public Instrumento getInstrumento() {
		// TODO Auto-generated method stub
		return this.instrumento;
	}
	
	

}
