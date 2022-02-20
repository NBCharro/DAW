package programacuerposcelestes;

import modelo.CuerpoCeleste;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Nelson Blanco Charro
 * @descripcion:
 * - Programa para guardar y almacenar en el archivo 'sistemasolar.dat' los datos de cuerpos celestes del sistema solar.
 * - He decidido validar codigoCuerpo, nombre, tipoObjeto y diametro tal y como aparece en el enunciado
 * 
 * @mejoras: como mejoras en el futuro podria hacerse que no se repitan los codigos o los nombres de los cuerpos celestes
 */
public class Main {
    static BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));
    private static File fileSistemaSolar=new File("sistemasolar.dat");
    private static List<CuerpoCeleste> planetas=new ArrayList<>();
    
    public static void main(String[] args) {
        int opcion = 1;
        System.out.println("Bienvenid@ a la base de datos de Cuerpos Celestes del Sistema Solar");
        System.out.println("");
        do{
            if(opcion <1 || opcion >7)
                System.err.println("Por favor, introduzca un numero comprendido entre 1 y 7");
            try{
                System.out.println("");
                System.out.println("---- Menú principal ----");
                System.out.println("1 - Añadir cuerpo celeste");
                System.out.println("2 - Listar cuerpos celestes");
                System.out.println("3 - Buscar cuerpo celeste por código");
                System.out.println("4 - Buscar cuerpo celeste por tipo");
                System.out.println("5 - Borrar cuerpo celeste");
                System.out.println("6 - Borrar fichero de cuerpos celestes");
                System.out.println("7 - Salir de la aplicación");
                System.out.println("Seleccione una de las opciones:");
                opcion = Integer.parseInt(dato.readLine());
                switch(opcion){
                    case 1 -> agregarCuerpoCeleste();
                    case 2 -> listarCuerpoCeleste();
                    case 3 -> buscarPorCodigo();
                    case 4 -> buscarPorTipo();
                    case 5 -> eliminarCuerpoCeleste();
                    case 6 -> eliminarFicheroCompleto();
                    case 7 -> System.out.println("*** Gracias por utilizar nuestra aplicacion de cuerpos celestes ***");
                }
            }catch (NumberFormatException nfe){
                System.err.println("Sólo son válidos valores enteros entre 1 y 7");
            }catch(Exception ioe){
                System.err.println("Error de entrada de datos: " + ioe.getMessage());
            }
        }while(opcion != 7);
    }
    private static void agregarCuerpoCeleste() {
        String codigo, nombre, tipo, diametro = null;
        boolean noCOD, noNOM, noTIP, noDIA;
        abrirArchivo();
        try{
            // Control del codigo del cuerpo
            do{
                System.out.println("Introduzca el codigo del cuerpo celeste:");
                codigo = dato.readLine();
                noCOD = compruebaCodigoCuerpo(codigo);
                if(!noCOD)
                    System.err.println("El codigo del cuerpo celeste debe ser un numero de 3 digitos");
            }while(!noCOD);
            // Control del nombre
            do{
                System.out.println("Introduzca el nombre del cuerpo celeste:");
                nombre = dato.readLine();
                noNOM = compruebaNombre(nombre);
                if(!noNOM)
                    System.err.println("El nombre del cuerpo celeste debe ser de un minimo de 3 caracteres hasta un maximo de 15");
            }while(!noNOM);
            // Control del tipo de objeto
            do{
                System.out.println("Introduzca el tipo del cuerpo celeste('planeta' o 'planetaEnano' o 'luna'):");
                // Como mejora futura podria ser que funcionase igual: luna/Luna/LUNA/etc pero con toUpperCase podria haber problemas con planetaEnano
                tipo = dato.readLine();
                noTIP = compruebaTipo(tipo);
                if(!noTIP)
                    System.err.println("El tipo solo puede ser 'planeta', 'planetaEnano' o 'luna'");
            }while(!noTIP);
            // Control del diametro
            do{
                System.out.println("Introduzca el diametro en kilometros del cuerpo celeste:");
                diametro = dato.readLine();
                noDIA = compruebaDiametro(diametro);
                if(!noDIA)
                    System.err.println("El diametro debe ser inferior a 999.999 Km");
            }while(!noDIA);

            if(planetas.isEmpty()){
                planetas = new ArrayList<>();
                // planetas=new ArrayList<CuerpoCeleste>();
            }
            planetas.add(new CuerpoCeleste(codigo, nombre, tipo, diametro));
            escribirArchivo();
            System.out.println("Cuerpo celeste numero " + planetas.size() + " añadido");
        }catch (IOException | NumberFormatException ex){
            System.err.println(ex.getMessage());
        }
    }
    private static void listarCuerpoCeleste() {
        if(!fileSistemaSolar.exists()){
            System.err.println("No se han encontrado datos de cuerpos celestes");
        } else{
            abrirArchivo();
            if(planetas != null){
                planetas.forEach(cuerpo -> {
                    System.out.println(cuerpo.toString());
                });
            }else{
                System.out.println("No existen cuerpos celestes guardados.");
            }
        }
    }
    private static void buscarPorCodigo() {
        try{
            String res;
            boolean repetir, encontrado;
            do{
                repetir = false;
                System.out.println("Introduzca el codigo del cuerpo celeste que desea buscar");
                String ni = dato.readLine();
                abrirArchivo();
                encontrado = false;
                for(CuerpoCeleste cuerpo:planetas){
                    if(cuerpo.getCodigoCuerpo().equals(ni)){
                        encontrado = true;
                        System.out.println(cuerpo.toString());
                    }
                }
                if(!encontrado)
                    System.err.println("Cuerpo celeste no encontrado");
                System.out.println("Desea buscar otro registro (s/N)");
                do{
                    res = dato.readLine().toUpperCase();
                    if(!res.equals("N") && !res.equals("S"))
                        System.err.println("Sólo 'S' para buscar otro y 'N' para salir");
                    if(res.equals("S")){
                        repetir = true;
                    }
                }while(!res.equals("S") && !res.equals("N"));
            }while(repetir);
        } catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    private static void buscarPorTipo() {
        try{
            String res;
            boolean repetir, encontrado;
            do{
                repetir = false;
                System.out.println("Introduzca el tipo del cuerpo celeste que desea buscar");
                String ni = dato.readLine();
                abrirArchivo();
                encontrado=false;
                for(CuerpoCeleste cuerpo:planetas){
                    if(cuerpo.getTipoObjeto().equals(ni)){
                        encontrado = true;
                        System.out.println(cuerpo.toString());
                    }
                }
                if(!encontrado)
                    System.err.println("Cuerpo celeste no encontrado");
                System.out.println("Desea buscar otro cuerpo celeste (s/N)");
                do{
                    res=dato.readLine().toUpperCase();
                    if(!res.equals("N")&&!res.equals("S"))
                        System.err.println("Introduzca 'S' para buscar otro cuerpo celeste y 'N' para salir al menu principal");
                    if(res.equals("S")){
                        repetir = true;
                    }
                }while(!res.equals("S") && !res.equals("N"));
            }while(repetir);
        } catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    private static void eliminarCuerpoCeleste() {
        try{
            System.out.println("Introduzca el codigo del cuerpo celeste que desea buscar");
            String ni = dato.readLine();
            abrirArchivo();
            int i = 0;
            boolean encontrado = false;
            for(CuerpoCeleste cuerpo:planetas){
                if(cuerpo.getCodigoCuerpo().equals(ni)){
                    encontrado=true;
                    System.out.println(cuerpo.toString());
                    System.out.println("Está seguro que desea eliminarlo (s/N)");
                    String res;
                    do{
                        res=dato.readLine().toUpperCase();
                        if(!res.equals("N") && !res.equals("S"))
                            System.err.println("Introduzca 'S' para borrar el fichero y 'N' para no borrarlo");
                        if(res.equals("S")){
                            planetas.remove(i);
                            escribirArchivo();
                            System.out.printf("Cuerpo celeste eliminado");
                        }
                    }while(!res.equals("S") && !res.equals("N"));
                }
                i++;
            }
            if(!encontrado)
                System.err.println("Fichero no encontrado");
        } catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    private static void eliminarFicheroCompleto() {
        String res;
        boolean borrado = false;
        try{
            System.out.println("Está seguro que desea eliminar el fichero al completo (s/N)");
            do{
                res = dato.readLine().toUpperCase();
                if(!res.equals("N") && !res.equals("S"))
                    System.err.println("Introduzca 'S' para borrar el fichero y 'N' para no borrarlo");
                if(res.equals("S")){
                    borrado = fileSistemaSolar.delete();
                    if(borrado){
                        System.out.println("FICHERO ELIMINADO");
                        planetas.clear();
                    }else{
                        System.err.println("Ha ocurrido un error al borrar el archivo");
                    }
                }
            }while(!res.equals("S") && !res.equals("N"));
        }catch(FileNotFoundException fnf){
            System.err.println("Fichero no encontrado: " + fnf.getMessage());
        }catch(Exception ex){
            ex.getMessage();
        }
    }
    
    // Metodos sobre el archivo de datos
    private static void abrirArchivo(){
        try{
            if(!fileSistemaSolar.exists()){
                crearArchivo();
            }else{
                if(fileSistemaSolar.canRead()){
                    System.out.println("Fichero de cuerpos celestes encontrado");
                    FileInputStream fis = new FileInputStream(fileSistemaSolar);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    planetas = (ArrayList<CuerpoCeleste>)ois.readObject();
                    ois.close();
                    fis.close();
                }else{
                    System.err.println("Fichero de datos vacio");
                }
            }
        }catch(IOException | ClassNotFoundException ex){
            System.err.println("Error: " + ex.getMessage());
        }
    }
    private static void crearArchivo(){
        try{
            fileSistemaSolar.createNewFile();
            System.out.println("Fichero de cuerpos celestes creado");
        }catch(Exception ex){
            System.err.println("Error al crear el archivo: " + ex.getMessage());
        }
    }
    private static void escribirArchivo(){
        try{
            if(!fileSistemaSolar.exists()) fileSistemaSolar = new File("sistemasolar.dat");
            FileOutputStream fos = new FileOutputStream(fileSistemaSolar);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(planetas);
            oos.close();
            fos.close();
        }catch(Exception ex){
            System.err.println("Error al escribir en el archivo: " + ex.getMessage());
        }
    }
    
    // Comprobaciones
    private static boolean compruebaCodigoCuerpo(String codigo) {
        int cod = Integer.parseInt(codigo);
        boolean codigoVerificado = false;
        if(cod > 0 && cod <= 999) codigoVerificado = true;
        return codigoVerificado;
    }
    private static boolean compruebaNombre(String nombre) {
        boolean nombreVerificado = false;
        if(nombre.length() >= 3 && nombre.length() <= 15) nombreVerificado = true;
        return nombreVerificado;
    }
    private static boolean compruebaTipo(String tipo) {
        boolean tipoVerificado = false;
        if(tipo.equals("planeta")|| tipo.equals("planetaEnano") || tipo.equals("luna" )) tipoVerificado = true;
        return tipoVerificado;
    }
    private static boolean compruebaDiametro(String diametro) {
        int dia = Integer.parseInt(diametro);
        boolean diametroVerificado = false;
        if(dia <= 999999) diametroVerificado = true;
        return diametroVerificado;
    }
}