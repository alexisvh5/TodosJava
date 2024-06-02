package ar.edu.unlam.pb1.interfaces;

public class PruebaOrdenamiento {

	public static void main(String[] args) {
		final int TOPE = 5;
		int i= 0;
		int j= 0;
		int auxiliar= 0;
		
		int vector[]= {11,8,33,14,5};
		
		System.out.println("VEctor original");
		mostrarVector(vector);
		
		
		
		for ( i = 1; i < TOPE; i++) {// <=
			for ( j = 0; j < TOPE-1; j++) {
				
				if (vector[j]<vector[j+1]) {
					auxiliar = vector[j+1];
					vector[j+1]=vector[j];
					vector[j]=auxiliar;
				}
			}
		}
		
		System.out.println("\n vector ordenado en forma crenciente");
mostrarVector(vector);
	}

	private static void mostrarVector(int[] vector) {
		for (int k = 0; k < vector.length; k++) {
			System.out.println("\t"+ vector[k]);
		}
		
	}

}
