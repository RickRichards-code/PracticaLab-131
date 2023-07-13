package Listas;

public class ListaSimpleNum extends ListaNum {
    public ListaSimpleNum() {
        super();
    }

    boolean vacia() {
        return getP() == null;
    }

    void adicionarPrimero(int dato) {
        NodoNum nodo = new NodoNum();
        nodo.setDato(dato);
        if (vacia()) {
            setP(nodo);
        } else {
            nodo.setSig(getP());
            setP(nodo);
        }
    }

    NodoNum eliminarPrimero() {
        NodoNum q = new NodoNum();
        if (vacia()) {
            if (getP().getSig() == null) {
                q = getP();
                setP(null);
            } else {
                q = getP();
                setP(getP().getSig());
                q.setSig(null);
            }
        } else {
            System.out.println("--- la lista esta vacia ---");
        }
        return q;
    }

    void adcionarUltimo(int dato) {
        NodoNum nodo = new NodoNum();
        nodo.setDato(dato);
        if (vacia()) {
            setP(nodo);
        } else {
            NodoNum q = new NodoNum();
            q = getP();
            while (q.getSig() != null) {
                q = q.getSig();
            }
            q.setSig(nodo);
        }
    }

    NodoNum eliminarUltimo() {
        NodoNum q = new NodoNum();
        if (vacia()) {
            System.out.println("--- la lista esta vacia ---");
        } else {
            if (getP().getSig() == null) {
                q = getP();
                setP(null);
            } else {
                NodoNum r = new NodoNum();
                r = getP();
                while (r.getSig().getSig() != null) {
                    r = r.getSig();
                }
                q = r.getSig();
                r.setSig(null);
            }
        }
        return q;
    }

    void mostrarLista() {
        NodoNum q = getP();
        System.out.println("--- Datos de la lista ---");
        while (q != null) {
            System.out.print(q.getDato() + " -> ");
            q = q.getSig();
        }
        System.out.print("null");
        System.out.println("\n--- fin de la lista ---");
    }


    // ========================================================================
    void llenarTipoPila() {
        System.out.print("ingrese la cantidad de elementos a ingresar: ");
        int cantidad = Leer.datoInt();
        for (int i = 0; i < cantidad; i++) {
            System.out.print("ingrese un elemento: ");
            adicionarPrimero(Leer.datoInt());
        }
//        System.out.println("------------------------");
    }

    void llenarTipoCola() {
        System.out.print("ingrese la cantidad de elementos a ingresar: ");
        int cantidad = Leer.datoInt();
        for (int i = 0; i < cantidad; i++) {
            System.out.print("ingrese un elemento: ");
            adcionarUltimo(Leer.datoInt());
        }
//        System.out.println("------------------------");
    }

    int cantidadNumeros() {
        int cantidad = 0;
        NodoNum q = new NodoNum();
        q = getP();
        while (q != null) {
            cantidad++;
            q = q.getSig();
        }
        return cantidad;
    }

    void invertirLista() {
        ListaSimpleNum aux = new ListaSimpleNum();
        while (!vacia()) {
            aux.adicionarPrimero(eliminarPrimero().getDato());
        }
        while (!aux.vacia()) {
            adicionarPrimero(aux.eliminarPrimero().getDato());
        }
    }

    void rotarNumerosDerecha() {
        NodoNum q = new NodoNum();
        q = eliminarUltimo();
        adicionarPrimero(q.getDato());
    }

    void rotarNumerosIzquierda() {
        NodoNum q = new NodoNum();
        q = eliminarPrimero();
        adcionarUltimo(q.getDato());
    }

    void rotarKnodos(int k) {
        if (k > 0 && k < cantidadNumeros()) {
            ListaSimpleNum aux = new ListaSimpleNum();
            for (int i = 0; i < k; i++) {
                aux.adicionarPrimero(eliminarPrimero().getDato());
            }
            aux.rotarNumerosDerecha();
            for (int i = 0; i < k; i++) {
                adicionarPrimero(aux.eliminarPrimero().getDato());
            }
        }
    }

    // agregar x nodos despues del nodo de la posicion K
    void agregarNodosDespuesDe(int k) {
        NodoNum q = getP();
        NodoNum r = getP();

        int contador = 1;

        while (contador < k - 1 && q != null) {
            q = q.getSig(); // nodo antes de K
            contador++;
        }


        if (q != null) {
            NodoNum nodo = q;
            System.out.print("ingrese n: "); // numero nodos antes de K
            int n = Leer.datoInt();

            for (int i = 0; i < n; i++) {
                System.out.print("ingrese un elemento: ");
                int dato = Leer.datoInt(); // Lee el dato del nuevo nodo
                NodoNum nuevoNodo = new NodoNum();
                nuevoNodo.setDato(dato);
                nuevoNodo.setSig(nodo.getSig());
                nodo.setSig(nuevoNodo);
                nodo = nuevoNodo;
                q = q.getSig();
            }
            q = q.getSig();


            NodoNum nodo1 = q;
            System.out.print("ingrese m: "); // numero nodos despues  de K
            int m = Leer.datoInt();
            for (int i = 0; i < m; i++) {
                System.out.print("ingrese un elemento: ");
                int dato = Leer.datoInt(); // Lee el dato del nuevo nodo
                NodoNum nuevoNodo = new NodoNum();
                nuevoNodo.setDato(dato);
                nuevoNodo.setSig(nodo1.getSig());
                nodo1.setSig(nuevoNodo);
                nodo1 = nuevoNodo;
            }

        } else {
            System.out.println("La posición K no existe en la lista.");
        }
    }


}