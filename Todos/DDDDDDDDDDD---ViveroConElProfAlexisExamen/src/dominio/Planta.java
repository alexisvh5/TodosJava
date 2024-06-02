package dominio;



/*
 * Modificadores de acceso para la clase, atributos y métodos:
 *   
 *   public/package -> Es accesible/visible por todo el proyecto. 
 *   
 *   protected -> Sólo es accesible/visible por las clases que hereden de la clase padre o superior (Herencia).
 *   
 *   private -> Sólo es accesible/visible por la propia clase. No es visible al exterior.
 * 
 * */
public class Planta {
	
	//Atributos o propiedades.
	int codigo;
	String nombre;
	double precioBase;
	TipoPlanta tipo;
	int stock;
	
	//Constantes
	/*
	 * final -> No se puede modificar el valor.
	 * static -> Pertece al objeto y no a la clase.
	 * */
	private static final double TIPO_HIERBA_MATA = 0.2;
	private static final double TIPO_ARBUSTO = 0.6;
	private static final double TIPO_ARBOL = 1.30;
	
	
	/*Constructor -> No posee tipo de dato de retorno y se llama igua que la clase. Es el encargado de generar la 
	  instancia de la clase.
	  Tipos de constructores
	    Parametrizado -> Contiene parámetros.
	    Sin parámetros -> No recibe valores.
	*/ 
	
	public Planta() {
		this.codigo = 0;
		this.precioBase = 0 ;
		this.nombre = "";
		this.stock = 0;  	
	}
	
	public Planta (int codigo,String nom, double precio, TipoPlanta tp, int st) {
		//this -> Referencia u objeto de la clase base o en la que estamos trabajando.
		this.codigo = codigo;
		this.nombre = nom;
		this.precioBase = precio;
		this.tipo = tp;
		this.stock = st;
	}
	
	
	
	//Métodos
	public double obtenerPrecioFinal() {
		
		double precioFinal;
		
		switch(this.tipo) {
			  case HIERBA : precioFinal = this.precioBase * TIPO_HIERBA_MATA;
			                break; 
			  case ARBUSTO: precioFinal = this.precioBase * TIPO_ARBUSTO;
			                break; 
			  default:      precioFinal = this.precioBase * TIPO_ARBOL;
		}
		
		return precioFinal;
		
		
		/*if (this.tipo == HIERBA) {
			  precioFinal = this.precioBase * TIPO_HIERBA_MATA;
			}
		else if (this.tipo == ARBUSTO) {
			     precioFinal = this.precioBase * TIPO_ARBUSTO;
			}
		else {
			   precioFinal = this.precioBase * TIPO_ARBOL;
		}
		
		return precioFinal; 
		*/ 
	}


	@Override //Java notations -> @Override: Firma de compromiso para sobre escribir el método.
	public String toString() {
		return "Código = " + this.getCodigo() + " ,Nombre = " + this.getNombre()+ "," + " precioBase=" + this.precioBase + ", tipo=" + this.tipo +
			   ", Precio Final=" + this.obtenerPrecioFinal() + ", Stock = " + this.getStock();
				
	}

     /*Accesores de la clase - Son opcionales*/
	//Getters
	public int getCodigo() {
		return this.codigo;
	}
	
	public int getStock() {
		return this.stock;
	}
	
	public String getNombre() {
		return this.nombre;
	}

    //Setters
	public void setStock(int stock) {
		this.stock -= stock;// this.stock = this.stock - stock;
	}

	public void setNombre(String nuevoNombre) {
		 this.nombre = nuevoNombre;
	}
	
	
	

	
	
	
}