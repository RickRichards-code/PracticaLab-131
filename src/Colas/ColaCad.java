package Colas;

import Pilas.PilaCad;

public class ColaCad {
    private int max = 15;
    private String v[] = new String[max + 1];
    private int ini, fin;


    ColaCad() {
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

    void adicionar(String elem) {
        if (!esllena()) {
            fin++;         //v[fin+1]=elem
            v[fin] = elem;  //fin=fin+1
        } else {
            System.out.println("Cola Simple llena");
        }
    }

    String eliminar() {
        String elem = "";
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
            ColaCad aux = new ColaCad();
            while (!esvacia()) {
                String elem = eliminar();
                aux.adicionar(elem);
                System.out.println(elem);
            }
            vaciar(aux);
        }
    }

    void llenarCola() {
        System.out.print("ingrese el numero de elementos a ingresar: ");
        int n = Leer.datoInt();
        for (int i = 0; i < n; i++) {
            System.out.print("ingrese un elemento: ");
            String e = Leer.dato();
            adicionar(e);
        }
    }

    void vaciar(ColaCad a) {
        while (!a.esvacia()) {
            adicionar(a.eliminar());
        }
    }



    public String obtenerFin() {
        return v[fin];

    }


    void ordenarAlfabeticamente() {
        ColaCad colaAux = new ColaCad();

        while (!esvacia()) {
            String minElem = eliminar();
            int minPos = 0;

            ColaCad temp = new ColaCad();
            temp.adicionar(minElem);

            while (!esvacia()) {
                String elem = eliminar();
                temp.adicionar(elem);

                if (elem.compareTo(minElem) < 0) {
                    minElem = elem;
                    minPos = temp.nroelem();
                }
            }

            colaAux.adicionar(minElem);

            while (!temp.esvacia()) {
                String elem = temp.eliminar();
                if (temp.nroelem() != minPos) {
                    adicionar(elem);
                }
            }
        }
        vaciar(colaAux);
    }


    public int buscarCadenaX() {
        System.out.print("inngrese X: ");
        String X = Leer.dato();
        ColaCad aux = new ColaCad();
        int posicion = -1;
        int contador = 0;
        boolean encontrado = false;

        while (!esvacia()) {
            String elem = eliminar();
            aux.adicionar(elem);
            contador++;
            if (elem.equals(X)) {
                posicion = contador;
                encontrado = true;
                break;
            }
        }
        while (!aux.esvacia()) adicionar(aux.eliminar());
        return posicion;
    }

    int buscarX() {
        System.out.print("inngrese X: ");
        String X = Leer.dato();
        ColaCad aux = new ColaCad();
        int posicion = -1;
        int contador = 0;

        while (!esvacia()) {
            String elem = eliminar();
            aux.adicionar(elem);
            contador++;
            if (elem.equals(X)) {
                posicion = contador;
                break;
            }
        }
        while (!aux.esvacia()) adicionar(aux.eliminar());
        return posicion;
    }

    void eliminarCad() {
        System.out.println("ingrese la cadena a eliminar: ");
        String e = Leer.dato();
        ColaCad aux = new ColaCad();
        boolean sw = false;
        while (!esvacia()) {
            String elem = eliminar();
            if (!(elem.equals(e)))
                aux.adicionar(elem);
        }
        while (!aux.esvacia())
            adicionar(aux.eliminar());

    }

    void invertirCola(ColaCad cola) { // recursividad
        if (cola.esvacia()) {
            return;
        }
        String elemento = cola.eliminar();
        invertirCola(cola);
        cola.adicionar(elemento);
    }

    void cantidadCaracteres(){

        ColaCad aux = new ColaCad();
        while(!esvacia()){
            String elem = eliminar();
            int cantidad = elem.length();
            aux.adicionar(cantidad+"");
        }
        aux.mostrarCola();
        while(!aux.esvacia())
            adicionar(aux.eliminar());
    }



}
