package Colas;

public class ColaCircularCad {
    private int max = 150;
    private String v[] = new String[max + 1];
    private int ini, fin;

    ColaCircularCad() {
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
        return nroelem() == max - 1;
    }

    void adicionar(String elem) {
        if (!esllena()) {
            fin = (fin + 1) % max;
            v[fin] = elem;
        } else {
            System.out.println("Cola circular llena");
        }
    }

    String eliminar() {
        String elem = "";
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
            ColaCircularCad aux = new ColaCircularCad();
            while (!esvacia()) {
                String elem = eliminar();
                aux.adicionar(elem);
                System.out.println(elem);
            }
            vaciar(aux);
        }
    }

    // llenar cola
    void llenarCola() {
        System.out.print("ingrese el numero de elementos a ingresar: ");
        int n = Leer.datoInt();
        for (int i = 1; i <= n; i++) {
            adicionar(Leer.dato());
        }
    }

    void vaciar(ColaCircularCad a) {
        while (!a.esvacia())
            adicionar(a.eliminar());
    }
}
