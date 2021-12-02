/**
 * @class PROG02_Ejer10
 * @description Ejercicio 10.
 * Diseña un programa Java que realice las siguientes operaciones, en el orden que se muestran. Se indica la variable y el tipo de dato que recibe el valor o resultado de la operación indicada:
 * @author Nelson Blanco Charro
 */
public class PROG02_Ejer10 {
    public static void main(String args[]) {
        // No he entendido el enunciado de este ejercicio. De ahi que tenga una estructura tan caotica
        System.out.println("------- Conversiones entre enteros y coma flotante -------");
        float x=4.5f;
        float y=3.0f;
        int i=2;
        int j=i * (int)x;
        double dx=2.0;
        double dz=dx * y;
        System.out.println("Producto de int por float: j= i*x = " + j);
        System.out.println("Producto de float por double: dz=dx * y = "+dz);
        System.out.println("------- Operaciones con byte -------");
        byte bx=5;
        byte by=2;
        int bzint = (byte)bx - (byte)by;
        byte bz = (byte) bzint;
        System.out.println("byte: 5 - 2 = "+bz);
        bx=(byte)-128;
        by=(byte)1;
        //int bzint2=bx – by;
        //bz =(byte) bzint2;
        System.out.println("byte -128 - 1 = "+bz);
        System.out.println("(int)(-128 - 1) = "+bz);
        System.out.println("------- Operaciones con short -------");
        short sx=5;
        short sy=2;
        int szint=sx - sy;
        short sz = (short)szint;
        System.out.println("short: 5 + 2 = "+sz);
        sx=(short)32767;
        sy=(short)1;
        int szint2=sx + sy;
        sz = (short) szint2;
        float cxfloat=0F;
        System.out.println("short 32767 + 1 = "+sz);
        System.out.println("------- Operaciones con char -------");
        char cx = (char)cxfloat;
        char cy=10;
        //double z=cx – cy;
        //int z=cx – 1;
        //char cx=\uFFFF;
        int z=cx;
        sx=(short)cx;
        sx=(short)-32768;
        cx=(char)sx;
        z=(int)sx;
        sx=(short)-1;
        cx=(char)sx;
        z=(int)cx;
    }
}
