package interfaz;

import dominio.MenuPrincipal;
import dominio.Planta;
import dominio.TipoPlanta;
import dominio.Vivero;
import java.util.Scanner;

public class GestionDeVivero {
	
	private static Vivero vo = new Vivero(3); 
	private static Scanner teclado = new Scanner(System.in);
	

	public static void main(String[] args) {
		
		//Vivero vo = new Vivero(3);
		
		/*Planta pla = new Planta(1000,"Rosa",1500,TipoPlanta.ARBUSTO,50);
		Planta pla1 = new Planta(1001,"Níspero",1500,TipoPlanta.ARBOL,20);
		Planta pla2 = new Planta(1002,"Hiedra",1500,TipoPlanta.MATA,10);
		
		System.out.println(vo.agregarPlanta(pla));
		System.out.println(vo.agregarPlanta(pla1));
		System.out.println(vo.agregarPlanta(pla2));
		
		/*System.out.println(vo.venderPlanta(1001, 80));
		  System.out.println(vo.buscarPlantaPorCodigo(1001));
		*/
		
		/*Planta [] vec = vo.buscarPlantasQueContienen("o");
		mostrarVector(vec);
		
		System.out.println(vo);//Invocar al método toString() de Vivero*/
		
		int opcion;
		
		do {
			 mostrarMenu();
			 System.out.println("Ingrese su opción(1-7)");
			 opcion = teclado.nextInt(); 
	       }while(obtenerOpcionDeMenuPrincipal(opcion) != MenuPrincipal.SALIR);
				
		
}
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static void mostrarMenu() {

		System.out.println("Menú principal");
		System.out.println("1 - Agregar nueva planta");
		System.out.println("2 - Modificar el stock de una planta");
		System.out.println("3 - Buscar planta por código");
		System.out.println("4 - Buscar planta por nombre");
		System.out.println("5 - Vender planta");
		System.out.println("6 - Listado de plantas por tipo");
		System.out.println("7 - Salir");

	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static MenuPrincipal obtenerOpcionDeMenuPrincipal(int numeroIngresado) {
		
		MenuPrincipal menu = null;
		Planta pla = null;
				
		switch(numeroIngresado){
		       
		        case 1:pla = ingresarPlanta(); 
		        	   menu = MenuPrincipal.AGREGAR_PLANTA;
		               
		        	   if (vo.agregarPlanta(pla)) {
		        		   System.out.println("La planta se agregó correctamente.");
		        	   }
		        	   else {
		        		   System.out.println("No se pudo agregar La planta.");
		        	   }
		                   
		               break; 
		                      
		        
		
		}
		
		return menu;
		
		
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static void mostrarVector(Planta [] vecPlantas) {
		
		for(int i = 0 ;i < vecPlantas.length ;i++) {
			System.out.println(vecPlantas[i]);
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * Solicita el ingreso de los datos de una
	planta y devuelve una instancia de Planta. Considerar el uso del método
	ingresarTipoDePlanta(MENU_TIPO_DE_PLANTA).
	 */
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static Planta ingresarPlanta() {
		
		Planta nuevaPlanta; 
		int codigo = ingresarNumeroEntero("Ingrese Código:");
		String nombre = ingresarString("Ingrese el nombre de la planta:");
		TipoPlanta tipo = ingresarTipoDePlanta("Ingrese el tipo de planta (HIERBA,MATA,ARBUSTO,ARBOL):");
		double precio = ingresarDouble("Ingrese el precio base:");
		int stock = ingresarNumeroEntero("Ingrese stock:");
				
		nuevaPlanta = new Planta(codigo,nombre,precio,tipo,stock);
		
		return nuevaPlanta;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
private static int ingresarNumeroEntero(String mensaje){
	
	System.out.println(mensaje);
	
	return teclado.nextInt();
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
private static String ingresarString(String mensaje){

System.out.println(mensaje);

return teclado.next();
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
private static double ingresarDouble(String mensaje) {
	
	System.out.println(mensaje);

	return teclado.nextDouble();	
	
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
private static TipoPlanta ingresarTipoDePlanta(String mensaje) {
		
		System.out.println(mensaje);
		
		String planta = teclado.next();
		TipoPlanta tipo = TipoPlanta.valueOf(planta.toUpperCase());
		
		return tipo; 
	}

}