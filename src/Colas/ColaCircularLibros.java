package Colas;

public class ColaCircularLibros {
    private int max = 150;
    private Libro v[] = new Libro[max + 1];
    private int ini, fin;

    ColaCircularLibros() {
        ini = fin = 0;
    }

    int nroelem() {
        return ((max + fin - ini) % max);
    }

    boolean esvacia() {
        if (nroelem() == 0) {
            return (true);
        }
        return (false);
    }

    boolean esllena() {
        if (nroelem() == max - 1) {
            return (true);
        }
        return (false);
    }

    void adicionar(Libro elem) {
        if (!esllena()) {
            fin = (fin + 1) % max;
            v[fin] = elem;
        } else {
            System.out.println("Cola circular llena");
        }
    }

    Libro eliminar() {
        Libro elem = new Libro();
        if (!esvacia()) {
            ini = (ini + 1) % max;
            elem = v[ini];
            if (nroelem() == 0) {
                ini = fin = 0;
            }
        } else {
            System.out.println("Cola circular vacia");
        }
        return (elem);
    }

    void mostrarCola() {
        if (esvacia()) {
            System.out.println("Cola vacia ");
        } else {
            System.out.println("\n--- Datos Cola Circular ---");
            ColaCircularLibros aux = new ColaCircularLibros();
            while (!esvacia()) {
                Libro elem = eliminar();
                aux.adicionar(elem);
                elem.mostrar();
            }
            vaciar(aux);
        }
    }

    // llenar cola
    void llenarCola() {
        System.out.print("ingrese el numero de elementos a ingresar: ");
        int n = Leer.datoInt();
        for (int i = 1; i <= n; i++) {
            Libro elem = new Libro();
            elem.leer();
            adicionar(elem);
        }
    }

    void vaciar(ColaCircularLibros a) {
        while (!a.esvacia())
            adicionar(a.eliminar());
    }
}
