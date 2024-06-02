package dominio;

import java.util.Arrays;
import java.util.Random;

/*
 * Array -> Arreglo, es un conjunto de variables que est�n agrupadas en forma continua en la memoria principal
 * y est�n referenciadas bajo el mismo nombre. Todas las variables tienen el mismo tipo de dato que el nombre.
 * El acceso a cada variable se realiza mediante un �ndice � posici�n. La primera posici�n es cero.
 * 
 * Tipos de Array:
 *   Unidimensionales -> Una dimensi�n, son los vectores.
 *   Bidimensionales o Multidimensionales -> Dos dimensiones, son las matrices.
 *   N-Dimensionales -> M�s de dos dimensiones.
 * 
 * */


public class Vivero {
	
	//Atributos.
	Planta [] listaPlantas;//Vector o Array unidimensional de Planta.
	String clave;
	
	private static int indice = 0;//�ndice del vector de plantas (S�lo para vender, buscar y m�s).
    private static int ultimaPosocupada;//Almacenar la �ltima posici�n ocupada en listPlantas
	private static double saldo = 0;//Importe total vendido por el vivero.
	
	//Constructor
	public Vivero(int cupoDeMacetas ) {
	 	this.listaPlantas = new Planta[cupoDeMacetas];
	 	this.clave = this.generarContrasenia();
	}
	
	  

//M�todos
   public boolean agregarPlanta (Planta pla) {
	   
	   //Buscar el c�digo de la nueva planta en el vector de plantas.
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
    	
    	//buscar el c�digo de planta.
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
    	     System.out.println("C�digo de planta inexistente.");
    	    }
    	
    	indice = ultimaPosocupada; //Asignar la �ltima posici�n anterior ocupada
    	
    	return resultado; 
    }
  
    public Planta[] buscarPlantasQueContienen(String texto){
    	
    	int j = 0;
    	//Nuevo vector de plantas
    	Planta [] vpla = new Planta [indice];
    	    	 
    	//System.out.println("Indice = "+ indice);
    	
    	//Recorrer el vector de plantas de clase Vivero.
    	for(int i = 0; i < indice ; i++) {
    		    //Consultar si el nombre de la planta contiene el texto enviado como par�metro.
    		    if (this.listaPlantas[i].getNombre().contains(texto)) {
    			    /*Copiar al nuevo vector de plantas, en la posici�n j lo que contiene el vector 
    			      de la clase Vivero en la posici�n i. */
    		    	vpla[j] = this.listaPlantas[i];
    		    	//M�todo trim() -> Quitar lo espacios del nombre de la planta.
    			    vpla[j].setNombre(this.listaPlantas[i].getNombre().trim());
    			    j++;
    		       } 
    		    
    	 }
    	 
    	//this.ordenarPlantasPorNombreAscendente(vpla);
    	
    	return vpla;
    	   	
    }
   

	/*
     * Nombre: obtenerCaracterAleatorio
     * Par�metros:
     *            posicionInicial -> Valor m�nimo aleatorio.
     *            posici�nFinal -> Valor m�ximo aletorio. 
     * 
     * Retorno: Un Caracter (C�digo Ascii del random). 
     * */
    private char obtenerCaracterAleatorio(int posicionInicial, int posicionFinal) {
    	
    	                       // Obtener un n�mero aleatorio entre posicioInicial y posicionFinal
    	
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
    		
    		//Consultar si el caracter es albaf�tico
    		if (Character.isAlphabetic(car)) {
    	    	//Consultar si el letra min�scula
    	    	if (Character.isLowerCase(car)) {
    	    		contLetrasMin++;
    	    	}
    	    	else{//Es letra may�scula
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
    	
       	//M�todo de burbujeo
    	for(int i = 0; i < plantas.length -1 ; i++) {//for 1
    		for(int j = 0; j < plantas.length -1  -i  ; j++) {//for 2
    			//Condici�n de ordenamiento
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
  
   
	
	
		
	


