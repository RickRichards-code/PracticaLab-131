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

    //    void mostrarCola() {
//        if (esvacia()) {
//            System.out.println("Cola vacia ");
//        } else {
//            System.out.println("\n--- Datos Cola Circular ---");
//            ColaCircularNum aux = new ColaCircularNum();
//            while (!esvacia()) {
//                int elem = eliminar();
//                aux.adicionar(elem);
//                System.out.println(elem);
//            }
//            vaciar(aux);
//        }
//    }
    void mostrarCola() {
        if (esvacia()) {
            System.out.println("Cola vacia ");
        } else {
            System.out.println("\n--- Datos Cola Circular ---");
            for (int i = ini + 1; i <= fin; i++) {
                System.out.println(v[i]);
            }
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


    // separar impares arriba y pares abajo
    void imparesArribaParesAbajo() {
        ColaCircularNum aux = new ColaCircularNum();
        ColaCircularNum aux2 = new ColaCircularNum();
        while (!esvacia()) {
            int e = eliminar();
            if (e % 2 == 0)
                aux.adicionar(e);
            else
                aux2.adicionar(e);
        }
        vaciar(aux2);
        vaciar(aux);
        mostrarCola();
    }


    boolean esUno() {
        ColaCircularNum aux = new ColaCircularNum();
        while (!esvacia()) {
            int e = eliminar();
            if (!(e == 1))
                return false;
            aux.adicionar(e);
        }
        vaciar(aux);
        return true;
    }


    void mayoreMenorPromedio() {
        ColaCircularNum aux = new ColaCircularNum();
        ColaCircularNum aux2 = new ColaCircularNum();
        ColaCircularNum aux3 = new ColaCircularNum();
        int sum = 0;
        int c = 0;

        while (!esvacia()) {
            int e = eliminar();
            sum = sum + e;
            c++;
            aux.adicionar(e);
        }
        vaciar(aux);

        if (c > 0) {
            double prom = (double) sum / c;
            System.out.println("promedio: " + prom);
            if (prom > 1) {
                while (!aux.esvacia()) {
                    int e = aux.eliminar();
                    if ((double) e > prom)
                        aux2.adicionar(e);
                    else if ((double) e < prom)
                        aux3.adicionar(e);
                    aux.adicionar(e);
                }
                vaciar(aux);
            }
        } else {
            System.out.println("La cola está vacía. No se puede calcular el promedio.");
        }

        System.out.println("--- cola mayores al promedio ---");
        aux2.mostrarCola();
        System.out.println("--- cola menores al promedio ---");
        aux3.mostrarCola();
    }
}


