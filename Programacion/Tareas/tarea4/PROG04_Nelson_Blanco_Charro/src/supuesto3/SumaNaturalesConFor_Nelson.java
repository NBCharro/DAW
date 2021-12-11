package supuesto3;

import java.util.Scanner;

/**
 * @author Nelson Blanco Charro
 * @description Supuesto 3 PROG 04.
 * Se sumaran los N primeros numeros mediante un bucle FOR con respecto al numero introducido por teclado.
 */

public class SumaNaturalesConFor_Nelson {
    public static void main() {
        int numero;
        int suma = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el numero para realizar la suma:");
        numero=teclado.nextInt();
        for (int i = 0; i < numero + 1; i++) {
            suma += i; 
            System.out.println("La suma parcial es de " + suma);
        }
        System.out.println("La suma total de los " + numero + " primeros numeros es de " + suma);
    }
}
