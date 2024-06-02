package ar.edu.unlam.pb1.interfaces;

public class PruebaWrapper {
	
	
	
public static void main(String[] args) {
boolean valorBooleano = false;
byte numeroEnteroDe8Bits = (byte)225;
byte otroEjConWrapper = Byte.MAX_VALUE;
System.out.println("otro ej convinado "+ otroEjConWrapper);
char caracter ='\0';
short enteroCorto= 1024;
int numeroEntero= 1321321;
long numeroEnteroLargo =654654;
float nomeroReal = 4.3F;
double numero=3.142452452;


Boolean valorBooleanoWrapper = null;
Byte numeroEnteroDe8BitsWrapper = Byte.MIN_VALUE;
Byte numeroEnteroDe8BitsWrapper2 = Byte.MAX_VALUE;
System.out.println(numeroEnteroDe8BitsWrapper);
System.out.println(numeroEnteroDe8BitsWrapper2);

Character caracterWrapper =Character.MIN_VALUE;
System.out.println("minimo de caracteres"  + caracterWrapper);
Short enteroCortoWrapper= 1024;
Integer numeroEnteroWrapper= 1321321;
Long numeroEnteroLargoWrapper =654654L;
Float nomeroRealWrapper = 4.3F;
Double numeroWrapper=3.142452452;

String  numeroEnString = "1500";

numeroEnteroWrapper = Integer.parseInt(numeroEnString);
System.out.println("numero entero en wrapper :"+numeroEnteroWrapper);

}

}