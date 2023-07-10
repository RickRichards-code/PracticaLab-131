package Pilas;

public class PilaNum {

    private int max = 100;
    private int v[] = new int[max + 1];
    private int tope;

    PilaNum() {
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

    void adicionar(int elem) {
        if (!esllena()) {
            tope++;
            v[tope] = elem;
        } else {
            System.out.println("Pila llena");
        }
    }

    int eliminar() {
        int elem = 0;
        if (!esvacia()) {
            elem = v[tope];
            tope--;
        } else {
            System.out.println("Pila vacia");
        }
        return (elem);
    }

    void mostrarPila() {
        int elem;
        if (esvacia()) {
            System.out.println("Pila vacia");
        } else {
            System.out.println("\n Datos de la Pila ");
            var aux = new PilaNum();
            while (!esvacia()) {
                elem = eliminar();
                aux.adicionar(elem);
                System.out.println(elem + " ");
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
            System.out.print("ingrese el elemento: ");
            int elem = Leer.datoInt();
            adicionar(elem);
        }
    }

    void vaciar(PilaNum a) {
        while (!a.esvacia()) {
            adicionar(a.eliminar());
        }

    }

    void invertir() {
        PilaNum aux = new PilaNum();
        PilaNum aux2 = new PilaNum();
        while (!esvacia())
            aux.adicionar(eliminar());
        while (!aux.esvacia())
            aux2.adicionar(aux.eliminar());
        while (!aux2.esvacia())
            adicionar(aux2.eliminar());
    }

    int obtenerTope() {
        return v[tope];
    }

    double calcularPromedio() {
        int sum = 0;
        int count = 0;
        PilaNum aux = new PilaNum();

        while (!esvacia()) {
            int elem = eliminar();
            sum += elem;
            count++;
            aux.adicionar(elem);
        }
        while (!aux.esvacia()) {
            adicionar(aux.eliminar());
        }
        double promedio = (double) sum / count;
        return promedio;
    }

    double calcularVarianza() {
        double promedio = calcularPromedio();
        int count = 0;
        double sumSquaredDiff = 0;

        PilaNum aux = new PilaNum();
        while (!esvacia()) {
            int elem = eliminar();
            count++;
            sumSquaredDiff += Math.pow(elem - promedio, 2);
            aux.adicionar(elem);
        }

        while (!aux.esvacia())
            adicionar(aux.eliminar());

        if (count != 0)
            return sumSquaredDiff / count;
        else
            return 0.0;
    }

    double calcularDesviacionEstandar() {
        return Math.sqrt(calcularVarianza());
    }

    double calcularMedidaArmonica() {
        double sumaInversos = 0;
        int count = 0;

        PilaNum aux = new PilaNum();
        while (!esvacia()) {
            int elem = eliminar();
            count++;
            sumaInversos += 1.0 / elem;
            aux.adicionar(elem);
        }

        while (!aux.esvacia())
            adicionar(aux.eliminar());
        if (count != 0)
            return count / sumaInversos;
        else
            return 0.0;
    }

    double calcularMedidaGeometrica() {
        double producto = 1;
        int count = 0;

        PilaNum aux = new PilaNum();
        while (!esvacia()) {
            int elem = eliminar();
            count++;
            producto *= elem;
            aux.adicionar(elem);
        }

        while (!aux.esvacia())
            adicionar(aux.eliminar());
        if (count != 0)
            return Math.pow(producto, 1.0 / count);
        else
            return 0.0;
    }

    void ordenarAscendente() {
        PilaNum pilaAux = new PilaNum();

        while (!esvacia()) {
            int elem = eliminar();
            while (!pilaAux.esvacia() && pilaAux.obtenerTope() > elem) {
                adicionar(pilaAux.eliminar());
            }
            pilaAux.adicionar(elem);
        }

        while (!pilaAux.esvacia()) {
            adicionar(pilaAux.eliminar());
        }
        mostrarPila();
    }

    void ordenarDescendenteImpares() {
        PilaNum pilaAux = new PilaNum();
        PilaNum impares = new PilaNum();
        while (!esvacia()) {
            int elem = eliminar();
            if (elem % 2 == 0)
                pilaAux.adicionar(elem);
            else
                impares.adicionar(elem);
        }
        impares.ordenarAscendente();
        impares.invertir();
        while (!impares.esvacia() || !pilaAux.esvacia()) {
            if (!impares.esvacia())
                adicionar(impares.eliminar());
            if (!pilaAux.esvacia())
                adicionar(pilaAux.eliminar());
        }
        mostrarPila();
    }

    void ordenarParesInferiorImparesSuperior() {
        PilaNum pilaAux = new PilaNum();
        PilaNum pares = new PilaNum();
        PilaNum impares = new PilaNum();

        while (!esvacia()) {
            int elem = eliminar();
            if (elem % 2 == 0)
                pares.adicionar(elem);
            else
                impares.adicionar(elem);
        }
        pares.invertir();
        impares.invertir();
        while (!impares.esvacia())
            pilaAux.adicionar(impares.eliminar());
        while (!pares.esvacia())
            pilaAux.adicionar(pares.eliminar());
        while (!pilaAux.esvacia())
            adicionar(pilaAux.eliminar());
        mostrarPila();

    }


//    void ordenarImpares() {
//        PilaNum aux = new PilaNum();
//        PilaNum aux2 = new PilaNum();
//        while(!estaVacia()) {
//            int num=a.eliPila();
//            if(num%2!=0) {
//                aux.adicionar(num);
//            }else {
//                aux2.adicionar(num);
//            }
//        }
//        aux.invertir();
//        while(!aux2.esvacia()) {
//            a.adiPila(aux2.eliminar());
//        }
//        while(!aux.est()) {
//            a.adiPila(aux.eliPila());
//        }
//    }

}