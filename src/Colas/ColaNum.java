package Colas;

public class ColaNum {
    private int max = 15;
    private int v[] = new int[max + 1];
    private int ini, fin;


    ColaNum() {
        ini = fin = 0;
    }

    public int getFin() {
        return fin;
    }


    boolean esvacia() {
        return ini == 0 && fin == 0;
    }

    boolean esllena() {
        return fin == max;
    }

    int nroelem() {
        return (fin - ini);
    }

    void adicionar(int elem) {
        if (!esllena()) {
            fin++;         //v[fin+1]=elem
            v[fin] = elem;  //fin=fin+1
        } else {
            System.out.println("Cola Simple llena");
        }
    }

    int eliminar() {
        int elem = 0;
        if (!esvacia()) {
            elem = v[ini];
            if (ini == fin) {
                ini = fin = 0;
            } else {
                ini++;
            }
        } else {
            System.out.println("Cola Simple vacia");
        }
        return elem;
    }

    void mostrarCola() {
        if (esvacia()) {
            System.out.println("Cola vacia");
        } else {
            System.out.println("\n--- Datos --- ");
            for (int i = ini+1; i <= fin; i++) {
                int elem = v[i];
                System.out.println(elem);
            }
        }
    }

    void llenarCola() {
        System.out.print("ingrese el numero de elementos a ingresar: ");
        int n = Leer.datoInt();
        for (int i = 0; i < n; i++) {
            System.out.print("ingrese un elemento: ");
            int e = Leer.datoInt();
            adicionar(e);
        }
    }

    void vaciar(ColaNum a) {
        while (!a.esvacia()) {
            adicionar(a.eliminar());
        }
    }


    public int obtenerFin() {
        return v[fin];
    }

    void ordenarColaAscendente() {
        for (int i = ini; i < fin; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= fin; j++) {
                if (v[j] < v[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = v[i];
            v[i] = v[minIndex];
            v[minIndex] = temp;
        }
    }
    public void moverImparesALaCima() {
        int countImpares = 0;
        for (int i = ini; i <= fin; i++) {
            if (v[i] % 2 != 0) {
                countImpares++;
            }
        }
        while (countImpares > 0) {
            if (v[ini] % 2 != 0) {
                ini++;
            } else {
                int temp = v[ini];
                for (int i = ini; i < fin; i++) {
                    v[i] = v[i + 1];
                }
                v[fin] = temp;
                countImpares--;
                fin--;
            }
        }
    }
    public void mostrarDosMenores() {
        int menor1 = Integer.MAX_VALUE;
        int menor2 = Integer.MAX_VALUE;

        for (int i = ini+1; i <= fin; i++) {
            int elem = v[i];
            if (elem < menor1) {
                menor2 = menor1;
                menor1 = elem;
            } else if (elem < menor2) {
                menor2 = elem;
            }
        }
        System.out.println("\nLos dos números menores son: " + menor1 + " y " + menor2);
    }

    public void rotarParesIzquierda() {
        int i = ini+1, countPares = 0;
        // Contar la cantidad de números pares
        for (int j = ini; j <= fin; j++) {
            if (v[j] % 2 == 0)
                countPares++;
        }
        while (countPares > 0) {
            if (v[i] % 2 != 0)
                i++;
            else {
                if (i == ini) {
                    ini++;
                    fin--;
                } else {
                    int temp = v[i];
                    for (int j = i; j > ini; j--)
                        v[j] = v[j - 1];
                    v[ini] = temp;
                    ini++;
                    fin--;
                }
                countPares--;
            }
        }
    }


}
