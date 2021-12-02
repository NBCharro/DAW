
import java.util.Scanner;

/**
 *
 * @class PROG02_Ejer09
 * @description Ejercicio 9.
Diseña un programa Java que solicite un número de 5 dígitos del teclado, separe el número en sus dígitos individuales y los muestre por pantalla. Por ejemplo, si el número es 53123 que muestre:

5 3 1 2 3
 * @author Nelson Blanco Charro
 */
public class PROG02_Ejer09 {
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        String x;
        System.out.println("Introducir un numero de 5 cifras:");
        x = teclado.nextLine();
        // Se puede hacer de forma mas sencilla, pero utilizare el metodo aprendido en este tema:
        System.out.println(x.length() == 5 ? x.substring(0,1)+" "+x.substring(1,2)+" "+x.substring(2,3)+" "+x.substring(3,4)+" "+x.substring(4,5):"El numero introducido no tiene 5 cifras");
    }
}
