package ar.edu.unlam.pb1.tools;

import java.util.Scanner;

//**********************************************
// TODO: No es necesario modificar esta clase.
// No es obligatorio usar esta clase.
//**********************************************

public class Keyboard {
	private static Scanner scanner = new Scanner(System.in);

	/*
	 * Con el constructor privado evitamos que instancien un objeto de la clase,
	 * solo se podra acceder a los metodos static, logrando un perfecto wrapper.
	 */
	private Keyboard() {

	}

	/**
	 * @author frodriguez
	 * @return Retorna un string leido desde el teclado
	 */
	public static String readString() {
		return scanner.nextLine();
	}

	/**
	 * @author frodriguez
	 * @return Retorna un string leido desde el teclado
	 * @param String msg Un mensaje que se imprime por consola
	 */
	public static String readString(String msg) {
		System.out.print(msg);
		return readString();
	}

	/**
	 * @author frodriguez
	 * @return Retorna un entero leido desde el teclado
	 * @param String msg Un mensaje que se imprime por consola
	 */
	public static int readInt(String msg) {
		int value = 0;
		boolean isValid = false;
		do {
			try {
				value = Integer.parseInt(readString(msg));
				isValid = true;
			} catch (Exception e) {
				System.out.println("El valor ingresado no es un numero.!");
			}
		} while (!isValid);
		return value;
	}

	/**
	 * @author frodriguez
	 * @return Retorna un entero leido desde el teclado
	 */
	public static int readInt() {
		return readInt("");
	}

	/**
	 * @author frodriguez
	 * @param String msg Un mensaje que se imprime por consola	  
	 * @return Retorna un float leido desde el teclado
	 */
	public static float readFloat(String msg) {
		float value = 0;
		boolean isValid = false;
		do {
			try {
				value = Float.parseFloat(readString(msg));
				isValid = true;
			} catch (Exception e) {
				System.out.println("El valor ingresado no es un numero.!");
			}
		} while (!isValid);
		return value;
	}

	/**
	 * @author frodriguez
	 * @return Retorna un float leido desde el teclado
	 */
	public static float readFloat() {
		return readFloat("");
	}
	
	/**
	 * @author frodriguez
	 * @param String msg Un mensaje que se imprime por consola	  
	 * @return Retorna un char leido desde el teclado
	 */
	public static char readChar(String msg) {
		char value = 0;
		boolean isValid = false;
		do {
			try {
				value = readString(msg).charAt(0);
				isValid = true;
			} catch (Exception e) {
				System.out.println("El valor ingresado no es un caracter.!");
			}
		} while (!isValid);
		return value;
	}

	/**
	 * @author frodriguez
	 * @return Retorna un char leido desde el teclado
	 */
	public static char readChar() {
		return readChar("");
	}

	public static void close() {
		scanner.close();
	}
}