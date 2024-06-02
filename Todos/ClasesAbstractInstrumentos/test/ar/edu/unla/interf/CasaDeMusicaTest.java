package ar.edu.unla.interf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.dominio.Bateria;
import ar.edu.unlam.dominio.CasaDeMusica;
import ar.edu.unlam.dominio.Concierto;
import ar.edu.unlam.dominio.Evento;
import ar.edu.unlam.dominio.GuitarraElectrica;
import ar.edu.unlam.dominio.Instrumento;

public class CasaDeMusicaTest {
	private static final String NOMBRE_CASA_MUSICAL="CasaMusical";
	private CasaDeMusica casaDeMusica;
	
	@Before
	
	public void init() {
		
		this.casaDeMusica= new CasaDeMusica(NOMBRE_CASA_MUSICAL);
	}

	@Test
	public void queSePuedaAgregarUnInstrumentoGuitarraElectricaALaCasaDeMusica() {
		
		//interfaz para instrumentos de cuerdas
		
		
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001,6,"Azul","Estratocaser","Fender",10,true,1994,1000D);
		
		//ejecucuin
		Boolean  instrumentoAgregado= casaDeMusica.agregarInstrumento(guitarraElectrica);
		
		//verificacion
		assertTrue(instrumentoAgregado);
	}

	@Test
	public void queSePuedaAgregarUnInstrumentoBateriaALaCasaDeMusica() {
		
		//interfaz para instrumentos de cuerdas
		
		
		Instrumento bateria  =this.crearBateria(2001,1,4,"Dorada","Jazz","UnModelo",2000,20,2000D);
	
		//ejecucuin
		Boolean  instrumentoAgregado= casaDeMusica.agregarInstrumento(bateria);
		
		//verificacion
		assertTrue(instrumentoAgregado);
	}

	@Test
	public void dadoQueExistenInstrumentosEnLaCasaDeMusicaAlBuscarGuitarrasElectricasObtengoLoPropio() {
		
	Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001,6,"Azul","Estratocaser","Fender",10,true,1994,1000D);
	Instrumento segundaGuitarraElectrica = this.crearGuitarraElectrica(1002,6,"Azul","Estratocaser","Fender",10,true,1994,1000D);
	Instrumento bateria  =this.crearBateria(2001,1,4,"Dorada","Jazz","UnModelo",2000,20,2000D);
	Instrumento segundaBateria  =this.crearBateria(2002,1,4,"Dorada","Jazz","UnModelo",2000,20,2000D); 
	
	casaDeMusica.agregarInstrumento(bateria);
	casaDeMusica.agregarInstrumento(segundaBateria);
	casaDeMusica.agregarInstrumento(guitarraElectrica);
	casaDeMusica.agregarInstrumento(segundaGuitarraElectrica);
	
	
	 // lista filtrada

	List<Instrumento>instrumentosGuitarraElectrica=this.casaDeMusica.obtenerInstrumentosGuitarraElectrica() ; // metodo especifico=> no iria como interface
	
int cantidadEsperadaDeInstrumentos=2;
	
	assertEquals(cantidadEsperadaDeInstrumentos,instrumentosGuitarraElectrica.size());
	
	
	}
	
	@Test
	public void dadoQueExistenInstrumentosEnLaCasaDeMusicaPuedeEmitirSonido() {
		Instrumento bateria  =this.crearBateria(2001,1,4,"Dorada","Jazz","UnModelo",2000,20,2000D);
		
		String sonido= bateria.emitirSonido();
		String sonidoEsperado= "trutiss";
		
		assertEquals(sonidoEsperado,sonido);
	}	
	
	
	
	
	@Test
	public void dadoQueExistenInstrumentosEnLaCasaDeMusicaAlBuscarUnInstrumentoPorCodigoObtengoElInstrumento() {
		
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001,6,"Azul","Estratocaser","Fender",10,true,1994,1000D);
		Instrumento segundaGuitarraElectrica = this.crearGuitarraElectrica(1002,6,"Azul","Estratocaser","Fender",10,true,1994,1000D);
		Instrumento bateria  =this.crearBateria(2001,1,4,"Dorada","Jazz","UnModelo",2000,20,2000D);
		Instrumento segundaBateria  =this.crearBateria(2002,1,4,"Dorada","Jazz","UnModelo",2000,20,2000D); 
		
		casaDeMusica.agregarInstrumento(bateria);
		casaDeMusica.agregarInstrumento(segundaBateria);
		casaDeMusica.agregarInstrumento(guitarraElectrica);
		casaDeMusica.agregarInstrumento(segundaGuitarraElectrica);
		
		
		Instrumento instrumentoEncontrado= casaDeMusica.buscar(2001);
		
		int codigobuscado=2001;
		
//		assertNotNull(instrumentoEncontrado); //pero no aclara que sea el que quiero
		assertEquals(codigobuscado,(int)instrumentoEncontrado.getCodigo());

	}
	
	@Test
	public void dadoQueExistenInstrumentosEnLaCasaDeMusicaAlBuscarUnInstrumentoPorCodigoInexistenteObtengoNull() {
		
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001,6,"Azul","Estratocaser","Fender",10,true,1994,2000D);
		Instrumento segundaGuitarraElectrica = this.crearGuitarraElectrica(1002,6,"Azul","Estratocaser","Fender",10,true,1994,2000D);
		Instrumento bateria  =this.crearBateria(2001,1,4,"Dorada","Jazz","UnModelo",2000,20,1000D);
		Instrumento segundaBateria  =this.crearBateria(2002,1,4,"Dorada","Jazz","UnModelo",2000,20,1000D); 
		
		casaDeMusica.agregarInstrumento(bateria);
		casaDeMusica.agregarInstrumento(segundaBateria);
		casaDeMusica.agregarInstrumento(guitarraElectrica);
		casaDeMusica.agregarInstrumento(segundaGuitarraElectrica);
		
		
		Instrumento instrumentoEncontrado= casaDeMusica.buscar(2001);
		
//		int codigobuscado=2001;
		
		assertNotNull(instrumentoEncontrado); //ahora si tiene esta opcon como principal-- si existe un if.. existe un test para este..	directamente no entra a la funcion
//		assertEquals(codigobuscado,(int)instrumentoEncontrado.getCodigo());

	}
	

	
	@Test
	public void dadoQueExisteUnInstrumentoGuitarraElectricaEnLaCasaDeMusicaSePuedeObtenerElPrecio() {
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001,6,"Azul","Estratocaser","Fender",10,true,1994,1000D);

		this.casaDeMusica.agregarInstrumento(guitarraElectrica);
		
		Double precioObtenido = this.casaDeMusica.obtenerPrecioInstrumento(1001); // se lo pusieron en instrumento, entonces va  adar el precio de cada uno

		Double precioEsperado =1100D; /// equivale a l 10%
				assertEquals(precioEsperado,precioObtenido);
	}
	
	
	public void dadoQueExisteUnInstrumentoBateriaElectricaEnLaCasaDeMusicaSePuedeObtenerElPrecio() {
		Instrumento bateria  =this.crearBateria(2001,1,4,"Dorada","Jazz","UnModelo",2000,20,1000D);

		this.casaDeMusica.agregarInstrumento(bateria);
		
		Double precioObtenido = this.casaDeMusica.obtenerPrecioInstrumento(2001); // se lo pusieron en instrumento, entonces va  adar el precio de cada uno

		//o consultar directo a instrumento bateria.getPrecio---estp seria espcificado en el nombre del test
		
		Double precioEsperado =3300D; /// equivale a l 10%
				assertEquals(precioEsperado,precioObtenido);
	}
	
	@Test
	
	public void dadoQueExisteInstrumentosEnLaCasaDeMusicaAlObtenerlosEstanOrdenados() {

		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001,6,"Azul","Estratocaser","Fender",10,true,1994,2000D);
		Instrumento segundaGuitarraElectrica = this.crearGuitarraElectrica(1002,6,"Azul","Estratocaser","Fender",10,true,1994,2000D);
		Instrumento bateria  =this.crearBateria(2001,1,4,"Dorada","Jazz","UnModelo",2000,20,1000D);
		Instrumento segundaBateria  =this.crearBateria(2002,1,4,"Dorada","Jazz","UnModelo",2000,20,1000D); 
		
		casaDeMusica.agregarInstrumento(bateria);
		casaDeMusica.agregarInstrumento(segundaBateria);
		casaDeMusica.agregarInstrumento(guitarraElectrica);
		casaDeMusica.agregarInstrumento(segundaGuitarraElectrica);
		
		List<Instrumento> instrumentosObtenidos= this.casaDeMusica.obtenerInstrumentos();
		
		assertEquals(1001, (int)instrumentosObtenidos.get(0).getCodigo());
		assertEquals(1002,(int)instrumentosObtenidos.get(1).getCodigo());
	}
	
	
	@Test
	public void dadoQueExisteUnInstrumentoGuitarraElectricaEnLaCasaDeMusicaAlObtenerloPorCodigoSePuedeObtenerElPrecio() { //HICE DE GUITARRA PERO DESDE LA CASA DE MUSICA-  CON INTERFACE
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001,6,"Azul","Estratocaser","Fender",10,true,1994,1000D);
		
		this.casaDeMusica.agregarInstrumento(guitarraElectrica);
		
		Double precioObtenido = this.casaDeMusica.obtenerPrecioInstrumento(1001); // se lo pusieron en instrumento, entonces va  adar el precio de cada uno
		
		Double precioEsperado =1100D; //equivale al 10%
				assertEquals(precioEsperado,precioObtenido);
	}
	
	@Test
	
	public void dadoQueExisteUnaCasaDeMusicaPuedeAgregarrUnEvento() {
		// Given-When-Then
		String nombre ="Lolla";
		LocalDate dia = LocalDate.of(2024,05,15);
		LocalTime horaInicio= LocalTime.of(21, 0);
		LocalTime horaFin = LocalTime.of(23, 0);
		
		Evento evento= new Evento(nombre, dia,horaInicio,horaFin);
		
		Boolean agregado = this.casaDeMusica.agregarEvento(evento);
		assertTrue(agregado);
	}
	
	@Test
	
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoSePuedeAgregarVariosConciertos() {
		// Given-When-Then
		String nombre ="Lolla";
		LocalDate dia = LocalDate.of(2024,05,15);
		LocalTime horaInicio= LocalTime.of(21, 0);
		LocalTime horaFin = LocalTime.of(23, 0);
		
		Evento evento= new Evento(nombre, dia,horaInicio,horaFin);
		
		this.casaDeMusica.agregarEvento(evento);
		
		String nombreConcierto = "RHCP";
		Integer idConcierto = 1;
		Concierto concierto = new Concierto(idConcierto,nombreConcierto);
		Concierto conciertoDos = new Concierto(idConcierto,"Artic");
		Concierto conciertoTres = new Concierto(idConcierto,"Link");
		
		Boolean agregadoUno = this.casaDeMusica.agregarConciertoAUnEvento(evento,concierto);
		Boolean agregadoDos=this.casaDeMusica.agregarConciertoAUnEvento(evento,conciertoDos);
		Boolean agregadoTres =this.casaDeMusica.agregarConciertoAUnEvento(evento,conciertoTres);
		
		assertTrue(agregadoUno);
		assertTrue(agregadoDos);
		assertTrue(agregadoTres);
	}
	
@Test
	
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoYUnConciertoSePuedeAsignarUnInstrumentoAUnConcierto() {
	
	String nombre ="Lolla";
	LocalDate dia = LocalDate.of(2024,05,15);
	LocalTime horaInicio= LocalTime.of(21, 0);
	LocalTime horaFin = LocalTime.of(23, 0);
	
	Evento evento= new Evento(nombre, dia,horaInicio,horaFin);
	
	this.casaDeMusica.agregarEvento(evento);
	
	String nombreConcierto = "RHCP";
	Integer idConcierto = 1;
	Concierto concierto = new Concierto(idConcierto,nombreConcierto);

	this.casaDeMusica.agregarConciertoAUnEvento(evento,concierto);
	
	Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001,6,"Azul","Estratocaser","Fender",10,true,1994,1000D);
	Instrumento guitarraCriolla = this.crearGuitarraElectrica(1002,6,"violeta","vanderbar","Fender",10,true,1994,1000D);

	Boolean electricaAgregada=this.casaDeMusica.asignarInstrumentoAConciertoDeEvento(evento, concierto,guitarraElectrica);
	Boolean criollaAgregada=this.casaDeMusica.asignarInstrumentoAConciertoDeEvento(evento, concierto,guitarraCriolla);
	assertTrue(electricaAgregada);
	assertTrue(criollaAgregada);

}

@Test

public void dadoQueExisteUnaCasaDeMusicaConUnEventoYUnConciertoSePuedeAgregarVariosInstrumentosAUnConcierto() {

String nombre ="Lolla";
LocalDate dia = LocalDate.of(2024,05,15);
LocalTime horaInicio= LocalTime.of(21, 0);
LocalTime horaFin = LocalTime.of(23, 0);

Evento evento1= new Evento(nombre, dia,horaInicio,horaFin);

this.casaDeMusica.agregarEvento(evento1);

String nombreConcierto = "RHCP";
Integer idConcierto = 1;
Concierto concierto = new Concierto(idConcierto,nombreConcierto);

this.casaDeMusica.agregarConciertoAUnEvento(evento1,concierto);

Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001,6,"Azul","Estratocaser","Fender",10,true,1994,1000D);
Instrumento guitarraCriolla = this.crearGuitarraElectrica(1002,6,"celes","openhaimer","Fender",10,true,1994,1000D);

Boolean electricaAgregada=this.casaDeMusica.agregarInstrumentoAConciertoDeEvento(evento1, concierto,guitarraElectrica);
Boolean criollaAgregada=this.casaDeMusica.agregarInstrumentoAConciertoDeEvento(evento1, concierto,guitarraCriolla);
// seria agregarConciertoInstrumentoAEvento

assertTrue(electricaAgregada);
assertTrue(criollaAgregada);

}

@Test

public void dadoQueExisteUnaCasaDeMusicaConUnEventoYvariosConciertosSePuedenObtenerLosInstrumentosDeUnConcierto() {
	
	String nombre ="Lolla";
	LocalDate dia = LocalDate.of(2024,05,15);
	LocalTime horaInicio= LocalTime.of(21, 0);
	LocalTime horaFin = LocalTime.of(23, 0);
	Evento evento= new Evento(nombre, dia,horaInicio,horaFin);
	this.casaDeMusica.agregarEvento(evento);

	String nombreConcierto = "RHCP";
	Integer idConcierto = 1;
	Concierto concierto = new Concierto(idConcierto,nombreConcierto);
	
	Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001,6,"Azul","Estratocaser","Fender",10,true,1994,1000D);
	Instrumento guitarraCriolla = this.crearGuitarraElectrica(1002,6,"celes","openhaimer","Fender",10,true,1994,1000D);
	this.casaDeMusica.agregarInstrumentoAConciertoDeEvento(evento,concierto,guitarraElectrica);
	this.casaDeMusica.agregarInstrumentoAConciertoDeEvento(evento,concierto,guitarraCriolla);
	
	
	Concierto concierto2 = new Concierto(2,"Linkin");
	Instrumento bateria  =this.crearBateria(2001,1,4,"Dorada","Jazz","UnModelo",2000,20,1000D);
	this.casaDeMusica.agregarInstrumentoAConciertoDeEvento(evento,concierto2,bateria);

	
List<Instrumento>instrumentos= this.casaDeMusica.obtenerLosInstrumentosDeUnConciertoParaUnEvento(evento, concierto);

assertEquals(2, instrumentos.size());
}


///----------------------------tareaaaaaaaaaaaaaaaaaaaaaa

public void dadoQueExisteUnaCasaConUnEventoyVariosConciertosConInstrumentosSePuedenObetenerLosConciertosDondeSeUltilizoUnInstrumento() {}
public void dadoQueExisteUnaCasaConUnEventoyVariosConciertosConInstrumentosNoSePuedeAgregarUnInstrumentoExisteParaEseConcierto() {}
public void dadoQueExisteUnaCasaConMuchosEventosYVariosConciertosEnCadaEventoSePuedenObtenerLosEventosDondeSeDioUnConcierto() {}
public void dadoQueExisteUnaCasaConMuchosEventosYVariosConciertosConInstrumentosSePuedenObtenerLosConciertosDondeSeUtilizoUnInstrumentoGuitarra() {}
	
	//--------------------------------------------------------------------------------------

	private Instrumento crearBateria(Integer codigo, Integer cantidadTambores, int cantidadPlatillos, String color, String marca, String modelo, Integer anioFabricacion, Integer stock, Double precioBase) {
		
		return new Bateria(codigo, cantidadTambores, cantidadPlatillos,  color,  marca,  modelo, anioFabricacion, stock,precioBase);
	}

	private Instrumento crearGuitarraElectrica(
	Integer codigo,
	Integer cantidadDeCuerdas,
	String color,
	String marca ,
	String modelo ,
	Integer anioFabricacion ,
	Boolean microfonosActivos,
	Integer stock,
	Double precioBase) {
		
	return new GuitarraElectrica(codigo,cantidadDeCuerdas,microfonosActivos,stock,color,marca,modelo,anioFabricacion,precioBase);
		
	};
}
