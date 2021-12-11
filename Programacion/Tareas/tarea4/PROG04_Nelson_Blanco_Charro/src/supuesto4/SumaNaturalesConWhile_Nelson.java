package supuesto4;

import java.util.Scanner;

/**
 * @author Nelson Blanco Charro
 * @description Supuesto 4 PROG 04.
 * Se sumaran los N primeros numeros mediante un bucle WHILE con respecto al numero introducido por teclado.
 */

public class SumaNaturalesConWhile_Nelson {
    public static void main() {
        int numero;
        int suma = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el numero para realizar la suma:");
        numero=teclado.nextInt();
        int i = 0;
        while (i < numero) {            
            i++;
            suma += i;
        }
        System.out.println("While. La suma total de los " + numero + " primeros numeros es de " + suma);
    }
}
