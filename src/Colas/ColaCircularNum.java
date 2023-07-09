package Colas;

public class ColaCircularNum {

    private int max = 150;
    private int v[] = new int[max + 1];
    private int ini, fin;

    ColaCircularNum() {
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

    void adicionar(int elem) {
        if (!esllena()) {
            fin = (fin + 1) % max;
            v[fin] = elem;
        } else {
            System.out.println("Cola circular llena");
        }
    }

    int eliminar() {
        int elem = 0;
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
            ColaCircularNum aux = new ColaCircularNum();
            while (!esvacia()) {
                int elem = eliminar();
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
            int elem = Leer.datoInt();
            adicionar(elem);
        }
    }

    void vaciar(ColaCircularNum a) {
        while (!a.esvacia())
            adicionar(a.eliminar());
    }



}
