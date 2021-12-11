package prog04_nelson_blanco_charro;

import supuesto1.DeportesConIF_Nelson;
import supuesto2.DeportesConSwitchCase_Nelson;
import supuesto3.SumaNaturalesConFor_Nelson;
import supuesto4.SumaNaturalesConWhile_Nelson;
import supuesto5.SumaNumeros_Nelson;
import supuesto6.Ecuacion_Nelson;
import supuesto6.ExcepcionDiscriminanteNegativo;

/**
 *
 * @author Nelson Blanco Charro
 * @version 11.12.2021
 * @description Clase principal para la tarea 4 de programacion de DAW.
 */
public class PROG04_Nelson_Blanco_Charro {
    public static void main(String[] args) {
        int a = 3;
        int b = 2;
        int c = -5;
        
/** Supuesto 1  */
            System.out.println("------------ Supuesto 1");
            DeportesConIF_Nelson.main();
            System.out.println("");
/** Supuesto 2 */
            System.out.println("------------ Supuesto 2");
            DeportesConSwitchCase_Nelson.main();
            System.out.println("");
/** Supuesto 3 */
            System.out.println("------------ Supuesto 3");
            SumaNaturalesConFor_Nelson.main();
            System.out.println("");
/** Supuesto 4 */
            System.out.println("------------ Supuesto 4");
            SumaNaturalesConWhile_Nelson.main();
            System.out.println("");
/** Supuesto 5 */
            System.out.println("------------ Supuesto 5");
            SumaNumeros_Nelson.main();
            System.out.println("");
/** Supuesto 6 */
        try {
            System.out.println("------------ Supuesto 6");
            /** Creacion de objeto y muestra en terminal de sus raices */
            Ecuacion_Nelson ecuacion = new Ecuacion_Nelson(a, b, c);
            ecuacion.calcularX1(a, b, c);
            ecuacion.calcularX2(a, b, c);
            /** Creacion de un objeto vacio, cambio de sus valores y obtencion de sus raices */
            Ecuacion_Nelson ecuacion2 = new Ecuacion_Nelson();
            ecuacion2.consultarAtributo();
            ecuacion2.modificarAtributo(3, 2, 5);
            ecuacion2.calcularX1(a, b, c);
            ecuacion2.calcularX2(a, b, c);
        }catch (ExcepcionDiscriminanteNegativo e) {
            /** Captura del error del discriminante negativo */
            System.out.println(e.getMessage()); 
        } 
        catch (Exception e) {
            /** Captura del cualquier otro error */
            System.out.println(e);
        }
    }
    
}
