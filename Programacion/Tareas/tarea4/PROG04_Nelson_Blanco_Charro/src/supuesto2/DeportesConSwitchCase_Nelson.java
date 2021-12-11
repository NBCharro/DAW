package supuesto2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Nelson Blanco Charro
 * @description Supuesto 2 PROG 04. La clase leera por teclado una temperatura y dependiendo del valor devolvera un deporte u otro.
 * Se usara switch.
 * En el catch utilizo "InputMismatchException" y no "NumberFormatException" porque estoy utilizando Scanner.
 */

public class DeportesConSwitchCase_Nelson {
    public static void main() {
        try {
            int temperatura;
            String deporte = "";
            Scanner teclado = new Scanner(System.in);
            System.out.println("Introduzca la temperatura ambiente en la que practicara el deporte:");
            temperatura=teclado.nextInt();
            /** No se como hacer el caso de Switch con valores mayores o menores(case temperatura > 30:)
             * de ahi que seleccione caso a caso y no esten todas las temperaturas. */
            switch (temperatura){
                case 50: case 49: case 48: case 47: case 46: case 45: case 44: case 43: case 42: case 41: case 40: case 39: case 38: case 37: case 36: case 35: case 34: case 33: case 32:
                case 31:
                    deporte = "natacion";
                    break;
                case 30: case 29: case 28: case 27: case 26: case 25: case 24: case 23: case 22: case 21: case 20: case 19: case 18: case 17:
                case 16:
                    deporte = "golf";
                    break;
                case 15: case 14: case 13: case 12: case 11: case 10: case 9: case 8: case 7:
                case 6:
                    deporte = "tenis";
                    break;
                case 5: case 4: case 3: case 2: case 1: case 0: case -1: case -2: case -3: case -4: case -5: case -6: case -7: case -8:
                case -9:
                    deporte = "esqui";
                    break;
                default: deporte = "damas";
            }
            System.out.println("Switch. Para una temperatura de " + temperatura + " el deporte adecuado es " + deporte);
        }catch(InputMismatchException ex){
            System.out.println("Se han introducido caracteres no numéricos"); 

        }
    }   
}
