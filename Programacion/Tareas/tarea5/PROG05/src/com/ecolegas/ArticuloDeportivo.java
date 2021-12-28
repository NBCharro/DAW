package com.ecolegas;

/**
 *
 * @author Nelson Blanco Charro
 * @description: Los metodos estan separados en grupos con una funcion similar,
 * A su vez cada metodo tiene la descripcion de lo que hace.
 */
public class ArticuloDeportivo {
// Atributos propios del objeto, son todos privados para que solo se puedan modificar con los metodos elegidos.

    private String ciudad;
    private String tienda;
    private String articulo;
    private int digitoControl;
    private String codigoCompleto;
    private String descripcion;
    private int numeroUnidades = 0;
// Constructores

    public ArticuloDeportivo() {
        // Constructor con valores por defecto. Supongo que el valor por defecto es el del ejemplo del enunciado, pero podria ser cualquier otro.
        codigoScanner("130100009914");
        descripcionScanner("Bicicleta MTB Trek X-Caliber 9");
    }

    public ArticuloDeportivo(String codigo, String descripcion) {
        // Constructor que usamos cuando no queremos los valores por defecto.
        codigoScanner(codigo);
        descripcionScanner(descripcion);
    }

    public ArticuloDeportivo(ArticuloDeportivo articulo) {
        // Constructor copia
        this.ciudad = articulo.ciudad;
        this.tienda = articulo.tienda;
        this.articulo = articulo.articulo;;
        this.digitoControl = articulo.digitoControl;
        this.codigoCompleto = articulo.codigoCompleto;
        this.descripcion = articulo.descripcion;
        this.numeroUnidades = articulo.numeroUnidades;
    }
// Metodos para guardar los atributos inicialmente. Privados ya que no se necesita acceder desde fuera del objeto.

    private void codigoScanner(String numero) {
        // Metodo que separa y guarda los distintos atributos cuando usamos un codigo completo de 12 digitos.
        this.codigoCompleto = numero;
        String[] partes = numero.split("");
        this.ciudad = partes[0] + partes[1];
        this.tienda = partes[2] + partes[3];
        this.articulo = partes[4] + partes[5] + partes[6] + partes[7] + partes[8] + partes[9];
        calcularDigitoControl();
    }

    private void calcularDigitoControl() {
        // Metodo que calcula el digito de control
        this.digitoControl = (Integer.parseInt(this.ciudad) + Integer.parseInt(this.tienda) + Integer.parseInt(this.articulo)) % 99;
    }

    private void descripcionScanner(String frase) {
        // Metodo que guarda la descricpcion cuando no es por defecto.
        this.descripcion = frase;
    }
// Metodos para mostrar los atributos. Son todos metodos GET. Son publicos para acceder desde fuera y ver los atributos.

    public void verTodo() {
        // Metodo para ver todos los atributos a la vez.
        verCodigoCompleto();
        verCiudad();
        verTienda();
        verArticulo();
        verDigitoControl();
        verDescripcion();
        verUnidades();
    }

    public void verCodigoCompleto() {
        // Metodo para ver el codigo completo de 12 digitos
        System.out.println("El codigo completo es: " + this.codigoCompleto);
    }

    public void verDescripcion() {
        // Metodo para ver la descripcion
        System.out.println("La descripcion del articulo es: " + this.descripcion);
    }

    public void verCiudad() {
        // Metodo para ver el codigo de la ciudad
        System.out.println("El codigo de ciudad es: " + this.ciudad);
    }

    public void verTienda() {
        // Metodo para ver el codigo de la tienda
        System.out.println("El codigo de la tienda es: " + this.tienda);
    }

    public void verArticulo() {
        // Metodo para ver el codigo del articulo
        System.out.println("El codigo del articulo es: " + this.articulo);
    }

    public void verDigitoControl() {
        // Metodo para ver el codigo del digito de control
        System.out.println("El digido de control es: " + this.digitoControl);
    }

    public void verUnidades() {
        // Metodo para ver la cantidad de unidades
        System.out.println("El numero de unidades son: " + this.numeroUnidades);
    }
// Metodos para aumentar o decrementar las unidades. Son metodos SET. Publicos para modificar la cantidad de unidades.

    public void aumentarUnidades(int numero) throws ExcepcionTiendaDeportes {
        // Metodo para aumentar la cantidad de unidades del articulo
        if (numero < 0) {
            throw new ExcepcionTiendaDeportes("Los numeros negativos no estan permitidos");
        }
        this.numeroUnidades = this.numeroUnidades + numero;
    }

    public void decrementarUnidades(int numero) throws ExcepcionTiendaDeportes {
        // Metodo para decrementar la cantidad de unidades del articulo
        this.numeroUnidades = this.numeroUnidades - numero;
        if (this.numeroUnidades < 0) {
            System.out.println("Se ha introducido un valor mayor de la cantidad de unidades existentes, el numero de unidades se ha establecido en 0");
            this.numeroUnidades = 0;
        }
        /**
         * Personalmente yo prefiero esta logica, en la que se genera un error
         * al intentar decrementar una cantidad mayor de la que hay de dicho
         * articulo.
         *
         * int unidades = this.numeroUnidades - numero; if (unidades < 0) {
         * throw new ExcepcionTiendaDeportes("No se puede decrementar " + numero
         * + " unidades, ya que el numero de unidades que quedan son " +
         * this.numeroUnidades); } this.numeroUnidades = this.numeroUnidades -
         * numero;
         *
         */
    }
// Metodos para modificar los atributos. Son metodos SET. Publicos para modificar los atributos.

    public void modificarCiudad(int numero) throws ExcepcionTiendaDeportes {
        // Metodo para cambiar el codigo de ciudad del articulo. Supongo que hay 13 ciudades como maximo y 1 ciudad minima
        if (numero >= 1 && numero <= 13) {
            if (numero >= 1 && numero <= 9) {
                this.ciudad = "0" + numero;
            } else {
                this.ciudad = Integer.toString(numero);
            }
            calcularDigitoControl();
            modificarCodigoCompleto();
        } else {
            throw new ExcepcionTiendaDeportes("Codigo de ciudad no valido");
        }
    }

    ;
    public void modificarTienda(int numero) throws ExcepcionTiendaDeportes {
        // Metodo para cambiar el codigo de tienda del articulo. Supongo que hay 50 tiendas como maximo y 0 tiendas como minimo.
        // El minimo de 0 tiendas supongo que me refiero a que estan en almacen, sin estar en una tienda en concreto
        // Agrego 0 a la izquierda para que el codigo completo sea de 12 caracteres cuando lo guardo como un string
        if (numero >= 0 && numero <= 50) {
            if (numero >= 1 && numero <= 9) {
                this.tienda = "0" + numero;
            } else {
                this.tienda = Integer.toString(numero);
            }
            calcularDigitoControl();
            modificarCodigoCompleto();
        } else {
            throw new ExcepcionTiendaDeportes("Codigo de tienda no valido");
        }
    }

    ;
    public void modificarArticulo(int numero) throws ExcepcionTiendaDeportes {
        // Metodo para cambiar el codigo de articulo. Supongo que hay 999.999 como maximo y 0 como minimo.
        // Agrego 0 a la izquierda para que el codigo completo sea de 12 caracteres cuando lo guardo como un string
        if (numero >= 0 && numero <= 999999) {
            if (numero >= 1 && numero <= 9) {
                this.articulo = "0" + "0" + "0" + "0" + "0" + numero;
            } else if (numero >= 10 && numero <= 99) {
                this.articulo = "0" + "0" + "0" + "0" + numero;
            } else if (numero >= 100 && numero <= 999) {
                this.articulo = "0" + "0" + "0" + numero;
            } else if (numero >= 1000 && numero <= 9999) {
                this.articulo = "0" + "0" + numero;
            } else if (numero >= 10000 && numero <= 99999) {
                this.articulo = "0" + numero;
            } else {
                this.articulo = Integer.toString(numero);
            }
            calcularDigitoControl();
            modificarCodigoCompleto();
        } else {
            throw new ExcepcionTiendaDeportes("Codigo de articulo no valido");
        }
    }

    private void modificarCodigoCompleto() {
        // Metodo para modificar el codigo completo al realizar modificaciones en los atributos de ciudad, tienda o codigo del articulo.
        this.codigoCompleto = this.ciudad + this.tienda + this.articulo + this.digitoControl;
    }

;
}
