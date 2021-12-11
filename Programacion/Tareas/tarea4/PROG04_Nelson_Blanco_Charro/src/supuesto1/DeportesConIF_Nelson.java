package supuesto1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Nelson Blanco Charro
 * @description Supuesto 1 PROG 04.
 * La clase leera por teclado una temperatura y dependiendo del valor devolvera un deporte u otro.
 * Sin usar switch.
 * En el catch utilizo "InputMismatchException" y no "NumberFormatException" porque estoy utilizando Scanner
 */

public class DeportesConIF_Nelson {
    public static void main() {
        try {
            int temperatura;
            String deporte = "";
            Scanner teclado = new Scanner(System.in);
            System.out.println("Introduzca la temperatura ambiente en la que practicara el deporte:");
            temperatura=teclado.nextInt();
            if(temperatura > 30){
                deporte = "natacion";
            }
            else if (temperatura > 15 && temperatura <= 30){
                deporte = "golf";
            }  
            else if(temperatura > 5 && temperatura <= 15){
                deporte = "tenis";
            }
            else if(temperatura > -10 && temperatura <= 5){
                deporte = "esqui";
            }
            else{
                deporte = "damas";
            }
            System.out.println("Para una temperatura de " + temperatura + " el deporte adecuado es " + deporte);
        }catch(InputMismatchException ex){
            System.out.println("Se han introducido caracteres no numéricos"); 

        }
        catch(Exception e){
            System.out.println(e);
        }
    }   
}