package com.ecolegas;

import java.util.Scanner;

/**
 *
 * @author Nelson Blanco Charro
 * @description: Programa en el que se introducira un codigo y una descripcion para trabajar con un articulo deportivo.
 */
public class LanzadorTienda {

    public static void main(String[] args) {
        // Inicio del programa
        // Codigo de ejemplo: 070500124973
        try {
            System.out.println("Bienvenido a la tienda de Ecolegas");
            String[] datosArticulo = obtenerDatosArticulo();
            ArticuloDeportivo articulo = new ArticuloDeportivo(datosArticulo[0], datosArticulo[1]);
            // ArticuloDeportivo articulo = new ArticuloDeportivo(); // Linea de codigo para crear un objeto por defecto
            interfaz(articulo);
            System.out.println("Muchas gracias por confiar en Ecolegas");
        } catch (ExcepcionTiendaDeportes e) {
            System.err.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("El valor introducido no es un numero valido");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private static void mostrarMenu() {
        // Metodo para mostrar el menu con las diferentes opciones
        System.out.println("1. Ver el codigo completo del articulo");
        System.out.println("2. Ver la descripcion del articulo");
        System.out.println("3. Ver el codigo de la ciudad");
        System.out.println("4. Ver el codigo de la tienda");
        System.out.println("5. Ver el codigo del articulo");
        System.out.println("6. Ver el digito de control");
        System.out.println("7. Aumentar unidades de este articulo");
        System.out.println("8. Decrementar unidades de este articulo");
        System.out.println("9. Consultar unidades del articulo");
        System.out.println("10. Salir");
        System.out.println("11. Cambiar codigo de la ciudad");
        System.out.println("12. Cambiar codigo de la tienda");
        System.out.println("13. Cambiar codigo del articulo");
        System.out.println("Introduzca una de las opciones");
    }

    private static String leerTeclado() {
        // Metodo para leer los datos introducidos por el usuario
        String lectura = "";
        try {
            Scanner teclado = new Scanner(System.in);
            lectura = teclado.nextLine();
        } catch (Exception e) {
            System.err.println("Error: No se ha podido leer el teclado");
        }
        return lectura;
    }

    private static int leerOpcion() {
        // Metodo para verificar que la opcion introducida por el usuario sea adecuada para el programa
        // El enunciado nos dice de 0 a 9, pero he agregado varias opciones mas, por eso llega hasta 13
        int opcion = 0;
        try {
            opcion = Integer.parseInt(leerTeclado());
            while (opcion <= 0 || opcion > 13) {
                System.err.println("Por favor, introduzca una opcion valida del menu");
                opcion = Integer.parseInt(leerTeclado());
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: No se ha introducido una opcion valida.");
        }
        return opcion;
    }

    private static String validarCodigoArticulo() {
        // Metodo para validar que el codigo introducido sea exactamente de 12 caracteres
        // He creado un bucle WHILE para que se pueda introducir un codigo correcto.
        System.out.println("Introduzca el codigo del articulo");
        String codigo = leerTeclado();
        int longitud = codigo.length();
        while (longitud != 12) {
            if (codigo.equals("s") || codigo.equals("S")) {
                codigo = "salir";
                break;
            }
            System.err.println("Error: El codigo del articulo deben ser 12 digitos. Por favor, introduzca un codigo valido.");
            codigo = leerTeclado();
            longitud = codigo.length();
        }
        return codigo;
    }

    private static String validarDescripcion(String salir) {
        // Metodo para validar que la descripcion sea mayor de 0 caracteres y menor de 40 caracteres
        // He creado un bucle WHILE para que se pueda introducir una descripcion correcta.
        String descripcion;
        if (salir.equals("salir")) {
            return "salir";
        }
        System.out.println("Introduzca la descripcion del articulo");
        descripcion = leerTeclado();
        int longitud = descripcion.length();
        while (longitud == 0 || longitud > 40) {
            if (descripcion.equals("s") || descripcion.equals("S")) {
                descripcion = "salir";
                break;
            }
            System.err.println("Error: La descripcion del articulo debe tener entre 0 y 40 caracteres. Por favor introduzca una descripcion valida.");
            descripcion = leerTeclado();
            longitud = descripcion.length();
        }
        return descripcion;
    }

    private static String[] obtenerDatosArticulo() throws ExcepcionTiendaDeportes {
        // Metodo para guardar los datos del codigo y la descripcion introducidos por el usuario.
        // He creado un sistema mediante bucles IF en el que si el usuario teclea "s" o "S" el programa se detenga
        String codigo = validarCodigoArticulo();
        String descripcion = validarDescripcion(codigo);
        if (descripcion.equals("salir")) {
            throw new ExcepcionTiendaDeportes("Ha elegido salir. Muchas gracias por confiar en Ecolegas");
        }
        String[] arr = {codigo, descripcion};
        return arr;
    }

    private static void interfaz(ArticuloDeportivo objeto) throws ExcepcionTiendaDeportes {
        // Metodo para mostrar y navegar entre los distintos menus.
        // He usado un bucle WHILE para que no se salga del programa a no ser que se elija(opcion 10) o genere algun error
        // Las opciones 11, 12 y 13 las he agregado yo para poder modificar los codigos de ciudad, tienda y codigo de articulo
        int opcion = 0;
        while (opcion != 10) {
            mostrarMenu();
            opcion = leerOpcion();
            if (opcion == 1) {
                objeto.verCodigoCompleto();
            }
            if (opcion == 2) {
                objeto.verDescripcion();
            }
            if (opcion == 3) {
                objeto.verCiudad();
            }
            if (opcion == 4) {
                objeto.verTienda();
            }
            if (opcion == 5) {
                objeto.verArticulo();
            }
            if (opcion == 6) {
                objeto.verDigitoControl();
            }
            if (opcion == 7) {
                System.out.println("Introduzca la cantidad que se aumentara");
                int aumentar = Integer.parseInt(leerTeclado());
                objeto.aumentarUnidades(aumentar);
            }
            if (opcion == 8) {
                System.out.println("Introduzca la cantidad que se decrementara");
                int decrementar = Integer.parseInt(leerTeclado());
                objeto.decrementarUnidades(decrementar);

            }
            if (opcion == 9) {
                objeto.verUnidades();
            }
            if (opcion == 10) {
                objeto.verTodo();
                System.out.println("");
                break;
            }
            if (opcion == 11) {
                System.out.println("Introduzca el nuevo codigo de ciudad");
                int modificar = Integer.parseInt(leerTeclado());
                objeto.modificarCiudad(modificar);
            }
            if (opcion == 12) {
                System.out.println("Introduzca el nuevo codigo de tienda");
                int modificar = Integer.parseInt(leerTeclado());
                objeto.modificarTienda(modificar);
            }
            if (opcion == 13) {
                System.out.println("Introduzca el nuevo codigo de articulo");
                int modificar = Integer.parseInt(leerTeclado());
                objeto.modificarArticulo(modificar);
            }
            System.out.println("");
        }

    }
}
