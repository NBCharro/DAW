
package proyectopersonaje;

/**
 *
 * @author Nelson Blanco Charro
 * @Detalles: la estructura deberia estar mejor pero he querido seguir el mismo orden que la tarea. Los atributos deberian estar al principio, luego el constructor y por ultimo los metodos.
 * En la actividad 7 cuando se crea un personaje, no se si se refiere a aumentar la variable numeroPersonajes con el constructor o de forma manual en el Main, yo lo he hecho mediante los dos constructores.
 */
public class Personaje {
    // Constantes
    final int MAX_FUERZA=100;
    final int MAX_INTELIGENCIA=100;
    // Variable estatica que ira incrementando con la creacion de cada personaje
    static int numeroPersonajes;
    // Nombre, edad, altura, inteligencia y fuerza del personaje
    String nombre;
    int edad;
    int altura;
    int inteligencia;
    int fuerza;
    // Metodos
    String consultaNombre(){
        return this.nombre;
    }
    void cambiaNombre(String nombre){
        this.nombre=nombre;
    }
// Actividad 2.  Métodos de consulta y asignación de las propiedades.
    int consultaEdad(){
        return this.edad;
    }
    void cambiaEdad(int edad){
        this.edad=edad;
    }
    int consultaAltura(){
        return this.altura;
    }
    void cambiaAltura(int altura){
        this.altura=altura;
    }
    int consultaInteligencia(){
        return this.inteligencia;
    }
    void cambiaInteligencia(int inteligencia){
        this.inteligencia=inteligencia;
    }
    int consultaFuerza(){
        return this.fuerza;
    }
    void cambiaFuerza(int fuerza){
        this.fuerza=fuerza;
    }
// Actividad 3.  Creación de constructor por defecto.
    public Personaje(){
        this.nombre="Desconocido";
        this.edad=0;
        this.altura=0;
        this.inteligencia=0;
        this.fuerza=0;
        //  Cada vez que se crea un personaje incrementarás en uno el valor de la variable estática que creaste con la clase Personaje.
        this.numeroPersonajes++;
    }
// Actividad 4. Creación de constructor con parámetros.
    public Personaje(String nombre, int edad, int altura, int inteligencia, int fuerza){
        this.nombre=nombre;
        this.edad=edad;
        this.altura=altura;
        this.inteligencia=inteligencia;
        this.fuerza=fuerza;
        //  Cada vez que se crea un personaje incrementarás en uno el valor de la variable estática que creaste con la clase Personaje.
        this.numeroPersonajes++;
    }
// Actividad 5. Creación del toString().
    public String toString(){
        String valor;
        // Nombre: Frodo; Edad: 33 años; Altura: 126 cm; Inteligencia:98; Fuerza: 38
        return valor = "Nombre: " + this.nombre + "; Edad: " + this.edad + " años; Altura: " + this.altura + " cm; Inteligencia: " + this.inteligencia + "; Fuerza: " + this.fuerza;
    }
// Actividad 6. Creación del método sumarFuerza().
    public int sumarFuerza(int p){
        int suma = this.fuerza + p;
        return suma;
    }
}
