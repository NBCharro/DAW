/**
 *
 * @class PROG02_Ejer06
 * @description Ejercicio 6. Diseña un programa Java que cree un tipo enumerado para los meses del año. El programa debe realizar las siguientes operaciones:
 * - Crear una variable m del tipo enumerado y asignarle el mes de marzo. Mostrar por pantalla su valor.
 * - Asignar a la variable m, la cadena de texto "MARZO". Mostrar por pantalla el valor de la variable de tipo enumerado tras realizar la asignación.
 * @author Nelson Blanco Charro
 */
public class PROG02_Ejer06 {
    public enum Meses{Enero, Febrero, Marzo, Abril, Mayo, Junio, Julio, Agosto, Septiembre, Octubre, Noviembre, Diciembre};
    public static void main(String args[]) {
	PROG02_Ejer06.Meses m = Meses.Marzo;
        System.out.println("El valor de la variable m es: " + m);        
    }
}


