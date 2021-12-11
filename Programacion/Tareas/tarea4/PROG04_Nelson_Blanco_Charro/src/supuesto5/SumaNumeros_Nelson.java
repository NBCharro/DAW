package supuesto5;

import java.util.Scanner;

/**
 * @author Nelson Blanco Charro
 * @description Supuesto 5 PROG 06.
 * Programa que sumara los numeros introducidos por teclado, finalizando con el numero -1.
 */

public class SumaNumeros_Nelson {
    public static void main() {
        int numero;
        int suma = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el primer numero para realizar la suma:");
        numero=teclado.nextInt();
        while (numero > 0 || numero <= 0) {
            suma += numero;
            System.out.println("Introduzca el siguiente numero para realizar la suma:");
            numero=teclado.nextInt();
            if (numero == -1) {
                break;
            }
        }
        System.out.println("La suma total de los numeros es de " + suma);
    }
}
