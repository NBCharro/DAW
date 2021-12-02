
import java.util.Scanner;

/**
 *
 * @class PROG02_Ejer08
 * @description Ejercicio 8.
Diseña un programa Java que calcule la suma, resta, multiplicación y división de dos números introducidos por teclado. Incorpora también las funciones que permitan realizar la potencia de un número y la raíz cuadrada del otro. Salida del programa para x=9, y=3:

Introducir primer numero: 9
Introducir segundo numero: 3
x = 9.0 y = 3.0
x + y = 12.0
x - y = 6.0
x * y = 27.0
x / y = 3.0
x ^ 2 = 81.0
? x = 3.0
 * @author Nelson Blanco Charro
 */
public class PROG02_Ejer08 {
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introducir el valor de X: ");
        int x = teclado.nextInt();
        System.out.println("Introducir el valor de Y: ");
        int y = teclado.nextInt();
        System.out.println("El valor de X es " + x + " y el valor de Y es " + y);
        System.out.println("La suma es: " + (x+y));
        System.out.println("La resta es: " + (x-y));
        System.out.println("La multiplicacion es: " + (x*y));
        System.out.println("La division es: " + (x/y));
        System.out.println("La potencia cuadrada del valor de X es: " + Math.pow(x,2));
        System.out.println("La raiz cuadrada de X es: " + Math.sqrt(x));
    }
}
