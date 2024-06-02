package dominio;

import java.util.Arrays;
import java.util.Random;

/*
 * Array -> Arreglo, es un conjunto de variables que están agrupadas en forma continua en la memoria principal
 * y están referenciadas bajo el mismo nombre. Todas las variables tienen el mismo tipo de dato que el nombre.
 * El acceso a cada variable se realiza mediante un índice ó posición. La primera posición es cero.
 * 
 * Tipos de Array:
 *   Unidimensionales -> Una dimensión, son los vectores.
 *   Bidimensionales o Multidimensionales -> Dos dimensiones, son las matrices.
 *   N-Dimensionales -> Más de dos dimensiones.
 * 
 * */


public class Vivero {
	
	//Atributos.
	Planta [] listaPlantas;//Vector o Array unidimensional de Planta.
	String clave;
	
	private static int indice = 0;//Índice del vector de plantas (Sólo para vender, buscar y más).
    private static int ultimaPosocupada;//Almacenar la última posición ocupada en listPlantas
	private static double saldo = 0;//Importe total vendido por el vivero.
	
	//Constructor
	public Vivero(int cupoDeMacetas ) {
	 	this.listaPlantas = new Planta[cupoDeMacetas];
	 	this.clave = this.generarContrasenia();
	}
	
	  

//Métodos
   public boolean agregarPlanta (Planta pla) {
	   
	   //Buscar el código de la nueva planta en el vector de plantas.
	   if (this.buscarPlantaPorCodigo(pla.codigo) == null) {
		   
		   this.listaPlantas[indice] = pla;//Agregar la nueva planta.
		   if(indice + 1 <= this.listaPlantas.length ) {
			   indice++;
		   }
		   
		   return true;
	   }
	   else {
	         System.out.println("Codigo de planta existente !!!!");
		     return false;   
	        }
   }


    public Planta buscarPlantaPorCodigo(int codigo) {
	
	 int i = 0;
	 
	 //System.out.println("indice = " + indice);
	 
	 while (i < indice && this.listaPlantas[i].getCodigo() != codigo) {
		    i++;
	 }
	 
	 if (i == indice) {
		 return null;
	 }
	 else{
		  ultimaPosocupada = indice; //Guardar el indice anterior.
		  indice = i; 
		  return this.listaPlantas[i];
	     }
    }
	 
    
    public boolean venderPlanta(int codigo, int cantidadAVender) {
		    
		 return modificarStockDePlantaPorCodigo(codigo, cantidadAVender);
		 
 }

    public boolean modificarStockDePlantaPorCodigo(int codigo, int stock) {
    	
    	boolean resultado = false;
    	
    	//buscar el código de planta.
    	if (this.buscarPlantaPorCodigo(codigo) != null) {
    	   	 //Verificar si existe stock disponible para vender.
    		 if(this.listaPlantas[indice].getStock()  >= stock) {
    	 	     //actualizar el stock de la planta.
    			 this.listaPlantas[indice].setStock(stock);
    	 	     //actualizar el saldo del vivero.
    			 saldo += this.listaPlantas[indice].obtenerPrecioFinal() * stock; 
    			
    			 resultado = true;
    	 		}
    		 else {
    	   	       System.out.println("No hay stock suficiente");
    	  	      }
    	}
    	else
    	    {
    	     System.out.println("Código de planta inexistente.");
    	    }
    	
    	indice = ultimaPosocupada; //Asignar la última posición anterior ocupada
    	
    	return resultado; 
    }
  
    public Planta[] buscarPlantasQueContienen(String texto){
    	
    	int j = 0;
    	//Nuevo vector de plantas
    	Planta [] vpla = new Planta [indice];
    	    	 
    	//System.out.println("Indice = "+ indice);
    	
    	//Recorrer el vector de plantas de clase Vivero.
    	for(int i = 0; i < indice ; i++) {
    		    //Consultar si el nombre de la planta contiene el texto enviado como parámetro.
    		    if (this.listaPlantas[i].getNombre().contains(texto)) {
    			    /*Copiar al nuevo vector de plantas, en la posición j lo que contiene el vector 
    			      de la clase Vivero en la posición i. */
    		    	vpla[j] = this.listaPlantas[i];
    		    	//Método trim() -> Quitar lo espacios del nombre de la planta.
    			    vpla[j].setNombre(this.listaPlantas[i].getNombre().trim());
    			    j++;
    		       } 
    		    
    	 }
    	 
    	//this.ordenarPlantasPorNombreAscendente(vpla);
    	
    	return vpla;
    	   	
    }
   

	/*
     * Nombre: obtenerCaracterAleatorio
     * Parámetros:
     *            posicionInicial -> Valor mínimo aleatorio.
     *            posiciónFinal -> Valor máximo aletorio. 
     * 
     * Retorno: Un Caracter (Código Ascii del random). 
     * */
    private char obtenerCaracterAleatorio(int posicionInicial, int posicionFinal) {
    	
    	                       // Obtener un número aleatorio entre posicioInicial y posicionFinal
    	
    	int caracterAleatorio = (int) (posicionFinal * Math.random()) + posicionInicial;
    	char car=' ';
    	
    	Random random = new Random();
    	
    	switch(random.nextInt(3)){
    	      	case 0: car = (char)((char) caracterAleatorio + 'A');
    	      	        break;
    	      	case 1: car = (char)((char) caracterAleatorio + 'a');
      	        		break;       
    	      	case 2: car = (char)((char) caracterAleatorio + '0');
      	        		break; 
    	      }
    	
    	return car;
   }
    
    private String generarContrasenia() {
    	
    	int contNumeros = 0;//1
    	int contLetrasMin = 0;//2
    	int contLetrasMay = 0;//1
    	char car;
    	String clave ="";
    	
    	do {
    		car = this.obtenerCaracterAleatorio(1,10);
    		
    		//Consultar si el caracter es albafético
    		if (Character.isAlphabetic(car)) {
    	    	//Consultar si el letra minúscula
    	    	if (Character.isLowerCase(car)) {
    	    		contLetrasMin++;
    	    	}
    	    	else{//Es letra mayúscula
    	    		contLetrasMay++;
    	    	}
    	    	 
    	    }
    		
    		else { 
    			 contNumeros++;
    		}
    		
    		clave += car + "";
    	    
    	}while(contNumeros < 1 || contLetrasMin < 2 || contLetrasMay < 1 );
    	
    	//System.out.println(this.clave);
    	
        return clave;
    }
    
    
       
	private Planta[] ordenarPlantasPorNombreAscendente(Planta[] plantas) {
    	
    	Planta aux;
    	
       	//Método de burbujeo
    	for(int i = 0; i < plantas.length -1 ; i++) {//for 1
    		for(int j = 0; j < plantas.length -1  -i  ; j++) {//for 2
    			//Condición de ordenamiento
    			//System.out.println("plantas[j].getNombre()=" + plantas[j].getNombre());
    			if(plantas[j] != null && plantas[j+1] != null && 
    			   plantas[j].getNombre().compareToIgnoreCase(plantas[j+1].getNombre()) > 0) {
    			   //Intercambio
    			   aux = plantas[j];
    			   plantas[j] = plantas[j+1];
    			   plantas[j+1] = aux;
    			}
    		}//fin for 2 
    		
    	}//fin for 1
    	
    	
    	return plantas;
    	
    }
    
	//toString
	public String toString() {
		    
		   return "Vivero [listaPlantas=" + Arrays.toString(this.listaPlantas) + "]";
	 }
	
    //Getters
	public String getClave() {
		return clave;
	}
    
    
}
  
   
	
	
		
	


