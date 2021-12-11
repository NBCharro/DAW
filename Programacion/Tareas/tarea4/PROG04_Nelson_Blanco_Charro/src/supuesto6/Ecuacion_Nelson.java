package supuesto6;
import supuesto6.ExcepcionDiscriminanteNegativo;
/**
 *
 * @author Nelson Blanco Charro
 * @description Supuesto 3 PROG 07. Programa que obtendra las raices de una ecuacion de segundo grado
 */
public class Ecuacion_Nelson {
    int a = 0;
    int b = 0;
    int c = 0;
    double raiz1,raiz2;
    public Ecuacion_Nelson() {
        /** Constructor que establece los atributos a 0 */
        System.out.println("Se han establecido los valores a 0");
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }
    public Ecuacion_Nelson(int a, int b, int c) {
        /** Constructor que guarda los atributos introducidos por el usuario */
        this.a=a;
        this.b=b;
        this.c=c;
        String signoB = b>0? "+": "" ;
        String signoC = c>0? "+": "" ;
        System.out.println("La ecuacion es: " + a + "x^2 " + signoB + b + "x " + signoC + c);
    }
    public void consultarAtributo(){
        /**  Metodo para consultar el valor de los atributos */
        System.out.println("El valor del atributo a es " + this.a + " el del b es " + this.b + " y el del c es " + this.c);
    }
    public void modificarAtributo(int a, int b, int c){
        /**  Metodo para modificar los valores de los atributos */
        this.a = a;
        this.b = b;
        this.c = c;
        String signoB = b>0? "+": "" ;
        String signoC = c>0? "+": "" ;
        System.out.println("La ecuacion modificada es: " + a + "x^2 " + signoB + b + "x " + signoC + c);
    }
    double comprobarDiscriminante (int a, int b, int c) throws ExcepcionDiscriminanteNegativo{
        /**  Metodo para comprobar que el discriminante no es negativo.
        Si es negativo lanzara un error y si no es negativo devolvera el valor del discriminante. */
        double discriminante = Math.pow(this.b, 2) - 4 * this.a * this.c;
        if (discriminante < 0) {
            throw new ExcepcionDiscriminanteNegativo("EL DISCRIMINANTE ES NEGATIVO: NO HAY SOLUCIONES REALES");
        }else{
            return discriminante;
        }
    }
    public double calcularX1(int a, int b, int c) throws ExcepcionDiscriminanteNegativo{
        /**  Metodo para la obtencion de la primera raiz  */
        double x1 = 0;
        try {
            double discriminante = comprobarDiscriminante(a, b, c);
            x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            System.out.println("La primera solución de la ecuación de segundo grado a=" + a + ", b=" + b + " c=" + c + " es " + x1);
        } catch (ExcepcionDiscriminanteNegativo e) {
            System.out.println(e.getMessage()); 
        }
        return x1;
    }
    public double calcularX2(int a, int b, int c) throws ExcepcionDiscriminanteNegativo{
        /**  Metodo para la obtencion de la segunda raiz */
        double x2 = 0;
        try {
            double discriminante = comprobarDiscriminante(a, b, c);
            x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("La primera solución de la ecuación de segundo grado a=" + a + ", b=" + b + " c=" + c + " es " + x2);
        } catch (ExcepcionDiscriminanteNegativo e) {
            System.out.println(e.getMessage()); 
        }
        return x2;
    }
}
