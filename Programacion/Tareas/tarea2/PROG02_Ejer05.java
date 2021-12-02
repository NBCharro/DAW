import java.util.Scanner;
/*
	@class PROG02_Ejer05
	@description Ejercicio 5. Diseña un programa Java que pida dos números por teclado, determine si el primero es múltiplo del segundo y muestre el resultado.
	@author Nelson Blanco Charro
 */

public class PROG02_Ejer05 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner (System.in);
		System.out.println("Introduzca un numero");
		int numero1 = entrada.nextInt();
		System.out.println("Introduzca otro numero");
		int numero2 = entrada.nextInt();
		int multiplo = numero2 % numero1;
		String mensajeMultiplo = "El numero " + numero1 + " SI es multiplo de " + numero2;
		String mensajeNoMultiplo = "El numero " + numero1 + " NO es multiplo de " + numero2;
		String mensaje = multiplo == 0? mensajeMultiplo : mensajeNoMultiplo;
		System.out.println(mensaje);
	};
}

