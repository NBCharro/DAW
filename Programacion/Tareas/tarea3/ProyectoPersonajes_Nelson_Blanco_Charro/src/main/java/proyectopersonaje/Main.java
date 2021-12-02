package proyectopersonaje;
// import java.util.Scanner;

/**
 *
 * @author Nelson Blanco Charro
 * @Detalles: la estructura deberia estar mejor pero he querido seguir el mismo orden que la tarea.
 * He ido mostrando por pantalla la solucion de cada actividad, y como en la actividad 7 es donde se debe mostrar esa informacion, he separado tambien por pantalla cada actividad.
 */
public class Main {    
    public static void main(String args[]) {
// Actividad 1. Creación de proyecto, paquete, clase y recoger datos por teclado.
        /*
        // Creamos la variable nombre que guardara el dato introducido
        String strNombre;
        // Creamos el objeto a partir de la clase Personaje
        Personaje p1 = new Personaje();
        // Generamos una variable que guardara el nombre introducido por el usuario
        Scanner teclado = new Scanner(System.in);
        // Mostramos por pantalla que debe introducir un nombre
        System.out.println("Nombre del personaje:");
        // Guardamos el nombre en la variable creada inicialmente
        strNombre=teclado.nextLine();
        // Utilizamos el metodo de la clase para cambiar, en este caso darle valor, el atributo nombre al objeto
        p1.cambiaNombre(strNombre);
        // Finalmente mostramos por pantalla el nombre introducido
        System.out.println("El nombre que ha introducido es:" + p1.consultaNombre());
        */
// Actividad 2.  Métodos de consulta y asignación de las propiedades.
        /*
        // Creamos las variables
        int strEdad;
        int strAltura;
        int strInteligencia;
        int strFuerza;
        /*
        // Preguntamos cada dato y la guardamos en cada variable
        System.out.println("Edad del personaje(años):");
        strEdad=Integer.parseInt(teclado.nextLine());
        p1.cambiaEdad(strEdad);
        System.out.println("Altura del personaje(cm):");
        strAltura=Integer.parseInt(teclado.nextLine());
        p1.cambiaAltura(strAltura);
        System.out.println("Inteligencia del personaje:");
        strInteligencia=Integer.parseInt(teclado.nextLine());
        p1.cambiaInteligencia(strInteligencia);
        System.out.println("Fuerza del personaje:");
        strFuerza=Integer.parseInt(teclado.nextLine());
        p1.cambiaFuerza(strFuerza);
        System.out.println(
                "Nombre: " + p1.consultaNombre() + 
                " - Edad: " + p1.consultaEdad() + 
                " - Altura: " + p1.consultaAltura() + 
                " - Inteligencia: " + p1.consultaInteligencia() + 
                " - Fuerza: " + p1.consultaFuerza());
        */
// Actividad 3.  Creación de constructor por defecto.
        System.out.println("Actividad 3");
        Personaje p1 = new Personaje();
        System.out.println(
                "Nombre: " + p1.consultaNombre() + 
                " - Edad: " + p1.consultaEdad() + 
                " - Altura: " + p1.consultaAltura() + 
                " - Inteligencia: " + p1.consultaInteligencia() + 
                " - Fuerza: " + p1.consultaFuerza());
// Actividad 4. Creación de constructor con parámetros.
        Personaje p2 = new Personaje("Frodo", 33, 126, 98, 38);
// Actividad 5. Creación del toString().
        System.out.println("Actividad 5");
        System.out.println(p2.toString());
// Actividad 7. Comprobación de la comprensión y funcionamiento del programa y uso de constantes y variables estáticas.
        System.out.println("Actividad 7");
        // A continuación, desde el main, crea otro objeto de tipo Personaje utilizando el primer constructor, para posteriormente mostrar el contenido de los atributos por pantalla, pero ahora utilizando el toString() creado.
        Personaje p3 = new Personaje();
        System.out.println(p3.toString());
        // Posteriormente tienes que crear 3 objetos utilizando el segundo constructor, con los siguientes datos.
        // Personaje1: nombre="Frodo"; edad=33; altura=126; inteligencia=98; fuerza=38;
        Personaje p4 = new Personaje("Frodo", 33, 126, 98, 38);
        System.out.println(p4.toString());
        // Personaje2: nombre="Aragorn"; edad=45; altura=185; inteligencia=88; fuerza=92;
        Personaje p5 = new Personaje("Aragorn", 45, 185, 88, 92);
        System.out.println(p5.toString());
        // Personaje3: nombre="Legolas"; edad=2931; altura=178; inteligencia=93; fuerza=84;
        Personaje p6 = new Personaje("Legolas", 2931, 178, 93, 84);
        System.out.println(p6.toString());
        // Ahora cambia varias de sus propiedades utilizando los métodos que creaste en el apartado 2.
        p4.cambiaAltura(250);
        p4.cambiaFuerza(5);
        p5.cambiaEdad(209);
        p5.cambiaNombre("Elessar");
        p6.cambiaInteligencia(90);
        p6.cambiaEdad(5000);
        // Vuelve a mostrar los datos de los personajes para comprobar que han cambiado. (con toString())
        System.out.println(p4.toString());
        System.out.println(p5.toString());
        System.out.println(p6.toString());
        // Crea un nuevo personaje inventado, y muestra sus datos. (con toString())
        Personaje p7 = new Personaje("Gandalf", 3019, 170, 91, 91);
        System.out.println(p7.toString());
        // Cambia sus datos y vuélvelo a mostrar. (con toString())
        p7.cambiaAltura(200);
        p7.cambiaEdad(10000);
        p7.cambiaInteligencia(100);
        p7.cambiaFuerza(100);
        System.out.println(p7.toString());
        // Muestra por pantalla la suma de fuerzas de dos objetos, usando el método sumarFuerzas de alguno de ellos ( y pasarás el otro objeto como parámetro)
        System.out.println("La suma de la fuerza de Gandalf y Frodo es: " + p7.sumarFuerza(p4.fuerza));
        // Antes de terminar, muestra el total de personajes que se llevan creados (mostrando el valor de la variable estática)
        System.out.println("El numero total de personajes creados es de " + p7.numeroPersonajes);
        // Antes de terminar, muestra el valor de la constante MAX_FUERZA.
        System.out.println("La fuerza maxima es " + p7.MAX_FUERZA);
    }
}
