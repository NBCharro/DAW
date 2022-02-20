package modelo;

import java.io.Serializable;

/**
 *
 * @author Nelson Blanco Charro
 * @descripcion:
 * - Utilizo String y luego lo cambio a integer, lo lei en los apuntes pero no se si es correcto
 */

public class CuerpoCeleste implements Serializable{
    private String codigoCuerpo;
    private String nombre;
    private int diametro;
    private String tipoObjeto;
    
    public CuerpoCeleste(String codigoCuerpo, String nombre, String tipoObjeto, String diametro ){
        this.codigoCuerpo = codigoCuerpo;
        this.nombre = nombre;
        this.diametro = Integer.parseInt(diametro);
        this.tipoObjeto = tipoObjeto;
    }
    
    // Metodos GET y SET para introducir y consultar los datos del objeto celeste
    public String getCodigoCuerpo() {
        return codigoCuerpo;
    }
    public void setCodigoCuerpo(String codigoCuerpo) {
        this.codigoCuerpo = codigoCuerpo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDiametro() {
        return diametro;
    }
    public void setdiametro(int diametro) {
        this.diametro = diametro;
    }
    
    public String getTipoObjeto() {
        return tipoObjeto;
    }
    public void setTipoObjeto(String tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }
    
    // Metodo para obtener los datos de los planetas por pantalla
    public String toString(){
        return "Codigo del cuerpo celeste: " + getCodigoCuerpo() + " - Nombre: " + getNombre() + " - Tipo de objeto celeste: " + getTipoObjeto() + " - Diametro: " + getDiametro();
    }
}
