package Recursividad;

public class Main {
    // maximo comun divisor de dos numeros de manera recursiva
    static int mcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return mcd(b, a % b);
    }

    // minimo comun multiplo de dos numeros de manera recursiva
    static int mcm(int a, int b) {
        return a * b / mcd(a, b);
    }

    // sumar elementos de un vector de dimension n de manera recursiva
    static int sumaVector(int[] v, int n) {
        if (n == 0) {
            return 0;
        }
        return v[n - 1] + sumaVector(v, n - 1);
    }
    // hallar el valor minimo de un vector v de  dimension n de manera recursiva
    static int minimoVector(int[] v, int n) {
        if (n == 1) {
            return v[0];
        }
        return Math.min(v[n - 1], minimoVector(v, n - 1));
    }
    // busqueda binaria de un elemento en un vector de dimension n de manera recursiva
    static int busquedaBinaria(int[] v, int n, int e) {
        if (n == 0) {
            return -1;
        }
        int m = n / 2;
        if (v[m] == e) {
            return m;
        }
        if (v[m] > e) {
            return busquedaBinaria(v, m, e);
        }
        return busquedaBinaria(v, n - m, e);
    }


    // ordenamiento de un vector por el metodo quicksort de manera recursiva
    static void quicksort(int[] v, int izq, int der) {
        if (izq < der) {
            int p = particion(v, izq, der);
            quicksort(v, izq, p - 1);
            quicksort(v, p + 1, der);
        }
    }
    static int particion(int[] v, int izq, int der) {
        int pivote = v[der];
        int i = izq - 1;
        for (int j = izq; j < der; j++) {
            if (v[j] <= pivote) {
                i++;
                int aux = v[i];
                v[i] = v[j];
                v[j] = aux;
            }
        }
        int aux = v[i + 1];
        v[i + 1] = v[der];
        v[der] = aux;
        return i + 1;
    }

    // funcion Stirling de manera recursiva
    static int stirling(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        }
        return stirling(n - 1, k - 1) + k * stirling(n - 1, k);
    }
    // funcion ackerman de manera recursiva
    static int ackerman(int m, int n) {
        if (m == 0) {
            return n + 1;
        }
        if (n == 0) {
            return ackerman(m - 1, 1);
        }
        return ackerman(m - 1, ackerman(m, n - 1));
    }


    // funcion torres de hanoi de manera recursiva
    static void hanoi(int n, char origen, char auxiliar, char destino) {
        if (n == 1) {
            System.out.println("Mueve disco de " + origen + " a " + destino);
        } else {
            hanoi(n - 1, origen, destino, auxiliar);
            System.out.println("Mueve disco de " + origen + " a " + destino);
            hanoi(n - 1, auxiliar, origen, destino);
        }
    }
    public static void main(String[] args) {

    }
}
