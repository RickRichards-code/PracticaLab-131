package Pilas;

public class PilaProducto {

    private int max = 100;
    private Producto v[] = new Producto[max + 1];
    private int tope;

    PilaProducto() {
        tope = 0;
    }

    boolean esvacia() {
        if (tope == 0) {
            return (true);
        }
        return (false);
    }

    boolean esllena() {
        return tope == max;
    }

    int nroelem() {
        return (tope);
    }

    void adicionar(Producto elem) {
        if (!esllena()) {
            tope++;
            v[tope] = elem;
        } else {
            System.out.println("Pila llena");
        }
    }

    Producto eliminar() {
        Producto elem = new Producto();
        if (!esvacia()) {
            elem = v[tope];
            tope--;
        } else {
            System.out.println("Pila vacia");
        }
        return (elem);
    }

    void mostrarPila() {
        Producto elem = new Producto();
        if (esvacia()) {
            System.out.println("Pila vacia");
        } else {
            System.out.println("\n--- Datos de la Pila ---");
            PilaProducto aux = new PilaProducto();
            while (!esvacia()) {
                elem = eliminar();
                aux.adicionar(elem);
                elem.mostrar();
            }
            while (!aux.esvacia()) {
                elem = aux.eliminar();

                adicionar(elem);
            }
        }
    }

    void llenarPila() {
        System.out.print("ingrese el numero de elementos a ingresar: ");
        int n = Leer.datoInt();
        for (int i = 0; i < n; i++) {
            System.out.print("ingrese el Producto: ");
            Producto elem = new Producto();
            elem.leer();
            adicionar(elem);
        }
    }

    void vaciar(PilaProducto a) {
        while (!a.esvacia()) {
            adicionar(a.eliminar());
        }
    }

    void invertir() {
        PilaProducto aux = new PilaProducto();
        PilaProducto aux2 = new PilaProducto();
        while (!esvacia())
            aux.adicionar(eliminar());
        while (!aux.esvacia())
            aux2.adicionar(aux.eliminar());
        while (!aux2.esvacia())
            adicionar(aux2.eliminar());
    }
    // listar los productos con el mismo codigo
    void listarProductos() {
        PilaProducto aux = new PilaProducto();
        PilaProducto aux2 = new PilaProducto();
        while (!esvacia())
            aux.adicionar(eliminar());
        while (!aux.esvacia()) {
            Producto elem = aux.eliminar();
            if (elem.getCodigo() == elem.getCodigo()) {
                aux2.adicionar(elem);
            }
        }
        while (!aux2.esvacia())
            adicionar(aux2.eliminar());

    }
    // mostrar los 2 precios mas altos
    void mostrarPrecios() {
        PilaProducto aux = new PilaProducto();
        PilaProducto aux2 = new PilaProducto();
        while (!esvacia())
            aux.adicionar(eliminar());
        while (!aux.esvacia()) {
            Producto elem = aux.eliminar();
            if (elem.getPrecio() == elem.getPrecio()) {
                aux2.adicionar(elem);
            }
        }
        while (!aux2.esvacia())
            adicionar(aux2.eliminar());

    }
    // ordenar los productos alfabeticamente
    int compareTo(String cadena1, String cadena2) {
        return cadena1.compareTo(cadena2);
    }
    void ordenarAlfabeticamente() {
        PilaProducto pilaAux = new PilaProducto();

        while (!esvacia()) {
            Producto elem = eliminar();
            String e = elem.getNombre();
            while (!pilaAux.esvacia() && e.compareTo(pilaAux.obtenerTope()) < 0) {
                adicionar(pilaAux.eliminar());
            }
            pilaAux.adicionar(elem);
        }

        while (!pilaAux.esvacia()) {
            adicionar(pilaAux.eliminar());
        }
    }

    // eliminar los productos con el mismo nombre
    void eliminarProductos() {
        PilaProducto aux = new PilaProducto();
        PilaProducto aux2 = new PilaProducto();
        while (!esvacia())
            aux.adicionar(eliminar());
        while (!aux.esvacia()) {
            Producto elem = aux.eliminar();
            if (elem.getNombre() == elem.getNombre()) {
                aux2.adicionar(elem);
            }
        }
        while (!aux2.esvacia())
            adicionar(aux2.eliminar());

    }




    public int getTope() {
        return tope;
    }
    public String obtenerTope() {
        return v[tope].getNombre();
    }

    public void setTope(int tope) {
        this.tope = tope;
    }
}