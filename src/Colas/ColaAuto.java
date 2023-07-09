package Colas;

public class ColaAuto {
    private int max = 15;
    private Auto v[] = new Auto[max + 1];
    private int ini, fin;


    ColaAuto() {
        ini = fin = 0;
    }

    public int getFin() {
        return fin;
    }
    // obtener dato fin


    boolean esvacia() {
        return ini == 0 && fin == 0;
    }

    boolean esllena() {
        return fin == max;
    }

    int nroelem() {
        return (fin - ini);
    }

    void adicionar(Auto elem) {
        if (!esllena()) {
            fin++;         //v[fin+1]=elem
            v[fin] = elem;  //fin=fin+1
        } else {
            System.out.println("Cola Simple llena");
        }
    }

    Auto eliminar() {
        Auto elem = new Auto();
        if (!esvacia()) {
            ini++;
            elem = v[ini];
            if (ini == fin) {
                ini = fin = 0;
            }
        } else {
            System.out.println("Cola Simple vacia");
        }
        return (elem);
    }

    void mostrarCola() {
        if (esvacia()) {
            System.out.println("Cola vacia");
        } else {
            System.out.println("\n--- Datos --- ");
            ColaAuto aux = new ColaAuto();
            while (!esvacia()) {
                Auto elem = eliminar();
                aux.adicionar(elem);
                elem.mostrar();
            }
            vaciar(aux);
        }
    }

    void llenarCola() {
        System.out.print("ingrese el numero de elementos a ingresar: ");
        int n = Leer.datoInt();
        for (int i = 0; i < n; i++) {
//            System.out.print("ingrese un elemento: ");
            Auto elem = new Auto();
            elem.leer();
            adicionar(elem);
        }
    }

    void vaciar(ColaAuto a) {
        while (!a.esvacia()) {
            adicionar(a.eliminar());
        }
    }

    public Auto obtenerFin() {
        return v[fin];
    }

    // listar los objetos con tipoAuto X
    void  listarTipoAuto(String tipoAuto) {
        ColaAuto aux = new ColaAuto();
        ColaAuto aux2 = new ColaAuto();
        while (!esvacia()) {
            Auto elem = eliminar();
            if (elem.getTipoAuto().equalsIgnoreCase(tipoAuto)) {
                aux.adicionar(elem);
            }
            aux2.adicionar(elem);
        }
        aux.mostrarCola();
        vaciar(aux2);
    }

    // ordenar alfabeticamente los objetos
    void ordenarAlfabeticamente() {
        int numElementos = nroelem();
        Auto[] arregloAutos = new Auto[numElementos];
        int indice = 0;

        while (!esvacia()) {
            Auto elem = eliminar();
            arregloAutos[indice] = elem;
            indice++;
        }

        for (int i = 0; i < numElementos - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < numElementos; j++) {
                if (arregloAutos[j].getTipoAuto().compareToIgnoreCase(arregloAutos[minPos].getTipoAuto()) < 0) {
                    minPos = j;
                }
            }
            Auto temp = arregloAutos[minPos];
            arregloAutos[minPos] = arregloAutos[i];
            arregloAutos[i] = temp;
        }

        for (int i = 0; i < numElementos; i++) {
            adicionar(arregloAutos[i]);
        }
    }


    void eliminarAutosMismoCodigo() {
        ColaAuto aux = new ColaAuto();

        while (!esvacia()) {
            Auto elem = eliminar();
            boolean repetido = false;

            ColaAuto temp = new ColaAuto();
            while (!esvacia()) {
                Auto tempElem = eliminar();
                if (tempElem.getCodigo().equals(elem.getCodigo())) {
                    repetido = true;
                }
                temp.adicionar(tempElem);
            }

            if (!repetido) {
                aux.adicionar(elem);
            }

            while (!temp.esvacia()) {
                adicionar(temp.eliminar());
            }
        }
        vaciar(aux);
    }
    double calcularPromedioMontoPago() {
        double suma = 0;
        int contador = 0;

        ColaAuto aux = new ColaAuto();
        while (!esvacia()) {
            Auto elem = eliminar();
            suma += elem.getMontoPago();
            contador++;
            aux.adicionar(elem);
        }

        vaciar(aux);

        double promedio = 0;
        if (contador > 0) {
            promedio = suma / contador;
        }

        return promedio;
    }


}
