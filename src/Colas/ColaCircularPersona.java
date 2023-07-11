package Colas;

public class ColaCircularPersona {
    private int max = 150;
    private Persona v[] = new Persona[max + 1];
    private int ini, fin;

    ColaCircularPersona() {
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

    void adicionar(Persona elem) {
        if (!esllena()) {
            fin = (fin + 1) % max;
            v[fin] = elem;
        } else {
            System.out.println("Cola circular llena");
        }
    }

    Persona eliminar() {
        Persona elem = new Persona();
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
            ColaCircularPersona aux = new ColaCircularPersona();
            while (!esvacia()) {
                Persona elem = eliminar();
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
            Persona elem = new Persona();
            elem.leer();
            adicionar(elem);
        }
    }

    void vaciar(ColaCircularPersona a) {
        while (!a.esvacia())
            adicionar(a.eliminar());
    }
}
